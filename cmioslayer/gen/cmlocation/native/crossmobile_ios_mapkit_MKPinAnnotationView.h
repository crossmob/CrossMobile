// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mapkit_MKPinAnnotationView definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@protocol crossmobile_ios_mapkit_MKAnnotation;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_mapkit_MKPinAnnotationView$Ext : MKPinAnnotationView
@end

#define crossmobile_ios_mapkit_MKPinAnnotationView MKPinAnnotationView
@interface MKPinAnnotationView (cm_crossmobile_ios_mapkit_MKPinAnnotationView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_mapkit_MKPinAnnotationView___crossmobile_ios_mapkit_MKAnnotation_java_lang_String:(id<MKAnnotation>) annotation :(NSString*) reuseIdentifier ;
- (void) setAnimatesDrop___boolean:(BOOL) animatesDrop ;
- (BOOL) animatesDrop__;
- (void) setPinColor___int:(int) pinColor ;
- (int) pinColor__;
@end
