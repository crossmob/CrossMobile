/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_io_Serializable.h"
#import "java_net_InetAddress.h"
#import "java_lang_String.h"
#import "java_net_NetworkInterface.h"
#include <arpa/inet.h>
#include <ifaddrs.h>
#include <net/if.h>

CM_EXPORT_CLASS
@interface java_net_InetAddress : java_lang_Object <java_io_Serializable> {
@private
    void* address;
    sa_family_t family;
    unsigned int flags;
}

//+ (java_net_InetAddress*) getByAddress___java_lang_String_byte_ARRAYTYPE :(java_lang_String*)n1 :(XMLVMArray*)n2;
//+ (java_net_InetAddress*) getByName___java_lang_String :(java_lang_String*)n1;
//+ (XMLVMArray*) getAllByName___java_lang_String :(java_lang_String*)n1;
//+ (java_net_InetAddress*) getLoopbackAddress__;
//+ (java_net_InetAddress*) getByAddress___byte_ARRAYTYPE :(XMLVMArray*)n1;
//+ (java_net_InetAddress*) getLocalHost__;

- (id) initWithInterface:(struct ifaddrs*) interface;
- (int) isMulticastAddress__;
- (int) isAnyLocalAddress__;
- (int) isLoopbackAddress__;
- (int) isLinkLocalAddress__;
- (int) isSiteLocalAddress__;
- (int) isMCGlobal__;
- (int) isMCNodeLocal__;
- (int) isMCLinkLocal__;
- (int) isMCSiteLocal__;
- (int) isMCOrgLocal__;
- (int) isReachable___int :(int)n1;
- (int) isReachable___java_net_NetworkInterface_int_int :(java_net_NetworkInterface*)n1 :(int)n2 :(int)n3;
- (java_lang_String*) getHostName__;
- (java_lang_String*) getCanonicalHostName__;
- (XMLVMArray*) getAddress__;
- (java_lang_String*) getHostAddress__;

@end
