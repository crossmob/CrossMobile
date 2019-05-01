// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UITableViewCell definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIImageView;
@class crossmobile_ios_uikit_UILabel;
@class crossmobile_ios_uikit_UIView;
@class java_lang_String;

@interface crossmobile_ios_uikit_UITableViewCell$Ext : UITableViewCell
@end

#define crossmobile_ios_uikit_UITableViewCell UITableViewCell
@interface UITableViewCell (cm_crossmobile_ios_uikit_UITableViewCell)
- (instancetype) __init_crossmobile_ios_uikit_UITableViewCell___int_java_lang_String:(int) style :(NSString*) reuseIdentifier ;
- (void) setAccessoryType___int:(int) accessoryType ;
- (void) setAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) accessoryView ;
- (UIView*) accessoryView__;
- (void) setBackgroundView___crossmobile_ios_uikit_UIView:(UIView*) backgroundView ;
- (UIView*) backgroundView__;
- (UIView*) contentView__;
- (UILabel*) detailTextLabel__;
- (int) editingStyle__;
- (void) setHighlighted___boolean:(BOOL) highlighted ;
- (BOOL) isHighlighted__;
- (UIImageView*) imageView__;
- (NSString*) reuseIdentifier__;
- (void) setSelected___boolean:(BOOL) selected ;
- (BOOL) isSelected__;
- (void) setSelectedBackgroundView___crossmobile_ios_uikit_UIView:(UIView*) selectedBackgroundView ;
- (UIView*) selectedBackgroundView__;
- (void) setSelectionStyle___int:(int) selectionStyle ;
- (int) selectionStyle__;
- (UILabel*) textLabel__;
@end
