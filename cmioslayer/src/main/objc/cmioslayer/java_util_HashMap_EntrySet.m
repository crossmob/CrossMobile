/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_HashMap_EntrySet.h"
#import "java_lang_NullPointerException.h"
#import "java_util_HashMap.h"
#import "java_util_ArrayList.h"
#import "java_util_Map_Entry_Impl.h"

// java.util.HashMap.EntrySet
//----------------------------------------------------------------------------
@implementation java_util_HashMap_EntrySet

- (instancetype) __init_java_util_HashMap_EntrySet___java_util_HashMap:(java_util_HashMap*)m {
	self = [super __init_java_lang_Object__];	;
	self->map = [m retain];
    return self;
}

//Returns a collection view of the mappings contained in this map.
//Each element in the returned collection is a Map.Entry
- (java_util_Iterator*) iterator__ {
	java_util_ArrayList* arrayList = [[java_util_ArrayList alloc] init];
	[arrayList __init_java_util_ArrayList___int:[map size__]];

	java_util_Set* keySet = [map keySet__ ];
	java_util_Iterator* iter = [keySet iterator__];
	while ([iter hasNext__]) {
		java_lang_Object* key = [iter next__];
		java_lang_Object* value = [map get___java_lang_Object:key];
		java_util_Map_Entry_Impl* mapEntry = [[java_util_Map_Entry_Impl alloc] initWithKey:key andValue:value];
		[arrayList add___java_lang_Object:mapEntry];
		[mapEntry release];
		[key release];
	}
	[iter release];
	[keySet release];

	java_util_Iterator* iter2 = [arrayList iterator__];
	[arrayList release];
	return iter2;
}

- (int) size__ {
	return [map size__];
}

- (void) clear__ {
	[map clear__];
}

- (void)dealloc {
	[map release];
	[super dealloc];
}

@end
