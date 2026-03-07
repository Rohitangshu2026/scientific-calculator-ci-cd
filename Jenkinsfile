pipeline {

    agent any

    environment {

        GITHUB_REPO = "https://github.com/Rohitangshu2026/scientific-calculator-ci-cd.git"
        DOCKER_IMAGE = "scientific-calculator"
        DOCKER_HUB_USERNAME = "rohitangshu"

    }

    stages {

        stage('Checkout Source Code') {
            steps {
                git branch: 'main',
                    url: "${GITHUB_REPO}"
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Verify Build Artifact') {
            steps {
                sh 'ls -lh target/'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push Docker Image to DockerHub') {

            steps {

                withCredentials([usernamePassword(
                        credentialsId: 'DockerHubCred',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin

                    docker tag scientific-calculator $DOCKER_USER/scientific-calculator:latest

                    docker push $DOCKER_USER/scientific-calculator:latest
                    '''
                }
            }
        }

        stage('Deploy Using Ansible') {
            steps {
                sh 'ansible-playbook -i inventory deploy.yml'
            }
        }

    }

    post {

        success {
            mail to: 'rbose2002@gmail.com',
            subject: "SUCCESS: Scientific Calculator CI/CD Pipeline - Build #${env.BUILD_NUMBER}",
            body: """
                Build completed successfully.

                Project: Scientific Calculator CI/CD
                Build Number: ${env.BUILD_NUMBER}
                Status: SUCCESS

                View build details:
                ${env.BUILD_URL}
                """
        }

        failure {
            mail to: 'rbose2002@gmail.com',
            subject: "FAILURE: Scientific Calculator CI/CD Pipeline - Build #${env.BUILD_NUMBER}",
            body: """
                Build FAILED.

                Project: Scientific Calculator CI/CD
                Build Number: ${env.BUILD_NUMBER}
                Status: FAILURE

                Check console output for error:
                ${env.BUILD_URL}console

                Test Report:
                ${env.BUILD_URL}testReport
                """
        }

        always {
            cleanWs()
        }
    }
}