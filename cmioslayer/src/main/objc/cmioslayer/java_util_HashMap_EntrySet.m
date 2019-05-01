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
