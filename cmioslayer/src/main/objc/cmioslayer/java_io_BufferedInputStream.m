/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */
 
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

