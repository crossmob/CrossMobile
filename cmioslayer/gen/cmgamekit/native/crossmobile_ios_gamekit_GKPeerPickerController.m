// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.gamekit.GKPeerPickerController implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_gamekit_GKPeerPickerController.h"
#import "crossmobile_ios_gamekit_GKPeerPickerControllerDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

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

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (GKPeerPickerController) - (void)dismiss;
- (void) dismiss__
{
    [super dismiss];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
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

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
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
