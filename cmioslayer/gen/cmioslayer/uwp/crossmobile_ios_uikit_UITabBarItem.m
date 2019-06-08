// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UITabBarItem implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UITabBarItem$Ext

// (UITabBarItem) @property(nonatomic, copy) NSString *badgeValue;
- (void) setBadgeValue___java_lang_String:(NSString*) badgeValue 
{
    [super setBadgeValue:(badgeValue == JAVA_NULL ? nil : badgeValue)];
}

// (UITabBarItem) @property(nonatomic, copy) NSString *badgeValue;
- (NSString*) badgeValue__
{
    NSString* re$ult = [super badgeValue];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarItem) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIBarItem) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
}

// (UIBarItem) @property(nonatomic, strong) UIImage *image;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    [super setImage:(image == JAVA_NULL ? nil : image)];
}

// (UIBarItem) @property(nonatomic, strong) UIImage *image;
- (UIImage*) image__
{
    UIImage* re$ult = [super image];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIBarItem) @property(nonatomic) UIEdgeInsets imageInsets;
- (void) setImageInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageInsets 
{
    [super setImageInsets:[imageInsets getUIEdgeInsets]];
}

// (UIBarItem) @property(nonatomic) UIEdgeInsets imageInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[super imageInsets]];
}

// (UIBarItem) @property(nonatomic) NSInteger tag;
- (void) setTag___int:(int) tag 
{
    [super setTag:tag];
}

// (UIBarItem) @property(nonatomic) NSInteger tag;
- (int) tag__
{
    return [super tag];
}

// (UIBarItem) @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
}

// (UIBarItem) @property(nonatomic, copy) NSString *title;
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

@implementation UITabBarItem (cm_crossmobile_ios_uikit_UITabBarItem)

// direct binding of: - (instancetype)initWithTitle:(NSString *)title image:(UIImage *)image tag:(NSInteger)tag;
- (instancetype) __init_crossmobile_ios_uikit_UITabBarItem___java_lang_String_crossmobile_ios_uikit_UIImage_int:(NSString*) title :(UIImage*) image :(int) tag 
{
    return [self initWithTitle:(title == JAVA_NULL ? nil : title) image:(image == JAVA_NULL ? nil : image) tag:tag];
}

// direct binding of: @property(nonatomic, copy) NSString *badgeValue;
- (void) setBadgeValue___java_lang_String:(NSString*) badgeValue 
{
    [self setBadgeValue:(badgeValue == JAVA_NULL ? nil : badgeValue)];
}

// direct binding of: @property(nonatomic, copy) NSString *badgeValue;
- (NSString*) badgeValue__
{
    NSString* re$ult = [self badgeValue];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
