// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKPinAnnotationView implementation

#import "crossmobile_ios_mapkit_MKAnnotation.h"
#import "crossmobile_ios_mapkit_MKPinAnnotationView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_mapkit_MKPinAnnotationView$Ext

@end

@implementation MKPinAnnotationView (cm_crossmobile_ios_mapkit_MKPinAnnotationView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKPinAnnotationView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKPinAnnotationView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithAnnotation:(id<MKAnnotation>)annotation reuseIdentifier:(NSString *)reuseIdentifier;
- (instancetype) __init_crossmobile_ios_mapkit_MKPinAnnotationView___crossmobile_ios_mapkit_MKAnnotation_java_lang_String:(id<MKAnnotation>) annotation :(NSString*) reuseIdentifier 
{
    return [self initWithAnnotation:(annotation == JAVA_NULL ? nil : annotation) reuseIdentifier:(reuseIdentifier == JAVA_NULL ? nil : reuseIdentifier)];
}

// @property(nonatomic) BOOL animatesDrop;
- (void) setAnimatesDrop___boolean:(BOOL) animatesDrop 
{
    [self setAnimatesDrop:animatesDrop];
}

// @property(nonatomic) BOOL animatesDrop;
- (BOOL) animatesDrop__
{
    return [self animatesDrop];
}

// @property(nonatomic) MKPinAnnotationColor pinColor;
- (void) setPinColor___int:(int) pinColor 
{
    [self setPinColor:pinColor];
}

// @property(nonatomic) MKPinAnnotationColor pinColor;
- (int) pinColor__
{
    return [self pinColor];
}

@end
