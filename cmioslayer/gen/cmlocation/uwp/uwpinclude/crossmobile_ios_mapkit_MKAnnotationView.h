// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKAnnotationView definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@protocol crossmobile_ios_mapkit_MKAnnotation;
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_mapkit_MKAnnotationView$Ext : MKAnnotationView
@end

#define crossmobile_ios_mapkit_MKAnnotationView MKAnnotationView
@interface MKAnnotationView (cm_crossmobile_ios_mapkit_MKAnnotationView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_mapkit_MKAnnotationView___crossmobile_ios_mapkit_MKAnnotation_java_lang_String:(id<MKAnnotation>) annotation :(NSString*) reuseIdentifier ;
- (void) setAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation ;
- (id<MKAnnotation>) annotation__;
- (void) setCalloutOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) calloutOffset ;
- (crossmobile_ios_coregraphics_CGPoint*) calloutOffset__;
- (void) setCanShowCallout___boolean:(BOOL) canShowCallout ;
- (BOOL) canShowCallout__;
- (void) setCenterOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) centerOffset ;
- (crossmobile_ios_coregraphics_CGPoint*) centerOffset__;
- (void) setDragState___int:(int) dragState ;
- (int) dragState__;
- (void) setDraggable___boolean:(BOOL) draggable ;
- (BOOL) isDraggable__;
- (void) setEnabled___boolean:(BOOL) enabled ;
- (BOOL) isEnabled__;
- (void) setHighlighted___boolean:(BOOL) highlighted ;
- (BOOL) isHighlighted__;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image ;
- (UIImage*) image__;
- (void) setLeftCalloutAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) leftCalloutAccessoryView ;
- (UIView*) leftCalloutAccessoryView__;
- (NSString*) reuseIdentifier__;
- (void) setRightCalloutAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) rightCalloutAccessoryView ;
- (UIView*) rightCalloutAccessoryView__;
- (void) setSelected___boolean:(BOOL) selected ;
- (BOOL) isSelected__;
- (void) prepareForReuse__;
- (void) setDragState___int_boolean:(int) newDragState :(BOOL) animated ;
- (void) setSelected___boolean_boolean:(BOOL) selected :(BOOL) animated ;
@end
