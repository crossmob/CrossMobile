/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_Exception.h"
#import "java_lang_String.h"


// java.lang.IndexOutOfBoundsException
//----------------------------------------------------------------------------
// For some reason, compiling for the device doesn't like to define this
// class as a category.
CM_EXPORT_CLASS
@interface java_lang_IndexOutOfBoundsException : java_lang_Exception

- (id) init;
- (instancetype) __init_java_lang_IndexOutOfBoundsException__;
- (instancetype) __init_java_lang_IndexOutOfBoundsException___java_lang_String: (java_lang_String*) msg;
- (instancetype) __init_java_lang_IndexOutOfBoundsException___java_lang_String_java_lang_Throwable: (java_lang_String*) msg: (java_lang_Throwable*) cause;
- (java_lang_IndexOutOfBoundsException *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause;
- (void) printStackTrace__;

@end
