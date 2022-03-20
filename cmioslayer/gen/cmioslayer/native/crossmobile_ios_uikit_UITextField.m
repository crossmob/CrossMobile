// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITextField implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_ios_uikit_UITextField.h"
#import "crossmobile_ios_uikit_UITextFieldDelegate.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UITextField$Ext

@end

@implementation UITextField (cm_crossmobile_ios_uikit_UITextField)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITextField appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITextField appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UITextField__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UITextField___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) BOOL adjustsFontSizeToFitWidth;
- (void) setAdjustsFontSizeToFitWidth___boolean:(BOOL) adjustsFontSizeToFitWidth 
{
    [self setAdjustsFontSizeToFitWidth:adjustsFontSizeToFitWidth];
}

// @property(nonatomic) BOOL adjustsFontSizeToFitWidth;
- (BOOL) adjustsFontSizeToFitWidth__
{
    return [self adjustsFontSizeToFitWidth];
}

// @property(nonatomic) UITextAutocapitalizationType autocapitalizationType;
- (void) setAutocapitalizationType___int:(int) autocapitalizationType 
{
    [self setAutocapitalizationType:autocapitalizationType];
}

// @property(nonatomic) UITextAutocapitalizationType autocapitalizationType;
- (int) autocapitalizationType__
{
    return [self autocapitalizationType];
}

// @property(nonatomic) UITextAutocorrectionType autocorrectionType;
- (void) setAutocorrectionType___int:(int) autocorrectionType 
{
    [self setAutocorrectionType:autocorrectionType];
}

// @property(nonatomic) UITextAutocorrectionType autocorrectionType;
- (int) autocorrectionType__
{
    return [self autocorrectionType];
}

// @property(nonatomic) UITextBorderStyle borderStyle;
- (void) setBorderStyle___int:(int) borderStyle 
{
    [self setBorderStyle:borderStyle];
}

// @property(nonatomic) UITextBorderStyle borderStyle;
- (int) borderStyle__
{
    return [self borderStyle];
}

// @property(nonatomic, weak) id<UITextFieldDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UITextFieldDelegate:(id<UITextFieldDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UITextFieldDelegate> delegate;
- (id<UITextFieldDelegate>) delegate__
{
    id<UITextFieldDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL enablesReturnKeyAutomatically;
- (void) setEnablesReturnKeyAutomatically___boolean:(BOOL) enablesReturnKeyAutomatically 
{
    [self setEnablesReturnKeyAutomatically:enablesReturnKeyAutomatically];
}

// @property(nonatomic) BOOL enablesReturnKeyAutomatically;
- (BOOL) enablesReturnKeyAutomatically__
{
    return [self enablesReturnKeyAutomatically];
}

// @property(nonatomic, strong) UIFont *font;
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font 
{
    [self setFont:(font == JAVA_NULL ? nil : font)];
}

// @property(nonatomic, strong) UIFont *font;
- (UIFont*) font__
{
    UIFont* re$ult = [self font];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIKeyboardAppearance keyboardAppearance;
- (void) setKeyboardAppearance___int:(int) keyboardAppearance 
{
    [self setKeyboardAppearance:keyboardAppearance];
}

// @property(nonatomic) UIKeyboardAppearance keyboardAppearance;
- (int) keyboardAppearance__
{
    return [self keyboardAppearance];
}

// @property(nonatomic) UIKeyboardType keyboardType;
- (void) setKeyboardType___int:(int) keyboardType 
{
    [self setKeyboardType:keyboardType];
}

// @property(nonatomic) UIKeyboardType keyboardType;
- (int) keyboardType__
{
    return [self keyboardType];
}

// @property(nonatomic, copy) NSString *placeholder;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder 
{
    [self setPlaceholder:(placeholder == JAVA_NULL ? nil : placeholder)];
}

// @property(nonatomic, copy) NSString *placeholder;
- (NSString*) placeholder__
{
    NSString* re$ult = [self placeholder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIReturnKeyType returnKeyType;
- (void) setReturnKeyType___int:(int) returnKeyType 
{
    [self setReturnKeyType:returnKeyType];
}

// @property(nonatomic) UIReturnKeyType returnKeyType;
- (int) returnKeyType__
{
    return [self returnKeyType];
}

// @property(nonatomic,getter=isSecureTextEntry) BOOL secureTextEntry;
- (void) setSecureTextEntry___boolean:(BOOL) secureTextEntry 
{
    [self setSecureTextEntry:secureTextEntry];
}

// @property(nonatomic,getter=isSecureTextEntry) BOOL secureTextEntry;
- (BOOL) isSecureTextEntry__
{
    return [self isSecureTextEntry];
}

// @property(nonatomic, copy) NSString *text;
- (void) setText___java_lang_String:(NSString*) text 
{
    [self setText:(text == JAVA_NULL ? nil : text)];
}

// @property(nonatomic, copy) NSString *text;
- (NSString*) text__
{
    NSString* re$ult = [self text];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSTextAlignment textAlignment;
- (void) setTextAlignment___int:(int) textAlignment 
{
    [self setTextAlignment:textAlignment];
}

// @property(nonatomic) NSTextAlignment textAlignment;
- (int) textAlignment__
{
    return [self textAlignment];
}

// @property(nonatomic, strong) UIColor *textColor;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor 
{
    [self setTextColor:(textColor == JAVA_NULL ? nil : textColor)];
}

// @property(nonatomic, strong) UIColor *textColor;
- (UIColor*) textColor__
{
    UIColor* re$ult = [self textColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic,copy) UITextContentType textContentType;
- (void) setTextContentType___java_lang_String:(NSString*) textContentType 
{
    [self setTextContentType:(textContentType == JAVA_NULL ? nil : textContentType)];
}

// @property(nonatomic,copy) UITextContentType textContentType;
- (NSString*) textContentType__
{
    NSString* re$ult = [self textContentType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
