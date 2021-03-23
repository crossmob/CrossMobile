// JNI file org_crossmobile_backend_avian_SkBitmap.c

#include"org_crossmobile_backend_avian_SkBitmap.h"
#include "aroma.h"

#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkRRect.h"

#include "avian/system/system.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromFileName
  (JNIEnv *env, jclass clazz, jstring jpath) {
  INIT();
  const char *path = env->GetStringUTFChars(jpath, 0);
  sk_sp<SkData> data = SkData::MakeFromFileName(path);
  SkBitmap* bitmap = new SkBitmap();
  std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
  if(bitmap->tryAllocPixels(generator->getInfo())) {
    generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
  }
  // Memory management step
  // Keep in mind:
  // No new — no delete. In the same way, no malloc (or calloc or realloc) — no free
  env->ReleaseStringUTFChars(jpath, path);
  RETURN_V(bitmap, jlong);
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromBlob
  (JNIEnv *env, jclass clazz, jlong blobPeer) {
  INIT();
  vm::System::Region* region = reinterpret_cast<vm::System::Region*>(blobPeer);
  sk_sp<SkData> data = SkData::MakeWithCopy(region->start(), region->length());
  SkBitmap* bitmap = new SkBitmap();
  std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
  if(bitmap->tryAllocPixels(generator->getInfo())) {
    generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
  }
  RETURN_V(bitmap, jlong);
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromByteArray
  (JNIEnv *env, jclass clazz, jbyteArray array) {
  INIT();

  jbyte* bufferPtr = env->GetByteArrayElements(array, NULL);
  jsize lengthOfArray = env->GetArrayLength(array);

  sk_sp<SkData> data = SkData::MakeWithCopy(bufferPtr, lengthOfArray);

  SkBitmap* bitmap = new SkBitmap();
  std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
  if(bitmap->tryAllocPixels(generator->getInfo())) {
    generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
  }

  env->ReleaseByteArrayElements(array, bufferPtr, 0);
  RETURN_V(bitmap, jlong);
}