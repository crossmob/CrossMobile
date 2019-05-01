// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UINib definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSBundle;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSObject;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UINib$Ext : UINib
@end

#define crossmobile_ios_uikit_UINib UINib
@interface UINib (cm_crossmobile_ios_uikit_UINib)
+ (UINib*) nibWithData___crossmobile_ios_foundation_NSData_crossmobile_ios_foundation_NSBundle:(NSData*) data :(NSBundle*) bundleOrNil ;
+ (UINib*) nibWithNibName___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) name :(NSBundle*) bundleOrNil ;
- (instancetype) __init_crossmobile_ios_uikit_UINib__;
- (NSArray*) instantiateWithOwner___crossmobile_ios_foundation_NSObject_java_util_Map:(NSObject*) ownerOrNil :(NSDictionary*) optionsOrNil ;
@end
