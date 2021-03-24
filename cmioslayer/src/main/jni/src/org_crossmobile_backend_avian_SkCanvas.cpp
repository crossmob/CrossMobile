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
    DEBUG("  SkBitmap::installPixels in %s in line %d\n", __FILE__, __LINE__);
    bitmap.installPixels(SkImageInfo::Make(
          width,
          height,
          kBGRA_8888_SkColorType, kPremul_SkAlphaType),
          (void*)pixels,
          pitch
        );
  DEBUG("  New SkCanvas from bitmap from surface in %s in line %d\n", __FILE__, __LINE__);
  RETURN_V(new SkCanvas(bitmap), jlong);
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initCanvas__J
  (JNIEnv *env, jclass clazz, jlong bitmap) {
  INIT();
  DEBUG("  New SkCanvas from bitmap in %s in line %d\n", __FILE__, __LINE__);
  RETURN_V(new SkCanvas(*((SkBitmap*) bitmap)), jlong);
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyCanvas
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    DEBUG("  Delete SkCanvas pointer in %s in line %d\n", __FILE__, __LINE__);
    delete (SkCanvas*)canvas;
  RETURN();
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initPaint
  (JNIEnv *env, jclass clazz) {
  INIT();
  DEBUG("  New SkPaint in %s in line %d\n", __FILE__, __LINE__);
  RETURN_V(new SkPaint(), jlong);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyPaint
  (JNIEnv *env, jclass clazz, jlong paint) {
  INIT();
    DEBUG("  Delete SkPaint pointer in %s in line %d\n", __FILE__, __LINE__);
    delete (SkPaint*)paint;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clear
  (JNIEnv *env, jclass clazz, jlong canvas, jint color) {
  INIT();
    DEBUG("  SkCanvas::clear in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->clear((unsigned int)color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_flush
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
      DEBUG("  SkCanvas::flush in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->flush();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawText
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jstring text, jlong paint, jlong font) {
    INIT();
      const char *ctext = env->GetStringUTFChars(text, 0);
      DEBUG("  SkTextBlob::MakeFromString in %s in line %d\n", __FILE__, __LINE__);
      sk_sp<SkTextBlob> blob = SkTextBlob::MakeFromString(ctext, *((SkFont*)font));
      env->ReleaseStringUTFChars(text, ctext);
      DEBUG("  SkCanvas::drawTextBlob in %s in line %d\n", __FILE__, __LINE__);
      ((SkCanvas*)canvas)->drawTextBlob(blob.get(), x, y, *((SkPaint*)paint));
    RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    DEBUG("  SkRect:MakeXYWH in %s in line %d\n", __FILE__, __LINE__);
    SkRect rect = SkRect::MakeXYWH(x, y, width, height);
    DEBUG("  SkCanvas::drawRect in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->drawRect(rect, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawImage
  (JNIEnv *env, jclass clazz, jlong canvas, jlong bitmap, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    DEBUG("  SkCanvas::translate in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->translate(x, y);
    DEBUG("  SkCanvas::drawBitmapRect in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->drawBitmapRect(*((SkBitmap*)bitmap), SkRect::MakeWH(width, height), (SkPaint*)paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawLine
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x1, jdouble y1, jdouble x2, jdouble y2, jlong paint) {
  INIT();
    DEBUG("  SkCanvas::drawLine in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->drawLine(x1, y1, x2, y2, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    DEBUG("  SkRect::MakeXYWH in %s in line %d\n", __FILE__, __LINE__);
    SkRect rect = SkRect::MakeXYWH(x, y, width,  height);
    DEBUG("  SkRRect::MakeOval in %s in line %d\n", __FILE__, __LINE__);
    SkRRect oval = SkRRect::MakeOval(rect);
    DEBUG("  SkCanvas::drawRRect in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->drawRRect(oval, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawArc
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jdouble from, jdouble extend, jlong paint) {
  INIT();
    DEBUG("  SkRect::MakeXYWH in %s in line %d\n", __FILE__, __LINE__);
    SkRect rect = SkRect::MakeXYWH(x, y, width, height);
    DEBUG("  SkCanvas::drawArc in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->drawArc(rect, from, extend, true, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawPath
  (JNIEnv *env, jclass clazz, jlong canvas, jlong paint, jlong path) {
  INIT();
    DEBUG("  SkCanvas::drawPath in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->drawPath(*((SkPath*)path), *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_save
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    DEBUG("  SkCanvas::save in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->save();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_restore
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    DEBUG("  SkCanvas::restore in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->restore();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_translate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble tx, jdouble ty) {
  INIT();
    DEBUG("  SkCanvas::translate in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->translate(tx, ty);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_rotate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble theta) {
  INIT();
    DEBUG("  SkCanvas::rotate in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->rotate(theta);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_scale
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble sx, jdouble sy) {
  INIT();
    DEBUG("  SkCanvas::scale in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->scale(sx, sy);
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clipRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble width, jdouble height, jlong paint) {
  INIT();
    DEBUG("  SkRect::MakeWH in %s in line %d\n", __FILE__, __LINE__);
    SkRect rect = SkRect::MakeWH(width, height);
    DEBUG("  SkCanvas::clipRect in %s in line %d\n", __FILE__, __LINE__);
    ((SkCanvas*)canvas)->clipRect(rect, SkClipOp::kIntersect, ((SkPaint*)paint)->isAntiAlias());
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStyle
  (JNIEnv *env, jclass clazz, jlong paint, jbyte style)  {
  INIT();
    DEBUG("  SkPaint::setStyle in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setStyle((SkPaint::Style)style);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeWidth
  (JNIEnv *env, jclass clazz, jlong paint, jdouble width) {
  INIT();
    DEBUG("  SkPaint::setStrokeWidth in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setStrokeWidth(width);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintColor
  (JNIEnv *env, jclass clazz, jlong paint, jint color) {
  INIT();
    DEBUG("  SkPaint::setColor in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setColor((unsigned int)color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAntialias
  (JNIEnv *env, jclass clazz, jlong paint, jboolean shouldAntiAlias) {
  INIT();
    DEBUG("  SkPaint::setAntiAlias in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setAntiAlias(shouldAntiAlias);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAlpha
  (JNIEnv *env, jclass clazz, jlong paint, jdouble alpha) {
  INIT();
    DEBUG("  SkPaint::setAlpha in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setAlpha(alpha);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeJoin
  (JNIEnv *env, jclass clazz, jlong paint, jbyte strokeJoin)  {
  INIT();
    DEBUG("  SkPaint::setStrokeJoin in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setStrokeJoin((SkPaint::Join)strokeJoin);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeCap
  (JNIEnv *env, jclass clazz, jlong paint, jbyte strokeCap)  {
  INIT();
    DEBUG("  SkPaint::setStrokeCap in %s in line %d\n", __FILE__, __LINE__);
    ((SkPaint*)paint)->setStrokeCap((SkPaint::Cap)strokeCap);
  RETURN();
}
