// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITextView implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_ios_uikit_UITextView.h"
#import "crossmobile_ios_uikit_UITextViewDelegate.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UITextView$Ext

@end

@implementation UITextView (cm_crossmobile_ios_uikit_UITextView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITextView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITextView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UITextView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UITextView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
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

// @property(nonatomic) UIDataDetectorTypes dataDetectorTypes;
- (void) setDataDetectorTypes___long:(JAVA_LONG) dataDetectorTypes 
{
    [self setDataDetectorTypes:dataDetectorTypes];
}

// @property(nonatomic) UIDataDetectorTypes dataDetectorTypes;
- (JAVA_LONG) dataDetectorTypes__
{
    return [self dataDetectorTypes];
}

// @property(nonatomic, weak) id<UITextViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UITextViewDelegate:(id<UITextViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UITextViewDelegate> delegate;
- (id<UITextViewDelegate>) delegate__
{
    id<UITextViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isEditable) BOOL editable;
- (void) setEditable___boolean:(BOOL) editable 
{
    [self setEditable:editable];
}

// @property(nonatomic, getter=isEditable) BOOL editable;
- (BOOL) isEditable__
{
    return [self isEditable];
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

// @property(nonatomic, getter=isSecureTextEntry) BOOL secureTextEntry;
- (void) setSecureTextEntry___boolean:(BOOL) secureTextEntry 
{
    [self setSecureTextEntry:secureTextEntry];
}

// @property(nonatomic, getter=isSecureTextEntry) BOOL secureTextEntry;
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

// @property(nonatomic, assign) UIEdgeInsets textContainerInset;
- (void) setTextContainerInset___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) textContainerInset 
{
    [self setTextContainerInset:[textContainerInset getUIEdgeInsets]];
}

// @property(nonatomic, assign) UIEdgeInsets textContainerInset;
- (crossmobile_ios_uikit_UIEdgeInsets*) textContainerInset__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self textContainerInset]];
}

@end
