// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIBarItem definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIEdgeInsets;
@class crossmobile_ios_uikit_UIImage;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIBarItem$Ext : UIBarItem
@end

#define crossmobile_ios_uikit_UIBarItem UIBarItem
@interface UIBarItem (cm_crossmobile_ios_uikit_UIBarItem)
- (void) setEnabled___boolean:(BOOL) enabled ;
- (BOOL) isEnabled__;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image ;
- (UIImage*) image__;
- (void) setImageInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageInsets ;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageInsets__;
- (void) setTag___int:(int) tag ;
- (int) tag__;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (NSString*) title__;
@end
