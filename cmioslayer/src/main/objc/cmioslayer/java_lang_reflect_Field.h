/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"


// java.lang.reflect.Field
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_reflect_Field : java_lang_Object {

	java_lang_String* name;
	BOOL              isStatic;
}

- (id) initWithName: (java_lang_String*) name isStatic: (BOOL) flag;
- (void) dealloc;
- (instancetype) __init_java_lang_reflect_Field__;
- (java_lang_String*) getName__;
- (int) getInt___java_lang_Object: (java_lang_Object*) obj;

@end
