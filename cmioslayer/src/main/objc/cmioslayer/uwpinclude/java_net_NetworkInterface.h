/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Enumeration.h"
#import "java_util_List.h"

@class java_net_InetAddress;

CM_EXPORT_CLASS
@interface java_net_NetworkInterface : java_lang_Object {
@private
    NSString* name;
    unsigned int flags;
    unsigned int index;
    NSArray* interfaces;
}

+ (java_net_NetworkInterface*) getByName___java_lang_String :(java_lang_String*)n1;
+ (java_net_NetworkInterface*) getByIndex___int :(int)n1;
+ (java_net_NetworkInterface*) getByInetAddress___java_net_InetAddress :(java_net_InetAddress*)n1;
+ (java_util_Enumeration*) getNetworkInterfaces__;

- (id) initWithInterface:(struct ifaddrs*) interface index:(unsigned int) idx;
- (java_lang_String*) getName__;
- (java_util_Enumeration*) getInetAddresses__;
- (java_util_List*) getInterfaceAddresses__;
- (java_util_Enumeration*) getSubInterfaces__;
- (java_net_NetworkInterface*) getParent__;
- (int) getIndex__;
- (java_lang_String*) getDisplayName__;
- (int) isUp__;
- (int) isLoopback__;
- (int) isPointToPoint__;
- (int) supportsMulticast__;
- (XMLVMArray*) getHardwareAddress__;
- (int) getMTU__;
- (int) isVirtual__;

@end

