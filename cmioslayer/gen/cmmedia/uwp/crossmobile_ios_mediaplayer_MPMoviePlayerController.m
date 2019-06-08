// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.mediaplayer.MPMoviePlayerController implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_mediaplayer_MPMoviePlayerController.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

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

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (MPMoviePlayerController) - (UIColor *)backgroundColor;
- (UIColor*) backgroundColor__
{
    UIColor* re$ult = [super backgroundColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
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

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
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

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
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
