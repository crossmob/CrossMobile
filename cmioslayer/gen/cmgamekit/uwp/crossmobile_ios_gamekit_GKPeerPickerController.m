// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.gamekit.GKPeerPickerController implementation

#import "crossmobile_ios_gamekit_GKPeerPickerController.h"
#import "crossmobile_ios_gamekit_GKPeerPickerControllerDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_gamekit_GKPeerPickerController$Ext

// (GKPeerPickerController) @property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;
- (void) setConnectionTypesMask___int:(int) connectionTypesMask 
{
    [super setConnectionTypesMask:connectionTypesMask];
}

// (GKPeerPickerController) @property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;
- (int) connectionTypesMask__
{
    return [super connectionTypesMask];
}

// (GKPeerPickerController) @property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_gamekit_GKPeerPickerControllerDelegate:(id<GKPeerPickerControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (GKPeerPickerController) @property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;
- (id<GKPeerPickerControllerDelegate>) delegate__
{
    id<GKPeerPickerControllerDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (GKPeerPickerController) @property(nonatomic, readonly, getter=isVisible) BOOL visible;
- (BOOL) isVisible__
{
    return [super isVisible];
}

// (GKPeerPickerController) - (void)dismiss;
- (void) dismiss__
{
    [super dismiss];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (GKPeerPickerController) - (void)show;
- (void) show__
{
    [super show];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation GKPeerPickerController (cm_crossmobile_ios_gamekit_GKPeerPickerController)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_gamekit_GKPeerPickerController__
{
    return [self init];
}

// direct binding of: @property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;
- (void) setConnectionTypesMask___int:(int) connectionTypesMask 
{
    [self setConnectionTypesMask:connectionTypesMask];
}

// direct binding of: @property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;
- (int) connectionTypesMask__
{
    return [self connectionTypesMask];
}

// direct binding of: @property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_gamekit_GKPeerPickerControllerDelegate:(id<GKPeerPickerControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;
- (id<GKPeerPickerControllerDelegate>) delegate__
{
    id<GKPeerPickerControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, getter=isVisible) BOOL visible;
- (BOOL) isVisible__
{
    return [self isVisible];
}

// direct binding of: - (void)dismiss;
- (void) dismiss__
{
    [self dismiss];
}

// direct binding of: - (void)show;
- (void) show__
{
    [self show];
}

@end
