/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_InputStream.h"
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_DataInputStream: java_io_InputStream {
	java_io_InputStream* target;
}

- (instancetype) __init_java_io_DataInputStream___java_io_InputStream: (java_io_InputStream*) stream;
- (void) dealloc;

- (int) readInt__;
- (int) readByte__;
- (bool) readBoolean__;
- (float) readFloat__;
- (double) readDouble__;
@end
