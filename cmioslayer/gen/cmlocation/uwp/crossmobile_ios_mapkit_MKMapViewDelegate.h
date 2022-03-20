// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKMapViewDelegate definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_foundation_NSError;
@protocol crossmobile_ios_mapkit_MKAnnotation;
@class crossmobile_ios_mapkit_MKAnnotationView;
@class crossmobile_ios_mapkit_MKMapView;
@protocol crossmobile_ios_mapkit_MKOverlay;
@class crossmobile_ios_mapkit_MKOverlayView;
@class crossmobile_ios_mapkit_MKUserLocation;
@class crossmobile_ios_uikit_UIControl;
@protocol java_util_List;

@protocol crossmobile_ios_mapkit_MKMapViewDelegate
- (void) annotationViewCalloutAccessoryControlTapped___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKAnnotationView_crossmobile_ios_uikit_UIControl:(MKMapView*) mapView :(MKAnnotationView*) view :(UIControl*) control ;
- (void) annotationViewDidChangeDragState___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKAnnotationView_int_int:(MKMapView*) mapView :(MKAnnotationView*) view :(int) newState :(int) oldState ;
- (void) didAddAnnotationViews___crossmobile_ios_mapkit_MKMapView_java_util_List:(MKMapView*) mapView :(NSArray*) views ;
- (void) didAddOverlayViews___crossmobile_ios_mapkit_MKMapView_java_util_List:(MKMapView*) mapView :(NSArray*) overlayViews ;
- (void) didDeselectAnnotationView___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKAnnotationView:(MKMapView*) mapView :(MKAnnotationView*) view ;
- (void) didFailLoadingMap___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_foundation_NSError:(MKMapView*) mapView :(NSError*) error ;
- (void) didFailToLocateUserWithError___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_foundation_NSError:(MKMapView*) mapView :(NSError*) error ;
- (void) didFinishLoadingMap___crossmobile_ios_mapkit_MKMapView:(MKMapView*) mapView ;
- (void) didSelectAnnotationView___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKAnnotationView:(MKMapView*) mapView :(MKAnnotationView*) view ;
- (void) didStopLocatingUser___crossmobile_ios_mapkit_MKMapView:(MKMapView*) mapView ;
- (void) didUpdateUserLocation___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKUserLocation:(MKMapView*) mapView :(MKUserLocation*) userLocation ;
- (void) regionDidChangeAnimated___crossmobile_ios_mapkit_MKMapView_boolean:(MKMapView*) mapView :(BOOL) animated ;
- (void) regionWillChangeAnimated___crossmobile_ios_mapkit_MKMapView_boolean:(MKMapView*) mapView :(BOOL) animated ;
- (MKAnnotationView*) viewForAnnotation___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKAnnotation:(MKMapView*) mapView :(id<MKAnnotation>) annotation ;
- (MKOverlayView*) viewForOverlay___crossmobile_ios_mapkit_MKMapView_crossmobile_ios_mapkit_MKOverlay:(MKMapView*) mapView :(id<MKOverlay>) overlay ;
- (void) willStartLoadingMap___crossmobile_ios_mapkit_MKMapView:(MKMapView*) mapView ;
- (void) willStartLocatingUser___crossmobile_ios_mapkit_MKMapView:(MKMapView*) mapView ;
@end
