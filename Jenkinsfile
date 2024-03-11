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
        sshagent(credentials : ['ssh-credentials-id']) {
            sh 'ssh -o user@${master_ip}'
            sh 'ssh -v user@${master_ip}'
      }
    }
    stage('Deploy') {
      steps {
        sh "echo ${master_ip}"
      }
    }
  }

}

