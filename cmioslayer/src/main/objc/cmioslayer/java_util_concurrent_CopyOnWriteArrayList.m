/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_ArrayList.h"
#import "java_lang_IllegalArgumentException.h"

@implementation NSMutableArray (cat_java_util_concurrent_CopyOnWriteArrayList)

- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList__ {
	return [self __init_java_util_concurrent_CopyOnWriteArrayList___int:10];
}

- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___int:(int)initialCapacity {
    return [self initWithCapacity:initialCapacity];
}

- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___java_util_Collection:(java_util_Collection*)c {
    self = [self initWithCapacity:[c size__]];
	[self addAll___java_util_Collection:c];
    return self;
}

@end
