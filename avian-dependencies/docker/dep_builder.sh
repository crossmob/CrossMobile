#!/usr/bin/env bash

set -e

USAGE="./dep_builder.sh $SRC_ROOT $BUILD_OS $BUILD_ARCH $BUILD_MODE"

BUILD_OS=${2:-$(uname -s | tr '[:upper:]' '[:lower:]')}
BUILD_ARCH=${3:-$(uname -m)}
BUILD_MODE=${4:-release}
NUM_PROC=$(nproc)

DIR_SYSROOT=/
CXX=g++
CC=gcc
IS_ARMV7=false

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
NC='\033[0m'

__msg_error() {
    echo -e "${RED}$1${NC}"
    exit 1
}

__msg_warn() {
    echo -e "${YELLOW}$1${NC}"
}

__msg_info() {
    echo -e "${GREEN}$1${NC}"
}

case $BUILD_ARCH in

arm|armhf)
    BUILD_AARCH="armhf"
    BUILD_ARCH="arm"
    CROSS_PREFIX="arm-linux-gnueabihf"
    SKIA_ARCH="armv7-a"
    SKIA_CPU="arm"
    SKIA_PLAT="armv7a-linux-gnueabihf"
    IS_ARMV7=true
;;
arm64|aarch64)
    BUILD_AARCH="aarch64"
    CROSS_PREFIX="aarch64-linux-gnu"
    SKIA_ARCH="armv8-a"
    SKIA_CPU="arm64"
    SKIA_PLAT="aarch64-linux-gnu"
;;
x86_64|amd64|x64)
    BUILD_ARCH="x86_64"
    BUILD_AARCH="x64"
    CROSS_PREFIX="x86_64-linux-gnu"
    SKIA_ARCH="x64"
    SKIA_CPU="x64"
    SKIA_PLAT="x86_64-linux-gnu"
;;
*)
    __msg_error "The '${BUILD_ARCH}' architecture is not supported!"
esac

DIR_CROSS_LIBS="/usr/lib/$CROSS_PREFIX"
DIR_ROOT_CROSS_LIBS="/lib/$CROSS_PREFIX"

if [[ $BUILD_ARCH != "$(uname -m)" ]]; then
    __msg_info "Cross compiling for $BUILD_ARCH"

    export ARCH=$BUILD_ARCH
    export CROSS_COMPILE="$CROSS_PREFIX-"
    export CC="$CROSS_PREFIX-gcc"
    export NM="$CROSS_PREFIX-nm"
    export LD="$CROSS_PREFIX-ld"
    export CXX="$CROSS_PREFIX-g++"
    export RANLIB="$CROSS_PREFIX-ranlib"
    export AR="$CROSS_PREFIX-ar"
    DIR_CROSS_INC="/usr/include/$CROSS_PREFIX"
    DIR_CROSS_INC_STD="$DIR_CROSS_INC/c++/8"
    export LD_LIBRARY_PATH=$DIR_CROSS_LIBS
    export LDFLAGS="-L$DIR_CROSS_LIBS -pie"
    export PKG_CONFIG_PATH="$PKG_CONFIG_PATH $DIR_CROSS_LIBS/pkgconfig"
fi

SKIA_DEBUG="is_debug=false"

if [ $BUILD_MODE == "debug" ]; then
    AVIAN_BUILD_MODE="debug"
    BUILD_EXP=$BUILD_EXP#-"debug"
    BUILD_IS_DEBUG=true
    SKIA_DEBUG="is_debug=true"
    export CFLAGS="$CFLAGS -ggdb"
    export CXXFLAGS="$CXXFLAGS -ggdb"
else
    AVIAN_BUILD_MODE="fast"
fi

#TODO: Check src root if it is valid dir
DIR_SRC_ROOT=${1:-"$(dirname "$(realpath "$0")")/.."}
BUILD_EXP="$BUILD_OS-$BUILD_ARCH"
DIR_LIBS="$DIR_SRC_ROOT/target/$BUILD_EXP"
DIR_3RD="$DIR_SRC_ROOT"
DIR_COMMON="$DIR_SRC_ROOT/target/all"


echo -e "Start building dependencies for: $GREEN$BUILD_EXP$NC"
mkdir -p $DIR_LIBS
mkdir -p $DIR_COMMON





#-----------------Avian build---------------------
DIR_AVIAN_SRC="$DIR_3RD/avian"
AVIAN_ZIP="libavian.zip"
AVIAN_JAR="classpath.jar"
AVIAN_INSTALL_ZIP="$DIR_LIBS/$AVIAN_ZIP"
AVIAN_INSTALL_JAR="$DIR_COMMON/$AVIAN_JAR"

