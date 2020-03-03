/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_net_URL.h"
#import "java_net_HttpURLConnection.h"


// java.net.URL
//----------------------------------------------------------------------------
@implementation java_net_URL

- (instancetype) __init_java_net_URL___java_lang_String: (java_lang_String*) urlString
{
	self->url = [NSURL URLWithString: urlString];
    return self;
}

- (void) dealloc
{
	[self->url release];
	[super dealloc];
}

- (java_net_URLConnection*) openConnection__
{
	return [[java_net_HttpURLConnection alloc] initWithURL:self->url];
}

@end

