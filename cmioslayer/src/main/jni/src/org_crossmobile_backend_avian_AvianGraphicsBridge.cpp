// JNI file org_crossmobile_backend_avian_AvianGraphicsBridge.c

#include "org_crossmobile_backend_avian_AvianGraphicsBridge.h"
#include "aroma.h"

#include "SDL.h"

JNIEXPORT jboolean JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_initSDL
  (JNIEnv *env, jclass clazz) {
  INIT();
    if (SDL_Init(SDL_INIT_VIDEO) < 0)
      RETURN_ERROR_V("Could not initialize SDL: %s", SDL_GetError());
  RETURN_V(1,int);
}


JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_quitSDL
  (JNIEnv *env, jclass clazz) {
  INIT();
    SDL_Quit();
  RETURN();
}

JNIEXPORT jobject JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_pollSDLEvents
  (JNIEnv *env, jclass clazz) {
  INIT();
    jclass eventClass;
    jmethodID eventMethod;
    SDL_Event event;

    jobject result = 0;
    //NOTE: This is not performed on the same thread that we redraw our screen
    if (SDL_WaitEvent(&event)) {
      switch (event.type) {
        case SDL_MOUSEMOTION:
          DEBUG("  SDL_MOUSEMOTION");
          eventClass = findClass(env, "org/crossmobile/backend/avian/event/MouseMotionEvent");
          eventMethod = findMethod(env, eventClass, "<init>", "(III)V");
          result = env->NewObject(eventClass,
                                eventMethod,
                                event.motion.x, event.motion.y, event.motion.state);
          break;
        case SDL_MOUSEBUTTONDOWN:
          DEBUG("  SDL_MOUSEBUTTONDOWN");
          eventClass = findClass(env, "org/crossmobile/backend/avian/event/MouseButtonEvent");
          eventMethod = findMethod(env, eventClass, "<init>", "(IIIZ)V");
          result = env->NewObject(eventClass,
                                eventMethod,
                                SDL_BUTTON(event.button.button), event.button.x, event.button.y, event.button.state);
          break;
        case SDL_MOUSEBUTTONUP:
          DEBUG("  SDL_MOUSEBUTTONUP");
          eventClass = findClass(env, "org/crossmobile/backend/avian/event/MouseButtonEvent");
          eventMethod = findMethod(env, eventClass, "<init>", "(IIIZ)V");
          result = env->NewObject(eventClass,
                                eventMethod,
                                SDL_BUTTON(event.button.button), event.button.x, event.button.y, event.button.state);
          break;
        case SDL_WINDOWEVENT:
          DEBUG("  SDL_WINDOWEVENT");
          eventClass = findClass(env, "org/crossmobile/backend/avian/event/WindowEvent");
          eventMethod = findMethod(env, eventClass, "<init>", "(I)V");
          result = env->NewObject(eventClass,
                                eventMethod,
                                event.window.event);
          break;
        case SDL_QUIT:
          DEBUG("  SDL_QUIT");
          eventClass = findClass(env, "org/crossmobile/backend/avian/event/QuitEvent");
          eventMethod = findMethod(env, eventClass, "<init>", "()V");
          result = env->NewObject(eventClass, eventMethod);
          break;
        default:
          break;
      }
    } else {
        RETURN_ERROR_V("Unable to retrieve event: %s", SDL_GetError());
    }
  RETURN_V(result,jobject);
}

JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_setDebugLevel
  (JNIEnv * env, jclass cls, jint level) {
  DEBUG_LEVEL = level;
}