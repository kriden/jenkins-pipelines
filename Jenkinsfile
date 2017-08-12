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
        parallel(
          "CodeQuality": {
            withMaven(jdk: 'JDK1.8', maven: 'Maven3.2.1') {
              sh 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false'
              sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.99.100:9000'
            }
            
            
          },
          "DependencyCheck": {
            withMaven(jdk: 'JDK1.5', maven: 'Maven3.2.1') {
              sh 'mvn org.owasp:dependency-check-maven:2.1.0:check'
            }
            
            
          }
        )
      }
    }
  }
}