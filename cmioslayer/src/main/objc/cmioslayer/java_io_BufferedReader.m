/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_BufferedReader.h"
#import "java_io_IOException.h"
#import "java_lang_IllegalArgumentException.h"
#import "java_lang_Math.h"
#import "java_lang_IndexOutOfBoundsException.h"
#import "java_lang_System.h"

// java.io.BufferedReader
//----------------------------------------------------------------------------
@implementation java_io_BufferedReader

static const int INVALIDATED = -2;
static const int UNMARKED = -1;
static const int defaultCharBufferSize = 8192;
static const int defaultExpectedLineLength = 80;

- (id) init {
	self = [super init];
	target = (java_io_Reader*) JAVA_NULL;
	cb = NULL;
	nChars = 0;
	nextChar = 0;
	markedChar = UNMARKED;
	readAheadLimit = 0;
	skipLF = FALSE;
	markedSkipLF = FALSE;
	return self;
}

- (instancetype) __init_java_io_BufferedReader___java_io_Reader: (java_io_Reader*) reader {
	return [self __init_java_io_BufferedReader___java_io_Reader_int:reader:defaultCharBufferSize];
}

- (instancetype) __init_java_io_BufferedReader___java_io_Reader_int: (java_io_Reader *) reader: (int) sz {
	[super __init_java_io_Reader___java_lang_Object:reader];
	if (sz <= 0) {
		java_lang_IllegalArgumentException* ex = [[java_lang_IllegalArgumentException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"Buffer size <= 0"];
		[ex __init_java_lang_IllegalArgumentException___java_lang_String:str];
		[str release];
		@throw ex;
	}
	self->target = [reader retain];
	cb = [XMLVMArray createSingleDimensionWithType: 2 andSize:sz]; //char array
//	[cb retain];

	nChars = 0;
	nextChar = 0;
    return self;
}

- (void) ensureOpen {
	if (target == (java_io_Reader*) JAVA_NULL) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"Stream closed"];
		[ex __init_java_io_IOException___java_lang_String:str];
		[str release];
		@throw ex;
	}
}

- (void) fill {
	int dst;
	if (markedChar <= UNMARKED) {
		// No mark
		dst = 0;
	} else {
		// Marked
		int delta = nextChar - markedChar;
		if (delta >= readAheadLimit) {
			// Gone past read-ahead limit: Invalidate mark
			markedChar = INVALIDATED;
			readAheadLimit = 0;
			dst = 0;
		} else {
			if (readAheadLimit <= [cb count]) {
				// Shuffle in the current buffer
				[java_lang_System arraycopy___java_lang_Object_int_java_lang_Object_int_int:cb:markedChar:cb:0:delta];
				markedChar = 0;
				dst = delta;
			} else {
				// Reallocate buffer to accommodate read-ahead limit
				XMLVMArray* ncb = [XMLVMArray createSingleDimensionWithType: 2 andSize:readAheadLimit]; //char array
				[java_lang_System arraycopy___java_lang_Object_int_java_lang_Object_int_int:cb:markedChar:ncb:0:delta];
				[cb release];
				cb = ncb;
				markedChar = 0;
				dst = delta;
			}
			nChars = delta;
			nextChar = nChars;
		}
	}

	int n;
	do {
		n = [target read___char_ARRAYTYPE_int_int:cb:dst:[cb count] - dst];
	} while (n == 0);
	if (n > 0) {
		nChars = dst + n;
		nextChar = dst;
	}
}

- (int) read1: (XMLVMArray *) cbuf: (int) off: (int) len {
	if (nextChar >= nChars) {
		if (len >= [cb count] && markedChar <= UNMARKED && !skipLF) {
			return [target read___char_ARRAYTYPE_int_int:cbuf:off:len];
		}
		[self fill];
	}
	if (nextChar >= nChars) {
		return -1;
	}
	if (skipLF) {
		skipLF = FALSE;
		if (cb->array.c[nextChar] == '\n') {
			nextChar++;
			if (nextChar >= nChars) {
				[self fill];
			}
			if (nextChar >= nChars) {
				return -1;
			}
		}
	}
	int n = [java_lang_Math min___int_int:len:nChars - nextChar];
	[java_lang_System arraycopy___java_lang_Object_int_java_lang_Object_int_int:cb:nextChar:cbuf:off:n];
	nextChar += n;
	return n;
}

- (int) read__ {
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		for (;;) {
			if (nextChar >= nChars) {
				[self fill];
				if (nextChar >= nChars) {
					return -1;
				}
			}
			if (skipLF) {
				skipLF = FALSE;
				if (cb->array.c[nextChar] == '\n') {
					nextChar++;
					continue;
				}
			}
			return cb->array.c[nextChar++];
		}
	}
	return -1;
}

- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len {
	int n = 0;
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		if (off < 0 || off > [cbuf count] || len < 0 ||
			(off + len) > [cbuf count] || (off + len) < 0)
		{
			java_lang_IndexOutOfBoundsException* ex = [[java_lang_IndexOutOfBoundsException alloc] init];
			[ex __init_java_lang_IndexOutOfBoundsException__];
			@throw ex;
		} else if (len == 0) {
			return 0;
		}
		n = [self read1:cbuf:off:len];
		if (n <= 0) {
			return n;
		}
		while (n < len && [target ready__]) {
			int n1 = [self read1:cbuf:off + n:len - n];
			if (n1 <= 0) {
				break;
			}
			n += n1;
		}
	}
	return n;
}

