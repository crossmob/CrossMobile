/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Enum.h"

@implementation java_lang_Enum 

- (instancetype) __init_java_lang_Enum___java_lang_String_int
                  :(java_lang_String*) n
                  :(int) o
{
	self->name = [n retain];
	self->ordinal = o;
    return self;
}

- (void) dealloc
{
	[self->name release];
	[super dealloc];
}

- (int) ordinal__
{
	return self->ordinal;
}

-(java_lang_String*) name__ 
{
    return [self->name retain];
}


@end
