#!/bin/bash

DEPLOY=

VERSION=29
SDK=10
SDK_FULL=$SDK.0.0_r36


set -e
OUT=/tmp/crossmobile.temp.android
rm -rf $OUT && mkdir $OUT
curl https://android-rebuilds.beuc.net/dl/repository/sdk-repo-linux-platforms-eng.$SDK_FULL.zip -o $OUT/sdk.zip
unzip -o -j $OUT/sdk.zip -d $OUT
mvn install:install-file -Dfile=$OUT/android.jar -DgroupId=org.crossmobile.ca.com.google.android -DartifactId=android -Dversion=$VERSION -Dpackaging=jar

cd $(dirname $0) && cd ../../cmioslayer
if [ $DEPLOY ] ; then 
    mvn deploy:deploy-file -DgroupId=org.crossmobile.ca.com.google.android -DartifactId=android -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar -DrepositoryId=crossmobile -Durl=http://mvn.crossmobile.org/content/repositories/crossmobile -Dfile=$OUT/android.jar
fi
rm -rf $OUT

if [ $DEPLOY ] ; then ALSO_DEPLOY="-DrepositoryId=crossmobile -DrepositoryUrl=http://mvn.crossmobile.org/content/repositories/crossmobile" ; else ALSO_DEPLOY= ; fi

mvn com.panayotis:unaar:0.2:unaar "-Dartifacts=androidx.fragment:fragment:aar:1.2.5;com.onesignal:OneSignal:aar:3.10.6;com.facebook.android:facebook-common:aar:7.0.1;com.facebook.android:facebook-core:aar:7.0.1;androidx.core:core:aar:1.3.0;com.google.firebase:firebase-messaging:aar:19.0.1;com.google.firebase:firebase-iid:aar:19.0.1;com.google.firebase:firebase-common:aar:18.0.0;com.google.android.gms:play-services-base:aar:17.0.0;com.google.android.gms:play-services-tasks:aar:17.0.0;com.google.android.gms:play-services-location:aar:17.0.0;com.google.android.gms:play-services-maps:aar:17.0.0;com.google.android.gms:play-services-basement:aar:17.0.0;androidx.multidex:multidex:aar:2.0.1" -DshadowGroup=org.crossmobile.ca $ALSO_DEPLOY
