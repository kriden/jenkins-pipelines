pipeline {
  agent any

  tools {
    maven 'Maven3.2.1'
    jdk 'JDK1.8'
  }

  stages {
    stage('Debug') {
        steps {
            sh 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false'
            withSonarQubeEnv('SonarQubeServer') {
                sh 'mvn sonar:sonar'
            }

            withSonarQubeEnv('SonarQubeServer') {
                sh "../../../sonar-scanner-3.0.3.778/bin/sonar-scanner"
                waitForQualityGate()
            }
        }
    }

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
              withSonarQubeEnv('SonarQubeScanner') {
                sh 'mvn sonar:sonar'

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