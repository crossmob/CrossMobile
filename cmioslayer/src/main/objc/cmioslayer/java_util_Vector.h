/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java.util.Vector
//----------------------------------------------------------------------------

#define java_util_Vector NSMutableArray
@interface NSMutableArray (cat_java_util_Vector)

- (instancetype) __init_java_util_Vector__;
- (instancetype) __init_java_util_Vector___int: (int) size;

@end
