/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

CM_EXPORT_CLASS
@interface java_io_Writer : java_lang_Object {
	java_lang_Object* lock;
	XMLVMArray* writeBuffer;
}

- (java_lang_Object*) protectedLock;

- (instancetype) __init_java_io_Writer__;
- (instancetype) __init_java_io_Writer__java_lang_Object: (java_lang_Object*)lockObject;

- (void) close__;
- (void) flush__;
- (void) write___char_ARRAYTYPE: (XMLVMArray *) cbuf;
- (void) write___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len;
- (void) write___int: (int) c;
- (void) write___java_lang_String: (java_lang_String*) str;
- (void) write___java_lang_String_int_int: (java_lang_String*) str: (int) off: (int) len;

@end
