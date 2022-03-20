// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_social_SLComposeViewController definition

#import "xmlvm.h"
#import <Social/Social.h>
@class crossmobile_ios_foundation_NSURL;
@protocol crossmobile_ios_social_SLComposeViewControllerCompletionHandler;
@class crossmobile_ios_uikit_UIImage;
@class java_lang_String;

@interface crossmobile_ios_social_SLComposeViewController$Ext : SLComposeViewController
@end

#define crossmobile_ios_social_SLComposeViewController SLComposeViewController
@interface SLComposeViewController (cm_crossmobile_ios_social_SLComposeViewController)
+ (SLComposeViewController*) composeViewControllerForServiceType___java_lang_String:(NSString*) serviceType ;
+ (BOOL) isAvailableForServiceType___java_lang_String:(NSString*) serviceType ;
- (void) setCompletionHandler___crossmobile_ios_social_SLComposeViewControllerCompletionHandler:(id<crossmobile_ios_social_SLComposeViewControllerCompletionHandler>) completionHandler ;
- (NSString*) serviceType__;
- (BOOL) addImage___crossmobile_ios_uikit_UIImage:(UIImage*) image ;
- (BOOL) addURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (BOOL) removeAllImages__;
- (BOOL) removeAllURLs__;
- (BOOL) setInitialText___java_lang_String:(NSString*) text ;
@end
