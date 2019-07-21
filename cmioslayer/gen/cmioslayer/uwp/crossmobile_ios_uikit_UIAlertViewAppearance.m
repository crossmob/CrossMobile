// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIAlertViewAppearance implementation

#import "crossmobile_ios_uikit_UIAlertViewAppearance.h"
#import "crossmobile_ios_uikit_UIColor.h"

@implementation crossmobile_ios_uikit_UIAlertViewAppearance

// direct binding of: @property(nonatomic, copy) UIColor *backgroundColor;
- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor 
{
    [self->$reference setBackgroundColor:(backgroundColor == JAVA_NULL ? nil : backgroundColor)];
}

- (instancetype) initWithUIAlertViewAppearance:(id) reference
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
