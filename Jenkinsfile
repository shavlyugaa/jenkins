pipeline {
  agent 'maven'
  stages{
     stage('Build') {
	   steps {
	     bat 'mvn -f .\\lambda clean package'
	   }
	   post {
	     success {
		   echo 'Archiving...'
		   archiveArtifacts artifacts: '**\\target\\*.jar; **\\serverless.yml'
		 }
	   }
	 }
  }
}