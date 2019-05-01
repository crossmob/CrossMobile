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

#import "java_nio_IntBuffer.h"


// java_nio_IntBuffer
//----------------------------------------------------------------------------
@implementation java_nio_IntBuffer


+ (java_nio_IntBuffer*) allocate___int: (int) size
{
	java_nio_IntBuffer *buffer = [[java_nio_IntBuffer alloc] init];
	[buffer __init_java_nio_IntBuffer___int: size];
	
	return buffer;
}

- (instancetype) __init_java_nio_IntBuffer___int: (int) size
{
	data = (int *) malloc(sizeof(int) * size);
	index = 0;
    return self;
}

- (float*) get_data
{
    return self->data;
}

- (void) set_data:(float*) data
{
    self->data = data;
}

- (int) get_index
{
    return self->index;
}

- (void) set_index:(int) index
{
    self->index = index;
}

- (float) get___float: (int) value
{
	return data[value];
}

- (int) get___int: (int) value
{
	return data[value];
}

- (java_nio_IntBuffer*) put___int_int: (int) pos : (int) value
{
	data[pos] = value;
	[self retain];
	return self;
}

- (java_nio_IntBuffer*) put___int: (int) value
{
	data[index] = value;
	index++;
	[self retain];
	return self;
}

- (java_nio_IntBuffer*) reset__
{
	index = 0;
	[self retain];
	return self;
}

- (void) dealloc {
	free(data);

    [super dealloc];
}

@end
