// (c) 2020 under LGPL by CrossMobile plugin tools

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
