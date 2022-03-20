// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIScreen implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIScreen.h"

@implementation crossmobile_ios_uikit_UIScreen$Ext

@end

@implementation UIScreen (cm_crossmobile_ios_uikit_UIScreen)

// + (UIScreen *)mainScreen;
+ (UIScreen*) mainScreen__
{
    UIScreen* re$ult = [UIScreen mainScreen];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIScreen__
{
    return [self init];
}

// @property(nonatomic, readonly) CGRect applicationFrame;
- (crossmobile_ios_coregraphics_CGRect*) applicationFrame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self applicationFrame]];
}

// @property(nonatomic, readonly) CGRect bounds;
- (crossmobile_ios_coregraphics_CGRect*) bounds__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self bounds]];
}

// @property(nonatomic, readonly) CGFloat scale;
- (double) scale__
{
    return [self scale];
}

@end
