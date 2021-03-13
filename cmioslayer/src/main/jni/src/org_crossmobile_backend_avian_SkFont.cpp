// JNI file org_crossmobile_backend_avian_SkFont.c

#include"org_crossmobile_backend_avian_SkFont.h"

#include "include/core/SkFont.h"
#include "include/core/SkFontMgr.h"
#include "include/core/SkFontMetrics.h"
#include "include/core/SkTypeface.h"

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkFont_destroy
  (JNIEnv *env, jobject thiz, jlong peer) {
  delete (SkFont*)peer;
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkFont_init
  (JNIEnv *env, jclass clazz, jstring jname, jdouble jsize) {
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
  return (jlong)font;
}


JNIEXPORT jstring JNICALL Java_org_crossmobile_backend_avian_SkFont_getFamily
  (JNIEnv *env, jclass clazz, jlong peer) {
  SkFont* font = (SkFont*)peer;
  SkString family;
  font->getTypeface()->getFamilyName(&family);
  jstring jfamily = env->NewStringUTF(family.c_str());
  return jfamily;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getAscent
  (JNIEnv *env, jclass clazz, jlong peer) {
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  return (jdouble)metrics.fAscent;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getDescent
  (JNIEnv *env, jclass clazz, jlong peer) {
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  return (jdouble)metrics.fDescent;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getLeading
  (JNIEnv *env, jclass clazz, jlong peer) {
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  return (jdouble)metrics.fLeading;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getCapHeight
  (JNIEnv *env, jclass clazz, jlong peer) {
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  return (jdouble)metrics.fCapHeight;
}


JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_getXHeight
  (JNIEnv *env, jclass clazz, jlong peer) {
  SkFont* font = (SkFont*)peer;
  SkFontMetrics metrics;
  font->getMetrics(&metrics);
  return (jdouble)metrics.fXHeight;
}
