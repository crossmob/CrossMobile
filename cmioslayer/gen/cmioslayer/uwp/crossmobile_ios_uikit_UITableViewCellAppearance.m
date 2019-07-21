// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UITableViewCellAppearance implementation

#import "crossmobile_ios_uikit_UITableViewCellAppearance.h"

@implementation crossmobile_ios_uikit_UITableViewCellAppearance

- (instancetype) initWithUITableViewCellAppearance:(id) reference
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
