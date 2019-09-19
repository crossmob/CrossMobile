// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKMapView implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_mapkit_MKAnnotation.h"
#import "crossmobile_ios_mapkit_MKAnnotationView.h"
#import "crossmobile_ios_mapkit_MKCoordinateRegion.h"
#import "crossmobile_ios_mapkit_MKMapRect.h"
#import "crossmobile_ios_mapkit_MKMapView.h"
#import "crossmobile_ios_mapkit_MKMapViewDelegate.h"
#import "crossmobile_ios_mapkit_MKOverlay.h"
#import "crossmobile_ios_mapkit_MKOverlayView.h"
#import "crossmobile_ios_mapkit_MKUserLocation.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"
#import "crossmobile_ios_uikit_NSLayoutXAxisAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UILayoutGuide.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_mapkit_MKMapView$Ext

// (UIView) @property(nonatomic, copy) NSString *accessibilityIdentifier;
- (void) setAccessibilityIdentifier___java_lang_String:(NSString*) accessibilityIdentifier 
{
    [super setAccessibilityIdentifier:(accessibilityIdentifier == JAVA_NULL ? nil : accessibilityIdentifier)];
}

// (UIView) @property(nonatomic, copy) NSString *accessibilityIdentifier;
- (NSString*) accessibilityIdentifier__
{
    NSString* re$ult = [super accessibilityIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGFloat alpha;
- (void) setAlpha___double:(double) alpha 
{
    [super setAlpha:alpha];
}

// (UIView) @property(nonatomic) CGFloat alpha;
- (double) alpha__
{
    return [super alpha];
}

// (MKMapView) @property(nonatomic, readonly) CGRect annotationVisibleRect;
- (crossmobile_ios_coregraphics_CGRect*) annotationVisibleRect__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super annotationVisibleRect]];
}

// (MKMapView) @property(nonatomic, readonly) NSArray<id<MKAnnotation>> *annotations;
- (NSArray*) annotations__
{
    NSArray* re$ult = [super annotations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) BOOL autoresizesSubviews;
- (void) setAutoresizesSubviews___boolean:(BOOL) autoresizesSubviews 
{
    [super setAutoresizesSubviews:autoresizesSubviews];
}

// (UIView) @property(nonatomic) BOOL autoresizesSubviews;
- (BOOL) autoresizesSubviews__
{
    return [super autoresizesSubviews];
}

// (UIView) @property(nonatomic) UIViewAutoresizing autoresizingMask;
- (void) setAutoresizingMask___int:(int) autoresizingMask 
{
    [super setAutoresizingMask:autoresizingMask];
}

// (UIView) @property(nonatomic) UIViewAutoresizing autoresizingMask;
- (int) autoresizingMask__
{
    return [super autoresizingMask];
}

// (UIView) @property(nonatomic, copy) UIColor *backgroundColor;
- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor 
{
    [super setBackgroundColor:(backgroundColor == JAVA_NULL ? nil : backgroundColor)];
}

// (UIView) @property(nonatomic, copy) UIColor *backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [super backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;
- (NSLayoutYAxisAnchor*) bottomAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [super bottomAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGRect bounds;
- (void) setBounds___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) bounds 
{
    [super setBounds:[bounds getCGRect]];
}

// (UIView) @property(nonatomic) CGRect bounds;
- (crossmobile_ios_coregraphics_CGRect*) bounds__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super bounds]];
}

// (UIView) @property(nonatomic) CGPoint center;
- (void) setCenter___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) center 
{
    [super setCenter:[center getCGPoint]];
}

// (UIView) @property(nonatomic) CGPoint center;
- (crossmobile_ios_coregraphics_CGPoint*) center__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super center]];
}

// (MKMapView) @property(nonatomic) CLLocationCoordinate2D centerCoordinate;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate 
{
    [super setCenterCoordinate:[centerCoordinate getCLLocationCoordinate2D]];
}

// (MKMapView) @property(nonatomic) CLLocationCoordinate2D centerCoordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super centerCoordinate]];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *centerXAnchor;
- (NSLayoutXAxisAnchor*) centerXAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super centerXAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutYAxisAnchor *centerYAnchor;
- (NSLayoutYAxisAnchor*) centerYAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [super centerYAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) BOOL clearsContextBeforeDrawing;
- (void) setClearsContextBeforeDrawing___boolean:(BOOL) clearsContextBeforeDrawing 
{
    [super setClearsContextBeforeDrawing:clearsContextBeforeDrawing];
}

// (UIView) @property(nonatomic) BOOL clipsToBounds;
- (void) setClipsToBounds___boolean:(BOOL) clipsToBounds 
{
    [super setClipsToBounds:clipsToBounds];
}

// (UIView) @property(nonatomic) BOOL clipsToBounds;
- (BOOL) clipsToBounds__
{
    return [super clipsToBounds];
}

// (UIView) @property(nonatomic, readonly) NSArray<__kindof NSLayoutConstraint *> *constraints;
- (NSArray*) constraints__
{
    NSArray* re$ult = [super constraints];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) UIViewContentMode contentMode;
- (void) setContentMode___int:(int) contentMode 
{
    [super setContentMode:contentMode];
}

// (UIView) @property(nonatomic) UIViewContentMode contentMode;
- (int) contentMode__
{
    return [super contentMode];
}

// (MKMapView) @property(nonatomic, weak) id<MKMapViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_mapkit_MKMapViewDelegate:(id<MKMapViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (MKMapView) @property(nonatomic, weak) id<MKMapViewDelegate> delegate;
- (id<MKMapViewDelegate>) delegate__
{
    id<MKMapViewDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGRect frame;
- (void) setFrame___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    [super setFrame:[frame getCGRect]];
}

