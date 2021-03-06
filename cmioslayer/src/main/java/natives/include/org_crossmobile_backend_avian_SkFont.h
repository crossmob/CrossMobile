/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_crossmobile_backend_avian_SkFont */

#ifndef _Included_org_crossmobile_backend_avian_SkFont
#define _Included_org_crossmobile_backend_avian_SkFont
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkFont_destroy
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    init
 * Signature: (Ljava/lang/String;D)J
 */
JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkFont_init
  (JNIEnv *, jclass, jstring, jdouble);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    getFamily
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_crossmobile_backend_avian_SkFont_getFamily
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    getAscent
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getAscent
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    getDescent
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getDescent
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    getLeading
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getLeading
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    getCapHeight
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getCapHeight
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SkFont
 * Method:    getXHeight
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getXHeight
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
