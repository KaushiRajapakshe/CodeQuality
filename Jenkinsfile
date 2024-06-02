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
            }
        }
        
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                    
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Code Quality Analysis') {
            steps {
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=CodeQuality -Dsonar.projectName='CodeQuality' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_ad6d93f32bb3f3be7946596c11457e1f936333d8"
            }
        }

    }

    post {
        always {
            script {
                emailext(
                    subject: "Jenkins Pipeline Status: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                    body: "Check the status in the Jenkins pipeline. Please check the console output for more details: ${env.BUILD_URL}",
                    to: "kaushi.rajapakshe1@gmail.com",
                    attachLog: true, 
                )
            }
        }
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
