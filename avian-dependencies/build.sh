#!/bin/bash
set -e

_init_variables () {
    RED='\033[0;31m'
    GREEN='\033[0;32m'
    YELLOW='\033[0;33m'
    NC='\033[0m'

    # Default parameters
    TARGET_OS=$(uname -s | tr '[:upper:]' '[:lower:]')
    TARGET_ARCH=$(uname -m)
    TARGET_DIR=all

    SRC_ROOT=$(dirname "$(realpath "$0")")
    cd $SRC_ROOT
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

_check_root () {
    if [[ $EUID -eq 0 ]]; then
        __msg_error "This script must not be run as root"
    fi
}

_usage () {
    __msg_info '\n\r
# MODULE=avian,sdl,skia,binutils  (all if no module provided)\n\r
# ARCH=x86_64,arm,arm64\n\r
# OS=linux\n\r
\n\r
Parameters:\n\r
    \t-h|--help\n\r
    \t-c|--clean [MODULE]\n\r
    \t-b|--build [-a ..] [-o ..]\n\r
    \t-a|--arch\n\r
    \t-o|--os OS\n\r
'
}

_check_docker_image() {
    __msg_info "Check for image: \"$1\""
    if [[ "$(docker images -q $1 2> /dev/null)" == "" ]]; then
        return -1 #image doesn't exits
    fi
        return 0 #image exist
}

_check_args () {
    if [[ $TARGET_OS != "linux" ]] ; then __msg_error "OS not recognised: $TARGET_OS" ; fi
    if [[ $TARGET_ARCH != "arm" && $TARGET_ARCH != "arm64" && $TARGET_ARCH != "x86_64" ]] ; then __msg_error "ARCH not recognised: $TARGET_ARCH" ; fi

    if [ "$TARGET_OS" = "linux" ] ; then HOST_TRIPLET=x86_64-linux-gnu   ; HOST_DIRNAME=linux-x86_64 ; DOCKER_IMAGE=aroma/dep-builder-$TARGET_OS-$TARGET_ARCH ; fi
    if [ "$TARGET_OS" = "win" ] ; then HOST_TRIPLET=x86_64-w64-mingw32   ; HOST_DIRNAME=win64-x386   ; DOCKER_IMAGE=aroma/dep-builder-win-i386 ; fi

    if [ "$TARGET_ARCH" = "arm" ] ; then TARGET_TRIPLET=arm-linux-gnueabihf ; TARGET_DIRNAME=linux-arm    ; DEBIAN_ARCH=armhf ; fi
    if [ "$TARGET_ARCH" = "arm64" ] ; then TARGET_TRIPLET=aarch64-linux-gnu ; TARGET_DIRNAME=linux-arm64  ; DEBIAN_ARCH=aarch64 ; fi
    if [ "$TARGET_ARCH" = "x86_64" ] ; then TARGET_TRIPLET=x86_64-linux-gnu ; TARGET_DIRNAME=linux-x86_64 ; DEBIAN_ARCH=x86_64 ; fi
}

# temporary hack to install avian dependencies user-wide
_install () {
    DEST=~/.cache/crossmobile/avian/0.1
    rm -rf $DEST
    mkdir -p $DEST
    cp -r target/* $DEST
}


_build () {
    if [[ "$(_check_docker_image $DOCKER_IMAGE)" != "0" ]]; then
        __msg_info "Building \"$DOCKER_IMAGE\" builder image"
        docker build -t $DOCKER_IMAGE docker/ --build-arg ARCH=$TARGET_ARCH --build-arg OS=$TARGET_OS
    fi

    # if [[ "$(_check_docker_image $IMAGE_WIN)" != "0" ]]; then
    #     __msg_info "Building windows host utils builder"
    #     docker build -t $IMAGE_WIN docker/ --build-arg ARCH=i386 --build-arg OS=win
    # fi

    # Build binutils
    __msg_info "Building host utils for '$HOST_TRIPLET' host and '$TARGET_TRIPLET' target"
    docker run --rm -it -v ${SRC_ROOT}:/src $DOCKER_IMAGE \
        bash "/src/scripts/host_utils_builder.sh" \
        -h $HOST_TRIPLET \
        -t $TARGET_TRIPLET \
        -hd $HOST_DIRNAME \
        -td $TARGET_DIRNAME

    __msg_info "Running \"$DOCKER_IMAGE\" to build dependencies for OS: $TARGET_OS ARCH: $TARGET_ARCH target"
    docker run --rm -it -v ${SRC_ROOT}:/src $DOCKER_IMAGE \
        bash /src/docker/dep_builder.sh \
        /src $TARGET_OS $TARGET_ARCH release

    #sudo chown -R $USER:$USER .
    _install
}

_clean_avian () {
    __msg_warn "Cleaning avian"
    (cd $SRC_ROOT/avian ; make clean)
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name libavian.zip -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name driver.o -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 3 -name binaryToObject -delete
    rm -f $SRC_ROOT/target/all/classpath.jar
}

_clean_sdl () {
    __msg_warn "Cleaning SDL"
    rm -rf $SRC_ROOT/SDL/build
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name 'libSDL2.a' -delete
}

_clean_binutils () {
    __msg_warn "Cleaning binutils"
    rm -rf $SRC_ROOT/aroma-ld-linker/build
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name crtbeginS.o -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name crtendS.o -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name crti.o -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name crtn.o -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name Scrt1.o -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name libgcc_s.so -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name libstdc++.so -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name libgcc.a -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 3 -name 'ld' -delete
}

_clean_skia () {
    __msg_warn "Cleaning Skia"
    rm -rf $SRC_ROOT/skia/out
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name 'libskia.a' -delete
    [ -d $SRC_ROOT/target ] && find $SRC_ROOT/target -maxdepth 2 -name skia_*_build_manifest.txt -delete
}

_clean () {
    case $TARGET_DIR in
    avian)
        _clean_avian
    ;;

    sdl)
        _clean_sdl
    ;;

    binutils)
        _clean_binutils
    ;;

    skia)
        _clean_skia
    ;;

    all)
        _clean_avian
        _clean_sdl
        _clean_skia
        _clean_binutils

    ;;

    *) 
        __msg_error "Unsupported target for clean operation"
    ;;
    esac
    [ -d $SRC_ROOT ] && find $SRC_ROOT -type d -empty -delete
}



#############################
#  Main script starts here  #
#############################

_init_variables
_check_root

while [[ $# -gt 0 ]] ; do
    case $1 in
    -h|--help)
        _usage
        exit 0
        ;;
    -b|build)
        TARGET_CMD=build
        shift
        ;;
    -c|clean)
        TARGET_CMD=clean
        shift
        [ $# -ge 1 ] && TARGET_DIR=$1 && shift
        ;;
    -o|--os)
        if [ $# -ge 2 ]; then
            TARGET_OS=$2
            shift
            shift
        else
            __msg_error "Please provide parameter for '-o|--os"
        fi
        ;;
    -a|--arch)
        if [ $# -ge 2 ]; then
            TARGET_ARCH=$2
            shift
            shift
        else
            __msg_error "Please provide parameter for '-a|--arch"
        fi
        ;;
    *)
        __msg_error "Unknown parameter: $1"
        ;;
    esac
done

_check_args


if [[ $TARGET_CMD == "" ]]; then
    _usage
    __msg_error "No command provided!"
else
    __msg_info "Executing $TARGET_CMD"
    _$TARGET_CMD
fi
