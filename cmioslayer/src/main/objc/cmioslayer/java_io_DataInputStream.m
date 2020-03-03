/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

 
#import "java_io_DataInputStream.h"

// java.io.DataInputStream
//----------------------------------------------------------------------------
@implementation java_io_DataInputStream

- (instancetype) __init_java_io_DataInputStream___java_io_InputStream: (java_io_InputStream*) stream
{
	target = [stream retain];
    return self;
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (int) read__
{
	return [target read__];
}

- (void) close__
{
	[target close__];
}

- (int) readInt__
{
	int d;
	unsigned char* p = (unsigned char*) &d;
	
	for (int i = 0; i < 4; i++) {
		int v = [target read__];
		*p++ = (unsigned char) v;
	}
	return d;
}

- (int) readByte__
{
	return [target read__];
}

- (bool) readBoolean__
{
	return [target read__] != 0;
}

- (float) readFloat__
{
	float f;
	unsigned char* p = (unsigned char*) &f;
	
	for (int i = 0; i < 4; i++) {
		int v = [target read__];
		*p++ = (unsigned char) v;
	}
	return f;
}

- (double) readDouble__
{
	double d;
	unsigned char* p = (unsigned char*) &d;
	
	for (int i = 0; i < 8; i++) {
		int v = [target read__];
		*p++ = (unsigned char) v;
	}
	return d;
}

@end

