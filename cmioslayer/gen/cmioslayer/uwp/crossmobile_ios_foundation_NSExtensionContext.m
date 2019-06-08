// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSExtensionContext implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSExtensionContext.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "java_lang_Boolean.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "org_robovm_objc_block_VoidBlock1.h"
#import "org_robovm_objc_block_VoidBlock3.h"

@implementation crossmobile_ios_foundation_NSExtensionContext$Ext

// (NSExtensionContext) @property(readonly, copy, nonatomic) NSArray *inputItems;
- (NSArray*) inputItems__
{
    NSArray* re$ult = [super inputItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSExtensionContext) - (void)cancelRequestWithError:(NSError *)error;
- (void) cancelRequestWithError___crossmobile_ios_foundation_NSError:(NSError*) error 
{
    [super cancelRequestWithError:(error == JAVA_NULL ? nil : error)];
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

@implementation NSExtensionContext (cm_crossmobile_ios_foundation_NSExtensionContext)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSExtensionContext__
{
    return [self init];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray *inputItems;
- (NSArray*) inputItems__
{
    NSArray* re$ult = [self inputItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)cancelRequestWithError:(NSError *)error;
- (void) cancelRequestWithError___crossmobile_ios_foundation_NSError:(NSError*) error 
{
    [self cancelRequestWithError:(error == JAVA_NULL ? nil : error)];
}

// direct binding of: - (void)completeRequestReturningItems:(NSArray *)items completionHandler:(void (^)(BOOL expired))completionHandler;
- (void) completeRequestReturningItems___java_util_List_org_robovm_objc_block_VoidBlock1:(NSArray*) items :(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self completeRequestReturningItems:(items == JAVA_NULL ? nil : items) completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL expired) {
        java_lang_Boolean* expired$conv = [[java_lang_Boolean alloc] initWithBool:expired];
        [completionHandler invoke___java_lang_Object:expired$conv];
        [expired$conv release];
    })];
}

// direct binding of: - (void)loadBroadcastingApplicationInfoWithCompletion:(void (^)(NSString *bundleID, NSString *displayName, UIImage *appIcon))handler;
- (void) loadBroadcastingApplicationInfoWithCompletion___org_robovm_objc_block_VoidBlock3:(id<org_robovm_objc_block_VoidBlock3>) handler 
{
    [self loadBroadcastingApplicationInfoWithCompletion:(handler == JAVA_NULL ? nil : ^(NSString* bundleID, NSString* displayName, UIImage* appIcon) {
        [handler invoke___java_lang_Object_java_lang_Object_java_lang_Object:(bundleID ? bundleID : JAVA_NULL) :(displayName ? displayName : JAVA_NULL) :(appIcon ? appIcon : JAVA_NULL)];
    })];
}

// direct binding of: - (void)openURL:(NSURL *)URL completionHandler:(void (^)(BOOL success))completionHandler;
- (void) openURL___crossmobile_ios_foundation_NSURL_org_robovm_objc_block_VoidBlock1:(NSURL*) URL :(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self openURL:(URL == JAVA_NULL ? nil : URL) completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL success) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [completionHandler invoke___java_lang_Object:success$conv];
        [success$conv release];
    })];
}

@end
