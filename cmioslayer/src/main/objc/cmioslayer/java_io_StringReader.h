/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_io_Reader.h"
#import "java_lang_String.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_StringReader : java_io_Reader {
	java_lang_String* str;
	int pos;
}

- (instancetype) __init_java_io_StringReader___java_lang_String:(java_lang_String*)s;
- (int) read__;

@end
