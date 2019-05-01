// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKMapSize definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
#import "java_lang_Object.h"

CM_EXPORT_CLASS
@interface crossmobile_ios_mapkit_MKMapSize : java_lang_Object {
@public double width_double;
@public double height_double;
}

- (crossmobile_ios_mapkit_MKMapSize*) __init_crossmobile_ios_mapkit_MKMapSize___double_double:(double) width :(double) height ;
- (void) setHeight___double:(double) height ;
- (double) getHeight__;
- (void) setWidth___double:(double) width ;
- (double) getWidth__;
- (instancetype) initWithMKMapSize:(MKMapSize) reference;
- (void) setMKMapSize:(MKMapSize) other;
- (MKMapSize) getMKMapSize;
@end
