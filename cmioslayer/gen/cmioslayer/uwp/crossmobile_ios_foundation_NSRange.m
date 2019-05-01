// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSRange implementation

#import "crossmobile_ios_foundation_NSRange.h"

@implementation crossmobile_ios_foundation_NSRange

// direct binding of: NSRange NSMakeRange ( NSUInteger loc, NSUInteger len );
- (crossmobile_ios_foundation_NSRange*) __init_crossmobile_ios_foundation_NSRange___int_int:(int) loc :(int) len 
{
    return [self initWithNSRange:NSMakeRange(loc, len)];
}

// direct binding of: NSUInteger length;
- (void) setLength___int:(int) length 
{
    self->length_int = length;
}

// direct binding of: NSUInteger length;
- (int) getLength__
{
    return self->length_int;
}

// direct binding of: NSUInteger location;
- (void) setLocation___int:(int) location 
{
    self->location_int = location;
}

// direct binding of: NSUInteger location;
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
