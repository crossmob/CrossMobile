// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSItemProvider definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSItemProviderCompletionHandler;
@protocol crossmobile_ios_foundation_NSSecureCoding;
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

@interface crossmobile_ios_foundation_NSItemProvider$Ext : NSItemProvider
@end

#define crossmobile_ios_foundation_NSItemProvider NSItemProvider
@interface NSItemProvider (cm_crossmobile_ios_foundation_NSItemProvider)
- (instancetype) __init_crossmobile_ios_foundation_NSItemProvider___crossmobile_ios_foundation_NSSecureCoding_java_lang_String:(id<NSSecureCoding>) itemtypeIdentifier :(NSString*) typeIdentifier ;
- (instancetype) __init_crossmobile_ios_foundation_NSItemProvider___crossmobile_ios_foundation_NSURL:(NSURL*) fileURL ;
- (NSArray*) registeredTypeIdentifiers__;
- (BOOL) hasItemConformingToTypeIdentifier___java_lang_String:(NSString*) typeIdentifier ;
- (void) loadItemForTypeIdentifier___java_lang_String_java_util_Map_crossmobile_ios_foundation_NSItemProviderCompletionHandler:(NSString*) typeIdentifier :(NSDictionary*) options :(id<crossmobile_ios_foundation_NSItemProviderCompletionHandler>) completionHandler ;
- (void) loadPreviewImageWithOptions___java_util_Map_crossmobile_ios_foundation_NSItemProviderCompletionHandler:(NSDictionary*) options :(id<crossmobile_ios_foundation_NSItemProviderCompletionHandler>) completionHandler ;
@end
