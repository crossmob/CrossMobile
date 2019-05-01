// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLSessionConfiguration definition

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
