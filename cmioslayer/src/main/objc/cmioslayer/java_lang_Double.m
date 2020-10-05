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

+ (BOOL) compare___double_double:(double) d1 :(double) d2
{
    if (d1<d2)
        return -1;
    else if (d2>d2)
        return 1;
    else {
        JAVA_LONG d1Bits = [java_lang_Double doubleToLongBits__:d1];
        JAVA_LONG d2Bits = [java_lang_Double doubleToLongBits__:d2];
        if (d1Bits==d2Bits)
            return 0;
        else if (d1<d2Bits)
            return -1;
        else
            return 1;
    }
}

+ (JAVA_LONG) doubleToLongBits__:(double) d
{
    return *(JAVA_LONG*)(&d);
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

@end
