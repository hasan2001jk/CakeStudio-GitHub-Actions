pipeline {
  agent any

  triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'master_ip', value: '$.data.master_ip']
     ],

     causeString: 'Triggered on Webhook',

     printContributedVariables: true,
     printPostContent: true,

     silentResponse: false,
     
     shouldNotFlatten: false,
    )
  }


  stages {
    stage('Deploy') {
      steps {
        sh "echo $master_ip"
      }
    }
  }

}

