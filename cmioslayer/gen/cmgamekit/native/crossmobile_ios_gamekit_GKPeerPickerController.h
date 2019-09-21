// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_gamekit_GKPeerPickerController definition

#import "xmlvm.h"
#import <GameKit/GameKit.h>
@protocol crossmobile_ios_gamekit_GKPeerPickerControllerDelegate;

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
