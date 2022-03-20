// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CAShapeLayer implementation

#import "crossmobile_ios_coregraphics_CGPath.h"
#import "crossmobile_ios_quartzcore_CAShapeLayer.h"

@implementation crossmobile_ios_quartzcore_CAShapeLayer$Ext

@end

@implementation CAShapeLayer (cm_crossmobile_ios_quartzcore_CAShapeLayer)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CAShapeLayer__
{
    return [self init];
}

// @property CGPathRef path;
- (void) setPath___crossmobile_ios_coregraphics_CGPath:(crossmobile_ios_coregraphics_CGPath*) path 
{
    [self setPath:path->$reference];
}

// @property CGPathRef path;
- (crossmobile_ios_coregraphics_CGPath*) path__
{
    return [[crossmobile_ios_coregraphics_CGPath alloc] initWithCGPath:[self path]];
}

@end
