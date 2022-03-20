// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_NSLayoutConstraint definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

@interface crossmobile_ios_uikit_NSLayoutConstraint$Ext : NSLayoutConstraint
@end

#define crossmobile_ios_uikit_NSLayoutConstraint NSLayoutConstraint
@interface NSLayoutConstraint (cm_crossmobile_ios_uikit_NSLayoutConstraint)
+ (void) activateConstraints___java_util_List:(NSArray*) constraints ;
+ (instancetype) constraintWithItem___java_lang_Object_int_int_java_lang_Object_int_double_double:(id) view1 :(int) attr1 :(int) relation :(id) view2 :(int) attr2 :(double) multiplier :(double) c ;
+ (NSArray*) constraintsWithVisualFormat___java_lang_String_int_java_util_Map_java_util_Map:(NSString*) format :(int) opts :(NSDictionary*) metrics :(NSDictionary*) views ;
+ (void) deactivateConstraints___java_util_List:(NSArray*) constraints ;
- (void) setActive___boolean:(BOOL) active ;
- (BOOL) isActive__;
- (void) setConstant___double:(double) constant ;
- (double) constant__;
- (int) firstAttribute__;
- (id) firstItem__;
- (void) setIdentifier___java_lang_String:(NSString*) identifier ;
- (NSString*) identifier__;
- (double) multiplier__;
- (void) setPriority___float:(float) priority ;
- (float) priority__;
- (int) relation__;
- (int) secondAttribute__;
- (id) secondItem__;
- (void) setShouldBeArchived___boolean:(BOOL) shouldBeArchived ;
- (BOOL) shouldBeArchived__;
@end
