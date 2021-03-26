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
TOOLS_DIR="$SRC_ROOT/target/common/bin"
LD_LINKER_SRC="${SRC_ROOT}/aroma-ld-linker"
LD_LINKER_ZIP="${LD_LINKER_SRC}.tar.bz2"
CYGWIN_LINKER_SRC="${SRC_ROOT}/aroma-cygwin-linker"
AROMA_LINKER_HOST_TRIPLE=""
AROMA_LINKER_TARGET_TRIPLE=""
CMD=""

_source_cygwin_check() {
    if [ ! -d $CYGWIN_LINKER_SRC ]; then
        cd $SRC_ROOT
        git clone --depth 1 https://github.com/cygwin/cygwin.git -b cygwin-3_1_7-release
        mv cygwin $CYGWIN_LINKER_SRC
    fi
}

_source_ld_check() {
    if [ ! -d $LD_LINKER_SRC ]; then
        if [ ! -f $LD_LINKER_ZIP ]; then
            wget -O $LD_LINKER_ZIP https://ftp.gnu.org/gnu/binutils/binutils-2.36.1.tar.bz2
        fi
        tar -xvf $LD_LINKER_ZIP --one-top-level=$LD_LINKER_SRC --strip-components 1
    fi
}

_clean() {
    local LINKER_BUILD_DIR="$LD_LINKER_SRC/build/${1}__${2}"
    local TOOLS_DIR_INSTALL="$TOOLS_DIR/${1}__${2}"
    __msg_warn "Deleting $LINKER_BUILD_DIR"
    rm -rf $LINKER_BUILD_DIR
    __msg_warn "Deleting $TOOLS_DIR_INSTALL"
    rm -rf $TOOLS_DIR_INSTALL
}

_build() {

    local PREFIX_BIN="aroma-"
    local IS_GNU=true
    if [[ "$1" == *"linux"* ]]; then
        PREFIX_BIN="${PREFIX_BIN}gnu-"
        LINKER_SRC=$LD_LINKER_SRC
    elif [[ "$1" == *"w64"* || "$1" == *"w32"* ]]; then
        SUFFIX_BIN=".exe"
        PREFIX_BIN="${PREFIX_BIN}cygwin-"
        LINKER_SRC=$CYGWIN_LINKER_SRC
        IS_GNU=false
    else
        __msg_error "host system is not supported: %1"
    fi

    local PREFIX_DIR="/user"
    local LINKER_BUILD_DIR="$LINKER_SRC/build/${1}__${2}"
    local LINKER_DIR_TEMP="$LINKER_BUILD_DIR/install"
    local LINKER_BIN_TEMP="$LINKER_DIR_TEMP${PREFIX_DIR}/bin/${PREFIX_BIN}ld${SUFFIX_BIN}"
    local TOOLS_DIR_INSTALL="$TOOLS_DIR/${1}__${2}"
    local LINKER_BIN_INSTALL="$TOOLS_DIR_INSTALL/${PREFIX_BIN}ld${SUFFIX_BIN}"
    local AR_BIN_TEMP="$LINKER_DIR_TEMP/${PREFIX_DIR}/bin/${PREFIX_BIN}ar${SUFFIX_BIN}"
    local AR_BIN_INSTALL="$TOOLS_DIR_INSTALL/${PREFIX_BIN}ar${SUFFIX_BIN}"
    if [ ! -f LINKER_BIN_INSTALL ]; then
        if [ ! -f $LINKER_BIN_TEMP ]; then
            if [ "$IS_GNU" = true ]; then
                _source_ld_check
                [ -d $LINKER_BUILD_DIR ] && \
                    rm -rf $LINKER_BUILD_DIR
                mkdir -p $LINKER_BUILD_DIR
                cd $LINKER_BUILD_DIR
                $LINKER_SRC/configure \
                --host=$AROMA_LINKER_HOST_TRIPLE \
                --target=$AROMA_LINKER_TARGET_TRIPLE \
                --program-prefix=$PREFIX_BIN \
                --prefix=$PREFIX_DIR \
                --enable-ld=yes \
                --with-static-standard-libraries
            else
                _source_cygwin_check
                [ -d $LINKER_BUILD_DIR ] && \
                    rm -rf $LINKER_BUILD_DIR
                mkdir -p $LINKER_BUILD_DIR
                cd $LINKER_BUILD_DIR
                $LINKER_SRC/configure \
                --host=$AROMA_LINKER_HOST_TRIPLE \
                --target=$AROMA_LINKER_TARGET_TRIPLE \
                --program-prefix=$PREFIX_BIN \
                --prefix=$PREFIX_DIR \
                --enable-ld=yes
            fi
            make -j $NUM_PROC
            mkdir -p $LINKER_DIR_TEMP
            DESTDIR=$LINKER_DIR_TEMP make install
        fi
        mkdir -p $TOOLS_DIR_INSTALL
        cp $LINKER_BIN_TEMP $TOOLS_DIR_INSTALL
        cp $AR_BIN_TEMP $TOOLS_DIR_INSTALL
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
            TOOLS_DIR="$2"
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
