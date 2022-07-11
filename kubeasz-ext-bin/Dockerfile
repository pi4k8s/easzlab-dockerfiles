# Download extral binaries needed by 'kubeasz'
#
# @author:  gjmzj
# @repo:    https://github.com/kubeasz/dockerfiles/kubeasz-ext-bin
# @ref:     https://github.com/easzlab/kubeasz
FROM alpine:3.12

ENV ETCD_VER=v3.5.4

RUN mkdir -p /extra && \
    \
    wget https://github.com/etcd-io/etcd/releases/download/${ETCD_VER}/etcd-${ETCD_VER}-linux-arm64.tar.gz && \
    tar zxf etcd-${ETCD_VER}-linux-arm64.tar.gz && \
    cd etcd-${ETCD_VER}-linux-arm64 && \
    mv etcd etcdctl /extra && \
    cd / && rm -rf etcd-${ETCD_VER}-linux-arm64*

FROM alpine:3.12

ENV CFSSL_VER=1.6.1

RUN mkdir -p /extra && \
    \
    wget https://github.com/pi4k8s/cfssl/releases/download/v${CFSSL_VER}/cfssl && \
    wget https://github.com/pi4k8s/cfssl/releases/download/v${CFSSL_VER}/cfssljson && \
    wget https://github.com/pi4k8s/cfssl/releases/download/v${CFSSL_VER}/cfssl-certinfo && \
    mv cfssl /extra/cfssl && \
    mv cfssljson /extra/cfssljson && \
    mv cfssl-certinfo /extra/cfssl-certinfo

FROM alpine:3.12

ENV CNI_VER=v1.1.1

RUN mkdir -p /extra && \
    \
    wget https://github.com/containernetworking/plugins/releases/download/${CNI_VER}/cni-plugins-linux-arm64-${CNI_VER}.tgz && \
    mkdir /cni && tar zxf cni-plugins-linux-arm64-${CNI_VER}.tgz -C /cni && \
    cd /cni && mv bridge host-local loopback portmap tuning /extra && \
    cd / && rm -rf cni*

FROM alpine:3.12

ENV CILIUM_CLI_VER=v0.11.9

RUN mkdir -p /extra && \
    \
    wget https://github.com/cilium/cilium-cli/releases/download/${CILIUM_CLI_VER}/cilium-linux-arm64.tar.gz && \
    tar zxf cilium-linux-arm64.tar.gz -C /extra && \
    rm -rf cilium-linux-arm64.tar.gz

FROM alpine:3.12

ENV HUBBLE_VER=v0.9.0

RUN mkdir -p /extra && \
    \
    wget https://github.com/cilium/hubble/releases/download/${HUBBLE_VER}/hubble-linux-arm64.tar.gz && \
    tar zxf hubble-linux-arm64.tar.gz -C /extra && \
    rm -rf hubble-linux-arm64.tar.gz

FROM alpine:3.12

ENV FLANNEL_CNI_VER=v1.1.0

RUN mkdir -p /extra && \
    \
    wget https://github.com/flannel-io/cni-plugin/releases/download/${FLANNEL_CNI_VER}/flannel-arm64 && \
    mv flannel-arm64 /extra/flannel

FROM alpine:3.12

ENV HELM_VER=v3.8.2

RUN mkdir -p /extra && \
    \
    wget https://get.helm.sh/helm-${HELM_VER}-linux-arm64.tar.gz && \
    tar zxf helm-${HELM_VER}-linux-arm64.tar.gz && \
    mv linux-arm64/helm /extra && \
    rm -rf linux-arm64 helm-${HELM_VER}-linux-arm64.tar.gz

FROM alpine:3.12

ENV DOCKER_COMPOSE_VER=v2.6.1

RUN mkdir -p /extra && \
    \
    wget https://github.com/docker/compose/releases/download/${DOCKER_COMPOSE_VER}/docker-compose-Linux-aarch64 && \
    mv docker-compose-Linux-aarch64 /extra/docker-compose



