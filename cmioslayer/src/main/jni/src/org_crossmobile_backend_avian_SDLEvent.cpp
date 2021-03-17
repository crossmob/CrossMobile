// JNI file org_crossmobile_backend_avian_SDLEvent.c

#include"org_crossmobile_backend_avian_SDLEvent.h"
#include "aroma_debug.h"

#include "SDL.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SDLEvent_initSDLEvent
  (JNIEnv *env, jclass clazz) {
  SDL_Event event;
  return (jlong)&event;
}


JNIEXPORT jboolean JNICALL Java_org_crossmobile_backend_avian_SDLEvent_pollEvent
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Event event;
  return (jboolean)SDL_PollEvent(&event);
}


JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLEvent_getType
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Event* event = (SDL_Event*)peer;
  return (jint)event->type;
}


JNIEXPORT jbyte JNICALL Java_org_crossmobile_backend_avian_SDLEvent_getWindowEvent
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Event* event = (SDL_Event*)peer;
  return (jbyte)event->window.event;
}
