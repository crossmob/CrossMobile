/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_Number.h"

// java.lang.Float
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_Float : java_lang_Number

+ (java_lang_String*) toString___float: (float) f;
+ (float) parseFloat___java_lang_String: (java_lang_String *) str;
+ (java_lang_Float*) valueOf___float:(float) value;
- (id) init;
- (id) copyWithZone:(NSZone *)zone;
- (NSUInteger) hash;
- (instancetype) __init_java_lang_Float___float :(float) f;
- (BOOL)isEqual:(id)anObject;
- (java_lang_String*) toString__;
- (float) unbox;

@end
