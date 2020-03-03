/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_net_InetAddress.h"
#import "java_net_InterfaceAddress.h"


@implementation java_net_InterfaceAddress

- (id) initWithInetAddress:(java_net_InetAddress*) inetaddress
{
    address = [inetaddress retain];
    return self;
}

- (void) dealloc {
    [address release];
    [super dealloc];
}

- (java_net_InetAddress*) getAddress__
{
    return [address retain];
}

- (java_net_InetAddress*) getBroadcast__
{
    return JAVA_NULL;
}

//- (int) getNetworkPrefixLength__
//{
//
//}


@end
