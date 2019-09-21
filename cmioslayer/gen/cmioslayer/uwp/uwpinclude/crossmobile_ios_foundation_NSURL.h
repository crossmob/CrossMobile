// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_NSURL definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSURL$Ext : NSURL
@end

#define crossmobile_ios_foundation_NSURL NSURL
@interface NSURL (cm_crossmobile_ios_foundation_NSURL)
+ (instancetype) URLWithString___java_lang_String:(NSString*) URLString ;
+ (NSURL*) fileURLWithPath___java_lang_String:(NSString*) path ;
- (NSString*) absoluteString__;
@end
