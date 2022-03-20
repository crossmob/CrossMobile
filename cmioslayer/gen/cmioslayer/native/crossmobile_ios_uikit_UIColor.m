// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIColor implementation

#import "crossmobile_ios_coregraphics_CGColor.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIImage.h"

@implementation crossmobile_ios_uikit_UIColor$Ext

@end

@implementation UIColor (cm_crossmobile_ios_uikit_UIColor)

// + (UIColor *)blackColor;
+ (UIColor*) blackColor__
{
    UIColor* re$ult = [UIColor blackColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)blueColor;
+ (UIColor*) blueColor__
{
    UIColor* re$ult = [UIColor blueColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)brownColor;
+ (UIColor*) brownColor__
{
    UIColor* re$ult = [UIColor brownColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)clearColor;
+ (UIColor*) clearColor__
{
    UIColor* re$ult = [UIColor clearColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)colorWithCGColor:(CGColorRef)cgColor;
+ (UIColor*) colorWithCGColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) cgColor 
{
    UIColor* re$ult = [UIColor colorWithCGColor:cgColor->$reference];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)colorWithHue:(CGFloat)hue saturation:(CGFloat)saturation brightness:(CGFloat)brightness alpha:(CGFloat)alpha;
+ (UIColor*) colorWithHueSaturationBrightnessAlpha___double_double_double_double:(double) hue :(double) saturation :(double) brightness :(double) alpha 
{
    UIColor* re$ult = [UIColor colorWithHue:hue saturation:saturation brightness:brightness alpha:alpha];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)colorWithPatternImage:(UIImage *)image;
+ (UIColor*) colorWithPatternImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    UIColor* re$ult = [UIColor colorWithPatternImage:(image == JAVA_NULL ? nil : image)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)colorWithRed:(CGFloat)red green:(CGFloat)green blue:(CGFloat)blue alpha:(CGFloat)alpha;
+ (UIColor*) colorWithRedGreenBlueAlpha___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha 
{
    UIColor* re$ult = [UIColor colorWithRed:red green:green blue:blue alpha:alpha];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)colorWithWhite:(CGFloat)white alpha:(CGFloat)alpha;
+ (UIColor*) colorWithWhiteAlpha___double_double:(double) white :(double) alpha 
{
    UIColor* re$ult = [UIColor colorWithWhite:white alpha:alpha];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)cyanColor;
+ (UIColor*) cyanColor__
{
    UIColor* re$ult = [UIColor cyanColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)darkGrayColor;
+ (UIColor*) darkGrayColor__
{
    UIColor* re$ult = [UIColor darkGrayColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)darkTextColor;
+ (UIColor*) darkTextColor__
{
    UIColor* re$ult = [UIColor darkTextColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)grayColor;
+ (UIColor*) grayColor__
{
    UIColor* re$ult = [UIColor grayColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)greenColor;
+ (UIColor*) greenColor__
{
    UIColor* re$ult = [UIColor greenColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)groupTableViewBackgroundColor;
+ (UIColor*) groupTableViewBackgroundColor__
{
    UIColor* re$ult = [UIColor groupTableViewBackgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)lightGrayColor;
+ (UIColor*) lightGrayColor__
{
    UIColor* re$ult = [UIColor lightGrayColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)lightTextColor;
+ (UIColor*) lightTextColor__
{
    UIColor* re$ult = [UIColor lightTextColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)magentaColor;
+ (UIColor*) magentaColor__
{
    UIColor* re$ult = [UIColor magentaColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)orangeColor;
+ (UIColor*) orangeColor__
{
    UIColor* re$ult = [UIColor orangeColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)purpleColor;
+ (UIColor*) purpleColor__
{
    UIColor* re$ult = [UIColor purpleColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)redColor;
+ (UIColor*) redColor__
{
    UIColor* re$ult = [UIColor redColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)viewFlipsideBackgroundColor;
+ (UIColor*) viewFlipsideBackgroundColor__
{
    UIColor* re$ult = [UIColor viewFlipsideBackgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)whiteColor;
+ (UIColor*) whiteColor__
{
    UIColor* re$ult = [UIColor whiteColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIColor *)yellowColor;
+ (UIColor*) yellowColor__
{
    UIColor* re$ult = [UIColor yellowColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) CGColorRef CGColor;
- (crossmobile_ios_coregraphics_CGColor*) CGColor__
{
    return [[crossmobile_ios_coregraphics_CGColor alloc] initWithCGColor:[self CGColor]];
}

@end
