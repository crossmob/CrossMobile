/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Boolean.h"

java_lang_Boolean* _STATIC_java_lang_Boolean_FALSE;
java_lang_Boolean* _STATIC_java_lang_Boolean_TRUE;


static java_lang_Class* primitiveBooleanClass;


// java.lang.Boolean
//----------------------------------------------------------------------------
@implementation java_lang_Boolean

+ (void) initialize
{
    if (strcmp(class_getName(self), "java_lang_Boolean") == 0) {
        _STATIC_java_lang_Boolean_FALSE = [[java_lang_Boolean alloc] initWithBool:NO];
        _STATIC_java_lang_Boolean_TRUE = [[java_lang_Boolean alloc] initWithBool:YES];
    }
}

+ (java_lang_Class*) _GET_TYPE
{
	return primitiveBooleanClass;
}

+ (BOOL) parseBoolean___java_lang_String:(java_lang_String*) str
{
	return str != JAVA_NULL && [str caseInsensitiveCompare:@"true"] == 0;
}

+ (java_lang_Boolean*) _GET_FALSE
{
	return [_STATIC_java_lang_Boolean_FALSE retain];
}

+ (java_lang_Boolean*) _GET_TRUE
{
	return [_STATIC_java_lang_Boolean_TRUE retain];
}


+ (java_lang_Boolean*) valueOf___java_lang_String:(java_lang_String*) s {
	java_lang_Boolean* result = [[java_lang_Boolean alloc] init];
	[result __init_java_lang_Boolean___boolean:[java_lang_Boolean parseBoolean___java_lang_String:s]];
	return result;
}

+ (java_lang_Boolean*) valueOf___boolean:(int)b
{
    return [[java_lang_Boolean alloc] initWithBool:b];
}


+ (java_lang_String*) toString___boolean:(BOOL) b {
	return b ? @"true" : @"false";
}

- (instancetype) __init_java_lang_Boolean___boolean :(BOOL) b
{
    return [self initWithBool:b];
}

- (java_lang_String*) toString__ {
    return [java_lang_Boolean toString___boolean:[self boolValue]];
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

- (BOOL) unbox
{
    return [self boolValue];
}


@end
