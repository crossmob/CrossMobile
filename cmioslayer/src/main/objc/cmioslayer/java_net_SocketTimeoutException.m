/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "java_net_SocketTimeoutException.h"

// java.net.SocketTimeoutException
//----------------------------------------------------------------------------
@implementation java_net_SocketTimeoutException

- (id) init
{
    return [self initWithName: @"java_net_SocketTimeoutException" reason: nil userInfo: nil];
}

- (instancetype) __init_java_net_SocketTimeoutException__
{
    return [self init];
}

- (instancetype) __init_java_net_SocketTimeoutException___java_lang_String: (java_lang_String*) msg
{
    return [self init];
}

@end
