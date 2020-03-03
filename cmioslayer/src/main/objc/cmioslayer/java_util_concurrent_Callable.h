/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

@class java_lang_Object;
@protocol java_util_concurrent_Callable
- (java_lang_Object*) call__;
@end

@interface java_util_concurrent_Callable : java_lang_Object <java_util_concurrent_Callable>
@end
