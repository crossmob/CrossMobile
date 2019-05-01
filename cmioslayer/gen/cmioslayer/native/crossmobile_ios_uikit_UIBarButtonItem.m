// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIBarButtonItem implementation

#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_Object.h"
#import "java_lang_Runnable.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIBarButtonItem$Ext

// (UIBarButtonItem) @property(nonatomic, strong) __kindof UIView *customView;
- (void) setCustomView___crossmobile_ios_uikit_UIView:(UIView*) customView 
{
    [super setCustomView:(customView == JAVA_NULL ? nil : customView)];
}

// (UIBarButtonItem) @property(nonatomic, strong) __kindof UIView *customView;
- (UIView*) customView__
{
    UIView* re$ult = [super customView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarItem) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIBarItem) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
}

// (UIBarItem) @property(nonatomic, strong) UIImage *image;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    [super setImage:(image == JAVA_NULL ? nil : image)];
}

// (UIBarItem) @property(nonatomic, strong) UIImage *image;
- (UIImage*) image__
{
    UIImage* re$ult = [super image];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarItem) @property(nonatomic) UIEdgeInsets imageInsets;
- (void) setImageInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageInsets 
{
    [super setImageInsets:[imageInsets getUIEdgeInsets]];
}

// (UIBarItem) @property(nonatomic) UIEdgeInsets imageInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super imageInsets]];
}

// (UIBarButtonItem) @property(nonatomic, copy) NSSet<NSString *> *possibleTitles;
- (void) setPossibleTitles___java_util_Set:(NSSet*) possibleTitles 
{
    [super setPossibleTitles:(possibleTitles == JAVA_NULL ? nil : possibleTitles)];
}

// (UIBarButtonItem) @property(nonatomic, copy) NSSet<NSString *> *possibleTitles;
- (NSSet*) possibleTitles__
{
    NSSet* re$ult = [super possibleTitles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarButtonItem) @property(nonatomic) UIBarButtonItemStyle style;
- (void) setStyle___int:(int) style 
{
    [super setStyle:style];
}

// (UIBarButtonItem) @property(nonatomic) UIBarButtonItemStyle style;
- (int) style__
{
    return [super style];
}

// (UIBarItem) @property(nonatomic) NSInteger tag;
- (void) setTag___int:(int) tag 
{
    [super setTag:tag];
}

// (UIBarItem) @property(nonatomic) NSInteger tag;
- (int) tag__
{
    return [super tag];
}

// (UIBarButtonItem) @property(nonatomic, weak) id target;
- (void) setTarget___java_lang_Runnable:(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(setTarget:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setTarget:(target == JAVA_NULL ? nil : target)];
}

// (UIBarButtonItem) @property(nonatomic, weak) id target;
- (id) target__
{
    id re$ult = [super target];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarItem) @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
}

// (UIBarItem) @property(nonatomic, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarButtonItem) @property(nonatomic) CGFloat width ;
- (void) setWidth___double:(double) width 
{
    [super setWidth:width];
}

// (UIBarButtonItem) @property(nonatomic) CGFloat width ;
- (double) width__
{
    return [super width];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIBarButtonItem (cm_crossmobile_ios_uikit_UIBarButtonItem)

// direct binding of: - (instancetype)initWithImage:(UIImage *)image style:(UIBarButtonItemStyle)style target:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___crossmobile_ios_uikit_UIImage_int_java_lang_Runnable:(UIImage*) image :(int) style :(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(initWithImage:style:target:action:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithImage:(image == JAVA_NULL ? nil : image) style:style target:(target == JAVA_NULL ? nil : target) action:@selector(run__)];
}

// direct binding of: - (instancetype)initWithCustomView:(UIView *)customView;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___crossmobile_ios_uikit_UIView:(UIView*) customView 
{
    return [self initWithCustomView:(customView == JAVA_NULL ? nil : customView)];
}

// direct binding of: - (instancetype)initWithBarButtonSystemItem:(UIBarButtonSystemItem)systemItem target:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___int_java_lang_Runnable:(int) systemItem :(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(initWithBarButtonSystemItem:target:action:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithBarButtonSystemItem:systemItem target:(target == JAVA_NULL ? nil : target) action:@selector(run__)];
}

// direct binding of: - (instancetype)initWithTitle:(NSString *)title style:(UIBarButtonItemStyle)style target:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___java_lang_String_int_java_lang_Runnable:(NSString*) title :(int) style :(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(initWithTitle:style:target:action:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTitle:(title == JAVA_NULL ? nil : title) style:style target:(target == JAVA_NULL ? nil : target) action:@selector(run__)];
}

// direct binding of: @property(nonatomic, strong) __kindof UIView *customView;
- (void) setCustomView___crossmobile_ios_uikit_UIView:(UIView*) customView 
{
    [self setCustomView:(customView == JAVA_NULL ? nil : customView)];
}

// direct binding of: @property(nonatomic, strong) __kindof UIView *customView;
- (UIView*) customView__
{
    UIView* re$ult = [self customView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSSet<NSString *> *possibleTitles;
- (void) setPossibleTitles___java_util_Set:(NSSet*) possibleTitles 
{
    [self setPossibleTitles:(possibleTitles == JAVA_NULL ? nil : possibleTitles)];
}

// direct binding of: @property(nonatomic, copy) NSSet<NSString *> *possibleTitles;
- (NSSet*) possibleTitles__
{
    NSSet* re$ult = [self possibleTitles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) UIBarButtonItemStyle style;
- (void) setStyle___int:(int) style 
{
    [self setStyle:style];
}

// direct binding of: @property(nonatomic) UIBarButtonItemStyle style;
- (int) style__
{
    return [self style];
}

// direct binding of: @property(nonatomic, weak) id target;
- (void) setTarget___java_lang_Runnable:(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(setTarget:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setTarget:(target == JAVA_NULL ? nil : target)];
}

// direct binding of: @property(nonatomic, weak) id target;
- (id) target__
{
    id re$ult = [self target];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) CGFloat width ;
- (void) setWidth___double:(double) width 
{
    [self setWidth:width];
}

// direct binding of: @property(nonatomic) CGFloat width ;
- (double) width__
{
    return [self width];
}

@end
