/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@protocol java_util_Comparator <NSObject>

- (int) compare___java_lang_Object_java_lang_Object:(java_lang_Object*)o1:(java_lang_Object*)o2;

@end

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_Comparator : java_lang_Object <java_util_Comparator>
@end
