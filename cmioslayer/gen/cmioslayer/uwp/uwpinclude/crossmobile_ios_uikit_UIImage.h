// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImage definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGImage;
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_uikit_UIEdgeInsets;
@protocol crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler;
@class java_lang_Object;
@class java_lang_String;
@class java_lang_reflect_Method;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIImage$Ext : UIImage
@end

#define crossmobile_ios_uikit_UIImage UIImage
@interface UIImage (cm_crossmobile_ios_uikit_UIImage)
+ (UIImage*) animatedImageNamed___java_lang_String_double:(NSString*) name :(double) duration ;
+ (UIImage*) animatedImageWithImages___java_util_List_double:(NSArray*) images :(double) duration ;
+ (UIImage*) imageNamed___java_lang_String:(NSString*) name ;
+ (UIImage*) imageWithCGImage___crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGImage*) cgImage ;
+ (UIImage*) imageWithCGImage___crossmobile_ios_coregraphics_CGImage_double_int:(crossmobile_ios_coregraphics_CGImage*) cgImage :(double) scale :(int) orientation ;
+ (UIImage*) imageWithContentsOfFile___java_lang_String:(NSString*) path ;
+ (UIImage*) imageWithData___crossmobile_ios_foundation_NSData:(NSData*) data ;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__;
- (double) duration__;
- (int) imageOrientation__;
- (NSArray*) images__;
- (int) renderingMode__;
- (double) scale__;
- (crossmobile_ios_coregraphics_CGSize*) size__;
- (NSData*) JPEGRepresentation___double:(double) compressionQuality ;
- (NSData*) PNGRepresentation__;
- (void) drawAtPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point ;
- (void) drawInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (UIImage*) imageWithRenderingMode___int:(int) renderingMode ;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets ;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets_int:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets :(int) resizingMode ;
- (UIImage*) stretchableImageWithLeftCapWidth___int_int:(int) leftCapWidth :(int) topCapHeight ;
- (void) writeToSavedPhotosAlbum___crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler_java_lang_Object:(id<crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler>) completionTarget :(id) contextInfo ;
@end
