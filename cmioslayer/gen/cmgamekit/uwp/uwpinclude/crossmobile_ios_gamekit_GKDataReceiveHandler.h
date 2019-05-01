// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.gamekit.GKDataReceiveHandler definition

#import "xmlvm.h"
#import <GameKit/GameKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_gamekit_GKSession;
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_gamekit_GKDataReceiveHandler
- (void) receiveData___crossmobile_ios_foundation_NSData_java_lang_String_crossmobile_ios_gamekit_GKSession_java_lang_Object:(NSData*) data :(NSString*) peer :(GKSession*) session :(id) context ;
@end
