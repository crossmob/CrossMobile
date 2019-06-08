// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNContactFetchRequest implementation

#import "crossmobile_ios_contacts_CNContactFetchRequest.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_contacts_CNContactFetchRequest$Ext

// (CNContactFetchRequest) @property(copy, nonatomic) NSArray<id<CNKeyDescriptor>> *keysToFetch;
- (void) setKeysToFetch___java_util_List:(NSArray*) keysToFetch 
{
    [super setKeysToFetch:(keysToFetch == JAVA_NULL ? nil : keysToFetch)];
}

// (CNContactFetchRequest) @property(copy, nonatomic) NSArray<id<CNKeyDescriptor>> *keysToFetch;
- (NSArray*) keysToFetch__
{
    NSArray* re$ult = [super keysToFetch];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContactFetchRequest) @property(nonatomic) BOOL mutableObjects;
- (void) setMutableObjects___boolean:(BOOL) mutableObjects 
{
    [super setMutableObjects:mutableObjects];
}

// (CNContactFetchRequest) @property(nonatomic) BOOL mutableObjects;
- (BOOL) mutableObjects__
{
    return [super mutableObjects];
}

// (CNContactFetchRequest) @property(nonatomic) CNContactSortOrder sortOrder;
- (void) setSortOrder___int:(int) sortOrder 
{
    [super setSortOrder:sortOrder];
}

// (CNContactFetchRequest) @property(nonatomic) CNContactSortOrder sortOrder;
- (int) sortOrder__
{
    return [super sortOrder];
}

// (CNContactFetchRequest) @property(nonatomic) BOOL unifyResults;
- (void) setUnifyResults___boolean:(BOOL) unifyResults 
{
    [super setUnifyResults:unifyResults];
}

// (CNContactFetchRequest) @property(nonatomic) BOOL unifyResults;
- (BOOL) unifyResults__
{
    return [super unifyResults];
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

@implementation CNContactFetchRequest (cm_crossmobile_ios_contacts_CNContactFetchRequest)

// direct binding of: - (instancetype)initWithKeysToFetch:(NSArray<id<CNKeyDescriptor>> *)keysToFetch;
- (instancetype) __init_crossmobile_ios_contacts_CNContactFetchRequest___java_util_List:(NSArray*) keysToFetch 
{
    return [self initWithKeysToFetch:(keysToFetch == JAVA_NULL ? nil : keysToFetch)];
}

// direct binding of: @property(copy, nonatomic) NSArray<id<CNKeyDescriptor>> *keysToFetch;
- (void) setKeysToFetch___java_util_List:(NSArray*) keysToFetch 
{
    [self setKeysToFetch:(keysToFetch == JAVA_NULL ? nil : keysToFetch)];
}

// direct binding of: @property(copy, nonatomic) NSArray<id<CNKeyDescriptor>> *keysToFetch;
- (NSArray*) keysToFetch__
{
    NSArray* re$ult = [self keysToFetch];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) BOOL mutableObjects;
- (void) setMutableObjects___boolean:(BOOL) mutableObjects 
{
    [self setMutableObjects:mutableObjects];
}

// direct binding of: @property(nonatomic) BOOL mutableObjects;
- (BOOL) mutableObjects__
{
    return [self mutableObjects];
}

// direct binding of: @property(nonatomic) CNContactSortOrder sortOrder;
- (void) setSortOrder___int:(int) sortOrder 
{
    [self setSortOrder:sortOrder];
}

// direct binding of: @property(nonatomic) CNContactSortOrder sortOrder;
- (int) sortOrder__
{
    return [self sortOrder];
}

// direct binding of: @property(nonatomic) BOOL unifyResults;
- (void) setUnifyResults___boolean:(BOOL) unifyResults 
{
    [self setUnifyResults:unifyResults];
}

// direct binding of: @property(nonatomic) BOOL unifyResults;
- (BOOL) unifyResults__
{
    return [self unifyResults];
}

@end
