// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAlertController implementation

#import "crossmobile_ios_uikit_UIAlertAction.h"
#import "crossmobile_ios_uikit_UIAlertController.h"
#import "crossmobile_ios_uikit_UITextField.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_uikit_UIAlertController$Ext

@end

@implementation UIAlertController (cm_crossmobile_ios_uikit_UIAlertController)

// + (instancetype)alertControllerWithTitle:(NSString *)title message:(NSString *)message preferredStyle:(UIAlertControllerStyle)preferredStyle;
+ (instancetype) alertControllerWithTitle___java_lang_String_java_lang_String_int:(NSString*) title :(NSString*) message :(int) preferredStyle 
{
    id re$ult = [UIAlertController alertControllerWithTitle:(title == JAVA_NULL ? nil : title) message:(message == JAVA_NULL ? nil : message) preferredStyle:preferredStyle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSArray<UIAlertAction *> *actions;
- (NSArray*) actions__
{
    NSArray* re$ult = [self actions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *message;
- (void) setMessage___java_lang_String:(NSString*) message 
{
    [self setMessage:(message == JAVA_NULL ? nil : message)];
}

// @property(nonatomic, copy) NSString *message;
- (NSString*) message__
{
    NSString* re$ult = [self message];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIAlertControllerStyle preferredStyle;
- (int) preferredStyle__
{
    return [self preferredStyle];
}

// @property(nonatomic, readonly) NSArray<UITextField *> *textFields;
- (NSArray*) textFields__
{
    NSArray* re$ult = [self textFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addAction:(UIAlertAction *)action;
- (void) addAction___crossmobile_ios_uikit_UIAlertAction:(UIAlertAction*) action 
{
    [self addAction:(action == JAVA_NULL ? nil : action)];
}

// - (void)addTextFieldWithConfigurationHandler:(void (^)(UITextField *textField))configurationHandler;
- (void) addTextFieldWithConfigurationHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) configurationHandler 
{
    [self addTextFieldWithConfigurationHandler:(configurationHandler == JAVA_NULL ? nil : ^(UITextField* textField) {
        [configurationHandler invoke___java_lang_Object:(textField ? textField : JAVA_NULL)];
    })];
}

@end
