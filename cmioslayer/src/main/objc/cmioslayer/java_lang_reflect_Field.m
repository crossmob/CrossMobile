/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_reflect_Field.h"
#import "java_lang_Class.h"


// java.lang.reflect.Field
//----------------------------------------------------------------------------
@implementation java_lang_reflect_Field;

- (id) initWithName: (java_lang_String*) n isStatic: (BOOL) flag
{
	self = [super init];
	self->name = [n retain];
	self->isStatic = flag;
	return self;
}

- (void) dealloc
{
	[self->name release];
	[super dealloc];
}

- (instancetype) __init_java_lang_reflect_Field__
{
    return self;
}

- (java_lang_String*) getName__
{
	java_lang_String* n = self->name;
	[n retain];
	return n;
}

- (int) getInt___java_lang_Object: (java_lang_Object*) obj
{
	int val = 0;
	if (isStatic) {
		NSMutableString* mangledFieldName = [[NSMutableString alloc] initWithString: @"_GET_"];
		[mangledFieldName appendString: name];
		SEL sel = NSSelectorFromString(mangledFieldName);
		val = (int) [((java_lang_Class*) obj)->clazz performSelector: sel];
		[mangledFieldName release];
	} else {
		// TODO non-static fields
	}
	return val;
}

@end
