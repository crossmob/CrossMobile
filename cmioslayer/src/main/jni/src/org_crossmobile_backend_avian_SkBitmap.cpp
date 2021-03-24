// JNI file org_crossmobile_backend_avian_SkBitmap.c

#include"org_crossmobile_backend_avian_SkBitmap.h"
#include "aroma.h"

#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkImageEncoder.h"
#include "include/core/SkRRect.h"

#include "avian/system/system.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromBlob
  (JNIEnv *env, jclass clazz, jlong blobPeer) {
  INIT();
    DEBUG("  vm::System::Region reinterpret_cast in %s in line %d\n", __FILE__, __LINE__);
    vm::System::Region* region = reinterpret_cast<vm::System::Region*>(blobPeer);
    DEBUG("  SkData::MakeWithCopy in %s in line %d\n", __FILE__, __LINE__);
    sk_sp<SkData> data = SkData::MakeWithCopy(region->start(), region->length());

    if (data->isEmpty())
      RETURN_ERROR_V("Bitmap has no data.\n");

    DEBUG("  SkImageGenerator::MakeFromEncoded in %s in line %d\n", __FILE__, __LINE__);
    std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
    SkBitmap* bitmap = new SkBitmap();
    if (bitmap->tryAllocPixels(generator->getInfo())) {
      DEBUG("  SkImageGenerator::getPixels in %s in line %d\n", __FILE__, __LINE__);
      generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
    } else {
      RETURN_ERROR_V("Cannot alloc bitmap pixels.\n");
    }
  RETURN_V(bitmap, jlong);
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromByteArray
  (JNIEnv *env, jclass clazz, jbyteArray array) {
  INIT();
    jbyte* bufferPtr = env->GetByteArrayElements(array, NULL);
    jsize lengthOfArray = env->GetArrayLength(array);
    DEBUG("  SkData::MakeWithCopy in %s in line %d\n", __FILE__, __LINE__);
    sk_sp<SkData> data = SkData::MakeWithCopy(bufferPtr, lengthOfArray);
    env->ReleaseByteArrayElements(array, bufferPtr, 0);

    if (data->isEmpty())
      RETURN_ERROR_V("Bitmap has no data.\n");

    DEBUG("  SkImageGenerator::MakeFromEncoded in %s in line %d\n", __FILE__, __LINE__);
    std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
    SkBitmap* bitmap = new SkBitmap();
    if (bitmap->tryAllocPixels(generator->getInfo())) {
      DEBUG("  SkImageGenerator::getPixels in %s in line %d\n", __FILE__, __LINE__);
      generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
    } else {
      RETURN_ERROR_V("Cannot alloc bitmap pixels.\n");
    }
  RETURN_V(bitmap, jlong);
}

JNIEXPORT jbyteArray JNICALL Java_org_crossmobile_backend_avian_SkBitmap_getBytesFromImage
  (JNIEnv *env, jclass clazz, jlong bitmap, jboolean asPNG, jdouble quality) {
  INIT();
    sk_sp<SkData> data = SkData::MakeEmpty();

    if (asPNG) {
      DEBUG("  SkEncodeBitmap to PNG in %s in line %d\n", __FILE__, __LINE__);
      data = SkEncodeBitmap(*((SkBitmap*)bitmap), SkEncodedImageFormat::kPNG, quality);
    } else {
      DEBUG("  SkEncodeBitmap to JPEG in %s in line %d\n", __FILE__, __LINE__);
      data = SkEncodeBitmap(*((SkBitmap*)bitmap), SkEncodedImageFormat::kJPEG, quality);
    }

    if (data->isEmpty())
      RETURN_ERROR_V("Bitmap has no data.\n");

  RETURN_V((uint8_t (*)[data->size()]) data->bytes(), jbyteArray);
}