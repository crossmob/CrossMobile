// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIActivityViewController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_uikit_UIActivityViewControllerCompletionHandler;
@protocol crossmobile_ios_uikit_UIActivityViewControllerCompletionWithItemsHandler;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIActivityViewController$Ext : UIActivityViewController
@end

#define crossmobile_ios_uikit_UIActivityViewController UIActivityViewController
@interface UIActivityViewController (cm_crossmobile_ios_uikit_UIActivityViewController)
- (instancetype) __init_crossmobile_ios_uikit_UIActivityViewController___java_util_List_java_util_List:(NSArray*) activityItems :(NSArray*) applicationActivities ;
- (void) setCompletionHandler___crossmobile_ios_uikit_UIActivityViewControllerCompletionHandler:(id<crossmobile_ios_uikit_UIActivityViewControllerCompletionHandler>) completionHandler ;
- (void) setCompletionWithItemsHandler___crossmobile_ios_uikit_UIActivityViewControllerCompletionWithItemsHandler:(id<crossmobile_ios_uikit_UIActivityViewControllerCompletionWithItemsHandler>) completionWithItemsHandler ;
- (void) setExcludedActivityTypes___java_util_List:(NSArray*) excludedActivityTypes ;
- (NSArray*) excludedActivityTypes__;
@end
