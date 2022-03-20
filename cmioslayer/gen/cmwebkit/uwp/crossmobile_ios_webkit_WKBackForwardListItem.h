// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKBackForwardListItem definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;

@interface crossmobile_ios_webkit_WKBackForwardListItem$Ext : WKBackForwardListItem
@end

#define crossmobile_ios_webkit_WKBackForwardListItem WKBackForwardListItem
@interface WKBackForwardListItem (cm_crossmobile_ios_webkit_WKBackForwardListItem)
- (NSURL*) URL__;
- (NSURL*) initialURL__;
- (NSString*) title__;
@end
