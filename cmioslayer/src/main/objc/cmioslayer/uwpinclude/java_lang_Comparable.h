/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

CM_EXPORT_CLASS
@protocol java_lang_Comparable <NSObject>
- (int) compareTo___java_lang_Object: (java_lang_Object*) obj;
@end

@interface java_lang_Comparable : java_lang_Object <java_lang_Comparable>
@end
