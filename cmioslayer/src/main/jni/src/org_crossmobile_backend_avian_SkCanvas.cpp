// JNI file org_crossmobile_backend_avian_SkCanvas.c

#include"org_crossmobile_backend_avian_SkCanvas.h"

#include "include/core/SkCanvas.h"
#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkRRect.h"
#include "include/core/SkClipOp.h"


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initCanvas
  (JNIEnv *env, jclass clazz, jint jwidth, jint jheight, jlong jpixels, jint jpitch) {
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
  return (jlong)canvas;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyCanvas
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  delete (SkCanvas*)canvasPeer;
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkCanvas_initPaint
  (JNIEnv *env, jclass clazz) {
  SkPaint* paint = new SkPaint();
  return (jlong)paint;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_destroyPaint
  (JNIEnv *env, jclass clazz, jlong paintPeer) {
  delete (SkPaint*)paintPeer;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clear
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jint jcolor) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkColor color = (unsigned int)jcolor;
  canvas->clear(color);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_flush
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  canvas->flush();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawText
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jstring jtext, jlong paintPeer, jlong fontPeer) {
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
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRect
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jlong paintPeer) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;

  // Turn java types into native types
  double x = (double)jx;
  double y = (double)jy;
  double width = (double)jwidth;
  double height = (double)jheight;

  SkRect rect = SkRect::MakeXYWH(x, y, width, height);
  canvas->drawRect(rect, *paint);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawImage
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jlong imagePeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jlong paintPeer) {
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
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawLine
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx1, jdouble jy1, jdouble jx2, jdouble jy2, jlong paintPeer) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  double x1 = (double)jx1;
  double y1 = (double)jy1;
  double x2 = (double)jx2;
  double y2 = (double)jy2;
  canvas->drawLine(x1, y1, x2, y2, *paint);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawRRect
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jlong paintPeer) {
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
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawArc
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight, jdouble jfrom, jdouble jextend, jlong paintPeer) {
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
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_drawPath
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jlong paintPeer, jlong pathPeer) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPath* path = (SkPath*)pathPeer;
  canvas->drawPath(*path, *paint);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_save
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  canvas->save();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_restore
  (JNIEnv *env, jclass clazz, jlong canvasPeer) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  canvas->restore();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_translate
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jtx, jdouble jty) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  double tx = (double)jtx;
  double ty = (double)jty;
  canvas->translate(tx, ty);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_rotate
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jtheta) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  double theta = (double)jtheta;
  canvas->rotate(theta);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_scale
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jsx, jdouble jsy) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  double sx = (double)jsx;
  double sy = (double)jsy;
  canvas->scale(sx, sy);
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_clipRect
  (JNIEnv *env, jclass clazz, jlong canvasPeer, jdouble jx, jdouble jy, jdouble jwidth, jdouble jheight) {
  SkCanvas* canvas = (SkCanvas*)canvasPeer;
  double x = (double)jx;
  double y = (double)jy;
  double width = (double)jwidth;
  double height = (double)jheight;
  canvas->clipRect(SkRect::MakeXYWH(x, y, width, height), SkClipOp::kIntersect, false);
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStyle
  (JNIEnv *env, jclass clazz, jlong paintPeer, jbyte jstyle)  {
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPaint::Style style = (SkPaint::Style)jstyle; 
  paint->setStyle(style);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeWidth
  (JNIEnv *env, jclass clazz, jlong paintPeer, jdouble jwidth) {
  SkPaint* paint = (SkPaint*)paintPeer;
  double width = (double)jwidth;
  paint->setStrokeWidth(width);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintColor
  (JNIEnv *env, jclass clazz, jlong paintPeer, jint jcolor) {
  SkPaint* paint = (SkPaint*)paintPeer;
  unsigned int color = (unsigned int)jcolor;
  paint->setColor(color);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAntialias
  (JNIEnv *env, jclass clazz, jlong paintPeer, jboolean jshouldAntiAlias) {
    SkPaint* paint = (SkPaint*)paintPeer;
    bool shouldAntiAlias = (bool)jshouldAntiAlias;
    paint->setAntiAlias(shouldAntiAlias);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintAlpha
  (JNIEnv *env, jclass clazz, jlong paintPeer, jdouble jalpha) {
  SkPaint* paint = (SkPaint*)paintPeer;
  double alpha = (double)jalpha;
  paint->setAlpha(alpha);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeJoin
  (JNIEnv *env, jclass clazz, jlong paintPeer, jbyte jstrokeJoin)  {
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPaint::Join strokeJoin = (SkPaint::Join)jstrokeJoin;
  paint->setStrokeJoin(strokeJoin); 
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkCanvas_setPaintStrokeCap
  (JNIEnv *env, jclass clazz, jlong paintPeer, jbyte jstrokeCap)  {
  SkPaint* paint = (SkPaint*)paintPeer;
  SkPaint::Cap strokeCap = (SkPaint::Cap)jstrokeCap;
  paint->setStrokeCap(strokeCap); 
}
