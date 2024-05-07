pipeline {
    agent any
    tools {
        jdk 'jdk17'
        maven 'maven'
    }

    stages {
        stage('Git checkout') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/Azim12121212/jenkins-springboot.git'
            }
        }
        stage('Sonar Analysis') {
            steps {
                bat "mvn clean package"
                bat ''' mvn sonar:sonar -Dsonar.url-http://localhost:9000
                -Dsonar.login=squ_a71fb78002da2a1eb227ae7785cf6a1eb1c13321
                -Dsonar.projectName=jenkins-springboot \
                -Dsonar.java.binaries=. \
                -Dsonar.projectKey=jenkins-springboot '''
            }
        }
    }
}