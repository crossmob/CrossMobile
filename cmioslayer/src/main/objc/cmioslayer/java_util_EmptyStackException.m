/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "java_util_EmptyStackException.h"

// java.lang.RuntimeException
//----------------------------------------------------------------------------
@implementation java_util_EmptyStackException

- (id) init
{
    return [self initWithName: @"java_util_EmptyStackException" reason: nil userInfo: nil];
}

- (instancetype) __init_java_util_EmptyStackException__
{
    return [self init];
}

@end
