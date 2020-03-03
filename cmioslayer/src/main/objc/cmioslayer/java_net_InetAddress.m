/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_net_InetAddress.h"
#include <ifaddrs.h>
#include <net/if.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>

#define ADDRESS_SIZE (self->family==AF_INET ? sizeof(struct	in_addr) : sizeof(struct in6_addr))


@implementation java_net_InetAddress

//+ (java_net_InetAddress*) getByAddress___java_lang_String_byte_ARRAYTYPE :(java_lang_String*)n1 :(XMLVMArray*)n2
//{
//    
//}
//
//+ (java_net_InetAddress*) getByName___java_lang_String :(java_lang_String*)n1
//{
//    
//}
//
//+ (XMLVMArray*) getAllByName___java_lang_String :(java_lang_String*)n1
//{
//    
//}
//
//+ (java_net_InetAddress*) getLoopbackAddress__
//{
//    
//}
//
//+ (java_net_InetAddress*) getByAddress___byte_ARRAYTYPE :(XMLVMArray*)n1
//{
//    
//}
//
//+ (java_net_InetAddress*) getLocalHost__
//{
//    
//}
//

- (id) initWithInterface:(struct ifaddrs*) interface
{
    family = interface->ifa_addr->sa_family;
    flags = interface->ifa_flags;
    
    void * addressPtr = family == AF_INET ? &((struct sockaddr_in *)interface->ifa_addr)->sin_addr : &((struct sockaddr_in6 *)interface->ifa_addr)->sin6_addr;
    address = malloc(ADDRESS_SIZE);
    memcpy(address, addressPtr, ADDRESS_SIZE);
    
    return self;
}

- (void) dealloc {
    free(address);
    [super dealloc];
}

- (int) isMulticastAddress__
{
    return (flags&IFF_MULTICAST)!=0;
}
//
//- (int) isAnyLocalAddress__
//{
//    
//}

- (int) isLoopbackAddress__
{
    return (flags&IFF_LOOPBACK)!=0;
}

//- (int) isLinkLocalAddress__
//{
//    
//}
//
//- (int) isSiteLocalAddress__
//{
//    
//}
//
//- (int) isMCGlobal__
//{
//    
//}
//
//- (int) isMCNodeLocal__
//{
//    
//}
//
//- (int) isMCLinkLocal__
//{
//    
//}
//
//- (int) isMCSiteLocal__
//{
//    
//}
//
//- (int) isMCOrgLocal__
//{
//    
//}
//
//- (int) isReachable___int :(int)n1
//{
//    
//}
//
//- (int) isReachable___java_net_NetworkInterface_int_int :(java_net_NetworkInterface*)n1 :(int)n2 :(int)n3
//{
//    
//}

- (java_lang_String*) getHostName__
{
    struct sockaddr_in ipaddr;
    char host[NI_MAXHOST];
    
    memset(&ipaddr, 0, sizeof(struct sockaddr_in));
    ipaddr.sin_family = family;
    ipaddr.sin_port = htons(0);
    ipaddr.sin_addr = *((struct in_addr*)address);
    
    int s = getnameinfo((struct sockaddr *) &ipaddr, ADDRESS_SIZE, host, NI_MAXHOST, NULL, NULL, NI_NUMERICSERV);
    return s == 0 ? [[NSString alloc] initWithUTF8String:host] :  JAVA_NULL;
}

- (java_lang_String*) getCanonicalHostName__
{
    NSString * name = [self getHostAddress__];
    
    struct addrinfo      hints;
    struct addrinfo      *result = NULL;
    memset(&hints, 0, sizeof(hints));
    hints.ai_flags    = AI_NUMERICHOST;
    hints.ai_family   = PF_UNSPEC;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = 0;
    int errorStatus = getaddrinfo([name cStringUsingEncoding:NSASCIIStringEncoding], NULL, &hints, &result);
    if (errorStatus != 0) return JAVA_NULL;
    CFDataRef addressRef = CFDataCreate(NULL, (UInt8 *)result->ai_addr, result->ai_addrlen);
    if (addressRef == nil) return JAVA_NULL;
    freeaddrinfo(result);
    CFHostRef hostRef = CFHostCreateWithAddress(kCFAllocatorDefault, addressRef);
    if (hostRef == nil) return JAVA_NULL;
    CFRelease(addressRef);
    BOOL isSuccess = CFHostStartInfoResolution(hostRef, kCFHostNames, NULL);
    if (!isSuccess) return JAVA_NULL;

    CFArrayRef hostnamesRef = CFHostGetNames(hostRef, NULL);
    NSString * res= [(NSArray *)hostnamesRef objectAtIndex:0];
    return [res retain];
//
//    // Get the hostnames for the host reference.
//
//    NSMutableArray *hostnames = [NSMutableArray array];
//    for (int currentIndex = 0; currentIndex < [(NSArray *)hostnamesRef count]; currentIndex++) {
//        [hostnames addObject:[(NSArray *)hostnamesRef objectAtIndex:currentIndex]];
//    }
//    
}

- (XMLVMArray*) getAddress__
{
    return [XMLVMArray createSingleDimensionWithType:3 size:address andData:ADDRESS_SIZE];
}

- (java_lang_String*) getHostAddress__
{
    char addressName[INET6_ADDRSTRLEN];
    inet_ntop(family, address, addressName, sizeof(addressName));
    return [[NSString alloc] initWithUTF8String:addressName];
}

- (java_lang_String*) toString__
{
    return [self getHostAddress__];
}

@end
