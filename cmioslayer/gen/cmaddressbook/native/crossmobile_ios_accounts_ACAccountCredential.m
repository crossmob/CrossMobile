// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccountCredential implementation

#import "crossmobile_ios_accounts_ACAccountCredential.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_accounts_ACAccountCredential$Ext

@end

@implementation ACAccountCredential (cm_crossmobile_ios_accounts_ACAccountCredential)

// - (instancetype)initWithOAuthToken:(NSString *)token tokenSecret:(NSString *)secret;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountCredential___java_lang_String_java_lang_String:(NSString*) token :(NSString*) secret 
{
    return [self initWithOAuthToken:(token == JAVA_NULL ? nil : token) tokenSecret:(secret == JAVA_NULL ? nil : secret)];
}

// - (instancetype)initWithOAuth2Token:(NSString *)token refreshToken:(NSString *)refreshToken expiryDate:(NSDate *)expiryDate;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountCredential___java_lang_String_java_lang_String_crossmobile_ios_foundation_NSDate:(NSString*) token :(NSString*) refreshToken :(NSDate*) expiryDate 
{
    return [self initWithOAuth2Token:(token == JAVA_NULL ? nil : token) refreshToken:(refreshToken == JAVA_NULL ? nil : refreshToken) expiryDate:(expiryDate == JAVA_NULL ? nil : expiryDate)];
}

// @property(copy, nonatomic) NSString *oauthToken;
- (void) setOauthToken___java_lang_String:(NSString*) oauthToken 
{
    [self setOauthToken:(oauthToken == JAVA_NULL ? nil : oauthToken)];
}

// @property(copy, nonatomic) NSString *oauthToken;
- (NSString*) oauthToken__
{
    NSString* re$ult = [self oauthToken];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
