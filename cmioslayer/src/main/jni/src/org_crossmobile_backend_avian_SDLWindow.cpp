// JNI file org_crossmobile_backend_avian_SDLWindow.c

#include"org_crossmobile_backend_avian_SDLWindow.h"

#include "SDL.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SDLWindow_init
  (JNIEnv *env, jclass clazz, jstring jtitle) {
  const char* title = env->GetStringUTFChars(jtitle, 0);
  double width = 600; 
  double height = 400;

  SDL_Window* window = SDL_CreateWindow(
    title,
    SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,
    width,
    height,
    SDL_WINDOW_RESIZABLE
  );
  
  env->ReleaseStringUTFChars(jtitle, title);

  if (window == NULL) {
    fprintf(stderr, "could not create window: %s\n", SDL_GetError());
    return 0;
  }

  SDL_AllocFormat(SDL_GetWindowPixelFormat(window));

  return (jlong)window;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SDLWindow_setSize
  (JNIEnv *env, jclass clazz, jlong peer, jint jwidth, jint jheight) {
  SDL_Window* window = (SDL_Window*)peer;
  double width = (double)jwidth; 
  double height = (double)jheight;
  SDL_SetWindowSize(window, width, height);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SDLWindow_destroy
  (JNIEnv *env, jobject thiz, jlong peer) {
  SDL_Window* window = (SDL_Window*)peer;
  SDL_DestroyWindow(window);
}


JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getWidth
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Window* window = (SDL_Window*)peer;
  SDL_Surface* surface = SDL_GetWindowSurface(window);
  return (jint)surface->w;
}


JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getHeight
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Window* window = (SDL_Window*)peer;
  SDL_Surface* surface = SDL_GetWindowSurface(window);
  return (jint)surface->h;
}


JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getPixels
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Window* window = (SDL_Window*)peer;
  SDL_Surface* surface = SDL_GetWindowSurface(window);
  return (jlong)surface->pixels;
}


JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getPitch
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Window* window = (SDL_Window*)peer;
  SDL_Surface* surface = SDL_GetWindowSurface(window);
  return (jint)surface->pitch;
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SDLWindow_update
  (JNIEnv *env, jclass clazz, jlong peer) {
  SDL_Window* window = (SDL_Window*)peer;
  SDL_UpdateWindowSurface(window);
}
