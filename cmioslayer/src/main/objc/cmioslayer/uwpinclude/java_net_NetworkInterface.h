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

