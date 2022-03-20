// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImage implementation

#import "crossmobile_ios_coregraphics_CGImage.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIImage$Ext

@end

@implementation UIImage (cm_crossmobile_ios_uikit_UIImage)

// + (UIImage *)animatedImageNamed:(NSString *)name duration:(NSTimeInterval)duration;
+ (UIImage*) animatedImageNamed___java_lang_String_double:(NSString*) name :(double) duration 
{
    UIImage* re$ult = [UIImage animatedImageNamed:(name == JAVA_NULL ? nil : name) duration:duration];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIImage *)animatedImageWithImages:(NSArray<UIImage *> *)images duration:(NSTimeInterval)duration;
+ (UIImage*) animatedImageWithImages___java_util_List_double:(NSArray*) images :(double) duration 
{
    UIImage* re$ult = [UIImage animatedImageWithImages:(images == JAVA_NULL ? nil : images) duration:duration];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIImage *)imageNamed:(NSString *)name;
+ (UIImage*) imageNamed___java_lang_String:(NSString*) name 
{
    UIImage* re$ult = [UIImage imageNamed:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIImage *)imageWithCGImage:(CGImageRef)cgImage;
+ (UIImage*) imageWithCGImage___crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGImage*) cgImage 
{
    UIImage* re$ult = [UIImage imageWithCGImage:cgImage->$reference];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIImage *)imageWithCGImage:(CGImageRef)cgImage scale:(CGFloat)scale orientation:(UIImageOrientation)orientation;
+ (UIImage*) imageWithCGImage___crossmobile_ios_coregraphics_CGImage_double_int:(crossmobile_ios_coregraphics_CGImage*) cgImage :(double) scale :(int) orientation 
{
    UIImage* re$ult = [UIImage imageWithCGImage:cgImage->$reference scale:scale orientation:orientation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIImage *)imageWithContentsOfFile:(NSString *)path;
+ (UIImage*) imageWithContentsOfFile___java_lang_String:(NSString*) path 
{
    UIImage* re$ult = [UIImage imageWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIImage *)imageWithData:(NSData *)data;
+ (UIImage*) imageWithData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    UIImage* re$ult = [UIImage imageWithData:(data == JAVA_NULL ? nil : data)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) CGImageRef CGImage;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[self CGImage]];
}

// @property(nonatomic, readonly) NSTimeInterval duration;
- (double) duration__
{
    return [self duration];
}

// @property(nonatomic, readonly) UIImageOrientation imageOrientation;
- (int) imageOrientation__
{
    return [self imageOrientation];
}

// @property(nonatomic, readonly) NSArray<UIImage *> *images;
- (NSArray*) images__
{
    NSArray* re$ult = [self images];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIImageRenderingMode renderingMode;
- (int) renderingMode__
{
    return [self renderingMode];
}

// @property(nonatomic, readonly) CGFloat scale;
- (double) scale__
{
    return [self scale];
}

// @property(nonatomic, readonly) CGSize size;
- (crossmobile_ios_coregraphics_CGSize*) size__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self size]];
}

// NSData * UIImageJPEGRepresentation ( UIImage *image, CGFloat compressionQuality );
- (NSData*) JPEGRepresentation___double:(double) compressionQuality 
{
    NSData* re$ult = UIImageJPEGRepresentation(self, compressionQuality);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// NSData * UIImagePNGRepresentation ( UIImage *image );
- (NSData*) PNGRepresentation__
{
    NSData* re$ult = UIImagePNGRepresentation(self);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)drawAtPoint:(CGPoint)point;
- (void) drawAtPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point 
{
    [self drawAtPoint:[point getCGPoint]];
}

// - (void)drawInRect:(CGRect)rect;
- (void) drawInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [self drawInRect:[rect getCGRect]];
}

// - (UIImage *)imageWithRenderingMode:(UIImageRenderingMode)renderingMode;
- (UIImage*) imageWithRenderingMode___int:(int) renderingMode 
{
    UIImage* re$ult = [self imageWithRenderingMode:renderingMode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets 
{
    UIImage* re$ult = [self resizableImageWithCapInsets:[capInsets getUIEdgeInsets]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets resizingMode:(UIImageResizingMode)resizingMode;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets_int:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets :(int) resizingMode 
{
    UIImage* re$ult = [self resizableImageWithCapInsets:[capInsets getUIEdgeInsets] resizingMode:resizingMode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)stretchableImageWithLeftCapWidth:(NSInteger)leftCapWidth topCapHeight:(NSInteger)topCapHeight;
- (UIImage*) stretchableImageWithLeftCapWidth___int_int:(int) leftCapWidth :(int) topCapHeight 
{
    UIImage* re$ult = [self stretchableImageWithLeftCapWidth:leftCapWidth topCapHeight:topCapHeight];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// void UIImageWriteToSavedPhotosAlbum ( UIImage *image, id completionTarget, SEL completionSelector, void *contextInfo );
- (void) writeToSavedPhotosAlbum___crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler_java_lang_Object:(id<crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler>) completionTarget :(id) contextInfo 
{
    UIImageWriteToSavedPhotosAlbum(self, (completionTarget == JAVA_NULL ? nil : completionTarget), @selector(didFinishSavingWithError___crossmobile_ios_uikit_UIImage_crossmobile_ios_foundation_NSError_java_lang_Object:::), (contextInfo == JAVA_NULL ? nil : contextInfo));
}

@end
