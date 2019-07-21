// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UINavigationBarAppearance implementation

#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UINavigationBarAppearance.h"

@implementation crossmobile_ios_uikit_UINavigationBarAppearance

// direct binding of: @property(nonatomic, copy) UIColor *backgroundColor;
- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor 
{
    [self->$reference setBackgroundColor:(backgroundColor == JAVA_NULL ? nil : backgroundColor)];
}

- (instancetype) initWithUINavigationBarAppearance:(id) reference
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
