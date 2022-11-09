#!/usr/bin/env groovy

def call(){
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t 207.154.233.102:8090/my-node-app:$IMAGE_NAME ."
        sh "echo $PASS | docker login -u $USER --password-stdin 207.154.233.102:8090"
        sh "docker push 207.154.233.102:8090/my-node-app:$IMAGE_NAME"
    }
}