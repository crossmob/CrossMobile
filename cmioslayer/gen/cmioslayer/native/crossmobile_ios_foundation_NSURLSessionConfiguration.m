// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLSessionConfiguration implementation

#import "crossmobile_ios_foundation_NSURLSessionConfiguration.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLSessionConfiguration$Ext

// (NSURLSessionConfiguration) @property(copy) NSString *sharedContainerIdentifier;
- (void) setSharedContainerIdentifier___java_lang_String:(NSString*) sharedContainerIdentifier 
{
    [super setSharedContainerIdentifier:(sharedContainerIdentifier == JAVA_NULL ? nil : sharedContainerIdentifier)];
}

// (NSURLSessionConfiguration) @property(copy) NSString *sharedContainerIdentifier;
- (NSString*) sharedContainerIdentifier__
{
    NSString* re$ult = [super sharedContainerIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation NSURLSessionConfiguration (cm_crossmobile_ios_foundation_NSURLSessionConfiguration)

// direct binding of: + (NSURLSessionConfiguration *)backgroundSessionConfigurationWithIdentifier:(NSString *)identifier;
+ (NSURLSessionConfiguration*) backgroundSessionConfigurationWithIdentifier___java_lang_String:(NSString*) identifier 
{
    NSURLSessionConfiguration* re$ult = [NSURLSessionConfiguration backgroundSessionConfigurationWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionConfiguration__
{
    return [self init];
}

// direct binding of: @property(copy) NSString *sharedContainerIdentifier;
- (void) setSharedContainerIdentifier___java_lang_String:(NSString*) sharedContainerIdentifier 
{
    [self setSharedContainerIdentifier:(sharedContainerIdentifier == JAVA_NULL ? nil : sharedContainerIdentifier)];
}

// direct binding of: @property(copy) NSString *sharedContainerIdentifier;
- (NSString*) sharedContainerIdentifier__
{
    NSString* re$ult = [self sharedContainerIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
