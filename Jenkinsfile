pipeline {
    agent any

    tools {
		maven "maven"
	}

    stages {
        stage('Stage 1 - Build App') {
			steps {
				// Build the Maven App
                bat "mvn clean package"
			}
		}
        stage('Stage 2 - Run Tests') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Stage 3 - SonarQube Analysis') {
            steps {
                withSonarQubeEnv(installationName: 'Sonarqube', credentialsId: 'sonar-token') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage("Stage 4 - SonarQube Quality Gate") {
            steps {
                // something wrong with "waitForQualityGate"
                echo 'Quality Gate stage'
            }
        }
        stage('Stage 5 - Deploy to Tomcat') {
            steps {
                bat 'mvn clean install'
                bat 'dir /s /b *.war'
                deploy adapters: [tomcat10(credentialsId: 'tomcat_username_password', path: '', url: 'http://localhost:8080')],
                contextPath: null, war: '**/*.war'
            }
        }
    }
}