pipeline {
  agent any
  stages{
     stage('Build') {
	   steps {
	     bat 'mvn -f .\\lambda -Djar.finalName=lambda clean package'
	   }
	 }
  }
}