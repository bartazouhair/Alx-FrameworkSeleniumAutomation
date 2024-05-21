pipeline {
    agent any

    tools {
        maven 'Maven_3.6.3' // Adjust this to your Maven installation name
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    mvnHome = tool 'Maven_3.6.3'
                    env.PATH = "${mvnHome}/bin:${env.PATH}"
                }
                sh 'mvn clean test'
            }
        }
        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site',
                    reportFiles: 'index.html',
                    reportName: 'HTML Report'
                ])
            }
        }
    }
}