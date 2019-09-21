// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_mediaplayer_MPMoviePlayerController definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_uikit_UIColor;

CM_EXPORT_CLASS
@interface crossmobile_ios_mediaplayer_MPMoviePlayerController$Ext : MPMoviePlayerController
@end

#define crossmobile_ios_mediaplayer_MPMoviePlayerController MPMoviePlayerController
@interface MPMoviePlayerController (cm_crossmobile_ios_mediaplayer_MPMoviePlayerController)
- (instancetype) __init_crossmobile_ios_mediaplayer_MPMoviePlayerController___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (NSURL*) contentURL__;
- (void) setInitialPlaybackTime___double:(double) initialPlaybackTime ;
- (double) initialPlaybackTime__;
- (void) setScalingMode___int:(int) scalingMode ;
- (int) scalingMode__;
- (UIColor*) backgroundColor__;
- (void) pause__;
- (void) play__;
- (void) stop__;
@end
