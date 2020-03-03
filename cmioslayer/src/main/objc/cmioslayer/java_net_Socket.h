/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_String.h"
#import "java_io_InputStream.h"
#import "java_io_OutputStream.h"


// java.net.Socket
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_net_Socket : java_lang_Object {
	int sock;
}

- (id) initWithSocket:(int)socket;

- (instancetype) __init_java_net_Socket__;
- (instancetype) __init_java_net_Socket___java_lang_String_int: (java_lang_String*)host: (int) port;

- (java_io_InputStream*) getInputStream__;
- (java_io_OutputStream*) getOutputStream__;
- (void) close__;
- (void) setSoTimeout___int:(int) msec;

@end


@interface java_net_SocketInputStreamImpl : java_io_InputStream {
	int sock;
	BOOL eof;
}

- (id) initWithSocket:(int)socket;

- (void) dealloc;

@end


@interface java_net_SocketOutputStreamImpl : java_io_OutputStream {
	int sock;
}

- (id) initWithSocket:(int)socket;

- (void) dealloc;

@end
