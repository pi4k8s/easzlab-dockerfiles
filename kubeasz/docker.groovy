node {
    stage('git chekout') {
        git branch: "master", url: 'https://github.com/pi4k8s/easzlab-dockerfiles.git'
    }
    stage('docker build & push') {
        sh "cd kubasz && docker build . -t pi4k8s/easzlab-kubasz:3.3.1"
        sh "docker push pi4k8s/easzlab-kubasz:3.3.1"
    }
    stage('cleanWs'){
        cleanWs()
    }
}