// (UIView) @property(nonatomic) CGRect frame;
- (crossmobile_ios_coregraphics_CGRect*) frame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super frame]];
}

// (UIView) @property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;
- (void) setGestureRecognizers___java_util_List:(NSArray*) gestureRecognizers 
{
    [super setGestureRecognizers:(gestureRecognizers == JAVA_NULL ? nil : gestureRecognizers)];
}

// (UIView) @property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;
- (NSArray*) gestureRecognizers__
{
    NSArray* re$ult = [super gestureRecognizers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutDimension *heightAnchor;
- (NSLayoutDimension*) heightAnchor__
{
    NSLayoutDimension* re$ult = [super heightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, getter=isHidden) BOOL hidden;
- (void) setHidden___boolean:(BOOL) hidden 
{
    [super setHidden:hidden];
}

// (UIView) @property(nonatomic, getter=isHidden) BOOL hidden;
- (BOOL) isHidden__
{
    return [super isHidden];
}

// (UIView) @property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;
- (void) setInsetsLayoutMarginsFromSafeArea___boolean:(BOOL) insetsLayoutMarginsFromSafeArea 
{
    [super setInsetsLayoutMarginsFromSafeArea:insetsLayoutMarginsFromSafeArea];
}

// (UIView) @property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;
- (BOOL) insetsLayoutMarginsFromSafeArea__
{
    return [super insetsLayoutMarginsFromSafeArea];
}

// (UIView) @property(nonatomic, readonly, strong) CALayer *layer;
- (CALayer*) layer__
{
    CALayer* re$ult = [super layer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) UIEdgeInsets layoutMargins;
- (void) setLayoutMargins___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) layoutMargins 
{
    [super setLayoutMargins:[layoutMargins getUIEdgeInsets]];
}

// (UIView) @property(nonatomic) UIEdgeInsets layoutMargins;
- (crossmobile_ios_uikit_UIEdgeInsets*) layoutMargins__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super layoutMargins]];
}

// (UIView) @property(readonly, strong) UILayoutGuide *layoutMarginsGuide;
- (UILayoutGuide*) layoutMarginsGuide__
{
    UILayoutGuide* re$ult = [super layoutMarginsGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *leadingAnchor;
- (NSLayoutXAxisAnchor*) leadingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super leadingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *leftAnchor;
- (NSLayoutXAxisAnchor*) leftAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super leftAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) @property(nonatomic) MKMapType mapType;
- (void) setMapType___int:(int) mapType 
{
    [super setMapType:mapType];
}

// (MKMapView) @property(nonatomic) MKMapType mapType;
- (int) mapType__
{
    return [super mapType];
}

// (UIView) @property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;
- (void) setMultipleTouchEnabled___boolean:(BOOL) multipleTouchEnabled 
{
    [super setMultipleTouchEnabled:multipleTouchEnabled];
}

// (UIView) @property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;
- (BOOL) isMultipleTouchEnabled__
{
    return [super isMultipleTouchEnabled];
}

// (UIView) @property(nonatomic, getter=isOpaque) BOOL opaque;
- (void) setOpaque___boolean:(BOOL) opaque 
{
    [super setOpaque:opaque];
}

// (UIView) @property(nonatomic, getter=isOpaque) BOOL opaque;
- (BOOL) isOpaque__
{
    return [super isOpaque];
}

// (MKMapView) @property(nonatomic, readonly) NSArray<id<MKOverlay>> *overlays;
- (NSArray*) overlays__
{
    NSArray* re$ult = [super overlays];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) BOOL preservesSuperviewLayoutMargins;
- (void) setPreservesSuperviewLayoutMargins___boolean:(BOOL) preservesSuperviewLayoutMargins 
{
    [super setPreservesSuperviewLayoutMargins:preservesSuperviewLayoutMargins];
}

// (UIView) @property(nonatomic) BOOL preservesSuperviewLayoutMargins;
- (BOOL) preservesSuperviewLayoutMargins__
{
    return [super preservesSuperviewLayoutMargins];
}

// (MKMapView) @property(nonatomic) MKCoordinateRegion region;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region 
{
    [super setRegion:[region getMKCoordinateRegion]];
}

// (MKMapView) @property(nonatomic) MKCoordinateRegion region;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) region__
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[super region]];
}

// (UIView) @property(nonatomic, copy) NSString *restorationIdentifier;
- (void) setRestorationIdentifier___java_lang_String:(NSString*) restorationIdentifier 
{
    [super setRestorationIdentifier:(restorationIdentifier == JAVA_NULL ? nil : restorationIdentifier)];
}

// (UIView) @property(nonatomic, copy) NSString *restorationIdentifier;
- (NSString*) restorationIdentifier__
{
    NSString* re$ult = [super restorationIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;
- (NSLayoutXAxisAnchor*) rightAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super rightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, readonly) UIEdgeInsets safeAreaInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) safeAreaInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super safeAreaInsets]];
}

