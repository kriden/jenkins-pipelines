pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withMaven(maven: 'Maven3.2.1', jdk: 'JDK8.1') {
          sh 'mvn clean install'
        }
        
      }
    }
  }
}