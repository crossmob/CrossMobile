// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UITouch implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_uikit_UITouch.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UITouch$Ext

// (UITouch) @property(nonatomic, readonly) UITouchPhase phase;
- (int) phase__
{
    return [super phase];
}

// (UITouch) @property(nonatomic, readonly) NSUInteger tapCount;
- (int) tapCount__
{
    return [super tapCount];
}

// (UITouch) @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [super timestamp];
}

// (UITouch) @property(nonatomic, readonly, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [super view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UITouch) @property(nonatomic, readonly, strong) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [super window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UITouch) - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super locationInView:(view == JAVA_NULL ? nil : view)]];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UITouch (cm_crossmobile_ios_uikit_UITouch)

// direct binding of: @property(nonatomic, readonly) UITouchPhase phase;
- (int) phase__
{
    return [self phase];
}

// direct binding of: @property(nonatomic, readonly) NSUInteger tapCount;
- (int) tapCount__
{
    return [self tapCount];
}

// direct binding of: @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// direct binding of: @property(nonatomic, readonly, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [self view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [self window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self locationInView:(view == JAVA_NULL ? nil : view)]];
}

@end
