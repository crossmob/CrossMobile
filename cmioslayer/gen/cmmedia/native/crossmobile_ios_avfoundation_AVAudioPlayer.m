// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_avfoundation_AVAudioPlayer implementation

#import "crossmobile_ios_avfoundation_AVAudioPlayer.h"
#import "crossmobile_ios_avfoundation_AVAudioPlayerDelegate.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_rt_StrongReference.h"

@implementation crossmobile_ios_avfoundation_AVAudioPlayer$Ext

@end

@implementation AVAudioPlayer (cm_crossmobile_ios_avfoundation_AVAudioPlayer)

// - (instancetype)initWithContentsOfURL:(NSURL *)url error:(NSError * _Nullable *)outError;
+ (instancetype) initWithContentsOfURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) outError 
{
    outError = outError == JAVA_NULL ? nil : outError;
    id outError$conv = nil;
    id re$ult = [[AVAudioPlayer alloc] initWithContentsOfURL:(url == JAVA_NULL ? nil : url) error:(outError ? &outError$conv : nil)];
    if (outError)
        [outError set___java_lang_Object:(outError$conv ? outError$conv : JAVA_NULL)];
    return re$ult;
}

// - (instancetype)initWithData:(NSData *)data error:(NSError * _Nullable *)outError;
+ (instancetype) initWithData___crossmobile_ios_foundation_NSData_crossmobile_rt_StrongReference:(NSData*) data :(crossmobile_rt_StrongReference*) outError 
{
    outError = outError == JAVA_NULL ? nil : outError;
    id outError$conv = nil;
    id re$ult = [[AVAudioPlayer alloc] initWithData:(data == JAVA_NULL ? nil : data) error:(outError ? &outError$conv : nil)];
    if (outError)
        [outError set___java_lang_Object:(outError$conv ? outError$conv : JAVA_NULL)];
    return re$ult;
}

// @property NSTimeInterval currentTime;
- (void) setCurrentTime___double:(double) currentTime 
{
    [self setCurrentTime:currentTime];
}

// @property NSTimeInterval currentTime;
- (double) currentTime__
{
    return [self currentTime];
}

// @property(readonly) NSData *data;
- (NSData*) data__
{
    NSData* re$ult = [self data];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(assign) id<AVAudioPlayerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_avfoundation_AVAudioPlayerDelegate:(id<AVAudioPlayerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(assign) id<AVAudioPlayerDelegate> delegate;
- (id<AVAudioPlayerDelegate>) delegate__
{
    id<AVAudioPlayerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSTimeInterval duration;
- (double) duration__
{
    return [self duration];
}

// @property(readonly) NSUInteger numberOfChannels;
- (int) numberOfChannels__
{
    return [self numberOfChannels];
}

// @property NSInteger numberOfLoops;
- (void) setNumberOfLoops___int:(int) numberOfLoops 
{
    [self setNumberOfLoops:numberOfLoops];
}

// @property NSInteger numberOfLoops;
- (int) numberOfLoops__
{
    return [self numberOfLoops];
}

// @property(readonly, getter=isPlaying) BOOL playing;
- (BOOL) isPlaying__
{
    return [self isPlaying];
}

// @property(readonly) NSURL *url;
- (NSURL*) url__
{
    NSURL* re$ult = [self url];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property float volume;
- (void) setVolume___float:(float) volume 
{
    [self setVolume:volume];
}

// @property float volume;
- (float) volume__
{
    return [self volume];
}

// - (void)pause;
- (void) pause__
{
    [self pause];
}

// - (BOOL)play;
- (BOOL) play__
{
    return [self play];
}

// - (BOOL)playAtTime:(NSTimeInterval)time;
- (BOOL) playAtTime___double:(double) time 
{
    return [self playAtTime:time];
}

// - (BOOL)prepareToPlay;
- (BOOL) prepareToPlay__
{
    return [self prepareToPlay];
}

// - (void)stop;
- (void) stop__
{
    [self stop];
}

@end
