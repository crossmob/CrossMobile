// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.accounts.ACAccountType implementation

#import "crossmobile_ios_accounts_ACAccountType.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_accounts_ACAccountType$Ext

// (ACAccountType) @property(readonly, nonatomic) BOOL accessGranted;
- (BOOL) accessGranted__
{
    return [super accessGranted];
}

// (ACAccountType) @property(readonly, nonatomic) NSString *accountTypeDescription;
- (NSString*) accountTypeDescription__
{
    NSString* re$ult = [super accountTypeDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (ACAccountType) @property(readonly, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
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

@implementation ACAccountType (cm_crossmobile_ios_accounts_ACAccountType)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountType__
{
    return [self init];
}

// direct binding of: @property(readonly, nonatomic) BOOL accessGranted;
- (BOOL) accessGranted__
{
    return [self accessGranted];
}

// direct binding of: @property(readonly, nonatomic) NSString *accountTypeDescription;
- (NSString*) accountTypeDescription__
{
    NSString* re$ult = [self accountTypeDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
