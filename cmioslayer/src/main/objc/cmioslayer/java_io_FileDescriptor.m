/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_FileDescriptor.h"

@implementation java_io_FileDescriptor 

- (instancetype) __init_java_io_FileDescriptor__
{
    return self;
}

- (instancetype) __init_java_io_FileDescriptor___NSFileHandle: (NSFileHandle *) fdImpl
{
	fd = [fdImpl retain];
    return self;
}

- (void) dealloc
{
	[fd release];
	[super dealloc];
}

- (bool) valid__
{
	return fd != JAVA_NULL;
}

- (NSFileHandle*) fileHandle
{
	return [fd retain];
}

- (void) invalidate
{
	[fd release];
	fd = JAVA_NULL;
}

@end
