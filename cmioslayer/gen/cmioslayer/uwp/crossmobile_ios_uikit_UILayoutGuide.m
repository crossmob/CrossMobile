// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILayoutGuide implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"
#import "crossmobile_ios_uikit_NSLayoutXAxisAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "crossmobile_ios_uikit_UILayoutGuide.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UILayoutGuide$Ext

@end

@implementation UILayoutGuide (cm_crossmobile_ios_uikit_UILayoutGuide)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UILayoutGuide__
{
    return [self init];
}

// @property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;
- (NSLayoutYAxisAnchor*) bottomAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [self bottomAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *centerXAnchor;
- (NSLayoutXAxisAnchor*) centerXAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self centerXAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutYAxisAnchor *centerYAnchor;
- (NSLayoutYAxisAnchor*) centerYAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [self centerYAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutDimension *heightAnchor;
- (NSLayoutDimension*) heightAnchor__
{
    NSLayoutDimension* re$ult = [self heightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [self setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// @property(nonatomic, copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) CGRect layoutFrame;
- (crossmobile_ios_coregraphics_CGRect*) layoutFrame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self layoutFrame]];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *leadingAnchor;
- (NSLayoutXAxisAnchor*) leadingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self leadingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *leftAnchor;
- (NSLayoutXAxisAnchor*) leftAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self leftAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) UIView *owningView;
- (void) setOwningView___crossmobile_ios_uikit_UIView:(UIView*) owningView 
{
    [self setOwningView:(owningView == JAVA_NULL ? nil : owningView)];
}

// @property(nonatomic, weak) UIView *owningView;
- (UIView*) owningView__
{
    UIView* re$ult = [self owningView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;
- (NSLayoutXAxisAnchor*) rightAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self rightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;
- (NSLayoutYAxisAnchor*) topAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [self topAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutXAxisAnchor *trailingAnchor;
- (NSLayoutXAxisAnchor*) trailingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [self trailingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, strong) NSLayoutDimension *widthAnchor;
- (NSLayoutDimension*) widthAnchor__
{
    NSLayoutDimension* re$ult = [self widthAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
