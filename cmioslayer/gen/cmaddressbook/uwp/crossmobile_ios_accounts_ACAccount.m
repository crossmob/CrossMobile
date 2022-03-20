// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccount implementation

#import "crossmobile_ios_accounts_ACAccount.h"
#import "crossmobile_ios_accounts_ACAccountCredential.h"
#import "crossmobile_ios_accounts_ACAccountType.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_accounts_ACAccount$Ext

@end

@implementation ACAccount (cm_crossmobile_ios_accounts_ACAccount)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_accounts_ACAccount__
{
    return [self init];
}

// - (instancetype)initWithAccountType:(ACAccountType *)type;
- (instancetype) __init_crossmobile_ios_accounts_ACAccount___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) type 
{
    return [self initWithAccountType:(type == JAVA_NULL ? nil : type)];
}

// @property(copy, nonatomic) NSString *accountDescription;
- (void) setAccountDescription___java_lang_String:(NSString*) accountDescription 
{
    [self setAccountDescription:(accountDescription == JAVA_NULL ? nil : accountDescription)];
}

// @property(copy, nonatomic) NSString *accountDescription;
- (NSString*) accountDescription__
{
    NSString* re$ult = [self accountDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(strong, nonatomic) ACAccountType *accountType;
- (void) setAccountType___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) accountType 
{
    [self setAccountType:(accountType == JAVA_NULL ? nil : accountType)];
}

// @property(strong, nonatomic) ACAccountType *accountType;
- (ACAccountType*) accountType__
{
    ACAccountType* re$ult = [self accountType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(strong, nonatomic) ACAccountCredential *credential;
- (void) setCredential___crossmobile_ios_accounts_ACAccountCredential:(ACAccountCredential*) credential 
{
    [self setCredential:(credential == JAVA_NULL ? nil : credential)];
}

// @property(strong, nonatomic) ACAccountCredential *credential;
- (ACAccountCredential*) credential__
{
    ACAccountCredential* re$ult = [self credential];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, weak, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy, nonatomic) NSString *username;
- (void) setUsername___java_lang_String:(NSString*) username 
{
    [self setUsername:(username == JAVA_NULL ? nil : username)];
}

// @property(copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [self username];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
