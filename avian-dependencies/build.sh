#!/bin/bash
set -e


RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
NC='\033[0m'

SRC_ROOT=$(dirname "$(realpath "$0")")
TARGET_OS=$(uname -s | tr '[:upper:]' '[:lower:]')
TARGET_ARCH=$(uname -m)
TARGET_CMD=""
TARGET_DIR="all"
TARGET_SUBDIR="all"

USAGE='\n\r
# TARGET=avian,sdl,skia,all(default)\n\r
# SUB_TARGET=arm,arm64,x86_64,all(default)\n\r
OS=linux
MACHINE=arm,arm64,amd64
\n\r
Parameters:\n\r
    \t-h|--help\n\r
    \t-c|--clean [OS] [MACHINE]\n\r
    \t-b|--build [OS] [MACHINE]\n\r
    \t-o|--os\n\r
    \t-m|--machine\n\r
'

cd $SRC_ROOT

_check_docker_image() {
    echo "Check image: \"$1\""
    if [[ "$(docker images -q $1 2> /dev/null)" == "" ]]; then
        return -1 #image doesn't exits
    fi
        return 0 #image exist
}

# temporary hack to install avian dependencies user-wide
_install () {
    DEST=~/.cache/crossmobile/avian/0.1
    rm -rf $DEST
    mkdir -p $DEST
    cp -r target/* $DEST
}

_build () {

    if [[ $TARGET_ARCH == "arm" ]]; then
        TARGET_ARCH="armhf"
    elif [[ $TARGET_ARCH == "x86_64" ]]; then
        TARGET_ARCH="amd64"
    fi

    local IMAGE_NAME="aroma/dep-builder-$TARGET_OS-$TARGET_ARCH"

    if [[ "$(_check_docker_image $IMAGE_NAME)" != "0" ]]; then
        echo "Building image: \"$IMAGE_NAME\""
        # SRC_DIR=$SRC_ROOT \
        # TARGET_OS=$TARGET_OS \
        # TARGET_ARCH=$TARGET_ARCH \
        #sudo docker-compose -f docker/docker-compose.yml build --build-args SRC_DIR=$SRC_ROOT TARGET_OS=$TARGET_OS TARGET_ARCH=$TARGET_ARCH aromadepbuilder
        docker build -t $IMAGE_NAME docker/ --build-arg ARCH=$TARGET_ARCH --build-arg OS=linux
    fi

    # if [[ "$(_check_docker_image "aroma/dep-builder-win-i386")"]]; then
    #     docker build -t aroma/dep-builder-win-i386 docker/ --build-arg ARCH=i386 OS=win
    # fi
    git submodule update --recursive --init --remote

    echo "Run image: \"$IMAGE_NAME\""
    # sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
    #     bash "/src/scripts/linker_builder.sh" -b \
    #     -h x86_64-w64-mingw32 \
    #     -t aarch64-linux-gnu \
    #     -s /src \
    #     -o /src/target/common/bin
    # sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
    #     bash "/src/scripts/linker_builder.sh" -b \
    #     -h x86_64-w64-mingw32 \
    #     -t arm-linux-gnueabihf \
    #     -s /src \
    #     -o /src/target/common/bin
    # sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
    #     bash "/src/scripts/linker_builder.sh" -b \
    #     -h x86_64-w64-mingw32 \
    #     -t x86_64-linux-gnu \
    #     -s /src \
    #     -o /src/target/common/bin
    sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
        bash "/src/scripts/linker_builder.sh" -b \
        -h x86_64-linux-gnu \
        -t x86_64-linux-gnu \
        -s /src \
        -o /src/target/common/bin
    sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
        bash "/src/scripts/linker_builder.sh" -b \
        -h x86_64-linux-gnu \
        -t aarch64-linux-gnu \
        -s /src \
        -o /src/target/common/bin
    sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
        bash /src/scripts/linker_builder.sh -b \
        -h x86_64-linux-gnu \
        -t arm-linux-gnueabihf \
        -s /src \
        -o /src/target/common/bin
    sudo docker run --rm -it -v ${SRC_ROOT}:/src $IMAGE_NAME \
        bash /src/docker/dep_builder.sh \
        /src $TARGET_OS $TARGET_ARCH release

    sudo chown -R $USER:$USER .
    _install
}

__msg_error() {
    echo -e ${RED}${1}${NC}
    exit 1
}

__msg_warn() {
    echo -e ${YELLOW}${1}${NC}
}

__msg_info() {
    echo -e ${GREEN}${1}${NC}
}

__git_clean() {
    git clean $1 -dxf
    git restore $1
}

_clean_avian () {
    [ -d "$SRC_ROOT/avian/build" ] && \
        chown -R $USER $SRC_ROOT/avian/build

    if [[ "$TARGET_SUBDIR" == "all" ]]; then
        if [ -d $SRC_ROOT/target ]; then
            find $SRC_ROOT/target -maxdepth 2 -name 'libavian.zip' -delete
            find $SRC_ROOT/target -maxdepth 2 -name 'driver.o' -delete
            find $SRC_ROOT/target -maxdepth 2 -name 'binaryToObject' -delete
        fi
        [ -f "$SRC_ROOT/target/common/classpath.jar" ] && \
            rm $SRC_ROOT/target/common/classpath.jar
        [ -f "$SRC_ROOT/target/common/bin/linux-x86_64/binaryToObject" ] && \
            rm "$SRC_ROOT/target/common/bin/linux-x86_64/binaryToObject"
        rm -rf $SRC_ROOT/avian/build/*
        __git_clean $SRC_ROOT/avian
    else
        [ -f "$SRC_ROOT/target/$TARGET_SUBDIR/driver.o" ] && \
            rm $SRC_ROOT/target/$TARGET_SUBDIR/driver.o
        [ -f $SRC_ROOT/target/$TARGET_SUBDIR/libavian.zip ] && \
            rm $SRC_ROOT/target/$TARGET_SUBDIR/libavian.zip
        [ -f $SRC_ROOT/avian/build/$TARGET_SUBDIR ] && \
            rm -rf $SRC_ROOT/avian/build/$TARGET_SUBDIR
    fi
}

_clean_sdl () {
    [ -d "$SRC_ROOT/SDL/build" ] && \
        chown -R $USER $SRC_ROOT/SDL/build

    if [ "$TARGET_SUBDIR" = "all" ]; then
        [ -d $SRC_ROOT/target ] && \
            find $SRC_ROOT/target -maxdepth 2 -name 'libSDL2.a' -delete
        rm -rf $SRC_ROOT/SDL/build/*
        __git_clean $SRC_ROOT/SDL
    else
        [ -f $SRC_ROOT/target/$TARGET_SUBDIR/libSDL2.a ] && \
            rm $SRC_ROOT/target/$TARGET_SUBDIR/libSDL2.a
        [ -d $SRC_ROOT/SDL/build/$TARGET_SUBDIR ] && \
            rm -rf $SRC_ROOT/SDL/build/$TARGET_SUBDIR
    fi
}

_clean_skia () {
    [ -d "$SRC_ROOT/skia/out" ] && \
        chown -R $USER $SRC_ROOT/skia/out

    if [[ "$TARGET_SUBDIR" == "all" ]]; then
        if [ -d $SRC_ROOT/target ]; then
            find $SRC_ROOT/target -maxdepth 2 -name 'libskia.a' -delete
            find $SRC_ROOT/target -maxdepth 2 -name skia_*_build_manifest.txt -delete
        fi
        rm -rf $SRC_ROOT/skia/out/*
        __git_clean $SRC_ROOT/skia
    else
        [ -f $SRC_ROOT/target/$TARGET_SUBDIR/libskia.a ] && \
            rm  $SRC_ROOT/target/$TARGET_SUBDIR/libskia.a
        [ -f $SRC_ROOT/target/$TARGET_SUBDIR/skia_*_build_manifest.txt ] && \
            rm  $SRC_ROOT/target/$TARGET_SUBDIR/skia_*_build_manifest.txt
        [ -d $SRC_ROOT/skia/out/$TARGET_SUBDIR ] && \
            rm -rf $SRC_ROOT/skia/out/$TARGET_SUBDIR
    fi
}

_clean () {
    [ -d "$SRC_ROOT/target" ] && \
        chown -R $USER $SRC_ROOT/target
    __msg_warn "Cleaning TARGET:[$TARGET_DIR] SUB_TARGET:[$TARGET_SUBDIR]"
    case $TARGET_DIR in

    avian)
        _clean_avian
    ;;

    sdl)
        _clean_sdl
    ;;

    skia)
        _clean_skia
    ;;

    all)
        _clean_avian
        _clean_sdl
        _clean_skia
    ;;

    *)
        echo "Unsupported target for 'clean' operation."
        exit 1
    ;;
    esac

}

while [[ $# -gt 0 ]] ; do
    case $1 in
    -h|--help)
        __msg_info "$USAGE"
        exit 0
        ;;
    -b|--build)
        TARGET_CMD=_build
        shift
        ;;
    -c|--clean)
        TARGET_CMD=_clean
        shift
        [ $# -ge 2 ] && TARGET_DIR=$1 && shift && \
        [ $# -eq 1 ] && TARGET_SUBDIR=$1 && shift
        ;;
    -o|--os)
        if [ -n $2 ]; then
         TARGET_OS=$2
         shift
         shift
        else
            __msg_error "Please provide parameter for '-o|--os"
        fi
        ;;
    -m|--machine)
        if [ -n $2 ]; then
         TARGET_ARCH=$2
         shift
         shift
        else
            __msg_error "Please provide parameter for '-m|--machine"
        fi
        ;;
    *)
        __msg_error "Unknown parameter: $1"
        ;;
    esac
done


if [[ $TARGET_CMD == "" ]]; then
    __msg_warn "$USAGE"
    __msg_error "No command provided!"
else
    __msg_info "Executing $TARGET_CMD"
    $TARGET_CMD
fi
