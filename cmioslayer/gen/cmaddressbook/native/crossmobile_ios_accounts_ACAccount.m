// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.accounts.ACAccount implementation

#import "crossmobile_ios_accounts_ACAccount.h"
#import "crossmobile_ios_accounts_ACAccountCredential.h"
#import "crossmobile_ios_accounts_ACAccountType.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_accounts_ACAccount$Ext

// (ACAccount) @property(copy, nonatomic) NSString *accountDescription;
- (void) setAccountDescription___java_lang_String:(NSString*) accountDescription 
{
    [super setAccountDescription:(accountDescription == JAVA_NULL ? nil : accountDescription)];
}

// (ACAccount) @property(copy, nonatomic) NSString *accountDescription;
- (NSString*) accountDescription__
{
    NSString* re$ult = [super accountDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (ACAccount) @property(strong, nonatomic) ACAccountType *accountType;
- (void) setAccountType___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) accountType 
{
    [super setAccountType:(accountType == JAVA_NULL ? nil : accountType)];
}

// (ACAccount) @property(strong, nonatomic) ACAccountType *accountType;
- (ACAccountType*) accountType__
{
    ACAccountType* re$ult = [super accountType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (ACAccount) @property(strong, nonatomic) ACAccountCredential *credential;
- (void) setCredential___crossmobile_ios_accounts_ACAccountCredential:(ACAccountCredential*) credential 
{
    [super setCredential:(credential == JAVA_NULL ? nil : credential)];
}

// (ACAccount) @property(strong, nonatomic) ACAccountCredential *credential;
- (ACAccountCredential*) credential__
{
    ACAccountCredential* re$ult = [super credential];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (ACAccount) @property(readonly, weak, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (ACAccount) @property(copy, nonatomic) NSString *username;
- (void) setUsername___java_lang_String:(NSString*) username 
{
    [super setUsername:(username == JAVA_NULL ? nil : username)];
}

// (ACAccount) @property(copy, nonatomic) NSString *username;
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

@implementation ACAccount (cm_crossmobile_ios_accounts_ACAccount)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_accounts_ACAccount__
{
    return [self init];
}

// direct binding of: - (instancetype)initWithAccountType:(ACAccountType *)type;
- (instancetype) __init_crossmobile_ios_accounts_ACAccount___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) type 
{
    return [self initWithAccountType:(type == JAVA_NULL ? nil : type)];
}

// direct binding of: @property(copy, nonatomic) NSString *accountDescription;
- (void) setAccountDescription___java_lang_String:(NSString*) accountDescription 
{
    [self setAccountDescription:(accountDescription == JAVA_NULL ? nil : accountDescription)];
}

// direct binding of: @property(copy, nonatomic) NSString *accountDescription;
- (NSString*) accountDescription__
{
    NSString* re$ult = [self accountDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(strong, nonatomic) ACAccountType *accountType;
- (void) setAccountType___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) accountType 
{
    [self setAccountType:(accountType == JAVA_NULL ? nil : accountType)];
}

// direct binding of: @property(strong, nonatomic) ACAccountType *accountType;
- (ACAccountType*) accountType__
{
    ACAccountType* re$ult = [self accountType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(strong, nonatomic) ACAccountCredential *credential;
- (void) setCredential___crossmobile_ios_accounts_ACAccountCredential:(ACAccountCredential*) credential 
{
    [self setCredential:(credential == JAVA_NULL ? nil : credential)];
}

// direct binding of: @property(strong, nonatomic) ACAccountCredential *credential;
- (ACAccountCredential*) credential__
{
    ACAccountCredential* re$ult = [self credential];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, weak, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy, nonatomic) NSString *username;
- (void) setUsername___java_lang_String:(NSString*) username 
{
    [self setUsername:(username == JAVA_NULL ? nil : username)];
}

// direct binding of: @property(copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [self username];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
