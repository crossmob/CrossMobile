// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIImage implementation

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

// (UIImage) @property(nonatomic, readonly) CGImageRef CGImage;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[super CGImage]];
}

// (UIImage) @property(nonatomic, readonly) NSTimeInterval duration;
- (double) duration__
{
    return [super duration];
}

// (UIImage) @property(nonatomic, readonly) UIImageOrientation imageOrientation;
- (int) imageOrientation__
{
    return [super imageOrientation];
}

// (UIImage) @property(nonatomic, readonly) NSArray<UIImage *> *images;
- (NSArray*) images__
{
    NSArray* re$ult = [super images];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIImage) @property(nonatomic, readonly) UIImageRenderingMode renderingMode;
- (int) renderingMode__
{
    return [super renderingMode];
}

// (UIImage) @property(nonatomic, readonly) CGFloat scale;
- (double) scale__
{
    return [super scale];
}

// (UIImage) @property(nonatomic, readonly) CGSize size;
- (crossmobile_ios_coregraphics_CGSize*) size__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super size]];
}

// (UIImage) - (void)drawAtPoint:(CGPoint)point;
- (void) drawAtPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point 
{
    [super drawAtPoint:[point getCGPoint]];
}

// (UIImage) - (void)drawInRect:(CGRect)rect;
- (void) drawInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [super drawInRect:[rect getCGRect]];
}

