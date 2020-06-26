#import "PluginTest.h"
#import <UIKit/UIDevice.h>

@implementation PluginTest
+ (int) getANumber
{
    return 5;
}

- (NSString*) doubleString:(NSString*) input
{
    return [[NSString alloc] initWithFormat:@"%@%@", input, input];
}
- (NSString*) systemVersion
{
    return [[[UIDevice currentDevice] systemVersion] retain];
}
@end
