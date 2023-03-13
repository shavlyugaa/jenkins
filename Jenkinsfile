pipeline {  
  agent { label 'maven' } 
  stages{     
     stage('Build') {
	   steps {
	     sh 'mvn -f ./lambda clean package'
	   }
	   post {
	     success {
		   echo 'Archiving...'
		   archiveArtifacts artifacts: '**/target/*.jar, **/serverless.yml' , fingerprint: true
		 }
	   }
	 }
	 stage('Deploy to stage') {
	   environment {
         STAGE_AWS_ACCESS_KEY_ID     = credentials('stage-aws-key-id')
         STAGE_AWS_SECRET_ACCESS_KEY = credentials('stage-aws-secret-access-key')
       }	   
	   steps {	
	     copyArtifacts(
           filter: '**/*.jar, **/serverless.yml',
           projectName: 'maven-build',
           fingerprintArtifacts: true)
	   }
	 }
  }
}