// (UIView) @property(nonatomic, readonly, strong) UILayoutGuide *safeAreaLayoutGuide;
- (UILayoutGuide*) safeAreaLayoutGuide__
{
    UILayoutGuide* re$ult = [super safeAreaLayoutGuide];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (void) setScrollEnabled___boolean:(BOOL) scrollEnabled 
{
    [super setScrollEnabled:scrollEnabled];
}

// (MKMapView) @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (BOOL) isScrollEnabled__
{
    return [super isScrollEnabled];
}

// (MKMapView) @property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;
- (void) setSelectedAnnotations___java_util_List:(NSArray*) selectedAnnotations 
{
    [super setSelectedAnnotations:(selectedAnnotations == JAVA_NULL ? nil : selectedAnnotations)];
}

// (MKMapView) @property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;
- (NSArray*) selectedAnnotations__
{
    NSArray* re$ult = [super selectedAnnotations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) @property(nonatomic) BOOL showsUserLocation;
- (void) setShowsUserLocation___boolean:(BOOL) showsUserLocation 
{
    [super setShowsUserLocation:showsUserLocation];
}

// (MKMapView) @property(nonatomic) BOOL showsUserLocation;
- (BOOL) showsUserLocation__
{
    return [super showsUserLocation];
}

// (UIView) @property(nonatomic, readonly, copy) NSArray<__kindof UIView *> *subviews;
- (NSArray*) subviews__
{
    NSArray* re$ult = [super subviews];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, readonly) UIView *superview;
- (UIView*) superview__
{
    UIView* re$ult = [super superview];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) NSInteger tag;
- (void) setTag___int:(int) tag 
{
    [super setTag:tag];
}

// (UIView) @property(nonatomic) NSInteger tag;
- (int) tag__
{
    return [super tag];
}

// (UIView) @property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;
- (void) setTintAdjustmentMode___int:(int) tintAdjustmentMode 
{
    [super setTintAdjustmentMode:tintAdjustmentMode];
}

// (UIView) @property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;
- (int) tintAdjustmentMode__
{
    return [super tintAdjustmentMode];
}

// (UIView) @property(nonatomic, strong) UIColor *tintColor;
- (void) setTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) tintColor 
{
    [super setTintColor:(tintColor == JAVA_NULL ? nil : tintColor)];
}

// (UIView) @property(nonatomic, strong) UIColor *tintColor;
- (UIColor*) tintColor__
{
    UIColor* re$ult = [super tintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;
- (NSLayoutYAxisAnchor*) topAnchor__
{
    NSLayoutYAxisAnchor* re$ult = [super topAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *trailingAnchor;
- (NSLayoutXAxisAnchor*) trailingAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super trailingAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic) CGAffineTransform transform;
- (void) setTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) transform 
{
    [super setTransform:[transform getCGAffineTransform]];
}

// (UIView) @property(nonatomic) CGAffineTransform transform;
- (crossmobile_ios_coregraphics_CGAffineTransform*) transform__
{
    return [[crossmobile_ios_coregraphics_CGAffineTransform alloc] initWithCGAffineTransform:[super transform]];
}

// (UIView) @property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;
- (void) setTranslatesAutoresizingMaskIntoConstraints___boolean:(BOOL) translatesAutoresizingMaskIntoConstraints 
{
    [super setTranslatesAutoresizingMaskIntoConstraints:translatesAutoresizingMaskIntoConstraints];
}

// (UIView) @property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;
- (BOOL) translatesAutoresizingMaskIntoConstraints__
{
    return [super translatesAutoresizingMaskIntoConstraints];
}

// (UIView) @property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;
- (void) setUserInteractionEnabled___boolean:(BOOL) userInteractionEnabled 
{
    [super setUserInteractionEnabled:userInteractionEnabled];
}

// (UIView) @property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;
- (BOOL) isUserInteractionEnabled__
{
    return [super isUserInteractionEnabled];
}

// (UIView) @property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;
- (int) userInterfaceLayoutDirection__
{
    return [super userInterfaceLayoutDirection];
}

// (MKMapView) @property(nonatomic, readonly) MKUserLocation *userLocation;
- (MKUserLocation*) userLocation__
{
    MKUserLocation* re$ult = [super userLocation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) @property(nonatomic, readonly, getter=isUserLocationVisible) BOOL userLocationVisible;
- (BOOL) isUserLocationVisible__
{
    return [super isUserLocationVisible];
}

// (UIView) @property(readonly, strong) UIView *viewForFirstBaselineLayout;
- (UIView*) viewForFirstBaselineLayout__
{
    UIView* re$ult = [super viewForFirstBaselineLayout];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) UIView *viewForLastBaselineLayout;
- (UIView*) viewForLastBaselineLayout__
{
    UIView* re$ult = [super viewForLastBaselineLayout];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) @property(nonatomic) MKMapRect visibleMapRect;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) visibleMapRect 
{
    [super setVisibleMapRect:[visibleMapRect getMKMapRect]];
}

// (MKMapView) @property(nonatomic) MKMapRect visibleMapRect;
- (crossmobile_ios_mapkit_MKMapRect*) visibleMapRect__
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[super visibleMapRect]];
}

// (UIView) @property(readonly, strong) NSLayoutDimension *widthAnchor;
- (NSLayoutDimension*) widthAnchor__
{
    NSLayoutDimension* re$ult = [super widthAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(nonatomic, readonly) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [super window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) @property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;
- (void) setZoomEnabled___boolean:(BOOL) zoomEnabled 
{
    [super setZoomEnabled:zoomEnabled];
}

// (MKMapView) @property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;
- (BOOL) isZoomEnabled__
{
    return [super isZoomEnabled];
}

// (MKMapView) - (void)addAnnotation:(id<MKAnnotation>)annotation;
- (void) addAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [super addAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// (MKMapView) - (void)addAnnotations:(NSArray<id<MKAnnotation>> *)annotations;
- (void) addAnnotations___java_util_List:(NSArray*) annotations 
{
    [super addAnnotations:(annotations == JAVA_NULL ? nil : annotations)];
}

// (UIView) - (void)addConstraint:(NSLayoutConstraint *)constraint;
- (void) addConstraint___crossmobile_ios_uikit_NSLayoutConstraint:(NSLayoutConstraint*) constraint 
{
    [super addConstraint:(constraint == JAVA_NULL ? nil : constraint)];
}

// (UIView) - (void)addConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;
- (void) addConstraints___java_util_List:(NSArray*) constraints 
{
    [super addConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// (UIView) - (void)addGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;
- (void) addGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer 
{
    [super addGestureRecognizer:(gestureRecognizer == JAVA_NULL ? nil : gestureRecognizer)];
}

// (UIView) - (void)addLayoutGuide:(UILayoutGuide *)layoutGuide;
- (void) addLayoutGuide___crossmobile_ios_uikit_UILayoutGuide:(UILayoutGuide*) layoutGuide 
{
    [super addLayoutGuide:(layoutGuide == JAVA_NULL ? nil : layoutGuide)];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (MKMapView) - (void)addOverlay:(id<MKOverlay>)overlay;
- (void) addOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    [super addOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// (MKMapView) - (void)addOverlays:(NSArray<id<MKOverlay>> *)overlays;
- (void) addOverlays___java_util_List:(NSArray*) overlays 
{
    [super addOverlays:(overlays == JAVA_NULL ? nil : overlays)];
}

// (UIView) - (void)addSubview:(UIView *)view;
- (void) addSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super addSubview:(view == JAVA_NULL ? nil : view)];
}

// (MKMapView) - (NSSet<id<MKAnnotation>> *)annotationsInMapRect:(MKMapRect)mapRect;
- (NSSet*) annotationsInMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    NSSet* re$ult = [super annotationsInMapRect:[mapRect getMKMapRect]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIResponder) - (BOOL)becomeFirstResponder;
- (BOOL) becomeFirstResponder__
{
    return [super becomeFirstResponder];
}

// (UIView) - (void)bringSubviewToFront:(UIView *)view;
- (void) bringSubviewToFront___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super bringSubviewToFront:(view == JAVA_NULL ? nil : view)];
}

// (UIView) - (UILayoutPriority)contentCompressionResistancePriorityForAxis:(UILayoutConstraintAxis)axis;
- (float) contentCompressionResistancePriorityForAxis___int:(int) axis 
{
    return [super contentCompressionResistancePriorityForAxis:axis];
}

// (UIView) - (UILayoutPriority)contentHuggingPriorityForAxis:(UILayoutConstraintAxis)axis;
- (float) contentHuggingPriorityForAxis___int:(int) axis 
{
    return [super contentHuggingPriorityForAxis:axis];
}

// (MKMapView) - (CGPoint)convertCoordinate:(CLLocationCoordinate2D)coordinate toPointToView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_crossmobile_ios_uikit_UIView:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super convertCoordinate:[coordinate getCLLocationCoordinate2D] toPointToView:(view == JAVA_NULL ? nil : view)]];
}

// (MKMapView) - (CLLocationCoordinate2D)convertPoint:(CGPoint)point toCoordinateFromView:(UIView *)view;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) convertPoint___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super convertPoint:[point getCGPoint] toCoordinateFromView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGPoint)convertPoint:(CGPoint)point fromView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointFromView___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super convertPoint:[point getCGPoint] fromView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGPoint)convertPoint:(CGPoint)point toView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointToView___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super convertPoint:[point getCGPoint] toView:(view == JAVA_NULL ? nil : view)]];
}

// (MKMapView) - (MKCoordinateRegion)convertRect:(CGRect)rect toRegionFromView:(UIView *)view;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) convertRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[super convertRect:[rect getCGRect] toRegionFromView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGRect)convertRect:(CGRect)rect fromView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRectFromView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super convertRect:[rect getCGRect] fromView:(view == JAVA_NULL ? nil : view)]];
}

// (UIView) - (CGRect)convertRect:(CGRect)rect toView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRectToView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super convertRect:[rect getCGRect] toView:(view == JAVA_NULL ? nil : view)]];
}

