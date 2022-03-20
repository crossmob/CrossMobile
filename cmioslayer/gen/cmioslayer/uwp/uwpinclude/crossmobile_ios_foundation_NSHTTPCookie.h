// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSHTTPCookie definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSHTTPCookie$Ext : NSHTTPCookie
@end

#define crossmobile_ios_foundation_NSHTTPCookie NSHTTPCookie
@interface NSHTTPCookie (cm_crossmobile_ios_foundation_NSHTTPCookie)
- (BOOL) isHTTPOnly__;
- (NSString*) comment__;
- (NSURL*) commentURL__;
- (NSString*) domain__;
- (NSDate*) expiresDate__;
- (NSString*) name__;
- (NSString*) path__;
- (NSArray*) portList__;
- (BOOL) isSecure__;
- (BOOL) isSessionOnly__;
- (NSString*) value__;
- (int) version__;
@end
