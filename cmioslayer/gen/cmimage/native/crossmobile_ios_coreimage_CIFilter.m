// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.coreimage.CIFilter implementation

#import "crossmobile_ios_coreimage_CIFilter.h"
#import "crossmobile_ios_coreimage_CIImage.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_coreimage_CIFilter$Ext

// (CIFilter) @property(nonatomic, readonly) NSDictionary<NSString *,id> *attributes;
- (NSDictionary*) attributes__
{
    NSDictionary* re$ult = [super attributes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CIFilter) @property(readonly, nonatomic) CIImage *outputImage;
- (CIImage*) outputImage__
{
    CIImage* re$ult = [super outputImage];
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

@implementation CIFilter (cm_crossmobile_ios_coreimage_CIFilter)

// direct binding of: + (CIFilter *)filterWithImageData:(NSData *)data options:(NSDictionary *)options;
+ (CIFilter*) filterWithImageData___crossmobile_ios_foundation_NSData_java_util_Map:(NSData*) data :(NSDictionary*) options 
{
    CIFilter* re$ult = [CIFilter filterWithImageData:(data == JAVA_NULL ? nil : data) options:(options == JAVA_NULL ? nil : options)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (CIFilter *)filterWithName:(NSString *)name;
+ (CIFilter*) filterWithName___java_lang_String:(NSString*) name 
{
    CIFilter* re$ult = [CIFilter filterWithName:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSDictionary<NSString *,id> *attributes;
- (NSDictionary*) attributes__
{
    NSDictionary* re$ult = [self attributes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CIImage *outputImage;
- (CIImage*) outputImage__
{
    CIImage* re$ult = [self outputImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
