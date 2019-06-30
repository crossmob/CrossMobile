#!/bin/bash

for i in `find . -name *.java | grep -v './cmioslayer/src/main/java/org/crossmobile/support/cassowary' | grep -v '/__artifactId__/' | grep -v '^./cmioslayer/src/main/java/org/crossmobile/backend/android/billing' | grep -v '^./cmutils/cmutils-common/src/main/java/org/robovm/objc/block' | grep -v '^./cmbuild/cmbuild-plugins/src/main/java/org/crossmobile/plugin/parser/antlr' | grep -v './cmutils/cmutils-tools/src/main/java/org/crossmobile/utils/StringEscapeUtilsTrimmed.java' | grep -v '^./cmbuild/cmbuild-maven-plugin/src/main/java/org/crossmobile/build/antlr' | grep -v '^./cmbuild/cmbuild-android-extra/src/main/java/org/crossmobile/backend/android' | grep -v '^./cmioslayer/src/main/java/org/crossmobile/backend/android/web/VideoEnabledWeb' | grep -v '^./cmioslayer/src/main/java/org/crossmobile/support/MiGBase64.java' | grep -v '^./cmioslayer/src/main/java/com/android/vending/billing/IInAppBillingService.java'` ; do
    q=`grep 'it under the terms of the CrossMobile Community License as published' $i`
    if [ "$q" == "" ] ; then
        echo $i
    fi
done
