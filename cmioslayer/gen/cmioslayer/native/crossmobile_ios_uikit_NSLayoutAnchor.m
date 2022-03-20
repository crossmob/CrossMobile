// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_NSLayoutAnchor implementation

#import "crossmobile_ios_uikit_NSLayoutAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"

@implementation crossmobile_ios_uikit_NSLayoutAnchor$Ext

@end

@implementation NSLayoutAnchor (cm_crossmobile_ios_uikit_NSLayoutAnchor)

// - (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutAnchor *)anchor;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor 
{
    NSLayoutConstraint* re$ult = [self constraintEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutAnchor *)anchor constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutAnchor *)anchor;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor 
{
    NSLayoutConstraint* re$ult = [self constraintGreaterThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutAnchor *)anchor constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintGreaterThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutAnchor *)anchor;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor 
{
    NSLayoutConstraint* re$ult = [self constraintLessThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutAnchor *)anchor constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c 
{
    NSLayoutConstraint* re$ult = [self constraintLessThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
