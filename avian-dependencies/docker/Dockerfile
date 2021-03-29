FROM debian:buster

ARG ARCH=amd64
ARG OS=linux

RUN ["/bin/bash", "-c", "\
if [[ $(uname -m) == $ARCH || 'amd64' == $ARCH ]] ; then \
        export ARCH='amd64' && \
        echo 'Build native docker ${ARCH} image'; \
else \
        if [[ $OS == 'linux' ]] ; then \
        echo 'Build cross-compiler docker image for target:' $ARCH && \
                case $ARCH in \
                        arm64|aarch64)\
                                export ARCH='arm64' && \
                                CROSS_PKG='\
                                        gcc-aarch64-linux-gnu \
                                        g++-aarch64-linux-gnu' \
                        ;;\
                        arm|armhf)\
                                export ARCH='armhf' && \
                                CROSS_PKG='\
                                        gcc-arm-linux-gnueabihf \
                                        g++-arm-linux-gnueabihf' \
                        ;;\
                        amd64|x86_64|x64)\
                                export ARCH='x86_64' && \
                                CROSS_PKG='\
                                        gcc \
                                        g++' \
                        ;;\
                        *)\
                                echo 'Unsupported system architecture: $ARCH'\
                                exit 1\
                        ;;\
                esac ;\
        elif [[ $OS == 'win' && $ARCH == 'i386' ]] ; then \
                export ARCH='i386' && \
                CROSS_PKG='\
                        mingw-w64'; \
        else echo 'Unsupported operating system: ${OS}'; fi && \
        dpkg --add-architecture $ARCH && \
        apt-get update && \
        apt-get install -y \
        $CROSS_PKG; fi\
"]

RUN     apt-get update && \
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
        python-libxml2 \
        git \
        wget \
        build-essential \
        ninja-build \
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
