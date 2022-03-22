#!/usr/bin/env.groovy
import com.example.Docker
def call(String credentialsId, String imageName) {
    def docker = new Docker(this)
    docker.login(credentialsId)
    docker.buildImage(imageName)
    docker.puchImage(imageName)
}