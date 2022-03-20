// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionConfiguration definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSURLSessionConfiguration$Ext : NSURLSessionConfiguration
@end

#define crossmobile_ios_foundation_NSURLSessionConfiguration NSURLSessionConfiguration
@interface NSURLSessionConfiguration (cm_crossmobile_ios_foundation_NSURLSessionConfiguration)
+ (NSURLSessionConfiguration*) backgroundSessionConfigurationWithIdentifier___java_lang_String:(NSString*) identifier ;
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionConfiguration__;
- (void) setSharedContainerIdentifier___java_lang_String:(NSString*) sharedContainerIdentifier ;
- (NSString*) sharedContainerIdentifier__;
@end
