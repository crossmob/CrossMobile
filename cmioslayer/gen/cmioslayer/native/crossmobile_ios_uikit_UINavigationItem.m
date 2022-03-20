// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINavigationItem implementation

#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UINavigationItem$Ext

@end

@implementation UINavigationItem (cm_crossmobile_ios_uikit_UINavigationItem)

// - (instancetype)initWithTitle:(NSString *)title;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationItem___java_lang_String:(NSString*) title 
{
    return [self initWithTitle:(title == JAVA_NULL ? nil : title)];
}

// @property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;
- (void) setBackBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) backBarButtonItem 
{
    [self setBackBarButtonItem:(backBarButtonItem == JAVA_NULL ? nil : backBarButtonItem)];
}

// @property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;
- (UIBarButtonItem*) backBarButtonItem__
{
    UIBarButtonItem* re$ult = [self backBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) BOOL hidesBackButton;
- (void) setHidesBackButton___boolean:(BOOL) hidesBackButton 
{
    [self setHidesBackButton:hidesBackButton];
}

// @property(nonatomic, assign) BOOL hidesBackButton;
- (BOOL) hidesBackButton__
{
    return [self hidesBackButton];
}

// @property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) leftBarButtonItem 
{
    [self setLeftBarButtonItem:(leftBarButtonItem == JAVA_NULL ? nil : leftBarButtonItem)];
}

// @property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;
- (UIBarButtonItem*) leftBarButtonItem__
{
    UIBarButtonItem* re$ult = [self leftBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *prompt;
- (void) setPrompt___java_lang_String:(NSString*) prompt 
{
    [self setPrompt:(prompt == JAVA_NULL ? nil : prompt)];
}

// @property(nonatomic, copy) NSString *prompt;
- (NSString*) prompt__
{
    NSString* re$ult = [self prompt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) rightBarButtonItem 
{
    [self setRightBarButtonItem:(rightBarButtonItem == JAVA_NULL ? nil : rightBarButtonItem)];
}

// @property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;
- (UIBarButtonItem*) rightBarButtonItem__
{
    UIBarButtonItem* re$ult = [self rightBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// @property(nonatomic, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIView *titleView;
- (void) setTitleView___crossmobile_ios_uikit_UIView:(UIView*) titleView 
{
    [self setTitleView:(titleView == JAVA_NULL ? nil : titleView)];
}

// @property(nonatomic, strong) UIView *titleView;
- (UIView*) titleView__
{
    UIView* re$ult = [self titleView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setHidesBackButton:(BOOL)hidesBackButton animated:(BOOL)animated;
- (void) setHidesBackButton___boolean_boolean:(BOOL) hidesBackButton :(BOOL) animated 
{
    [self setHidesBackButton:hidesBackButton animated:animated];
}

// - (void)setLeftBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated 
{
    [self setLeftBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated];
}

// - (void)setRightBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated 
{
    [self setRightBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated];
}

@end
