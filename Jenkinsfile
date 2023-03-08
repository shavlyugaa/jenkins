pipeline {
  agent any
  stages{
     stage('Build') {
	   steps {
	     bat 'mvn -f .\\lambda clean package'
	   }
	 }
  }
}