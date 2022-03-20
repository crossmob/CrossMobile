// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISearchBar implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UISearchBar.h"
#import "crossmobile_ios_uikit_UISearchBarDelegate.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UISearchBar$Ext

@end

@implementation UISearchBar (cm_crossmobile_ios_uikit_UISearchBar)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISearchBar appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISearchBar appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISearchBar__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UISearchBar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) UITextAutocapitalizationType autocapitalizationType ;
- (void) setAutocapitalizationType___int:(int) autocapitalizationType 
{
    [self setAutocapitalizationType:autocapitalizationType];
}

// @property(nonatomic) UITextAutocapitalizationType autocapitalizationType ;
- (int) autocapitalizationType__
{
    return [self autocapitalizationType];
}

// @property(nonatomic) UITextAutocorrectionType autocorrectionType ;
- (void) setAutocorrectionType___int:(int) autocorrectionType 
{
    [self setAutocorrectionType:autocorrectionType];
}

// @property(nonatomic) UITextAutocorrectionType autocorrectionType ;
- (int) autocorrectionType__
{
    return [self autocorrectionType];
}

// @property(nonatomic) UIBarStyle barStyle;
- (void) setBarStyle___int:(int) barStyle 
{
    [self setBarStyle:barStyle];
}

// @property(nonatomic) UIBarStyle barStyle;
- (int) barStyle__
{
    return [self barStyle];
}

// @property(nonatomic, strong) UIColor *barTintColor;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor 
{
    [self setBarTintColor:(barTintColor == JAVA_NULL ? nil : barTintColor)];
}

// @property(nonatomic, strong) UIColor *barTintColor;
- (UIColor*) barTintColor__
{
    UIColor* re$ult = [self barTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<UISearchBarDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UISearchBarDelegate:(id<UISearchBarDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<UISearchBarDelegate> delegate;
- (id<UISearchBarDelegate>) delegate__
{
    id<UISearchBarDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIKeyboardType keyboardType ;
- (void) setKeyboardType___int:(int) keyboardType 
{
    [self setKeyboardType:keyboardType];
}

// @property(nonatomic) UIKeyboardType keyboardType ;
- (int) keyboardType__
{
    return [self keyboardType];
}

// @property(nonatomic, copy) NSString *placeholder;
- (void) setPlaceholder___java_lang_String:(NSString*) placeholder 
{
    [self setPlaceholder:(placeholder == JAVA_NULL ? nil : placeholder)];
}

// @property(nonatomic, copy) NSString *placeholder;
- (NSString*) placeholder__
{
    NSString* re$ult = [self placeholder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *prompt;
- (void) setPrompt___java_lang_String:(NSString*) prompt 
{
    [self setPrompt:(prompt == JAVA_NULL ? nil : prompt)];
}

// @property(nonatomic, copy) NSString *prompt;
- (NSString*) prompt__
{
    NSString* re$ult = [self prompt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray<NSString *> *scopeButtonTitles;
- (void) setScopeButtonTitles___java_util_List:(NSArray*) scopeButtonTitles 
{
    [self setScopeButtonTitles:(scopeButtonTitles == JAVA_NULL ? nil : scopeButtonTitles)];
}

// @property(nonatomic, copy) NSArray<NSString *> *scopeButtonTitles;
- (NSArray*) scopeButtonTitles__
{
    NSArray* re$ult = [self scopeButtonTitles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UISearchBarStyle searchBarStyle;
- (void) setSearchBarStyle___int:(int) searchBarStyle 
{
    [self setSearchBarStyle:searchBarStyle];
}

// @property(nonatomic) UISearchBarStyle searchBarStyle;
- (int) searchBarStyle__
{
    return [self searchBarStyle];
}

// @property(nonatomic) NSInteger selectedScopeButtonIndex;
- (void) setSelectedScopeButtonIndex___int:(int) selectedScopeButtonIndex 
{
    [self setSelectedScopeButtonIndex:selectedScopeButtonIndex];
}

// @property(nonatomic) NSInteger selectedScopeButtonIndex;
- (int) selectedScopeButtonIndex__
{
    return [self selectedScopeButtonIndex];
}

// @property(nonatomic) BOOL showsBookmarkButton;
- (void) setShowsBookmarkButton___boolean:(BOOL) showsBookmarkButton 
{
    [self setShowsBookmarkButton:showsBookmarkButton];
}

// @property(nonatomic) BOOL showsBookmarkButton;
- (BOOL) showsBookmarkButton__
{
    return [self showsBookmarkButton];
}

// @property(nonatomic) BOOL showsCancelButton;
- (void) setShowsCancelButton___boolean:(BOOL) showsCancelButton 
{
    [self setShowsCancelButton:showsCancelButton];
}

// @property(nonatomic) BOOL showsCancelButton;
- (BOOL) showsCancelButton__
{
    return [self showsCancelButton];
}

// @property(nonatomic) BOOL showsScopeBar;
- (void) setShowsScopeBar___boolean:(BOOL) showsScopeBar 
{
    [self setShowsScopeBar:showsScopeBar];
}

// @property(nonatomic) BOOL showsScopeBar;
- (BOOL) showsScopeBar__
{
    return [self showsScopeBar];
}

// @property(nonatomic, copy) NSString *text;
- (void) setText___java_lang_String:(NSString*) text 
{
    [self setText:(text == JAVA_NULL ? nil : text)];
}

// @property(nonatomic, copy) NSString *text;
- (NSString*) text__
{
    NSString* re$ult = [self text];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign, getter=isTranslucent) BOOL translucent;
- (void) setTranslucent___boolean:(BOOL) translucent 
{
    [self setTranslucent:translucent];
}

// @property(nonatomic, assign, getter=isTranslucent) BOOL translucent;
- (BOOL) isTranslucent__
{
    return [self isTranslucent];
}

// - (void)setImage:(UIImage *)iconImage forSearchBarIcon:(UISearchBarIcon)icon state:(UIControlState)state;
- (void) setImage___crossmobile_ios_uikit_UIImage_int_int:(UIImage*) iconImage :(int) icon :(int) state 
{
    [self setImage:(iconImage == JAVA_NULL ? nil : iconImage) forSearchBarIcon:icon state:state];
}

@end
