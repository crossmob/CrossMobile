#ifndef AROMA_H
#define AROMA_H

#include <stdio.h>
#include <jni.h>

extern int DEBUG_LEVEL;

#ifdef DEBUG_AROMA
# define DEBUG(fmt, args...) {if (DEBUG_LEVEL>0) fprintf(stderr, fmt " [%s]\n", ## args, __func__);}
# define INIT() DEBUG("<init>")
# define RETURN() DEBUG("<end> ")
# define RETURN_V(VAL,TYPE) {TYPE __result = (TYPE)(VAL); RETURN(); return __result;}
#else
# define DEBUG(fmt, args...)
# define INIT();
# define RETURN();
# define RETURN_V(VAL,TYPE) return (TYPE)(VAL)
#endif

#define FATAL_ERROR(fmt, args...) {fprintf(stderr, "ERROR: " fmt " [%s]\n", ## args, __func__) ; exit(-1) ;}
#define RETURN_ERROR(fmt, args...) {fprintf(stderr, "ERROR: " fmt " [%s]\n", ## args, __func__) ; return ;}
#define RETURN_ERROR_V(fmt, args...) {fprintf(stderr, "ERROR: " fmt " [%s]\n", ## args, __func__) ; return NULL;}

#ifdef __cplusplus
extern "C" {
#endif

jclass findClass(JNIEnv *env, const char* classname);
jclass findObjectClass(JNIEnv *env, jobject object);
jmethodID findMethod(JNIEnv *env, jclass clazz, const char* methodName, const char* signature);
jfieldID findField(JNIEnv *env, jclass clazz, const char* fieldName, const char* signature);
void setIntField(JNIEnv *env, jobject object, jfieldID field, jint value);
void setDoubleField(JNIEnv *env, jobject object, jfieldID field, jdouble value);
void setStringField(JNIEnv *env, jobject object, jfieldID field, jstring value);

#ifdef __cplusplus
}
#endif

#endif
