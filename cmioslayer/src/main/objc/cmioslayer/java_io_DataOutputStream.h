/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_OutputStream.h"
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_DataOutputStream: java_io_OutputStream {
	java_io_OutputStream* target;
}

- (instancetype) __init_java_io_DataOutputStream___java_io_OutputStream: (java_io_OutputStream *) stream;
- (void) writeInt___int: (int) v;
- (void) writeDouble___double: (double) v;
- (void) writeByte___int: (int) v;
- (void) writeBoolean___boolean: (int) v;
- (void) write___int: (int) i;
- (void) close__;
- (void) flush__;
- (void) dealloc;

@end
