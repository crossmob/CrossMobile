/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_BufferedWriter.h"
#import "java_io_IOException.h"
#import "java_lang_IllegalArgumentException.h"
#import "java_lang_IndexOutOfBoundsException.h"
#import "java_lang_System.h"

// java.io.BufferedWriter
//----------------------------------------------------------------------------
@implementation java_io_BufferedWriter

- (id) init
{
	self = [super init];
	writer = (java_io_Writer*) JAVA_NULL;
	cb = (XMLVMArray*) JAVA_NULL;
	return self;
}

- (id) initWithWriter:(java_io_Writer*)ioWriter
{
	[super init];
	[self __init_java_io_BufferedWriter___java_io_Writer:ioWriter];
	return self;
}

- (instancetype) __init_java_io_BufferedWriter___java_io_Writer: (java_io_Writer*)ioWriter
{
	int defaultCharBufferSize = 8192;
	return [self __init_java_io_BufferedWriter___java_io_Writer_int:ioWriter:defaultCharBufferSize];
}

- (instancetype) __init_java_io_BufferedWriter___java_io_Writer_int: (java_io_Writer*)ioWriter: (int)sz
{
	self = [super __init_java_io_Writer__java_lang_Object:ioWriter];
	if (sz <= 0) {
		java_lang_IllegalArgumentException* ex = [[java_lang_IllegalArgumentException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"Buffer size <= 0"];
		[ex __init_java_lang_IllegalArgumentException___java_lang_String:str];
		[str release];
		@throw ex;
	}
	[ioWriter retain];
	self->writer = ioWriter;
	cb = [XMLVMArray createSingleDimensionWithType: 2 andSize:sz]; //char array
//	[cb retain];

	nChars = sz;
	nextChar = 0;
    return self;
}

- (void) ensureOpen
{
	if (writer == (java_io_Writer*) JAVA_NULL) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"Stream closed!"];
		[ex __init_java_io_IOException___java_lang_String:str];
		[str release];
		@throw ex;
	}
}

- (void) write___int: (int) c
{
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		if (nextChar >= nChars) {
			[self flushBuffer__];
		}
		cb->array.c[nextChar++] = (char)c;
	}
}

- (int) min:(int)a:(int)b
{
	return a < b ? a : b;
}

- (void) write___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len
{
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		if (off < 0 || off > [cbuf count] || len < 0 ||
			(off + len) > [cbuf count] || (off + len) < 0) {

			java_lang_IndexOutOfBoundsException* ex = [[java_lang_IndexOutOfBoundsException alloc] init];
			[ex __init_java_lang_IndexOutOfBoundsException__];
			@throw ex;
		} else if (len == 0) {
			return;
		}

		if (len >= nChars) {
			[self flushBuffer__];
			[writer write___char_ARRAYTYPE_int_int:cbuf:off:len];
			return;
		}

		int b = off;
		int t = off + len;
		while (b < t) {
			int d = [self min:nChars - nextChar:t-b];
			[java_lang_System arraycopy___java_lang_Object_int_java_lang_Object_int_int:cbuf:b:cb:nextChar:d];
			b += d;
			nextChar += d;
			if (nextChar >= nChars) {
				[self flushBuffer__];
			}
		}
	}
}

- (void) write___java_lang_String_int_int: (java_lang_String*)str: (int)off: (int)len
{
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		int b = off;
		int t = off + len;
		while (b < t) {
			int d = [self min:nChars - nextChar:t - b];
			[str getChars___int_int_char_ARRAYTYPE_int:b:b+d:cb:nextChar];
			b += d;
			nextChar += d;
			if (nextChar >= nChars) {
				[self flushBuffer__];
			}
		}
	}
}

- (void) newLine__
{
	NSMutableString* str = [[NSMutableString alloc] initWithString:@"\n"];
	[self write___java_lang_String:str];
	[str release];
}

- (void) close__
{
	@synchronized([self protectedLock]) {
		if (writer == (java_io_Writer*) JAVA_NULL) {
			return;
		}
		@try {
			[self flushBuffer__];
		}
		@finally {
			[writer close__];

			[writer release];
			[cb release];
			writer = (java_io_Writer*) JAVA_NULL;
			cb = (XMLVMArray*) JAVA_NULL;
		}
	}
}

- (void) flushBuffer__
{
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		if (nextChar == 0) {
			return;
		}
		[writer write___char_ARRAYTYPE_int_int:cb:0:nextChar];
		nextChar = 0;
	}
}

- (void) flush__
{
	@synchronized([self protectedLock]) {
		[self flushBuffer__];
		[writer flush__];
	}
}

- (void)dealloc
{
	[writer release];
	[cb release];
	[super dealloc];
}

@end
