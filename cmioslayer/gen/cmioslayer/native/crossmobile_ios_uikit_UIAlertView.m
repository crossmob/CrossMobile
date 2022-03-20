// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAlertView implementation

#import "crossmobile_ios_uikit_UIAlertView.h"
#import "crossmobile_ios_uikit_UIAlertViewDelegate.h"
#import "crossmobile_ios_uikit_UITextField.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIAlertView$Ext

@end

@implementation UIAlertView (cm_crossmobile_ios_uikit_UIAlertView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIAlertView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIAlertView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithTitle:(NSString *)title message:(NSString *)message delegate:(id)delegate cancelButtonTitle:(NSString *)cancelButtonTitle otherButtonTitles:(NSString *)otherButtonTitles, ...;
- (instancetype) __init_crossmobile_ios_uikit_UIAlertView___java_lang_String_java_lang_String_crossmobile_ios_uikit_UIAlertViewDelegate_java_lang_String_java_lang_String_ARRAYTYPE:(NSString*) title :(NSString*) message :(id<UIAlertViewDelegate>) delegate :(NSString*) cancelButtonTitle :(XMLVMArray*) otherButtonTitles 
{
    objc_setAssociatedObject(self, @selector(initWithTitle:message:delegate:cancelButtonTitle:otherButtonTitles:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTitle:(title == JAVA_NULL ? nil : title) message:(message == JAVA_NULL ? nil : message) delegate:(delegate == JAVA_NULL ? nil : delegate) cancelButtonTitle:(cancelButtonTitle == JAVA_NULL ? nil : cancelButtonTitle) otherButtonTitles:
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

// @property(nonatomic, assign) UIAlertViewStyle alertViewStyle;
- (void) setAlertViewStyle___int:(int) alertViewStyle 
{
    [self setAlertViewStyle:alertViewStyle];
}

// @property(nonatomic, assign) UIAlertViewStyle alertViewStyle;
- (int) alertViewStyle__
{
    return [self alertViewStyle];
}

// @property(nonatomic, weak) id delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIAlertViewDelegate:(id<UIAlertViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id delegate;
- (id) delegate__
{
    id re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *message;
- (void) setMessage___java_lang_String:(NSString*) message 
{
    [self setMessage:(message == JAVA_NULL ? nil : message)];
}

// @property(nonatomic, copy) NSString *message;
- (NSString*) message__
{
    NSString* re$ult = [self message];
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

// - (NSInteger)addButtonWithTitle:(NSString *)title;
- (int) addButtonWithTitle___java_lang_String:(NSString*) title 
{
    return [self addButtonWithTitle:(title == JAVA_NULL ? nil : title)];
}

// - (void)show;
- (void) show__
{
    [self show];
}

// - (UITextField *)textFieldAtIndex:(NSInteger)textFieldIndex;
- (UITextField*) textFieldAtIndex___int:(int) textFieldIndex 
{
    UITextField* re$ult = [self textFieldAtIndex:textFieldIndex];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
