pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withMaven(maven: 'Maven3.2.1', jdk: 'JDK1.8') {
          sh 'mvn clean install'
        }
        
      }
    }
    stage('CodeQuality') {
      steps {
        withMaven(jdk: 'JDK1.8', maven: 'Maven3.2.1') {
          sh 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false'
        }
        withSonarQubeEnv('SonarQube') {
          sh 'mvn sonar:sonar'
        }

      }
    }
  }
}