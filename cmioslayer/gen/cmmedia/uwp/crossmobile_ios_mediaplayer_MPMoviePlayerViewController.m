// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_mediaplayer_MPMoviePlayerViewController implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_mediaplayer_MPMoviePlayerController.h"
#import "crossmobile_ios_mediaplayer_MPMoviePlayerViewController.h"

@implementation crossmobile_ios_mediaplayer_MPMoviePlayerViewController$Ext

@end

@implementation MPMoviePlayerViewController (cm_crossmobile_ios_mediaplayer_MPMoviePlayerViewController)

// - (instancetype)initWithContentURL:(NSURL *)contentURL;
- (instancetype) __init_crossmobile_ios_mediaplayer_MPMoviePlayerViewController___crossmobile_ios_foundation_NSURL:(NSURL*) contentURL 
{
    return [self initWithContentURL:(contentURL == JAVA_NULL ? nil : contentURL)];
}

// @property(nonatomic, readonly) MPMoviePlayerController *moviePlayer;
- (MPMoviePlayerController*) moviePlayer__
{
    MPMoviePlayerController* re$ult = [self moviePlayer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
