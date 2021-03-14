#ifndef AROMA_DEBUG_H
#define AROMA_DEBUG_H

#include <stdio.h>

#ifdef DEBUG_AROMA
# define DEBUG(fmt, args...) fprintf(stderr, fmt "\n", ## args)
#else
# define DEBUG(fmt, args...)
#endif

#define ERROR(fmt, args...) fprintf(stderr, fmt "\n", ## args)

#endif
