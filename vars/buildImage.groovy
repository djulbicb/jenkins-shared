#!/usr/bin/env.groovy
import com.example.Docker
def call(String credentialsId, String imageName) {
    return new Docker(this).login(credentialsId, imageName)
}