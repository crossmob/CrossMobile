// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.audiotoolbox.AudioServices implementation

#import "crossmobile_ios_audiotoolbox_AudioServices.h"

@implementation crossmobile_ios_audiotoolbox_AudioServices

// direct binding of: void AudioServicesPlaySystemSound ( SystemSoundID inSystemSoundID );
+ (void) playSystemSound___int:(int) inSystemSoundID 
{
    AudioServicesPlaySystemSound(inSystemSoundID);
}

@end
