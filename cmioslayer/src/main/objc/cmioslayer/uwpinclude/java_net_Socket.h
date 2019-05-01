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
#import "java_lang_String.h"
#import "java_io_InputStream.h"
#import "java_io_OutputStream.h"


// java.net.Socket
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
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
