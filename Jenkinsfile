pipeline {
  agent any

  triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'ref', value: '$.data.master_ip']
     ],

     causeString: 'Triggered on $ref',

     printContributedVariables: true,
     printPostContent: true,

     silentResponse: false,
     
     shouldNotFlatten: false,
    )
  }


  stages {
    stage('Deploy') {
      steps {
        sh "echo $ref"
      }
    }
  }

}

