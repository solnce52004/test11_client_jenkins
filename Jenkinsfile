pipeline {

    environment {
        registry = "solnce52004/test11_client_jenkins"
        registryCredential = 'dockerhub'
        containerName = 'container'
    }

    agent any

    stages {
        stage('Build') {
             steps {
                    sh "./gradlew build"
                }
        }
        stage("Checkout code") {
              steps {
                 checkout scm
              }
        }

        stage('docker-compose build') {
             steps {
                 sh "docker-compose build"
             }
        }
        stage('docker-compose up') {
             steps {
                 sh "docker-compose up -d --abort-on-container-exit"
             }
        }

//         stage('Docker build') {
//             steps {
//                 script{
//                   myapp = dockerCompose.build(registry + ":${env.BUILD_ID}", ".")
//                 }
//             }
//         }
//         stage('Docker run') {
//              steps {
//                  sh 'docker stop ' + containerName + ' || true && docker rm ' + containerName + ' || true'
//
//                  script{
//                      myapp.run('--rm -p 5443:4443 --name=' + containerName)
//                  }
//              }
//         }
//         stage('Docker push') {
//             steps {
//                 script{
//                   docker.withRegistry('https://registry.hub.docker.com', registryCredential) {
//                        docker.push(registry + ":${env.BUILD_ID}")
//                    }
//
//                 }
//             }
//         }
    }

//     post {
//           always {
//              sh "docker-compose down || true"
//           }
//     }
}
