/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_InputStreamReader.h"
#import "java_lang_StringBuffer.h"

// java.io.InputStreamReader
//----------------------------------------------------------------------------
@implementation java_io_InputStreamReader

- (instancetype) __init_java_io_InputStreamReader___java_io_InputStream: (java_io_InputStream*) input
{
	[super __init_java_io_Reader___java_lang_Object:input];
	self->target = [input retain];
    return self;
}

- (instancetype) __init_java_io_InputStreamReader___java_io_InputStream_java_lang_String: (java_io_InputStream*) input: (java_lang_String*) charsetName
{
	[super __init_java_io_Reader___java_lang_Object:input];
	self->target = [input retain];
    return self;
	//charsetName is currently ignored (which is not consistent with the Java API, but I didn't want to remove an implemented constructor)
}

- (int) read__
{
	return [super read__];
}

- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len {
	int tempSize = [buffer count] - pos;
	XMLVMArray* temp = [XMLVMArray createSingleDimensionWithType: 3 andSize:tempSize]; //byte array
	int result = [target read___byte_ARRAYTYPE_int_int:temp:0:len];
	for (int i = 0; i < result; i++) {
		buffer->array.c[i + pos] = temp->array.b[i];
	}
	[temp release];
	return result;
}

- (bool) ready__ {
	//TODO this isn't consistent with the Java API since we're not using StreamDecoder
	return [target available__] > 0;
}

- (void) close__
{
	[target close__];
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

@end

