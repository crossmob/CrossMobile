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

JNIEXPORT jboolean JNICALL Java_org_crossmobile_backend_avian_SkFont_postInit
  (JNIEnv * env, jobject thiz, jlong font) {
  INIT();
    jclass fontClass = findObjectClass(env, thiz);

    SkFontMetrics metrics;
    ((SkFont*)font)->getMetrics(&metrics);

    setDoubleField(env, thiz, findField(env, fontClass, "ascent", "D"), metrics.fAscent);
    setDoubleField(env, thiz, findField(env, fontClass, "descent", "D"), metrics.fDescent);
    setDoubleField(env, thiz, findField(env, fontClass, "leading", "D"), metrics.fLeading);
    setDoubleField(env, thiz, findField(env, fontClass, "capHeight", "D"), metrics.fCapHeight);
    setDoubleField(env, thiz, findField(env, fontClass, "xHeight", "D"), metrics.fXHeight);

    SkString family;
    ((SkFont*)font)->getTypeface()->getFamilyName(&family);

    setStringField(env, thiz, findField(env, fontClass, "family", "Ljava/lang/String;"), env->NewStringUTF(family.c_str()));

  RETURN_V(1, jboolean);
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

JNIEXPORT jdouble JNICALL Java_org_crossmobile_backend_avian_SkFont_ascentText
  (JNIEnv * env, jclass clazz, jlong font, jstring text) {
  INIT();
  SkRect bounds;
  const char *ctext = env->GetStringUTFChars(text, 0);
  (void)((SkFont*)font)->measureText(ctext, strlen(ctext), SkTextEncoding::kUTF8, &bounds);
  env->ReleaseStringUTFChars(text, ctext);
  RETURN_V(bounds.top(), jdouble);
}
