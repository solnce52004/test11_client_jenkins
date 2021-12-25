pipeline {

    environment {
        registry = "solnce52004/test11_client_jenkins"
        registryCredential = 'dockerhub'
        containerName = 'container_client_app'
    }

    agent any

    stages {
        stage('Build') {
             steps {
                    sh "./gradlew build"
                }
        }
        stage('docker-compose build') {
             steps {
                 sh "docker-compose build"
             }
        }
        stage('docker-compose up') {
             steps {
                 sh "docker-compose up -d"
             }
        }
    }
}
