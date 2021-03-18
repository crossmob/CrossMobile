#!/bin/bash
set -e

USAGE="./build $SRC_ROOT $BUILD_OS $BUILD_ARCH $BUILD_MODE"

if [ ! -f "$JAVA_HOME/include/jni.h" ] ; then
    echo "Unable to locate JDK under ${JAVA_HOME}"
    exit 1
fi


BUILD_OS=${2:-$(uname -s | tr '[:upper:]' '[:lower:]')}
BUILD_ARCH=${3:-$(uname -m)}
BUILD_MODE=${4:-release}
AVIAN_BUILD_MODE=${3:-fast}
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'
BUILD_EXP="$BUILD_OS-$BUILD_ARCH"
CXX=g++

if [ $BUILD_MODE == "debug" ]; then
    AVIAN_BUILD_MODE="debug"
    BUILD_EXP=$BUILD_EXP#-"debug"
    BUILD_IS_DEBUG=true
fi

if [ $BUILD_ARCH != "$(uname -m)" ]; then
    echo "Cross compiling for $BUILD_ARCH"
    BUILD_AARCH=$BUILD_ARCH
    if [ $BUILD_ARCH == "arm64" ]; then
        BUILD_AARCH="aarch64"
    fi
    DIR_CROSS_LIBS="/usr/lib/$BUILD_AARCH-linux-gnu"
    CC="$BUILD_AARCH-$BUILD_OS-gnu-gcc"
    CXX="$BUILD_AARCH-$BUILD_OS-gnu-g++"
    LD_LIBRARY_PATH=$DIR_CROSS_LIBS
    LDFLAGS="-L$DIR_CROSS_LIBS -Wl,-rpath=$DIR_CROSS_LIBS"
    CXXFLAGS="-Wl,-rpath=$DIR_CROSS_LIBS"
    CFLAGS="-Wl,-rpath=$DIR_CROSS_LIBS"
    LIBPATH=$DIR_CROSS_LIBS
    BUILD_CROSS_LIBS="$DIR_CROSS_LIBS/*"
    echo "DIR_CROSS_LIBS: $DIR_CROSS_LIBS"
fi

DIR_SRC_ROOT=${1:-$(pwd)}

#TODO: Check src root if it is valid dir

DIR_LIBS="$DIR_SRC_ROOT/target/$BUILD_EXP"
DIR_3RD="$DIR_SRC_ROOT"
DIR_COMMON="$DIR_SRC_ROOT/target/common"
NUM_PROC=$(nproc)

echo -e "Start building: $GREEN$BUILD_EXP$NC"
mkdir -p $DIR_LIBS
mkdir -p $DIR_COMMON

#-----------------Avian build---------------------
DIR_AVIAN_SRC="$DIR_3RD/avian"
#DIR_AVIAN_INC="$DIR_AVIAN_SRC/include"
AVIAN_ZIP="libavian.zip"
AVIAN_JAR="boot.jar"
DIR_AVIAN_ZIP="$DIR_LIBS/$AVIAN_ZIP"
DIR_AVIAN_JAR="$DIR_LIBS/$AVIAN_JAR"

DIR_AVIAN_BUILD="$DIR_AVIAN_SRC/build/$BUILD_OS-$BUILD_ARCH"
AVIAN_BUILD_ARC="$DIR_AVIAN_BUILD/libavian.a"
AVIAN_BUILD_JAR="$DIR_AVIAN_BUILD/classpath.jar"
AVIAN_DESTINATION_JAR="$DIR_COMMON/classpath.jar"

if [[ ! -f $DIR_AVIAN_ZIP || ! -f $DIR_AVIAN_JAR ]]; then
    if [[ ! -f $AVIAN_BUILD_ARC || ! -f $AVIAN_BUILD_JAR ]]; then
        echo -e "${GREEN}Building Avian ...${NC}"
        cd $DIR_AVIAN_SRC
        make clean

        make\
        -j ${NUM_PROC} \
        platform=$BUILD_OS \
        arch=$BUILD_ARCH
    fi

    if [[ ! -f $DIR_AVIAN_ZIP ]] ; then
        cd $DIR_AVIAN_BUILD
        rm -rf extracted_files
        mkdir extracted_files
        cd extracted_files
        ar x $AVIAN_BUILD_ARC
        zip $DIR_AVIAN_ZIP *.o
    fi
fi

if [[ ! -f $AVIAN_DESTINATION_JAR ]]; then
    mkdir -p $DIR_COMMON/bin/linux-x86_64
    cp $AVIAN_BUILD_JAR $AVIAN_DESTINATION_JAR
    cp $DIR_AVIAN_BUILD/binaryToObject/binaryToObject $DIR_COMMON/bin/linux-x86_64/
fi



