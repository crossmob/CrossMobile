/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_Reader : java_lang_Object {
	java_lang_Object* lock;
	XMLVMArray* skipBuffer;
}

- (java_lang_Object*) protectedLock;

- (instancetype) __init_java_io_Reader__;
- (instancetype) __init_java_io_Reader___java_lang_Object: (java_lang_Object*) lockObject;

- (int) read__;
- (int) read___char_ARRAYTYPE: (XMLVMArray *) buffer;
- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len;
- (bool) ready__;
- (void) mark___int: (int) readAheadLimit;
- (BOOL) markSupported__;
- (JAVA_LONG) skip___long: (JAVA_LONG) n;
- (void) reset__;
- (void) close__;

@end
