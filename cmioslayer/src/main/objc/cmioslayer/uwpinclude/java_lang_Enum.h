/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"


CM_EXPORT_CLASS
@interface java_lang_Enum : java_lang_Object {
	
	java_lang_String* name;
	int ordinal;
}

- (instancetype) __init_java_lang_Enum___java_lang_String_int
                  :(java_lang_String*) name
                  :(int) ordinal;
- (void) dealloc;
- (int) ordinal__;
-(java_lang_String*) name__;

@end