// (MKMapView) - (CGRect)convertRegion:(MKCoordinateRegion)region toRectToView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRegion___crossmobile_ios_mapkit_MKCoordinateRegion_crossmobile_ios_uikit_UIView:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super convertRegion:[region getMKCoordinateRegion] toRectToView:(view == JAVA_NULL ? nil : view)]];
}

// (MKMapView) - (MKAnnotationView *)dequeueReusableAnnotationViewWithIdentifier:(NSString *)identifier;
- (MKAnnotationView*) dequeueReusableAnnotationViewWithIdentifier___java_lang_String:(NSString*) identifier 
{
    MKAnnotationView* re$ult = [super dequeueReusableAnnotationViewWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) - (void)deselectAnnotation:(id<MKAnnotation>)annotation animated:(BOOL)animated;
- (void) deselectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated 
{
    [super deselectAnnotation:(annotation == JAVA_NULL ? nil : annotation) animated:animated];
}

// (UIView) - (void)didAddSubview:(UIView *)subview;
- (void) didAddSubview___crossmobile_ios_uikit_UIView:(UIView*) subview 
{
    [super didAddSubview:(subview == JAVA_NULL ? nil : subview)];
}

// (UIView) - (void)didMoveToSuperview;
- (void) didMoveToSuperview__
{
    [super didMoveToSuperview];
}

// (UIView) - (void)didMoveToWindow;
- (void) didMoveToWindow__
{
    [super didMoveToWindow];
}

// (UIView) - (void)drawRect:(CGRect)rect;
- (void) drawRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [super drawRect:[rect getCGRect]];
}

// (MKMapView) - (void)exchangeOverlayAtIndex:(NSUInteger)index1 withOverlayAtIndex:(NSUInteger)index2;
- (void) exchangeOverlayAtIndex___int_int:(int) index1 :(int) index2 
{
    [super exchangeOverlayAtIndex:index1 withOverlayAtIndex:index2];
}

// (UIView) - (UIView *)hitTest:(CGPoint)point withEvent:(UIEvent *)event;
- (UIView*) hitTest___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    UIView* re$ult = [super hitTest:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) - (void)insertOverlay:(id<MKOverlay>)overlay atIndex:(NSUInteger)index;
- (void) insertOverlay___crossmobile_ios_mapkit_MKOverlay_int:(id<MKOverlay>) overlay :(int) index 
{
    [super insertOverlay:(overlay == JAVA_NULL ? nil : overlay) atIndex:index];
}

