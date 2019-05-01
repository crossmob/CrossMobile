// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mediaplayer.MPMoviePlayerController implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_mediaplayer_MPMoviePlayerController.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_mediaplayer_MPMoviePlayerController$Ext

// (MPMoviePlayerController) @property(nonatomic, copy) NSURL *contentURL;
- (NSURL*) contentURL__
{
    NSURL* re$ult = [super contentURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MPMoviePlayerController) @property(nonatomic) NSTimeInterval initialPlaybackTime;
- (void) setInitialPlaybackTime___double:(double) initialPlaybackTime 
{
    [super setInitialPlaybackTime:initialPlaybackTime];
}

// (MPMoviePlayerController) @property(nonatomic) NSTimeInterval initialPlaybackTime;
- (double) initialPlaybackTime__
{
    return [super initialPlaybackTime];
}

// (MPMoviePlayerController) @property(nonatomic) MPMovieScalingMode scalingMode;
- (void) setScalingMode___int:(int) scalingMode 
{
    [super setScalingMode:scalingMode];
}

// (MPMoviePlayerController) @property(nonatomic) MPMovieScalingMode scalingMode;
- (int) scalingMode__
{
    return [super scalingMode];
}

// (MPMoviePlayerController) - (UIColor *)backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [super backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (MPMoviePlayerController) - (void)pause;
- (void) pause__
{
    [super pause];
}

// (MPMoviePlayerController) - (void)play;
- (void) play__
{
    [super play];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (MPMoviePlayerController) - (void)stop;
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

@implementation MPMoviePlayerController (cm_crossmobile_ios_mediaplayer_MPMoviePlayerController)

// direct binding of: - (instancetype)initWithContentURL:(NSURL *)url;
- (instancetype) __init_crossmobile_ios_mediaplayer_MPMoviePlayerController___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [self initWithContentURL:(url == JAVA_NULL ? nil : url)];
}

// direct binding of: @property(nonatomic, copy) NSURL *contentURL;
- (NSURL*) contentURL__
{
    NSURL* re$ult = [self contentURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) NSTimeInterval initialPlaybackTime;
- (void) setInitialPlaybackTime___double:(double) initialPlaybackTime 
{
    [self setInitialPlaybackTime:initialPlaybackTime];
}

// direct binding of: @property(nonatomic) NSTimeInterval initialPlaybackTime;
- (double) initialPlaybackTime__
{
    return [self initialPlaybackTime];
}

// direct binding of: @property(nonatomic) MPMovieScalingMode scalingMode;
- (void) setScalingMode___int:(int) scalingMode 
{
    [self setScalingMode:scalingMode];
}

// direct binding of: @property(nonatomic) MPMovieScalingMode scalingMode;
- (int) scalingMode__
{
    return [self scalingMode];
}

// direct binding of: - (UIColor *)backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [self backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)pause;
- (void) pause__
{
    [self pause];
}

// direct binding of: - (void)play;
- (void) play__
{
    [self play];
}

// direct binding of: - (void)stop;
- (void) stop__
{
    [self stop];
}

@end
