// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.accounts.ACAccountCredential implementation

#import "crossmobile_ios_accounts_ACAccountCredential.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

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

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
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
