#import "CM_Block_Reverse_cmioslayer_2.h"

@implementation CM_Block_Reverse_cmioslayer_2

-(instancetype) initWithCMBlock:(id) blk
{
    self = [super init];
    self->blockVar = blk;
    return self;
}

- (void) run__
{
    ((void (^)(void))blockVar)();
}

@end