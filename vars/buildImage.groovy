#!/usr/bin/env.groovy
def call(String imageName) {
    echo "Building the docker image"
    withCredentials([ usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t djulb/echo4j:$imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push djulb/echo4j:$imageName"
    }
}