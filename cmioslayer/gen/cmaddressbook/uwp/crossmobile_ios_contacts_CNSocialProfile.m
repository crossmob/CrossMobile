// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNSocialProfile implementation

#import "crossmobile_ios_contacts_CNSocialProfile.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNSocialProfile$Ext

@end

@implementation CNSocialProfile (cm_crossmobile_ios_contacts_CNSocialProfile)

// - (instancetype)initWithUrlString:(NSString *)urlString username:(NSString *)username userIdentifier:(NSString *)userIdentifier service:(NSString *)service;
- (instancetype) __init_crossmobile_ios_contacts_CNSocialProfile___java_lang_String_java_lang_String_java_lang_String_java_lang_String:(NSString*) urlString :(NSString*) username :(NSString*) userIdentifier :(NSString*) service 
{
    return [self initWithUrlString:(urlString == JAVA_NULL ? nil : urlString) username:(username == JAVA_NULL ? nil : username) userIdentifier:(userIdentifier == JAVA_NULL ? nil : userIdentifier) service:(service == JAVA_NULL ? nil : service)];
}

// @property(readonly, copy, nonatomic) NSString *service;
- (NSString*) service__
{
    NSString* re$ult = [self service];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *urlString;
- (NSString*) urlString__
{
    NSString* re$ult = [self urlString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *userIdentifier;
- (NSString*) userIdentifier__
{
    NSString* re$ult = [self userIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [self username];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
