// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.NSLayoutConstraint implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_NSLayoutConstraint$Ext

// (NSLayoutConstraint) @property(getter=isActive) BOOL active;
- (void) setActive___boolean:(BOOL) active 
{
    [super setActive:active];
}

// (NSLayoutConstraint) @property(getter=isActive) BOOL active;
- (BOOL) isActive__
{
    return [super isActive];
}

// (NSLayoutConstraint) @property CGFloat constant;
- (void) setConstant___double:(double) constant 
{
    [super setConstant:constant];
}

// (NSLayoutConstraint) @property CGFloat constant;
- (double) constant__
{
    return [super constant];
}

// (NSLayoutConstraint) @property(readonly) NSLayoutAttribute firstAttribute;
- (int) firstAttribute__
{
    return [super firstAttribute];
}

// (NSLayoutConstraint) @property(readonly, assign) id firstItem;
- (id) firstItem__
{
    id re$ult = [super firstItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutConstraint) @property(copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [super setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// (NSLayoutConstraint) @property(copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutConstraint) @property(readonly) CGFloat multiplier;
- (double) multiplier__
{
    return [super multiplier];
}

// (NSLayoutConstraint) @property UILayoutPriority priority;
- (void) setPriority___float:(float) priority 
{
    [super setPriority:priority];
}

// (NSLayoutConstraint) @property UILayoutPriority priority;
- (float) priority__
{
    return [super priority];
}

// (NSLayoutConstraint) @property(readonly) NSLayoutRelation relation;
- (int) relation__
{
    return [super relation];
}

// (NSLayoutConstraint) @property(readonly) NSLayoutAttribute secondAttribute;
- (int) secondAttribute__
{
    return [super secondAttribute];
}

// (NSLayoutConstraint) @property(readonly, assign) id secondItem;
- (id) secondItem__
{
    id re$ult = [super secondItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutConstraint) @property BOOL shouldBeArchived;
- (void) setShouldBeArchived___boolean:(BOOL) shouldBeArchived 
{
    [super setShouldBeArchived:shouldBeArchived];
}

// (NSLayoutConstraint) @property BOOL shouldBeArchived;
- (BOOL) shouldBeArchived__
{
    return [super shouldBeArchived];
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

@implementation NSLayoutConstraint (cm_crossmobile_ios_uikit_NSLayoutConstraint)

// direct binding of: + (void)activateConstraints:(NSArray<NSLayoutConstraint *> *)constraints;
+ (void) activateConstraints___java_util_List:(NSArray*) constraints 
{
    [NSLayoutConstraint activateConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// direct binding of: + (instancetype)constraintWithItem:(id)view1 attribute:(NSLayoutAttribute)attr1 relatedBy:(NSLayoutRelation)relation toItem:(id)view2 attribute:(NSLayoutAttribute)attr2 multiplier:(CGFloat)multiplier constant:(CGFloat)c;
+ (instancetype) constraintWithItem___java_lang_Object_int_int_java_lang_Object_int_double_double:(id) view1 :(int) attr1 :(int) relation :(id) view2 :(int) attr2 :(double) multiplier :(double) c 
{
    id re$ult = [NSLayoutConstraint constraintWithItem:(view1 == JAVA_NULL ? nil : view1) attribute:attr1 relatedBy:relation toItem:(view2 == JAVA_NULL ? nil : view2) attribute:attr2 multiplier:multiplier constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSArray<__kindof NSLayoutConstraint *> *)constraintsWithVisualFormat:(NSString *)format options:(NSLayoutFormatOptions)opts metrics:(NSDictionary<NSString *,id> *)metrics views:(NSDictionary<NSString *,id> *)views;
+ (NSArray*) constraintsWithVisualFormat___java_lang_String_int_java_util_Map_java_util_Map:(NSString*) format :(int) opts :(NSDictionary*) metrics :(NSDictionary*) views 
{
    NSArray* re$ult = [NSLayoutConstraint constraintsWithVisualFormat:(format == JAVA_NULL ? nil : format) options:opts metrics:(metrics == JAVA_NULL ? nil : metrics) views:(views == JAVA_NULL ? nil : views)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (void)deactivateConstraints:(NSArray<NSLayoutConstraint *> *)constraints;
+ (void) deactivateConstraints___java_util_List:(NSArray*) constraints 
{
    [NSLayoutConstraint deactivateConstraints:(constraints == JAVA_NULL ? nil : constraints)];
}

// direct binding of: @property(getter=isActive) BOOL active;
- (void) setActive___boolean:(BOOL) active 
{
    [self setActive:active];
}

// direct binding of: @property(getter=isActive) BOOL active;
- (BOOL) isActive__
{
    return [self isActive];
}

// direct binding of: @property CGFloat constant;
- (void) setConstant___double:(double) constant 
{
    [self setConstant:constant];
}

// direct binding of: @property CGFloat constant;
- (double) constant__
{
    return [self constant];
}

// direct binding of: @property(readonly) NSLayoutAttribute firstAttribute;
- (int) firstAttribute__
{
    return [self firstAttribute];
}

// direct binding of: @property(readonly, assign) id firstItem;
- (id) firstItem__
{
    id re$ult = [self firstItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [self setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// direct binding of: @property(copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) CGFloat multiplier;
- (double) multiplier__
{
    return [self multiplier];
}

// direct binding of: @property UILayoutPriority priority;
- (void) setPriority___float:(float) priority 
{
    [self setPriority:priority];
}

// direct binding of: @property UILayoutPriority priority;
- (float) priority__
{
    return [self priority];
}

// direct binding of: @property(readonly) NSLayoutRelation relation;
- (int) relation__
{
    return [self relation];
}

// direct binding of: @property(readonly) NSLayoutAttribute secondAttribute;
- (int) secondAttribute__
{
    return [self secondAttribute];
}

// direct binding of: @property(readonly, assign) id secondItem;
- (id) secondItem__
{
    id re$ult = [self secondItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property BOOL shouldBeArchived;
- (void) setShouldBeArchived___boolean:(BOOL) shouldBeArchived 
{
    [self setShouldBeArchived:shouldBeArchived];
}

// direct binding of: @property BOOL shouldBeArchived;
- (BOOL) shouldBeArchived__
{
    return [self shouldBeArchived];
}

@end
