// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIScreen implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIScreen.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIScreen$Ext

// (UIScreen) @property(nonatomic, readonly) CGRect applicationFrame;
- (crossmobile_ios_coregraphics_CGRect*) applicationFrame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super applicationFrame]];
}

// (UIScreen) @property(nonatomic, readonly) CGRect bounds;
- (crossmobile_ios_coregraphics_CGRect*) bounds__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[super bounds]];
}

// (UIScreen) @property(nonatomic, readonly) CGFloat scale;
- (double) scale__
{
    return [super scale];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIScreen (cm_crossmobile_ios_uikit_UIScreen)

// direct binding of: + (UIScreen *)mainScreen;
+ (UIScreen*) mainScreen__
{
    UIScreen* re$ult = [UIScreen mainScreen];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIScreen__
{
    return [self init];
}

// direct binding of: @property(nonatomic, readonly) CGRect applicationFrame;
- (crossmobile_ios_coregraphics_CGRect*) applicationFrame__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self applicationFrame]];
}

// direct binding of: @property(nonatomic, readonly) CGRect bounds;
- (crossmobile_ios_coregraphics_CGRect*) bounds__
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self bounds]];
}

// direct binding of: @property(nonatomic, readonly) CGFloat scale;
- (double) scale__
{
    return [self scale];
}

@end
