#import "CM_Block_Reverse_cmioslayer_1.h"

@implementation CM_Block_Reverse_cmioslayer_1

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