// (MKMapView) - (void)insertOverlay:(id<MKOverlay>)overlay aboveOverlay:(id<MKOverlay>)sibling;
- (void) insertOverlayAboveOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling 
{
    [super insertOverlay:(overlay == JAVA_NULL ? nil : overlay) aboveOverlay:(sibling == JAVA_NULL ? nil : sibling)];
}

// (MKMapView) - (void)insertOverlay:(id<MKOverlay>)overlay belowOverlay:(id<MKOverlay>)sibling;
- (void) insertOverlayBelowOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling 
{
    [super insertOverlay:(overlay == JAVA_NULL ? nil : overlay) belowOverlay:(sibling == JAVA_NULL ? nil : sibling)];
}

// (UIView) - (void)insertSubview:(UIView *)view atIndex:(NSInteger)index;
- (void) insertSubview___crossmobile_ios_uikit_UIView_int:(UIView*) view :(int) index 
{
    [super insertSubview:(view == JAVA_NULL ? nil : view) atIndex:index];
}

// (UIView) - (CGSize)intrinsicContentSize;
- (crossmobile_ios_coregraphics_CGSize*) intrinsicContentSize__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super intrinsicContentSize]];
}

// (UIView) - (void)invalidateIntrinsicContentSize;
- (void) invalidateIntrinsicContentSize__
{
    [super invalidateIntrinsicContentSize];
}

// (UIResponder) - (BOOL)isFirstResponder;
- (BOOL) isFirstResponder__
{
    return [super isFirstResponder];
}

// (UIView) - (void)layoutIfNeeded;
- (void) layoutIfNeeded__
{
    [super layoutIfNeeded];
}

// (UIView) - (void)layoutMarginsDidChange;
- (void) layoutMarginsDidChange__
{
    [super layoutMarginsDidChange];
}

// (UIView) - (void)layoutSubviews;
- (void) layoutSubviews__
{
    [super layoutSubviews];
}

// (MKMapView) - (MKMapRect)mapRectThatFits:(MKMapRect)mapRect;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[super mapRectThatFits:[mapRect getMKMapRect]]];
}

// (MKMapView) - (MKMapRect)mapRectThatFits:(MKMapRect)mapRect edgePadding:(UIEdgeInsets)insets;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[super mapRectThatFits:[mapRect getMKMapRect] edgePadding:[insets getUIEdgeInsets]]];
}

// (UIView) - (BOOL)needsUpdateConstraints;
- (BOOL) needsUpdateConstraints__
{
    return [super needsUpdateConstraints];
}

// (UIResponder) - (UIResponder *)nextResponder;
- (UIResponder*) nextResponder__
{
    UIResponder* re$ult = [super nextResponder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (UIView) - (BOOL)pointInside:(CGPoint)point withEvent:(UIEvent *)event;
- (BOOL) pointInside___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    return [super pointInside:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
}

// (MKMapView) - (MKCoordinateRegion)regionThatFits:(MKCoordinateRegion)region;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) regionThatFits___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region 
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[super regionThatFits:[region getMKCoordinateRegion]]];
}

