#!/usr/bin/env bash

set -e

USAGE='\n\r
Usage: linker_builder.sh [CMD] [TARGET_TRIPLE]|[HOST_TRIPLE]\n
    Parameters:\n
    \t-b | --build\t\tBuild command\n
    \t-c | --clean\t\tClean command\n
    \t-h | --host\t\tLinker host system triple {CPU}-{OS}-{ABI}\n
    \t-t | --target\t\tLinker target system triple {CPU}-{OS}-{ABI}\n
    \t-s | --source\t\tLinker parent directory (third-party)\n
    \t-o | --ouput\t\tLinker install directory\n\r
'

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
NC='\033[0m'

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

NUM_PROC=$(nproc)

#----------------linker--------------------
SRC_ROOT="$(dirname $(realpath "$0"))/.."
INSTALL_HOST_UTIL_DIR="$SRC_ROOT/target/host-utils"
UTIL_GNU_SRC="${SRC_ROOT}/aroma-ld-linker"
UTIL_GNU_ZIP="${UTIL_GNU_SRC}.tar.bz2"
#UTIL_WIN_SRC="${SRC_ROOT}/aroma-cygwin-linker"
UTIL_WIN_SRC="${SRC_ROOT}/mingw-w64"
UTIL_WIN_BRANCH="master"

AROMA_LINKER_HOST_TRIPLE="all"
AROMA_LINKER_TARGET_TRIPLE="all"
CMD=""
GCC_VER="8"

_source_cygwin_check() {
    if [ ! -d $UTIL_WIN_SRC ]; then
        cd $SRC_ROOT
        git clone --depth 1 https://github.com/cygwin/cygwin.git -b $UTIL_WIN_BRANCH
        mv cygwin $UTIL_WIN_SRC
    fi
    cd $UTIL_WIN_SRC
    git checkout $UTIL_WIN_BRANCH
    cd $SRC_ROOT
}

_source_ld_check() {
    if [ ! -d $UTIL_GNU_SRC ]; then
        if [ ! -f $UTIL_GNU_ZIP ]; then
            wget -O $UTIL_GNU_ZIP https://ftp.gnu.org/gnu/binutils/binutils-2.36.1.tar.bz2
        fi
        tar -xvf $UTIL_GNU_ZIP --one-top-level=$UTIL_GNU_SRC --strip-components 1
    fi
}

_clean() {
    HOST_TRIPLE=$1
    TARGET_TRIPLE=$2

    if [ "$HOST_TRIPLE" == "all" ]; then
        HOST_TRIPLE=*
    fi

    if [ "$TARGET_TRIPLE" == "all" ]; then
        TARGET_TRIPLE=*
    fi

    local SUB_DIR=${HOST_TRIPLE}__${TARGET_TRIPLE}
    if [ "$SUB_DIR" == "*__*" ]; then
        SUB_DIR=""
    fi

    local BUILD_DIR="$UTIL_GNU_SRC/build/$SUB_DIR"
    local INSTALL_UTIL_BIN_DIR="$INSTALL_HOST_UTIL_DIR/$SUB_DIR"

    __msg_warn "Deleting $BUILD_DIR"
    rm -rf $BUILD_DIR
    __msg_warn "Deleting $INSTALL_UTIL_BIN_DIR"
    rm -rf $INSTALL_UTIL_BIN_DIR
}

