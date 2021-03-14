// JNI file org_crossmobile_backend_avian_AvianGraphicsBridge.c

#include "org_crossmobile_backend_avian_AvianGraphicsBridge.h"
#include "aroma_debug.h"

#include "SDL.h"

JNIEXPORT jboolean JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_initSDL
  (JNIEnv *env, jclass clazz) {
  DEBUG("Request to initialize SDL");
  if (SDL_Init(SDL_INIT_VIDEO) < 0) {
    ERROR("Could not initialize SDL, error code %s\n", SDL_GetError());
    return 0;
  }
  DEBUG("SDL initialized");
  return 1;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_quitSDL
  (JNIEnv *env, jclass clazz) {
  DEBUG("Request to quit SDL");
  SDL_Quit();
  DEBUG("SDL quit");
}


JNIEXPORT jobject JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_pollSDLEvents
  (JNIEnv *env, jclass clazz) {
    return NULL;
}
