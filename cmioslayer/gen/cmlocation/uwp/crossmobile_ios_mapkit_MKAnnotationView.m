// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKAnnotationView implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_mapkit_MKAnnotation.h"
#import "crossmobile_ios_mapkit_MKAnnotationView.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_mapkit_MKAnnotationView$Ext

@end

@implementation MKAnnotationView (cm_crossmobile_ios_mapkit_MKAnnotationView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKAnnotationView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKAnnotationView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithAnnotation:(id<MKAnnotation>)annotation reuseIdentifier:(NSString *)reuseIdentifier;
- (instancetype) __init_crossmobile_ios_mapkit_MKAnnotationView___crossmobile_ios_mapkit_MKAnnotation_java_lang_String:(id<MKAnnotation>) annotation :(NSString*) reuseIdentifier 
{
    return [self initWithAnnotation:(annotation == JAVA_NULL ? nil : annotation) reuseIdentifier:(reuseIdentifier == JAVA_NULL ? nil : reuseIdentifier)];
}

// @property(nonatomic, strong) id<MKAnnotation> annotation;
- (void) setAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [self setAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// @property(nonatomic, strong) id<MKAnnotation> annotation;
- (id<MKAnnotation>) annotation__
{
    id<MKAnnotation> re$ult = [self annotation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGPoint calloutOffset;
- (void) setCalloutOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) calloutOffset 
{
    [self setCalloutOffset:[calloutOffset getCGPoint]];
}

// @property(nonatomic) CGPoint calloutOffset;
- (crossmobile_ios_coregraphics_CGPoint*) calloutOffset__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self calloutOffset]];
}

// @property(nonatomic) BOOL canShowCallout;
- (void) setCanShowCallout___boolean:(BOOL) canShowCallout 
{
    [self setCanShowCallout:canShowCallout];
}

// @property(nonatomic) BOOL canShowCallout;
- (BOOL) canShowCallout__
{
    return [self canShowCallout];
}

// @property(nonatomic) CGPoint centerOffset;
- (void) setCenterOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) centerOffset 
{
    [self setCenterOffset:[centerOffset getCGPoint]];
}

// @property(nonatomic) CGPoint centerOffset;
- (crossmobile_ios_coregraphics_CGPoint*) centerOffset__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self centerOffset]];
}

// @property(nonatomic) MKAnnotationViewDragState dragState;
- (void) setDragState___int:(int) dragState 
{
    [self setDragState:dragState];
}

// @property(nonatomic) MKAnnotationViewDragState dragState;
- (int) dragState__
{
    return [self dragState];
}

// @property(nonatomic, getter=isDraggable) BOOL draggable;
- (void) setDraggable___boolean:(BOOL) draggable 
{
    [self setDraggable:draggable];
}

// @property(nonatomic, getter=isDraggable) BOOL draggable;
- (BOOL) isDraggable__
{
    return [self isDraggable];
}

// @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [self setEnabled:enabled];
}

// @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [self isEnabled];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [self setHighlighted:highlighted];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [self isHighlighted];
}

// @property(nonatomic, strong) UIImage *image;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    [self setImage:(image == JAVA_NULL ? nil : image)];
}

// @property(nonatomic, strong) UIImage *image;
- (UIImage*) image__
{
    UIImage* re$ult = [self image];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(strong, nonatomic) UIView *leftCalloutAccessoryView;
- (void) setLeftCalloutAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) leftCalloutAccessoryView 
{
    [self setLeftCalloutAccessoryView:(leftCalloutAccessoryView == JAVA_NULL ? nil : leftCalloutAccessoryView)];
}

// @property(strong, nonatomic) UIView *leftCalloutAccessoryView;
- (UIView*) leftCalloutAccessoryView__
{
    UIView* re$ult = [self leftCalloutAccessoryView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSString *reuseIdentifier;
- (NSString*) reuseIdentifier__
{
    NSString* re$ult = [self reuseIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(strong, nonatomic) UIView *rightCalloutAccessoryView;
- (void) setRightCalloutAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) rightCalloutAccessoryView 
{
    [self setRightCalloutAccessoryView:(rightCalloutAccessoryView == JAVA_NULL ? nil : rightCalloutAccessoryView)];
}

// @property(strong, nonatomic) UIView *rightCalloutAccessoryView;
- (UIView*) rightCalloutAccessoryView__
{
    UIView* re$ult = [self rightCalloutAccessoryView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isSelected) BOOL selected;
- (void) setSelected___boolean:(BOOL) selected 
{
    [self setSelected:selected];
}

// @property(nonatomic, getter=isSelected) BOOL selected;
- (BOOL) isSelected__
{
    return [self isSelected];
}

// - (void)prepareForReuse;
- (void) prepareForReuse__
{
    [self prepareForReuse];
}

// - (void)setDragState:(MKAnnotationViewDragState)newDragState animated:(BOOL)animated;
- (void) setDragState___int_boolean:(int) newDragState :(BOOL) animated 
{
    [self setDragState:newDragState animated:animated];
}

// - (void)setSelected:(BOOL)selected animated:(BOOL)animated;
- (void) setSelected___boolean_boolean:(BOOL) selected :(BOOL) animated 
{
    [self setSelected:selected animated:animated];
}

@end
