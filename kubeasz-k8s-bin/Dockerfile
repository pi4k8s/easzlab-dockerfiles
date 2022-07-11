# Download kubernetes binaries needed by 'kubeasz'
#
# @author:  gjmzj
# @repo:    https://github.com/kubeasz/dockerfiles/kubeasz-k8s-bin
# @ref:     https://github.com/easzlab/kubeasz

FROM alpine:3.12

ARG K8S_VERSION=v1.21.4

ENV K8S_VER=$K8S_VERSION

RUN wget https://dl.k8s.io/$K8S_VER/kubernetes-server-linux-arm64.tar.gz && \
    tar zxf kubernetes-server-linux-arm64.tar.gz && \
    mkdir -p /k8s && cd kubernetes/server/bin && \
    mv kube-apiserver kube-controller-manager kube-scheduler /k8s && \
    mv kubelet kube-proxy kubectl /k8s && \
    cd / && rm -rf kubernetes*

CMD [ "sleep", "360000000" ]
