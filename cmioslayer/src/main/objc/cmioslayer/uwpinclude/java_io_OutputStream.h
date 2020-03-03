/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

CM_EXPORT_CLASS
@interface java_io_OutputStream : java_lang_Object

- (instancetype) __init_java_io_OutputStream__;
- (void) write___int: (int) i;
- (void) write___byte_ARRAYTYPE: (XMLVMArray *) data;
- (void) write___byte_ARRAYTYPE_int_int: (XMLVMArray *) data: (int) pos: (int) len;
- (void) flush__;
- (void) close__;

@end
