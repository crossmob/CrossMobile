#ifndef AROMA_H
#define AROMA_H

#include <stdio.h>
#include <jni.h>

extern int DEBUG_LEVEL;

#ifdef DEBUG_AROMA
# define DEBUG(fmt, args...) if (DEBUG_LEVEL>0) fprintf(stderr, fmt " [%s]\n", ## args, __func__)
# define INIT() DEBUG("<init>")
# define RETURN() DEBUG("<end> ")
# define RETURN_V(VAL,TYPE) TYPE __result = (TYPE)(VAL); RETURN(); return __result
#else
# define DEBUG(fmt, args...)
# define INIT();
# define RETURN();
# define RETURN_V(VAL,TYPE) return (TYPE)(VAL)
#endif

#define ERROR(fmt, args...) fprintf(stderr, fmt " [%s]\n", ## args, __func__)

#ifdef __cplusplus
extern "C" {
#endif

jclass findClass(JNIEnv *env, char* classname);
jmethodID findMethod(JNIEnv *env, jclass clazz, char* methodName, char* signature);

#ifdef __cplusplus
}
#endif

#endif
