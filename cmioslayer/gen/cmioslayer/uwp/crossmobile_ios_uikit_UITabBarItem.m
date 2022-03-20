// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBarItem implementation

#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UITabBarItem$Ext

@end

@implementation UITabBarItem (cm_crossmobile_ios_uikit_UITabBarItem)

// - (instancetype)initWithTitle:(NSString *)title image:(UIImage *)image tag:(NSInteger)tag;
- (instancetype) __init_crossmobile_ios_uikit_UITabBarItem___java_lang_String_crossmobile_ios_uikit_UIImage_int:(NSString*) title :(UIImage*) image :(int) tag 
{
    return [self initWithTitle:(title == JAVA_NULL ? nil : title) image:(image == JAVA_NULL ? nil : image) tag:tag];
}

// @property(nonatomic, copy) NSString *badgeValue;
- (void) setBadgeValue___java_lang_String:(NSString*) badgeValue 
{
    [self setBadgeValue:(badgeValue == JAVA_NULL ? nil : badgeValue)];
}

// @property(nonatomic, copy) NSString *badgeValue;
- (NSString*) badgeValue__
{
    NSString* re$ult = [self badgeValue];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
