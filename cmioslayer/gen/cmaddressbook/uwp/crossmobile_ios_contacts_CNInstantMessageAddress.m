// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNInstantMessageAddress implementation

#import "crossmobile_ios_contacts_CNInstantMessageAddress.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNInstantMessageAddress$Ext

// (CNInstantMessageAddress) @property(readonly, copy, nonatomic) NSString *service;
- (NSString*) service__
{
    NSString* re$ult = [super service];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNInstantMessageAddress) @property(readonly, copy, nonatomic) NSString *username;
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

@implementation CNInstantMessageAddress (cm_crossmobile_ios_contacts_CNInstantMessageAddress)

// direct binding of: - (instancetype)initWithUsername:(NSString *)username service:(NSString *)service;
- (instancetype) __init_crossmobile_ios_contacts_CNInstantMessageAddress___java_lang_String_java_lang_String:(NSString*) username :(NSString*) service 
{
    return [self initWithUsername:(username == JAVA_NULL ? nil : username) service:(service == JAVA_NULL ? nil : service)];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *service;
- (NSString*) service__
{
    NSString* re$ult = [self service];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [self username];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
