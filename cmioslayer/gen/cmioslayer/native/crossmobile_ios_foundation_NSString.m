// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSString implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSLocale.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSString.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSString$Ext

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

@implementation NSString (cm_crossmobile_ios_foundation_NSString)

// direct binding of: - (BOOL)canBeConvertedToEncoding:(NSStringEncoding)encoding;
+ (BOOL) canBeConvertedToEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    return [(this == JAVA_NULL ? nil : this) canBeConvertedToEncoding:encoding];
}

// direct binding of: - (NSComparisonResult)compare:(NSString *)aString options:(NSStringCompareOptions)mask;
+ (int) compare___java_lang_String_java_lang_String_int:(NSString*) this :(NSString*) aString :(int) mask 
{
    return [(this == JAVA_NULL ? nil : this) compare:(aString == JAVA_NULL ? nil : aString) options:mask];
}

// direct binding of: - (NSArray<NSString *> *)componentsSeparatedByString:(NSString *)separator;
+ (NSArray*) componentsSeparatedByString___java_lang_String_java_lang_String:(NSString*) this :(NSString*) separator 
{
    NSArray* re$ult = [(this == JAVA_NULL ? nil : this) componentsSeparatedByString:(separator == JAVA_NULL ? nil : separator)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSData *)dataUsingEncoding:(NSStringEncoding)encoding;
+ (NSData*) dataUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    NSData* re$ult = [(this == JAVA_NULL ? nil : this) dataUsingEncoding:encoding];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (CGSize)drawAtPoint:(CGPoint)point withFont:(UIFont *)font;
+ (crossmobile_ios_coregraphics_CGSize*) drawAtPoint___java_lang_String_crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIFont:(NSString*) this :(crossmobile_ios_coregraphics_CGPoint*) point :(UIFont*) font 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[(this == JAVA_NULL ? nil : this) drawAtPoint:[point getCGPoint] withFont:(font == JAVA_NULL ? nil : font)]];
}

// direct binding of: - (instancetype)initWithData:(NSData *)data encoding:(NSStringEncoding)encoding;
+ (instancetype) initWithData___crossmobile_ios_foundation_NSData_int:(NSData*) data :(int) encoding 
{
    return [[NSString alloc] initWithData:(data == JAVA_NULL ? nil : data) encoding:encoding];
}

// direct binding of: - (instancetype)initWithFormat:(NSString *)format locale:(id)locale, ...;
+ (instancetype) initWithFormat___java_lang_String_crossmobile_ios_foundation_NSLocale_java_lang_Object_ARRAYTYPE:(NSString*) format :(NSLocale*) locale :(XMLVMArray*) va_array 
{
    id re$ult = [cmioslayer_va NSString_initWithFormat:(format == JAVA_NULL ? nil : format) :(locale == JAVA_NULL ? nil : locale) :[java_util_Arrays asList___java_lang_Object_ARRAYTYPE:va_array]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithFormat:(NSString *)format, ...;
+ (instancetype) initWithFormat___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    id re$ult = [cmioslayer_va NSString_initWithFormat:(format == JAVA_NULL ? nil : format) :[java_util_Arrays asList___java_lang_Object_ARRAYTYPE:va_array]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)localizedStringWithFormat:(NSString *)format, ...;
+ (instancetype) localizedStringWithFormat___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    id re$ult = [cmioslayer_va NSString_localizedStringWithFormat:(format == JAVA_NULL ? nil : format) :[java_util_Arrays asList___java_lang_Object_ARRAYTYPE:va_array]];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (CGSize)sizeWithFont:(UIFont *)font;
+ (crossmobile_ios_coregraphics_CGSize*) sizeWithFont___java_lang_String_crossmobile_ios_uikit_UIFont:(NSString*) this :(UIFont*) font 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[(this == JAVA_NULL ? nil : this) sizeWithFont:(font == JAVA_NULL ? nil : font)]];
}

// direct binding of: - (CGSize)sizeWithFont:(UIFont *)font constrainedToSize:(CGSize)size lineBreakMode:(NSLineBreakMode)lineBreakMode ;
+ (crossmobile_ios_coregraphics_CGSize*) sizeWithFont___java_lang_String_crossmobile_ios_uikit_UIFont_crossmobile_ios_coregraphics_CGSize_int:(NSString*) this :(UIFont*) font :(crossmobile_ios_coregraphics_CGSize*) size :(int) lineBreakMode 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[(this == JAVA_NULL ? nil : this) sizeWithFont:(font == JAVA_NULL ? nil : font) constrainedToSize:[size getCGSize] lineBreakMode:lineBreakMode]];
}

// direct binding of: - (NSString *)stringByAddingPercentEscapesUsingEncoding:(NSStringEncoding)encoding;
+ (NSString*) stringByAddingPercentEscapesUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    NSString* re$ult = [(this == JAVA_NULL ? nil : this) stringByAddingPercentEscapesUsingEncoding:encoding];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSString *)stringByReplacingPercentEscapesUsingEncoding:(NSStringEncoding)encoding;
+ (NSString*) stringByReplacingPercentEscapesUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    NSString* re$ult = [(this == JAVA_NULL ? nil : this) stringByReplacingPercentEscapesUsingEncoding:encoding];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (id)stringWithContentsOfFile:(NSString *)path;
+ (id) stringWithContentsOfFile___java_lang_String:(NSString*) path 
{
    id re$ult = [NSString stringWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)stringWithContentsOfFile:(NSString *)path encoding:(NSStringEncoding)enc error:(NSError * _Nullable *)error;
+ (instancetype) stringWithContentsOfFile___java_lang_String_int_crossmobile_rt_StrongReference:(NSString*) path :(int) enc :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSString stringWithContentsOfFile:(path == JAVA_NULL ? nil : path) encoding:enc error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (id)stringWithContentsOfURL:(NSURL *)url;
+ (id) stringWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    id re$ult = [NSString stringWithContentsOfURL:(url == JAVA_NULL ? nil : url)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)stringWithContentsOfURL:(NSURL *)url encoding:(NSStringEncoding)enc error:(NSError * _Nullable *)error;
+ (instancetype) stringWithContentsOfURL___crossmobile_ios_foundation_NSURL_int_crossmobile_rt_StrongReference:(NSURL*) url :(int) enc :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSString stringWithContentsOfURL:(url == JAVA_NULL ? nil : url) encoding:enc error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (BOOL)writeToFile:(NSString *)path atomically:(BOOL)useAuxiliaryFile encoding:(NSStringEncoding)enc error:(NSError * _Nullable *)error;
+ (BOOL) writeToFile___java_lang_String_java_lang_String_boolean_int_crossmobile_rt_StrongReference:(NSString*) this :(NSString*) path :(BOOL) useAuxiliaryFile :(int) enc :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [(this == JAVA_NULL ? nil : this) writeToFile:(path == JAVA_NULL ? nil : path) atomically:useAuxiliaryFile encoding:enc error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

@end
