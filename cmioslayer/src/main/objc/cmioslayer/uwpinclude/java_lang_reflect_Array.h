/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Iterator.h"


// java.lang.reflect.Array
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_reflect_Array : java_lang_Object

+ (XMLVMArray*) newInstance___java_lang_Class_int_ARRAYTYPE:(java_lang_Class*)clazz :(XMLVMArray*)dimensions;
+ (void) set___java_lang_Object_int_java_lang_Object:(XMLVMArray*) array :(int) index :(java_lang_Object*) obj;

@end
