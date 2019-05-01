// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.accounts.ACAccountCredential implementation

#import "crossmobile_ios_accounts_ACAccountCredential.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_accounts_ACAccountCredential$Ext

// (ACAccountCredential) @property(copy, nonatomic) NSString *oauthToken;
- (void) setOauthToken___java_lang_String:(NSString*) oauthToken 
{
    [super setOauthToken:(oauthToken == JAVA_NULL ? nil : oauthToken)];
}

// (ACAccountCredential) @property(copy, nonatomic) NSString *oauthToken;
- (NSString*) oauthToken__
{
    NSString* re$ult = [super oauthToken];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation ACAccountCredential (cm_crossmobile_ios_accounts_ACAccountCredential)

// direct binding of: - (instancetype)initWithOAuthToken:(NSString *)token tokenSecret:(NSString *)secret;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountCredential___java_lang_String_java_lang_String:(NSString*) token :(NSString*) secret 
{
    return [self initWithOAuthToken:(token == JAVA_NULL ? nil : token) tokenSecret:(secret == JAVA_NULL ? nil : secret)];
}

// direct binding of: - (instancetype)initWithOAuth2Token:(NSString *)token refreshToken:(NSString *)refreshToken expiryDate:(NSDate *)expiryDate;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountCredential___java_lang_String_java_lang_String_crossmobile_ios_foundation_NSDate:(NSString*) token :(NSString*) refreshToken :(NSDate*) expiryDate 
{
    return [self initWithOAuth2Token:(token == JAVA_NULL ? nil : token) refreshToken:(refreshToken == JAVA_NULL ? nil : refreshToken) expiryDate:(expiryDate == JAVA_NULL ? nil : expiryDate)];
}

// direct binding of: @property(copy, nonatomic) NSString *oauthToken;
- (void) setOauthToken___java_lang_String:(NSString*) oauthToken 
{
    [self setOauthToken:(oauthToken == JAVA_NULL ? nil : oauthToken)];
}

// direct binding of: @property(copy, nonatomic) NSString *oauthToken;
- (NSString*) oauthToken__
{
    NSString* re$ult = [self oauthToken];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
