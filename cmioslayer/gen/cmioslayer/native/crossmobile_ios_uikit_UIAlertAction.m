// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIAlertAction implementation

#import "crossmobile_ios_uikit_UIAlertAction.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIAlertAction$Ext

// (UIAlertAction) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIAlertAction) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
}

// (UIAlertAction) @property(nonatomic, readonly) UIAlertActionStyle style;
- (int) style__
{
    return [super style];
}

// (UIAlertAction) @property(nonatomic, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIAlertAction (cm_crossmobile_ios_uikit_UIAlertAction)

// direct binding of: + (instancetype)actionWithTitle:(NSString *)title style:(UIAlertActionStyle)style handler:(void (^)(UIAlertAction *action))handler;
+ (instancetype) actionWithTitle___java_lang_String_int_org_robovm_objc_block_VoidBlock1:(NSString*) title :(int) style :(id<org_robovm_objc_block_VoidBlock1>) handler 
{
    id re$ult = [UIAlertAction actionWithTitle:(title == JAVA_NULL ? nil : title) style:style handler:(handler == JAVA_NULL ? nil : ^(UIAlertAction* action) {
        [handler invoke___java_lang_Object:(action ? action : JAVA_NULL)];
    })];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [self setEnabled:enabled];
}

// direct binding of: @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [self isEnabled];
}

// direct binding of: @property(nonatomic, readonly) UIAlertActionStyle style;
- (int) style__
{
    return [self style];
}

// direct binding of: @property(nonatomic, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
