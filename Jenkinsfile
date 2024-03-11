pipeline {
  agent any


  stages {
     stage('Pre-SSH Checks') {
      steps {
        // Ping the IP address
        script {
          def ipAddress = ${master_ip}
          def result = sh(returnStatus: true, script: "ping -c 1 ${ipAddress} && echo Success || echo Failure")
          if (result != 0) {
            error "Ping to ${ipAddress} failed!"
          } else {
            echo "Ping to ${ipAddress} successful!"
          }
        }
      }
    }
     stage('SSH Connection') {
      steps {
        // Connect to the remote server if ping is successful
        ssh(
          label: 'ssh-label',
          credentialsId: 'ssh-credentials-id',
          command: 'echo "Hello World"',
          timeout: 10
        )
      }
    }
    stage('Deploy') {
      steps {
        sh "echo ${master_ip}"
      }
    }
  }

}

