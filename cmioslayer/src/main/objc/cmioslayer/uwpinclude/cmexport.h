#pragma once

#if defined(_WIN32) || defined(WIN32)
#define CM_EXPORT_CLASS UIKIT_EXPORT_CLASS
#define CM_EXPORT UIKIT_EXPORT
#else
#define CM_EXPORT_CLASS 
#define CM_EXPORT extern
#endif