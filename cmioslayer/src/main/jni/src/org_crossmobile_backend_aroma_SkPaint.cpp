// JNI file org_crossmobile_backend_aroma_SkPaint.c

#include"org_crossmobile_backend_aroma_SkPaint.h"
#include "aroma.h"

#include "include/core/SkPaint.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_aroma_SkPaint_initPaint
  (JNIEnv *env, jclass clazz) {
  INIT();
  RETURN_V(new SkPaint(), jlong);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_destroyPaint
  (JNIEnv *env, jclass clazz, jlong paint) {
  INIT();
    delete (SkPaint*)paint;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setStyle
  (JNIEnv *env, jclass clazz, jlong paint, jbyte style)  {
  INIT();
    ((SkPaint*)paint)->setStyle((SkPaint::Style)style);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setStrokeWidth
  (JNIEnv *env, jclass clazz, jlong paint, jdouble width) {
  INIT();
    ((SkPaint*)paint)->setStrokeWidth(width);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setColor
  (JNIEnv *env, jclass clazz, jlong paint, jint color) {
  INIT();
    ((SkPaint*)paint)->setColor((unsigned int)color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setAntialias
  (JNIEnv *env, jclass clazz, jlong paint, jboolean shouldAntiAlias) {
  INIT();
    ((SkPaint*)paint)->setAntiAlias(shouldAntiAlias);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setAlpha
  (JNIEnv *env, jclass clazz, jlong paint, jdouble alpha) {
  INIT();
    ((SkPaint*)paint)->setAlpha(alpha);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setStrokeJoin
  (JNIEnv *env, jclass clazz, jlong paint, jbyte strokeJoin)  {
  INIT();
    ((SkPaint*)paint)->setStrokeJoin((SkPaint::Join)strokeJoin);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkPaint_setStrokeCap
  (JNIEnv *env, jclass clazz, jlong paint, jbyte strokeCap)  {
  INIT();
    ((SkPaint*)paint)->setStrokeCap((SkPaint::Cap)strokeCap);
  RETURN();
}