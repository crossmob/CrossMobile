#!/bin/bash

cd `dirname $0`
JAVA_INC=../../../../resources/native/jni

x86_64-w64-mingw32-gcc -I $JAVA_INC -I $JAVA_INC/win32 -Wl,--add-stdcall-alias -shared -o ../resources/lib/64/commander.dll org_crossmobile_NativeHandler.cpp
i686-w64-mingw32-gcc -I $JAVA_INC -I $JAVA_INC/win32 -Wl,--add-stdcall-alias -shared -o ../resources/lib/32/commander.dll org_crossmobile_NativeHandler.cpp
