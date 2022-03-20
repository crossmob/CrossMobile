// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSUUID implementation

#import "crossmobile_ios_foundation_NSUUID.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSUUID$Ext

@end

@implementation NSUUID (cm_crossmobile_ios_foundation_NSUUID)

// + (instancetype)UUID;
+ (instancetype) UUID__
{
    id re$ult = [NSUUID UUID];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithUUIDBytes:(const uuid_t)bytes;
- (instancetype) __init_crossmobile_ios_foundation_NSUUID___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    return [self initWithUUIDBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data)];
}

// - (instancetype)initWithUUIDString:(NSString *)string;
- (instancetype) __init_crossmobile_ios_foundation_NSUUID___java_lang_String:(NSString*) string 
{
    return [self initWithUUIDString:(string == JAVA_NULL ? nil : string)];
}

// @property(readonly, copy) NSString *UUIDString;
- (NSString*) UUIDString__
{
    NSString* re$ult = [self UUIDString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)getUUIDBytes:(uuid_t)uuid;
- (void) getUUIDBytes___byte_ARRAYTYPE:(XMLVMArray*) uuid 
{
    [self getUUIDBytes:(uuid == JAVA_NULL ? NULL : uuid->array.data)];
}

@end
