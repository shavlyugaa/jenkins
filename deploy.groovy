pipeline {
    agent any
    environment {
        AWS_ACCESS_KEY_ID     = credentials('access-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('secret-access-key-id')
    }
    stages {
        stage('Example stage 1') {
            steps {
                withCredentials([string(credentialsId: 'access-key-id', variable: 'access_key_id')]) {
				  echo $access_key_id
		       }
            }
        }
    }
}