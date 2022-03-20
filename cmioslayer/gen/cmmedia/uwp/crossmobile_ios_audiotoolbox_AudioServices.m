// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_audiotoolbox_AudioServices implementation

#import "crossmobile_ios_audiotoolbox_AudioServices.h"

@implementation crossmobile_ios_audiotoolbox_AudioServices

// void AudioServicesPlaySystemSound ( SystemSoundID inSystemSoundID );
+ (void) playSystemSound___int:(int) inSystemSoundID 
{
    AudioServicesPlaySystemSound(inSystemSoundID);
}

@end
