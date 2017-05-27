pipeline {
  //The agent ensures that the source repository is checked out and made available for steps in the subsequent stages
  agent any

  environment {
    DOCKER_VERSION = '1.0.0'
  }

  tools {
    nodejs 'NodeJS (7.2.0) with AngularCLI'
  }

  stages {
    stage('Preparing enviroment') {
      steps {
        sh 'node -v'
        sh 'npm -v'
        sh 'npm install'
      }
    }
    stage('Build') {
      steps {
        echo 'Building'
        sh 'ng build --prod'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing'
        sh 'ng test --prod --watch=false'
      }
    }
    stage('Build Docker Images'){
      when{
        expression {
          return  BRANCH_NAME == 'staging'
        }
      }
      steps {
        sh "docker build -t davidem1979/wallet-web:${env.DOCKER_VERSION} -t davidem1979/wallet-web:latest ."

        sh 'docker push davidem1979/wallet-web'

        sh 'docker rmi -f davidem1979/wallet-web'
        sh 'docker rmi $(docker images davidem1979/wallet-web -q)'
      }
    }
  }
  post {
    always {
      echo 'prune and cleanup'
      sh 'rm node_modules -rf'
    }

    success {
      mail body: 'project build successful',
        from: 'davide.martorana@gmail.com',
        replyTo: 'davide.martorana@gmail.com',
        subject: 'The Pipeline successful',
        to: 'davide.martorana@gmail.com'
    }
    failure {
      mail body: "project build error is here: ${env.BUILD_URL}" ,
        from: 'davide.martorana@gmail.com',
        replyTo: 'davide.martorana@gmail.com',
        subject: 'The Pipeline failed',
        to: 'davide.martorana@gmail.com'
    }
  }
}