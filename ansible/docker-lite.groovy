node {
    stage('git chekout') {
        git branch: "master", url: 'https://github.com/pi4k8s/easzlab-dockerfiles.git'
    }
    stage('parallel docker build') {
        sh "cd ansible && docker build -f Dockerfile-lite . -t pi4k8s/easzlab-ansible:2.10.6-lite"
        sh "docker push pi4k8s/easzlab-ansible:2.10.6-lite"
    }
    stage('cleanWs'){
        cleanWs()
    }
}