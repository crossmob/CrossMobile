// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSXMLParser implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSXMLParser.h"
#import "crossmobile_ios_foundation_NSXMLParserDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSXMLParser$Ext

// (NSXMLParser) @property(assign) id<NSXMLParserDelegate> delegate;
- (void) setDelegate___crossmobile_ios_foundation_NSXMLParserDelegate:(id<NSXMLParserDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (NSXMLParser) @property(readonly, copy) NSError *parserError;
- (NSError*) parserError__
{
    NSError* re$ult = [super parserError];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSXMLParser) @property BOOL shouldProcessNamespaces;
- (void) setShouldProcessNamespaces___boolean:(BOOL) shouldProcessNamespaces 
{
    [super setShouldProcessNamespaces:shouldProcessNamespaces];
}

// (NSXMLParser) @property BOOL shouldProcessNamespaces;
- (BOOL) shouldProcessNamespaces__
{
    return [super shouldProcessNamespaces];
}

// (NSXMLParser) @property BOOL shouldReportNamespacePrefixes;
- (void) setShouldReportNamespacePrefixes___boolean:(BOOL) shouldReportNamespacePrefixes 
{
    [super setShouldReportNamespacePrefixes:shouldReportNamespacePrefixes];
}

// (NSXMLParser) @property BOOL shouldReportNamespacePrefixes;
- (BOOL) shouldReportNamespacePrefixes__
{
    return [super shouldReportNamespacePrefixes];
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

// (NSXMLParser) - (BOOL)parse;
- (BOOL) parse__
{
    return [super parse];
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

@implementation NSXMLParser (cm_crossmobile_ios_foundation_NSXMLParser)

// direct binding of: - (instancetype)initWithData:(NSData *)data;
- (instancetype) __init_crossmobile_ios_foundation_NSXMLParser___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    return [self initWithData:(data == JAVA_NULL ? nil : data)];
}

// direct binding of: @property(assign) id<NSXMLParserDelegate> delegate;
- (void) setDelegate___crossmobile_ios_foundation_NSXMLParserDelegate:(id<NSXMLParserDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(readonly, copy) NSError *parserError;
- (NSError*) parserError__
{
    NSError* re$ult = [self parserError];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property BOOL shouldProcessNamespaces;
- (void) setShouldProcessNamespaces___boolean:(BOOL) shouldProcessNamespaces 
{
    [self setShouldProcessNamespaces:shouldProcessNamespaces];
}

// direct binding of: @property BOOL shouldProcessNamespaces;
- (BOOL) shouldProcessNamespaces__
{
    return [self shouldProcessNamespaces];
}

// direct binding of: @property BOOL shouldReportNamespacePrefixes;
- (void) setShouldReportNamespacePrefixes___boolean:(BOOL) shouldReportNamespacePrefixes 
{
    [self setShouldReportNamespacePrefixes:shouldReportNamespacePrefixes];
}

// direct binding of: @property BOOL shouldReportNamespacePrefixes;
- (BOOL) shouldReportNamespacePrefixes__
{
    return [self shouldReportNamespacePrefixes];
}

// direct binding of: - (BOOL)parse;
- (BOOL) parse__
{
    return [self parse];
}

@end
