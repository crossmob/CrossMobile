// JNI file org_crossmobile_backend_avian_SkCanvas.c

#include"org_crossmobile_backend_avian_SkCanvas.h"
#include "aroma.h"

#include "include/core/SkCanvas.h"
#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkRRect.h"
#include "include/core/SkClipOp.h"


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initCanvas__IIJI
  (JNIEnv *env, jclass clazz, jint width, jint height, jlong pixels, jint pitch) {
  INIT();
    SkBitmap bitmap;
    bitmap.installPixels(SkImageInfo::Make(
          width,
          height,
          kBGRA_8888_SkColorType, kPremul_SkAlphaType),
          (void*)pixels,
          pitch
        );
  RETURN_V(new SkCanvas(bitmap), jlong);
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initCanvas__J
  (JNIEnv *env, jclass clazz, jlong bitmap) {
  INIT();
  RETURN_V(new SkCanvas(*((SkBitmap*) bitmap)), jlong);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyCanvas
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    delete (SkCanvas*)canvas;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clear
  (JNIEnv *env, jclass clazz, jlong canvas, jint color) {
  INIT();
    ((SkCanvas*)canvas)->clear((unsigned int)color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_flush
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    ((SkCanvas*)canvas)->flush();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawText
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jstring text, jlong paint, jlong font) {
    INIT();
      const char *ctext = env->GetStringUTFChars(text, 0);
      DEBUG("  SkTextBlob::MakeFromString");
      sk_sp<SkTextBlob> blob = SkTextBlob::MakeFromString(ctext, *((SkFont*)font));
      env->ReleaseStringUTFChars(text, ctext);
      DEBUG("  SkCanvas::drawTextBlob");
      ((SkCanvas*)canvas)->drawTextBlob(blob.get(), x, y, *((SkPaint*)paint));
    RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeXYWH(x, y, width, height);
    ((SkCanvas*)canvas)->drawRect(rect, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawImage
  (JNIEnv *env, jclass clazz, jlong canvas, jlong bitmap, jdouble x, jdouble y, jdouble width, jdouble height) {
  INIT();
    ((SkCanvas*)canvas)->drawBitmapRect(*((SkBitmap*)bitmap), SkRect::MakeXYWH(x, y, width, height), NULL);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawLine
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x1, jdouble y1, jdouble x2, jdouble y2, jlong paint) {
  INIT();
    ((SkCanvas*)canvas)->drawLine(x1, y1, x2, y2, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeXYWH(x, y, width,  height);
    SkRRect oval = SkRRect::MakeOval(rect);
    ((SkCanvas*)canvas)->drawRRect(oval, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawArc
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jdouble from, jdouble extend, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeXYWH(x, y, width, height);
    ((SkCanvas*)canvas)->drawArc(rect, from, extend, true, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawPath
  (JNIEnv *env, jclass clazz, jlong canvas, jlong paint, jlong path) {
  INIT();
    ((SkCanvas*)canvas)->drawPath(*((SkPath*)path), *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_save
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    ((SkCanvas*)canvas)->save();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_restore
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    ((SkCanvas*)canvas)->restore();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_translate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble tx, jdouble ty) {
  INIT();
    ((SkCanvas*)canvas)->translate(tx, ty);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_rotate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble theta) {
  INIT();
    ((SkCanvas*)canvas)->rotate(theta);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_scale
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble sx, jdouble sy) {
  INIT();
    ((SkCanvas*)canvas)->scale(sx, sy);
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clipRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble width, jdouble height, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeWH(width, height);
    ((SkCanvas*)canvas)->clipRect(rect, SkClipOp::kIntersect, ((SkPaint*)paint)->isAntiAlias());
  RETURN();
}
