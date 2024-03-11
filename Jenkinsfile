pipeline {
  agent any

  triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'master_ip', value: '$.master_ip']
     ],

     causeString: 'Triggered on $master_ip',

     printContributedVariables: true,
     printPostContent: true,

     silentResponse: false,
     
     shouldNotFlatten: false,
    )
  }


  stages {
    stage('Deploy') {
      steps {
        sh "echo ${master_ip}"
      }
    }
  }

}

