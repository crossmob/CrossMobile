// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_social_SLRequest implementation

#import "crossmobile_ios_accounts_ACAccount.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_social_SLRequest.h"
#import "crossmobile_ios_social_SLRequestHandler.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_social_SLRequest$Ext

@end

@implementation SLRequest (cm_crossmobile_ios_social_SLRequest)

// + (SLRequest *)requestForServiceType:(NSString *)serviceType requestMethod:(SLRequestMethod)requestMethod URL:(NSURL *)url parameters:(NSDictionary *)parameters;
+ (SLRequest*) requestForServiceType___java_lang_String_int_crossmobile_ios_foundation_NSURL_java_util_Map:(NSString*) serviceType :(int) requestMethod :(NSURL*) url :(NSDictionary*) parameters 
{
    SLRequest* re$ult = [SLRequest requestForServiceType:(serviceType == JAVA_NULL ? nil : serviceType) requestMethod:requestMethod URL:(url == JAVA_NULL ? nil : url) parameters:(parameters == JAVA_NULL ? nil : parameters)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_social_SLRequest__
{
    return [self init];
}

// @property(readonly, nonatomic) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(retain, nonatomic) ACAccount *account;
- (void) setAccount___crossmobile_ios_accounts_ACAccount:(ACAccount*) account 
{
    [self setAccount:(account == JAVA_NULL ? nil : account)];
}

// @property(retain, nonatomic) ACAccount *account;
- (ACAccount*) account__
{
    ACAccount* re$ult = [self account];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [self parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) SLRequestMethod requestMethod;
- (int) requestMethod__
{
    return [self requestMethod];
}

// - (void)addMultipartData:(NSData *)data withName:(NSString *)name type:(NSString *)type filename:(NSString *)filename;
- (void) addMultipartData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_java_lang_String:(NSData*) data :(NSString*) name :(NSString*) type :(NSString*) filename 
{
    [self addMultipartData:(data == JAVA_NULL ? nil : data) withName:(name == JAVA_NULL ? nil : name) type:(type == JAVA_NULL ? nil : type) filename:(filename == JAVA_NULL ? nil : filename)];
}

// - (void)performRequestWithHandler:(SLRequestHandler)handler;
- (void) performRequestWithHandler___crossmobile_ios_social_SLRequestHandler:(id<crossmobile_ios_social_SLRequestHandler>) handler 
{
    [self performRequestWithHandler:(handler == JAVA_NULL ? nil : ^(NSData* responseData, NSHTTPURLResponse* urlResponse, NSError* error) {
        [handler invoke___crossmobile_ios_foundation_NSData_crossmobile_ios_foundation_NSHTTPURLResponse_crossmobile_ios_foundation_NSError:(responseData ? responseData : JAVA_NULL) :(urlResponse ? urlResponse : JAVA_NULL) :(error ? error : JAVA_NULL)];
    })];
}

// - (NSURLRequest *)preparedURLRequest;
- (NSURLRequest*) preparedURLRequest__
{
    NSURLRequest* re$ult = [self preparedURLRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
