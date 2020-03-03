/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Vector.h"

@implementation NSMutableArray (cat_java_util_Vector)

- (instancetype) __init_java_util_Vector__
{
    return [self init];
}

- (instancetype) __init_java_util_Vector___int: (int) size
{
    return [self initWithCapacity:size];
}

@end

