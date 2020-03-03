/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_BufferedOutputStream.h"

// java.io.BufferedOutputStream
//----------------------------------------------------------------------------
@implementation java_io_BufferedOutputStream

- (instancetype) __init_java_io_BufferedOutputStream___java_io_OutputStream: (java_io_OutputStream*) stream 
{
	return [self __init_java_io_BufferedOutputStream___java_io_OutputStream_int: stream : 0];
}


- (instancetype) __init_java_io_BufferedOutputStream___java_io_OutputStream_int: (java_io_OutputStream*) stream: (int) size 
{
    target = [stream retain];
    return self;
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (void) write___int: (int) i
{
	[target write___int: i];
}

- (void) write___byte_ARRAYTYPE: (XMLVMArray *) data
{
	[target write___byte_ARRAYTYPE: data];
}

- (void) write___byte_ARRAYTYPE_int_int: (XMLVMArray *) data: (int) pos: (int) len
{
	[target write___byte_ARRAYTYPE_int_int: data : pos : len];
}

- (void) flush__
{
	[target flush__];
}

- (void) close__ 
{
	[target close__];
}

@end

