FROM debian:buster

ARG ARCH=amd64
ARG OS=linux

RUN     if [ "$ARCH" = "arm"    ] ; then ARCH=armhf ; CROSS_PKG='gcc-arm-linux-gnueabihf g++-arm-linux-gnueabihf' ; fi ;\
        if [ "$ARCH" = "arm64"  ] ; then ARCH=arm64 ; CROSS_PKG='gcc-aarch64-linux-gnu g++-aarch64-linux-gnu'    ; fi ;\
        if [ "$ARCH" = "x86_64" ] ; then ARCH=amd64 ; CROSS_PKG='gcc g++'; fi ;\
        dpkg --add-architecture $ARCH && \
        apt-get update && \
        apt-get install -y software-properties-common && \
        apt-add-repository -yu 'deb http://security.debian.org/debian-security stretch/updates main' && \
        apt-get update && \
        apt-get install -y $CROSS_PKG \
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
        libsamplerate-dev:$ARCH \
        libwayland-dev:$ARCH \
        libxkbcommon-dev:$ARCH \
        wayland-protocols:$ARCH \
        libxml2-dev:$ARCH \
        libinput-dev:$ARCH \
        libexpat1-dev:$ARCH \
        libmtdev-dev:$ARCH \
        libpam0g-dev:$ARCH \
        libunwind8-dev:$ARCH \
        libpciaccess-dev:$ARCH \
        libgudev-1.0-dev:$ARCH \
        libglib2.0-dev:$ARCH \
        libglew2.1:$ARCH \
        libglu1-mesa:$ARCH \
        libgles1:$ARCH \
        libgles2:$ARCH \
        libgcrypt20-dev:$ARCH \
        libxfont-dev:$ARCH \
        libedit-dev:$ARCH \
        libstdc++-8-dev:$ARCH \
        libjpeg62-turbo:$ARCH \
        libjpeg62-turbo-dev:$ARCH \
        libpng16-16:$ARCH \
        libpng-dev:$ARCH \
        libgmp3-dev:$ARCH \
        libmpc-dev:$ARCH \
        libmpfr-dev:$ARCH \
        bison \
        flex \
        texinfo \
        python-libxml2 \
        git \
        wget \
        build-essential \
        ninja-build \
        clang \
        python2.7 \
        zip \
        zlib1g-dev \
        openjdk-8-jdk && \
        ln -sf /usr/bin/python2.7 /usr/bin/python && \
        ln -sf /usr/bin/python2.7 /usr/bin/python2


ENV JAVA_HOME "/usr/lib/jvm/java-1.8.0-openjdk-amd64"
ENV PATH "$JAVA_HOME/bin:/src/depot_tools:$PATH"

WORKDIR /src

RUN useradd builduser && chown -R builduser /src
USER builduser
