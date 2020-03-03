/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_net_URLConnection.h"
#import "java_io_ByteArrayInputStream.h"
#import "java_io_ByteArrayOutputStream.h"
#import "java_io_IOException.h"


@interface HTTPRequestNoRedirect : NSThread {
	
	NSAutoreleasePool* pool;
	NSURLRequest*      request;
	NSURLResponse**    response;
	NSError**          error;
	NSConditionLock*   lock;
	NSMutableData*     receivedData;
	
}

+ (NSData *)sendSynchronousRequest:(NSURLRequest *)request returningResponse:(NSURLResponse **)response error:(NSError **)error;

- (id) initWithLock: (NSConditionLock*) l urlRequest: (NSURLRequest*) req response:(NSURLResponse**) resp error:(NSError**)err;
- (void) dealloc;
- (NSData*) cmData;
- (void) main;
- (NSURLRequest *)connection: (NSURLConnection *)inConnection
             willSendRequest: (NSURLRequest *)inRequest
            redirectResponse: (NSURLResponse *)inRedirectResponse;
- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response;
- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data;
- (void)connectionDidFinishLoading:(NSURLConnection *)connection;
- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)err;

@end

@implementation HTTPRequestNoRedirect

+ (NSData *)sendSynchronousRequest:(NSURLRequest *)request returningResponse:(NSURLResponse **)response error:(NSError **)error
{
	NSConditionLock* wait = [[NSConditionLock alloc] initWithCondition:0];
	HTTPRequestNoRedirect* syncReq = [[HTTPRequestNoRedirect alloc] initWithLock:wait urlRequest:request response:response error:error];
	[syncReq start];
	[wait lockWhenCondition:1];
	[wait unlock];
	[wait release];
	NSData* data = [syncReq cmData];
	[syncReq release];
	return data;
}

- (id) initWithLock: (NSConditionLock*) l urlRequest: (NSURLRequest*) req response:(NSURLResponse**) resp error:(NSError**)err;
{
	if (self = [super init]) {
		self->lock = l;
		self->request = req;
		self->response = resp;
		self->error = err;
		self->receivedData = [[NSMutableData alloc] init];
	}
	return self;
}

- (void) dealloc
{
	//TODO if we release the pool we get the following error:
	// Attempt to Pop an Unknown Autorelease Pool
	//	[self->pool release];
	[receivedData release];
	[super dealloc];
}

- (NSData*) cmData
{
	return [receivedData retain];
}

- (void) main
{
	pool = [[NSAutoreleasePool alloc] init];
	[[NSURLConnection alloc] initWithRequest:request delegate:self];
	[[NSRunLoop currentRunLoop] run];
}

- (NSURLRequest *)connection: (NSURLConnection *)inConnection
             willSendRequest: (NSURLRequest *)inRequest
            redirectResponse: (NSURLResponse *)inRedirectResponse;
{
	[inRedirectResponse retain];
	[*(self->response) release];
	*(self->response) = inRedirectResponse;
	return inRedirectResponse ? nil : inRequest;
}

- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)resp
{
	[receivedData setLength:0];
	*(self->response) = [resp retain];
}

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data
{
    [receivedData appendData:data];
}

- (void)connectionDidFinishLoading:(NSURLConnection *)connection
{
	[self->lock lock];
	[self->lock unlockWithCondition:1];
	[self cancel];
}

- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)err
{
	[err retain];
	[*(self->error) release];
	*(self->error) = err;
}

@end



// java.net.URLConnection
//----------------------------------------------------------------------------
@implementation java_net_URLConnection

- (id) initWithURL:(NSURL*) nsurl
{
	self = [super init];
	if (self) {
		self->url = [nsurl retain];
		self->request = [[NSMutableURLRequest alloc] initWithURL:nsurl];
		self->body = nil;
		self->response = nil;
		self->error = nil;
		self->data = nil;
	}
	return self;
}

- (void) dealloc
{
	// TODO check why we can't do the releases. Without the comments, the application will crash.
	//[self->url release];
	[self->request release];
	[self->body release];
	[self->response release];
	[self->error release];
	//[self->data release];
	[super dealloc];
}

- (void) setDoOutput___boolean:(int) flag
{
	// Do nothing
}

- (void) setDoInput___boolean:(int) flag
{
	// Do nothing
}

- (void) setRequestProperty___java_lang_String_java_lang_String:(java_lang_String*) key
															   :(java_lang_String*) value
{
	[request setValue:value forHTTPHeaderField:key];
}

- (void) addRequestProperty___java_lang_String_java_lang_String:(java_lang_String*) key
															   :(java_lang_String*) value
{
	[request addValue:value forHTTPHeaderField:key];
}

- (java_io_InputStream*) getInputStream__
{
	[self xmlvmDoRequest];
	int statusCode = [((NSHTTPURLResponse *)response) statusCode];
	if (statusCode >= 400) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		[ex __init_java_io_IOException__];
		@throw ex;
	}
	if (data == nil) {
		return JAVA_NULL;
	}
	java_io_ByteArrayInputStream* stream = [[java_io_ByteArrayInputStream alloc] init];
	[stream __init_java_io_ByteArrayInputStream___byte_ARRAYTYPE:[data getBytes__]];
	return stream;
}

- (java_io_OutputStream*) getOutputStream__
{
	if (body == nil) {
		body = [[java_io_ByteArrayOutputStream alloc] init];
		[body __init_java_io_ByteArrayOutputStream__];
	}
	return [body retain];
}

- (java_lang_String*) getHeaderField___java_lang_String: (java_lang_String*) field
{
	[self xmlvmDoRequest];
	NSDictionary* headerFields = [response allHeaderFields];
	return [[headerFields objectForKey:field] retain];
}

- (void) xmlvmDoRequest
{
	if (response != nil) {
		return;
	}
	if (body != nil) {
		[request setHTTPMethod:@"POST"];
		XMLVMArray* bodyData = [body toByteArray__];
		NSData* postData = [[NSData alloc] initWithBytes:bodyData->array.b length:[bodyData count]];
		NSString *postLength = [NSString stringWithFormat:@"%d", [postData length]];
		[request setValue:postLength forHTTPHeaderField:@"Content-Length"];
		[request setValue:@"application/x-www-form-urlencoded" forHTTPHeaderField:@"Content-Type"];
		[request setHTTPBody:postData];
	}
	data = [HTTPRequestNoRedirect sendSynchronousRequest:request returningResponse:&response error:&error];
}

@end

