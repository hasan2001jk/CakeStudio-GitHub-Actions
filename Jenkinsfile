pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                script {
                    // Access and print the entire payload
                    def payload = env.RAW_ENV
                    println "Full payload: ${payload}"
                }
            }
        }
    }
}