// (MKMapView) - (void)removeAnnotation:(id<MKAnnotation>)annotation;
- (void) removeAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [super removeAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// (MKMapView) - (void)removeAnnotations:(NSArray<id<MKAnnotation>> *)annotations;
- (void) removeAnnotations___java_util_List:(NSArray*) annotations 
{
    [super removeAnnotations:(annotations == JAVA_NULL ? nil : annotations)];
}

// (UIView) - (void)removeConstraint:(NSLayoutConstraint *)constraint;
- (void) removeConstraint___crossmobile_ios_uikit_NSLayoutConstraint:(NSLayoutConstraint*) constraint 
{
    [super removeConstraint:(constraint == JAVA_NULL ? nil : constraint)];
}

// (UIView) - (void)removeConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;
- (void) removeConstraints___java_util_List:(NSArray*) constraints 
{
    [super removeConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// (UIView) - (void)removeFromSuperview;
- (void) removeFromSuperview__
{
    [super removeFromSuperview];
}

// (UIView) - (void)removeGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;
- (void) removeGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer 
{
    [super removeGestureRecognizer:(gestureRecognizer == JAVA_NULL ? nil : gestureRecognizer)];
}

// (UIView) - (void)removeLayoutGuide:(UILayoutGuide *)layoutGuide;
- (void) removeLayoutGuide___crossmobile_ios_uikit_UILayoutGuide:(UILayoutGuide*) layoutGuide 
{
    [super removeLayoutGuide:(layoutGuide == JAVA_NULL ? nil : layoutGuide)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (MKMapView) - (void)removeOverlay:(id<MKOverlay>)overlay;
- (void) removeOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    [super removeOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// (MKMapView) - (void)removeOverlays:(NSArray<id<MKOverlay>> *)overlays;
- (void) removeOverlays___java_util_List:(NSArray*) overlays 
{
    [super removeOverlays:(overlays == JAVA_NULL ? nil : overlays)];
}

// (UIResponder) - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [super resignFirstResponder];
}

// (MKMapView) - (void)selectAnnotation:(id<MKAnnotation>)annotation animated:(BOOL)animated;
- (void) selectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated 
{
    [super selectAnnotation:(annotation == JAVA_NULL ? nil : annotation) animated:animated];
}

// (UIView) - (void)sendSubviewToBack:(UIView *)view;
- (void) sendSubviewToBack___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super sendSubviewToBack:(view == JAVA_NULL ? nil : view)];
}

// (MKMapView) - (void)setCenterCoordinate:(CLLocationCoordinate2D)coordinate animated:(BOOL)animated;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_boolean:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(BOOL) animated 
{
    [super setCenterCoordinate:[coordinate getCLLocationCoordinate2D] animated:animated];
}

// (UIView) - (void)setContentCompressionResistancePriority:(UILayoutPriority)priority forAxis:(UILayoutConstraintAxis)axis;
- (void) setContentCompressionResistancePriority___float_int:(float) priority :(int) axis 
{
    [super setContentCompressionResistancePriority:priority forAxis:axis];
}

// (UIView) - (void)setContentHuggingPriority:(UILayoutPriority)priority forAxis:(UILayoutConstraintAxis)axis;
- (void) setContentHuggingPriority___float_int:(float) priority :(int) axis 
{
    [super setContentHuggingPriority:priority forAxis:axis];
}

// (UIView) - (void)setNeedsDisplay;
- (void) setNeedsDisplay__
{
    [super setNeedsDisplay];
}

// (UIView) - (void)setNeedsLayout;
- (void) setNeedsLayout__
{
    [super setNeedsLayout];
}

// (UIView) - (void)setNeedsUpdateConstraints;
- (void) setNeedsUpdateConstraints__
{
    [super setNeedsUpdateConstraints];
}

// (MKMapView) - (void)setRegion:(MKCoordinateRegion)region animated:(BOOL)animated;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion_boolean:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(BOOL) animated 
{
    [super setRegion:[region getMKCoordinateRegion] animated:animated];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (MKMapView) - (void)setVisibleMapRect:(MKMapRect)mapRect animated:(BOOL)animate;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(BOOL) animate 
{
    [super setVisibleMapRect:[mapRect getMKMapRect] animated:animate];
}

// (MKMapView) - (void)setVisibleMapRect:(MKMapRect)mapRect edgePadding:(UIEdgeInsets)insets animated:(BOOL)animate;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets :(BOOL) animate 
{
    [super setVisibleMapRect:[mapRect getMKMapRect] edgePadding:[insets getUIEdgeInsets] animated:animate];
}

// (UIView) - (CGSize)sizeThatFits:(CGSize)size;
- (crossmobile_ios_coregraphics_CGSize*) sizeThatFits___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) size 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[super sizeThatFits:[size getCGSize]]];
}

// (UIView) - (void)sizeToFit;
- (void) sizeToFit__
{
    [super sizeToFit];
}

// (UIView) - (void)tintColorDidChange;
- (void) tintColorDidChange__
{
    [super tintColorDidChange];
}

// (UIResponder) - (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesBegan:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesCancelled:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesEnded:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIResponder) - (void)touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesMoved:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIView) - (void)updateConstraints;
- (void) updateConstraints__
{
    [super updateConstraints];
}

// (UIView) - (void)updateConstraintsIfNeeded;
- (void) updateConstraintsIfNeeded__
{
    [super updateConstraintsIfNeeded];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) - (MKAnnotationView *)viewForAnnotation:(id<MKAnnotation>)annotation;
- (MKAnnotationView*) viewForAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    MKAnnotationView* re$ult = [super viewForAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKMapView) - (MKOverlayView *)viewForOverlay:(id<MKOverlay>)overlay;
- (MKOverlayView*) viewForOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    MKOverlayView* re$ult = [super viewForOverlay:(overlay == JAVA_NULL ? nil : overlay)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) - (void)willMoveToSuperview:(UIView *)newSuperview;
- (void) willMoveToSuperview___crossmobile_ios_uikit_UIView:(UIView*) newSuperview 
{
    [super willMoveToSuperview:(newSuperview == JAVA_NULL ? nil : newSuperview)];
}

// (UIView) - (void)willMoveToWindow:(UIWindow *)newWindow;
- (void) willMoveToWindow___crossmobile_ios_uikit_UIWindow:(UIWindow*) newWindow 
{
    [super willMoveToWindow:(newWindow == JAVA_NULL ? nil : newWindow)];
}

// (UIView) - (void)willRemoveSubview:(UIView *)subview;
- (void) willRemoveSubview___crossmobile_ios_uikit_UIView:(UIView*) subview 
{
    [super willRemoveSubview:(subview == JAVA_NULL ? nil : subview)];
}

@end

@implementation MKMapView (cm_crossmobile_ios_mapkit_MKMapView)

// direct binding of: + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKMapView appearance]];
}

// direct binding of: + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKMapView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_mapkit_MKMapView__
{
    return [self init];
}

// direct binding of: - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_mapkit_MKMapView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// direct binding of: @property(nonatomic, readonly) CGRect annotationVisibleRect;
- (crossmobile_ios_coregraphics_CGRect*) annotationVisibleRect__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self annotationVisibleRect]];
}

// direct binding of: @property(nonatomic, readonly) NSArray<id<MKAnnotation>> *annotations;
- (NSArray*) annotations__
{
    NSArray* re$ult = [self annotations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) CLLocationCoordinate2D centerCoordinate;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate 
{
    [self setCenterCoordinate:[centerCoordinate getCLLocationCoordinate2D]];
}

// direct binding of: @property(nonatomic) CLLocationCoordinate2D centerCoordinate;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) centerCoordinate__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self centerCoordinate]];
}

// direct binding of: @property(nonatomic, weak) id<MKMapViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_mapkit_MKMapViewDelegate:(id<MKMapViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, weak) id<MKMapViewDelegate> delegate;
- (id<MKMapViewDelegate>) delegate__
{
    id<MKMapViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) MKMapType mapType;
- (void) setMapType___int:(int) mapType 
{
    [self setMapType:mapType];
}

// direct binding of: @property(nonatomic) MKMapType mapType;
- (int) mapType__
{
    return [self mapType];
}

