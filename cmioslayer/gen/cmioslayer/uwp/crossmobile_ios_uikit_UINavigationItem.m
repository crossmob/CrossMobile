// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UINavigationItem implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UINavigationItem$Ext

// (UINavigationItem) @property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;
- (void) setBackBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) backBarButtonItem 
{
    [super setBackBarButtonItem:(backBarButtonItem == JAVA_NULL ? nil : backBarButtonItem)];
}

// (UINavigationItem) @property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;
- (UIBarButtonItem*) backBarButtonItem__
{
    UIBarButtonItem* re$ult = [super backBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UINavigationItem) @property(nonatomic, assign) BOOL hidesBackButton;
- (void) setHidesBackButton___boolean:(BOOL) hidesBackButton 
{
    [super setHidesBackButton:hidesBackButton];
}

// (UINavigationItem) @property(nonatomic, assign) BOOL hidesBackButton;
- (BOOL) hidesBackButton__
{
    return [super hidesBackButton];
}

// (UINavigationItem) @property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) leftBarButtonItem 
{
    [super setLeftBarButtonItem:(leftBarButtonItem == JAVA_NULL ? nil : leftBarButtonItem)];
}

// (UINavigationItem) @property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;
- (UIBarButtonItem*) leftBarButtonItem__
{
    UIBarButtonItem* re$ult = [super leftBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UINavigationItem) @property(nonatomic, copy) NSString *prompt;
- (void) setPrompt___java_lang_String:(NSString*) prompt 
{
    [super setPrompt:(prompt == JAVA_NULL ? nil : prompt)];
}

// (UINavigationItem) @property(nonatomic, copy) NSString *prompt;
- (NSString*) prompt__
{
    NSString* re$ult = [super prompt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UINavigationItem) @property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) rightBarButtonItem 
{
    [super setRightBarButtonItem:(rightBarButtonItem == JAVA_NULL ? nil : rightBarButtonItem)];
}

// (UINavigationItem) @property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;
- (UIBarButtonItem*) rightBarButtonItem__
{
    UIBarButtonItem* re$ult = [super rightBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UINavigationItem) @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
}

// (UINavigationItem) @property(nonatomic, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UINavigationItem) @property(nonatomic, strong) UIView *titleView;
- (void) setTitleView___crossmobile_ios_uikit_UIView:(UIView*) titleView 
{
    [super setTitleView:(titleView == JAVA_NULL ? nil : titleView)];
}

// (UINavigationItem) @property(nonatomic, strong) UIView *titleView;
- (UIView*) titleView__
{
    UIView* re$ult = [super titleView];
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

// (UINavigationItem) - (void)setHidesBackButton:(BOOL)hidesBackButton animated:(BOOL)animated;
- (void) setHidesBackButton___boolean_boolean:(BOOL) hidesBackButton :(BOOL) animated 
{
    [super setHidesBackButton:hidesBackButton animated:animated];
}

// (UINavigationItem) - (void)setLeftBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated 
{
    [super setLeftBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated];
}

// (UINavigationItem) - (void)setRightBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated 
{
    [super setRightBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated];
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

@implementation UINavigationItem (cm_crossmobile_ios_uikit_UINavigationItem)

// direct binding of: - (instancetype)initWithTitle:(NSString *)title;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationItem___java_lang_String:(NSString*) title 
{
    return [self initWithTitle:(title == JAVA_NULL ? nil : title)];
}

// direct binding of: @property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;
- (void) setBackBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) backBarButtonItem 
{
    [self setBackBarButtonItem:(backBarButtonItem == JAVA_NULL ? nil : backBarButtonItem)];
}

// direct binding of: @property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;
- (UIBarButtonItem*) backBarButtonItem__
{
    UIBarButtonItem* re$ult = [self backBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, assign) BOOL hidesBackButton;
- (void) setHidesBackButton___boolean:(BOOL) hidesBackButton 
{
    [self setHidesBackButton:hidesBackButton];
}

// direct binding of: @property(nonatomic, assign) BOOL hidesBackButton;
- (BOOL) hidesBackButton__
{
    return [self hidesBackButton];
}

// direct binding of: @property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) leftBarButtonItem 
{
    [self setLeftBarButtonItem:(leftBarButtonItem == JAVA_NULL ? nil : leftBarButtonItem)];
}

// direct binding of: @property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;
- (UIBarButtonItem*) leftBarButtonItem__
{
    UIBarButtonItem* re$ult = [self leftBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *prompt;
- (void) setPrompt___java_lang_String:(NSString*) prompt 
{
    [self setPrompt:(prompt == JAVA_NULL ? nil : prompt)];
}

// direct binding of: @property(nonatomic, copy) NSString *prompt;
- (NSString*) prompt__
{
    NSString* re$ult = [self prompt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem:(UIBarButtonItem*) rightBarButtonItem 
{
    [self setRightBarButtonItem:(rightBarButtonItem == JAVA_NULL ? nil : rightBarButtonItem)];
}

// direct binding of: @property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;
- (UIBarButtonItem*) rightBarButtonItem__
{
    UIBarButtonItem* re$ult = [self rightBarButtonItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// direct binding of: @property(nonatomic, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, strong) UIView *titleView;
- (void) setTitleView___crossmobile_ios_uikit_UIView:(UIView*) titleView 
{
    [self setTitleView:(titleView == JAVA_NULL ? nil : titleView)];
}

// direct binding of: @property(nonatomic, strong) UIView *titleView;
- (UIView*) titleView__
{
    UIView* re$ult = [self titleView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)setHidesBackButton:(BOOL)hidesBackButton animated:(BOOL)animated;
- (void) setHidesBackButton___boolean_boolean:(BOOL) hidesBackButton :(BOOL) animated 
{
    [self setHidesBackButton:hidesBackButton animated:animated];
}

// direct binding of: - (void)setLeftBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated;
- (void) setLeftBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated 
{
    [self setLeftBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated];
}

// direct binding of: - (void)setRightBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated;
- (void) setRightBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean:(UIBarButtonItem*) item :(BOOL) animated 
{
    [self setRightBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated];
}

@end
