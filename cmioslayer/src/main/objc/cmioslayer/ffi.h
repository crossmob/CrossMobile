#if TARGET_OS_SIMULATOR
#   if TARGET_CPU_X86_64
#       import "x86_64_ffi.h"
#   else
#       import "i386_ffi.h"
#   endif
#else
#   if TARGET_CPU_ARM64
#       import "arm64_ffi.h"
#   else
#       import "armv7_ffi.h"
#   endif
#endif
