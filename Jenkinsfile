pipeline {  
  agent { label 'maven' } 
  options {
        copyArtifactPermission('deploy-groovy, deploy');
  }
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
  }
}