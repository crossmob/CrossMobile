// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.gamekit.GKSession implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_gamekit_GKDataReceiveHandler.h"
#import "crossmobile_ios_gamekit_GKSession.h"
#import "crossmobile_ios_gamekit_GKSessionDelegate.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_gamekit_GKSession$Ext

// (GKSession) @property(getter=isAvailable) BOOL available;
- (void) setAvailable___boolean:(BOOL) available 
{
    [super setAvailable:available];
}

// (GKSession) @property(getter=isAvailable) BOOL available;
- (BOOL) isAvailable__
{
    return [super isAvailable];
}

// (GKSession) @property(assign) id<GKSessionDelegate> delegate;
- (void) setDelegate___crossmobile_ios_gamekit_GKSessionDelegate:(id<GKSessionDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (GKSession) @property(assign) id<GKSessionDelegate> delegate;
- (id<GKSessionDelegate>) delegate__
{
    id<GKSessionDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKSession) @property(assign) NSTimeInterval disconnectTimeout;
- (void) setDisconnectTimeout___double:(double) disconnectTimeout 
{
    [super setDisconnectTimeout:disconnectTimeout];
}

// (GKSession) @property(assign) NSTimeInterval disconnectTimeout;
- (double) disconnectTimeout__
{
    return [super disconnectTimeout];
}

// (GKSession) @property(readonly) NSString *displayName;
- (NSString*) displayName__
{
    NSString* re$ult = [super displayName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKSession) @property(readonly) NSString *peerID;
- (NSString*) peerID__
{
    NSString* re$ult = [super peerID];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKSession) @property(readonly) NSString *sessionID;
- (NSString*) sessionID__
{
    NSString* re$ult = [super sessionID];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKSession) @property(readonly) GKSessionMode sessionMode;
- (int) sessionMode__
{
    return [super sessionMode];
}

// (GKSession) - (BOOL)acceptConnectionFromPeer:(NSString *)peerID error:(NSError **)error;
- (BOOL) acceptConnectionFromPeer___java_lang_String_crossmobile_rt_StrongReference:(NSString*) peerID :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [super acceptConnectionFromPeer:(peerID == JAVA_NULL ? nil : peerID) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// (GKSession) - (void)cancelConnectToPeer:(NSString *)peerID;
- (void) cancelConnectToPeer___java_lang_String:(NSString*) peerID 
{
    [super cancelConnectToPeer:(peerID == JAVA_NULL ? nil : peerID)];
}

// (GKSession) - (void)connectToPeer:(NSString *)peerID withTimeout:(NSTimeInterval)timeout;
- (void) connectToPeer___java_lang_String_double:(NSString*) peerID :(double) timeout 
{
    [super connectToPeer:(peerID == JAVA_NULL ? nil : peerID) withTimeout:timeout];
}

// (GKSession) - (void)denyConnectionFromPeer:(NSString *)peerID;
- (void) denyConnectionFromPeer___java_lang_String:(NSString*) peerID 
{
    [super denyConnectionFromPeer:(peerID == JAVA_NULL ? nil : peerID)];
}

// (GKSession) - (void)disconnectFromAllPeers;
- (void) disconnectFromAllPeers__
{
    [super disconnectFromAllPeers];
}

// (GKSession) - (void)disconnectPeerFromAllPeers:(NSString *)peerID;
- (void) disconnectPeerFromAllPeers___java_lang_String:(NSString*) peerID 
{
    [super disconnectPeerFromAllPeers:(peerID == JAVA_NULL ? nil : peerID)];
}

// (GKSession) - (NSString *)displayNameForPeer:(NSString *)peerID;
- (NSString*) displayNameForPeer___java_lang_String:(NSString*) peerID 
{
    NSString* re$ult = [super displayNameForPeer:(peerID == JAVA_NULL ? nil : peerID)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKSession) - (NSArray *)peersWithConnectionState:(GKPeerConnectionState)state;
- (NSArray*) peersWithConnectionState___int:(int) state 
{
    NSArray* re$ult = [super peersWithConnectionState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKSession) - (BOOL)sendData:(NSData *)data toPeers:(NSArray *)peers withDataMode:(GKSendDataMode)mode error:(NSError **)error;
- (BOOL) sendData___crossmobile_ios_foundation_NSData_java_util_List_int_crossmobile_rt_StrongReference:(NSData*) data :(NSArray*) peers :(int) mode :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [super sendData:(data == JAVA_NULL ? nil : data) toPeers:(peers == JAVA_NULL ? nil : peers) withDataMode:mode error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// (GKSession) - (BOOL)sendDataToAllPeers:(NSData *)data withDataMode:(GKSendDataMode)mode error:(NSError **)error;
- (BOOL) sendDataToAllPeers___crossmobile_ios_foundation_NSData_int_crossmobile_rt_StrongReference:(NSData*) data :(int) mode :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [super sendDataToAllPeers:(data == JAVA_NULL ? nil : data) withDataMode:mode error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// (GKSession) - (void)setDataReceiveHandler:(id)handler withContext:(void *)context;
- (void) setDataReceiveHandler___crossmobile_ios_gamekit_GKDataReceiveHandler_java_lang_Object:(id<crossmobile_ios_gamekit_GKDataReceiveHandler>) handler :(id) context 
{
    [super setDataReceiveHandler:(handler == JAVA_NULL ? nil : handler) withContext:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation GKSession (cm_crossmobile_ios_gamekit_GKSession)

// direct binding of: - (id)initWithSessionID:(NSString *)sessionID displayName:(NSString *)name sessionMode:(GKSessionMode)mode;
- (id) __init_crossmobile_ios_gamekit_GKSession___java_lang_String_java_lang_String_int:(NSString*) sessionID :(NSString*) name :(int) mode 
{
    return [self initWithSessionID:(sessionID == JAVA_NULL ? nil : sessionID) displayName:(name == JAVA_NULL ? nil : name) sessionMode:mode];
}

// direct binding of: @property(getter=isAvailable) BOOL available;
- (void) setAvailable___boolean:(BOOL) available 
{
    [self setAvailable:available];
}

// direct binding of: @property(getter=isAvailable) BOOL available;
- (BOOL) isAvailable__
{
    return [self isAvailable];
}

// direct binding of: @property(assign) id<GKSessionDelegate> delegate;
- (void) setDelegate___crossmobile_ios_gamekit_GKSessionDelegate:(id<GKSessionDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(assign) id<GKSessionDelegate> delegate;
- (id<GKSessionDelegate>) delegate__
{
    id<GKSessionDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(assign) NSTimeInterval disconnectTimeout;
- (void) setDisconnectTimeout___double:(double) disconnectTimeout 
{
    [self setDisconnectTimeout:disconnectTimeout];
}

// direct binding of: @property(assign) NSTimeInterval disconnectTimeout;
- (double) disconnectTimeout__
{
    return [self disconnectTimeout];
}

// direct binding of: @property(readonly) NSString *displayName;
- (NSString*) displayName__
{
    NSString* re$ult = [self displayName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) NSString *peerID;
- (NSString*) peerID__
{
    NSString* re$ult = [self peerID];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) NSString *sessionID;
- (NSString*) sessionID__
{
    NSString* re$ult = [self sessionID];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) GKSessionMode sessionMode;
- (int) sessionMode__
{
    return [self sessionMode];
}

// direct binding of: - (BOOL)acceptConnectionFromPeer:(NSString *)peerID error:(NSError **)error;
- (BOOL) acceptConnectionFromPeer___java_lang_String_crossmobile_rt_StrongReference:(NSString*) peerID :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self acceptConnectionFromPeer:(peerID == JAVA_NULL ? nil : peerID) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: - (void)cancelConnectToPeer:(NSString *)peerID;
- (void) cancelConnectToPeer___java_lang_String:(NSString*) peerID 
{
    [self cancelConnectToPeer:(peerID == JAVA_NULL ? nil : peerID)];
}

// direct binding of: - (void)connectToPeer:(NSString *)peerID withTimeout:(NSTimeInterval)timeout;
- (void) connectToPeer___java_lang_String_double:(NSString*) peerID :(double) timeout 
{
    [self connectToPeer:(peerID == JAVA_NULL ? nil : peerID) withTimeout:timeout];
}

// direct binding of: - (void)denyConnectionFromPeer:(NSString *)peerID;
- (void) denyConnectionFromPeer___java_lang_String:(NSString*) peerID 
{
    [self denyConnectionFromPeer:(peerID == JAVA_NULL ? nil : peerID)];
}

// direct binding of: - (void)disconnectFromAllPeers;
- (void) disconnectFromAllPeers__
{
    [self disconnectFromAllPeers];
}

// direct binding of: - (void)disconnectPeerFromAllPeers:(NSString *)peerID;
- (void) disconnectPeerFromAllPeers___java_lang_String:(NSString*) peerID 
{
    [self disconnectPeerFromAllPeers:(peerID == JAVA_NULL ? nil : peerID)];
}

// direct binding of: - (NSString *)displayNameForPeer:(NSString *)peerID;
- (NSString*) displayNameForPeer___java_lang_String:(NSString*) peerID 
{
    NSString* re$ult = [self displayNameForPeer:(peerID == JAVA_NULL ? nil : peerID)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSArray *)peersWithConnectionState:(GKPeerConnectionState)state;
- (NSArray*) peersWithConnectionState___int:(int) state 
{
    NSArray* re$ult = [self peersWithConnectionState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (BOOL)sendData:(NSData *)data toPeers:(NSArray *)peers withDataMode:(GKSendDataMode)mode error:(NSError **)error;
- (BOOL) sendData___crossmobile_ios_foundation_NSData_java_util_List_int_crossmobile_rt_StrongReference:(NSData*) data :(NSArray*) peers :(int) mode :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self sendData:(data == JAVA_NULL ? nil : data) toPeers:(peers == JAVA_NULL ? nil : peers) withDataMode:mode error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: - (BOOL)sendDataToAllPeers:(NSData *)data withDataMode:(GKSendDataMode)mode error:(NSError **)error;
- (BOOL) sendDataToAllPeers___crossmobile_ios_foundation_NSData_int_crossmobile_rt_StrongReference:(NSData*) data :(int) mode :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self sendDataToAllPeers:(data == JAVA_NULL ? nil : data) withDataMode:mode error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: - (void)setDataReceiveHandler:(id)handler withContext:(void *)context;
- (void) setDataReceiveHandler___crossmobile_ios_gamekit_GKDataReceiveHandler_java_lang_Object:(id<crossmobile_ios_gamekit_GKDataReceiveHandler>) handler :(id) context 
{
    [self setDataReceiveHandler:(handler == JAVA_NULL ? nil : handler) withContext:(context == JAVA_NULL ? nil : context)];
}

@end
