/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "java_lang_Throwable.h"

// java.lang.Throwable
//----------------------------------------------------------------------------
@implementation NSException (java_lang_Throwable)

- (id) init
{
    return [self initWithName: @"java_lang_Throwable" reason: nil userInfo: nil];
}

- (instancetype) __init_java_lang_Throwable__
{
    return [self initWithName:@"java_lang_Throwable" reason: nil userInfo: nil];
}

- (NSString *) getMessage__
{
	return_XMLVM(reason)
}

- (NSString *) toString__
{
	return_XMLVM(name)
}

- (void) printStackTrace__
{
}

@end
