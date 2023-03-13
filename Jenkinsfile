pipeline {  
  agent any
  stages{     
     stage('Build') {
	   agent { label 'maven' } 
	   steps {
	     sh 'mvn -f ./lambda clean package'
	   }
	   post {
	     success {
		   echo 'Archiving...'
		   archiveArtifacts artifacts: '**/target/*.jar, **/serverless.yml'
		 }
	   }
	 }
	 stage('Deploy to stage') {	 
	   agent { label 'serverless' }
	   environment {
         STAGE_AWS_ACCESS_KEY_ID     = credentials('stage-aws-key-id')
         STAGE_AWS_SECRET_ACCESS_KEY = credentials('stage-aws-secret-access-key')
       }	   
	   steps {	     
         sh 'serverless config credentials \
		   --provider aws \
		   --key $STAGE_AWS_ACCESS_KEY_ID \
		   --secret $STAGE_AWS_SECRET_ACCESS_KEY'
		 cd ./lambda
		 sh 'serverless deploy --verbose'
	   }
	 }
  }
}