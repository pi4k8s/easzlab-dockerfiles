node {
    stage('git chekout') {
        git branch: "master", url: 'https://github.com/pi4k8s/easzlab-dockerfiles.git'
    }
    stage('docker build & push') {
        sh "cd kubeasz-sys-pkg && docker build . -t pi4k8s/easzlab-kubeasz-sys-pkg:0.4.3"
        sh "docker push pi4k8s/easzlab-kubeasz-sys-pkg:0.4.3"
    }
    stage('cleanWs'){
        cleanWs()
    }
}