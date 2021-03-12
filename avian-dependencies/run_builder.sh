#!/bin/bash

cd $(dirname $0)
cd docker
docker-compose build
cd ..

docker run --rm -it -v ${PWD}:/src aroma/dep-builder bash /src/docker/dep_builder.sh
