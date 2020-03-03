/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Map_Entry_Impl.h"

@implementation java_util_Map_Entry_Impl

- (id) initWithKey:(java_lang_Object*)key andValue:(java_lang_Object*)value {
	self = [super init];
	self->myKey = [key retain];
	self->myValue = [value retain];
	return self;
}

- (java_lang_Object*) getKey__ {
	return [myKey retain];
}

- (java_lang_Object*) getValue__ {
	return [myValue retain];
}

- (void)dealloc {
	[myKey release];
	[myValue release];
	[super dealloc];
}

@end
