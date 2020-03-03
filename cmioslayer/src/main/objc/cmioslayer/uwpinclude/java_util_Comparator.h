/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

@protocol java_util_Comparator <NSObject>

- (int) compare___java_lang_Object_java_lang_Object:(java_lang_Object*)o1:(java_lang_Object*)o2;
- (BOOL) equals___java_lang_Object:(java_lang_Object*)obj;

@end

CM_EXPORT_CLASS
@interface java_util_Comparator : java_lang_Object <java_util_Comparator>
@end
