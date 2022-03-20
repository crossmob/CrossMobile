// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKOverlayView implementation

#import "crossmobile_ios_coregraphics_CGContext.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_mapkit_MKMapPoint.h"
#import "crossmobile_ios_mapkit_MKMapRect.h"
#import "crossmobile_ios_mapkit_MKOverlay.h"
#import "crossmobile_ios_mapkit_MKOverlayView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_mapkit_MKOverlayView$Ext

@end

@implementation MKOverlayView (cm_crossmobile_ios_mapkit_MKOverlayView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKOverlayView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKOverlayView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithOverlay:(id<MKOverlay>)overlay;
- (instancetype) __init_crossmobile_ios_mapkit_MKOverlayView___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    return [self initWithOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// @property(nonatomic, readonly) id<MKOverlay> overlay;
- (id<MKOverlay>) overlay__
{
    id<MKOverlay> re$ult = [self overlay];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)canDrawMapRect:(MKMapRect)mapRect zoomScale:(MKZoomScale)zoomScale;
- (BOOL) canDrawMapRect___crossmobile_ios_mapkit_MKMapRect_double:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(double) zoomScale 
{
    return [self canDrawMapRect:[mapRect getMKMapRect] zoomScale:zoomScale];
}

// - (void)drawMapRect:(MKMapRect)mapRect zoomScale:(MKZoomScale)zoomScale inContext:(CGContextRef)context;
- (void) drawMapRect___crossmobile_ios_mapkit_MKMapRect_double_crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(double) zoomScale :(crossmobile_ios_coregraphics_CGContext*) context 
{
    [self drawMapRect:[mapRect getMKMapRect] zoomScale:zoomScale inContext:context->$reference];
}

// - (MKMapPoint)mapPointForPoint:(CGPoint)point;
- (crossmobile_ios_mapkit_MKMapPoint*) mapPointForPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point 
{
    return [[crossmobile_ios_mapkit_MKMapPoint alloc] initWithMKMapPoint:[self mapPointForPoint:[point getCGPoint]]];
}

// - (MKMapRect)mapRectForRect:(CGRect)rect;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectForRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self mapRectForRect:[rect getCGRect]]];
}

// - (CGPoint)pointForMapPoint:(MKMapPoint)mapPoint;
- (crossmobile_ios_coregraphics_CGPoint*) pointForMapPoint___crossmobile_ios_mapkit_MKMapPoint:(crossmobile_ios_mapkit_MKMapPoint*) mapPoint 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self pointForMapPoint:[mapPoint getMKMapPoint]]];
}

// - (CGRect)rectForMapRect:(MKMapRect)mapRect;
- (crossmobile_ios_coregraphics_CGRect*) rectForMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self rectForMapRect:[mapRect getMKMapRect]]];
}

// - (void)setNeedsDisplayInMapRect:(MKMapRect)mapRect;
- (void) setNeedsDisplayInMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    [self setNeedsDisplayInMapRect:[mapRect getMKMapRect]];
}

// - (void)setNeedsDisplayInMapRect:(MKMapRect)mapRect zoomScale:(MKZoomScale)zoomScale;
- (void) setNeedsDisplayInMapRect___crossmobile_ios_mapkit_MKMapRect_double:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(double) zoomScale 
{
    [self setNeedsDisplayInMapRect:[mapRect getMKMapRect] zoomScale:zoomScale];
}

@end
