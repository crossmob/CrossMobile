FROM debian:buster

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y \
        libfontconfig1-dev \
        libx11-dev \
        libxext-dev \
        libxrandr-dev \
        libxcursor-dev \
        libxi-dev \
        libxinerama-dev \
        libxxf86vm-dev \
        #libxss-dev \
        libgl1-mesa-dev \
        libdbus-1-dev \
        libudev-dev \
        libgles2-mesa-dev \
        libegl1-mesa-dev \
        libibus-1.0-dev \
        fcitx-libs-dev \
        libwayland-dev \
        libxkbcommon-dev \
        wayland-protocols \
        git \
        cmake \
        ninja-build \
        build-essential \
        clang \
        python2.7 \
        zip \
        software-properties-common && \
        \
        apt-add-repository -yu 'deb http://security.debian.org/debian-security stretch/updates main' && \
        apt-get install -y openjdk-8-jdk && \
        ln -sf /usr/bin/python2.7 /usr/bin/python && \
        ln -sf /usr/bin/python2.7 /usr/bin/python2

ENV JAVA_HOME "/usr/lib/jvm/java-1.8.0-openjdk-amd64"
ENV PATH "$JAVA_HOME/bin:/src/depot_tools:$PATH"

WORKDIR /src
