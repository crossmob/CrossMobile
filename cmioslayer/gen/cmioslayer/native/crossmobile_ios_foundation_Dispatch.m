// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_Dispatch implementation

#import "crossmobile_ios_foundation_Dispatch.h"
#import "java_lang_Runnable.h"

@implementation Dispatch (cm_crossmobile_ios_foundation_Dispatch)

// id dispatch_get_main_queue(void);
+ (id) getMainQueue__
{
    id re$ult = dispatch_get_main_queue();
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// void dispatch_async(id queue, void (^)(void) block);
- (void) async___java_lang_Runnable:(id<java_lang_Runnable>) block 
{
    dispatch_async(self, (block == JAVA_NULL ? nil : ^{
        [block run__];
    }));
}

@end
