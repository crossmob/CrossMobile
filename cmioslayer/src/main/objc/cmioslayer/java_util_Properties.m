/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Properties.h"


@implementation NSMutableDictionary (cat_java_util_Properties)

- (instancetype) __init_java_util_Properties__
{
    return [self init];
}

- (instancetype) __init_java_util_Properties___java_util_Properties: (java_util_Properties*) defaults
{
    return [self init];
}

- (java_lang_String*) getProperty___java_lang_String:(java_lang_String*) key
{
	return [self getProperty___java_lang_String_java_lang_String:key :JAVA_NULL];
}

- (java_lang_String*) getProperty___java_lang_String_java_lang_String:(java_lang_String*) key:(java_lang_String*) defaultvalue
{
	java_lang_String* value = XMLVM_NIL2NULL([self get___java_lang_Object:key]);
	if (value==JAVA_NULL)
		value=defaultvalue;
	return [value retain];
}

@end
