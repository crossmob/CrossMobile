// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_avfoundation_AVAudioPlayerDelegate definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
@class crossmobile_ios_avfoundation_AVAudioPlayer;
@class crossmobile_ios_foundation_NSError;

CM_EXPORT_CLASS
@protocol crossmobile_ios_avfoundation_AVAudioPlayerDelegate
- (void) beginInterruption___crossmobile_ios_avfoundation_AVAudioPlayer:(AVAudioPlayer*) player ;
- (void) decodeErrorDidOccur___crossmobile_ios_avfoundation_AVAudioPlayer_crossmobile_ios_foundation_NSError:(AVAudioPlayer*) player :(NSError*) error ;
- (void) didFinishPlaying___crossmobile_ios_avfoundation_AVAudioPlayer_boolean:(AVAudioPlayer*) player :(BOOL) flag ;
- (void) endInterruption___crossmobile_ios_avfoundation_AVAudioPlayer:(AVAudioPlayer*) player ;
@end
