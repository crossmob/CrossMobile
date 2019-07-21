// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UILabelAppearance implementation

#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_ios_uikit_UILabelAppearance.h"

@implementation crossmobile_ios_uikit_UILabelAppearance

// direct binding of: @property(nonatomic, copy) UIColor *backgroundColor;
- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor 
{
    [self->$reference setBackgroundColor:(backgroundColor == JAVA_NULL ? nil : backgroundColor)];
}

// direct binding of: @property(nonatomic, strong) UIFont *font;
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font 
{
    [self->$reference setFont:(font == JAVA_NULL ? nil : font)];
}

// direct binding of: @property(nonatomic, strong) UIColor *textColor;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor 
{
    [self->$reference setTextColor:(textColor == JAVA_NULL ? nil : textColor)];
}

- (instancetype) initWithUILabelAppearance:(id) reference
{
    self = [super init];
    self->$reference = reference;
    if (self->$reference)
        [self->$reference retain];
    return self;
}

- (void) dealloc
{
    if (self->$reference)
        [self->$reference release];
    [super dealloc];
}

@end
