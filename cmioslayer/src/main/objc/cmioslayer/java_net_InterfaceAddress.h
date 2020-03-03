/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"

@class java_net_InetAddress;

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_net_InterfaceAddress : java_lang_Object {
@private
    java_net_InetAddress* address;
}

- (id) initWithInetAddress:(java_net_InetAddress*) inetaddress;
- (java_net_InetAddress*) getAddress__;
- (java_net_InetAddress*) getBroadcast__;
- (int) getNetworkPrefixLength__;

@end

