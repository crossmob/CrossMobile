/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_Writer.h"
#import "java_lang_String.h"
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_BufferedWriter : java_io_Writer {
	java_io_Writer* writer;
	XMLVMArray* cb;
	int nChars;
	int nextChar;
}

- (id) initWithWriter:(java_io_Writer*)ioWriter;

- (instancetype) __init_java_io_BufferedWriter___java_io_Writer: (java_io_Writer*)ioWriter;
- (instancetype) __init_java_io_BufferedWriter___java_io_Writer_int: (java_io_Writer*)ioWriter: (int)sz;

- (int) min:(int)a:(int)b;
- (void) ensureOpen;

- (void) write___int: (int) c;
- (void) write___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len;
- (void) write___java_lang_String_int_int: (java_lang_String*)str: (int)off: (int)len;
- (void) newLine__;
- (void) close__;
- (void) flushBuffer__;
- (void) flush__;

@end
