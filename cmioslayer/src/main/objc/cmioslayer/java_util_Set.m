/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Set.h"


// java.util.Set
//----------------------------------------------------------------------------
@implementation NSMutableSet (cat_java_util_Set)

- (void) clear__
{
	[self removeAllObjects];
}

- (BOOL) add___java_lang_Object: (java_lang_Object*) obj
{
	BOOL hasObj = [self containsObject:obj];
	[self addObject:obj];
	return hasObj;
}

- (BOOL) remove___java_lang_Object:(java_lang_Object*) obj
{
	BOOL hasObj = [self containsObject:obj];
	[self removeObject:obj];
	return hasObj;
}

@end

@implementation NSSet (cat_java_util_Set)

- (java_util_Iterator*) iterator__
{
    return [[java_util_IteratorImpl alloc] init: [self objectEnumerator]];
}

- (int) size__
{
	return [self count];
}

- (BOOL) isEmpty__
{
	return [self count]<1;
}

@end
