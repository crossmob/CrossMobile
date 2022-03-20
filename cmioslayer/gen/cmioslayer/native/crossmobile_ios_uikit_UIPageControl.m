// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPageControl implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIPageControl.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIPageControl$Ext

@end

@implementation UIPageControl (cm_crossmobile_ios_uikit_UIPageControl)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIPageControl appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIPageControl appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIPageControl__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIPageControl___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) NSInteger currentPage;
- (void) setCurrentPage___int:(int) currentPage 
{
    [self setCurrentPage:currentPage];
}

// @property(nonatomic) NSInteger currentPage;
- (int) currentPage__
{
    return [self currentPage];
}

// @property(nonatomic, strong) UIColor *currentPageIndicatorTintColor;
- (void) setCurrentPageIndicatorTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) currentPageIndicatorTintColor 
{
    [self setCurrentPageIndicatorTintColor:(currentPageIndicatorTintColor == JAVA_NULL ? nil : currentPageIndicatorTintColor)];
}

// @property(nonatomic, strong) UIColor *currentPageIndicatorTintColor;
- (UIColor*) currentPageIndicatorTintColor__
{
    UIColor* re$ult = [self currentPageIndicatorTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL defersCurrentPageDisplay;
- (void) setDefersCurrentPageDisplay___boolean:(BOOL) defersCurrentPageDisplay 
{
    [self setDefersCurrentPageDisplay:defersCurrentPageDisplay];
}

// @property(nonatomic) BOOL defersCurrentPageDisplay;
- (BOOL) defersCurrentPageDisplay__
{
    return [self defersCurrentPageDisplay];
}

// @property(nonatomic) BOOL hidesForSinglePage;
- (void) setHidesForSinglePage___boolean:(BOOL) hidesForSinglePage 
{
    [self setHidesForSinglePage:hidesForSinglePage];
}

// @property(nonatomic) BOOL hidesForSinglePage;
- (BOOL) hidesForSinglePage__
{
    return [self hidesForSinglePage];
}

// @property(nonatomic) NSInteger numberOfPages;
- (void) setNumberOfPages___int:(int) numberOfPages 
{
    [self setNumberOfPages:numberOfPages];
}

// @property(nonatomic) NSInteger numberOfPages;
- (int) numberOfPages__
{
    return [self numberOfPages];
}

// @property(nonatomic, strong) UIColor *pageIndicatorTintColor;
- (void) setPageIndicatorTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) pageIndicatorTintColor 
{
    [self setPageIndicatorTintColor:(pageIndicatorTintColor == JAVA_NULL ? nil : pageIndicatorTintColor)];
}

// @property(nonatomic, strong) UIColor *pageIndicatorTintColor;
- (UIColor*) pageIndicatorTintColor__
{
    UIColor* re$ult = [self pageIndicatorTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGSize)sizeForNumberOfPages:(NSInteger)pageCount;
- (crossmobile_ios_coregraphics_CGSize*) sizeForNumberOfPages___int:(int) pageCount 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self sizeForNumberOfPages:pageCount]];
}

// - (void)updateCurrentPageDisplay;
- (void) updateCurrentPageDisplay__
{
    [self updateCurrentPageDisplay];
}

@end
