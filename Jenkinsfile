pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    environment {
        IMAGE_NAME = "dineshreddy5/demo-image:v1"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/DineshReddy-515/Devops_company_intranet_portal.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Docker Login & Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKER_USERNAME',
                    passwordVariable: 'DOCKER_PASSWORD'
                )]) {

                    bat '''
                    echo %DOCKER_PASSWORD% | docker login -u %DOCKER_USERNAME% --password-stdin
                    docker push %IMAGE_NAME%
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f k8s/'
                bat 'kubectl rollout restart deployment company-intranet-deployment'
            }
        }

        stage('Verify Deployment') {
            steps {
                bat 'kubectl get deployments'
                bat 'kubectl get pods'
                bat 'kubectl get svc'
            }
        }
    }

    post {
        success {
            echo '==================================='
            echo ' Deployment Successful!'
            echo ' Docker Image Pushed!'
            echo ' Kubernetes Updated!'
            echo '==================================='
        }

        failure {
            echo '==================================='
            echo ' Deployment Failed!'
            echo 'Check Console Output.'
            echo '==================================='
        }

        always {
            bat 'docker logout'
        }
    }
}