#------------------SDL2 build---------------------
DIR_SDL_SRC="$DIR_3RD/SDL"
#DIR_SDL_INC="$DIR_SDL_SRC/include"
DIR_SDL_BUILD="$DIR_SDL_SRC/build/$BUILD_EXP"
SDL_ARC="$DIR_LIBS/libSDL2.a"

if [ ! -f $SDL_ARC ] ; then
    if [ ! -f $DIR_SDL_BUILD/libSDL2.a ]; then
        echo -e "${GREEN}Building SDL2 ...${NC}"
        mkdir -p $DIR_SDL_BUILD
        cd $DIR_SDL_BUILD
        cmake $DIR_SDL_SRC \
            -GNinja \
            -DCMAKE_C_COMPILER="$CC" \
            -DCMAKE_CXX_COMPILER="$CXX" \
            -DCMAKE_C_FLAGS="$CFLAGS" \
            -DCMAKE_CXX_FLAGS="$CXXFLAGS" \
            -DCMAKE_EXE_LINKER_FLAGS="$LDFLAGS" \
            -DCMAKE_BUILD_TYPE="$BUILD_MODE" \
            -DSDL_SHARED=0 \
            -DSDL_AUDIO=0 \
            -DVIDEO_WAYLAND=ON \
            -DWAYLAND_SHARED=ON
        ninja -C $DIR_SDL_BUILD -j $NUM_PROC
    fi
    cp $DIR_SDL_BUILD/libSDL2.a $DIR_LIBS
fi

#------------------Skia build---------------------

DIR_SKIA_SRC="$DIR_3RD/skia"
#DIR_SKIA_INC="$DIR_SKIA_SRC"
DIR_SKIA_OUT="out/$BUILD_EXP"
DIR_SKIA_BUILD="$DIR_SKIA_SRC/$DIR_SKIA_OUT"
DIR_DEPTOOL_BIN="$DIR_SKIA_SRC/depot_tools"
SKIA_ARC="$DIR_LIBS/libskia.a"
SKIA_VER="chrome/m87"
if [[ $BUILD_ARCH == "x86_64" ]]; then
    SKIA_ARCH="x64"
    SKIA_CPU="x64"
    SKIA_PLAT="x86_64-linux-gnu"
elif [[ $BUILD_ARCH == "arm64" ]]; then
    SKIA_ARCH="arm64"
    SKIA_CPU="arm64"
    SKIA_PLAT="aarch64-linux-gnu"
elif [[ $BUILD_ARCH == "arm" ]]; then
    SKIA_ARCH="arm"
    SKIA_CPU="arm"
    SKIA_PLAT="arm-linux-gnu"
fi


if [ ! -f $SKIA_ARC ] ; then
    if [ ! -f "$DIR_SKIA_BUILD/libskia.a" ]; then
        echo -e "${GREEN}Building SKIA ...${NC}"
        cd $DIR_SKIA_SRC
        #python tools/git-sync-deps
        rm -rf $DIR_SKIA_BUILD

        SKIA_OPTIONS_ENABLED="
            skia_use_gl = true
            skia_gl_standard = \"gl\"
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
            skia_use_libpng_decode = true
            skia_use_system_libpng = false
            skia_use_system_libjpeg_turbo = false
        "

        SKIA_OPTIONS_DISABLED="
            skia_build_fuzzers = false
            skia_use_libgifcodec = false
            skia_use_libjpeg_turbo_encode = false
            skia_use_libpng_encode = false
            skia_use_libwebp_decode = false
            skia_use_libwebp_encode = false
            skia_use_expat = false
            skia_use_harfbuzz = false
            skia_use_x11 = true
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
            target_os="'"$BUILD_OS"'"
            target_cpu="'"${SKIA_CPU}"'"
            cc = "clang"
            cxx = "clang++"
            extra_asmflags=[
                "'"--target=${SKIA_PLAT}"'",
                "'"--sysroot=${DIR_SYSROOT}"'",
                "'"-march=${SKIA_ARCH}"'"
            ]
            extra_cflags=[
                "'"--target=${SKIA_PLAT}"'",
                "'"--sysroot=${DIR_SYSROOT}"'",
                "'"-I${LIBEGL_INC}"'",
                "'"-I${DIR_SYSROOT}/include/**"'"
            ]
            extra_ldflags=[
                "'"--target=${SKIA_PLAT}"'",
                "'"--sysroot=${DIR_SYSROOT}"'",
                "'"-B${DIR_SYSROOT}/bin"'",
                "'"-L${DIR_SYSROOT}/lib -L$DIR_CROSS_LIBS"'",
                "'"-L${LIBEGL_BIN}"'",
            ]
            is_official_build=true
            is_debug=false
            is_component_build=false
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
