// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIEdgeInsets implementation

#import "crossmobile_ios_uikit_UIEdgeInsets.h"

@implementation crossmobile_ios_uikit_UIEdgeInsets

// direct binding of: extern const UIEdgeInsets UIEdgeInsetsZero;
+ (crossmobile_ios_uikit_UIEdgeInsets*) zero__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:UIEdgeInsetsZero];
}

// direct binding of: UIEdgeInsets UIEdgeInsetsMake(CGFloat top, CGFloat left, CGFloat bottom, CGFloat right);
- (crossmobile_ios_uikit_UIEdgeInsets*) __init_crossmobile_ios_uikit_UIEdgeInsets___double_double_double_double:(double) top :(double) left :(double) bottom :(double) right 
{
    return [self initWithUIEdgeInsets:UIEdgeInsetsMake(top, left, bottom, right)];
}

// direct binding of: CGFloat bottom;
- (void) setBottom___double:(double) bottom 
{
    self->bottom_double = bottom;
}

// direct binding of: CGFloat bottom;
- (double) getBottom__
{
    return self->bottom_double;
}

// direct binding of: CGFloat left;
- (void) setLeft___double:(double) left 
{
    self->left_double = left;
}

// direct binding of: CGFloat left;
- (double) getLeft__
{
    return self->left_double;
}

// direct binding of: CGFloat right;
- (void) setRight___double:(double) right 
{
    self->right_double = right;
}

// direct binding of: CGFloat right;
- (double) getRight__
{
    return self->right_double;
}

// direct binding of: CGFloat top;
- (void) setTop___double:(double) top 
{
    self->top_double = top;
}

// direct binding of: CGFloat top;
- (double) getTop__
{
    return self->top_double;
}

// direct binding of: BOOL UIEdgeInsetsEqualToEdgeInsets(UIEdgeInsets insets1, UIEdgeInsets insets2);
- (BOOL) equalToEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) insets2 
{
    return UIEdgeInsetsEqualToEdgeInsets([self getUIEdgeInsets], [insets2 getUIEdgeInsets]);
}

- (instancetype) initWithUIEdgeInsets:(UIEdgeInsets) other
{
    self = [super init];
    self->top_double = other.top;
    self->left_double = other.left;
    self->bottom_double = other.bottom;
    self->right_double = other.right;
    return self;
}

- (void) setUIEdgeInsets:(UIEdgeInsets) other
{
    self->top_double = other.top;
    self->left_double = other.left;
    self->bottom_double = other.bottom;
    self->right_double = other.right;
}

- (UIEdgeInsets) getUIEdgeInsets
{
    UIEdgeInsets result;
    result.top = self->top_double;
    result.left = self->left_double;
    result.bottom = self->bottom_double;
    result.right = self->right_double;
    return result;
}

@end
