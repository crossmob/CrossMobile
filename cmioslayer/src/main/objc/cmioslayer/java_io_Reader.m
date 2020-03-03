/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_Reader.h"
#import "java_io_IOException.h"
#import "java_lang_IllegalArgumentException.h"
#import "java_lang_Math.h"
#import "java_lang_NullPointerException.h"

// java.io.Reader
//----------------------------------------------------------------------------
@implementation java_io_Reader

- (id) init {
	self = [super init];
	self->lock = (java_lang_Object*) JAVA_NULL;
	skipBuffer = NULL;
	return self;
}

- (java_lang_Object*) protectedLock {
	return self->lock;
}

- (instancetype) __init_java_io_Reader__
{
	return [self __init_java_io_Reader___java_lang_Object:self];
}

- (instancetype) __init_java_io_Reader___java_lang_Object: (java_lang_Object*) lockObject
{
	if (lockObject == (java_lang_Object*) JAVA_NULL) {
		java_lang_NullPointerException* ex = [[java_lang_NullPointerException alloc] init];
//		[ex __init_java_lang_NullPointerException___java_lang_String:@"Locking object cannot be NULL!"];
		@throw ex;
	}

	self->lock = lockObject;
	// Avoid cyclic dependency where self is never released if it references itself in self->lock. Similar logic is in "dealloc".
	// If self were to be retained again, the "retainCount" would never get to 0 and would not be deallocated.
	if (self != self->lock) {
		[self->lock retain];
	}
    return self;
}

- (int) read__
{
	XMLVMArray* cb = [XMLVMArray createSingleDimensionWithType: 2 andSize:1]; //char array
	int result = -1;
	if ([self read___char_ARRAYTYPE_int_int:cb:0:1] != -1) {
		result = cb->array.c[0];
	}
	return result;
}

- (int) read___char_ARRAYTYPE: (XMLVMArray *) buffer
{
	return [self read___char_ARRAYTYPE_int_int: buffer:	0: [buffer count]];
}

- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len
{
	return [self xmlvmSubclassResponsibility];
}

- (bool) ready__
{
	return false;
}

- (void) mark___int: (int) readAheadLimit
{
	java_io_IOException* ex = [[java_io_IOException alloc] init];
	NSMutableString* str = [[NSMutableString alloc] initWithString:@"mark() not supported"];
	[ex __init_java_io_IOException___java_lang_String:str];
	[str release];
	@throw ex;
}


- (BOOL) markSupported__
{
	return false;
}

- (JAVA_LONG) skip___long: (JAVA_LONG) n
{
	if (n < 0) {
		java_lang_IllegalArgumentException* ex = [[java_lang_IllegalArgumentException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"skip value is negative"];
		[ex __init_java_lang_IllegalArgumentException___java_lang_String:str];
		[str release];
		@throw ex;
	}
	int maxSkipBufferSize = 8192;
	int nn = (int) [java_lang_Math min___long_long:n:(JAVA_LONG)maxSkipBufferSize];
	JAVA_LONG result = 0;
	@synchronized([self protectedLock]) {
		if (skipBuffer == NULL || [skipBuffer count] < nn) {
			skipBuffer = [XMLVMArray createSingleDimensionWithType: 2 andSize:nn];
		}
		JAVA_LONG r = n;
		int nc = 0;
		while (r > 0 && nc != -1) {
			int len = (int)[java_lang_Math min___long_long:r:(JAVA_LONG)nn];
			nc = [self read___char_ARRAYTYPE_int_int:skipBuffer:0:len];
			if (nc != -1) {
				r -= nc;
			}
		}
		result = n - r;
	}
	return result;
}

- (void) reset__
{
	java_io_IOException* ex = [[java_io_IOException alloc] init];
	NSMutableString* str = [[NSMutableString alloc] initWithString:@"reset() not supported"];
	[ex __init_java_io_IOException___java_lang_String:str];
	[str release];
	@throw ex;
}

- (void) close__
{
	[self xmlvmSubclassResponsibility];
}	

- (void)dealloc {
	// In order to avoid cyclic dependency, self->lock was NOT retained during initialization if it was equal to self.
	// Otherwise, the "retainCount" would never get to 0 and this "dealloc" method wouldn't even be called, causing a memory leak.
	// Since it was not retained, it should not be released either. It already has a "retainCount" of 0 right now.
	if (self != self->lock) {
		[self->lock release];
	}
	[skipBuffer release];
	[super dealloc];
}

@end
