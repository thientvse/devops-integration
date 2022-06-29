pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven_3_8_6"
    }

    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/thientvse/devops-integration.git']]])
                sh 'mvn clean install'
            }
        }
        stage("Build docker image"){
            steps {
                script {
                    sh 'docker build -t thientvse/devops-integration .'
                }
            }
        }
        stage("Push image to hub"){
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        // some block
                        sh 'docker login -u thientvse -p ${dockerhubpwd}'
                    }

                    sh 'docker push thientvse/devops-integration'
                }
            }
        }
        stage("Run image with docker-compose"){
            steps {
                script {
                    sh 'docker-compose up -d'
                }
            }
        }
    }

}