// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UISlider implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutDimension.h"
#import "crossmobile_ios_uikit_NSLayoutXAxisAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIControlDelegate.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UILayoutGuide.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UISlider.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UISlider$Ext

// (UIControl) @property(nonatomic, readonly) NSSet *allTargets;
- (NSSet*) allTargets__
{
    NSSet* re$ult = [super allTargets];
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

// (UIControl) @property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;
- (void) setContentHorizontalAlignment___int:(int) contentHorizontalAlignment 
{
    [super setContentHorizontalAlignment:contentHorizontalAlignment];
}

// (UIControl) @property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;
- (int) contentHorizontalAlignment__
{
    return [super contentHorizontalAlignment];
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

// (UIControl) @property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;
- (void) setContentVerticalAlignment___int:(int) contentVerticalAlignment 
{
    [super setContentVerticalAlignment:contentVerticalAlignment];
}

// (UIControl) @property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;
- (int) contentVerticalAlignment__
{
    return [super contentVerticalAlignment];
}

// (UISlider) @property(nonatomic, getter=isContinuous) BOOL continuous;
- (void) setContinuous___boolean:(BOOL) continuous 
{
    [super setContinuous:continuous];
}

// (UISlider) @property(nonatomic, getter=isContinuous) BOOL continuous;
- (BOOL) isContinuous__
{
    return [super isContinuous];
}

// (UISlider) @property(nonatomic, readonly) UIImage *currentMaximumTrackImage;
- (UIImage*) currentMaximumTrackImage__
{
    UIImage* re$ult = [super currentMaximumTrackImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISlider) @property(nonatomic, readonly) UIImage *currentMinimumTrackImage;
- (UIImage*) currentMinimumTrackImage__
{
    UIImage* re$ult = [super currentMinimumTrackImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISlider) @property(nonatomic, readonly) UIImage *currentThumbImage;
- (UIImage*) currentThumbImage__
{
    UIImage* re$ult = [super currentThumbImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIControl) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIControl) @property(nonatomic, getter=isEnabled) BOOL enabled;
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

// (UIControl) @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [super setHighlighted:highlighted];
}

// (UIControl) @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [super isHighlighted];
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

// (UISlider) @property(nonatomic, strong) UIColor *maximumTrackTintColor;
- (void) setMaximumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) maximumTrackTintColor 
{
    [super setMaximumTrackTintColor:(maximumTrackTintColor == JAVA_NULL ? nil : maximumTrackTintColor)];
}

// (UISlider) @property(nonatomic, strong) UIColor *maximumTrackTintColor;
- (UIColor*) maximumTrackTintColor__
{
    UIColor* re$ult = [super maximumTrackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISlider) @property(nonatomic) float maximumValue;
- (void) setMaximumValue___float:(float) maximumValue 
{
    [super setMaximumValue:maximumValue];
}

// (UISlider) @property(nonatomic) float maximumValue;
- (float) maximumValue__
{
    return [super maximumValue];
}

// (UISlider) @property(nonatomic, strong) UIImage *maximumValueImage;
- (void) setMaximumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) maximumValueImage 
{
    [super setMaximumValueImage:(maximumValueImage == JAVA_NULL ? nil : maximumValueImage)];
}

// (UISlider) @property(nonatomic, strong) UIImage *maximumValueImage;
- (UIImage*) maximumValueImage__
{
    UIImage* re$ult = [super maximumValueImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISlider) @property(nonatomic, strong) UIColor *minimumTrackTintColor;
- (void) setMinimumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) minimumTrackTintColor 
{
    [super setMinimumTrackTintColor:(minimumTrackTintColor == JAVA_NULL ? nil : minimumTrackTintColor)];
}

// (UISlider) @property(nonatomic, strong) UIColor *minimumTrackTintColor;
- (UIColor*) minimumTrackTintColor__
{
    UIColor* re$ult = [super minimumTrackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISlider) @property(nonatomic) float minimumValue;
- (void) setMinimumValue___float:(float) minimumValue 
{
    [super setMinimumValue:minimumValue];
}

// (UISlider) @property(nonatomic) float minimumValue;
- (float) minimumValue__
{
    return [super minimumValue];
}

// (UISlider) @property(nonatomic, strong) UIImage *minimumValueImage;
- (void) setMinimumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) minimumValueImage 
{
    [super setMinimumValueImage:(minimumValueImage == JAVA_NULL ? nil : minimumValueImage)];
}

// (UISlider) @property(nonatomic, strong) UIImage *minimumValueImage;
- (UIImage*) minimumValueImage__
{
    UIImage* re$ult = [super minimumValueImage];
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

// (UIControl) @property(nonatomic, getter=isSelected) BOOL selected;
- (void) setSelected___boolean:(BOOL) selected 
{
    [super setSelected:selected];
}

// (UIControl) @property(nonatomic, getter=isSelected) BOOL selected;
- (BOOL) isSelected__
{
    return [super isSelected];
}

// (UIControl) @property(nonatomic, readonly) UIControlState state;
- (int) state__
{
    return [super state];
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

// (UISlider) @property(nonatomic, strong) UIColor *thumbTintColor;
- (void) setThumbTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) thumbTintColor 
{
    [super setThumbTintColor:(thumbTintColor == JAVA_NULL ? nil : thumbTintColor)];
}

// (UISlider) @property(nonatomic, strong) UIColor *thumbTintColor;
- (UIColor*) thumbTintColor__
{
    UIColor* re$ult = [super thumbTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (UISlider) @property(nonatomic) float value;
- (void) setValue___float:(float) value 
{
    [super setValue:value];
}

// (UISlider) @property(nonatomic) float value;
- (float) value__
{
    return [super value];
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

// (UIView) - (void)addSubview:(UIView *)view;
- (void) addSubview___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    [super addSubview:(view == JAVA_NULL ? nil : view)];
}

// (UIControl) - (void)addTarget:(id)target action:(SEL)action forControlEvents:(UIControlEvents)controlEvents;
- (void) addTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents 
{
    if (target == JAVA_NULL)
        return;
    if (controlEvents == 0)
        return;
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super addTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent::) forControlEvents:controlEvents];
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

// (UISlider) - (UIImage *)maximumTrackImageForState:(UIControlState)state;
- (UIImage*) maximumTrackImageForState___int:(int) state 
{
    UIImage* re$ult = [super maximumTrackImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UISlider) - (UIImage *)minimumTrackImageForState:(UIControlState)state;
- (UIImage*) minimumTrackImageForState___int:(int) state 
{
    UIImage* re$ult = [super minimumTrackImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (UIView) - (BOOL)pointInside:(CGPoint)point withEvent:(UIEvent *)event;
- (BOOL) pointInside___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIEvent:(crossmobile_ios_coregraphics_CGPoint*) point :(UIEvent*) event 
{
    return [super pointInside:[point getCGPoint] withEvent:(event == JAVA_NULL ? nil : event)];
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

// (UIControl) - (void)removeTarget:(id)target action:(SEL)action forControlEvents:(UIControlEvents)controlEvents;
- (void) removeTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents 
{
    if (target == JAVA_NULL)
        return;
    if (controlEvents == 0)
        return;
    objc_setAssociatedObject(self, (void*)target, nil, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super removeTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___crossmobile_ios_uikit_UIControl_crossmobile_ios_uikit_UIEvent::) forControlEvents:controlEvents];
}

// (UIResponder) - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [super resignFirstResponder];
}

// (UIControl) - (void)sendActionsForControlEvents:(UIControlEvents)controlEvents;
- (void) sendActionsForControlEvents___int:(int) controlEvents 
{
    [super sendActionsForControlEvents:controlEvents];
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

// (UISlider) - (void)setMaximumTrackImage:(UIImage *)image forState:(UIControlState)state;
- (void) setMaximumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [super setMaximumTrackImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// (UISlider) - (void)setMinimumTrackImage:(UIImage *)image forState:(UIControlState)state;
- (void) setMinimumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [super setMinimumTrackImage:(image == JAVA_NULL ? nil : image) forState:state];
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

// (UISlider) - (void)setThumbImage:(UIImage *)image forState:(UIControlState)state;
- (void) setThumbImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [super setThumbImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// (UISlider) - (void)setValue:(float)value animated:(BOOL)animated;
- (void) setValue___float_boolean:(float) value :(BOOL) animated 
{
    [super setValue:value animated:animated];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
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

// (UISlider) - (UIImage *)thumbImageForState:(UIControlState)state;
- (UIImage*) thumbImageForState___int:(int) state 
{
    UIImage* re$ult = [super thumbImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation UISlider (cm_crossmobile_ios_uikit_UISlider)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISlider__
{
    return [self init];
}

// direct binding of: - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UISlider___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// direct binding of: @property(nonatomic, getter=isContinuous) BOOL continuous;
- (void) setContinuous___boolean:(BOOL) continuous 
{
    [self setContinuous:continuous];
}

// direct binding of: @property(nonatomic, getter=isContinuous) BOOL continuous;
- (BOOL) isContinuous__
{
    return [self isContinuous];
}

// direct binding of: @property(nonatomic, readonly) UIImage *currentMaximumTrackImage;
- (UIImage*) currentMaximumTrackImage__
{
    UIImage* re$ult = [self currentMaximumTrackImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIImage *currentMinimumTrackImage;
- (UIImage*) currentMinimumTrackImage__
{
    UIImage* re$ult = [self currentMinimumTrackImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIImage *currentThumbImage;
- (UIImage*) currentThumbImage__
{
    UIImage* re$ult = [self currentThumbImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, strong) UIColor *maximumTrackTintColor;
- (void) setMaximumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) maximumTrackTintColor 
{
    [self setMaximumTrackTintColor:(maximumTrackTintColor == JAVA_NULL ? nil : maximumTrackTintColor)];
}

// direct binding of: @property(nonatomic, strong) UIColor *maximumTrackTintColor;
- (UIColor*) maximumTrackTintColor__
{
    UIColor* re$ult = [self maximumTrackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) float maximumValue;
- (void) setMaximumValue___float:(float) maximumValue 
{
    [self setMaximumValue:maximumValue];
}

// direct binding of: @property(nonatomic) float maximumValue;
- (float) maximumValue__
{
    return [self maximumValue];
}

// direct binding of: @property(nonatomic, strong) UIImage *maximumValueImage;
- (void) setMaximumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) maximumValueImage 
{
    [self setMaximumValueImage:(maximumValueImage == JAVA_NULL ? nil : maximumValueImage)];
}

// direct binding of: @property(nonatomic, strong) UIImage *maximumValueImage;
- (UIImage*) maximumValueImage__
{
    UIImage* re$ult = [self maximumValueImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, strong) UIColor *minimumTrackTintColor;
- (void) setMinimumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) minimumTrackTintColor 
{
    [self setMinimumTrackTintColor:(minimumTrackTintColor == JAVA_NULL ? nil : minimumTrackTintColor)];
}

// direct binding of: @property(nonatomic, strong) UIColor *minimumTrackTintColor;
- (UIColor*) minimumTrackTintColor__
{
    UIColor* re$ult = [self minimumTrackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) float minimumValue;
- (void) setMinimumValue___float:(float) minimumValue 
{
    [self setMinimumValue:minimumValue];
}

// direct binding of: @property(nonatomic) float minimumValue;
- (float) minimumValue__
{
    return [self minimumValue];
}

// direct binding of: @property(nonatomic, strong) UIImage *minimumValueImage;
- (void) setMinimumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) minimumValueImage 
{
    [self setMinimumValueImage:(minimumValueImage == JAVA_NULL ? nil : minimumValueImage)];
}

// direct binding of: @property(nonatomic, strong) UIImage *minimumValueImage;
- (UIImage*) minimumValueImage__
{
    UIImage* re$ult = [self minimumValueImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, strong) UIColor *thumbTintColor;
- (void) setThumbTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) thumbTintColor 
{
    [self setThumbTintColor:(thumbTintColor == JAVA_NULL ? nil : thumbTintColor)];
}

// direct binding of: @property(nonatomic, strong) UIColor *thumbTintColor;
- (UIColor*) thumbTintColor__
{
    UIColor* re$ult = [self thumbTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) float value;
- (void) setValue___float:(float) value 
{
    [self setValue:value];
}

// direct binding of: @property(nonatomic) float value;
- (float) value__
{
    return [self value];
}

// direct binding of: - (UIImage *)maximumTrackImageForState:(UIControlState)state;
- (UIImage*) maximumTrackImageForState___int:(int) state 
{
    UIImage* re$ult = [self maximumTrackImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (UIImage *)minimumTrackImageForState:(UIControlState)state;
- (UIImage*) minimumTrackImageForState___int:(int) state 
{
    UIImage* re$ult = [self minimumTrackImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)setMaximumTrackImage:(UIImage *)image forState:(UIControlState)state;
- (void) setMaximumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setMaximumTrackImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// direct binding of: - (void)setMinimumTrackImage:(UIImage *)image forState:(UIControlState)state;
- (void) setMinimumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setMinimumTrackImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// direct binding of: - (void)setThumbImage:(UIImage *)image forState:(UIControlState)state;
- (void) setThumbImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setThumbImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// direct binding of: - (void)setValue:(float)value animated:(BOOL)animated;
- (void) setValue___float_boolean:(float) value :(BOOL) animated 
{
    [self setValue:value animated:animated];
}

// direct binding of: - (UIImage *)thumbImageForState:(UIControlState)state;
- (UIImage*) thumbImageForState___int:(int) state 
{
    UIImage* re$ult = [self thumbImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
