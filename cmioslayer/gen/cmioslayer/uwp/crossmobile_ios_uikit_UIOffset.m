// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIOffset implementation

#import "crossmobile_ios_uikit_UIOffset.h"

@implementation crossmobile_ios_uikit_UIOffset

// UIOffset UIOffsetMake(CGFloat horizontal, CGFloat vertical);
- (crossmobile_ios_uikit_UIOffset*) __init_crossmobile_ios_uikit_UIOffset___double_double:(double) horizontal :(double) vertical 
{
    return [self initWithUIOffset:UIOffsetMake(horizontal, vertical)];
}

// CGFloat horizontal;
- (void) setHorizontal___double:(double) horizontal 
{
    self->horizontal_double = horizontal;
}

// CGFloat horizontal;
- (double) getHorizontal__
{
    return self->horizontal_double;
}

// CGFloat vertical;
- (void) setVertical___double:(double) vertical 
{
    self->vertical_double = vertical;
}

// CGFloat vertical;
- (double) getVertical__
{
    return self->vertical_double;
}

- (instancetype) initWithUIOffset:(UIOffset) other
{
    self = [super init];
    self->horizontal_double = other.horizontal;
    self->vertical_double = other.vertical;
    return self;
}

- (void) setUIOffset:(UIOffset) other
{
    self->horizontal_double = other.horizontal;
    self->vertical_double = other.vertical;
}

- (UIOffset) getUIOffset
{
    UIOffset result;
    result.horizontal = self->horizontal_double;
    result.vertical = self->vertical_double;
    return result;
}

@end
