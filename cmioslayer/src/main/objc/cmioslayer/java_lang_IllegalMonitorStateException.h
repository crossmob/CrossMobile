/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_RuntimeException.h"
#import "java_lang_String.h"


// java.lang.IllegalMonitorStateException
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_IllegalMonitorStateException : java_lang_RuntimeException

- (instancetype) __init_java_lang_IllegalMonitorStateException__;
- (instancetype) __init_java_lang_IllegalMonitorStateException___java_lang_String: (java_lang_String*) s;

@end
