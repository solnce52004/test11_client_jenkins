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
        stage('Build') {
             steps {
                    sh "./gradlew build"
                }
        }
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
        stage("Checkout code") {
             steps {
                  checkout scm
             }
        }
        stage('Docker build app') {
             steps {
                  script{
                       myApp =  docker.build(registry + ":latest", ".")
                  }
             }
        }
//         stage('Docker push') {
//             steps {
//                 script{
//                   docker.withRegistry('https://registry.hub.docker.com', registryCredential) {
//                        myApp.push("${env.BUILD_ID}")
//                        myApp.push("latest")
//                    }
//                 }
//             }
//         }

        stage('set network') {
             steps {
                 sh "docker network create -d bridge test11 || true"
             }
        }
        stage('docker-compose build') {
             steps {
                 sh "docker-compose build --no-cache"
             }
        }

        stage('docker-compose up mysql-service') {
             steps {
                 sh "docker-compose up -d --build --force-recreate mysql-service"
             }
        }
        stage('docker-compose up app') {
             steps {
                 sh "docker-compose up -d --force-recreate --build test11_client_jenkins"
             }
        }
    }
}
