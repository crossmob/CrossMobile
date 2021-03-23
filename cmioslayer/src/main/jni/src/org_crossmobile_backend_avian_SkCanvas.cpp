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
  (JNIEnv *env, jclass clazz, jint jwidth, jint jheight, jlong jpixels, jint jpitch) {
  INIT();
  int width = (int)jwidth;
  int height = (int)jheight;
  void* pixels = (void*)jpixels;
  int pitch = (int)jpitch;
  SkBitmap bitmap;
  bitmap.installPixels(SkImageInfo::Make(
        width, 
        height, 
        kBGRA_8888_SkColorType, kPremul_SkAlphaType),
        pixels, 
        pitch
      );
  SkCanvas* canvas = new SkCanvas(bitmap);
  RETURN();
  return (jlong)canvas;
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initCanvas__J
  (JNIEnv *env, jclass clazz, jlong bitmapPeer) {
  SkBitmap* bitmap = (SkBitmap*) bitmapPeer;
  SkCanvas* canvas = new SkCanvas(*bitmap);
  return (jlong)canvas;
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyCanvas
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  INIT();
  delete (SkCanvas*)canvasPeer;
  RETURN();
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initPaint
  (JNIEnv *env, jclass clazz) {
  INIT();
  SkPaint* paint = new SkPaint();
  return (jlong)paint;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyPaint
  (JNIEnv *env, jclass clazz, jlong paintPeer) {
  INIT();
  delete (SkPaint*)paintPeer;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clear
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jint jcolor) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkColor color = (unsigned int)jcolor;
  canvas->clear(color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_flush
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  canvas->flush();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawText
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jstring jtext, jlong paintPeer, jlong fontPeer) {
    INIT();
    // Get canvas pointer from SkiaContext
    SkCanvas* canvas = (SkCanvas*)canvasPeer;
    // Get paint pointer from SkiaPaint
    SkPaint* paint = (SkPaint*)paintPeer;
    // Get font pointer from SkiaFont
    SkFont* font = (SkFont*)fontPeer;

    // Turn java types into native types
    double x = (double)jx;
    double y = (double)jy;
    const char *text = env->GetStringUTFChars(jtext, 0);

    // Draw text
    sk_sp<SkTextBlob> blob = SkTextBlob::MakeFromString(text, *font);
    canvas->drawTextBlob(blob.get(), x, y, *paint);

    // Memory management step
    // Keep in mind:
    // No new — no delete. In the same way, no malloc (or calloc or realloc) — no free
    env->ReleaseStringUTFChars(jtext, text);
    RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRect
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jlong paintPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;

  // Turn java types into native types
  double x = (double)jx;
  double y = (double)jy;
  double width = (double)jwidth;
  double height = (double)jheight;

  SkRect rect = SkRect::MakeXYWH(x, y, width, height);
  canvas->drawRect(rect, *paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawImage
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jlong imagePeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jlong paintPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;

  // Turn String into native text
  double x = (double)jx;
  double y = (double)jy;
  double width = (double)jwidth;
  double height = (double)jheight;

  // Code :)
  SkBitmap* bitmap = (SkBitmap*)imagePeer;
  canvas->translate(x, y);
  canvas->drawBitmapRect(*bitmap, SkRect::MakeWH(width, height), paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawLine
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx1, jdouble jy1, jdouble jx2, jdouble jy2, jlong paintPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  double x1 = (double)jx1;
  double y1 = (double)jy1;
  double x2 = (double)jx2;
  double y2 = (double)jy2;
  canvas->drawLine(x1, y1, x2, y2, *paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRRect
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jlong paintPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  double x = (double)jx;
  double y = (double)jy;
  double width = (double)jwidth;
  double height = (double)jheight;

  SkRect rect = SkRect::MakeXYWH(x, y, width, height);
  SkRRect oval;
  oval.setOval(rect);
  canvas->drawRRect(oval, *paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawArc
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jdouble jfrom, jdouble jextend, jlong paintPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  double x = (double)jx;
  double y = (double)jy;
  double width = (double)jwidth;
  double height = (double)jheight;
  double from = (double)jfrom;
  double extend = (double)jextend;

  SkRect rect = SkRect::MakeXYWH(x, y, width, height);

  canvas->drawArc(rect, from, extend, true, *paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawPath
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jlong paintPeer, jlong pathPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPath* path = (SkPath*)pathPeer;
  canvas->drawPath(*path, *paint);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_save
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  canvas->save();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_restore
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  canvas->restore();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_translate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble tx, jdouble ty) {
  INIT();
  ((SkCanvas*)canvas)->translate(tx, ty);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_rotate
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jtheta) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  double theta = (double)jtheta;
  canvas->rotate(theta);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_scale
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jsx, jdouble jsy) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  double sx = (double)jsx;
  double sy = (double)jsy;
  canvas->scale(sx, sy);
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clipRect
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble width, jdouble height, jlong paintPeer) {
  INIT();
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  canvas->clipRect(SkRect::MakeWH(width, height), SkClipOp::kIntersect, paint->isAntiAlias());
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStyle
  (JNIEnv *env, jclass clazz, jlong paintPeer, jbyte jstyle)  {
  INIT();
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPaint::Style style = (SkPaint::Style)jstyle; 
  paint->setStyle(style);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeWidth
  (JNIEnv *env, jclass clazz, jlong paintPeer, jdouble jwidth) {
  INIT();
  SkPaint* paint = (SkPaint*)paintPeer;
  double width = (double)jwidth;
  paint->setStrokeWidth(width);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintColor
  (JNIEnv *env, jclass clazz, jlong paintPeer, jint jcolor) {
  INIT();
  SkPaint* paint = (SkPaint*)paintPeer;
  unsigned int color = (unsigned int)jcolor;
  paint->setColor(color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAntialias
  (JNIEnv *env, jclass clazz, jlong paintPeer, jboolean jshouldAntiAlias) {
  INIT();
    SkPaint* paint = (SkPaint*)paintPeer;
    bool shouldAntiAlias = (bool)jshouldAntiAlias;
    paint->setAntiAlias(shouldAntiAlias);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAlpha
  (JNIEnv *env, jclass clazz, jlong paintPeer, jdouble jalpha) {
  INIT();
  SkPaint* paint = (SkPaint*)paintPeer;
  double alpha = (double)jalpha;
  paint->setAlpha(alpha);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeJoin
  (JNIEnv *env, jclass clazz, jlong paintPeer, jbyte jstrokeJoin)  {
  INIT();
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPaint::Join strokeJoin = (SkPaint::Join)jstrokeJoin;
  paint->setStrokeJoin(strokeJoin); 
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeCap
  (JNIEnv *env, jclass clazz, jlong paintPeer, jbyte jstrokeCap)  {
  INIT();
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPaint::Cap strokeCap = (SkPaint::Cap)jstrokeCap;
  paint->setStrokeCap(strokeCap); 
  RETURN();
}
