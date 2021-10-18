pipeline{
    agent any
    stage("test"){
        steps{
            script{
                sh '''echo test1
                      sh whami'''
            }
        }
    }
}