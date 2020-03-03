/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Number.h"
#import "java_lang_Class.h"
#import "java_lang_String.h"


// java.lang.Boolean
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Boolean : java_lang_Number

+ (java_lang_Class*) _GET_TYPE;
+ (BOOL) parseBoolean___java_lang_String:(java_lang_String*) str;
+ (java_lang_Boolean*) _GET_FALSE;
+ (java_lang_Boolean*) _GET_TRUE;
+ (java_lang_Boolean*) valueOf___java_lang_String:(java_lang_String*) s;
+ (java_lang_Boolean*) valueOf___boolean:(int)b;
+ (java_lang_String*) toString___boolean:(BOOL) b;
- (instancetype) __init_java_lang_Boolean___boolean :(BOOL) b;
- (BOOL) unbox;

@end
