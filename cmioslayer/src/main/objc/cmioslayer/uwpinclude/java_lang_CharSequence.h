/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

@class java_lang_String;


CM_EXPORT_CLASS
@protocol java_lang_CharSequence <NSObject>

- (int) charAt___int :(int) index;
- (int) length__;
- (id<java_lang_CharSequence>) subSequence___int_int :(int) start :(int) end;
 
@end

@interface java_lang_CharSequence : java_lang_Object <java_lang_CharSequence>
@end
