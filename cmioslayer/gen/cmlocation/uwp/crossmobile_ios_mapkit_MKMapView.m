// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapView implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_mapkit_MKAnnotation.h"
#import "crossmobile_ios_mapkit_MKAnnotationView.h"
#import "crossmobile_ios_mapkit_MKCoordinateRegion.h"
#import "crossmobile_ios_mapkit_MKMapRect.h"
#import "crossmobile_ios_mapkit_MKMapView.h"
#import "crossmobile_ios_mapkit_MKMapViewDelegate.h"
#import "crossmobile_ios_mapkit_MKOverlay.h"
#import "crossmobile_ios_mapkit_MKOverlayView.h"
#import "crossmobile_ios_mapkit_MKUserLocation.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_mapkit_MKMapView$Ext

@end

@implementation MKMapView (cm_crossmobile_ios_mapkit_MKMapView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKMapView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKMapView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_mapkit_MKMapView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_mapkit_MKMapView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, readonly) CGRect annotationVisibleRect;
- (crossmobile_ios_coregraphics_CGRect*) annotationVisibleRect__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self annotationVisibleRect]];
}

// @property(nonatomic, readonly) NSArray<id<MKAnnotation>> *annotations;
- (NSArray*) annotations__
{
    NSArray* re$ult = [self annotations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CLLocationCoordinate2D centerCoordinate;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate 
{
    [self setCenterCoordinate:[centerCoordinate getCLLocationCoordinate2D]];
}

// @property(nonatomic) CLLocationCoordinate2D centerCoordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self centerCoordinate]];
}

// @property(nonatomic, weak) id<MKMapViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_mapkit_MKMapViewDelegate:(id<MKMapViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<MKMapViewDelegate> delegate;
- (id<MKMapViewDelegate>) delegate__
{
    id<MKMapViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) MKMapType mapType;
- (void) setMapType___int:(int) mapType 
{
    [self setMapType:mapType];
}

// @property(nonatomic) MKMapType mapType;
- (int) mapType__
{
    return [self mapType];
}

// @property(nonatomic, readonly) NSArray<id<MKOverlay>> *overlays;
- (NSArray*) overlays__
{
    NSArray* re$ult = [self overlays];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) MKCoordinateRegion region;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region 
{
    [self setRegion:[region getMKCoordinateRegion]];
}

// @property(nonatomic) MKCoordinateRegion region;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) region__
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[self region]];
}

// @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (void) setScrollEnabled___boolean:(BOOL) scrollEnabled 
{
    [self setScrollEnabled:scrollEnabled];
}

// @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (BOOL) isScrollEnabled__
{
    return [self isScrollEnabled];
}

// @property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;
- (void) setSelectedAnnotations___java_util_List:(NSArray*) selectedAnnotations 
{
    [self setSelectedAnnotations:(selectedAnnotations == JAVA_NULL ? nil : selectedAnnotations)];
}

// @property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;
- (NSArray*) selectedAnnotations__
{
    NSArray* re$ult = [self selectedAnnotations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL showsUserLocation;
- (void) setShowsUserLocation___boolean:(BOOL) showsUserLocation 
{
    [self setShowsUserLocation:showsUserLocation];
}

// @property(nonatomic) BOOL showsUserLocation;
- (BOOL) showsUserLocation__
{
    return [self showsUserLocation];
}

// @property(nonatomic, readonly) MKUserLocation *userLocation;
- (MKUserLocation*) userLocation__
{
    MKUserLocation* re$ult = [self userLocation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, getter=isUserLocationVisible) BOOL userLocationVisible;
- (BOOL) isUserLocationVisible__
{
    return [self isUserLocationVisible];
}

// @property(nonatomic) MKMapRect visibleMapRect;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) visibleMapRect 
{
    [self setVisibleMapRect:[visibleMapRect getMKMapRect]];
}

// @property(nonatomic) MKMapRect visibleMapRect;
- (crossmobile_ios_mapkit_MKMapRect*) visibleMapRect__
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self visibleMapRect]];
}

// @property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;
- (void) setZoomEnabled___boolean:(BOOL) zoomEnabled 
{
    [self setZoomEnabled:zoomEnabled];
}

// @property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;
- (BOOL) isZoomEnabled__
{
    return [self isZoomEnabled];
}

// - (void)addAnnotation:(id<MKAnnotation>)annotation;
- (void) addAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [self addAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// - (void)addAnnotations:(NSArray<id<MKAnnotation>> *)annotations;
- (void) addAnnotations___java_util_List:(NSArray*) annotations 
{
    [self addAnnotations:(annotations == JAVA_NULL ? nil : annotations)];
}

// - (void)addOverlay:(id<MKOverlay>)overlay;
- (void) addOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    [self addOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// - (void)addOverlays:(NSArray<id<MKOverlay>> *)overlays;
- (void) addOverlays___java_util_List:(NSArray*) overlays 
{
    [self addOverlays:(overlays == JAVA_NULL ? nil : overlays)];
}

// - (NSSet<id<MKAnnotation>> *)annotationsInMapRect:(MKMapRect)mapRect;
- (NSSet*) annotationsInMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    NSSet* re$ult = [self annotationsInMapRect:[mapRect getMKMapRect]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGPoint)convertCoordinate:(CLLocationCoordinate2D)coordinate toPointToView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_crossmobile_ios_uikit_UIView:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self convertCoordinate:[coordinate getCLLocationCoordinate2D] toPointToView:(view == JAVA_NULL ? nil : view)]];
}

// - (CLLocationCoordinate2D)convertPoint:(CGPoint)point toCoordinateFromView:(UIView *)view;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) convertPoint___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self convertPoint:[point getCGPoint] toCoordinateFromView:(view == JAVA_NULL ? nil : view)]];
}

