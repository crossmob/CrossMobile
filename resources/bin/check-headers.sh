#!/bin/bash

cd $(dirname $0)/../..
mvn clean
clear

for i in `find . -name *.java | grep -v './cmioslayer/src/main/java/org/crossmobile/support/cassowary' | grep -v '/__artifactId__/' | grep -v '^./cmioslayer/src/main/java/org/crossmobile/backend/android/billing' | grep -v '^./cmutils/cmutils-common/src/main/java/org/robovm/objc/block' | grep -v '^./cmbuild/cmplugin-maven-plugin/src/main/java/org/crossmobile/plugin/parser/antlr' | grep -v './cmutils/cmutils-tools/src/main/java/org/crossmobile/utils/StringEscapeUtilsTrimmed.java' | grep -v '^./cmbuild/cmbuild-maven-plugin/src/main/java/org/crossmobile/build/antlr' | grep -v '^./cmbuild/cmbuild-android-extra/src/main/java/org/crossmobile/backend/android' | grep -v '^./cmioslayer/src/main/java/org/crossmobile/backend/android/web/VideoEnabledWeb' | grep -v '^./cmioslayer/src/main/java/org/crossmobile/support/MiGBase64.java' | grep -v '^./cmioslayer/src/main/java/com/android/vending/billing/IInAppBillingService.java' | grep -v '/target/generated-sources/' ` ; do
    q=`grep 'SPDX-License-Identifier' $i`
    if [[ "$q" == "" ]] ; then
        echo ${i}
    fi
done
