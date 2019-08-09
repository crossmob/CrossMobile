#import "CM_Block_Reverse_cmnotifications_1.h"

@implementation CM_Block_Reverse_cmnotifications_1

-(instancetype) initWithCMBlock:(id) blk
{
    self = [super init];
    self->blockVar = blk;
    return self;
}

- (void) invoke___java_lang_Object :(java_lang_Object*)n1
{
    [self invoke___java_lang_Long :(java_lang_Long*)n1];
}

- (void) invoke___java_lang_Long :(java_lang_Long*)n1
{
    ((void (^)(UNNotificationPresentationOptions options))blockVar)([n1 longValue__]);
}

@end