// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKBackForwardListItem implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_webkit_WKBackForwardListItem.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_webkit_WKBackForwardListItem$Ext

@end

@implementation WKBackForwardListItem (cm_crossmobile_ios_webkit_WKBackForwardListItem)

// @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSURL *initialURL;
- (NSURL*) initialURL__
{
    NSURL* re$ult = [self initialURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, readonly, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
