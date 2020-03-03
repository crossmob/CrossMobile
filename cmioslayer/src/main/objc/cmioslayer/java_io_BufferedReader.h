/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_io_Reader.h"
#import "java_lang_StringBuilder.h"
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_BufferedReader : java_io_Reader {
	java_io_Reader *target;
	XMLVMArray* cb;
	int nChars;
	int nextChar;
	int markedChar;
	int readAheadLimit;
	BOOL skipLF;
	BOOL markedSkipLF;
}

//Private methods
- (void) ensureOpen;
- (void) fill;
- (int) read1: (XMLVMArray *) cbuf: (int) off: (int) len;

+ (void) appendChars: (java_lang_StringBuilder*)sb : (XMLVMArray*)src: (int)offset: (int)count;

//Protected or Package methods
- (java_lang_String*) readLine___boolean:(BOOL)ignoreLF;

//Public methods
- (instancetype) __init_java_io_BufferedReader___java_io_Reader: (java_io_Reader *) reader;
- (instancetype) __init_java_io_BufferedReader___java_io_Reader_int: (java_io_Reader *) reader: (int) sz;
- (int) read__;
- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len;
- (bool) ready__;
- (void) mark___int: (int) readAheadLimitArg;
- (BOOL) markSupported__;
- (java_lang_String*) readLine__;
- (JAVA_LONG) skip___long: (JAVA_LONG) n;
- (void) reset__;
- (void) close__;

@end
