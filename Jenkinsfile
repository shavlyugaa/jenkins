pipeline {
  agent any
  stages{
     stage('Build') {
	   steps {
	     sh 'mvn -f .\\lambda clean package'
	   }
	   post {
	     success {
		   echo 'Archiving...'
		   archiveArtifacts artifacts:'**/target/*.jar'
		 }
	   }
	 }
  }
}