FROM alpine:3.12

ENV CALICOCTL_VER=v3.19.4

RUN mkdir -p /extra && \
    \
    wget https://github.com/projectcalico/calicoctl/releases/download/${CALICOCTL_VER}/calicoctl-linux-arm64 && \
    mv calicoctl-linux-arm64 /extra/calicoctl

FROM alpine:3.12

ENV CRICTL_VER=v1.24.2

RUN mkdir -p /extra/containerd-bin && \
    \
    wget https://github.com/kubernetes-sigs/cri-tools/releases/download/${CRICTL_VER}/crictl-${CRICTL_VER}-linux-arm64.tar.gz && \
    tar zxf crictl-${CRICTL_VER}-linux-arm64.tar.gz -C /extra/containerd-bin && \
    rm -rf crictl-${CRICTL_VER}-linux-arm64.tar.gz

FROM alpine:3.12

ENV RUNC_VER=v1.1.2

RUN mkdir -p /extra/containerd-bin && \
    \
    wget https://github.com/opencontainers/runc/releases/download/${RUNC_VER}/runc.arm64 && \
    chmod +x runc.arm64 && mv runc.arm64 /extra/containerd-bin/runc

FROM alpine:3.12

ENV ETCD_VER=v3.5.4 \
    CFSSL_VER=1.6.1 \
    CNI_VER=v1.1.1 \
    CILIUM_CLI_VER=v0.11.9 \
    HUBBLE_VER=v0.9.0 \
    FLANNEL_CNI_VER=v1.1.0 \
    HELM_VER=v3.8.2 \
    DOCKER_COMPOSE_VER=2.6.1 \
    CALICOCTL_VER=v3.19.4 \
    CRICTL_VER=v1.24.2 \
    RUNC_VER=v1.1.2 \
    CONTAINERD_VER=1.6.4 \
    EXT_BIN_VER=1.2.0

RUN mkdir -p /extra/containerd-bin && \
    wget https://github.com/containerd/containerd/releases/download/v${CONTAINERD_VER}/containerd-${CONTAINERD_VER}-linux-arm64.tar.gz && \
    tar zxf containerd-${CONTAINERD_VER}-linux-arm64.tar.gz -C /tmp && \
    mv /tmp/bin/* /extra/containerd-bin && \
    rm -rf containerd-${CONTAINERD_VER}-linux-arm64.tar.gz

COPY --from=0 /extra/etcd /extra/etcd
COPY --from=0 /extra/etcdctl /extra/etcdctl
COPY --from=1 /extra/cfssl /extra/cfssl
COPY --from=1 /extra/cfssljson /extra/cfssljson
COPY --from=1 /extra/cfssl-certinfo /extra/cfssl-certinfo
COPY --from=2 /extra/bridge /extra/bridge
COPY --from=2 /extra/host-local /extra/host-local
COPY --from=2 /extra/loopback /extra/loopback
COPY --from=2 /extra/portmap /extra/portmap
COPY --from=2 /extra/tuning /extra/tuning
COPY --from=3 /extra/cilium /extra/cilium
COPY --from=4 /extra/hubble /extra/hubble
COPY --from=5 /extra/flannel /extra/flannel
COPY --from=6 /extra/helm /extra/helm
COPY --from=7 /extra/docker-compose /extra/docker-compose
COPY --from=8 /extra/calicoctl /extra/calicoctl
COPY --from=9 /extra/containerd-bin/crictl /extra/containerd-bin/crictl
COPY --from=10 /extra/containerd-bin/runc /extra/containerd-bin/runc
COPY --from=pi4k8s/easzlab-kubeasz-ext-build:1.0.0 /bin/nginx /extra/nginx
COPY --from=pi4k8s/easzlab-kubeasz-ext-build:1.0.0 /bin/chronyd /extra/chronyd
COPY --from=pi4k8s/easzlab-kubeasz-ext-build:1.0.0 /bin/keepalived /extra/keepalived

CMD [ "sleep", "360000000" ]
