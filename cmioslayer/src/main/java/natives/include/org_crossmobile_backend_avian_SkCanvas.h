/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_crossmobile_backend_avian_SkCanvas */

#ifndef _Included_org_crossmobile_backend_avian_SkCanvas
#define _Included_org_crossmobile_backend_avian_SkCanvas
#ifdef __cplusplus
extern "C" {
#endif
#undef org_crossmobile_backend_avian_SkCanvas_FILL
#define org_crossmobile_backend_avian_SkCanvas_FILL 0L
#undef org_crossmobile_backend_avian_SkCanvas_STROKE
#define org_crossmobile_backend_avian_SkCanvas_STROKE 1L
#undef org_crossmobile_backend_avian_SkCanvas_FILL_AND_STROKE
#define org_crossmobile_backend_avian_SkCanvas_FILL_AND_STROKE 2L
#undef org_crossmobile_backend_avian_SkCanvas_MITER_JOIN
#define org_crossmobile_backend_avian_SkCanvas_MITER_JOIN 0L
#undef org_crossmobile_backend_avian_SkCanvas_ROUND_JOIN
#define org_crossmobile_backend_avian_SkCanvas_ROUND_JOIN 1L
#undef org_crossmobile_backend_avian_SkCanvas_BEVEL_JOIN
#define org_crossmobile_backend_avian_SkCanvas_BEVEL_JOIN 2L
#undef org_crossmobile_backend_avian_SkCanvas_LAST_JOIN
#define org_crossmobile_backend_avian_SkCanvas_LAST_JOIN 2L
#undef org_crossmobile_backend_avian_SkCanvas_DEFAULT_JOIN
#define org_crossmobile_backend_avian_SkCanvas_DEFAULT_JOIN 0L
#undef org_crossmobile_backend_avian_SkCanvas_BUTT_CAP
#define org_crossmobile_backend_avian_SkCanvas_BUTT_CAP 0L
#undef org_crossmobile_backend_avian_SkCanvas_ROUND_CAP
#define org_crossmobile_backend_avian_SkCanvas_ROUND_CAP 1L
#undef org_crossmobile_backend_avian_SkCanvas_SQUARE_CAP
#define org_crossmobile_backend_avian_SkCanvas_SQUARE_CAP 2L
#undef org_crossmobile_backend_avian_SkCanvas_LAST_CAP
#define org_crossmobile_backend_avian_SkCanvas_LAST_CAP 2L
#undef org_crossmobile_backend_avian_SkCanvas_DEFAULT_CAP
#define org_crossmobile_backend_avian_SkCanvas_DEFAULT_CAP 1L
/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    initCanvas
 * Signature: (IIJI)J
 */
JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initCanvas
  (JNIEnv *, jclass, jint, jint, jlong, jint);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    destroyCanvas
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyCanvas
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    initPaint
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initPaint
  (JNIEnv *, jclass);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    destroyPaint
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyPaint
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    clear
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clear
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    flush
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_flush
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawText
 * Signature: (JDDLjava/lang/String;JJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawText
  (JNIEnv *, jclass, jlong, jdouble, jdouble, jstring, jlong, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawRect
 * Signature: (JDDDDJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRect
  (JNIEnv *, jclass, jlong, jdouble, jdouble, jdouble, jdouble, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawImage
 * Signature: (JJDDDDJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawImage
  (JNIEnv *, jclass, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawLine
 * Signature: (JDDDDJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawLine
  (JNIEnv *, jclass, jlong, jdouble, jdouble, jdouble, jdouble, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawRRect
 * Signature: (JDDDDJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRRect
  (JNIEnv *, jclass, jlong, jdouble, jdouble, jdouble, jdouble, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawArc
 * Signature: (JDDDDDDJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawArc
  (JNIEnv *, jclass, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    drawPath
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawPath
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    save
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_save
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    restore
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_restore
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    translate
 * Signature: (JDD)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_translate
  (JNIEnv *, jclass, jlong, jdouble, jdouble);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    rotate
 * Signature: (JD)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_rotate
  (JNIEnv *, jclass, jlong, jdouble);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    scale
 * Signature: (JDD)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_scale
  (JNIEnv *, jclass, jlong, jdouble, jdouble);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintStyle
 * Signature: (JB)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStyle
  (JNIEnv *, jclass, jlong, jbyte);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintStrokeWidth
 * Signature: (JD)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeWidth
  (JNIEnv *, jclass, jlong, jdouble);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintColor
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintColor
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintAntialias
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAntialias
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintAlpha
 * Signature: (JD)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAlpha
  (JNIEnv *, jclass, jlong, jdouble);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintStrokeJoin
 * Signature: (JB)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeJoin
  (JNIEnv *, jclass, jlong, jbyte);

/*
 * Class:     org_crossmobile_backend_avian_SkCanvas
 * Method:    setPaintStrokeCap
 * Signature: (JB)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeCap
  (JNIEnv *, jclass, jlong, jbyte);

#ifdef __cplusplus
}
#endif
#endif