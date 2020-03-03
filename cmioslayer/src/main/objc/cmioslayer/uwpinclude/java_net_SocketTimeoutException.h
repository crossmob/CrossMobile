/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_io_IOException.h"
#import "java_lang_String.h"


// java.net.SocketTimeoutException
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_net_SocketTimeoutException : java_io_IOException

- (id) init;
- (instancetype) __init_java_net_SocketTimeoutException__;
- (instancetype) __init_java_net_SocketTimeoutException___java_lang_String: (java_lang_String*) msg;

@end
