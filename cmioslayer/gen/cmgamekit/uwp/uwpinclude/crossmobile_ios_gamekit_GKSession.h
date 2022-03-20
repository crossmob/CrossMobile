// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_gamekit_GKSession definition

#import "xmlvm.h"
#import <GameKit/GameKit.h>
@class crossmobile_ios_foundation_NSData;
@protocol crossmobile_ios_gamekit_GKDataReceiveHandler;
@protocol crossmobile_ios_gamekit_GKSessionDelegate;
@class crossmobile_rt_StrongReference;
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_gamekit_GKSession$Ext : GKSession
@end

#define crossmobile_ios_gamekit_GKSession GKSession
@interface GKSession (cm_crossmobile_ios_gamekit_GKSession)
- (id) __init_crossmobile_ios_gamekit_GKSession___java_lang_String_java_lang_String_int:(NSString*) sessionID :(NSString*) name :(int) mode ;
- (void) setAvailable___boolean:(BOOL) available ;
- (BOOL) isAvailable__;
- (void) setDelegate___crossmobile_ios_gamekit_GKSessionDelegate:(id<GKSessionDelegate>) delegate ;
- (id<GKSessionDelegate>) delegate__;
- (void) setDisconnectTimeout___double:(double) disconnectTimeout ;
- (double) disconnectTimeout__;
- (NSString*) displayName__;
- (NSString*) peerID__;
- (NSString*) sessionID__;
- (int) sessionMode__;
- (BOOL) acceptConnectionFromPeer___java_lang_String_crossmobile_rt_StrongReference:(NSString*) peerID :(crossmobile_rt_StrongReference*) error ;
- (void) cancelConnectToPeer___java_lang_String:(NSString*) peerID ;
- (void) connectToPeer___java_lang_String_double:(NSString*) peerID :(double) timeout ;
- (void) denyConnectionFromPeer___java_lang_String:(NSString*) peerID ;
- (void) disconnectFromAllPeers__;
- (void) disconnectPeerFromAllPeers___java_lang_String:(NSString*) peerID ;
- (NSString*) displayNameForPeer___java_lang_String:(NSString*) peerID ;
- (NSArray*) peersWithConnectionState___int:(int) state ;
- (BOOL) sendData___crossmobile_ios_foundation_NSData_java_util_List_int_crossmobile_rt_StrongReference:(NSData*) data :(NSArray*) peers :(int) mode :(crossmobile_rt_StrongReference*) error ;
- (BOOL) sendDataToAllPeers___crossmobile_ios_foundation_NSData_int_crossmobile_rt_StrongReference:(NSData*) data :(int) mode :(crossmobile_rt_StrongReference*) error ;
- (void) setDataReceiveHandler___crossmobile_ios_gamekit_GKDataReceiveHandler_java_lang_Object:(id<crossmobile_ios_gamekit_GKDataReceiveHandler>) handler :(id) context ;
@end
