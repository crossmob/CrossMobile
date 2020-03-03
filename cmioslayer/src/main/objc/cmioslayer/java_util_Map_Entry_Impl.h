/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Object.h"
#import "java_util_Map_Entry.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_Map_Entry_Impl : java_lang_Object <java_util_Map_Entry> {
	java_lang_Object* myKey;
	java_lang_Object* myValue;
}

- (id) initWithKey:(java_lang_Object*)key andValue:(java_lang_Object*)value;
- (java_lang_Object*) getKey__;
- (java_lang_Object*) getValue__;

@end
