#!/usr/bin/env groovy

def call(){
    withCredentials([usernamePassword(credentialsId: 'github-credentials', passwordVariable: 'PWD', usernameVariable: 'USR')]) {
        sh 'git config  --global user.email "jenkins@example.com"'
        sh 'git config  --global user.name "jenkins"'

        sh "git remote set-url origin https://$USR:$PWD@github.com/eralora/jenkins_hw.git"
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh 'git push origin HEAD:jenkins-jobs'
    }
}