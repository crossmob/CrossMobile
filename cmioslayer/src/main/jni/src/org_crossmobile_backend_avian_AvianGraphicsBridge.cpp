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

///* Print all information about a key event */
//void PrintKeyInfo( SDL_KeyboardEvent *key ){
//  /* Is it a release or a press? */
//  if( key->type == SDL_KEYUP )
//      printf( "Release:- " );
//  else
//      printf( "Press:- " );
//
//  /* Print the hardware scancode first */
//  printf( "Scancode: 0x%02X", key->keysym.scancode );
//  /* Print the name of the key */
//  printf( ", Name: %s", SDL_GetKeyName( key->keysym.sym ) );
//  /* We want to print the unicode info, but we need to make */
//  /* sure its a press event first (remember, release events */
//  /* don't have unicode info                                */
//  if( key->type == SDL_KEYDOWN ){
//      /* If the Unicode value is less than 0x80 then the    */
//      /* unicode value can be used to get a printable       */
//      /* representation of the key, using (char)unicode.    */
//      printf(", Unicode: " );
//      if( key->keysym.unicode < 0x80 && key->keysym.unicode > 0 ){
//          printf( "%c (0x%04X)", (char)key->keysym.unicode,
//                  key->keysym.unicode );
//      }
//      else{
//          printf( "? (0x%04X)", key->keysym.unicode );
//      }
//  }
//  printf( "\n" );
//  /* Print modifier info */
//  PrintModifiers( key->keysym.mod );
//}
//
///* Print modifier info */
//void PrintModifiers( SDLMod mod ){
//  printf( "Modifers: " );
//
//  /* If there are none then say so and return */
//  if( mod == KMOD_NONE ){
//      printf( "None\n" );
//      return;
//  }
//
//  /* Check for the presence of each SDLMod value */
//  /* This looks messy, but there really isn't    */
//  /* a clearer way.                              */
//  if( mod & KMOD_NUM ) printf( "NUMLOCK " );
//  if( mod & KMOD_CAPS ) printf( "CAPSLOCK " );
//  if( mod & KMOD_LCTRL ) printf( "LCTRL " );
//  if( mod & KMOD_RCTRL ) printf( "RCTRL " );
//  if( mod & KMOD_RSHIFT ) printf( "RSHIFT " );
//  if( mod & KMOD_LSHIFT ) printf( "LSHIFT " );
//  if( mod & KMOD_RALT ) printf( "RALT " );
//  if( mod & KMOD_LALT ) printf( "LALT " );
//  if( mod & KMOD_CTRL ) printf( "CTRL " );
//  if( mod & KMOD_SHIFT ) printf( "SHIFT " );
//  if( mod & KMOD_ALT ) printf( "ALT " );
//  printf( "\n" );
//}


JNIEXPORT jobject JNICALL Java_org_crossmobile_backend_avian_AvianGraphicsBridge_pollSDLEvents
  (JNIEnv *env, jclass clazz) {
  jclass eventClass;
  jmethodID eventConstrutor;
  jobject eventObject;
  SDL_Event event;
  if (!SDL_PollEvent(&event)) {
    return 0; // or NULL
  } else if (event.type == SDL_MOUSEMOTION) {
    eventClass = env->FindClass("org/crossmobile/backend/avian/SDLMouseEvent");
    eventConstrutor = env->GetMethodID(eventClass, "<init>", "(III)V");
    eventObject = env->NewObject(eventClass, eventConstrutor, SDL_MOUSEMOTION, event.motion.x, event.motion.y);
  } else if (event.type == SDL_MOUSEBUTTONDOWN) {
    eventClass = env->FindClass("org/crossmobile/backend/avian/SDLMouseEvent");
    eventConstrutor = env->GetMethodID(eventClass, "<init>", "(IIII)V");
    if (event.button.button == SDL_BUTTON_LEFT)
      eventObject = env->NewObject(eventClass, eventConstrutor, SDL_MOUSEBUTTONDOWN, SDL_BUTTON_LEFT, event.button.x, event.button.y);
    else if (event.button.button == SDL_BUTTON_RIGHT)
      eventObject = env->NewObject(eventClass, eventConstrutor, SDL_MOUSEBUTTONDOWN, SDL_BUTTON_RIGHT, event.button.x, event.button.y);
  } else if (event.type == SDL_WINDOWEVENT) {
    eventClass = env->FindClass("org/crossmobile/backend/avian/SDLWindowEvent");
    eventConstrutor = env->GetMethodID(eventClass, "<init>", "(II)V");
    if (event.window.event == SDL_WINDOWEVENT_CLOSE)
      eventObject = env->NewObject(eventClass, eventConstrutor, SDL_WINDOWEVENT, SDL_WINDOWEVENT_CLOSE);
    else
      eventObject = env->NewObject(eventClass, eventConstrutor, SDL_WINDOWEVENT, 0);
  }
  return eventObject;
}
