// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_CFType implementation

#import "crossmobile_ios_foundation_CFType.h"

@implementation crossmobile_ios_foundation_CFType

- (instancetype) initWithCFType:(CFTypeRef) reference
{
    self = [super init];
    self->$reference = reference;
    if (self->$reference)
        CFRetain(self->$reference);
    return self;
}

- (void) dealloc
{
    if (self->$reference)
        CFRelease(self->$reference);
    [super dealloc];
}

@end
