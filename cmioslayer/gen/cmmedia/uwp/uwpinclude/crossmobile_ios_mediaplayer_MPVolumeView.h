// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mediaplayer_MPVolumeView definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_mediaplayer_MPVolumeView$Ext : MPVolumeView
@end

#define crossmobile_ios_mediaplayer_MPVolumeView MPVolumeView
@interface MPVolumeView (cm_crossmobile_ios_mediaplayer_MPVolumeView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_mediaplayer_MPVolumeView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setShowsRouteButton___boolean:(BOOL) showsRouteButton ;
- (BOOL) showsRouteButton__;
- (void) setShowsVolumeSlider___boolean:(BOOL) showsVolumeSlider ;
- (BOOL) showsVolumeSlider__;
@end
