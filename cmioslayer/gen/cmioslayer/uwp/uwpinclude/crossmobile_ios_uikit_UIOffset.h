// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIOffset definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIOffset : java_lang_Object {
@public double horizontal_double;
@public double vertical_double;
}

- (crossmobile_ios_uikit_UIOffset*) __init_crossmobile_ios_uikit_UIOffset___double_double:(double) horizontal :(double) vertical ;
- (void) setHorizontal___double:(double) horizontal ;
- (double) getHorizontal__;
- (void) setVertical___double:(double) vertical ;
- (double) getVertical__;
- (instancetype) initWithUIOffset:(UIOffset) reference;
- (void) setUIOffset:(UIOffset) other;
- (UIOffset) getUIOffset;
@end
