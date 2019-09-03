#!/bin/bash

install () {
    if [ ! -f "$1" ] ; then
        error "File $1 does not exist, exiting"
    fi
    mvn install:install-file "-Dfile=$1" -DgroupId=$2 -DartifactId=$3 -Dversion=$4 -Dpackaging=jar
}

cd `dirname $0`
cmioslayer=`pwd`/../../cmioslayer
incdest=$cmioslayer/src/main/objc/cmioslayer
libdest=$cmioslayer/lib/main/vendor/cmioslayer

if [ ! -f libffi/generate-darwin-source-and-headers.py ] ; then git clone https://github.com/crossmob/libffi.git ; fi
pushd >/dev/null libffi
if [ ! -f configure ] ; then ./autogen.sh ; fi
if [ ! -f build_iphoneos-arm64/Makefile ] ; then ./generate-darwin-source-and-headers.py --only-ios ; fi
for i in build_* ; do 
    arch=`echo $i|sed -e 's/build_//'|sed -e 's/.*-//g'`
    cd $i
    make
    sed -e "s/<ffitarget.h>/\"${arch}_ffitarget.h\"/g" <include/ffi.h  >$incdest/${arch}_ffi.h
    cp include/ffitarget.h $incdest/${arch}_ffitarget.h
    cp .libs/libffi.a $libdest/${arch}_libffi.a
    cd ..
done
popd >/dev/null
pushd >/dev/null $libdest
lipo -create -output ffi.a *_libffi.a
rm *_libffi.a
popd >/dev/null
cat >$incdest/ffi.h <<EOF
#if TARGET_OS_SIMULATOR
#   if TARGET_CPU_X86_64
#       include "x86_64_ffi.h"
#   else
#       include "i386_ffi.h"
#   endif
#else
#   if TARGET_CPU_ARM64
#       include "arm64_ffi.h"
#   else
#       include "armv7_ffi.h"
#   endif
#endif
EOF
rm -rf libffi
