// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSRunLoop implementation

#import "crossmobile_ios_foundation_NSRunLoop.h"
#import "crossmobile_ios_foundation_NSTimer.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSRunLoop$Ext

@end

@implementation NSRunLoop (cm_crossmobile_ios_foundation_NSRunLoop)

// + (NSRunLoop *)mainRunLoop;
+ (NSRunLoop*) mainRunLoop__
{
    NSRunLoop* re$ult = [NSRunLoop mainRunLoop];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addTimer:(NSTimer *)timer forMode:(NSString *)mode;
- (void) addTimer___crossmobile_ios_foundation_NSTimer_java_lang_String:(NSTimer*) timer :(NSString*) mode 
{
    [self addTimer:(timer == JAVA_NULL ? nil : timer) forMode:(mode == JAVA_NULL ? nil : mode)];
}

@end
