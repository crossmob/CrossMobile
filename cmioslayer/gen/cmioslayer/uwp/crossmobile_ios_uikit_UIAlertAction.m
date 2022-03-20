// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAlertAction implementation

#import "crossmobile_ios_uikit_UIAlertAction.h"
#import "java_lang_String.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIAlertAction$Ext

@end

@implementation UIAlertAction (cm_crossmobile_ios_uikit_UIAlertAction)

// + (instancetype)actionWithTitle:(NSString *)title style:(UIAlertActionStyle)style handler:(void (^)(UIAlertAction *action))handler;
+ (instancetype) actionWithTitle___java_lang_String_int_org_robovm_objc_block_VoidBlock1:(NSString*) title :(int) style :(id<org_robovm_objc_block_VoidBlock1>) handler 
{
    id re$ult = [UIAlertAction actionWithTitle:(title == JAVA_NULL ? nil : title) style:style handler:(handler == JAVA_NULL ? nil : ^(UIAlertAction* action) {
        [handler invoke___java_lang_Object:(action ? action : JAVA_NULL)];
    })];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [self setEnabled:enabled];
}

// @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [self isEnabled];
}

// @property(nonatomic, readonly) UIAlertActionStyle style;
- (int) style__
{
    return [self style];
}

// @property(nonatomic, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
