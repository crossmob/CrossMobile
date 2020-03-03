/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_String.h"

@class java_io_File;
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@protocol java_io_FilenameFilter

- (bool) accept___java_io_File_java_lang_String :(java_io_File*) dir :(java_lang_String*) name;

@end

@interface java_io_FilenameFilter : java_lang_Object <java_io_FilenameFilter>
@end

