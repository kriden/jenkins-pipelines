pipeline {
  agent any

  tools {
    maven 'Maven3.2.1'
    jdk 'JDK1.8'
  }

  environment {
    DOCKER_TLS_VERIFY="1"
    DOCKER_HOST="tcp://192.168.99.100:2376"
    DOCKER_MACHINE_NAME="default"
  }

  stages {

    stage('Build') {
      steps {
          sh 'mvn install'
      }
    }

    stage('Quality Gate') {
      steps {
        parallel(
          "Sonar": {
              sh 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent -Dmaven.test.failure.ignore=false'
              withSonarQubeEnv('SonarQubeServer') {
                sh 'mvn sonar:sonar'
              }

              withSonarQubeEnv('SonarQubeServer') {
                    timeout(time: 1, unit: 'HOURS') {
                          script {
                            def qg = waitForQualityGate()
                            if (qg.status != 'OK') {
                              error "Pipeline aborted due to quality gate failure: ${qg.status}"
                            }
                          }
                        }
              }
          },
          "Security": {
              sh 'mvn org.owasp:dependency-check-maven:2.1.0:check'
          }
        )
      }
    }

    stage('Deploy') {
        steps {
           sh 'mvn docker:build'
           print "Deploy docker image"
        }
    }

  }
}