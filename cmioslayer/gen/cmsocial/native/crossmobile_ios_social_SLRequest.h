// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_social_SLRequest definition

#import "xmlvm.h"
#import <Social/Social.h>
@class crossmobile_ios_accounts_ACAccount;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_foundation_NSURLRequest;
@protocol crossmobile_ios_social_SLRequestHandler;
@class java_lang_String;
@protocol java_util_Map;

@interface crossmobile_ios_social_SLRequest$Ext : SLRequest
@end

#define crossmobile_ios_social_SLRequest SLRequest
@interface SLRequest (cm_crossmobile_ios_social_SLRequest)
+ (SLRequest*) requestForServiceType___java_lang_String_int_crossmobile_ios_foundation_NSURL_java_util_Map:(NSString*) serviceType :(int) requestMethod :(NSURL*) url :(NSDictionary*) parameters ;
- (instancetype) __init_crossmobile_ios_social_SLRequest__;
- (NSURL*) URL__;
- (void) setAccount___crossmobile_ios_accounts_ACAccount:(ACAccount*) account ;
- (ACAccount*) account__;
- (NSDictionary*) parameters__;
- (int) requestMethod__;
- (void) addMultipartData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_java_lang_String:(NSData*) data :(NSString*) name :(NSString*) type :(NSString*) filename ;
- (void) performRequestWithHandler___crossmobile_ios_social_SLRequestHandler:(id<crossmobile_ios_social_SLRequestHandler>) handler ;
- (NSURLRequest*) preparedURLRequest__;
@end
