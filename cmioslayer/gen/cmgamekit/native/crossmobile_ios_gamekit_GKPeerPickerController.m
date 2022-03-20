// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_gamekit_GKPeerPickerController implementation

#import "crossmobile_ios_gamekit_GKPeerPickerController.h"
#import "crossmobile_ios_gamekit_GKPeerPickerControllerDelegate.h"

@implementation crossmobile_ios_gamekit_GKPeerPickerController$Ext

@end

@implementation GKPeerPickerController (cm_crossmobile_ios_gamekit_GKPeerPickerController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_gamekit_GKPeerPickerController__
{
    return [self init];
}

// @property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;
- (void) setConnectionTypesMask___int:(int) connectionTypesMask 
{
    [self setConnectionTypesMask:connectionTypesMask];
}

// @property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;
- (int) connectionTypesMask__
{
    return [self connectionTypesMask];
}

// @property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_gamekit_GKPeerPickerControllerDelegate:(id<GKPeerPickerControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;
- (id<GKPeerPickerControllerDelegate>) delegate__
{
    id<GKPeerPickerControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, getter=isVisible) BOOL visible;
- (BOOL) isVisible__
{
    return [self isVisible];
}

// - (void)dismiss;
- (void) dismiss__
{
    [self dismiss];
}

// - (void)show;
- (void) show__
{
    [self show];
}

@end
