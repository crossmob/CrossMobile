// JNI file org_crossmobile_backend_avian_AvianGraphicsBridge.c

#include"org_crossmobile_backend_avian_AvianGraphicsBridge.h"

#include "SDL.h"

JNIEXPORT jboolean JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_initSDL
  (JNIEnv *env, jclass clazz) {
  if (SDL_Init(SDL_INIT_VIDEO) < 0) {
    fprintf(stderr, "Could not initialize SDL2: %s\n", SDL_GetError());
    return 0;
  }
  return 1;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_quitSDL
  (JNIEnv *env, jclass clazz) {
  SDL_Quit();
}


JNIEXPORT jobject JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_pollSDLEvents
  (JNIEnv *env, jclass clazz) {
    return NULL;
}
