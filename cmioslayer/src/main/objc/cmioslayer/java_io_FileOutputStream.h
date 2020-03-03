/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_File.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_io_OutputStream.h"
#import "java_io_FileDescriptor.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_FileOutputStream : java_io_OutputStream {
	java_io_FileDescriptor* fd;
	NSFileHandle *fdImpl;
}

- (instancetype) __init_java_io_FileOutputStream___java_lang_String: (java_lang_String*) f;
- (instancetype) __init_java_io_FileOutputStream___java_io_File: (java_io_File*) f;
- (instancetype) __init_java_io_FileOutputStream___java_io_File_boolean: (java_io_File *) f : (bool) append; 

@end
