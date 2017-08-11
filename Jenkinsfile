pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool(name: 'JDK1.8', type: 'jdk')
        tool(name: 'Maven3.2.1', type: 'maven')
        sh 'mvn clean install'
      }
    }
  }
}