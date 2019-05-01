#!/bin/bash

mkdir -p include

for f in *.h
do
	sed 's/dllexport/dllimport/g' $f > include/$f	
done
