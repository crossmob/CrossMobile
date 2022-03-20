// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSRange implementation

#import "crossmobile_ios_foundation_NSRange.h"

@implementation crossmobile_ios_foundation_NSRange

// NSRange NSMakeRange ( NSUInteger loc, NSUInteger len );
- (crossmobile_ios_foundation_NSRange*) __init_crossmobile_ios_foundation_NSRange___int_int:(int) loc :(int) len 
{
    return [self initWithNSRange:NSMakeRange(loc, len)];
}

// NSUInteger length;
- (void) setLength___int:(int) length 
{
    self->length_int = length;
}

// NSUInteger length;
- (int) getLength__
{
    return self->length_int;
}

// NSUInteger location;
- (void) setLocation___int:(int) location 
{
    self->location_int = location;
}

// NSUInteger location;
- (int) getLocation__
{
    return self->location_int;
}

- (instancetype) initWithNSRange:(NSRange) other
{
    self = [super init];
    self->location_int = other.location;
    self->length_int = other.length;
    return self;
}

- (void) setNSRange:(NSRange) other
{
    self->location_int = other.location;
    self->length_int = other.length;
}

- (NSRange) getNSRange
{
    NSRange result;
    result.location = self->location_int;
    result.length = self->length_int;
    return result;
}

@end
