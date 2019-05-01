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

