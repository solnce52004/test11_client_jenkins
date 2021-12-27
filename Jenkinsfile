pipeline {

    environment {
        registry = "solnce52004/test11_client_jenkins"
        registryCredential = 'dockerhub'
        containerName = 'test11_client_jenkins-service'
        registryDb = "mysql"
        containerNameDb = 'mysql-service'
    }

    agent any

    stages {
        stage('Docker rmi') {
            steps {
                 sh String.format(
                     '''
                        docker stop %s \
                       || true && docker rm %s && docker rmi -f $(docker images | grep %s | awk '{print $3}') \
                       || true
                     ''',
                     containerNameDb,
                     containerNameDb,
                     registryDb
                 )

                 sh String.format(
                     '''
                        docker stop %s \
                       || true && docker rm %s && docker rmi -f $(docker images | grep %s | awk '{print $3}') \
                       || true
                     ''',
                     containerName,
                     containerName,
                     registry
                 )
            }
        }
        stage('gradlew build') {
             steps {
                    sh "./gradlew build"
                }
        }
        stage('build') {
             steps {
                    sh "docker build -t solnce52004/test11_client_jenkins:latest ."
                }
        }
        stage('Docker push') {
            steps {
                script{
                  docker.withRegistry('https://docker.io', registryCredential) {
                       myApp = docker.build(registry + ":latest", ".")
                       myApp.push("latest")
//                        myApp.push("${env.BUILD_ID}")
                   }
                }
            }
        }
        stage('docker-compose build') {
             steps {
                 sh "docker network create -d bridge test11 || true \
                 && docker-compose build --no-cache \
                 && docker-compose up -d --build"
             }
        }
    }
}
