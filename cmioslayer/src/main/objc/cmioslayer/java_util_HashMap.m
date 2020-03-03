/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_HashMap.h"
#import "java_util_IteratorImpl.h"
#import "java_util_HashMap_EntrySet.h"
#import "java_util_ArrayList.h"

// java.util.HashMap
//----------------------------------------------------------------------------
@implementation NSMutableDictionary (cat_java_util_HashMap)

- (instancetype) __init_java_util_HashMap__
{
    return [self init];
}

- (instancetype) __init_java_util_HashMap___int: (int) size
{
    return [self initWithCapacity:size];
}


@end
