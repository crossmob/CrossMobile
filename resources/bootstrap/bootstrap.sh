#!/bin/bash

PREFIX=private.cm

error () {
    echo "** ERROR **"
    echo $@
    echo
    exit 1
}

install () {
    if [ ! -f "$1" ] ; then
        error "File $1 does not exist, exiting"
    fi
    mvn install:install-file "-Dfile=$1" -DgroupId=$2 -DartifactId=$3 -Dversion=$4 -Dpackaging=jar
}

install_arr () {
    LOC="$1"
    echo "[****] INSTALLING $LOC"
    GROUP=`echo $LOC | awk -F / '{print $(NF-4) }' `
    ARTIFACT=`echo $LOC | awk -F / '{print $(NF-3) }' `
    VERSION=`echo $LOC | awk -F / '{print $(NF-2) }' `
    FILE=`echo $LOC | awk -F / '{print $NF }' `
    if [ -n "`echo $LOC | grep 'aar$'`" ] ; then
        rm -rf temp ; mkdir temp
        unzip -qq "$LOC" -d temp
        install `pwd`/temp/classes.jar $PREFIX.$GROUP $ARTIFACT $VERSION
        rm -rf temp
    else
        install "$LOC" $PREFIX.$GROUP $ARTIFACT $VERSION
    fi
}

### Main

cd `dirname $0`
if [ "$ANDROID_SDK" == "" ]; then
    error "ANDROID_SDK should be defined first, exiting"
fi

# Accept license
"$ANDROID_SDK/tools/bin/sdkmanager" --licenses

# Run demo Android project, afterwards all artifacts should be here
echo >local.properties "sdk.dir=$ANDROID_SDK"
gradle --no-daemon compileDebugSources  -g ./cache

for art in support-v4 support-compat support-annotations play-services-base firebase-messaging play-services-tasks play-services-location play-services-maps play-services-basement firebase-iid firebase-common; do
    LOC=`find cache/caches/modules-2 -name $art'*' | grep /$art/ | grep [aj]ar`
    COUNT=`echo $LOC | wc -l`
    if [ $COUNT -ne 1 ] ; then
        error "Unable to locate artifact $art"
    fi
    install_arr "$LOC"
done

install "$ANDROID_SDK/platforms/android-26/android.jar" $PREFIX.com.google.android android 26

rm -rf cache build local.properties
