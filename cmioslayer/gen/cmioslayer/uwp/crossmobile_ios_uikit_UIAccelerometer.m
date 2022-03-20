// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAccelerometer implementation

#import "crossmobile_ios_uikit_UIAccelerometer.h"
#import "crossmobile_ios_uikit_UIAccelerometerDelegate.h"

@implementation crossmobile_ios_uikit_UIAccelerometer$Ext

@end

@implementation UIAccelerometer (cm_crossmobile_ios_uikit_UIAccelerometer)

// + (UIAccelerometer *)sharedAccelerometer;
+ (UIAccelerometer*) sharedAccelerometer__
{
    UIAccelerometer* re$ult = [UIAccelerometer sharedAccelerometer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<UIAccelerometerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIAccelerometerDelegate:(id<UIAccelerometerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic) NSTimeInterval updateInterval;
- (void) setUpdateInterval___double:(double) updateInterval 
{
    [self setUpdateInterval:updateInterval];
}

@end
