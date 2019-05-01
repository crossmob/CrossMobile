// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIEvent implementation

#import "crossmobile_ios_uikit_UIEvent.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIEvent$Ext

// (UIEvent) @property(nonatomic, readonly) UIEventSubtype subtype;
- (int) subtype__
{
    return [super subtype];
}

// (UIEvent) @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [super timestamp];
}

// (UIEvent) @property(nonatomic, readonly) UIEventType type;
- (int) type__
{
    return [super type];
}

// (UIEvent) - (NSSet<UITouch *> *)allTouches;
- (NSSet*) allTouches__
{
    NSSet* re$ult = [super allTouches];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation UIEvent (cm_crossmobile_ios_uikit_UIEvent)

// direct binding of: @property(nonatomic, readonly) UIEventSubtype subtype;
- (int) subtype__
{
    return [self subtype];
}

// direct binding of: @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// direct binding of: @property(nonatomic, readonly) UIEventType type;
- (int) type__
{
    return [self type];
}

// direct binding of: - (NSSet<UITouch *> *)allTouches;
- (NSSet*) allTouches__
{
    NSSet* re$ult = [self allTouches];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
