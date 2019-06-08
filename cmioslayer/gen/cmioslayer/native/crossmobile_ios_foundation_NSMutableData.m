// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSMutableData implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSMutableData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSMutableData$Ext

// (NSData) @property(readonly) const void *bytes;
- (void*) bytes__
{
    return [XMLVMArray createSingleDimensionWithType:3/*byte*/ size:[self length] andData:(void*)[super bytes]];
}

// (NSData) @property(readonly) NSUInteger length;
- (int) length__
{
    return [super length];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSMutableData) - (void)appendBytes:(const void *)bytes length:(NSUInteger)length;
- (void) appendBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    [super appendBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
}

// (NSMutableData) - (void)appendData:(NSData *)other;
- (void) appendData___crossmobile_ios_foundation_NSData:(NSData*) other 
{
    [super appendData:(other == JAVA_NULL ? nil : other)];
}

// (NSData) - (NSString *)base64EncodedStringWithOptions:(NSDataBase64EncodingOptions)options;
- (NSString*) base64EncodedStringWithOptions___int:(int) options 
{
    NSString* re$ult = [super base64EncodedStringWithOptions:options];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (NSMutableData) - (void)setData:(NSData *)data;
- (void) setData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    [super setData:(data == JAVA_NULL ? nil : data)];
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

// (NSData) - (BOOL)writeToFile:(NSString *)path atomically:(BOOL)useAuxiliaryFile;
- (BOOL) writeToFile___java_lang_String_boolean:(NSString*) path :(BOOL) useAuxiliaryFile 
{
    return [super writeToFile:(path == JAVA_NULL ? nil : path) atomically:useAuxiliaryFile];
}

@end

@implementation NSMutableData (cm_crossmobile_ios_foundation_NSMutableData)

// direct binding of: + (instancetype)dataWithBytes:(const void *)bytes length:(NSUInteger)length;
+ (instancetype) dataWithBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    id re$ult = [NSMutableData dataWithBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)dataWithBytesNoCopy:(void *)bytes length:(NSUInteger)length;
+ (instancetype) dataWithBytesNoCopy___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    id re$ult = [NSMutableData dataWithBytesNoCopy:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)dataWithContentsOfFile:(NSString *)path;
+ (instancetype) dataWithContentsOfFile___java_lang_String:(NSString*) path 
{
    id re$ult = [NSMutableData dataWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)dataWithContentsOfURL:(NSURL *)aURL;
+ (instancetype) dataWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) aURL 
{
    id re$ult = [NSMutableData dataWithContentsOfURL:(aURL == JAVA_NULL ? nil : aURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithLength:(NSUInteger)length;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableData___int:(int) length 
{
    return [self initWithLength:length];
}

// direct binding of: - (void)appendBytes:(const void *)bytes length:(NSUInteger)length;
- (void) appendBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes 
{
    [self appendBytes:(bytes == JAVA_NULL ? NULL : bytes->array.data) length:(bytes == JAVA_NULL ? 0 : bytes->length)];
}

// direct binding of: - (void)appendData:(NSData *)other;
- (void) appendData___crossmobile_ios_foundation_NSData:(NSData*) other 
{
    [self appendData:(other == JAVA_NULL ? nil : other)];
}

// direct binding of: - (void)setData:(NSData *)data;
- (void) setData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    [self setData:(data == JAVA_NULL ? nil : data)];
}

@end
