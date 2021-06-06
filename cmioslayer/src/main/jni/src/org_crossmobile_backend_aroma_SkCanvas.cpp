// JNI file org_crossmobile_backend_aroma_SkCanvas.c

#include"org_crossmobile_backend_aroma_SkCanvas.h"
#include "aroma.h"

#include "SDL.h"
#include "include/core/SkCanvas.h"
#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkRRect.h"
#include "include/core/SkClipOp.h"
#include "include/core/SkImageInfo.h"


SkColorType getColorType(Uint32 sdlPixelFormat) {
  switch(sdlPixelFormat) {
    case SDL_PIXELFORMAT_RGB565:
      return kRGB_565_SkColorType;
    case SDL_PIXELFORMAT_RGB888:
      return kBGRA_8888_SkColorType;
    default:
      FATAL_ERROR("Unsupported SDL pixel format, please report back to the Aroma Team: %s", SDL_GetPixelFormatName(sdlPixelFormat));
  }
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_initSDLWindowCanvas
  (JNIEnv *env, jclass clazz, jlong window) {
  INIT();
    SkBitmap bitmap;
    SDL_Surface* surface = SDL_GetWindowSurface((SDL_Window*)window);
    Uint32 sdlPixelFormat = SDL_GetWindowPixelFormat((SDL_Window*)window);
    DEBUG("  Using window pixel format %s", SDL_GetPixelFormatName(sdlPixelFormat));
    bitmap.installPixels(SkImageInfo::Make(
          surface->w,
          surface->h,
          getColorType(sdlPixelFormat),
          kPremul_SkAlphaType),
          (void*)surface->pixels,
          surface->pitch
        );
  RETURN_V(new SkCanvas(bitmap), jlong);
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_initBitmapCanvas
  (JNIEnv *env, jclass clazz, jlong bitmap) {
  INIT();
  RETURN_V(new SkCanvas(*((SkBitmap*) bitmap)), jlong);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_destroyCanvas
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    delete (SkCanvas*)canvas;
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_clear
  (JNIEnv *env, jclass clazz, jlong canvas, jint color) {
  INIT();
    ((SkCanvas*)canvas)->clear((unsigned int)color);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_flush
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    ((SkCanvas*)canvas)->flush();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawText
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


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeXYWH(x, y, width, height);
    ((SkCanvas*)canvas)->drawRect(rect, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawImage
  (JNIEnv *env, jclass clazz, jlong canvas, jlong bitmap, jdouble x, jdouble y, jdouble width, jdouble height) {
  INIT();
    ((SkCanvas*)canvas)->drawBitmapRect(*((SkBitmap*)bitmap), SkRect::MakeXYWH(x, y, width, height), NULL);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawLine
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x1, jdouble y1, jdouble x2, jdouble y2, jlong paint) {
  INIT();
    ((SkCanvas*)canvas)->drawLine(x1, y1, x2, y2, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawRRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeXYWH(x, y, width,  height);
    SkRRect oval = SkRRect::MakeOval(rect);
    ((SkCanvas*)canvas)->drawRRect(oval, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawArc
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble x, jdouble y, jdouble width, jdouble height, jdouble from, jdouble extend, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeXYWH(x, y, width, height);
    ((SkCanvas*)canvas)->drawArc(rect, from, extend, true, *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawPath
  (JNIEnv *env, jclass clazz, jlong canvas, jlong paint, jlong path) {
  INIT();
    ((SkCanvas*)canvas)->drawPath(*((SkPath*)path), *((SkPaint*)paint));
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_save
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    ((SkCanvas*)canvas)->save();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_restore
  (JNIEnv *env, jclass clazz, jlong canvas) {
  INIT();
    ((SkCanvas*)canvas)->restore();
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_translate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble tx, jdouble ty) {
  INIT();
    ((SkCanvas*)canvas)->translate(tx, ty);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_rotate
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble theta) {
  INIT();
    ((SkCanvas*)canvas)->rotate(theta);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_scale
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble sx, jdouble sy) {
  INIT();
    ((SkCanvas*)canvas)->scale(sx, sy);
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_clipRect
  (JNIEnv *env, jclass clazz, jlong canvas, jdouble width, jdouble height, jlong paint) {
  INIT();
    SkRect rect = SkRect::MakeWH(width, height);
    ((SkCanvas*)canvas)->clipRect(rect, SkClipOp::kIntersect, ((SkPaint*)paint)->isAntiAlias());
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawPaint
  (JNIEnv *env, jclass clazz, jlong canvas, jlong paint) {
  INIT();
    ((SkCanvas*)canvas)->drawPaint(*((SkPaint*)paint));
  RETURN();
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SkCanvas_drawNinePatch
  (JNIEnv *env, jclass clazz, jlong canvas, jlong sourceBitmap, jint top, jint right, jint bottom, jint left, jint reqX, jint reqY) {
  INIT();
//    SkRect rect = SkRect::MakeLTRB(left, top, right, bottom);
//    SkIRect irect = SkIRect::MakeLTRB(left, top, right, bottom);
//    ((SkCanvas*)canvas)->drawBitmapNine(*((SkBitmap*)sourceBitmap), irect, rect);
  RETURN();
}