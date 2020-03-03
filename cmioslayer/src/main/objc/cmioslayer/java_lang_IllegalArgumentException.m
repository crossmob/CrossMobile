/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "java_lang_IllegalArgumentException.h"

// java.lang.IllegalArgumentException
//----------------------------------------------------------------------------
@implementation java_lang_IllegalArgumentException

- (id) init
{
    return [self initWithName: @"java_lang_IllegalArgumentException" reason: nil userInfo: nil];
}

- (instancetype) __init_java_lang_IllegalArgumentException__
{
    return [self init];
}

- (instancetype) __init_java_lang_IllegalArgumentException___java_lang_String: (java_lang_String*) msg
{
    return [self init];
}

- (instancetype) __init_java_lang_IllegalArgumentException___java_lang_String_java_lang_Throwable: (java_lang_String*) msg: (java_lang_Throwable*) cause
{
    return [self init];
}

- (java_lang_IllegalArgumentException *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause
{
	[self retain];
	return self;
}

- (void) printStackTrace__
{
}

@end
