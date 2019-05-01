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
 
#import "java_io_ByteArrayOutputStream.h"

// java.io.ByteArrayOutputStream
//----------------------------------------------------------------------------
@implementation java_io_ByteArrayOutputStream

- (void) dealloc
{
	[buffer release];
	[super dealloc];
}

- (instancetype) __init_java_io_ByteArrayOutputStream__
{
    self = [super init];
    self->buffer = [[NSMutableData alloc] initWithCapacity: DEFAULT_CAPACITY];
    return self;
}

- (instancetype) __init_java_io_ByteArrayOutputStream___int: (int) size
{
    self = [super init];
	buffer = [[NSMutableData alloc] initWithCapacity: size];
    return self;
}

- (void) write___int:(int)i
{
	[buffer appendByte___int:i];	
}

- (void) writeTo___java_io_OutputStream: (java_io_OutputStream*) os
{
	XMLVMArray* data = [self toByteArray__];
	[os write___byte_ARRAYTYPE:data];
	[data release];
}

- (XMLVMArray *) toByteArray__
{
	int length = [buffer length];
	XMLVMArray* result = [XMLVMArray createSingleDimensionWithType: 3 andSize: length];	// byte array
	
	unsigned char* buf = (unsigned char *) [buffer mutableBytes];
	
	for (int i = 0; i < length; ++i) {
		result->array.b[i] = *(buf+i); 
	}

	return result;
}

- (void) reset__
{
	[buffer setLength:0];
}

@end

