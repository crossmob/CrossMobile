/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Map.h"
#import "java_util_HashMap_EntrySet.h"

// java.util.Map & friends
//----------------------------------------------------------------------------

@implementation NSDictionary (cat_java_util_Map)

- (java_util_Iterator*) iterator__
{
    return [[java_util_IteratorImpl alloc] init: [self objectEnumerator]];
}

- (int) size__
{
    return (int)[self count];
}

- (java_util_Set*) keySet__ {
    NSMutableSet* keySet = [[NSMutableSet alloc] initWithCapacity:[self count]];
    
    NSEnumerator* keysEnumerator = [[self allKeys] objectEnumerator];
    id key = nil;
    while ((key = [keysEnumerator nextObject]) != nil) {
        [keySet addObject:key];
    }
    return keySet;
}

- (java_util_Set*) entrySet__
{
    //Since we're using an NSMutableDictionary, we will construct a new EntrySet
    java_util_HashMap_EntrySet* es = [[java_util_HashMap_EntrySet alloc] init];
    [es __init_java_util_HashMap_EntrySet___java_util_HashMap:self];
    return es;
}

- (java_lang_Object*) get___java_lang_Object:(java_lang_Object*) key {
    id k = [key conformsToProtocol: @protocol(NSCopying)] ? key : [NSValue valueWithPointer: key];
    return_XMLVM(objectForKey: k);
}

- (BOOL) containsKey___java_lang_Object: (java_lang_Object*) key
{
    return [self objectForKey:key] != nil;
}

- (BOOL) containsValue___java_lang_Object: (java_lang_Object*) value
{
    NSEnumerator *enumerator = [self objectEnumerator];
    id enumval;
    while ((enumval = [enumerator nextObject])) {
        if (enumval==value) {
            return YES;
        }
    }
    return NO;
}

- (java_util_Collection*) values__
{
    return [[self allValues] retain];
}


- (void) clear__
{
    @throw [NSException exceptionWithName:@"ImmutableCollectionException" reason:@"Accessing Map.clear from an immutable map" userInfo:nil];
}

- (java_lang_Object*) put___java_lang_Object_java_lang_Object:(java_lang_Object*) key : (java_lang_Object*) value {
    @throw [NSException exceptionWithName:@"ImmutableCollectionException" reason:@"Accessing Map.put from an immutable map" userInfo:nil];
}


- (java_lang_Object*) remove___java_lang_Object:(java_lang_Object*) key
{
   @throw [NSException exceptionWithName:@"ImmutableCollectionException" reason:@"Accessing Map.remove from an immutable map" userInfo:nil];
}

- (void) putAll___java_util_Map:(java_util_Map*) other
{
  @throw [NSException exceptionWithName:@"ImmutableCollectionException" reason:@"Accessing Map.putAll from an immutable map" userInfo:nil];
}


@end

@implementation NSMutableDictionary (cat_java_util_Map)

- (void) clear__
{
    [self removeAllObjects];
}

- (java_lang_Object*) put___java_lang_Object_java_lang_Object:(java_lang_Object*) key : (java_lang_Object*) value {
    java_lang_Object* oldObj = [self get___java_lang_Object:key];
    id k = [key conformsToProtocol: @protocol(NSCopying)] ? key : [NSValue valueWithPointer: key];
    [self setObject:value forKey:k];
    return oldObj;
}


- (java_lang_Object*) remove___java_lang_Object:(java_lang_Object*) key
{
    id k = [key conformsToProtocol: @protocol(NSCopying)] ? key : [NSValue valueWithPointer: key];
    java_lang_Object* item = [[self objectForKey:k] retain];
    item = XMLVM_NIL2NULL(item);
    [self removeObjectForKey:k];
    return item;
}

- (void) putAll___java_util_Map:(java_util_Map*) other
{
    for(id key in other) {
        [self setValue:[other objectForKey:key] forKey:key];
    }
}

@end
