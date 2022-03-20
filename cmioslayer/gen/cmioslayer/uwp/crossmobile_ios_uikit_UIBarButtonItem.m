// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIBarButtonItem implementation

#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_Runnable.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIBarButtonItem$Ext

@end

@implementation UIBarButtonItem (cm_crossmobile_ios_uikit_UIBarButtonItem)

// - (instancetype)initWithImage:(UIImage *)image style:(UIBarButtonItemStyle)style target:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___crossmobile_ios_uikit_UIImage_int_java_lang_Runnable:(UIImage*) image :(int) style :(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(initWithImage:style:target:action:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithImage:(image == JAVA_NULL ? nil : image) style:style target:(target == JAVA_NULL ? nil : target) action:@selector(run__)];
}

// - (instancetype)initWithCustomView:(UIView *)customView;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___crossmobile_ios_uikit_UIView:(UIView*) customView 
{
    return [self initWithCustomView:(customView == JAVA_NULL ? nil : customView)];
}

// - (instancetype)initWithBarButtonSystemItem:(UIBarButtonSystemItem)systemItem target:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___int_java_lang_Runnable:(int) systemItem :(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(initWithBarButtonSystemItem:target:action:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithBarButtonSystemItem:systemItem target:(target == JAVA_NULL ? nil : target) action:@selector(run__)];
}

// - (instancetype)initWithTitle:(NSString *)title style:(UIBarButtonItemStyle)style target:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___java_lang_String_int_java_lang_Runnable:(NSString*) title :(int) style :(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(initWithTitle:style:target:action:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTitle:(title == JAVA_NULL ? nil : title) style:style target:(target == JAVA_NULL ? nil : target) action:@selector(run__)];
}

// @property(nonatomic, strong) __kindof UIView *customView;
- (void) setCustomView___crossmobile_ios_uikit_UIView:(UIView*) customView 
{
    [self setCustomView:(customView == JAVA_NULL ? nil : customView)];
}

// @property(nonatomic, strong) __kindof UIView *customView;
- (UIView*) customView__
{
    UIView* re$ult = [self customView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSSet<NSString *> *possibleTitles;
- (void) setPossibleTitles___java_util_Set:(NSSet*) possibleTitles 
{
    [self setPossibleTitles:(possibleTitles == JAVA_NULL ? nil : possibleTitles)];
}

// @property(nonatomic, copy) NSSet<NSString *> *possibleTitles;
- (NSSet*) possibleTitles__
{
    NSSet* re$ult = [self possibleTitles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIBarButtonItemStyle style;
- (void) setStyle___int:(int) style 
{
    [self setStyle:style];
}

// @property(nonatomic) UIBarButtonItemStyle style;
- (int) style__
{
    return [self style];
}

// @property(nonatomic, weak) id target;
- (void) setTarget___java_lang_Runnable:(id<java_lang_Runnable>) target 
{
    objc_setAssociatedObject(self, @selector(setTarget:), target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setTarget:(target == JAVA_NULL ? nil : target)];
}

// @property(nonatomic, weak) id target;
- (id) target__
{
    id re$ult = [self target];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGFloat width ;
- (void) setWidth___double:(double) width 
{
    [self setWidth:width];
}

// @property(nonatomic) CGFloat width ;
- (double) width__
{
    return [self width];
}

@end
