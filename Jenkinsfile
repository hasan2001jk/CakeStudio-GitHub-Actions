pipeline {
    agent any

        triggers {
        genericTrigger {
            genericVariables {
                genericVariable {
                    key("extractedField")  // Name for the extracted variable
                    value("\$.master_ip)  // JSONPath expression to locate the value
                    expressionType("JSONPath") // Optional, defaults to JSONPath
                    regexpFilter("")        // Optional, defaults to empty string
                    defaultValue("")        // Optional, defaults to empty string
                }
            }
        }
    }

    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                script {
                    // Access and print the entire payload
                    def extractedValue = env.extractedField
                    println "Extracted value: ${extractedValue}"
                }
            }
        }
    }
}
