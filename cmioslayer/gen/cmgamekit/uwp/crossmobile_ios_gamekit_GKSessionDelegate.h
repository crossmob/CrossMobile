// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.gamekit.GKSessionDelegate definition

#import "xmlvm.h"
#import <GameKit/GameKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_gamekit_GKSession;
@class java_lang_String;

@protocol crossmobile_ios_gamekit_GKSessionDelegate
- (void) connectionWithPeerFailed___crossmobile_ios_gamekit_GKSession_java_lang_String_crossmobile_ios_foundation_NSError:(GKSession*) session :(NSString*) peerID :(NSError*) error ;
- (void) didFailWithError___crossmobile_ios_gamekit_GKSession_crossmobile_ios_foundation_NSError:(GKSession*) session :(NSError*) error ;
- (void) didReceiveConnectionRequestFromPeer___crossmobile_ios_gamekit_GKSession_java_lang_String:(GKSession*) session :(NSString*) peerID ;
- (void) peerDidChangeState___crossmobile_ios_gamekit_GKSession_java_lang_String_int:(GKSession*) session :(NSString*) peerID :(int) state ;
@end
