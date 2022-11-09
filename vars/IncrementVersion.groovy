#!/usr/bin/env groovy

def call(){
    dir("app") {
        sh "npm version minor"

        def packageJson = readJSON file: 'package.json'
        def version = packageJson.version

        env.IMAGE_NAME = "$version-$BUILD_NUMBER"
    }
}