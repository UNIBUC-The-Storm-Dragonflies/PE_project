pipeline {
    agent any
    environment {
        DOCKER_PASSWORD = credentials("docker_password")
        GITHUB_TOKEN = credentials("github_token")
    }

    stages {
        stage('Build & Test') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Tag image') {
          steps {
            script {
                sh([script: 'git fetch --tag', returnStdout: true]).trim()
                env.MAJOR_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 1', returnStdout: true]).trim()
                env.MINOR_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 2', returnStdout: true]).trim()
                env.PATCH_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 3', returnStdout: true]).trim()
                env.IMAGE_TAG = "${env.MAJOR_VERSION}.\$((${env.MINOR_VERSION} + 1)).${env.PATCH_VERSION}"
            }
            sh "docker build -t ovidiuiordache/hello-img:${env.IMAGE_TAG} ."
            sh "docker login docker.io -u ovidiuiordache -p $DOCKER_PASSWORD"
            sh "docker push ovidiuiordache/hello-img:${env.IMAGE_TAG}"
            sh "git tag ${env.IMAGE_TAG}"
            sh "git push https://$GITHUB_TOKEN@github.com/UNIBUC-The-Storm-Dragonflies/PE_project.git ${env.IMAGE_TAG}"
          }
        }
        stage('Docker start') {
            steps {
                sh "IMAGE_TAG=${env.IMAGE_TAG} docker-compose up -d hello"
            }
        }
        stage('Test E2E') {
            steps {
                sh './gradlew testE2E'
            }
        }
    }
}
