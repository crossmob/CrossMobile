#!/bin/bash

VERSION=$1
LONGVERSION=$2

if [[ -z ${VERSION} || -z ${LONGVERSION} ]] ; then
    echo Usage: update-version.sh VERSION LONGVERSION
    exit -1
fi

if [[ -z `which xmlstarlet` ]] ; then
    echo xmlstarlet not installed
    exit -1
fi

echo "Version will change to '$VERSION' and long version to '$LONGVERSION'."
echo -n "Press [RETURN] to accept..."
read WAIT

mvn versions:set -DnewVersion="$VERSION" -DgenerateBackupPoms=false

xmlstarlet ed -P -L -u "/_:project/_:properties/_:crossmobile.version" -v "$VERSION" pom.xml
xmlstarlet ed -P -L -u "/_:project/_:properties/_:long.version" -v "$LONGVERSION" pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmutils/cmutils-tools/src/main/resources/templates/pom_xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-button/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-camera/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-empty/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-i18n/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-map/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-navigation/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-single/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-storyboard/src/main/resources/archetype-resources/pom.xml
xmlstarlet ed -P -L -u "/_:project/_:parent/_:version" -v "$VERSION" cmarchetypes/cmarchetype-table/src/main/resources/archetype-resources/pom.xml
