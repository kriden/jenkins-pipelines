pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        parallel(
          "Build": {
            withMaven(maven: 'Maven3.2.1', jdk: 'JDK1.8') {
              sh 'mvn clean install'
            }
            
            
          },
          "CodeQuality": {
            sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false'
            sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.99.100:9000'
            waitForQualityGate()
            
          }
        )
      }
    }
  }
}