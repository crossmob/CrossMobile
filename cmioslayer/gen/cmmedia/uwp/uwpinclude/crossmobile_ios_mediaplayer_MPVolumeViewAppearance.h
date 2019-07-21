// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mediaplayer.MPVolumeViewAppearance definition

#import "xmlvm.h"
#import <AVFoundation/AVFoundation.h>
#import <AudioToolbox/AudioToolbox.h>
#import <MediaPlayer/MediaPlayer.h>
#import "crossmobile_ios_foundation_NSObject.h"
@class crossmobile_ios_uikit_UIColor;

CM_EXPORT_CLASS
@interface crossmobile_ios_mediaplayer_MPVolumeViewAppearance : crossmobile_ios_foundation_NSObject {
@public id $reference;
}

- (void) setBackgroundColor___crossmobile_ios_uikit_UIColor:(UIColor*) backgroundColor ;
- (instancetype) initWithMPVolumeViewAppearance:(id) reference;
@end
