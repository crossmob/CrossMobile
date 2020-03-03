/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Collection.h"

CM_EXPORT_CLASS
@protocol java_util_Queue <java_util_Collection>
- (int) add___java_lang_Object :(java_lang_Object*)n1;
- (int) offer___java_lang_Object :(java_lang_Object*)n1;
- (java_lang_Object*) remove__;
- (java_lang_Object*) poll__;
- (java_lang_Object*) element__;
- (java_lang_Object*) peek__;

@end

@interface java_util_Queue : java_lang_Object <java_util_Queue>
@end
