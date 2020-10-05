/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Float.h"
#import "java_lang_NumberFormatException.h"

// java.lang.Float
//----------------------------------------------------------------------------
@implementation java_lang_Float

- (instancetype) __init_java_lang_Float___float :(float) f
{
    return [self initWithFloat:f];
}

- (java_lang_String*) toString__
{
	return [[self stringValue] retain];
}

+ (java_lang_String*) toString___float: (float) f
{
	return [[[NSNumber numberWithFloat: f] stringValue] retain];
}

+ (float) parseFloat___java_lang_String: (java_lang_String *) str
{
    char * end;
    float result = strtof([str UTF8String], &end);
    if (*end!='\0') {
        java_lang_NumberFormatException* ex = [[java_lang_NumberFormatException alloc] init];
        [ex __init_java_lang_NumberFormatException__];
        @throw ex;
    } else
        return result;
}


+ (java_lang_Float*) valueOf___float:(float) f {
    return [[java_lang_Float alloc] __init_java_lang_Float___float:f];
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

- (float) unbox
{
    return [self floatValue];
}


@end
