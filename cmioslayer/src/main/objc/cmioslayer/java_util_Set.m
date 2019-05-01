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