- (bool) ready__ {
	BOOL result = FALSE;
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		if (skipLF) {
			if (nextChar >= nChars && [target ready__]) {
				[self fill];
			}
			if (nextChar < nChars) {
				if (cb->array.c[nextChar] == '\n') {
					nextChar++;
				}
				skipLF = FALSE;
			}
		}
		result = (nextChar < nChars) || [target ready__];
	}
	return result;
}

- (void) mark___int: (int) readAheadLimitArg {
	if (readAheadLimitArg < 0) {
		java_lang_IllegalArgumentException* ex = [[java_lang_IllegalArgumentException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"Read-ahead limit < 0"];
		[ex __init_java_lang_IllegalArgumentException___java_lang_String:str];
		[str release];
		@throw ex;
	}
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		readAheadLimit = readAheadLimitArg;
		markedChar = nextChar;
		markedSkipLF = skipLF;
	}
}

- (BOOL) markSupported__ {
	return TRUE;
}

+ (void) appendChars: (java_lang_StringBuilder*)sb : (XMLVMArray*)src: (int)offset: (int)count {
	for (int i = offset; i < offset + count; i++) {
		[[sb append___char:(unichar) src->array.c[i]] release];
	}
}

- (java_lang_String*) readLine___boolean:(BOOL)ignoreLF {
	int startChar = 0;
	java_lang_StringBuilder* s = (java_lang_StringBuilder*) JAVA_NULL;
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		BOOL omitLF = ignoreLF || skipLF;
		//Buffer loop
		for (;;) {
			if (nextChar >= nChars) {
				[self fill];
			}
			if (nextChar >= nChars) { // EOF
				if (s != (java_lang_StringBuilder*) JAVA_NULL && [s length__] > 0) {
					java_lang_String* temp = [s toString__];
					[s release];
					return temp;
				} else {
					return (java_lang_String*) JAVA_NULL;
				}
			}
			BOOL eol = FALSE;
			char c = 0;
			int i = 0;

			// Skip a leftover '\n', if necessary
			if (omitLF && cb->array.c[nextChar] == '\n') {
				nextChar++;
			}
			skipLF = FALSE;
			omitLF = FALSE;

			//Char loop
			for (i = nextChar; i < nChars; i++) {
				c = cb->array.c[i];
				if (c == '\n' || c == '\r') {
					eol = TRUE;
					break; //break out of Char loop
				}
			}

			startChar = nextChar;
			nextChar = i;

			if (eol) {
				java_lang_String* str = (java_lang_String*) JAVA_NULL;
				if (s == (java_lang_StringBuilder*) JAVA_NULL) {
					java_lang_StringBuilder* sb = [[java_lang_StringBuilder alloc] init];
					[sb __init_java_lang_StringBuilder__];
					[java_io_BufferedReader appendChars: sb: cb: startChar: i - startChar];
					str = [sb toString__];
					[sb release];
				} else {
					[java_io_BufferedReader appendChars: s: cb: startChar: i - startChar];

					str = [s toString__];
					[s release];
				}
				nextChar++;
				if (c == '\r') {
					skipLF = TRUE;
				}
				return str;
			}

			if (s == (java_lang_StringBuilder*) JAVA_NULL) {
				s = [[java_lang_StringBuilder alloc] init];
//TODO call the StringBuilder(int) constructor instead (it doesn't currently exist). Send value "defaultExpectedLineLength"
				[s __init_java_lang_StringBuilder__];
			}
			[java_io_BufferedReader appendChars: s: cb: startChar: i - startChar];
		}
	}
	return (java_lang_String*) JAVA_NULL; //Code will never reach here
}

- (java_lang_String*) readLine__ {
	return [self readLine___boolean:FALSE];
}

- (JAVA_LONG) skip___long: (JAVA_LONG) n {
	if (n < 0) {
		java_lang_IllegalArgumentException* ex = [[java_lang_IllegalArgumentException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"skip value is negative"];
		[ex __init_java_lang_IllegalArgumentException___java_lang_String:str];
		[str release];
		@throw ex;
	}
	JAVA_LONG result = 0;
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		JAVA_LONG r = n;
		BOOL done = FALSE;
		while (r > 0 && !done) {
			if (nextChar >= nChars) {
				[self fill];
			}
			if (nextChar >= nChars) { // EOF
				done = TRUE;
			} else {
				if (skipLF) {
					skipLF = FALSE;
					if (cb->array.c[nextChar] == '\n') {
						nextChar++;
					}
				}
				JAVA_LONG d = nChars - nextChar;
				if (r <= d) {
					nextChar += r;
					r = 0;
					done = TRUE;
				} else {
					r -= d;
					nextChar = nChars;
				}
			}
		}
		result = n - r;
	}
	return result;
}

- (void) reset__ {
	@synchronized([self protectedLock]) {
		[self ensureOpen];
		if (markedChar < 0) {
			java_io_IOException* ex = [[java_io_IOException alloc] init];
			NSMutableString* str = NULL;
			if (markedChar == INVALIDATED) {
				str = [[NSMutableString alloc] initWithString:@"Mark invalid"];
			} else {
				str = [[NSMutableString alloc] initWithString:@"Stream not marked"];
			}
			[ex __init_java_io_IOException___java_lang_String:str];
			[str release];
			@throw ex;
		}
		nextChar = markedChar;
		skipLF = markedSkipLF;
	}
}

- (void) close__ {
	@synchronized([self protectedLock]) {
		if (target != (java_io_Reader*) JAVA_NULL) {
			[target close__];
			[target release];
			target = (java_io_Reader*) JAVA_NULL;
			[cb release];
			cb = NULL;
		}
	}
}

- (void) dealloc
{
	[cb release];
	[target release];
	[super dealloc];
}

@end

