// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_contacts_CNGroup implementation

#import "crossmobile_ios_contacts_CNGroup.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNGroup$Ext

@end

@implementation CNGroup (cm_crossmobile_ios_contacts_CNGroup)

// @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
