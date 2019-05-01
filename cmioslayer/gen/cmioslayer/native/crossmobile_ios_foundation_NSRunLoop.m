// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSRunLoop implementation

#import "crossmobile_ios_foundation_NSRunLoop.h"
#import "crossmobile_ios_foundation_NSTimer.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSRunLoop$Ext

// (NSRunLoop) - (void)addTimer:(NSTimer *)timer forMode:(NSString *)mode;
- (void) addTimer___crossmobile_ios_foundation_NSTimer_java_lang_String:(NSTimer*) timer :(NSString*) mode 
{
    [super addTimer:(timer == JAVA_NULL ? nil : timer) forMode:(mode == JAVA_NULL ? nil : mode)];
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

@implementation NSRunLoop (cm_crossmobile_ios_foundation_NSRunLoop)

// direct binding of: + (NSRunLoop *)mainRunLoop;
+ (NSRunLoop*) mainRunLoop__
{
    NSRunLoop* re$ult = [NSRunLoop mainRunLoop];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)addTimer:(NSTimer *)timer forMode:(NSString *)mode;
- (void) addTimer___crossmobile_ios_foundation_NSTimer_java_lang_String:(NSTimer*) timer :(NSString*) mode 
{
    [self addTimer:(timer == JAVA_NULL ? nil : timer) forMode:(mode == JAVA_NULL ? nil : mode)];
}

@end
