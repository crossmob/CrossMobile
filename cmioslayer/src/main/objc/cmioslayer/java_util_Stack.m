/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

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
