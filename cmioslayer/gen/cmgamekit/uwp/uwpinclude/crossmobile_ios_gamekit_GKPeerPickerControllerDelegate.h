// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_gamekit_GKPeerPickerControllerDelegate definition

#import "xmlvm.h"
#import <GameKit/GameKit.h>
@class crossmobile_ios_gamekit_GKPeerPickerController;
@class crossmobile_ios_gamekit_GKSession;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_gamekit_GKPeerPickerControllerDelegate
- (void) didCancel___crossmobile_ios_gamekit_GKPeerPickerController:(GKPeerPickerController*) picker ;
- (void) didConnectPeer___crossmobile_ios_gamekit_GKPeerPickerController_java_lang_String_crossmobile_ios_gamekit_GKSession:(GKPeerPickerController*) picker :(NSString*) peerID :(GKSession*) session ;
- (void) didSelectConnectionType___crossmobile_ios_gamekit_GKPeerPickerController_int:(GKPeerPickerController*) picker :(int) type ;
- (GKSession*) sessionForConnectionType___crossmobile_ios_gamekit_GKPeerPickerController_int:(GKPeerPickerController*) picker :(int) type ;
@end
