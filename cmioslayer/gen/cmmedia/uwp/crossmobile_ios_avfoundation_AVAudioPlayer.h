// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_avfoundation_AVAudioPlayer definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
@protocol crossmobile_ios_avfoundation_AVAudioPlayerDelegate;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_rt_StrongReference;

@interface crossmobile_ios_avfoundation_AVAudioPlayer$Ext : AVAudioPlayer
@end

#define crossmobile_ios_avfoundation_AVAudioPlayer AVAudioPlayer
@interface AVAudioPlayer (cm_crossmobile_ios_avfoundation_AVAudioPlayer)
+ (instancetype) initWithContentsOfURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) outError ;
+ (instancetype) initWithData___crossmobile_ios_foundation_NSData_crossmobile_rt_StrongReference:(NSData*) data :(crossmobile_rt_StrongReference*) outError ;
- (void) setCurrentTime___double:(double) currentTime ;
- (double) currentTime__;
- (NSData*) data__;
- (void) setDelegate___crossmobile_ios_avfoundation_AVAudioPlayerDelegate:(id<AVAudioPlayerDelegate>) delegate ;
- (id<AVAudioPlayerDelegate>) delegate__;
- (double) duration__;
- (int) numberOfChannels__;
- (void) setNumberOfLoops___int:(int) numberOfLoops ;
- (int) numberOfLoops__;
- (BOOL) isPlaying__;
- (NSURL*) url__;
- (void) setVolume___float:(float) volume ;
- (float) volume__;
- (void) pause__;
- (BOOL) play__;
- (BOOL) playAtTime___double:(double) time ;
- (BOOL) prepareToPlay__;
- (void) stop__;
@end
