/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_net_URLConnection.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_net_URL : java_lang_Object {
	NSURL* url;
}

- (instancetype) __init_java_net_URL___java_lang_String:(java_lang_String *)url;
- (void) dealloc;
- (java_net_URLConnection*) openConnection__;

@end
