/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_Throwable.h"
#import "java_lang_String.h"


#define java_lang_Exception NSException

@interface NSException (cm_java_lang_Exception)

- (instancetype) __init_java_lang_Exception__;
- (instancetype) __init_java_lang_Exception___java_lang_String: (java_lang_String*) msg;
- (instancetype) __init_java_lang_Exception___java_lang_String_java_lang_Throwable: (java_lang_String*) msg : (java_lang_Throwable*) cause;
- (java_lang_Exception *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause;

@end
