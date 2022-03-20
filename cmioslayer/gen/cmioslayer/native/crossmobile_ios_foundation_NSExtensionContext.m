// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSExtensionContext implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSExtensionContext.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "java_lang_Boolean.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "org_robovm_objc_block_VoidBlock1.h"
#import "org_robovm_objc_block_VoidBlock3.h"

@implementation crossmobile_ios_foundation_NSExtensionContext$Ext

@end

@implementation NSExtensionContext (cm_crossmobile_ios_foundation_NSExtensionContext)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSExtensionContext__
{
    return [self init];
}

// @property(readonly, copy, nonatomic) NSArray *inputItems;
- (NSArray*) inputItems__
{
    NSArray* re$ult = [self inputItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)cancelRequestWithError:(NSError *)error;
- (void) cancelRequestWithError___crossmobile_ios_foundation_NSError:(NSError*) error 
{
    [self cancelRequestWithError:(error == JAVA_NULL ? nil : error)];
}

// - (void)completeRequestReturningItems:(NSArray *)items completionHandler:(void (^)(BOOL expired))completionHandler;
- (void) completeRequestReturningItems___java_util_List_org_robovm_objc_block_VoidBlock1:(NSArray*) items :(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self completeRequestReturningItems:(items == JAVA_NULL ? nil : items) completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL expired) {
        java_lang_Boolean* expired$conv = [[java_lang_Boolean alloc] initWithBool:expired];
        [completionHandler invoke___java_lang_Object:expired$conv];
        [expired$conv release];
    })];
}

// - (void)loadBroadcastingApplicationInfoWithCompletion:(void (^)(NSString *bundleID, NSString *displayName, UIImage *appIcon))handler;
- (void) loadBroadcastingApplicationInfoWithCompletion___org_robovm_objc_block_VoidBlock3:(id<org_robovm_objc_block_VoidBlock3>) handler 
{
    [self loadBroadcastingApplicationInfoWithCompletion:(handler == JAVA_NULL ? nil : ^(NSString* bundleID, NSString* displayName, UIImage* appIcon) {
        [handler invoke___java_lang_Object_java_lang_Object_java_lang_Object:(bundleID ? bundleID : JAVA_NULL) :(displayName ? displayName : JAVA_NULL) :(appIcon ? appIcon : JAVA_NULL)];
    })];
}

// - (void)openURL:(NSURL *)URL completionHandler:(void (^)(BOOL success))completionHandler;
- (void) openURL___crossmobile_ios_foundation_NSURL_org_robovm_objc_block_VoidBlock1:(NSURL*) URL :(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self openURL:(URL == JAVA_NULL ? nil : URL) completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL success) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [completionHandler invoke___java_lang_Object:success$conv];
        [success$conv release];
    })];
}

@end
