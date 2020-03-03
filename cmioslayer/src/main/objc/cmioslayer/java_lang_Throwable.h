/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#include "xmlvm.h"

// java.lang.Throwable
//----------------------------------------------------------------------------
// For some reason, compiling for the device doesn't like to define this
// class as a category.


#define java_lang_Throwable NSException

@interface NSException (java_lang_Throwable)
- (instancetype) __init_java_lang_Throwable__;
- (NSString *) getMessage__;
- (void) printStackTrace__;
@end
