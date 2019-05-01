// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.avfoundation.AVAudioPlayer implementation

#import "crossmobile_ios_avfoundation_AVAudioPlayer.h"
#import "crossmobile_ios_avfoundation_AVAudioPlayerDelegate.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_avfoundation_AVAudioPlayer$Ext

// (AVAudioPlayer) @property NSTimeInterval currentTime;
- (void) setCurrentTime___double:(double) currentTime 
{
    [super setCurrentTime:currentTime];
}

// (AVAudioPlayer) @property NSTimeInterval currentTime;
- (double) currentTime__
{
    return [super currentTime];
}

// (AVAudioPlayer) @property(readonly) NSData *data;
- (NSData*) data__
{
    NSData* re$ult = [super data];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (AVAudioPlayer) @property(assign) id<AVAudioPlayerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_avfoundation_AVAudioPlayerDelegate:(id<AVAudioPlayerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (AVAudioPlayer) @property(assign) id<AVAudioPlayerDelegate> delegate;
- (id<AVAudioPlayerDelegate>) delegate__
{
    id<AVAudioPlayerDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (AVAudioPlayer) @property(readonly) NSTimeInterval duration;
- (double) duration__
{
    return [super duration];
}

// (AVAudioPlayer) @property(readonly) NSUInteger numberOfChannels;
- (int) numberOfChannels__
{
    return [super numberOfChannels];
}

// (AVAudioPlayer) @property NSInteger numberOfLoops;
- (void) setNumberOfLoops___int:(int) numberOfLoops 
{
    [super setNumberOfLoops:numberOfLoops];
}

// (AVAudioPlayer) @property NSInteger numberOfLoops;
- (int) numberOfLoops__
{
    return [super numberOfLoops];
}

// (AVAudioPlayer) @property(readonly, getter=isPlaying) BOOL playing;
- (BOOL) isPlaying__
{
    return [super isPlaying];
}

// (AVAudioPlayer) @property(readonly) NSURL *url;
- (NSURL*) url__
{
    NSURL* re$ult = [super url];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (AVAudioPlayer) @property float volume;
- (void) setVolume___float:(float) volume 
{
    [super setVolume:volume];
}

// (AVAudioPlayer) @property float volume;
- (float) volume__
{
    return [super volume];
}

// (AVAudioPlayer) - (void)pause;
- (void) pause__
{
    [super pause];
}

// (AVAudioPlayer) - (BOOL)play;
- (BOOL) play__
{
    return [super play];
}

// (AVAudioPlayer) - (BOOL)playAtTime:(NSTimeInterval)time;
- (BOOL) playAtTime___double:(double) time 
{
    return [super playAtTime:time];
}

// (AVAudioPlayer) - (BOOL)prepareToPlay;
- (BOOL) prepareToPlay__
{
    return [super prepareToPlay];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (AVAudioPlayer) - (void)stop;
- (void) stop__
{
    [super stop];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation AVAudioPlayer (cm_crossmobile_ios_avfoundation_AVAudioPlayer)

// direct binding of: - (instancetype)initWithData:(NSData *)data error:(NSError * _Nullable *)outError;
- (instancetype) __init_crossmobile_ios_avfoundation_AVAudioPlayer___crossmobile_ios_foundation_NSData_crossmobile_rt_StrongReference:(NSData*) data :(crossmobile_rt_StrongReference*) outError 
{
    outError = outError == JAVA_NULL ? nil : outError;
    id outError$conv = nil;
    id re$ult = [self initWithData:(data == JAVA_NULL ? nil : data) error:(outError ? &outError$conv : nil)];
    if (outError)
        [outError set___java_lang_Object:(outError$conv ? outError$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: - (instancetype)initWithContentsOfURL:(NSURL *)url error:(NSError * _Nullable *)outError;
- (instancetype) __init_crossmobile_ios_avfoundation_AVAudioPlayer___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) outError 
{
    outError = outError == JAVA_NULL ? nil : outError;
    id outError$conv = nil;
    id re$ult = [self initWithContentsOfURL:(url == JAVA_NULL ? nil : url) error:(outError ? &outError$conv : nil)];
    if (outError)
        [outError set___java_lang_Object:(outError$conv ? outError$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: @property NSTimeInterval currentTime;
- (void) setCurrentTime___double:(double) currentTime 
{
    [self setCurrentTime:currentTime];
}

// direct binding of: @property NSTimeInterval currentTime;
- (double) currentTime__
{
    return [self currentTime];
}

// direct binding of: @property(readonly) NSData *data;
- (NSData*) data__
{
    NSData* re$ult = [self data];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(assign) id<AVAudioPlayerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_avfoundation_AVAudioPlayerDelegate:(id<AVAudioPlayerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(assign) id<AVAudioPlayerDelegate> delegate;
- (id<AVAudioPlayerDelegate>) delegate__
{
    id<AVAudioPlayerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) NSTimeInterval duration;
- (double) duration__
{
    return [self duration];
}

// direct binding of: @property(readonly) NSUInteger numberOfChannels;
- (int) numberOfChannels__
{
    return [self numberOfChannels];
}

// direct binding of: @property NSInteger numberOfLoops;
- (void) setNumberOfLoops___int:(int) numberOfLoops 
{
    [self setNumberOfLoops:numberOfLoops];
}

// direct binding of: @property NSInteger numberOfLoops;
- (int) numberOfLoops__
{
    return [self numberOfLoops];
}

// direct binding of: @property(readonly, getter=isPlaying) BOOL playing;
- (BOOL) isPlaying__
{
    return [self isPlaying];
}

// direct binding of: @property(readonly) NSURL *url;
- (NSURL*) url__
{
    NSURL* re$ult = [self url];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property float volume;
- (void) setVolume___float:(float) volume 
{
    [self setVolume:volume];
}

// direct binding of: @property float volume;
- (float) volume__
{
    return [self volume];
}

// direct binding of: - (void)pause;
- (void) pause__
{
    [self pause];
}

// direct binding of: - (BOOL)play;
- (BOOL) play__
{
    return [self play];
}

// direct binding of: - (BOOL)playAtTime:(NSTimeInterval)time;
- (BOOL) playAtTime___double:(double) time 
{
    return [self playAtTime:time];
}

// direct binding of: - (BOOL)prepareToPlay;
- (BOOL) prepareToPlay__
{
    return [self prepareToPlay];
}

// direct binding of: - (void)stop;
- (void) stop__
{
    [self stop];
}

@end
