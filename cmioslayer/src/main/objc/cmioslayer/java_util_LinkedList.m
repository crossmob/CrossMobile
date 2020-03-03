/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_LinkedList.h"


// java.util.LinkedList
//----------------------------------------------------------------------------
@implementation NSMutableArray (cat_java_util_LinkedList)

- (instancetype) __init_java_util_LinkedList__
{
    return [self init];
}


- (java_lang_Object*) getFirst__
{
    if ([self count]<1) {
        return JAVA_NULL;
    }
    return [[self objectAtIndex:0] retain];
}

- (java_lang_Object*) getLast__
{
    if ([self count]<1) {
        return JAVA_NULL;
    }
    return [[self objectAtIndex:[self count]-1] retain];
}

- (java_lang_Object*) removeFirst__
{
    java_lang_Object *o = [self getFirst__];
    if (o != JAVA_NULL) {
        [self removeObjectAtIndex:0];
    }
    return o;
}

- (java_lang_Object*) removeLast__
{
    java_lang_Object *o = [self getLast__];
    if (o != JAVA_NULL) {
        [self removeLastObject];
    }
    return o;
}

- (void) addFirst___java_lang_Object :(java_lang_Object*)n1
{
    [self insertObject:n1 atIndex:0];
}

- (void) addLast___java_lang_Object :(java_lang_Object*)n1
{
    [self addObject:n1];
}

- (java_lang_Object*) peek__
{
    return [self getFirst__];
}

- (java_lang_Object*) element__
{
    java_lang_Object* result = [self getFirst__];
    if (result==JAVA_NULL) {
        [NSException raise:@"NoSuchElementException" format:@""];
    }
    return result;
}

- (java_lang_Object*) poll__
{
    return [self removeFirst__];
}

- (java_lang_Object*) remove__
{
    java_lang_Object* result = [self removeFirst__];
    if (result==JAVA_NULL) {
        [NSException raise:@"NoSuchElementException" format:@""];
    }
    return result;
}

- (int) offer___java_lang_Object :(java_lang_Object*)n1
{
    [self addFirst___java_lang_Object:n1];
    return true;
}

- (int) offerFirst___java_lang_Object :(java_lang_Object*)n1
{
    [self addFirst___java_lang_Object:n1];
    return YES;
}

- (int) offerLast___java_lang_Object :(java_lang_Object*)n1
{
    [self addLast___java_lang_Object:n1];
    return YES;
}

- (java_lang_Object*) peekFirst__
{
    return [self getFirst__];
}

- (java_lang_Object*) peekLast__
{
    return [self getLast__];
}

- (java_lang_Object*) pollFirst__
{
    return [self removeFirst__];
}

- (java_lang_Object*) pollLast__
{
    return [self removeLast__];
}

- (void) push___java_lang_Object :(java_lang_Object*)n1
{
    [self addFirst___java_lang_Object:n1];
}

- (java_lang_Object*) pop__
{
    return [self removeFirst__];
}

- (int) removeFirstOccurrence___java_lang_Object :(java_lang_Object*)n1
{
    int idx = [self indexOfObject:n1];
    if (idx==NSNotFound)
        return NO;
    [self remove___int:idx];
    return true;
}

- (int) removeLastOccurrence___java_lang_Object :(java_lang_Object*)n1
{
    int idx = [self lastIndexOf___java_lang_Object:n1];
    if (idx==NSNotFound)
        return NO;
    [self remove___int:idx];
    return true;
}


// - (java_util_ListIterator*) listIterator___int :(int)n1;
// - (java_util_Iterator*) descendingIterator__;



// From java_util_ArrayList
// - (int) contains___java_lang_Object :(java_lang_Object*)n1
// - (int) size__;
// - (int) add___java_lang_Object :(java_lang_Object*)n1;
// - (int) remove___java_lang_Object :(java_lang_Object*)n1;
// - (int) addAll___java_util_Collection :(java_util_Collection*)n1;
// - (void) clear__;
// - (java_lang_Object*) get___int :(int)n1;
// - (java_lang_Object*) set___int_java_lang_Object :(int)n1 :(java_lang_Object*)n2;
// - (void) add___int_java_lang_Object :(int)n1 :(java_lang_Object*)n2;
// - (java_lang_Object*) remove___int :(int)n1;
// - (int) indexOf___java_lang_Object :(java_lang_Object*)n1;
// - (int) lastIndexOf___java_lang_Object :(java_lang_Object*)n1;
// - (int) addAll___int_java_util_Collection :(int)n1 :(java_util_Collection*)n2;
// - (XMLVMArray*) toArray__;
// - (XMLVMArray*) toArray___java_lang_Object_ARRAYTYPE :(XMLVMArray*)n1;


@end
