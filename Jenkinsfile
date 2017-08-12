pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withMaven(maven: 'Maven3.2.1', jdk: 'JDK1.8') {
          sh 'mvn clean install'
        }
        
        junit '**/surefire-reports/TEST*.xml'
      }
    }
  }
}