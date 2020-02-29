// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_audiotoolbox_AudioServices implementation

#import "crossmobile_ios_audiotoolbox_AudioServices.h"

@implementation crossmobile_ios_audiotoolbox_AudioServices

// void AudioServicesPlaySystemSound ( SystemSoundID inSystemSoundID );
+ (void) playSystemSound___int:(int) inSystemSoundID 
{
    AudioServicesPlaySystemSound(inSystemSoundID);
}

@end
