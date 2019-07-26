// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mapkit.MKPinAnnotationView implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_mapkit_MKAnnotation.h"
#import "crossmobile_ios_mapkit_MKPinAnnotationView.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"
#import "crossmobile_ios_uikit_NSLayoutXAxisAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIImage.h"
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

@implementation crossmobile_ios_mapkit_MKPinAnnotationView$Ext

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

// (MKPinAnnotationView) @property(nonatomic) BOOL animatesDrop;
- (void) setAnimatesDrop___boolean:(BOOL) animatesDrop 
{
    [super setAnimatesDrop:animatesDrop];
}

// (MKPinAnnotationView) @property(nonatomic) BOOL animatesDrop;
- (BOOL) animatesDrop__
{
    return [super animatesDrop];
}

// (MKAnnotationView) @property(nonatomic, strong) id<MKAnnotation> annotation;
- (void) setAnnotation___crossmobile_ios_mapkit_MKAnnotation:(id<MKAnnotation>) annotation 
{
    [super setAnnotation:(annotation == JAVA_NULL ? nil : annotation)];
}

// (MKAnnotationView) @property(nonatomic, strong) id<MKAnnotation> annotation;
- (id<MKAnnotation>) annotation__
{
    id<MKAnnotation> re$ult = [super annotation];
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

// (MKAnnotationView) @property(nonatomic) CGPoint calloutOffset;
- (void) setCalloutOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) calloutOffset 
{
    [super setCalloutOffset:[calloutOffset getCGPoint]];
}

// (MKAnnotationView) @property(nonatomic) CGPoint calloutOffset;
- (crossmobile_ios_coregraphics_CGPoint*) calloutOffset__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super calloutOffset]];
}

// (MKAnnotationView) @property(nonatomic) BOOL canShowCallout;
- (void) setCanShowCallout___boolean:(BOOL) canShowCallout 
{
    [super setCanShowCallout:canShowCallout];
}

// (MKAnnotationView) @property(nonatomic) BOOL canShowCallout;
- (BOOL) canShowCallout__
{
    return [super canShowCallout];
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

// (MKAnnotationView) @property(nonatomic) CGPoint centerOffset;
- (void) setCenterOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) centerOffset 
{
    [super setCenterOffset:[centerOffset getCGPoint]];
}

// (MKAnnotationView) @property(nonatomic) CGPoint centerOffset;
- (crossmobile_ios_coregraphics_CGPoint*) centerOffset__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super centerOffset]];
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

// (MKAnnotationView) @property(nonatomic) MKAnnotationViewDragState dragState;
- (void) setDragState___int:(int) dragState 
{
    [super setDragState:dragState];
}

// (MKAnnotationView) @property(nonatomic) MKAnnotationViewDragState dragState;
- (int) dragState__
{
    return [super dragState];
}

// (MKAnnotationView) @property(nonatomic, getter=isDraggable) BOOL draggable;
- (void) setDraggable___boolean:(BOOL) draggable 
{
    [super setDraggable:draggable];
}

// (MKAnnotationView) @property(nonatomic, getter=isDraggable) BOOL draggable;
- (BOOL) isDraggable__
{
    return [super isDraggable];
}

// (MKAnnotationView) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (MKAnnotationView) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
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

// (MKAnnotationView) @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [super setHighlighted:highlighted];
}

// (MKAnnotationView) @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [super isHighlighted];
}

// (MKAnnotationView) @property(nonatomic, strong) UIImage *image;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    [super setImage:(image == JAVA_NULL ? nil : image)];
}

// (MKAnnotationView) @property(nonatomic, strong) UIImage *image;
- (UIImage*) image__
{
    UIImage* re$ult = [super image];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (MKAnnotationView) @property(strong, nonatomic) UIView *leftCalloutAccessoryView;
- (void) setLeftCalloutAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) leftCalloutAccessoryView 
{
    [super setLeftCalloutAccessoryView:(leftCalloutAccessoryView == JAVA_NULL ? nil : leftCalloutAccessoryView)];
}