// direct binding of: @property(nonatomic, readonly) NSArray<id<MKOverlay>> *overlays;
- (NSArray*) overlays__
{
    NSArray* re$ult = [self overlays];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) MKCoordinateRegion region;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region 
{
    [self setRegion:[region getMKCoordinateRegion]];
}

// direct binding of: @property(nonatomic) MKCoordinateRegion region;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) region__
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[self region]];
}

// direct binding of: @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (void) setScrollEnabled___boolean:(BOOL) scrollEnabled 
{
    [self setScrollEnabled:scrollEnabled];
}

// direct binding of: @property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;
- (BOOL) isScrollEnabled__
{
    return [self isScrollEnabled];
}

// direct binding of: @property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;
- (void) setSelectedAnnotations___java_util_List:(NSArray*) selectedAnnotations 
{
    [self setSelectedAnnotations:(selectedAnnotations == JAVA_NULL ? nil : selectedAnnotations)];
}

// direct binding of: @property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;
- (NSArray*) selectedAnnotations__
{
    NSArray* re$ult = [self selectedAnnotations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) BOOL showsUserLocation;
- (void) setShowsUserLocation___boolean:(BOOL) showsUserLocation 
{
    [self setShowsUserLocation:showsUserLocation];
}

// direct binding of: @property(nonatomic) BOOL showsUserLocation;
- (BOOL) showsUserLocation__
{
    return [self showsUserLocation];
}

// direct binding of: @property(nonatomic, readonly) MKUserLocation *userLocation;
- (MKUserLocation*) userLocation__
{
    MKUserLocation* re$ult = [self userLocation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, getter=isUserLocationVisible) BOOL userLocationVisible;
- (BOOL) isUserLocationVisible__
{
    return [self isUserLocationVisible];
}

// direct binding of: @property(nonatomic) MKMapRect visibleMapRect;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) visibleMapRect 
{
    [self setVisibleMapRect:[visibleMapRect getMKMapRect]];
}

// direct binding of: @property(nonatomic) MKMapRect visibleMapRect;
- (crossmobile_ios_mapkit_MKMapRect*) visibleMapRect__
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self visibleMapRect]];
}

// direct binding of: @property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;
- (void) setZoomEnabled___boolean:(BOOL) zoomEnabled 
{
    [self setZoomEnabled:zoomEnabled];
}

// direct binding of: @property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;
- (BOOL) isZoomEnabled__
{
    return [self isZoomEnabled];
}

// direct binding of: - (void)addAnnotation:(id<MKAnnotation>)annotation;
- (void) addAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [self addAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// direct binding of: - (void)addAnnotations:(NSArray<id<MKAnnotation>> *)annotations;
- (void) addAnnotations___java_util_List:(NSArray*) annotations 
{
    [self addAnnotations:(annotations == JAVA_NULL ? nil : annotations)];
}

// direct binding of: - (void)addOverlay:(id<MKOverlay>)overlay;
- (void) addOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    [self addOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// direct binding of: - (void)addOverlays:(NSArray<id<MKOverlay>> *)overlays;
- (void) addOverlays___java_util_List:(NSArray*) overlays 
{
    [self addOverlays:(overlays == JAVA_NULL ? nil : overlays)];
}

// direct binding of: - (NSSet<id<MKAnnotation>> *)annotationsInMapRect:(MKMapRect)mapRect;
- (NSSet*) annotationsInMapRect___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    NSSet* re$ult = [self annotationsInMapRect:[mapRect getMKMapRect]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (CGPoint)convertCoordinate:(CLLocationCoordinate2D)coordinate toPointToView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) convertCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_crossmobile_ios_uikit_UIView:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self convertCoordinate:[coordinate getCLLocationCoordinate2D] toPointToView:(view == JAVA_NULL ? nil : view)]];
}

// direct binding of: - (CLLocationCoordinate2D)convertPoint:(CGPoint)point toCoordinateFromView:(UIView *)view;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) convertPoint___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGPoint*) point :(UIView*) view 
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self convertPoint:[point getCGPoint] toCoordinateFromView:(view == JAVA_NULL ? nil : view)]];
}

// direct binding of: - (MKCoordinateRegion)convertRect:(CGRect)rect toRegionFromView:(UIView *)view;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) convertRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view 
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[self convertRect:[rect getCGRect] toRegionFromView:(view == JAVA_NULL ? nil : view)]];
}

// direct binding of: - (CGRect)convertRegion:(MKCoordinateRegion)region toRectToView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGRect*) convertRegion___crossmobile_ios_mapkit_MKCoordinateRegion_crossmobile_ios_uikit_UIView:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self convertRegion:[region getMKCoordinateRegion] toRectToView:(view == JAVA_NULL ? nil : view)]];
}

