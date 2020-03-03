/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_nio_FloatBuffer.h"


// java_nio_FloatBuffer
//----------------------------------------------------------------------------
@implementation java_nio_FloatBuffer


- (instancetype) __init_java_nio_FloatBuffer___int: (int) size
{
	data = (float *) malloc(sizeof(float) * size);
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

- (java_nio_FloatBuffer*) put___float: (float) value
{
	data[index] = value;
	index++;
	[self retain];
	return self;
}

- (java_nio_FloatBuffer*) reset__
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
