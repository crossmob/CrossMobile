// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_NSLayoutConstraint implementation

#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_NSLayoutConstraint$Ext

@end

@implementation NSLayoutConstraint (cm_crossmobile_ios_uikit_NSLayoutConstraint)

// + (void)activateConstraints:(NSArray<NSLayoutConstraint *> *)constraints;
+ (void) activateConstraints___java_util_List:(NSArray*) constraints 
{
    [NSLayoutConstraint activateConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// + (instancetype)constraintWithItem:(id)view1 attribute:(NSLayoutAttribute)attr1 relatedBy:(NSLayoutRelation)relation toItem:(id)view2 attribute:(NSLayoutAttribute)attr2 multiplier:(CGFloat)multiplier constant:(CGFloat)c;
+ (instancetype) constraintWithItem___java_lang_Object_int_int_java_lang_Object_int_double_double:(id) view1 :(int) attr1 :(int) relation :(id) view2 :(int) attr2 :(double) multiplier :(double) c 
{
    id re$ult = [NSLayoutConstraint constraintWithItem:(view1 == JAVA_NULL ? nil : view1) attribute:attr1 relatedBy:relation toItem:(view2 == JAVA_NULL ? nil : view2) attribute:attr2 multiplier:multiplier constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSArray<__kindof NSLayoutConstraint *> *)constraintsWithVisualFormat:(NSString *)format options:(NSLayoutFormatOptions)opts metrics:(NSDictionary<NSString *,id> *)metrics views:(NSDictionary<NSString *,id> *)views;
+ (NSArray*) constraintsWithVisualFormat___java_lang_String_int_java_util_Map_java_util_Map:(NSString*) format :(int) opts :(NSDictionary*) metrics :(NSDictionary*) views 
{
    NSArray* re$ult = [NSLayoutConstraint constraintsWithVisualFormat:(format == JAVA_NULL ? nil : format) options:opts metrics:(metrics == JAVA_NULL ? nil : metrics) views:(views == JAVA_NULL ? nil : views)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (void)deactivateConstraints:(NSArray<NSLayoutConstraint *> *)constraints;
+ (void) deactivateConstraints___java_util_List:(NSArray*) constraints 
{
    [NSLayoutConstraint deactivateConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// @property(getter=isActive) BOOL active;
- (void) setActive___boolean:(BOOL) active 
{
    [self setActive:active];
}

// @property(getter=isActive) BOOL active;
- (BOOL) isActive__
{
    return [self isActive];
}

// @property CGFloat constant;
- (void) setConstant___double:(double) constant 
{
    [self setConstant:constant];
}

// @property CGFloat constant;
- (double) constant__
{
    return [self constant];
}

// @property(readonly) NSLayoutAttribute firstAttribute;
- (int) firstAttribute__
{
    return [self firstAttribute];
}

// @property(readonly, assign) id firstItem;
- (id) firstItem__
{
    id re$ult = [self firstItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [self setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// @property(copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) CGFloat multiplier;
- (double) multiplier__
{
    return [self multiplier];
}

// @property UILayoutPriority priority;
- (void) setPriority___float:(float) priority 
{
    [self setPriority:priority];
}

// @property UILayoutPriority priority;
- (float) priority__
{
    return [self priority];
}

// @property(readonly) NSLayoutRelation relation;
- (int) relation__
{
    return [self relation];
}

// @property(readonly) NSLayoutAttribute secondAttribute;
- (int) secondAttribute__
{
    return [self secondAttribute];
}

// @property(readonly, assign) id secondItem;
- (id) secondItem__
{
    id re$ult = [self secondItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property BOOL shouldBeArchived;
- (void) setShouldBeArchived___boolean:(BOOL) shouldBeArchived 
{
    [self setShouldBeArchived:shouldBeArchived];
}

// @property BOOL shouldBeArchived;
- (BOOL) shouldBeArchived__
{
    return [self shouldBeArchived];
}

@end
