/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_Number.h"


// java.lang.Double
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_Double : java_lang_Number

+ (double) parseDouble___java_lang_String: (java_lang_String *) str;
+ (java_lang_String*) toString___double: (double) d;
+ (java_lang_Double*) valueOf___double: (double) d;
- (id) init;
- (id) copyWithZone:(NSZone *)zone;
- (NSUInteger) hash;
- (instancetype) __init_java_lang_Double___double :(double) d;
- (BOOL)isEqual:(id)anObject;
- (java_lang_String*) toString__;
- (double) unbox;

@end
