// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITableViewCell implementation

#import "crossmobile_ios_uikit_UIImageView.h"
#import "crossmobile_ios_uikit_UILabel.h"
#import "crossmobile_ios_uikit_UITableViewCell.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UITableViewCell$Ext

@end

@implementation UITableViewCell (cm_crossmobile_ios_uikit_UITableViewCell)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITableViewCell appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UITableViewCell appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier;
- (instancetype) __init_crossmobile_ios_uikit_UITableViewCell___int_java_lang_String:(int) style :(NSString*) reuseIdentifier 
{
    return [self initWithStyle:style reuseIdentifier:(reuseIdentifier == JAVA_NULL ? nil : reuseIdentifier)];
}

// @property(nonatomic) UITableViewCellAccessoryType accessoryType;
- (void) setAccessoryType___int:(int) accessoryType 
{
    [self setAccessoryType:accessoryType];
}

// @property(nonatomic) UITableViewCellAccessoryType accessoryType;
- (int) accessoryType__
{
    return [self accessoryType];
}

// @property(nonatomic, strong) UIView *accessoryView;
- (void) setAccessoryView___crossmobile_ios_uikit_UIView:(UIView*) accessoryView 
{
    [self setAccessoryView:(accessoryView == JAVA_NULL ? nil : accessoryView)];
}

// @property(nonatomic, strong) UIView *accessoryView;
- (UIView*) accessoryView__
{
    UIView* re$ult = [self accessoryView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIView *backgroundView;
- (void) setBackgroundView___crossmobile_ios_uikit_UIView:(UIView*) backgroundView 
{
    [self setBackgroundView:(backgroundView == JAVA_NULL ? nil : backgroundView)];
}

// @property(nonatomic, strong) UIView *backgroundView;
- (UIView*) backgroundView__
{
    UIView* re$ult = [self backgroundView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIView *contentView;
- (UIView*) contentView__
{
    UIView* re$ult = [self contentView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UILabel *detailTextLabel;
- (UILabel*) detailTextLabel__
{
    UILabel* re$ult = [self detailTextLabel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UITableViewCellEditingStyle editingStyle;
- (int) editingStyle__
{
    return [self editingStyle];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [self setHighlighted:highlighted];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [self isHighlighted];
}

// @property(nonatomic, readonly, strong) UIImageView *imageView;
- (UIImageView*) imageView__
{
    UIImageView* re$ult = [self imageView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *reuseIdentifier;
- (NSString*) reuseIdentifier__
{
    NSString* re$ult = [self reuseIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isSelected) BOOL selected;
- (void) setSelected___boolean:(BOOL) selected 
{
    [self setSelected:selected];
}

// @property(nonatomic, getter=isSelected) BOOL selected;
- (BOOL) isSelected__
{
    return [self isSelected];
}

// @property(nonatomic, strong) UIView *selectedBackgroundView;
- (void) setSelectedBackgroundView___crossmobile_ios_uikit_UIView:(UIView*) selectedBackgroundView 
{
    [self setSelectedBackgroundView:(selectedBackgroundView == JAVA_NULL ? nil : selectedBackgroundView)];
}

// @property(nonatomic, strong) UIView *selectedBackgroundView;
- (UIView*) selectedBackgroundView__
{
    UIView* re$ult = [self selectedBackgroundView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UITableViewCellSelectionStyle selectionStyle;
- (void) setSelectionStyle___int:(int) selectionStyle 
{
    [self setSelectionStyle:selectionStyle];
}

// @property(nonatomic) UITableViewCellSelectionStyle selectionStyle;
- (int) selectionStyle__
{
    return [self selectionStyle];
}

// @property(nonatomic, readonly, strong) UILabel *textLabel;
- (UILabel*) textLabel__
{
    UILabel* re$ult = [self textLabel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)prepareForReuse;
- (void) prepareForReuse__
{
    [self prepareForReuse];
}

@end
