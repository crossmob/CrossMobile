// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CATransition definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_quartzcore_CATransition$Ext : CATransition
@end

#define crossmobile_ios_quartzcore_CATransition CATransition
@interface CATransition (cm_crossmobile_ios_quartzcore_CATransition)
- (instancetype) __init_crossmobile_ios_quartzcore_CATransition__;
- (void) setEndProgress___float:(float) endProgress ;
- (float) endProgress__;
- (void) setStartProgress___float:(float) startProgress ;
- (float) startProgress__;
- (void) setSubtype___java_lang_String:(NSString*) subtype ;
- (NSString*) subtype__;
- (void) setType___java_lang_String:(NSString*) type ;
- (NSString*) type__;
@end
