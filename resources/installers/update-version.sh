#!/bin/bash

cd `dirname $0`
cd ../..


RV=`hg tip | grep changeset | awk -F : '{print $2}' | tr -d '[ ]'`
echo
echo -n "Please provide display version: "
read DV
echo -n "Please provide full version: "
read FV

echo
echo current.release=$RV
echo current.version=$DV
echo current.fullversion=$FV
echo

echo "Press [RETURN] to update version"
read OK

cat >modules/cmmanager/src/main/resources/org/crossmobile/gui/version.properties <<EOF
current.release=$RV
current.version=$DV
current.fullversion=$FV
EOF

mvn versions:set -DnewVersion=$DV
mvn versions:commit

sed <pom.xml -e "s/<long.version>.*<\/long.version>/<long.version>$FV<\/long.version>/g" >pom.back
mv pom.back pom.xml
