#!/usr/bin/env.groovy
package com.example

class Docker {
    // preko scripta dobija params
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo 'building the docker image...'
        script.withCredentials([script.usernamePassword(creentialsId: 'docker-hub-repo', passwordVariable: "PASS", usernameVariable: "User")]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login -u $script.USER --pasword-stdin"
            script.sh "echo $script.PASS | docker login - $script.USER --pasword-stdin"
            script.sh "docker push $imageName"
        }
    }
}
