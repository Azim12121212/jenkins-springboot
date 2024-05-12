pipeline {
    agent any

    tools {
		maven "maven"
	}

    stages {
        stage('Stage 1 - Checkout Source Code') {
			steps {
			    // Get the source code form GitHub
                git 'https://github.com/Azim12121212/jenkins-springboot'
			}
		}
        stage('Stage 2 - Build App') {
			steps {
				// Build the Maven App
                bat "mvn clean package"
			}
		}
        stage('Stage 3 - Run Tests') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Stage 4 - SonarQube Analysis') {
            steps {
                withSonarQubeEnv(installationName: 'Sonarqube', credentialsId: 'sonar-token') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage("Stage 5 - SonarQube Quality Gate") {
            steps {
                // something wrong with "waitForQualityGate"
                echo 'Quality Gate stage'
            }
        }
        stage('Stage 6 - Deploy to Tomcat') {
            steps {
                bat 'mvn clean install'
                bat 'dir /s /b *.war'
                deploy adapters: [tomcat9(credentialsId: 'tomcat_username_password', path: '', url: 'http://localhost:9999')],
                contextPath: null, war: '**/*.war'
            }
        }
    }
}