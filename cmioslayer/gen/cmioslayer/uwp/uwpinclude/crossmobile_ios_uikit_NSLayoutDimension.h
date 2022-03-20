// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_NSLayoutDimension definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_NSLayoutConstraint;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_NSLayoutDimension$Ext : NSLayoutDimension
@end

#define crossmobile_ios_uikit_NSLayoutDimension NSLayoutDimension
@interface NSLayoutDimension (cm_crossmobile_ios_uikit_NSLayoutDimension)
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double:(NSLayoutDimension*) anchor :(double) m ;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double_double:(NSLayoutDimension*) anchor :(double) m :(double) c ;
- (NSLayoutConstraint*) constraintEqualToConstant___double:(double) c ;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double:(NSLayoutDimension*) anchor :(double) m ;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double_double:(NSLayoutDimension*) anchor :(double) m :(double) c ;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToConstant___double:(double) c ;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double:(NSLayoutDimension*) anchor :(double) m ;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutDimension_double_double:(NSLayoutDimension*) anchor :(double) m :(double) c ;
- (NSLayoutConstraint*) constraintLessThanOrEqualToConstant___double:(double) c ;
@end
