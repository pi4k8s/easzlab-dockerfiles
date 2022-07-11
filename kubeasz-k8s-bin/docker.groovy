node {
    stage('git chekout') {
        git branch: "master", url: 'https://github.com/pi4k8s/easzlab-dockerfiles.git'
    }
    stage('docker build & push') {
        sh "cd kubeasz-k8s-bin && docker build . -t pi4k8s/easzlab-kubeasz-k8s-bin:v1.24.2 --build-arg K8S_VERSION=v1.24.2"
        sh "docker push pi4k8s/easzlab-kubeasz-k8s-bin:v1.24.2"
    }
    stage('cleanWs'){
        cleanWs()
    }
}