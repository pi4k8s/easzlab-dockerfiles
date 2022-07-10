node {
    stage('git chekout') {
        git branch: "master", url: 'https://github.com/pi4k8s/easzlab-dockerfiles.git'
    }
    stage('docker build & push') {
        sh "cd kubeasz-k8s-build && docker build . -t pi4k8s/easzlab-kubeasz-ext-build:1.0.0"
        sh "docker push pi4k8s/easzlab-kubeasz-ext-build:1.0.0"
    }
    stage('cleanWs'){
        cleanWs()
    }
}