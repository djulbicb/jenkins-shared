#!/usr/bin/env.groovy
package com.example

class Docker {
    // preko scripta dobija params
    def script

    Docker(script) {
        this.script = script
    }

    def login(String credentialsId) {
        script.echo 'Login to docker...'
        script.sh "echo $script.PASS | docker login -u $script.USER --pasword-stdin"
    }

    def buildImage(String imageName) {
        script.echo 'building the docker image...'
        script.sh "docker build -t $imageName ."
    }

    def puchImage(String imageName) {
        script.sh "docker push $imageName"
    }
}
