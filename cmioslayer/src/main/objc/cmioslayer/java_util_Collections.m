/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Collections.h"
#import "java_util_Arrays.h"
#import "java_util_List.h"
#import "java_util_ArrayList.h"
#import "java_util_IteratorImpl.h"

@implementation java_util_Collections

+ (java_util_List*) _GET_EMPTY_LIST
{
    const NSArray* empty_list = nil;
    if (empty_list==nil) {
        empty_list = [[NSArray alloc] init];
    }
    return (java_util_List*)[empty_list retain];
}

+ (java_util_Set*) _GET_EMPTY_SET
{
    const NSSet* empty_list = nil;
    if (empty_list==nil) {
        empty_list = [[NSSet alloc] init];
    }
    return (java_util_Set*)[empty_list retain];
}

+ (java_util_Map*) _GET_EMPTY_MAP
{
    const NSDictionary* empty_list = nil;
    if (empty_list==nil) {
        empty_list = [[NSDictionary alloc] init];
    }
    return (java_util_Map*)[empty_list retain];
}


//TODO Move the following to non-static [java_util_List toArray__]
+ (XMLVMArray*)toArray: (java_util_List*) list {
	XMLVMArray* a = [XMLVMArray createSingleDimensionWithType:0 andSize:[list size__]]; //Object array
	for (int i = 0; i < [list size__]; i++) {
		a->array.o[i] = [list get___int:i];
	}
	return a;
}

+ (void) sort___java_util_List: (java_util_List*) list {
	[java_util_Collections sort___java_util_List_java_util_Comparator:list:JAVA_NULL];
}

+ (void) sort___java_util_List_java_util_Comparator: (java_util_List*) list: (java_util_Comparator*) c {
	XMLVMArray* a = [java_util_Collections toArray:list];

	if (c == JAVA_NULL) {
		[java_util_Arrays sort___java_lang_Object_ARRAYTYPE:a];
	} else {
		[java_util_Arrays sort___java_lang_Object_ARRAYTYPE_java_util_Comparator:a:c];
	}
	for (int j = 0; j < [a count]; j++) {
		java_lang_Object* removedObj = [list set___int_java_lang_Object:j:a->array.o[j]];
		[removedObj release];
	}
}

+ (BOOL) addAll___java_util_Collection_java_lang_Object_ARRAYTYPE:(java_util_Collection*) c :(XMLVMArray*) elements
{
    BOOL result = false;
    for(int i = 0 ; i < elements->length ; i++)
        result |= [c add___java_lang_Object:elements->array.o[i]];
    return result;
}

+ (java_util_Map*) emptyMap__
{
    return [java_util_Collections _GET_EMPTY_MAP];
}

+ (java_util_List*) emptyList__
{
   return [java_util_Collections _GET_EMPTY_LIST];
}

+ (java_util_Set*) emptySet__
{
    return [java_util_Collections _GET_EMPTY_SET];
}

+ (java_util_Enumeration*) emptyEnumeration__
{
    return [java_util_Collections emptyIterator__];
}

+ (java_util_Iterator*) emptyIterator__
{
    return [[java_util_IteratorImpl alloc] init: [[java_util_Collections _GET_EMPTY_SET] objectEnumerator]];
}

+ (java_util_ListIterator*) emptyListIterator__
{
    return [java_util_Collections emptyIterator__];
}

+ (java_util_Map*) emptyNavigableMap__
{
    return [java_util_Collections emptyMap__];
}

+ (java_util_Set*) emptyNavigableSet__
{
    return [java_util_Collections emptySet__];
}

+ (java_util_SortedMap*) emptySortedMap__
{
    return [java_util_Collections emptyMap__];
}

+ (java_util_SortedSet*) emptySortedSet__
{
    return [java_util_Collections emptySet__];
}

+ (java_util_Set*) singleton___java_lang_Object:(java_lang_Object*) item
{
    return [[NSSet alloc] initWithObjects:item, nil];
}

+ (java_util_List*) singletonList___java_lang_Object:(java_lang_Object*) item
{
    return [[NSArray alloc] initWithObjects:item, nil];
}

+ (java_util_Map*) singletonMap___java_lang_Object_java_lang_Object:(java_lang_Object*) key :(java_lang_Object*) value
{
    return [[NSDictionary alloc] initWithObjectsAndKeys:value, key, nil];
}

@end
