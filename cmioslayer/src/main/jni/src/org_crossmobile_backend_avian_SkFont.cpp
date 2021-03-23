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
  (JNIEnv *env, jclass clazz, jstring jname, jdouble jsize) {
  INIT();
  const char *name = env->GetStringUTFChars(jname, 0);
  double size = (double)jsize;
  SkFontStyle fontStyle;
  sk_sp<SkFontMgr> fontMgr = SkFontMgr::RefDefault();
  sk_sp<SkTypeface> typeface = fontMgr->legacyMakeTypeface(name, fontStyle);
  SkFont* font = new SkFont(typeface, size);
  font->setEdging(SkFont::Edging::kAntiAlias);
  // Memory management step
  // Keep in mind:
  // No new — no delete. In the same way, no malloc (or calloc or realloc) — no free
  env->ReleaseStringUTFChars(jname, name);
  // Return, return
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
  RETURN_V(metrics.fAscent,jdouble);
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getDescent
  (JNIEnv *env, jclass clazz, jlong peer) {
  INIT();
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  RETURN();
  return (jdouble)metrics.fDescent;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getLeading
  (JNIEnv *env, jclass clazz, jlong peer) {
  INIT();
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  RETURN();
  return (jdouble)metrics.fLeading;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getCapHeight
  (JNIEnv *env, jclass clazz, jlong peer) {
  INIT();
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  RETURN();
  return (jdouble)metrics.fCapHeight;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getXHeight
  (JNIEnv *env, jclass clazz, jlong peer) {
  INIT();
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  RETURN();
  return (jdouble)metrics.fXHeight;
}

JNIEXPORT jobject JNICALL Java_org_crossmobile_backend_avian_SkFont_measureText
  (JNIEnv *env, jclass clazz, jlong peer, jstring jtext) {
  INIT();
    SkFont* font = (SkFont*)peer;
    const char *text = env->GetStringUTFChars(jtext, 0);
    SkRect bounds;
    // NOTE: maybe strlen stops the char count at first 0 char
    (void)font->measureText(text, strlen(text), SkTextEncoding::kUTF8, &bounds);

    jclass cgsize = findClass(env, "crossmobile/ios/coregraphics/CGSize");
    jmethodID cgsize_init = findMethod(env, cgsize, "<init>", "(DD)V");

    env->ReleaseStringUTFChars(jtext, text);
    jobject result = env->NewObject(cgsize, cgsize_init, bounds.width(), bounds.height());
    RETURN();
    return result;
  }
