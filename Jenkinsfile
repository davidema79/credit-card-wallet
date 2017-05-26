pipeline {
    //The agent ensures that the source repository is checked out and made available for steps in the subsequent stages
    agent any

    stages {
    	stage('Compile') {
    		steps {
    			echo "Compiling ${BUILD_TAG}"
    			echo "Branch name: ${BRANCH_NAME}"
    			sh 'mvn clean compile -U'
    		}
		  }

    	stage('Unit Test & Package') {
    		steps {
    			echo "Packaging ${BUILD_TAG}"
    			sh 'mvn package'
    		}
      }

    	stage('Integration Test') {
    	  when {
    	    branch "development"
    	  }
    		steps {
    			echo "IT Testing ${BUILD_TAG}"

    			// It executes the pre and post integration-test phases
    			// It skips the Unit Tests because already performed
    			sh 'mvn verify -DskipTests=true -Pit.test'
        }
      }

    	stage('Deploy Artifact') {
    	  when {
    	    expression {
    	      return  BRANCH_NAME == 'master' || BRANCH_NAME == 'development'
    	    }
    	  }
    		steps {
    		  echo "Deploying ${BUILD_TAG}"

    			//It skips the Unit and Integration tests because already performed
    			sh 'mvn deploy -DskipIT=true -DskipTests=true'
    		}
      }

    	stage('Create Docker Image') {
    	  when {
    	    expression {
    	      return  BRANCH_NAME == 'master' || BRANCH_NAME == 'staging'
    	    }
    	  }
    		steps {
    			echo "Creating Image for ${BUILD_TAG}"

    			sh 'pwd'
    			sh 'ls -al'

    			sh 'mvn docker:build'

          echo 'pushing config-server docker image to nexus'
    			sh "docker push nexus.vexios.mla.local:18079/back-office/bo-vexios-gateway"

    			echo 'Cleaning up the local docker registry...'
    			sh 'docker rmi -f nexus.vexios.mla.local:18079/back-office/bo-vexios-gateway'
    			sh 'docker rmi $(docker images nexus.vexios.mla.local:18079/back-office/bo-vexios-gateway -q)'
    		}
		}
	}

	post{

		always{

			echo 'Always step'

		}
		success {
				mail body: "Job '${JOB_NAME}' (${BUILD_NUMBER}) was successful",
					from: 'clinton.magro@vexios.com',
					replyTo: 'clinton.magro@vexios.com',
					subject: 'The Pipeline Successful',
					to: 'adam.darmanin@vexios.com',
					cc: 'davide.martorana@vexios.com'

				echo 'Success step'
		}
		failure{
				mail body: "Job '${JOB_NAME}' ( ${BUILD_NUMBER} ) was unsuccessful. Please go to ${BUILD_URL} and verify the build.",
					from: 'clinton.magro@vexios.com',
					replyTo: 'clinton.magro@vexios.com',
					subject: 'The Pipeline Failed',
					to: 'adam.darmanin@vexios.com'
					cc: 'davide.martorana@vexios.com'

				echo 'Failure step'
		}
	}

}