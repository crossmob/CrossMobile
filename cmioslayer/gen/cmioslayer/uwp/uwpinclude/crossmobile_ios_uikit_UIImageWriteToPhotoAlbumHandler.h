// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_uikit_UIImage;
@class java_lang_Object;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler
- (void) didFinishSavingWithError___crossmobile_ios_uikit_UIImage_crossmobile_ios_foundation_NSError_java_lang_Object:(UIImage*) image :(NSError*) error :(id) contextInfo ;
@end
