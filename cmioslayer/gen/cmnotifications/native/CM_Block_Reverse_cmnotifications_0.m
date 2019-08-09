#import "CM_Block_Reverse_cmnotifications_0.h"

@implementation CM_Block_Reverse_cmnotifications_0

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