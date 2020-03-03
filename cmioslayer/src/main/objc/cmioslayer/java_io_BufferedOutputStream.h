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
@interface java_io_BufferedOutputStream : java_io_OutputStream {
	java_io_OutputStream *target;
}

- (instancetype) __init_java_io_BufferedOutputStream___java_io_OutputStream: (java_io_OutputStream *) stream;
- (instancetype) __init_java_io_BufferedOutputStream___java_io_OutputStream_int: (java_io_OutputStream *) stream: (int) size;

@end
