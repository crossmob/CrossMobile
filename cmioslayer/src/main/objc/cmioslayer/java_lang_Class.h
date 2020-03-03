/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@class java_lang_reflect_Constructor;


// java.lang.Class
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Class : java_lang_Object {

@public Class clazz;

}

+ (java_lang_Class*) forName___java_lang_String :(java_lang_String*) className;
- (id) initWithClass: (Class) c;
- (instancetype) __init_java_lang_Class__;
- (BOOL) desiredAssertionStatus__;
- (java_lang_String*) getName__;
- (java_lang_String*) getSimpleName__;
- (XMLVMArray*) getDeclaredFields__;
- (NSObject*) newInstance__;
- (java_lang_reflect_Constructor*) getConstructor___java_lang_Class_ARRAYTYPE :(XMLVMArray*) signature;
- (BOOL) isAssignableFrom___java_lang_Class:(java_lang_Class*) child;

@end
