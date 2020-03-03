/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_Reader.h"
#import "java_io_InputStream.h"
#import "java_lang_String.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_InputStreamReader : java_io_Reader {
	java_io_InputStream *target;
}

- (instancetype) __init_java_io_InputStreamReader___java_io_InputStream: (java_io_InputStream *) input;
- (instancetype) __init_java_io_InputStreamReader___java_io_InputStream_java_lang_String: (java_io_InputStream*) input: (java_lang_String*) charsetName;
- (int) read__;
- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len;
- (bool) ready__;
- (void) close__;

@end
