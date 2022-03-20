// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_NSLayoutDimension implementation

#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"

@implementation crossmobile_ios_uikit_NSLayoutDimension$Ext

@end

@implementation NSLayoutDimension (cm_crossmobile_ios_uikit_NSLayoutDimension)

// - (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutDimension *)anchor multiplier:(CGFloat)m;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double:(NSLayoutDimension*) anchor :(double) m 
{
    NSLayoutConstraint* re$ult = [self constraintEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) multiplier:m];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutDimension *)anchor multiplier:(CGFloat)m constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double_double:(NSLayoutDimension*) anchor :(double) m :(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) multiplier:m constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintEqualToConstant:(CGFloat)c;
- (NSLayoutConstraint*) constraintEqualToConstant___double:(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintEqualToConstant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutDimension *)anchor multiplier:(CGFloat)m;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double:(NSLayoutDimension*) anchor :(double) m 
{
    NSLayoutConstraint* re$ult = [self constraintGreaterThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) multiplier:m];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutDimension *)anchor multiplier:(CGFloat)m constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double_double:(NSLayoutDimension*) anchor :(double) m :(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintGreaterThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) multiplier:m constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintGreaterThanOrEqualToConstant:(CGFloat)c;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToConstant___double:(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintGreaterThanOrEqualToConstant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutDimension *)anchor multiplier:(CGFloat)m;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double:(NSLayoutDimension*) anchor :(double) m 
{
    NSLayoutConstraint* re$ult = [self constraintLessThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) multiplier:m];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutDimension *)anchor multiplier:(CGFloat)m constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double_double:(NSLayoutDimension*) anchor :(double) m :(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintLessThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) multiplier:m constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintLessThanOrEqualToConstant:(CGFloat)c;
- (NSLayoutConstraint*) constraintLessThanOrEqualToConstant___double:(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintLessThanOrEqualToConstant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
