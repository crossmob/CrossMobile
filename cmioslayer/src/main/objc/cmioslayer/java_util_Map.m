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

#import "java_util_Map.h"
#import "java_util_HashMap_EntrySet.h"

// java.util.Map
//----------------------------------------------------------------------------
@implementation NSDictionary (cat_java_util_Map)

- (void) clear__
{
    [self removeAllObjects];
}

- (java_util_Collection*) values__
{
    return [self retain];
}

- (java_util_Iterator*) iterator__
{
    return [[java_util_IteratorImpl alloc] init: [self objectEnumerator]];
}

- (int) size__
{
    return [self count];
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

- (java_lang_Object*) put___java_lang_Object_java_lang_Object:(java_lang_Object*) key: (java_lang_Object*) value {
    java_lang_Object* oldObj = [self get___java_lang_Object:key];
    id k = [key conformsToProtocol: @protocol(NSCopying)] ? key : [NSValue valueWithPointer: key];
    [self setObject:value forKey:k];
    return oldObj;
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
