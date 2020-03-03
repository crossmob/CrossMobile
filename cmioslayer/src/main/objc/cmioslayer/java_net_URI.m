/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

/**
 * 
 *
 */
 
#import "java_net_URI.h"

// java.net.URI
//----------------------------------------------------------------------------

@implementation NSURLRef : NSObject
	
- (id) init
{
	url = nil;
	return self;
}

- (instancetype) __init_java_net_URI___java_lang_String: (java_lang_String*) urlString
{
	NSURL *url = [NSURL URLWithString: urlString];
	NSURLRef *r = (NSURLRef*) self;
	[r setRef: url];
    return self;
}

- (id) copyWithZone: (NSZone *) zone
{
	if (url != nil)
	{
		return [self retain];
	} else {
		return [[NSURLRef allocWithZone: zone] init];
	}
}

- (void) dealloc
{
	if (url != nil) {
		[url release];
	}
	[super dealloc];
}

- (void) setRef: (NSURL *) url
{
	if (self->url == nil) {
		self->url = [url retain];
	} else {
		@throw [[NSException alloc] init];
	}
}

- (NSMethodSignature *) methodSignatureForSelector:(SEL)aSelector
{
	NSMethodSignature * s = nil;
	if (self->url != nil) {
		s = [self->url methodSignatureForSelector: aSelector];
	}
	if (s == nil) {
		s = [super methodSignatureForSelector: aSelector];
	}
	return s;
}

- (void) forwardInvocation:(NSInvocation *)anInvocation
{
	if (self->url != nil) {
		SEL selector = [anInvocation selector];
		if ([self->url respondsToSelector: selector]) {
			[anInvocation invokeWithTarget: self->url];
			return;
		}
	}
	[super forwardInvocation: anInvocation];
}

@end


@implementation NSURL (cat_java_net_URI)

- (id) init
{
	self = [[NSURLRef alloc] init];
	return self;
}

+ (java_net_URI*) create___java_lang_String: (java_lang_String*) str 
{
	java_net_URI* uri = [[java_net_URI alloc] initWithString: [str stringByAddingPercentEscapesUsingEncoding: NSASCIIStringEncoding]];
	return uri;
}

- (java_lang_String*) getRawPath__
{
	// TODO: Return encoded string
	return_XMLVM(path)
}

- (java_lang_String*) getPath__
{
	
	return_XMLVM(path)
}

- (java_lang_String*) toString__
{
	return_XMLVM(absoluteString)
}

@end