_build() {

    local PREFIX_BIN="aroma-"
    local IS_GNU=true
    local HOST_TRIPLE=$1
    local TARGET_TRIPLE=$2
    local HOST_TRIPLE_LIB=$1

    if [[ "$1" == *"linux"* ]]; then
        PREFIX_BIN="${PREFIX_BIN}gnu-"
        LINKER_SRC=$UTIL_GNU_SRC
    elif [[ "$1" == *"w64"* || "$1" == *"w32"* ]]; then
        SUFFIX_BIN=".exe"
        PREFIX_BIN="${PREFIX_BIN}cygwin-"
        LINKER_SRC=$UTIL_WIN_SRC
        IS_GNU=false
	    HOST_TRIPLE_LIB=i386-linux-gnu
    else
        __msg_error "host system is not supported: $1"
    fi

    local LIB_ROOT="/lib"
    local LIB_ROOT_TARGET="/lib/$HOST_TRIPLE_LIB"
    local LIB_USR="/usr/lib"
    local LIB_USR_TARGET="/usr/lib/$HOST_TRIPLE_LIB"
    local LIB_GCC_TARGET="/usr/lib/gcc/$HOST_TRIPLE_LIB/$GCC_VER"
    local LIB_GCC_CROSS="/usr/lib/gcc-cross/$HOST_TRIPLE_LIB/$GCC_VER"
    local BUILD_DIR="$LINKER_SRC/build/${1}__${2}"
    local TEMP_INSTALL_PREFIX="/user"
    local TEMP_INSTALL_DIR="$BUILD_DIR/install"
    local TEMP_LD_BIN="${TEMP_INSTALL_DIR}${TEMP_INSTALL_PREFIX}/bin/${PREFIX_BIN}ld${SUFFIX_BIN}"
    local TEMP_AR_BIN="${TEMP_INSTALL_DIR}${TEMP_INSTALL_PREFIX}/bin/${PREFIX_BIN}ar${SUFFIX_BIN}"
    local INSTALL_UTIL_BIN_DIR="$INSTALL_HOST_UTIL_DIR/${1}__${2}/bin"
    local INSTALL_UTIL_LIB_DIR="$INSTALL_HOST_UTIL_DIR/${1}__${2}/lib"
    local INSTALL_LD_BIN="$INSTALL_UTIL_BIN_DIR/${PREFIX_BIN}ld${SUFFIX_BIN}"
    local INSTALL_AR_BIN="$INSTALL_UTIL_BIN_DIR/${PREFIX_BIN}ar${SUFFIX_BIN}"

    if [ ! -f $INSTALL_LD_BIN ]; then
        if [ ! -f $TEMP_LD_BIN ]; then
            if [ "$IS_GNU" = true ]; then
                __msg_info "Building GNU Binutils ..."
                _source_ld_check
                [ -d $BUILD_DIR ] && \
                    rm -rf $BUILD_DIR
                mkdir -p $BUILD_DIR
                cd $BUILD_DIR
                $LINKER_SRC/configure \
                --host=$AROMA_LINKER_HOST_TRIPLE \
                --target=$AROMA_LINKER_TARGET_TRIPLE \
                --program-prefix=$PREFIX_BIN \
                --prefix=$TEMP_INSTALL_PREFIX \
                --enable-ld=yes \
                --with-static-standard-libraries

                mkdir -p $INSTALL_UTIL_LIB_DIR
                cp $LIB_USR_TARGET/Scrt1.o $INSTALL_UTIL_LIB_DIR 
                cp $LIB_USR_TARGET/crti.o  $INSTALL_UTIL_LIB_DIR
                cp $LIB_USR_TARGET/crtn.o  $INSTALL_UTIL_LIB_DIR
                cp $LIB_GCC_TARGET/crtbeginS.o  $INSTALL_UTIL_LIB_DIR
                cp $LIB_GCC_TARGET/crtendS.o    $INSTALL_UTIL_LIB_DIR
                cp $LIB_GCC_TARGET/libgcc_s.so  $INSTALL_UTIL_LIB_DIR
                cp $LIB_GCC_TARGET/libstdc++.so $INSTALL_UTIL_LIB_DIR
            else
                __msg_info "building Windows Bintuils ..."
                _source_cygwin_check
                [ -d $BUILD_DIR ] && \
                    rm -rf $BUILD_DIR
                mkdir -p $BUILD_DIR
                cd $BUILD_DIR
                
                CROSS_PREFIX="x86_64-w64-mingw32"
                export CROSS_COMPILE="${CROSS_PREFIX}-"
                export CC="$CROSS_PREFIX-gcc"
                export NM="$CROSS_PREFIX-nm"
                export LD="$CROSS_PREFIX-ld"
                export CXX="$CROSS_PREFIX-g++"
                export RANLIB="$CROSS_PREFIX-ranlib"
                export AR="$CROSS_PREFIX-ar"
                #DIR_CROSS_INC="/usr/include/i386-linux-gnu"
		        DIR_CROSS_INC="/usr/include/arm-linux-gnueabihf"
                DIR_CROSS_INC_STD="$DIR_CROSS_INC/c++/8"
		        #DIR_CROSS_INC_STD_0="/usr/arm-linux-gnueabihf/include"
		        #DIR_CROSS_INC_STD_1="/usr/i686-linux-gnu/include"
                DIR_CROSS_LIBS="/usr/lib/i386-linux-gnu"
                export LD_LIBRARY_PATH="$DIR_CROSS_LIBS:/usr/lib/$2"
                export LDFLAGS="$LDFLAGS -L$DIR_CROSS_LIBS -L/usr/lib$2 -pie"
                export PKG_CONFIG_PATH="$PKG_CONFIG_PATH $DIR_CROSS_LIBS/pkgconfig"
                export CFLAGS="$CFLAGS -I$DIR_CROSS_INC -I$DIR_CROSS_INC_STD -I$DIR_CROSS_INC_STD_0 -I$DIR_CROSS_INC_STD_1"

                $LINKER_SRC/configure \
                --host=$AROMA_LINKER_HOST_TRIPLE \
                --target=$AROMA_LINKER_TARGET_TRIPLE \
                --program-prefix=$PREFIX_BIN \
                --prefix=$TEMP_INSTALL_PREFIX \
                --enable-ld=yes
            fi
            make -j $NUM_PROC
            mkdir -p $TEMP_INSTALL_DIR
            DESTDIR=$TEMP_INSTALL_DIR make install
        fi
        mkdir -p $INSTALL_UTIL_BIN_DIR
        cp $TEMP_LD_BIN $INSTALL_UTIL_BIN_DIR
        cp $TEMP_AR_BIN $INSTALL_UTIL_BIN_DIR
    fi
}

while [[ $# -gt 0 ]] ; do
    case $1 in

    --help)
        __msg_info "$USAGE"
        exit 0
    ;;
    -s|--source)
        if [ -n $2 ]; then
            SRC_DIR="$2"
            shift
            shift
        else
            __msg_error "Please provide third-parthy source directory."
        fi
    ;;
    -o|--output)
        if [ -n $2 ]; then
            INSTALL_HOST_UTIL_DIR="$2"
            shift
            shift
        else
            __msg_error "Please provide output directory."
        fi
    ;;
    -c|--clean)
        CMD=_clean
        shift
    ;;
    -b|--build)
        CMD=_build
        shift
    ;;
    -h|--host)
        if [ -n $2 ]; then
            AROMA_LINKER_HOST_TRIPLE="$2"
            shift
            shift
        else
            __msg_error "Please provide host system triple with '{CPU}-{OS}-{ABI}' template"
        fi
    ;;
    -t|--target)
        if [ -n $2 ]; then
            AROMA_LINKER_TARGET_TRIPLE="$2"
            shift
            shift
        else
            __msg_error "Please provide target system triple with '{CPU}-{OS}-{ABI}' template"
        fi
    ;;
    *)
        __msg_error "Unsupported parameter: $1"
    ;;
    esac
done

$CMD $AROMA_LINKER_HOST_TRIPLE $AROMA_LINKER_TARGET_TRIPLE
