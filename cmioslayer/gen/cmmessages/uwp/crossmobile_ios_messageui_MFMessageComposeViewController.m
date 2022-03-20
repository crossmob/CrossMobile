// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_messageui_MFMessageComposeViewController implementation

#import "crossmobile_ios_messageui_MFMessageComposeViewController.h"
#import "crossmobile_ios_messageui_MFMessageComposeViewControllerDelegate.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_messageui_MFMessageComposeViewController$Ext

@end

@implementation MFMessageComposeViewController (cm_crossmobile_ios_messageui_MFMessageComposeViewController)

// + (BOOL)canSendText;
+ (BOOL) canSendText__
{
    return [MFMessageComposeViewController canSendText];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_messageui_MFMessageComposeViewController__
{
    return [self init];
}

// @property(nonatomic, copy) NSString *body;
- (void) setBody___java_lang_String:(NSString*) body 
{
    [self setBody:(body == JAVA_NULL ? nil : body)];
}

// @property(nonatomic, copy) NSString *body;
- (NSString*) body__
{
    NSString* re$ult = [self body];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) id<MFMessageComposeViewControllerDelegate> messageComposeDelegate;
- (void) setMessageComposeDelegate___crossmobile_ios_messageui_MFMessageComposeViewControllerDelegate:(id<MFMessageComposeViewControllerDelegate>) messageComposeDelegate 
{
    objc_setAssociatedObject(self, @selector(setMessageComposeDelegate:), messageComposeDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setMessageComposeDelegate:(messageComposeDelegate == JAVA_NULL ? nil : messageComposeDelegate)];
}

// @property(nonatomic, assign) id<MFMessageComposeViewControllerDelegate> messageComposeDelegate;
- (id<MFMessageComposeViewControllerDelegate>) messageComposeDelegate__
{
    id<MFMessageComposeViewControllerDelegate> re$ult = [self messageComposeDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray<NSString *> *recipients;
- (void) setRecipients___java_util_List:(NSArray*) recipients 
{
    [self setRecipients:(recipients == JAVA_NULL ? nil : recipients)];
}

// @property(nonatomic, copy) NSArray<NSString *> *recipients;
- (NSArray*) recipients__
{
    NSArray* re$ult = [self recipients];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