// (MKAnnotationView) @property(strong, nonatomic) UIView *leftCalloutAccessoryView;
- (UIView*) leftCalloutAccessoryView__
{
    UIView* re$ult = [super leftCalloutAccessoryView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (MKPinAnnotationView) @property(nonatomic) MKPinAnnotationColor pinColor;
- (void) setPinColor___int:(int) pinColor 
{
    [super setPinColor:pinColor];
}

// (MKPinAnnotationView) @property(nonatomic) MKPinAnnotationColor pinColor;
- (int) pinColor__
{
    return [super pinColor];
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

// (MKAnnotationView) @property(nonatomic, readonly) NSString *reuseIdentifier;
- (NSString*) reuseIdentifier__
{
    NSString* re$ult = [super reuseIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIView) @property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;
- (NSLayoutXAxisAnchor*) rightAnchor__
{
    NSLayoutXAxisAnchor* re$ult = [super rightAnchor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MKAnnotationView) @property(strong, nonatomic) UIView *rightCalloutAccessoryView;
- (void) setRightCalloutAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) rightCalloutAccessoryView 
{
    [super setRightCalloutAccessoryView:(rightCalloutAccessoryView == JAVA_NULL ? nil : rightCalloutAccessoryView)];
}

// (MKAnnotationView) @property(strong, nonatomic) UIView *rightCalloutAccessoryView;
- (UIView*) rightCalloutAccessoryView__
{
    UIView* re$ult = [super rightCalloutAccessoryView];
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

// (MKAnnotationView) @property(nonatomic, getter=isSelected) BOOL selected;
- (void) setSelected___boolean:(BOOL) selected 
{
    [super setSelected:selected];
}

// (MKAnnotationView) @property(nonatomic, getter=isSelected) BOOL selected;
- (BOOL) isSelected__
{
    return [super isSelected];
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

// (UIView) - (void)addSubview:(UIView *)view;
- (void) addSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super addSubview:(view == JAVA_NULL ? nil : view)];
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

// (UIView) - (UIView *)hitTest:(CGPoint)point withEvent:(UIEvent *)event;
- (UIView*) hitTest___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    UIView* re$ult = [super hitTest:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (MKAnnotationView) - (void)prepareForReuse;
- (void) prepareForReuse__
{
    [super prepareForReuse];
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

// (UIResponder) - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [super resignFirstResponder];
}

// (UIView) - (void)sendSubviewToBack:(UIView *)view;
- (void) sendSubviewToBack___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super sendSubviewToBack:(view == JAVA_NULL ? nil : view)];
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

// (MKAnnotationView) - (void)setDragState:(MKAnnotationViewDragState)newDragState animated:(BOOL)animated;
- (void) setDragState___int_boolean:(int) newDragState :(BOOL) animated 
{
    [super setDragState:newDragState animated:animated];
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

// (MKAnnotationView) - (void)setSelected:(BOOL)selected animated:(BOOL)animated;
- (void) setSelected___boolean_boolean:(BOOL) selected :(BOOL) animated 
{
    [super setSelected:selected animated:animated];
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

@implementation MKPinAnnotationView (cm_crossmobile_ios_mapkit_MKPinAnnotationView)

// direct binding of: + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKPinAnnotationView appearance]];
}

// direct binding of: + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MKPinAnnotationView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// direct binding of: - (instancetype)initWithAnnotation:(id<MKAnnotation>)annotation reuseIdentifier:(NSString *)reuseIdentifier;
- (instancetype) __init_crossmobile_ios_mapkit_MKPinAnnotationView___crossmobile_ios_mapkit_MKAnnotation_java_lang_String:(id<MKAnnotation>) annotation :(NSString*) reuseIdentifier 
{
    return [self initWithAnnotation:(annotation == JAVA_NULL ? nil : annotation) reuseIdentifier:(reuseIdentifier == JAVA_NULL ? nil : reuseIdentifier)];
}

// direct binding of: @property(nonatomic) BOOL animatesDrop;
- (void) setAnimatesDrop___boolean:(BOOL) animatesDrop 
{
    [self setAnimatesDrop:animatesDrop];
}

// direct binding of: @property(nonatomic) BOOL animatesDrop;
- (BOOL) animatesDrop__
{
    return [self animatesDrop];
}

// direct binding of: @property(nonatomic) MKPinAnnotationColor pinColor;
- (void) setPinColor___int:(int) pinColor 
{
    [self setPinColor:pinColor];
}

// direct binding of: @property(nonatomic) MKPinAnnotationColor pinColor;
- (int) pinColor__
{
    return [self pinColor];
}

@end
