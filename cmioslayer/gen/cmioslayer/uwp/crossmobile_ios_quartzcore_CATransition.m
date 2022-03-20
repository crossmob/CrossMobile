// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CATransition implementation

#import "crossmobile_ios_quartzcore_CATransition.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_quartzcore_CATransition$Ext

@end

@implementation CATransition (cm_crossmobile_ios_quartzcore_CATransition)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CATransition__
{
    return [self init];
}

// @property float endProgress;
- (void) setEndProgress___float:(float) endProgress 
{
    [self setEndProgress:endProgress];
}

// @property float endProgress;
- (float) endProgress__
{
    return [self endProgress];
}

// @property float startProgress;
- (void) setStartProgress___float:(float) startProgress 
{
    [self setStartProgress:startProgress];
}

// @property float startProgress;
- (float) startProgress__
{
    return [self startProgress];
}

// @property(copy) NSString *subtype;
- (void) setSubtype___java_lang_String:(NSString*) subtype 
{
    [self setSubtype:(subtype == JAVA_NULL ? nil : subtype)];
}

// @property(copy) NSString *subtype;
- (NSString*) subtype__
{
    NSString* re$ult = [self subtype];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy) NSString *type;
- (void) setType___java_lang_String:(NSString*) type 
{
    [self setType:(type == JAVA_NULL ? nil : type)];
}

// @property(copy) NSString *type;
- (NSString*) type__
{
    NSString* re$ult = [self type];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
