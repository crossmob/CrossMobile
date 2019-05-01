// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mediaplayer.MPVolumeView definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
@class crossmobile_ios_coregraphics_CGRect;

CM_EXPORT_CLASS
@interface crossmobile_ios_mediaplayer_MPVolumeView$Ext : MPVolumeView
@end

#define crossmobile_ios_mediaplayer_MPVolumeView MPVolumeView
@interface MPVolumeView (cm_crossmobile_ios_mediaplayer_MPVolumeView)
- (instancetype) __init_crossmobile_ios_mediaplayer_MPVolumeView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setShowsRouteButton___boolean:(BOOL) showsRouteButton ;
- (BOOL) showsRouteButton__;
- (void) setShowsVolumeSlider___boolean:(BOOL) showsVolumeSlider ;
- (BOOL) showsVolumeSlider__;
@end
