/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later
 
#import "java_io_DataOutputStream.h"

// java.io.DataOutputStream
//----------------------------------------------------------------------------
@implementation java_io_DataOutputStream

- (instancetype) __init_java_io_DataOutputStream___java_io_OutputStream: (java_io_OutputStream*) stream
{
	target = [stream retain];
    return self;
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (void) writeInt___int: (int) v
{
	unsigned char* p = (unsigned char*) &v;
	for (int i = 0; i < 4; i++) {
		[target write___int:*p++];
	}
}

- (void) writeDouble___double: (double) v
{
	unsigned char* p = (unsigned char*) &v;
	for (int i = 0; i < 8; i++) {
		[target write___int:*p++];
	}
}

- (void) writeByte___int: (int) v
{
	[target write___int:v];
}

- (void) writeBoolean___boolean: (int) v
{
	[target write___int:v];
}

- (void) write___int: (int) i
{
	[target write___int: i];
}

- (void) close__
{
	[target close__];
}

- (void) flush__
{
	[target flush__];
}

@end

