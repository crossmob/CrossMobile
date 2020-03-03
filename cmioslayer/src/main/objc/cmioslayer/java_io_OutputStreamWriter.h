/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_Writer.h"
#import "java_lang_String.h"
#import "java_io_OutputStream.h"


// java.io.OutputStreamWriter
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_OutputStreamWriter : java_io_Writer {
	java_io_OutputStream* outputStream;
}

- (id) initWithOutputStream:(java_io_OutputStream*)outStream;

- (instancetype) __init_java_io_OutputStreamWriter___java_io_OutputStream: (java_io_OutputStream*)outStream;

- (void) write___java_lang_String_int_int: (java_lang_String*)str: (int)off: (int)len;
- (void) write___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len;
- (void) write___int: (int) c;
- (void) close__;
- (void) flush__;

@end
