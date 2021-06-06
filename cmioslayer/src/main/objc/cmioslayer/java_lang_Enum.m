/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Enum.h"
#import "java_lang_Class.h"
#import "java_lang_IllegalArgumentException.h"

@implementation java_lang_Enum 

+ (java_lang_Enum*) valueOf___java_lang_Class_java_lang_String:(java_lang_Class*) clazz :(NSString*) value
{
	XMLVMArray* values = [clazz->clazz _GET__VALUES];
	for(int i = 0 ; i < values->length ; i++) {
		java_lang_Enum* item = values->array.o[i];
		if ([item->name isEqual:value])
			return [item retain];
	}
	@throw [[[java_lang_IllegalArgumentException alloc] preInitJava] __init_java_lang_IllegalArgumentException___java_lang_String:[NSString stringWithFormat:@"No enum constant %@.%@", [[clazz getName__] autorelease], value]];
}

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
