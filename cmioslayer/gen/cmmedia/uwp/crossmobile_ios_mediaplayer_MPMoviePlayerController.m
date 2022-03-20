// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mediaplayer_MPMoviePlayerController implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_mediaplayer_MPMoviePlayerController.h"
#import "crossmobile_ios_uikit_UIColor.h"

@implementation crossmobile_ios_mediaplayer_MPMoviePlayerController$Ext

@end

@implementation MPMoviePlayerController (cm_crossmobile_ios_mediaplayer_MPMoviePlayerController)

// - (instancetype)initWithContentURL:(NSURL *)url;
- (instancetype) __init_crossmobile_ios_mediaplayer_MPMoviePlayerController___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [self initWithContentURL:(url == JAVA_NULL ? nil : url)];
}

// @property(nonatomic, copy) NSURL *contentURL;
- (NSURL*) contentURL__
{
    NSURL* re$ult = [self contentURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSTimeInterval initialPlaybackTime;
- (void) setInitialPlaybackTime___double:(double) initialPlaybackTime 
{
    [self setInitialPlaybackTime:initialPlaybackTime];
}

// @property(nonatomic) NSTimeInterval initialPlaybackTime;
- (double) initialPlaybackTime__
{
    return [self initialPlaybackTime];
}

// @property(nonatomic) MPMovieScalingMode scalingMode;
- (void) setScalingMode___int:(int) scalingMode 
{
    [self setScalingMode:scalingMode];
}

// @property(nonatomic) MPMovieScalingMode scalingMode;
- (int) scalingMode__
{
    return [self scalingMode];
}

// - (UIColor *)backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [self backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)pause;
- (void) pause__
{
    [self pause];
}

// - (void)play;
- (void) play__
{
    [self play];
}

// - (void)stop;
- (void) stop__
{
    [self stop];
}

@end
