/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_InputStream.h"
CM_EXPORT_CLASS
@interface java_io_BufferedInputStream : java_io_InputStream {
	java_io_InputStream *target;
}

- (instancetype) __init_java_io_BufferedInputStream___java_io_InputStream: (java_io_InputStream *) stream;
- (instancetype) __init_java_io_BufferedInputStream___java_io_InputStream_int: (java_io_InputStream *) stream: (int) size;

@end
