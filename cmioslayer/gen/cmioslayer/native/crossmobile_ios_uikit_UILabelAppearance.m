// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILabelAppearance implementation

#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_ios_uikit_UILabelAppearance.h"

@implementation crossmobile_ios_uikit_UILabelAppearance

// @property(nonatomic, strong) UIFont *font;
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font 
{
    [self->$reference setFont:(font == JAVA_NULL ? nil : font)];
}

// @property(nonatomic, strong) UIColor *textColor;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor 
{
    [self->$reference setTextColor:(textColor == JAVA_NULL ? nil : textColor)];
}

- (instancetype) initWithUILabelAppearance:(id) reference
{
    self = [super initWithUIViewAppearance:reference];
    return self;
}

@end
