/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"


@class java_lang_Class;


// java.lang.reflect.Constructor
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_reflect_Constructor : java_lang_Object {

	java_lang_Class* clazz;
	XMLVMArray*      signature;
	NSMutableString* mangledConstructorName;

}


- (id) initWithClass: (java_lang_Class*) c andSignature: (XMLVMArray*) s andMangledConstructorName: (NSMutableString*) n;
- (void) dealloc;
- (java_lang_Object*) newInstance___java_lang_Object_ARRAYTYPE: (XMLVMArray*) params;

@end
