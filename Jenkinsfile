// Kaushalya_Rajapaksha - s223681886
// 6.2HD - SIT753
pipeline {
    agent any



    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: 'main']],
                          userRemoteConfigs: [[url: 'https://github.com/KaushiRajapakshe/CodeQuality']]])
                sh "echo 'Checkout stage completed'"
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                    sh "echo 'Build stage completed'"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                    sh "echo 'Test stage completed'"
                }
            }
        }

        stage('Code Quality Analysis') {
            steps {
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=CodeQuality -Dsonar.projectName='CodeQuality' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_ad6d93f32bb3f3be7946596c11457e1f936333d8"
                sh "echo 'Code Quality Analysis stage completed'"
            }
        }
        stage('Deploy') {
            steps {
                sh "java -jar CodeQuality-1.0-SNAPSHOT.jar"
                sh "echo 'Deploy stage completed'"
            }
        }

    }

    post {
        failure {
            script {
                emailext(
                    subject: "Jenkins Pipeline Failed: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                    body: "Something went wrong in the Jenkins pipeline. Please check the console output for more details: ${env.BUILD_URL}",
                    to: "kaushi.rajapakshe1@gmail.com",
                    attachLog: true,
                )
            }
        }
    }
}