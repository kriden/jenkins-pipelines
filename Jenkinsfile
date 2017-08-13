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
              waitForQualityGate()
          },
          "DependencyCheck": {
              sh 'mvn org.owasp:dependency-check-maven:2.1.0:check'
          }
        )
      }
    }
  }
}