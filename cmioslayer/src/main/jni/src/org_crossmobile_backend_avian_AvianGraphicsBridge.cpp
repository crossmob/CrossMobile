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
  jclass eventClass;
  jmethodID eventMethod;
  SDL_Event event;
  if (!SDL_PollEvent(&event)) {
    return 0; // Means NULL
  } else {
    switch (event.type) {
      case SDL_MOUSEMOTION:
        eventClass = env->FindClass("org/crossmobile/backend/avian/event/MouseMotionEvent");
        eventMethod = env->GetMethodID(eventClass, "<init>", "(III)V");
        return env->NewObject(eventClass,
                              eventMethod,
                              event.motion.x, event.motion.y, event.motion.state);
      case SDL_MOUSEBUTTONDOWN:
        eventClass = env->FindClass("org/crossmobile/backend/avian/event/MouseButtonEvent");
        eventMethod = env->GetMethodID(eventClass, "<init>", "(IIIZ)V");
        return env->NewObject(eventClass,
                              eventMethod,
                              SDL_BUTTON(event.button.button), event.button.x, event.button.y, event.button.state);
      case SDL_MOUSEBUTTONUP:
        eventClass = env->FindClass("org/crossmobile/backend/avian/event/MouseButtonEvent");
        eventMethod = env->GetMethodID(eventClass, "<init>", "(IIIZ)V");
        return env->NewObject(eventClass,
                              eventMethod,
                              SDL_BUTTON(event.button.button), event.button.x, event.button.y, event.button.state);
      case SDL_WINDOWEVENT:
        eventClass = env->FindClass("org/crossmobile/backend/avian/event/WindowEvent");
        eventMethod = env->GetMethodID(eventClass, "<init>", "(I)V");
        return env->NewObject(eventClass,
                              eventMethod,
                              event.window.event);
      default:
          return 0; // Means NULL
    }
  }
}