// - (MKCoordinateRegion)convertRect:(CGRect)rect toRegionFromView:(UIView *)view;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) convertRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[self convertRect:[rect getCGRect] toRegionFromView:(view == JAVA_NULL ? nil : view)]];
}

// - (CGRect)convertRegion:(MKCoordinateRegion)region toRectToView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRegion___crossmobile_ios_mapkit_MKCoordinateRegion_crossmobile_ios_uikit_UIView:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self convertRegion:[region getMKCoordinateRegion] toRectToView:(view == JAVA_NULL ? nil : view)]];
}

// - (MKAnnotationView *)dequeueReusableAnnotationViewWithIdentifier:(NSString *)identifier;
- (MKAnnotationView*) dequeueReusableAnnotationViewWithIdentifier___java_lang_String:(NSString*) identifier 
{
    MKAnnotationView* re$ult = [self dequeueReusableAnnotationViewWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)deselectAnnotation:(id<MKAnnotation>)annotation animated:(BOOL)animated;
- (void) deselectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated 
{
    [self deselectAnnotation:(annotation == JAVA_NULL ? nil : annotation) animated:animated];
}

// - (void)exchangeOverlayAtIndex:(NSUInteger)index1 withOverlayAtIndex:(NSUInteger)index2;
- (void) exchangeOverlayAtIndex___int_int:(int) index1 :(int) index2 
{
    [self exchangeOverlayAtIndex:index1 withOverlayAtIndex:index2];
}

// - (void)insertOverlay:(id<MKOverlay>)overlay atIndex:(NSUInteger)index;
- (void) insertOverlay___crossmobile_ios_mapkit_MKOverlay_int:(id<MKOverlay>) overlay :(int) index 
{
    [self insertOverlay:(overlay == JAVA_NULL ? nil : overlay) atIndex:index];
}

// - (void)insertOverlay:(id<MKOverlay>)overlay aboveOverlay:(id<MKOverlay>)sibling;
- (void) insertOverlayAboveOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling 
{
    [self insertOverlay:(overlay == JAVA_NULL ? nil : overlay) aboveOverlay:(sibling == JAVA_NULL ? nil : sibling)];
}

// - (void)insertOverlay:(id<MKOverlay>)overlay belowOverlay:(id<MKOverlay>)sibling;
- (void) insertOverlayBelowOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling 
{
    [self insertOverlay:(overlay == JAVA_NULL ? nil : overlay) belowOverlay:(sibling == JAVA_NULL ? nil : sibling)];
}

// - (MKMapRect)mapRectThatFits:(MKMapRect)mapRect;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self mapRectThatFits:[mapRect getMKMapRect]]];
}

// - (MKMapRect)mapRectThatFits:(MKMapRect)mapRect edgePadding:(UIEdgeInsets)insets;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self mapRectThatFits:[mapRect getMKMapRect] edgePadding:[insets getUIEdgeInsets]]];
}

// - (MKCoordinateRegion)regionThatFits:(MKCoordinateRegion)region;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) regionThatFits___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region 
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[self regionThatFits:[region getMKCoordinateRegion]]];
}

// - (void)removeAnnotation:(id<MKAnnotation>)annotation;
- (void) removeAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [self removeAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// - (void)removeAnnotations:(NSArray<id<MKAnnotation>> *)annotations;
- (void) removeAnnotations___java_util_List:(NSArray*) annotations 
{
    [self removeAnnotations:(annotations == JAVA_NULL ? nil : annotations)];
}

// - (void)removeOverlay:(id<MKOverlay>)overlay;
- (void) removeOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    [self removeOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// - (void)removeOverlays:(NSArray<id<MKOverlay>> *)overlays;
- (void) removeOverlays___java_util_List:(NSArray*) overlays 
{
    [self removeOverlays:(overlays == JAVA_NULL ? nil : overlays)];
}

// - (void)selectAnnotation:(id<MKAnnotation>)annotation animated:(BOOL)animated;
- (void) selectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated 
{
    [self selectAnnotation:(annotation == JAVA_NULL ? nil : annotation) animated:animated];
}

// - (void)setCenterCoordinate:(CLLocationCoordinate2D)coordinate animated:(BOOL)animated;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_boolean:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(BOOL) animated 
{
    [self setCenterCoordinate:[coordinate getCLLocationCoordinate2D] animated:animated];
}

// - (void)setRegion:(MKCoordinateRegion)region animated:(BOOL)animated;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion_boolean:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(BOOL) animated 
{
    [self setRegion:[region getMKCoordinateRegion] animated:animated];
}

// - (void)setVisibleMapRect:(MKMapRect)mapRect animated:(BOOL)animate;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(BOOL) animate 
{
    [self setVisibleMapRect:[mapRect getMKMapRect] animated:animate];
}

// - (void)setVisibleMapRect:(MKMapRect)mapRect edgePadding:(UIEdgeInsets)insets animated:(BOOL)animate;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets :(BOOL) animate 
{
    [self setVisibleMapRect:[mapRect getMKMapRect] edgePadding:[insets getUIEdgeInsets] animated:animate];
}

// - (MKAnnotationView *)viewForAnnotation:(id<MKAnnotation>)annotation;
- (MKAnnotationView*) viewForAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    MKAnnotationView* re$ult = [self viewForAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (MKOverlayView *)viewForOverlay:(id<MKOverlay>)overlay;
- (MKOverlayView*) viewForOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    MKOverlayView* re$ult = [self viewForOverlay:(overlay == JAVA_NULL ? nil : overlay)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
