/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_util_Hashtable.h"
#import "java_lang_String.h"

#define java_util_Properties NSMutableDictionary

@interface NSMutableDictionary (cat_java_util_Properties)

- (instancetype) __init_java_util_Properties__;
- (instancetype) __init_java_util_Properties___java_util_Properties: (java_util_Properties*) defaults;
- (java_lang_String*) getProperty___java_lang_String:(java_lang_String*) key;
- (java_lang_String*) getProperty___java_lang_String_java_lang_String:(java_lang_String*) key:(java_lang_String*) defaultvalue;

@end
