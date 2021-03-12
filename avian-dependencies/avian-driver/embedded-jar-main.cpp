#include "stdint.h"
#include "stdlib.h"
#include "jni.h"

#if (defined __MINGW32__) || (defined _MSC_VER)
#  define EXPORT __declspec(dllexport)
#else
#  define EXPORT __attribute__ ((visibility("default"))) \
  __attribute__ ((used))
#endif

#if (! defined __x86_64__) && ((defined __MINGW32__) || (defined _MSC_VER))
#  define SYMBOL(x) binary_boot_jar_##x
#  define MAINCLASS(x) binary_mainclass_##x
#else
#  define SYMBOL(x) _binary_boot_jar_##x
#  define MAINCLASS(x) _binary_mainclass_##x
#endif

extern "C" {
  extern const uint8_t SYMBOL(start)[];
  extern const uint8_t SYMBOL(end)[];
  extern const char MAINCLASS(start)[];
  extern const char MAINCLASS(end)[];

  EXPORT const uint8_t*
  bootJar(size_t* size)
  {
    *size = SYMBOL(end) - SYMBOL(start);
    return SYMBOL(start);
  }


} // extern "C"

extern "C" void __cxa_pure_virtual(void) { abort(); }

int main(int ac, const char** av)
{

  JavaVMInitArgs vmArgs;
  vmArgs.version = JNI_VERSION_1_2;
  vmArgs.nOptions = 1;
  vmArgs.ignoreUnrecognized = JNI_TRUE;

  JavaVMOption options[vmArgs.nOptions];
  vmArgs.options = options;
  options[0].optionString = const_cast<char*>("-Xbootclasspath:[bootJar]");
  JavaVM* vm;
  void* env;
  JNI_CreateJavaVM(&vm, &env, &vmArgs);
  JNIEnv* e = static_cast<JNIEnv*>(env);
  // Reusable stuff
  jclass entrypoint;
  jmethodID method;
  // Main method requires
  jclass stringClass;
  jobjectArray array;
  // My functions
  jint init;
  jint quit;

  entrypoint = e->FindClass(MAINCLASS(start));
  if (not e->ExceptionCheck()) {
    method = e->GetStaticMethodID(entrypoint, "main", "([Ljava/lang/String;)V");
    if (not e->ExceptionCheck()) {
      stringClass = e->FindClass("java/lang/String");
      if (not e->ExceptionCheck()) {
        array = e->NewObjectArray(ac-1, stringClass, 0);
        if (not e->ExceptionCheck()) {
          for (int i = 1; i < ac; ++i) {
            e->SetObjectArrayElement(array, i-1, e->NewStringUTF(av[i]));
          }
          e->CallStaticVoidMethod(entrypoint, method, array);
        }
      }
    }
  }

  int exitCode = 0;
  if (e->ExceptionCheck()) {
    exitCode = -1;
    e->ExceptionDescribe();
  }

  vm->DestroyJavaVM();

  return exitCode;
}
