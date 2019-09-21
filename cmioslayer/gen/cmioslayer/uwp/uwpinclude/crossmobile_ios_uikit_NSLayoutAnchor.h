// (c) 2019 under LGPL by CrossMobile plugin tools

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
