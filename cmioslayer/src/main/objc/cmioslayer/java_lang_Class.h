/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

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
