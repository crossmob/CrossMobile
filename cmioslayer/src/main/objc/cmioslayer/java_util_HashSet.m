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

#import "java_util_HashSet.h"


// java.util.HashSet
//----------------------------------------------------------------------------
@implementation NSMutableSet (cat_java_util_HashSet)

- (instancetype) __init_java_util_HashSet__
{
    return [self init];
}

-(instancetype) __init_java_util_HashSet___int:(int) size
{
    return [self __init_java_util_HashSet__];
}

- (instancetype) __init_java_util_HashSet___java_util_Collection:(java_util_Collection*)c
{
    self = [self initWithCapacity:[c size__]];
	[self addAll___java_util_Collection: c];
    return self;
}

- (BOOL) add___java_lang_Object:(java_lang_Object*)e
{
	BOOL contains = [self containsObject:e];
	[self addObject:e];
	return !contains;
}

// TODO move this to AbstractCollection where it really belongs
- (BOOL) addAll___java_util_Collection: (java_util_Collection*) c
{
	int origSize = [self size__];
	java_util_Iterator* iter = [c iterator__];
	while ([iter hasNext__]) {
		java_lang_Object* obj = [iter next__];
		[self add___java_lang_Object:obj];
		[obj release];
	}
	[iter release];
	return origSize == [self size__];
}

- (int) size__
{
	return [self count];
}

- (void) clear__
{
	[self removeAllObjects];
}

//Returns an iterator over the elements in this set. The elements are returned in no particular order.
- (java_util_Iterator*) iterator__
{
	return [[java_util_IteratorImpl alloc] init: [self objectEnumerator]];
}

- (BOOL) contains___java_lang_Object: (java_lang_Object*) o
{
	java_util_Iterator* iter = [self iterator__];
	while ([iter hasNext__]) {
		java_lang_Object* obj = [iter next__];
		if (o == JAVA_NULL ? obj == JAVA_NULL : [o equals___java_lang_Object:obj]) {
			[obj release];
			[iter release];
			return TRUE;
		}
		[obj release];
	}
	[iter release];
	return FALSE;
}

@end
