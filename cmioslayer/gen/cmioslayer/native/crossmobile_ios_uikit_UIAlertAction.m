// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIAlertAction implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UIAlertAction.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIAlertAction$Ext

// (UIAlertAction) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIAlertAction) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
}

// (UIAlertAction) @property(nonatomic, readonly) UIAlertActionStyle style;
- (int) style__
{
    return [super style];
}

// (UIAlertAction) @property(nonatomic, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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

@implementation UIAlertAction (cm_crossmobile_ios_uikit_UIAlertAction)

// direct binding of: + (instancetype)actionWithTitle:(NSString *)title style:(UIAlertActionStyle)style handler:(void (^)(UIAlertAction *action))handler;
+ (instancetype) actionWithTitle___java_lang_String_int_org_robovm_objc_block_VoidBlock1:(NSString*) title :(int) style :(id<org_robovm_objc_block_VoidBlock1>) handler 
{
    id re$ult = [UIAlertAction actionWithTitle:(title == JAVA_NULL ? nil : title) style:style handler:(handler == JAVA_NULL ? nil : ^(UIAlertAction* action) {
        [handler invoke___java_lang_Object:(action ? action : JAVA_NULL)];
    })];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [self setEnabled:enabled];
}

// direct binding of: @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [self isEnabled];
}

// direct binding of: @property(nonatomic, readonly) UIAlertActionStyle style;
- (int) style__
{
    return [self style];
}

// direct binding of: @property(nonatomic, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
