/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_io_File.h"
#import "java_io_FileDescriptor.h"
#import "java_io_InputStream.h"
CM_EXPORT_CLASS
@interface java_io_FileInputStream : java_io_InputStream {

	java_io_FileDescriptor* fd;
	unsigned long int marked;
}

- (instancetype) __init_java_io_FileInputStream___java_io_File: (java_io_File*) f;
- (instancetype) __init_java_io_FileInputStream___java_lang_String :(java_lang_String*) path;
- (void) dealloc;
- (instancetype) __init_java_io_FileInputStream___java_io_FileDescriptor: (java_io_FileDescriptor*) fd;
- (int) available__;
- (java_io_FileDescriptor*) getFD__;

@end
