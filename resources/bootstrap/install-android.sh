#!/bin/bash

PREFIX=org.crossmobile.ca

PACKAGES="core firebase-messaging firebase-iid firebase-common play-services-base play-services-tasks play-services-location play-services-maps play-services-basement multidex"

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
if [ "$ANDROID_SDK_ROOT" == "" ]; then
    error "ANDROID_SDK_ROOT should be defined first, exiting"
fi

# Accept license
"$ANDROID_SDK_ROOT/tools/bin/sdkmanager" --sdk_root="${ANDROID_SDK_ROOT}" --licenses

# Run demo Android project, afterwards all artifacts should be here
# echo >local.properties "sdk.dir=$ANDROID_SDK_ROOT"
gradle --no-daemon compileDebugSources --warning-mode all -g ./cache

for art in $PACKAGES; do
    LOC=`find cache/caches/modules-2 -name $art'*' | grep /$art/ | grep [aj]ar`
    COUNT=`echo $LOC | wc -w`
    if [ $COUNT -ne 1 ] ; then
        error "Unable to locate artifact $art"
    fi
    install_arr "$LOC"
done

install "$ANDROID_SDK_ROOT/platforms/android-28/android.jar" $PREFIX.com.google.android android 28

rm -rf cache build local.properties .gradle
