/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java.util.Locale
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_util_Locale : java_lang_Object {
	java_lang_String *language;
	NSUInteger        languageHash;
	java_lang_String* country;
	NSUInteger        countryHash;
}

+ (void) initialize;
- (id) init;
- (instancetype) __init_java_util_Locale___java_lang_String: (java_lang_String*) theLanguage;
- (instancetype) __init_java_util_Locale___java_lang_String_java_lang_String:(java_lang_String*) theLanguage
                                                                    :(java_lang_String*) theCountry;
- (void) dealloc;
+ (java_util_Locale*) getDefault__;
- (int) equals___java_lang_Object:(java_lang_Object*) obj;
- (java_lang_String*) toString__;
- (java_lang_String*) getLanguage__;
- (java_lang_String*) getCountry__;
	
@end
