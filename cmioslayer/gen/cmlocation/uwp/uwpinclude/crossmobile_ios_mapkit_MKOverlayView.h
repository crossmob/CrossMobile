// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKOverlayView definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_coregraphics_CGContext;
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_mapkit_MKMapPoint;
@class crossmobile_ios_mapkit_MKMapRect;
@protocol crossmobile_ios_mapkit_MKOverlay;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_mapkit_MKOverlayView$Ext : MKOverlayView
@end

#define crossmobile_ios_mapkit_MKOverlayView MKOverlayView
@interface MKOverlayView (cm_crossmobile_ios_mapkit_MKOverlayView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_mapkit_MKOverlayView___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay ;
- (id<MKOverlay>) overlay__;
- (BOOL) canDrawMapRect___crossmobile_ios_mapkit_MKMapRect_double:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(double) zoomScale ;
- (void) drawMapRect___crossmobile_ios_mapkit_MKMapRect_double_crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(double) zoomScale :(crossmobile_ios_coregraphics_CGContext*) context ;
- (crossmobile_ios_mapkit_MKMapPoint*) mapPointForPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) point ;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectForRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect ;
- (crossmobile_ios_coregraphics_CGPoint*) pointForMapPoint___crossmobile_ios_mapkit_MKMapPoint:(crossmobile_ios_mapkit_MKMapPoint*) mapPoint ;
- (crossmobile_ios_coregraphics_CGRect*) rectForMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect ;
- (void) setNeedsDisplayInMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect ;
- (void) setNeedsDisplayInMapRect___crossmobile_ios_mapkit_MKMapRect_double:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(double) zoomScale ;
@end
