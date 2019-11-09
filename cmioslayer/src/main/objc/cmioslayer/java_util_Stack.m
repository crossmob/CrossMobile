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

#import "java_util_Stack.h"


// java.util.Stack
//----------------------------------------------------------------------------
@implementation java_util_Stack

- (instancetype) __init_java_util_Stack__
{
	theStack = [[NSMutableArray alloc] init];
    return self;
}

- (void) dealloc
{
	[theStack release];
	[super dealloc];
}

- (java_util_Iterator*) iterator__
{
	return [[java_util_IteratorImpl alloc] init: [theStack objectEnumerator]];
}

- (int) size__
{
	return (int)[theStack count];
}

- (java_lang_Object*) push___java_lang_Object :(java_lang_Object*) item
{
	[theStack addObject: item];
	return [item retain];
}

- (java_lang_Object*) get___int :(int) idx
{
    return [[theStack objectAtIndex: idx] retain];
}

- (java_lang_Object*) remove___int :(int) idx
{
	id o = [[theStack objectAtIndex: idx] retain];
	[theStack removeObjectAtIndex: idx];
	return o;
}

- (java_lang_Object*) pop__
{
	id o = [[theStack lastObject] retain];
	[theStack removeLastObject];
	return o;
}

- (java_lang_Object*) peek__
{
	return [[theStack lastObject] retain];
}

- (BOOL) empty__
{
    return [theStack count]==0;
}

- (BOOL) remove___java_lang_Object :(java_lang_Object*) item
{
	if ([theStack indexOfObject: item] != NSNotFound) {
		[theStack removeObject: item];
		return true;
	} else {
		return false;
	}
}

@end
