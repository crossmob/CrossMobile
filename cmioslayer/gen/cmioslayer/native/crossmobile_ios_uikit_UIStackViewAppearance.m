// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIStackViewAppearance implementation

#import "crossmobile_ios_uikit_UIStackViewAppearance.h"

@implementation crossmobile_ios_uikit_UIStackViewAppearance

- (instancetype) initWithUIStackViewAppearance:(id) reference
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
