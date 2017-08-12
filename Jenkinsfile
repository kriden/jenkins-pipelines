pipeline {
  agent any

  tools {
    maven 'Maven3.2.1'
    jdk 'JDK1.8'
  }

  stages {
    stage('Build') {
      steps {
          sh 'mvn clean install'
      }
    }
    stage('CodeQuality') {
      steps {
        parallel(
          "CodeQuality": {
              sh 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false'
              withSonarQubeEnv('SonarQubeServer') {
                sh 'mvn sonar:sonar'
              }

              withSonarQubeEnv('SonarQubeServer') {
               timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
                  def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
                  if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                  }
                }
              }
          },
          "DependencyCheck": {
              sh 'mvn org.owasp:dependency-check-maven:2.1.0:check'
          }
        )
      }
    }
  }
}