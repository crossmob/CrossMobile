// JNI file org_crossmobile_backend_avian_SkPath.c

#include"org_crossmobile_backend_avian_SkPath.h"
#include "aroma.h"

#include "include/core/SkPath.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkPath_init
  (JNIEnv *env, jclass clazz) {
  INIT();
  SkPath* path = new SkPath();
  RETURN();
  return (jlong)path;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkPath_destroy
  (JNIEnv *env, jobject thiz, jlong peer) {
  INIT();
  delete (SkPath*)peer;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkPath_moveTo
  (JNIEnv *env, jclass clazz, jlong peer, jdouble jx, jdouble jy) {
  INIT();
    SkPath* path = (SkPath*)peer;
    double x = (double)jx;
    double y = (double)jy;
    path->moveTo(x, y);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkPath_quadTo
  (JNIEnv *env, jclass clazz, jlong peer, jdouble jx1, jdouble jy1, jdouble jx2, jdouble jy2) {
  INIT();
  SkPath* path = (SkPath*)peer;
  double x1 = (double)jx1;
  double y1 = (double)jy1;
  double x2 = (double)jx2;
  double y2 = (double)jy2;
  path->quadTo(x1, y1, x2, y2);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkPath_close
  (JNIEnv *env, jclass clazz, jlong path) {
  INIT();
  ((SkPath*)path)->close();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkPath_reset
  (JNIEnv *env, jclass clazz, jlong peer) {
  INIT();
  SkPath* path = (SkPath*)peer;
  path->reset();
  RETURN();
}
