/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_net_Socket.h"


// java.net.ServerSocket
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_net_ServerSocket : java_lang_Object {
	int sock;
	int soTimeout;
}

- (instancetype) __init_java_net_ServerSocket__;
- (instancetype) __init_java_net_ServerSocket___int :(int) port;
- (instancetype) __init_java_net_ServerSocket___int_int :(int) port:(int) backlog;

- (void) setSoTimeout___int :(int) timeout;
- (java_net_Socket*) accept__;
- (void) close__;

@end
