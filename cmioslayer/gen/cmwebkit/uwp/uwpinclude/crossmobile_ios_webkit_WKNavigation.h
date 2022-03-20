// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKNavigation definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>

CM_EXPORT_CLASS
@interface crossmobile_ios_webkit_WKNavigation$Ext : WKNavigation
@end

#define crossmobile_ios_webkit_WKNavigation WKNavigation
@interface WKNavigation (cm_crossmobile_ios_webkit_WKNavigation)
@end
