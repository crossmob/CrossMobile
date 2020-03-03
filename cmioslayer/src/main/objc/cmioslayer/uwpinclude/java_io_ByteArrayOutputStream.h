/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_OutputStream.h"

static int const DEFAULT_CAPACITY;
CM_EXPORT_CLASS
@interface java_io_ByteArrayOutputStream : java_io_OutputStream {
	NSMutableData *buffer;
}

- (void) dealloc;
- (instancetype) __init_java_io_ByteArrayOutputStream__;
- (instancetype) __init_java_io_ByteArrayOutputStream___int: (int) size;
- (void) writeTo___java_io_OutputStream: (java_io_OutputStream*) os;
- (void) write___int:(int)i;
- (XMLVMArray *) toByteArray__;
- (void) reset__;

@end
