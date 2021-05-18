// JNI file org_crossmobile_backend_aroma_SkPath.c

#include"org_crossmobile_backend_aroma_SkPath.h"
#include "aroma.h"

#include "include/core/SkPath.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_aroma_SkPath_init
  (JNIEnv *env, jclass clazz) {
  INIT();
  RETURN_V(new SkPath(), jlong);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPath_destroy
  (JNIEnv *env, jobject thiz, jlong path) {
  INIT();
    delete (SkPath*)path;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPath_moveTo
  (JNIEnv *env, jclass clazz, jlong path, jdouble x, jdouble y) {
  INIT();
    ((SkPath*)path)->moveTo(x, y);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPath_quadTo
  (JNIEnv *env, jclass clazz, jlong path, jdouble x1, jdouble y1, jdouble x2, jdouble y2) {
  INIT();
    ((SkPath*)path)->quadTo(x1, y1, x2, y2);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPath_close
  (JNIEnv *env, jclass clazz, jlong path) {
  INIT();
    ((SkPath*)path)->close();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPath_reset
  (JNIEnv *env, jclass clazz, jlong path) {
  INIT();
    ((SkPath*)path)->reset();
  RETURN();
}
