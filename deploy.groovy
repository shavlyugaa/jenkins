pipeline {
    agent { label 'serverless' }
	stages {
    stage('Deploy to stage') {
	   environment {
         STAGE_AWS_ACCESS_KEY_ID     = credentials('stage-aws-key-id')
         STAGE_AWS_SECRET_ACCESS_KEY = credentials('stage-aws-secret-access-key')
       }	   
	   steps {	
	     step([
                    $class: 'CopyArtifact',
                    filter: '**/*.jar, **/serverless.yml',
                    fingerprintArtifacts: true,
                    optional: true,
                    projectName: '/Microservices/Stage/build'
                ])
         sh 'serverless config credentials \
		   --provider aws \
		   --key $STAGE_AWS_ACCESS_KEY_ID \
		   --secret $STAGE_AWS_SECRET_ACCESS_KEY'
		 sh 'cd ./lambda'
		 sh 'ls'
		 sh 'serverless deploy --verbose'
	   }
	 }
  }
}