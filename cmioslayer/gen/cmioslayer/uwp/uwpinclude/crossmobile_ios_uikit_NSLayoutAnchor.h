// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_NSLayoutAnchor definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_NSLayoutConstraint;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_NSLayoutAnchor$Ext : NSLayoutAnchor
@end

#define crossmobile_ios_uikit_NSLayoutAnchor NSLayoutAnchor
@interface NSLayoutAnchor (cm_crossmobile_ios_uikit_NSLayoutAnchor)
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor ;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c ;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor ;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c ;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor ;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c ;
@end
