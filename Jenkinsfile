pipeline {
  agent any
  stages{
     stage('Build') {
	   steps {
	     bat 'mvn -f .\\lambda clean package'
	   }
	   post {
	     success {
		   echo 'Archiving...'
		   archiveArtifacts artiffacts:'**/target/*.zip'
		 }
	   }
	 }
  }
}