// direct binding of: - (MKAnnotationView *)dequeueReusableAnnotationViewWithIdentifier:(NSString *)identifier;
- (MKAnnotationView*) dequeueReusableAnnotationViewWithIdentifier___java_lang_String:(NSString*) identifier 
{
    MKAnnotationView* re$ult = [self dequeueReusableAnnotationViewWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)deselectAnnotation:(id<MKAnnotation>)annotation animated:(BOOL)animated;
- (void) deselectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated 
{
    [self deselectAnnotation:(annotation == JAVA_NULL ? nil : annotation) animated:animated];
}

// direct binding of: - (void)exchangeOverlayAtIndex:(NSUInteger)index1 withOverlayAtIndex:(NSUInteger)index2;
- (void) exchangeOverlayAtIndex___int_int:(int) index1 :(int) index2 
{
    [self exchangeOverlayAtIndex:index1 withOverlayAtIndex:index2];
}

// direct binding of: - (void)insertOverlay:(id<MKOverlay>)overlay atIndex:(NSUInteger)index;
- (void) insertOverlay___crossmobile_ios_mapkit_MKOverlay_int:(id<MKOverlay>) overlay :(int) index 
{
    [self insertOverlay:(overlay == JAVA_NULL ? nil : overlay) atIndex:index];
}

// direct binding of: - (void)insertOverlay:(id<MKOverlay>)overlay aboveOverlay:(id<MKOverlay>)sibling;
- (void) insertOverlayAboveOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling 
{
    [self insertOverlay:(overlay == JAVA_NULL ? nil : overlay) aboveOverlay:(sibling == JAVA_NULL ? nil : sibling)];
}

// direct binding of: - (void)insertOverlay:(id<MKOverlay>)overlay belowOverlay:(id<MKOverlay>)sibling;
- (void) insertOverlayBelowOverlay___crossmobile_ios_mapkit_MKOverlay_crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay :(id<MKOverlay>) sibling 
{
    [self insertOverlay:(overlay == JAVA_NULL ? nil : overlay) belowOverlay:(sibling == JAVA_NULL ? nil : sibling)];
}

// direct binding of: - (MKMapRect)mapRectThatFits:(MKMapRect)mapRect;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect:(crossmobile_ios_mapkit_MKMapRect*) mapRect 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self mapRectThatFits:[mapRect getMKMapRect]]];
}

// direct binding of: - (MKMapRect)mapRectThatFits:(MKMapRect)mapRect edgePadding:(UIEdgeInsets)insets;
- (crossmobile_ios_mapkit_MKMapRect*) mapRectThatFits___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets 
{
    return [[crossmobile_ios_mapkit_MKMapRect alloc] initWithMKMapRect:[self mapRectThatFits:[mapRect getMKMapRect] edgePadding:[insets getUIEdgeInsets]]];
}

// direct binding of: - (MKCoordinateRegion)regionThatFits:(MKCoordinateRegion)region;
- (crossmobile_ios_mapkit_MKCoordinateRegion*) regionThatFits___crossmobile_ios_mapkit_MKCoordinateRegion:(crossmobile_ios_mapkit_MKCoordinateRegion*) region 
{
    return [[crossmobile_ios_mapkit_MKCoordinateRegion alloc] initWithMKCoordinateRegion:[self regionThatFits:[region getMKCoordinateRegion]]];
}

// direct binding of: - (void)removeAnnotation:(id<MKAnnotation>)annotation;
- (void) removeAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [self removeAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// direct binding of: - (void)removeAnnotations:(NSArray<id<MKAnnotation>> *)annotations;
- (void) removeAnnotations___java_util_List:(NSArray*) annotations 
{
    [self removeAnnotations:(annotations == JAVA_NULL ? nil : annotations)];
}

// direct binding of: - (void)removeOverlay:(id<MKOverlay>)overlay;
- (void) removeOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    [self removeOverlay:(overlay == JAVA_NULL ? nil : overlay)];
}

// direct binding of: - (void)removeOverlays:(NSArray<id<MKOverlay>> *)overlays;
- (void) removeOverlays___java_util_List:(NSArray*) overlays 
{
    [self removeOverlays:(overlays == JAVA_NULL ? nil : overlays)];
}

// direct binding of: - (void)selectAnnotation:(id<MKAnnotation>)annotation animated:(BOOL)animated;
- (void) selectAnnotation___crossmobile_ios_mapkit_MKAnnotation_boolean:(id<MKAnnotation>) annotation :(BOOL) animated 
{
    [self selectAnnotation:(annotation == JAVA_NULL ? nil : annotation) animated:animated];
}

// direct binding of: - (void)setCenterCoordinate:(CLLocationCoordinate2D)coordinate animated:(BOOL)animated;
- (void) setCenterCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D_boolean:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate :(BOOL) animated 
{
    [self setCenterCoordinate:[coordinate getCLLocationCoordinate2D] animated:animated];
}

// direct binding of: - (void)setRegion:(MKCoordinateRegion)region animated:(BOOL)animated;
- (void) setRegion___crossmobile_ios_mapkit_MKCoordinateRegion_boolean:(crossmobile_ios_mapkit_MKCoordinateRegion*) region :(BOOL) animated 
{
    [self setRegion:[region getMKCoordinateRegion] animated:animated];
}

// direct binding of: - (void)setVisibleMapRect:(MKMapRect)mapRect animated:(BOOL)animate;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(BOOL) animate 
{
    [self setVisibleMapRect:[mapRect getMKMapRect] animated:animate];
}

// direct binding of: - (void)setVisibleMapRect:(MKMapRect)mapRect edgePadding:(UIEdgeInsets)insets animated:(BOOL)animate;
- (void) setVisibleMapRect___crossmobile_ios_mapkit_MKMapRect_crossmobile_ios_uikit_UIEdgeInsets_boolean:(crossmobile_ios_mapkit_MKMapRect*) mapRect :(crossmobile_ios_uikit_UIEdgeInsets*) insets :(BOOL) animate 
{
    [self setVisibleMapRect:[mapRect getMKMapRect] edgePadding:[insets getUIEdgeInsets] animated:animate];
}

// direct binding of: - (MKAnnotationView *)viewForAnnotation:(id<MKAnnotation>)annotation;
- (MKAnnotationView*) viewForAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    MKAnnotationView* re$ult = [self viewForAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (MKOverlayView *)viewForOverlay:(id<MKOverlay>)overlay;
- (MKOverlayView*) viewForOverlay___crossmobile_ios_mapkit_MKOverlay:(id<MKOverlay>) overlay 
{
    MKOverlayView* re$ult = [self viewForOverlay:(overlay == JAVA_NULL ? nil : overlay)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
