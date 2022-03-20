// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAcceleration implementation

#import "crossmobile_ios_uikit_UIAcceleration.h"

@implementation crossmobile_ios_uikit_UIAcceleration$Ext

@end

@implementation UIAcceleration (cm_crossmobile_ios_uikit_UIAcceleration)

// @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// @property(nonatomic, readonly) UIAccelerationValue x;
- (double) x__
{
    return [self x];
}

// @property(nonatomic, readonly) UIAccelerationValue y;
- (double) y__
{
    return [self y];
}

// @property(nonatomic, readonly) UIAccelerationValue z;
- (double) z__
{
    return [self z];
}

@end
