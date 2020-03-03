/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_nio_ByteBuffer.h"


// java_nio_ByteBuffer
//----------------------------------------------------------------------------
@implementation java_nio_ByteBuffer


- (instancetype) __init_java_nio_ByteBuffer___int: (int) size
{
	data = (unsigned char *) malloc(sizeof(unsigned char) * size);
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

- (java_nio_ByteBuffer*) put___int_int: (int) pos: (int) value
{
	data[pos] = (unsigned char) value;
	[self retain];
	return self;
}

- (java_nio_ByteBuffer*) put___int: (int) value
{
	data[index] = (unsigned char) value;
	index++;
	[self retain];
	return self;
}

- (java_nio_ByteBuffer*) reset__
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
