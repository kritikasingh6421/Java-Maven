pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
        jdk "JAVA_HOME"
    }

    stages {

       stage ('Build') {
            steps {
                bat 'mvn clean test'
            }
        }
           
    }
}