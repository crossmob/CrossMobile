/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

CM_EXPORT_CLASS
@interface java_io_InputStream : java_lang_Object 
- (instancetype) __init_java_io_InputStream__;
- (int) available__;
- (bool) markSupported__;
- (void) mark___int: (int) readlimit;
- (void) mark___long: (JAVA_LONG) readlimit;
- (int) read__;
- (int) read___byte_ARRAYTYPE: (XMLVMArray *) buffer;
- (int) read___byte_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len;
- (void) close__;
- (void) reset__;
- (JAVA_LONG) skip___long: (JAVA_LONG) n;
@end
