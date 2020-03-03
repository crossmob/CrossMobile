/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Double.h"
#import "java_lang_NumberFormatException.h"


// java.lang.Double
//----------------------------------------------------------------------------
@implementation java_lang_Double

+ (double) parseDouble___java_lang_String: (java_lang_String *) str
{
    char * end;
    double result = strtod([str UTF8String], &end);
    if (*end!='\0') {
        java_lang_NumberFormatException* ex = [[java_lang_NumberFormatException alloc] init];
        [ex __init_java_lang_NumberFormatException__];
        @throw ex;
    } else
        return result;
}

+ (java_lang_String*) toString___double: (double) d
{
    java_lang_Double* proxy = [[java_lang_Double alloc] __init_java_lang_Double___double:d];
    NSString* result = [proxy toString__];
    [proxy release];
    return result;
}

+ (java_lang_Double*) valueOf___double: (double) d
{
    return [[java_lang_Double alloc] __init_java_lang_Double___double:d];
}

- (instancetype) __init_java_lang_Double___double :(double) d
{
    return [self initWithDouble:d];
}

- (double) unbox
{
    return [self doubleValue];
}


@end
