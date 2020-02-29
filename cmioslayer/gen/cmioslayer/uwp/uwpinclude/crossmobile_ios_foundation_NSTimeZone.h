// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_NSTimeZone definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSTimeZone$Ext : NSTimeZone
@end

#define crossmobile_ios_foundation_NSTimeZone NSTimeZone
@interface NSTimeZone (cm_crossmobile_ios_foundation_NSTimeZone)
- (instancetype) __init_crossmobile_ios_foundation_NSTimeZone___java_lang_String:(NSString*) tzName ;
- (NSString*) name__;
@end
