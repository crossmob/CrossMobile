/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_net_NetworkInterface.h"
#import "java_net_InetAddress.h"
#import "java_util_IteratorImpl.h"
#import "java_util_ArrayList.h"
#import "java_net_InterfaceAddress.h"
#include <ifaddrs.h>
#include <net/if.h>
#include <netinet/in.h>
#include <arpa/inet.h>

@implementation java_net_NetworkInterface

+ (NSArray*) getAllInterfaces
{
    NSMutableArray* array = [[NSMutableArray alloc] init];
    struct ifaddrs* interfaces = NULL;
    struct ifaddrs* looper = NULL;
#if defined(_WIN32) || defined(WIN32)
	fprintf(stderr, "WARNING, NETWORK INTERFACES NOT IMPLEMENTED!\n");	// Look below
#else
    if (getifaddrs(&interfaces) == 0) {
        looper = interfaces;
        unsigned int index = 0;
        char* last_name = NULL;
        java_net_NetworkInterface* last_nif = nil;
        
        while (looper != NULL) {
            if (last_name==NULL || strncmp(last_name, looper->ifa_name, 50)!=0) {
                index++;
                last_name = looper->ifa_name;
                [last_nif release];
                last_nif = nil;
            }
            if (looper->ifa_addr->sa_family == AF_INET || looper->ifa_addr->sa_family == AF_INET6) {
                if (last_nif == nil) {
                    last_nif = [[java_net_NetworkInterface alloc] initWithInterface:looper index:index];
                    [array addObject:last_nif];
                }
                java_net_InetAddress *inet = [[java_net_InetAddress alloc] initWithInterface:looper];
                [last_nif->interfaces addObject:inet];
                [inet release];
            }
            looper = looper->ifa_next;
        }
        [last_nif release];
    }
    freeifaddrs(interfaces);
#endif
    return array;
}

+ (java_net_NetworkInterface*) getByName___java_lang_String :(java_lang_String*)name
{
    NSArray * ifs = [java_net_NetworkInterface getAllInterfaces];
    for (java_net_NetworkInterface * current in ifs) {
        if ([current->name isEqualToString:name]) {
            [current retain];
            [ifs release];
            return current;
        }
    }
    [ifs release];
    return JAVA_NULL;
}

+ (java_net_NetworkInterface*) getByIndex___int :(int)n1
{
    if (n1<1)
        return JAVA_NULL;
    
    NSArray * ifs = [java_net_NetworkInterface getAllInterfaces];
    java_net_NetworkInterface* result = [ifs count]<n1 ? JAVA_NULL : [[ifs objectAtIndex:n1] retain];
    [ifs release];
    return result;
}

+ (java_net_NetworkInterface*) getByInetAddress___java_net_InetAddress :(java_net_InetAddress*)inetaddr
{
    NSArray * ifs = [java_net_NetworkInterface getAllInterfaces];
    for (java_net_NetworkInterface * current in ifs) {
        java_util_Enumeration* inet = [current getInetAddresses__];
        while ([inet hasMoreElements__]) {
            java_net_InetAddress* cinetaddr = [inet nextElement__];
            if ([cinetaddr equals___java_lang_Object:inetaddr]) {
                [current retain];
                [cinetaddr release];
                [inet release];
                [ifs release];
            }
            [cinetaddr release];
        }
        [inet release];
    }
    [ifs release];
    return JAVA_NULL;
}

+ (java_util_Enumeration*) getNetworkInterfaces__
{
    NSArray * ifs = [java_net_NetworkInterface getAllInterfaces];
    java_util_Enumeration * result = [[java_util_IteratorImpl alloc] init:[ifs objectEnumerator]];
    [ifs release];
    return result;
}

- (id) initWithInterface:(struct ifaddrs*) interface index:(unsigned int) idx
{
    name = [[NSString alloc] initWithUTF8String:interface->ifa_name];
    flags = interface->ifa_flags;
    index = idx;
    interfaces = [[NSMutableArray alloc] init];
    return self;
}

- (void) dealloc {
    [name release];
    [interfaces release];
    [super dealloc];
}

- (java_lang_String*) getName__
{
    return [name retain];
}

- (java_util_Enumeration*) getInetAddresses__
{
    return [[java_util_IteratorImpl alloc] init:[interfaces objectEnumerator]];
}

- (java_util_List*) getInterfaceAddresses__
{
    java_util_List * result = [[java_util_ArrayList alloc] init];
    for (java_net_InetAddress* inet in interfaces) {
        java_net_InterfaceAddress *ifaddr = [[java_net_InterfaceAddress alloc] initWithInetAddress:inet];
        [result add___java_lang_Object:ifaddr];
        [ifaddr release];
    }
    return result;
}

- (java_util_Enumeration*) getSubInterfaces__
{
    return [[java_util_IteratorImpl alloc] init:[[NSArray arrayWithObjects: nil] objectEnumerator]];
}

- (java_net_NetworkInterface*) getParent__
{
    return JAVA_NULL;
}

- (int) getIndex__
{
    return index;
}

- (java_lang_String*) getDisplayName__
{
    return [name length] < 1 ? JAVA_NULL : [name retain];
}

- (int) isUp__
{
    return (flags&IFF_UP)!=0;
}

- (int) isLoopback__
{
    return (flags&IFF_LOOPBACK)!=0;
}

- (int) isPointToPoint__
{
    return (flags&IFF_POINTOPOINT)!=0;
}

- (int) supportsMulticast__
{
    return (flags&IFF_MULTICAST)!=0;
}
//
//- (XMLVMArray*) getHardwareAddress__
//{
//    
//}
//
//- (int) getMTU__
//{
//    
//}

- (int) isVirtual__
{
    return false;
}

- (java_lang_String*) toString__
{
    return [name retain];
}

@end
