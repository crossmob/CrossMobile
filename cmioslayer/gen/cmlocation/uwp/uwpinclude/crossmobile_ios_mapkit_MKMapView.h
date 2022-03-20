// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapView definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@protocol crossmobile_ios_mapkit_MKAnnotation;
@class crossmobile_ios_mapkit_MKAnnotationView;
@class crossmobile_ios_mapkit_MKCoordinateRegion;
@class crossmobile_ios_mapkit_MKMapRect;
@protocol crossmobile_ios_mapkit_MKMapViewDelegate;
@protocol crossmobile_ios_mapkit_MKOverlay;
@class crossmobile_ios_mapkit_MKOverlayView;
@class crossmobile_ios_mapkit_MKUserLocation;
@class crossmobile_ios_uikit_UIEdgeInsets;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_mapkit_MKMapView$Ext : MKMapView
@end

#define crossmobile_ios_mapkit_MKMapView MKMapView
@interface MKMapView (cm_crossmobile_ios_mapkit_MKMapView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_mapkit_MKMapView__;
- (instancetype) __init_crossmobile_ios_mapkit_MKMapView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (crossmobile_ios_coregraphics_CGRect*) annotationVisibleRect__;
- (NSArray*) annotations__;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate ;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate__;
- (void) setDelegate___crossmobile_ios_mapkit_MKMapViewDelegate:(id<MKMapViewDelegate>) delegate ;
- (id<MKMapViewDelegate>) delegate__;
- (void) setMapType___int:(int) mapType ;
- (int) mapType__;
- (NSArray*) overlays__;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region ;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) region__;
- (void) setScrollEnabled___boolean:(BOOL) scrollEnabled ;
- (BOOL) isScrollEnabled__;
- (void) setSelectedAnnotations___java_util_List:(NSArray*) selectedAnnotations ;
- (NSArray*) selectedAnnotations__;
- (void) setShowsUserLocation___boolean:(BOOL) showsUserLocation ;
- (BOOL) showsUserLocation__;
- (MKUserLocation*) userLocation__;
- (BOOL) isUserLocationVisible__;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) visibleMapRect ;
- (crossmobile_ios_mapkit_MKMapRect*) visibleMapRect__;
- (void) setZoomEnabled___boolean:(BOOL) zoomEnabled ;
- (BOOL) isZoomEnabled__;
- (void) addAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation ;
- (void) addAnnotations___java_util_List:(NSArray*) annotations ;
- (void) addOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay ;
- (void) addOverlays___java_util_List:(NSArray*) overlays ;
- (NSSet*) annotationsInMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect ;
- (crossmobile_ios_coregraphics_CGPoint*) convertCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_crossmobile_ios_uikit_UIView:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(UIView*) view ;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) convertPoint___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view ;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) convertRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view ;
- (crossmobile_ios_coregraphics_CGRect*) convertRegion___crossmobile_ios_mapkit_MKCoordinateRegion_crossmobile_ios_uikit_UIView:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(UIView*) view ;
- (MKAnnotationView*) dequeueReusableAnnotationViewWithIdentifier___java_lang_String:(NSString*) identifier ;
- (void) deselectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated ;
- (void) exchangeOverlayAtIndex___int_int:(int) index1 :(int) index2 ;
- (void) insertOverlay___crossmobile_ios_mapkit_MKOverlay_int:(id<MKOverlay>) overlay :(int) index ;
- (void) insertOverlayAboveOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling ;
- (void) insertOverlayBelowOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling ;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect ;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets ;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) regionThatFits___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region ;
- (void) removeAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation ;
- (void) removeAnnotations___java_util_List:(NSArray*) annotations ;
- (void) removeOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay ;
- (void) removeOverlays___java_util_List:(NSArray*) overlays ;
- (void) selectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated ;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_boolean:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(BOOL) animated ;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion_boolean:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(BOOL) animated ;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(BOOL) animate ;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets :(BOOL) animate ;
- (MKAnnotationView*) viewForAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation ;
- (MKOverlayView*) viewForOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay ;
@end
