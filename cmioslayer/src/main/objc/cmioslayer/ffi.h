#if TARGET_OS_SIMULATOR
#   if TARGET_CPU_X86_64
#       include "x86_64_ffi.h"
#   else
#       include "i386_ffi.h"
#   endif
#else
#   if TARGET_CPU_ARM64
#       include "arm64_ffi.h"
#   else
#       include "armv7_ffi.h"
#   endif
#endif