// (UIImage) - (UIImage *)imageWithRenderingMode:(UIImageRenderingMode)renderingMode;
- (UIImage*) imageWithRenderingMode___int:(int) renderingMode 
{
    UIImage* re$ult = [super imageWithRenderingMode:renderingMode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIImage) - (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets 
{
    UIImage* re$ult = [super resizableImageWithCapInsets:[capInsets getUIEdgeInsets]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIImage) - (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets resizingMode:(UIImageResizingMode)resizingMode;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets_int:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets :(int) resizingMode 
{
    UIImage* re$ult = [super resizableImageWithCapInsets:[capInsets getUIEdgeInsets] resizingMode:resizingMode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (UIImage) - (UIImage *)stretchableImageWithLeftCapWidth:(NSInteger)leftCapWidth topCapHeight:(NSInteger)topCapHeight;
- (UIImage*) stretchableImageWithLeftCapWidth___int_int:(int) leftCapWidth :(int) topCapHeight 
{
    UIImage* re$ult = [super stretchableImageWithLeftCapWidth:leftCapWidth topCapHeight:topCapHeight];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIImage (cm_crossmobile_ios_uikit_UIImage)

// direct binding of: + (UIImage *)animatedImageNamed:(NSString *)name duration:(NSTimeInterval)duration;
+ (UIImage*) animatedImageNamed___java_lang_String_double:(NSString*) name :(double) duration 
{
    UIImage* re$ult = [UIImage animatedImageNamed:(name == JAVA_NULL ? nil : name) duration:duration];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIImage *)animatedImageWithImages:(NSArray<UIImage *> *)images duration:(NSTimeInterval)duration;
+ (UIImage*) animatedImageWithImages___java_util_List_double:(NSArray*) images :(double) duration 
{
    UIImage* re$ult = [UIImage animatedImageWithImages:(images == JAVA_NULL ? nil : images) duration:duration];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIImage *)imageNamed:(NSString *)name;
+ (UIImage*) imageNamed___java_lang_String:(NSString*) name 
{
    UIImage* re$ult = [UIImage imageNamed:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIImage *)imageWithCGImage:(CGImageRef)cgImage;
+ (UIImage*) imageWithCGImage___crossmobile_ios_coregraphics_CGImage:(crossmobile_ios_coregraphics_CGImage*) cgImage 
{
    UIImage* re$ult = [UIImage imageWithCGImage:cgImage->$reference];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIImage *)imageWithCGImage:(CGImageRef)cgImage scale:(CGFloat)scale orientation:(UIImageOrientation)orientation;
+ (UIImage*) imageWithCGImage___crossmobile_ios_coregraphics_CGImage_double_int:(crossmobile_ios_coregraphics_CGImage*) cgImage :(double) scale :(int) orientation 
{
    UIImage* re$ult = [UIImage imageWithCGImage:cgImage->$reference scale:scale orientation:orientation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIImage *)imageWithContentsOfFile:(NSString *)path;
+ (UIImage*) imageWithContentsOfFile___java_lang_String:(NSString*) path 
{
    UIImage* re$ult = [UIImage imageWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIImage *)imageWithData:(NSData *)data;
+ (UIImage*) imageWithData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    UIImage* re$ult = [UIImage imageWithData:(data == JAVA_NULL ? nil : data)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) CGImageRef CGImage;
- (crossmobile_ios_coregraphics_CGImage*) CGImage__
{
    return [[crossmobile_ios_coregraphics_CGImage alloc] initWithCGImage:[self CGImage]];
}

// direct binding of: @property(nonatomic, readonly) NSTimeInterval duration;
- (double) duration__
{
    return [self duration];
}

// direct binding of: @property(nonatomic, readonly) UIImageOrientation imageOrientation;
- (int) imageOrientation__
{
    return [self imageOrientation];
}

// direct binding of: @property(nonatomic, readonly) NSArray<UIImage *> *images;
- (NSArray*) images__
{
    NSArray* re$ult = [self images];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIImageRenderingMode renderingMode;
- (int) renderingMode__
{
    return [self renderingMode];
}

// direct binding of: @property(nonatomic, readonly) CGFloat scale;
- (double) scale__
{
    return [self scale];
}

// direct binding of: @property(nonatomic, readonly) CGSize size;
- (crossmobile_ios_coregraphics_CGSize*) size__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self size]];
}

// direct binding of: NSData * UIImageJPEGRepresentation ( UIImage *image, CGFloat compressionQuality );
- (NSData*) JPEGRepresentation___double:(double) compressionQuality 
{
    NSData* re$ult = UIImageJPEGRepresentation(self, compressionQuality);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: NSData * UIImagePNGRepresentation ( UIImage *image );
- (NSData*) PNGRepresentation__
{
    NSData* re$ult = UIImagePNGRepresentation(self);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)drawAtPoint:(CGPoint)point;
- (void) drawAtPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point 
{
    [self drawAtPoint:[point getCGPoint]];
}

// direct binding of: - (void)drawInRect:(CGRect)rect;
- (void) drawInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [self drawInRect:[rect getCGRect]];
}

// direct binding of: - (UIImage *)imageWithRenderingMode:(UIImageRenderingMode)renderingMode;
- (UIImage*) imageWithRenderingMode___int:(int) renderingMode 
{
    UIImage* re$ult = [self imageWithRenderingMode:renderingMode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets 
{
    UIImage* re$ult = [self resizableImageWithCapInsets:[capInsets getUIEdgeInsets]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIImage *)resizableImageWithCapInsets:(UIEdgeInsets)capInsets resizingMode:(UIImageResizingMode)resizingMode;
- (UIImage*) resizableImageWithCapInsets___crossmobile_ios_uikit_UIEdgeInsets_int:(crossmobile_ios_uikit_UIEdgeInsets*) capInsets :(int) resizingMode 
{
    UIImage* re$ult = [self resizableImageWithCapInsets:[capInsets getUIEdgeInsets] resizingMode:resizingMode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIImage *)stretchableImageWithLeftCapWidth:(NSInteger)leftCapWidth topCapHeight:(NSInteger)topCapHeight;
- (UIImage*) stretchableImageWithLeftCapWidth___int_int:(int) leftCapWidth :(int) topCapHeight 
{
    UIImage* re$ult = [self stretchableImageWithLeftCapWidth:leftCapWidth topCapHeight:topCapHeight];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: void UIImageWriteToSavedPhotosAlbum ( UIImage *image, id completionTarget, SEL completionSelector, void *contextInfo );
- (void) writeToSavedPhotosAlbum___crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler_java_lang_Object:(id<crossmobile_ios_uikit_UIImageWriteToPhotoAlbumHandler>) completionTarget :(id) contextInfo 
{
    UIImageWriteToSavedPhotosAlbum(self, (completionTarget == JAVA_NULL ? nil : completionTarget), @selector(didFinishSavingWithError___crossmobile_ios_uikit_UIImage_crossmobile_ios_foundation_NSError_java_lang_Object:::), (contextInfo == JAVA_NULL ? nil : contextInfo));
}

@end
