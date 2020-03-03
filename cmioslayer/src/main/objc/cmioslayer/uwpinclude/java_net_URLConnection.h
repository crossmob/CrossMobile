/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_io_InputStream.h"
#import "java_io_OutputStream.h"

@class java_io_ByteArrayOutputStream;


CM_EXPORT_CLASS
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
