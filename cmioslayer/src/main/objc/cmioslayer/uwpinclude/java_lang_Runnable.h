/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

CM_EXPORT_CLASS
@protocol java_lang_Runnable <NSObject>
- (void) run__;
@end

CM_EXPORT_CLASS
@interface java_lang_Runnable : java_lang_Object <java_lang_Runnable>
@end
