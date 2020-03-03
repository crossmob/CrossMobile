/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

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
