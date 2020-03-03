/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later
 
#import "java_io_BufferedInputStream.h"

// java.io.BufferedInputStream
//----------------------------------------------------------------------------
@implementation java_io_BufferedInputStream

- (instancetype) __init_java_io_BufferedInputStream___java_io_InputStream: (java_io_InputStream*) stream 
{
	return [self __init_java_io_BufferedInputStream___java_io_InputStream_int: stream : 0];
}

- (instancetype) __init_java_io_BufferedInputStream___java_io_InputStream_int: (java_io_InputStream*) stream: (int) size 
{
	target = [stream retain];
    return self;
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (bool) available__
{
	return [target available__];
}

- (bool) markSupported__
{
	return [target markSupported__];
}

- (void) mark___int: (int) readlimit
{
	[target mark___int: readlimit];
}

- (int) read__
{
	return [target read__];
}

- (int) read___byte_ARRAYTYPE: (XMLVMArray *) buffer
{
	return [target read___byte_ARRAYTYPE: buffer];
}

- (int) read___byte_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len
{
	return [target read___byte_ARRAYTYPE_int_int: buffer : pos : len];
}

- (void) close__
{
	[target close__];
}

- (void) reset__
{
	[target reset__];
}

- (JAVA_LONG) skip___long: (JAVA_LONG) n
{
	return [target skip___long: n];
}

@end

