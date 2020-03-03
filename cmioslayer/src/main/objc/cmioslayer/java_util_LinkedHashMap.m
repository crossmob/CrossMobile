/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_LinkedHashMap.h"
#import "java_util_IteratorImpl.h"
#import "java_util_HashMap_EntrySet.h"
#import "java_util_ArrayList.h"


@implementation java_util_LinkedHashMap 

- (id) init
{
    return [self initWithCapacity:0];
}

- (id)initWithCapacity:(int) size
{
    self = [super init];
    self->dict = [[NSMutableDictionary alloc] initWithCapacity:size];
    self->keys = [[NSMutableArray alloc] initWithCapacity:size];
	return self;
}

- (id)initWithObjects:(NSArray *)objects forKeys:(NSArray *)keys
{
    self = [super init];
    self->dict = [[NSMutableDictionary alloc] initWithObjects:objects forKeys:keys];
    self->keys = [[NSMutableArray alloc] initWithArray:keys];
    return self;
}

- (void)dealloc
{
    [dict release];
    [keys release];
    [super dealloc];
}


- (NSUInteger)count
{
	return [keys count];
}

- (id)objectForKey:(id) key
{
	return [dict objectForKey:key];
}

- (NSEnumerator *)keyEnumerator
{
	return [keys objectEnumerator];
}

- (void)setObject:(id)object forKey:(id < NSCopying >) key
{
	if (![dict objectForKey:key]) {
		[keys addObject:key];
	}
	[dict setObject:object forKey:key];
}

- (void)removeObjectForKey:(id) key
{
	[dict removeObjectForKey:key];
	[keys removeObject:key];
}


- (instancetype) __init_java_util_LinkedHashMap__
{
    return [self init];
}

- (instancetype) __init_java_util_LinkedHashMap___int: (int) size
{
    return [self initWithCapacity:size];
}

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
    return [[NSMutableOrderedSet alloc] initWithArray:keys];
}

- (java_util_Set*) entrySet__
{
    [self sortMap];

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

@end
