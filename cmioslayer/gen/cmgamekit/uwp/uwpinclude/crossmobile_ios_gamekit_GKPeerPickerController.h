// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_gamekit_GKPeerPickerController definition

#import "xmlvm.h"
#import <GameKit/GameKit.h>
@protocol crossmobile_ios_gamekit_GKPeerPickerControllerDelegate;

CM_EXPORT_CLASS
@interface crossmobile_ios_gamekit_GKPeerPickerController$Ext : GKPeerPickerController
@end

#define crossmobile_ios_gamekit_GKPeerPickerController GKPeerPickerController
@interface GKPeerPickerController (cm_crossmobile_ios_gamekit_GKPeerPickerController)
- (instancetype) __init_crossmobile_ios_gamekit_GKPeerPickerController__;
- (void) setConnectionTypesMask___int:(int) connectionTypesMask ;
- (int) connectionTypesMask__;
- (void) setDelegate___crossmobile_ios_gamekit_GKPeerPickerControllerDelegate:(id<GKPeerPickerControllerDelegate>) delegate ;
- (id<GKPeerPickerControllerDelegate>) delegate__;
- (BOOL) isVisible__;
- (void) dismiss__;
- (void) show__;
@end
