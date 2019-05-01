// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSExtensionItem implementation

#import "crossmobile_ios_foundation_NSExtensionItem.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSExtensionItem$Ext

// (NSExtensionItem) @property(copy, nonatomic) NSArray *attachments;
- (void) setAttachments___java_util_List:(NSArray*) attachments 
{
    [super setAttachments:(attachments == JAVA_NULL ? nil : attachments)];
}

// (NSExtensionItem) @property(copy, nonatomic) NSArray *attachments;
- (NSArray*) attachments__
{
    NSArray* re$ult = [super attachments];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSExtensionItem) @property(copy, nonatomic) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [super setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// (NSExtensionItem) @property(copy, nonatomic) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [super userInfo];
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

@implementation NSExtensionItem (cm_crossmobile_ios_foundation_NSExtensionItem)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSExtensionItem__
{
    return [self init];
}

// direct binding of: @property(copy, nonatomic) NSArray *attachments;
- (void) setAttachments___java_util_List:(NSArray*) attachments 
{
    [self setAttachments:(attachments == JAVA_NULL ? nil : attachments)];
}

// direct binding of: @property(copy, nonatomic) NSArray *attachments;
- (NSArray*) attachments__
{
    NSArray* re$ult = [self attachments];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy, nonatomic) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [self setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// direct binding of: @property(copy, nonatomic) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
