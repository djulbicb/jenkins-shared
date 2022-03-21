#!/usr/bin/env.groovy
def call() {
    sh 'echo buildind $BRANCH_NAME'
    echo 'building the application'
    sh 'mvn clean package'
}