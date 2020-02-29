// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_mediaplayer_MPMoviePlayerViewController definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_mediaplayer_MPMoviePlayerController;

@interface crossmobile_ios_mediaplayer_MPMoviePlayerViewController$Ext : MPMoviePlayerViewController
@end

#define crossmobile_ios_mediaplayer_MPMoviePlayerViewController MPMoviePlayerViewController
@interface MPMoviePlayerViewController (cm_crossmobile_ios_mediaplayer_MPMoviePlayerViewController)
- (instancetype) __init_crossmobile_ios_mediaplayer_MPMoviePlayerViewController___crossmobile_ios_foundation_NSURL:(NSURL*) contentURL ;
- (MPMoviePlayerController*) moviePlayer__;
@end
