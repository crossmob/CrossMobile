// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNSocialProfile implementation

#import "crossmobile_ios_contacts_CNSocialProfile.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNSocialProfile$Ext

// (CNSocialProfile) @property(readonly, copy, nonatomic) NSString *service;
- (NSString*) service__
{
    NSString* re$ult = [super service];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNSocialProfile) @property(readonly, copy, nonatomic) NSString *urlString;
- (NSString*) urlString__
{
    NSString* re$ult = [super urlString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNSocialProfile) @property(readonly, copy, nonatomic) NSString *userIdentifier;
- (NSString*) userIdentifier__
{
    NSString* re$ult = [super userIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNSocialProfile) @property(readonly, copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [super username];
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

@implementation CNSocialProfile (cm_crossmobile_ios_contacts_CNSocialProfile)

// direct binding of: - (instancetype)initWithUrlString:(NSString *)urlString username:(NSString *)username userIdentifier:(NSString *)userIdentifier service:(NSString *)service;
- (instancetype) __init_crossmobile_ios_contacts_CNSocialProfile___java_lang_String_java_lang_String_java_lang_String_java_lang_String:(NSString*) urlString :(NSString*) username :(NSString*) userIdentifier :(NSString*) service 
{
    return [self initWithUrlString:(urlString == JAVA_NULL ? nil : urlString) username:(username == JAVA_NULL ? nil : username) userIdentifier:(userIdentifier == JAVA_NULL ? nil : userIdentifier) service:(service == JAVA_NULL ? nil : service)];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *service;
- (NSString*) service__
{
    NSString* re$ult = [self service];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *urlString;
- (NSString*) urlString__
{
    NSString* re$ult = [self urlString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *userIdentifier;
- (NSString*) userIdentifier__
{
    NSString* re$ult = [self userIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [self username];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
