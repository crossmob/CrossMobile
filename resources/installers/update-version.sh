#!/bin/bash

VERSION=$1

if [ -z "$VERSION" ] ; then
    echo New version shouild not be empty
    exit -1
fi

if [ -z `which xmlstarlet` ] ; then
    echo xmlstarlet not installed
    exit -1
fi

echo -n "Version will change to '$VERSION'. Press [RETURN] to accept..."
read WAIT

mvn versions:set -DnewVersion="$VERSION" -DgenerateBackupPoms=false

xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmutils/cmutils-tools/src/main/resources/templates/pom_xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-empty/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-navigation/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-sample/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-single/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-storyboard/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:properties/_:crossmobile.version" -v "$VERSION" cmprojects/cmproject-debug/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:properties/_:crossmobile.version" -v "$VERSION" cmprojects/cmproject/pom.xml
xmlstarlet ed -P -L -u  '/repositories/repository[@id="themes"]/plugins/plugin/version' -v "$VERSION" cmutils/cmutils-tools/src/main/resources/plugins/baseplugins.xml
xmlstarlet ed -P -L -u  '/repositories/repository[@id="crossmobile"]/plugins/plugin/version' -v "$VERSION" cmutils/cmutils-tools/src/main/resources/plugins/baseplugins.xml
