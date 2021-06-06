// JNI file org_crossmobile_backend_aroma_SDLWindow.c

#include"org_crossmobile_backend_aroma_SDLWindow.h"
#include "aroma.h"

#include "SDL.h"

JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_aroma_SDLWindow_init
  (JNIEnv *env, jclass clazz, jstring title) {
  INIT();
    const char* ctitle = env->GetStringUTFChars(title, 0);
    SDL_Window* window = SDL_CreateWindow(
      ctitle,
      SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,
      80,
      80,
      SDL_WINDOW_RESIZABLE
    );
    env->ReleaseStringUTFChars(title, ctitle);
  RETURN_V(window, jlong);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SDLWindow_setSize
  (JNIEnv *env, jclass clazz, jlong window, jint width, jint height) {
  INIT();
    SDL_SetWindowSize((SDL_Window*)window, width, height);
  RETURN();
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SDLWindow_destroy
  (JNIEnv *env, jobject thiz, jlong window) {
  INIT();
    SDL_DestroyWindow((SDL_Window*)window);
  RETURN();
}


JNIEXPORT jint JNICALL Java_org_crossmobile_backend_aroma_SDLWindow_getWidth
  (JNIEnv *env, jclass clazz, jlong window) {
  INIT();
    SDL_Surface* surface = SDL_GetWindowSurface((SDL_Window*)window);
  RETURN_V(surface->w, jint);
}


JNIEXPORT jint JNICALL Java_org_crossmobile_backend_aroma_SDLWindow_getHeight
  (JNIEnv *env, jclass clazz, jlong window) {
  INIT();
    SDL_Surface* surface = SDL_GetWindowSurface((SDL_Window*)window);
  RETURN_V(surface->h, jint);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_aroma_SDLWindow_update
  (JNIEnv *env, jclass clazz, jlong window) {
  INIT();
    SDL_UpdateWindowSurface((SDL_Window*)window);
  RETURN();
}
