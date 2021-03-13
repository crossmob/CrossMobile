#!/bin/bash

set -e
set -x
# temporary hack to install avian dependencies user-wide
DEST=~/.cache/crossmobile/avian/0.1

cd $(dirname $0)
cd docker
docker-compose build
cd ..

docker run --rm -it -v ${PWD}:/src aroma/dep-builder bash /src/docker/dep_builder.sh


# Install hack continues here
sudo chown -R $USER target
rm -rf $DEST
mkdir -p $DEST
cp -r target/* $DEST
