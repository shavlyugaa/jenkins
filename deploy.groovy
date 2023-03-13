pipeline {
    agent any
    environment {
        AWS_ACCESS_KEY_ID     = credentials('access-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('secret-access-key-id')
    }
    stages {
        stage('Example stage 1') {
            steps {
                echo $AWS_ACCESS_KEY_ID
            }
        }
    }
}