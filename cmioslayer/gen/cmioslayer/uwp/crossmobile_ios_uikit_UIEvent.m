// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIEvent implementation

#import "crossmobile_ios_uikit_UIEvent.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIEvent$Ext

@end

@implementation UIEvent (cm_crossmobile_ios_uikit_UIEvent)

// @property(nonatomic, readonly) UIEventSubtype subtype;
- (int) subtype__
{
    return [self subtype];
}

// @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// @property(nonatomic, readonly) UIEventType type;
- (int) type__
{
    return [self type];
}

// - (NSSet<UITouch *> *)allTouches;
- (NSSet*) allTouches__
{
    NSSet* re$ult = [self allTouches];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
