#import "CM_Block_Reverse_cmwebkit_1.h"

@implementation CM_Block_Reverse_cmwebkit_1

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
    ((void (^)(WKNavigationResponsePolicy))blockVar)([n1 intValue__]);
}

@end