/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "java_net_SocketException.h"

// java.net.SocketException
//----------------------------------------------------------------------------
@implementation java_net_SocketException

- (id) init
{
    return [self initWithName: @"java_net_SocketException" reason: nil userInfo: nil];
}

- (instancetype) __init_java_net_SocketException__
{
    return [self init];
}

- (instancetype) __init_java_net_SocketException___java_lang_String: (java_lang_String*) msg
{
    return [self init];
}

@end
