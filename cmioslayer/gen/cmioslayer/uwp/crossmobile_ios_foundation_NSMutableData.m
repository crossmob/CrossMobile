// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSMutableData implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSMutableData.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSMutableData$Ext

@end

@implementation NSMutableData (cm_crossmobile_ios_foundation_NSMutableData)

// + (instancetype)dataWithBytes:(const void *)bytes length:(NSUInteger)length;
+ (instancetype) dataWithBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    id re$ult = [NSMutableData dataWithBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dataWithBytesNoCopy:(void *)bytes length:(NSUInteger)length;
+ (instancetype) dataWithBytesNoCopy___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    id re$ult = [NSMutableData dataWithBytesNoCopy:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dataWithContentsOfFile:(NSString *)path;
+ (instancetype) dataWithContentsOfFile___java_lang_String:(NSString*) path 
{
    id re$ult = [NSMutableData dataWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dataWithContentsOfURL:(NSURL *)aURL;
+ (instancetype) dataWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) aURL 
{
    id re$ult = [NSMutableData dataWithContentsOfURL:(aURL == JAVA_NULL ? nil : aURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithLength:(NSUInteger)length;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableData___int:(int) length 
{
    return [self initWithLength:length];
}

// - (void)appendBytes:(const void *)bytes length:(NSUInteger)length;
- (void) appendBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    [self appendBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
}

// - (void)appendData:(NSData *)other;
- (void) appendData___crossmobile_ios_foundation_NSData:(NSData*) other 
{
    [self appendData:(other == JAVA_NULL ? nil : other)];
}

// - (void)setData:(NSData *)data;
- (void) setData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    [self setData:(data == JAVA_NULL ? nil : data)];
}

@end
