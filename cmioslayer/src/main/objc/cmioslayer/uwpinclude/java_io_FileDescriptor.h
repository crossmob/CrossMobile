/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
CM_EXPORT_CLASS
@interface java_io_FileDescriptor : java_lang_Object {
	NSFileHandle *fd;
}

- (instancetype) __init_java_io_FileDescriptor__;
- (instancetype) __init_java_io_FileDescriptor___NSFileHandle: (NSFileHandle *) fd;
- (bool) valid__;
- (void) dealloc;
- (NSFileHandle*) fileHandle;
- (void) invalidate;

@end
