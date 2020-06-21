#!/bin/bash

PREFIX=org.crossmobile.ca

PACKAGES="com.onesignal:OneSignal:3.10.6 com.facebook.android:facebook-common:4.42.0  com.facebook.android:facebook-core:4.42.0 androidx.core:core:1.0.2 com.google.firebase:firebase-messaging:19.0.1 com.google.firebase:firebase-iid:19.0.1 com.google.firebase:firebase-common:18.0.0 com.google.android.gms:play-services-base:17.0.0 com.google.android.gms:play-services-tasks:17.0.0 com.google.android.gms:play-services-location:17.0.0 com.google.android.gms:play-services-maps:17.0.0 com.google.android.gms:play-services-basement:17.0.0 androidx.multidex:multidex:2.0.1"


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

make_gradle () {

    cat >build.gradle <<EOF
apply plugin: 'com.android.application'
android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "com.example.myapplication"
        minSdkVersion 16
        targetSdkVersion 28
    }
}
dependencies {
EOF
    for a in $PACKAGES ; do echo >>build.gradle "    implementation '"$a"'" ; done
    cat >>build.gradle <<EOF
}
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.4.1'
    }
}
allprojects {
    repositories {
        google()
        jcenter()
    }
}
EOF
}


### Main

cd `dirname $0`
if [ "$ANDROID_SDK_ROOT" == "" ]; then
    error "ANDROID_SDK_ROOT should be defined first, exiting"
fi

# Accept license
yes | "$ANDROID_SDK_ROOT/tools/bin/sdkmanager" --sdk_root="${ANDROID_SDK_ROOT}" --licenses

# Run demo Android project, afterwards all artifacts should be here
# echo >local.properties "sdk.dir=$ANDROID_SDK_ROOT"
make_gradle
gradle --no-daemon compileDebugSources --warning-mode all --console=plain -g ./cache

for art in $PACKAGES; do
    IFS=':' read -ra PARTS <<< "$art"
    GROUPID=${PARTS[0]}
    ARTID=${PARTS[1]}
    VERS=${PARTS[2]}
    LOC=`find cache/caches/modules-2 -name  $ARTID'*' | grep /$ARTID/ | grep $GROUPID | grep $VERS | grep [aj]ar`
    COUNT=`echo $LOC | wc -w`
    if [ $COUNT -ne 1 ] ; then
        echo $LOC
        error "Unable to locate artifact $art, found $COUNT item(s)"
    fi
    install_arr "$LOC"
done

install "$ANDROID_SDK_ROOT/platforms/android-28/android.jar" $PREFIX.com.google.android android 28

rm -rf cache build local.properties .gradle build.gradle
