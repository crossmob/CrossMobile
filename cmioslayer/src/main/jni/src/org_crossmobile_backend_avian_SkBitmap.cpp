// JNI file org_crossmobile_backend_avian_SkBitmap.c

#include"org_crossmobile_backend_avian_SkBitmap.h"
#include "aroma.h"

#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkImageEncoder.h"
#include "include/core/SkRRect.h"

#include "avian/system/system.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromSizes
  (JNIEnv *env, jclass clazz, jint width, jint height) {
  INIT();
    SkBitmap* bitmap = new SkBitmap();
    if(!bitmap->tryAllocPixels(SkImageInfo::Make(width, height, kBGRA_8888_SkColorType, kPremul_SkAlphaType)))
      RETURN_ERROR_V("  Cannot allocate pixels in bitmap.\n");
  RETURN_V(bitmap, jlong);
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromBlob
  (JNIEnv *env, jclass clazz, jlong blobPeer) {
  INIT();
    vm::System::Region* region = reinterpret_cast<vm::System::Region*>(blobPeer);
    DEBUG("  SkData::MakeWithCopy");
    sk_sp<SkData> data = SkData::MakeWithCopy(region->start(), region->length());

    if (data->isEmpty())
      RETURN_ERROR_V("Bitmap has no data.");

    DEBUG("  SkImageGenerator::MakeFromEncoded");
    std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
    SkBitmap* bitmap = new SkBitmap();
    if (bitmap->tryAllocPixels(generator->getInfo())) {
      DEBUG("  SkImageGenerator::getPixels");
      generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
    } else {
      RETURN_ERROR_V("Cannot alloc bitmap pixels.");
    }
  RETURN_V(bitmap, jlong);
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromByteArray
  (JNIEnv *env, jclass clazz, jbyteArray array) {
  INIT();
    jbyte* bufferPtr = env->GetByteArrayElements(array, NULL);
    jsize lengthOfArray = env->GetArrayLength(array);
    DEBUG("  SkData::MakeWithCopy");
    sk_sp<SkData> data = SkData::MakeWithCopy(bufferPtr, lengthOfArray);
    env->ReleaseByteArrayElements(array, bufferPtr, 0);

    if (data->isEmpty())
      RETURN_ERROR_V("Bitmap has no data.");

    DEBUG("  SkImageGenerator::MakeFromEncoded");
    std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
    SkBitmap* bitmap = new SkBitmap();
    if (bitmap->tryAllocPixels(generator->getInfo())) {
      DEBUG("  SkImageGenerator::getPixels");
      generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
    } else {
      RETURN_ERROR_V("Cannot alloc bitmap pixels.");
    }
  RETURN_V(bitmap, jlong);
}

JNIEXPORT jboolean JNICALL Java_org_crossmobile_backend_avian_SkBitmap_postInit
  (JNIEnv * env, jobject thiz, jlong bitmap) {
  INIT();
    jclass bitmapClass = findObjectClass(env, thiz);
    env->SetIntField(thiz, findField(env, bitmapClass, "width", "I"), ((SkBitmap*)bitmap)->width());
    env->SetIntField(thiz, findField(env, bitmapClass, "height", "I"), ((SkBitmap*)bitmap)->height());
  RETURN_V(1, jboolean);
}

JNIEXPORT jbyteArray JNICALL Java_org_crossmobile_backend_avian_SkBitmap_getBytesFromImage
  (JNIEnv *env, jclass clazz, jlong bitmap, jboolean asPNG, jdouble quality) {
  INIT();
    sk_sp<SkData> data = SkData::MakeEmpty();

    if (asPNG) {
      DEBUG("  SkEncodeBitmap to PNG");
      data = SkEncodeBitmap(*((SkBitmap*)bitmap), SkEncodedImageFormat::kPNG, quality);
    } else {
      DEBUG("  SkEncodeBitmap to JPEG");
      data = SkEncodeBitmap(*((SkBitmap*)bitmap), SkEncodedImageFormat::kJPEG, quality);
    }

    if (data->isEmpty())
      RETURN_ERROR_V("Bitmap has no data.");

  RETURN_V((uint8_t (*)[data->size()]) data->bytes(), jbyteArray);
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SkBitmap_extractAlpha
  (JNIEnv *env, jclass clazz, jlong sourceBitmap, jlong targetBitmap) {
  INIT();
    ((SkBitmap*) sourceBitmap)->extractAlpha((SkBitmap*) targetBitmap);
  RETURN();
  }