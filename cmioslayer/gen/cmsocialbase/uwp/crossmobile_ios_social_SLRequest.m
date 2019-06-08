// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.social.SLRequest implementation

#import "crossmobile_ios_accounts_ACAccount.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_social_SLRequest.h"
#import "crossmobile_ios_social_SLRequestHandler.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_social_SLRequest$Ext

// (SLRequest) @property(readonly, nonatomic) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [super URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SLRequest) @property(retain, nonatomic) ACAccount *account;
- (void) setAccount___crossmobile_ios_accounts_ACAccount:(ACAccount*) account 
{
    [super setAccount:(account == JAVA_NULL ? nil : account)];
}

// (SLRequest) @property(retain, nonatomic) ACAccount *account;
- (ACAccount*) account__
{
    ACAccount* re$ult = [super account];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SLRequest) @property(readonly, nonatomic) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [super parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SLRequest) @property(readonly, nonatomic) SLRequestMethod requestMethod;
- (int) requestMethod__
{
    return [super requestMethod];
}

// (SLRequest) - (void)addMultipartData:(NSData *)data withName:(NSString *)name type:(NSString *)type filename:(NSString *)filename;
- (void) addMultipartData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_java_lang_String:(NSData*) data :(NSString*) name :(NSString*) type :(NSString*) filename 
{
    [super addMultipartData:(data == JAVA_NULL ? nil : data) withName:(name == JAVA_NULL ? nil : name) type:(type == JAVA_NULL ? nil : type) filename:(filename == JAVA_NULL ? nil : filename)];
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

// (SLRequest) - (NSURLRequest *)preparedURLRequest;
- (NSURLRequest*) preparedURLRequest__
{
    NSURLRequest* re$ult = [super preparedURLRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation SLRequest (cm_crossmobile_ios_social_SLRequest)

// direct binding of: + (SLRequest *)requestForServiceType:(NSString *)serviceType requestMethod:(SLRequestMethod)requestMethod URL:(NSURL *)url parameters:(NSDictionary *)parameters;
+ (SLRequest*) requestForServiceType___java_lang_String_int_crossmobile_ios_foundation_NSURL_java_util_Map:(NSString*) serviceType :(int) requestMethod :(NSURL*) url :(NSDictionary*) parameters 
{
    SLRequest* re$ult = [SLRequest requestForServiceType:(serviceType == JAVA_NULL ? nil : serviceType) requestMethod:requestMethod URL:(url == JAVA_NULL ? nil : url) parameters:(parameters == JAVA_NULL ? nil : parameters)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_social_SLRequest__
{
    return [self init];
}

// direct binding of: @property(readonly, nonatomic) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(retain, nonatomic) ACAccount *account;
- (void) setAccount___crossmobile_ios_accounts_ACAccount:(ACAccount*) account 
{
    [self setAccount:(account == JAVA_NULL ? nil : account)];
}

// direct binding of: @property(retain, nonatomic) ACAccount *account;
- (ACAccount*) account__
{
    ACAccount* re$ult = [self account];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [self parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) SLRequestMethod requestMethod;
- (int) requestMethod__
{
    return [self requestMethod];
}

// direct binding of: - (void)addMultipartData:(NSData *)data withName:(NSString *)name type:(NSString *)type filename:(NSString *)filename;
- (void) addMultipartData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_java_lang_String:(NSData*) data :(NSString*) name :(NSString*) type :(NSString*) filename 
{
    [self addMultipartData:(data == JAVA_NULL ? nil : data) withName:(name == JAVA_NULL ? nil : name) type:(type == JAVA_NULL ? nil : type) filename:(filename == JAVA_NULL ? nil : filename)];
}

// direct binding of: - (void)performRequestWithHandler:(SLRequestHandler)handler;
- (void) performRequestWithHandler___crossmobile_ios_social_SLRequestHandler:(id<crossmobile_ios_social_SLRequestHandler>) handler 
{
    [self performRequestWithHandler:(handler == JAVA_NULL ? nil : ^(NSData* responseData, NSHTTPURLResponse* urlResponse, NSError* error) {
        [handler invoke___crossmobile_ios_foundation_NSData_crossmobile_ios_foundation_NSHTTPURLResponse_crossmobile_ios_foundation_NSError:(responseData ? responseData : JAVA_NULL) :(urlResponse ? urlResponse : JAVA_NULL) :(error ? error : JAVA_NULL)];
    })];
}

// direct binding of: - (NSURLRequest *)preparedURLRequest;
- (NSURLRequest*) preparedURLRequest__
{
    NSURLRequest* re$ult = [self preparedURLRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
