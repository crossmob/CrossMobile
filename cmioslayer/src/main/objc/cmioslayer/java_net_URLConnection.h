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
#import "java_io_InputStream.h"
#import "java_io_OutputStream.h"

@class java_io_ByteArrayOutputStream;


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_net_URLConnection : java_lang_Object {
	NSURL* url;
	NSMutableURLRequest* request;
	java_io_ByteArrayOutputStream* body;
	NSHTTPURLResponse* response;
	NSError* error;
	NSData* data; 
}

- (id) initWithURL:(NSURL*) url;
- (void) dealloc;
- (void) setDoOutput___boolean:(int) flag;
- (void) setDoInput___boolean:(int) flag;
- (void) setRequestProperty___java_lang_String_java_lang_String:(java_lang_String*) key
															   :(java_lang_String*) value;
- (void) addRequestProperty___java_lang_String_java_lang_String:(java_lang_String*) key
															   :(java_lang_String*) value;
- (java_io_InputStream*) getInputStream__;
- (java_lang_String*) getHeaderField___java_lang_String: (java_lang_String*) field;
- (void) xmlvmDoRequest;

@end
