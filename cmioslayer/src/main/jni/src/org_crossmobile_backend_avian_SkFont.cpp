// JNI file org_crossmobile_backend_avian_SkFont.c

#include"org_crossmobile_backend_avian_SkFont.h"
#include "aroma.h"

#include "include/core/SkFont.h"
#include "include/core/SkFontMgr.h"
#include "include/core/SkFontMetrics.h"
#include "include/core/SkTypeface.h"

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkFont_destroy
  (JNIEnv *env, jobject thiz, jlong peer) {
  INIT();
    delete (SkFont*)peer;
  RETURN();
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkFont_init
  (JNIEnv *env, jclass clazz, jstring name, jdouble size) {
  INIT();
    sk_sp<SkFontMgr> fontMgr = SkFontMgr::RefDefault();

    const char *cname = env->GetStringUTFChars(name, 0);
    DEBUG("  SkFontMgr::legacyMakeTypeface");
    SkFontStyle fontStyle;
    sk_sp<SkTypeface> typeface = fontMgr->legacyMakeTypeface(cname, fontStyle);
    env->ReleaseStringUTFChars(name, cname);

    DEBUG("  New SkFont");
    SkFont* font = new SkFont(typeface, size);
    DEBUG("  SkFont::setEdging");
    font->setEdging(SkFont::Edging::kAntiAlias);
  RETURN_V(font, jlong);
}


JNIEXPORT jstring JNICALL Java_org_crossmobile_backend_avian_SkFont_getFamily
  (JNIEnv *env, jclass clazz, jlong font) {
  INIT();
    SkString family;
    ((SkFont*)font)->getTypeface()->getFamilyName(&family);
  RETURN_V(env->NewStringUTF(family.c_str()), jstring);
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getAscent
  (JNIEnv *env, jclass clazz, jlong font) {
  INIT();
    SkFontMetrics metrics;
    ((SkFont*)font)->getMetrics(&metrics);
  RETURN_V(metrics.fAscent, jdouble);
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getDescent
  (JNIEnv *env, jclass clazz, jlong font) {
  INIT();
    SkFontMetrics metrics;
    ((SkFont*)font)->getMetrics(&metrics);
  RETURN_V(metrics.fDescent, jdouble);
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getLeading
  (JNIEnv *env, jclass clazz, jlong font) {
  INIT();
    SkFontMetrics metrics;
    ((SkFont*)font)->getMetrics(&metrics);
  RETURN_V(metrics.fLeading, jdouble);
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getCapHeight
  (JNIEnv *env, jclass clazz, jlong font) {
  INIT();
    SkFontMetrics metrics;
    ((SkFont*)font)->getMetrics(&metrics);
  RETURN_V(metrics.fCapHeight, jdouble);
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getXHeight
  (JNIEnv *env, jclass clazz, jlong font) {
  INIT();
    SkFontMetrics metrics;
    ((SkFont*)font)->getMetrics(&metrics);
  RETURN_V(metrics.fXHeight, jdouble);
}

JNIEXPORT jobject JNICALL Java_org_crossmobile_backend_avian_SkFont_measureText
  (JNIEnv *env, jclass clazz, jlong font, jstring text) {
  INIT();
    SkRect bounds;
    const char *ctext = env->GetStringUTFChars(text, 0);
    DEBUG("  SkFont::measureText");
    (void)((SkFont*)font)->measureText(ctext, strlen(ctext), SkTextEncoding::kUTF8, &bounds);
    env->ReleaseStringUTFChars(text, ctext);

    jclass cgsize = findClass(env, "crossmobile/ios/coregraphics/CGSize");
    jmethodID cgsize_init = findMethod(env, cgsize, "<init>", "(DD)V");

    jobject result = env->NewObject(cgsize, cgsize_init, bounds.width(), bounds.height());
  RETURN_V(result, jobject);
}
