// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIUserNotificationSettings definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIUserNotificationSettings$Ext : UIUserNotificationSettings
@end

#define crossmobile_ios_uikit_UIUserNotificationSettings UIUserNotificationSettings
@interface UIUserNotificationSettings (cm_crossmobile_ios_uikit_UIUserNotificationSettings)
+ (instancetype) settingsForTypes___int_java_util_Set:(int) types :(NSSet*) categories ;
- (NSSet*) categories__;
- (int) types__;
@end
