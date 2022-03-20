// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_social_SLComposeViewController implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_social_SLComposeViewController.h"
#import "crossmobile_ios_social_SLComposeViewControllerCompletionHandler.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_social_SLComposeViewController$Ext

@end

@implementation SLComposeViewController (cm_crossmobile_ios_social_SLComposeViewController)

// + (SLComposeViewController*)composeViewControllerForServiceType:(NSString *)serviceType;
+ (SLComposeViewController*) composeViewControllerForServiceType___java_lang_String:(NSString*) serviceType 
{
    SLComposeViewController* re$ult = [SLComposeViewController composeViewControllerForServiceType:(serviceType == JAVA_NULL ? nil : serviceType)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (BOOL)isAvailableForServiceType:(NSString *)serviceType;
+ (BOOL) isAvailableForServiceType___java_lang_String:(NSString*) serviceType 
{
    return [SLComposeViewController isAvailableForServiceType:(serviceType == JAVA_NULL ? nil : serviceType)];
}

// @property(nonatomic, copy) SLComposeViewControllerCompletionHandler completionHandler;
- (void) setCompletionHandler___crossmobile_ios_social_SLComposeViewControllerCompletionHandler:(id<crossmobile_ios_social_SLComposeViewControllerCompletionHandler>) completionHandler 
{
    [self setCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(SLComposeViewControllerResult result) {
        java_lang_Integer* result$conv = [[java_lang_Integer alloc] initWithInt:result];
        [completionHandler invoke___java_lang_Integer:result$conv];
        [result$conv release];
    })];
}

// @property(nonatomic, readonly) NSString *serviceType;
- (NSString*) serviceType__
{
    NSString* re$ult = [self serviceType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)addImage:(UIImage *)image;
- (BOOL) addImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    return [self addImage:(image == JAVA_NULL ? nil : image)];
}

// - (BOOL)addURL:(NSURL *)url;
- (BOOL) addURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [self addURL:(url == JAVA_NULL ? nil : url)];
}

// - (BOOL)removeAllImages;
- (BOOL) removeAllImages__
{
    return [self removeAllImages];
}

// - (BOOL)removeAllURLs;
- (BOOL) removeAllURLs__
{
    return [self removeAllURLs];
}

// - (BOOL)setInitialText:(NSString *)text;
- (BOOL) setInitialText___java_lang_String:(NSString*) text 
{
    return [self setInitialText:(text == JAVA_NULL ? nil : text)];
}

@end
