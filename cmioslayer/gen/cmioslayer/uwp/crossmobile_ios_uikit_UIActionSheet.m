// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActionSheet implementation

#import "crossmobile_ios_uikit_UIActionSheet.h"
#import "crossmobile_ios_uikit_UIActionSheetDelegate.h"
#import "crossmobile_ios_uikit_UITabBar.h"
#import "crossmobile_ios_uikit_UIToolbar.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIActionSheet$Ext

@end

@implementation UIActionSheet (cm_crossmobile_ios_uikit_UIActionSheet)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIActionSheet appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIActionSheet appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithTitle:(NSString *)title delegate:(id<UIActionSheetDelegate>)delegate cancelButtonTitle:(NSString *)cancelButtonTitle destructiveButtonTitle:(NSString *)destructiveButtonTitle otherButtonTitles:(NSString *)otherButtonTitles, ...;
- (instancetype) __init_crossmobile_ios_uikit_UIActionSheet___java_lang_String_crossmobile_ios_uikit_UIActionSheetDelegate_java_lang_String_java_lang_String_java_lang_String_ARRAYTYPE:(NSString*) title :(id<UIActionSheetDelegate>) delegate :(NSString*) cancelButtonTitle :(NSString*) destructiveButtonTitle :(XMLVMArray*) otherButtonTitles 
{
    objc_setAssociatedObject(self, @selector(initWithTitle:delegate:cancelButtonTitle:destructiveButtonTitle:otherButtonTitles:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTitle:(title == JAVA_NULL ? nil : title) delegate:(delegate == JAVA_NULL ? nil : delegate) cancelButtonTitle:(cancelButtonTitle == JAVA_NULL ? nil : cancelButtonTitle) destructiveButtonTitle:(destructiveButtonTitle == JAVA_NULL ? nil : destructiveButtonTitle) otherButtonTitles:
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 0 ? otherButtonTitles->array.o[0] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 1 ? otherButtonTitles->array.o[1] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 2 ? otherButtonTitles->array.o[2] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 3 ? otherButtonTitles->array.o[3] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 4 ? otherButtonTitles->array.o[4] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 5 ? otherButtonTitles->array.o[5] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 6 ? otherButtonTitles->array.o[6] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 7 ? otherButtonTitles->array.o[7] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 8 ? otherButtonTitles->array.o[8] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 9 ? otherButtonTitles->array.o[9] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 10 ? otherButtonTitles->array.o[10] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 11 ? otherButtonTitles->array.o[11] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 12 ? otherButtonTitles->array.o[12] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 13 ? otherButtonTitles->array.o[13] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 14 ? otherButtonTitles->array.o[14] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 15 ? otherButtonTitles->array.o[15] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 16 ? otherButtonTitles->array.o[16] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 17 ? otherButtonTitles->array.o[17] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 18 ? otherButtonTitles->array.o[18] : nil),
        (otherButtonTitles != JAVA_NULL && otherButtonTitles->length > 19 ? otherButtonTitles->array.o[19] : nil),
        nil];
}

// @property(nonatomic) NSInteger cancelButtonIndex;
- (int) cancelButtonIndex__
{
    return [self cancelButtonIndex];
}

// @property(nonatomic, weak) id<UIActionSheetDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIActionSheetDelegate:(id<UIActionSheetDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UIActionSheetDelegate> delegate;
- (id<UIActionSheetDelegate>) delegate__
{
    id<UIActionSheetDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSInteger destructiveButtonIndex;
- (int) destructiveButtonIndex__
{
    return [self destructiveButtonIndex];
}

// @property(nonatomic, readonly) NSInteger firstOtherButtonIndex;
- (int) firstOtherButtonIndex__
{
    return [self firstOtherButtonIndex];
}

// @property(nonatomic, readonly) NSInteger numberOfButtons;
- (int) numberOfButtons__
{
    return [self numberOfButtons];
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

// - (NSInteger)addButtonWithTitle:(NSString *)title;
- (int) addButtonWithTitle___java_lang_String:(NSString*) title 
{
    return [self addButtonWithTitle:(title == JAVA_NULL ? nil : title)];
}

// - (void)dismissWithClickedButtonIndex:(NSInteger)buttonIndex animated:(BOOL)animated;
- (void) dismissWithClickedButtonIndex___int_boolean:(int) buttonIndex :(BOOL) animated 
{
    [self dismissWithClickedButtonIndex:buttonIndex animated:animated];
}

// - (void)showFromTabBar:(UITabBar *)view;
- (void) showFromTabBar___crossmobile_ios_uikit_UITabBar:(UITabBar*) view 
{
    [self showFromTabBar:(view == JAVA_NULL ? nil : view)];
}

// - (void)showFromToolbar:(UIToolbar *)view;
- (void) showFromToolbar___crossmobile_ios_uikit_UIToolbar:(UIToolbar*) view 
{
    [self showFromToolbar:(view == JAVA_NULL ? nil : view)];
}

// - (void)showInView:(UIView *)view;
- (void) showInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [self showInView:(view == JAVA_NULL ? nil : view)];
}

@end
