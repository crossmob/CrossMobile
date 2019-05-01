// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSOperationQueue implementation

#import "crossmobile_ios_foundation_NSOperationQueue.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSOperationQueue$Ext

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

@implementation NSOperationQueue (cm_crossmobile_ios_foundation_NSOperationQueue)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSOperationQueue__
{
    return [self init];
}

@end
