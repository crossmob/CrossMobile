/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_net_URLConnection.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_net_HttpURLConnection : java_net_URLConnection

- (void) setRequestMethod___java_lang_String: (java_lang_String*) method;

@end
