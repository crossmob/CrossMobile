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
@protocol java_util_Map_Entry <NSObject>
- (java_lang_Object*) getKey__;
- (java_lang_Object*) getValue__;
- (int) hashCode__;
- (java_lang_Object*) setValue___java_lang_Object:(java_lang_Object*)value;
@end

@interface java_util_Map_Entry : java_lang_Object <java_util_Map_Entry>
@end