DIR_AVIAN_BUILD="$DIR_AVIAN_SRC/build/$BUILD_OS-$BUILD_ARCH"
AVIAN_BUILD_ARC="$DIR_AVIAN_BUILD/libavian.a"
AVIAN_BUILD_JAR="$DIR_AVIAN_BUILD/$AVIAN_JAR"

if [[ ! -f $AVIAN_INSTALL_ZIP || ! -f $AVIAN_INSTALL_JAR ]]; then
    if [[ ! -f $AVIAN_BUILD_ARC || ! -f $AVIAN_BUILD_JAR ]]; then
        __msg_info "Building Avian ..."
        cd $DIR_AVIAN_SRC
        rm -rf $DIR_AVIAN_BUILD
        make \
        -j ${NUM_PROC} \
        platform=$BUILD_OS \
        arch=$BUILD_ARCH

        if [ -f $AVIAN_BUILD_ARC ]; then
            cd $DIR_AVIAN_BUILD
            rm -rf extracted_files
            mkdir extracted_files
            cd extracted_files
            ar x $AVIAN_BUILD_ARC
            zip $AVIAN_INSTALL_ZIP *.o

            cp $AVIAN_BUILD_JAR $DIR_COMMON
            mkdir -p $DIR_COMMON/linux-x86_64
            cp $DIR_AVIAN_BUILD/binaryToObject/binaryToObject $DIR_COMMON/linux-x86_64/binaryToObject
        else
            __msg_error "libavian.a is not available!"
        fi
    fi
fi

#------------------SDL2 build---------------------
DIR_SDL_SRC="$DIR_3RD/SDL"
DIR_SDL_BUILD="$DIR_SDL_SRC/build/$BUILD_EXP"
SDL_ARC="$DIR_LIBS/libSDL2.a"

