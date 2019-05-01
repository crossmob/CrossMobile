// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSUUID implementation

#import "crossmobile_ios_foundation_NSUUID.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSUUID$Ext

// (NSUUID) @property(readonly, copy) NSString *UUIDString;
- (NSString*) UUIDString__
{
    NSString* re$ult = [super UUIDString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSUUID) - (void)getUUIDBytes:(uuid_t)uuid;
- (void) getUUIDBytes___byte_ARRAYTYPE:(XMLVMArray*) uuid 
{
    [super getUUIDBytes:(uuid == JAVA_NULL ? NULL : uuid->array.data)];
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

@implementation NSUUID (cm_crossmobile_ios_foundation_NSUUID)

// direct binding of: + (instancetype)UUID;
+ (instancetype) UUID__
{
    id re$ult = [NSUUID UUID];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithUUIDBytes:(const uuid_t)bytes;
- (instancetype) __init_crossmobile_ios_foundation_NSUUID___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    return [self initWithUUIDBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data)];
}

// direct binding of: - (instancetype)initWithUUIDString:(NSString *)string;
- (instancetype) __init_crossmobile_ios_foundation_NSUUID___java_lang_String:(NSString*) string 
{
    return [self initWithUUIDString:(string == JAVA_NULL ? nil : string)];
}

// direct binding of: @property(readonly, copy) NSString *UUIDString;
- (NSString*) UUIDString__
{
    NSString* re$ult = [self UUIDString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)getUUIDBytes:(uuid_t)uuid;
- (void) getUUIDBytes___byte_ARRAYTYPE:(XMLVMArray*) uuid 
{
    [self getUUIDBytes:(uuid == JAVA_NULL ? NULL : uuid->array.data)];
}

@end
