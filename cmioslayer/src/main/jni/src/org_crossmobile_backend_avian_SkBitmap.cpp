// JNI file org_crossmobile_backend_avian_SkBitmap.c

#include"org_crossmobile_backend_avian_SkBitmap.h"

#include "include/core/SkBitmap.h"
#include "include/core/SkTextBlob.h"
#include "include/core/SkImageGenerator.h"
#include "include/core/SkRRect.h"

#include "avian/system/system.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromFileName
  (JNIEnv *env, jclass clazz, jstring jpath) {

  const char *path = env->GetStringUTFChars(jpath, 0);

  sk_sp<SkData> data = SkData::MakeFromFileName(path);

  SkBitmap* bitmap;
  std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
  if(bitmap->tryAllocPixels(generator->getInfo())) {
    generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
  }
  // Memory management step
  // Keep in mind:
  // No new — no delete. In the same way, no malloc (or calloc or realloc) — no free
  env->ReleaseStringUTFChars(jpath, path);
  return (jlong)bitmap;
}

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SkBitmap_initFromBlob
  (JNIEnv *env, jclass clazz, jlong blobPeer) {

  
  vm::System::Region* region = reinterpret_cast<vm::System::Region*>(blobPeer);
  sk_sp<SkData> data = SkData::MakeWithCopy(region->start(), region->length());

  SkBitmap* bitmap;
  std::unique_ptr<SkImageGenerator> generator(SkImageGenerator::MakeFromEncoded(std::move(data)));
  if(bitmap->tryAllocPixels(generator->getInfo())) {
    generator->getPixels(generator->getInfo().makeColorSpace(NULL), bitmap->getPixels(), bitmap->rowBytes());
  }
  return (jlong)bitmap;
}