if [ ! -f $SDL_ARC ] ; then
    if [ ! -f $DIR_SDL_BUILD/libSDL2.a ]; then
        __msg_info "Building SDL2 ..."

        if [ -d $DIR_SDL_BUILD ]; then
            rm -rf $DIR_SDL_BUILD/*
        else
            mkdir -p $DIR_SDL_BUILD
        fi

        if [ -n "$CROSS_COMPILE" ]; then
            AVIAN_CROSS_FLAGS="--host=${CROSS_PREFIX} --target=${CROSS_PREFIX}"
            if [[ "$BUILD_ARCH" == "arm64" || "$BUILD_ARCH" == "arm" ]]; then
                AVIAN_CROSS_FLAGS="$AVIAN_CROSS_FLAGS --enable-arm-neon"
            fi
        fi

        cd $DIR_SDL_BUILD
        CC="$CC -I/usr/include -I$DIR_CROSS_INC -L$DIR_CROSS_LIBS" \
        $DIR_SDL_SRC/configure \
        --disable-audio \
        --enable-video-wayland=yes \
        --enable-wayland-shared=yes \
        --enable-video-vivante \
        --disable-shared \
        --enable-static \
        $AVIAN_CROSS_FLAGS

        make -j $NUM_PROC
        mkdir -p $DIR_SDL_BUILD/install
        DESTDIR=$DIR_SDL_BUILD/install make install
        cd $DIR_SRC_ROOT
    fi
    cp $DIR_SDL_BUILD/install/usr/local/lib/libSDL2.a $DIR_LIBS
fi

#------------------Skia build---------------------
DIR_SKIA_SRC="$DIR_3RD/skia"
DIR_SKIA_OUT="out/$BUILD_EXP"
DIR_SKIA_BUILD="$DIR_SKIA_SRC/$DIR_SKIA_OUT"
DIR_DEPTOOL_BIN="$DIR_SKIA_SRC/depot_tools"
SKIA_ARC="$DIR_LIBS/libskia.a"
SKIA_VER="chrome/m87"

if [ ! -f $SKIA_ARC ] ; then
    if [ ! -f "$DIR_SKIA_BUILD/libskia.a" ]; then
        __msg_info "Building SKIA ..."
        cd $DIR_SKIA_SRC
        python tools/git-sync-deps
        rm -rf $DIR_SKIA_BUILD

        SKIA_OPTIONS_ENABLED="
            skia_use_gl = true
            skia_use_egl = true
            skia_use_zlib = true
            skia_use_system_zlib = false
            skia_use_fontconfig = true
            skia_use_freetype = true
            skia_use_system_freetype2 = false
            skia_enable_skvm_jit_when_possible = true
            skia_enable_ccpr = true
            skia_enable_nvpr = true
            skia_use_opencl = true
            skia_use_libjpeg_turbo_decode = true
            skia_use_libjpeg_turbo_encode = true
            skia_use_libpng_decode = true
            skia_use_libpng_encode = true
            skia_use_system_libpng = $IS_ARMV7
            skia_use_system_libjpeg_turbo = $IS_ARMV7
        "

        SKIA_OPTIONS_DISABLED="
            skia_build_fuzzers = false
            skia_use_libgifcodec = false
            skia_use_libwebp_decode = false
            skia_use_libwebp_encode = false
            skia_use_expat = false
            skia_use_harfbuzz = false
            skia_use_x11 = false
            skia_use_piex = false
            skia_use_icu = false
            skia_use_xps = false
            skia_use_libfuzzer_defaults = false
            skia_enable_pdf = false
            skia_enable_tools = false
            skia_enable_skottie = false
            skia_enable_android_utils = false
            skia_enable_fontmgr_android = false
            skia_enable_skrive = false
            skia_enable_skshaper = false
            skia_enable_particles = false
            skia_enable_skparagraph = false
            skia_enable_fontmgr_fontconfig=false
        "

        bin/gn gen $DIR_SKIA_OUT  --args='
            target_os="'"${BUILD_OS}"'"
            target_cpu="'"${SKIA_CPU}"'"
            cc = "clang"
            cxx = "clang++"
            extra_asmflags=[
                "'"--target=${SKIA_PLAT}"'",
                "'"-march=${SKIA_ARCH}"'"
            ]
            extra_cflags=[
                "'"--target=${SKIA_PLAT}"'",
                "'"-I${DIR_CROSS_INC}"'",
                "'"-I${DIR_CROSS_INC_STD}"'",
                "-DMESA_EGL_NO_X11_HEADERS"
            ]
            extra_ldflags=[
                "'"--target=${SKIA_PLAT}"'",
                "'"-L${DIR_CROSS_LIBS}"'"
            ]
            is_official_build=true
            is_component_build=false
            '"${SKIA_DEBUG}"'
            '"${SKIA_OPTIONS_ENABLED}"'
            '"${SKIA_OPTIONS_DISABLED}"'
            '

        ninja -C $DIR_SKIA_BUILD -j $NUM_PROC
        bin/gn args $DIR_SKIA_OUT --list --short > $DIR_LIBS/"skia_${BUILD_EXP}_build_manifest.txt"
    fi
    cp $DIR_SKIA_BUILD/libskia.a $DIR_LIBS
fi

DIR_SRC_DRIVER="$DIR_SRC_ROOT/avian-driver/embedded-jar-main.cpp"

$CXX -I$JAVA_HOME/include -I$JAVA_HOME/include/$BUILD_OS -c $DIR_SRC_DRIVER -o $DIR_LIBS/driver.o


OBJ_USR_TARGET=("Scrt1.o" "crti.o" "crtn.o" "libc_nonshared.a")
for obj in ${OBJ_USR_TARGET[@]}; do
    cp "$DIR_CROSS_LIBS/$obj" "$DIR_LIBS"
done

DIR_LIB_GCC_TARGET="/usr/lib/gcc/$CROSS_PREFIX/8"
OBJ_GCC_TARGET=("crtbeginS.o" "crtendS.o" "libgcc.a" "libstdc++.so")
for obj in ${OBJ_GCC_TARGET[@]}; do
    cp "$DIR_LIB_GCC_TARGET/$obj" "$DIR_LIBS"
done

declare -Ar SYS_LIBS=( \
    [libld.so]=ld-2.28.so \
    [libdl.so]=libdl-2.28.so \
    [libz.so]=libz.so.1.2.11 \
    [libm.so]=libm-2.28.so \
    [libc.so]=libc-2.28.so \
    [libpthread.so]=libpthread-2.28.so \
    [libgcc_s.so]=libgcc_s.so.1 \
)

for slib in ${!SYS_LIBS[@]}; do
    cp $DIR_ROOT_CROSS_LIBS/${SYS_LIBS[$slib]} $DIR_LIBS/$slib
done

cp $DIR_CROSS_LIBS/libfontconfig.so.1.12.0 $DIR_LIBS/libfontconfig.so
