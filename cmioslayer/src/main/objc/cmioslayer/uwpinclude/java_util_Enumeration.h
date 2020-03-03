/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java.util.Enumeration
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@protocol java_util_Enumeration <NSObject>

- (bool) hasMoreElements__;
- (java_lang_Object*) nextElement__;

@end

@interface java_util_Enumeration : java_lang_Object <java_util_Enumeration>
@end
