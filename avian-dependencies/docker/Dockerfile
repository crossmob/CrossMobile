FROM debian:buster

ARG ARCH

RUN [ "$(uname -m)" != "$ARCH" ] && \
    g++-$ARCH-linux-gnu \
    binutils-$ARCH-linux-gnu

RUN dpkg --add-architecture $ARCH && \
    apt-get update && \
    apt-get install -y \
        libfontconfig1-dev:$ARCH \
        libx11-dev:$ARCH \
        libxext-dev:$ARCH \
        libxrandr-dev:$ARCH \
        libxcursor-dev:$ARCH \
        libxi-dev:$ARCH \
        libxinerama-dev:$ARCH \
        libxxf86vm-dev:$ARCH \
        libgl1-mesa-dev:$ARCH \
        libdbus-1-dev:$ARCH \
        libudev-dev:$ARCH \
        libgles2-mesa-dev:$ARCH \
        libegl1-mesa-dev:$ARCH \
        libibus-1.0-dev:$ARCH \
        fcitx-libs-dev:$ARCH \
        libwayland-dev:$ARCH \
        libxkbcommon-dev:$ARCH \
        wayland-protocols:$ARCH \
        git \
        cmake \
        ninja-build \
        build-essential \
        clang \
        python2.7 \
        zip \
        zlib1g-dev \
        software-properties-common && \
        apt-add-repository -yu 'deb http://security.debian.org/debian-security stretch/updates main' && \
        apt-get install -y openjdk-8-jdk && \
        ln -sf /usr/bin/python2.7 /usr/bin/python && \
        ln -sf /usr/bin/python2.7 /usr/bin/python2

ENV JAVA_HOME "/usr/lib/jvm/java-1.8.0-openjdk-amd64"
ENV PATH "$JAVA_HOME/bin:/src/depot_tools:$PATH"

WORKDIR /src
