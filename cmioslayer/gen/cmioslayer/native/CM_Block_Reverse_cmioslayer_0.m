#import "CM_Block_Reverse_cmioslayer_0.h"

@implementation CM_Block_Reverse_cmioslayer_0

-(instancetype) initWithCMBlock:(id) blk
{
    self = [super init];
    self->blockVar = blk;
    return self;
}

- (void) invoke___java_lang_Object :(java_lang_Object*)n1
{
    [self invoke___java_lang_Integer :(java_lang_Integer*)n1];
}

- (void) invoke___java_lang_Integer :(java_lang_Integer*)n1
{
    ((void (^)(UIBackgroundFetchResult result))blockVar)([n1 intValue__]);
}

@end