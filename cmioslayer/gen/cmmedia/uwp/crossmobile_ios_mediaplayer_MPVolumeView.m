// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mediaplayer_MPVolumeView implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_mediaplayer_MPVolumeView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_mediaplayer_MPVolumeView$Ext

@end

@implementation MPVolumeView (cm_crossmobile_ios_mediaplayer_MPVolumeView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MPVolumeView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[MPVolumeView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_mediaplayer_MPVolumeView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) BOOL showsRouteButton;
- (void) setShowsRouteButton___boolean:(BOOL) showsRouteButton 
{
    [self setShowsRouteButton:showsRouteButton];
}

// @property(nonatomic) BOOL showsRouteButton;
- (BOOL) showsRouteButton__
{
    return [self showsRouteButton];
}

// @property(nonatomic) BOOL showsVolumeSlider;
- (void) setShowsVolumeSlider___boolean:(BOOL) showsVolumeSlider 
{
    [self setShowsVolumeSlider:showsVolumeSlider];
}

// @property(nonatomic) BOOL showsVolumeSlider;
- (BOOL) showsVolumeSlider__
{
    return [self showsVolumeSlider];
}

@end
