// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIColor implementation

#import "crossmobile_ios_coregraphics_CGColor.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UIColor$Ext

// (UIColor) @property(nonatomic, readonly) CGColorRef CGColor;
- (crossmobile_ios_coregraphics_CGColor*) CGColor__
{
    return [[crossmobile_ios_coregraphics_CGColor alloc] initWithCGColor:[super CGColor]];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIColor (cm_crossmobile_ios_uikit_UIColor)

// direct binding of: + (UIColor *)blackColor;
+ (UIColor*) blackColor__
{
    UIColor* re$ult = [UIColor blackColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)blueColor;
+ (UIColor*) blueColor__
{
    UIColor* re$ult = [UIColor blueColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)brownColor;
+ (UIColor*) brownColor__
{
    UIColor* re$ult = [UIColor brownColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)clearColor;
+ (UIColor*) clearColor__
{
    UIColor* re$ult = [UIColor clearColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)colorWithCGColor:(CGColorRef)cgColor;
+ (UIColor*) colorWithCGColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) cgColor 
{
    UIColor* re$ult = [UIColor colorWithCGColor:cgColor->$reference];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)colorWithHue:(CGFloat)hue saturation:(CGFloat)saturation brightness:(CGFloat)brightness alpha:(CGFloat)alpha;
+ (UIColor*) colorWithHueSaturationBrightnessAlpha___double_double_double_double:(double) hue :(double) saturation :(double) brightness :(double) alpha 
{
    UIColor* re$ult = [UIColor colorWithHue:hue saturation:saturation brightness:brightness alpha:alpha];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)colorWithPatternImage:(UIImage *)image;
+ (UIColor*) colorWithPatternImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    UIColor* re$ult = [UIColor colorWithPatternImage:(image == JAVA_NULL ? nil : image)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)colorWithRed:(CGFloat)red green:(CGFloat)green blue:(CGFloat)blue alpha:(CGFloat)alpha;
+ (UIColor*) colorWithRedGreenBlueAlpha___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha 
{
    UIColor* re$ult = [UIColor colorWithRed:red green:green blue:blue alpha:alpha];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)colorWithWhite:(CGFloat)white alpha:(CGFloat)alpha;
+ (UIColor*) colorWithWhiteAlpha___double_double:(double) white :(double) alpha 
{
    UIColor* re$ult = [UIColor colorWithWhite:white alpha:alpha];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)cyanColor;
+ (UIColor*) cyanColor__
{
    UIColor* re$ult = [UIColor cyanColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)darkGrayColor;
+ (UIColor*) darkGrayColor__
{
    UIColor* re$ult = [UIColor darkGrayColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)darkTextColor;
+ (UIColor*) darkTextColor__
{
    UIColor* re$ult = [UIColor darkTextColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)grayColor;
+ (UIColor*) grayColor__
{
    UIColor* re$ult = [UIColor grayColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)greenColor;
+ (UIColor*) greenColor__
{
    UIColor* re$ult = [UIColor greenColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)groupTableViewBackgroundColor;
+ (UIColor*) groupTableViewBackgroundColor__
{
    UIColor* re$ult = [UIColor groupTableViewBackgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)lightGrayColor;
+ (UIColor*) lightGrayColor__
{
    UIColor* re$ult = [UIColor lightGrayColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)lightTextColor;
+ (UIColor*) lightTextColor__
{
    UIColor* re$ult = [UIColor lightTextColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)magentaColor;
+ (UIColor*) magentaColor__
{
    UIColor* re$ult = [UIColor magentaColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)orangeColor;
+ (UIColor*) orangeColor__
{
    UIColor* re$ult = [UIColor orangeColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)purpleColor;
+ (UIColor*) purpleColor__
{
    UIColor* re$ult = [UIColor purpleColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)redColor;
+ (UIColor*) redColor__
{
    UIColor* re$ult = [UIColor redColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)viewFlipsideBackgroundColor;
+ (UIColor*) viewFlipsideBackgroundColor__
{
    UIColor* re$ult = [UIColor viewFlipsideBackgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)whiteColor;
+ (UIColor*) whiteColor__
{
    UIColor* re$ult = [UIColor whiteColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIColor *)yellowColor;
+ (UIColor*) yellowColor__
{
    UIColor* re$ult = [UIColor yellowColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) CGColorRef CGColor;
- (crossmobile_ios_coregraphics_CGColor*) CGColor__
{
    return [[crossmobile_ios_coregraphics_CGColor alloc] initWithCGColor:[self CGColor]];
}

@end
