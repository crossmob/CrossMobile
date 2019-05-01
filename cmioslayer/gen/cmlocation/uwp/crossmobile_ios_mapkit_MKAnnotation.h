// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKAnnotation definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_corelocation_CLLocationCoordinate2D;
@class java_lang_String;

@protocol crossmobile_ios_mapkit_MKAnnotation
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate__;
- (NSString*) subtitle__;
- (NSString*) title__;
- (void) setCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) newCoordinate ;
@end
