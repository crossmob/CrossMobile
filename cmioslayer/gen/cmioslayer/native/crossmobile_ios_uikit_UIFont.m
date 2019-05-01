// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIFont implementation

#import "crossmobile_ios_uikit_UIFont.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIFont$Ext

// (UIFont) @property(nonatomic, readonly, strong) NSString *familyName;
- (NSString*) familyName__
{
    NSString* re$ult = [super familyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIFont) @property(nonatomic, readonly, strong) NSString *fontName;
- (NSString*) fontName__
{
    NSString* re$ult = [super fontName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIFont) @property(nonatomic, readonly) CGFloat pointSize;
- (double) pointSize__
{
    return [super pointSize];
}

// (UIFont) - (UIFont *)fontWithSize:(CGFloat)fontSize;
- (UIFont*) fontWithSize___double:(double) fontSize 
{
    UIFont* re$ult = [super fontWithSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation UIFont (cm_crossmobile_ios_uikit_UIFont)

// direct binding of: + (UIFont *)boldSystemFontOfSize:(CGFloat)fontSize;
+ (UIFont*) boldSystemFontOfSize___double:(double) fontSize 
{
    UIFont* re$ult = [UIFont boldSystemFontOfSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (CGFloat)buttonFontSize;
+ (double) buttonFontSize__
{
    return [UIFont buttonFontSize];
}

// direct binding of: + (NSArray<NSString *>*) familyNames;
+ (NSArray*) familyNames__
{
    NSArray* re$ult = [UIFont familyNames];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSArray<NSString *> *)fontNamesForFamilyName:(NSString *)familyName;
+ (NSArray*) fontNamesForFamilyName___java_lang_String:(NSString*) familyName 
{
    NSArray* re$ult = [UIFont fontNamesForFamilyName:(familyName == JAVA_NULL ? nil : familyName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIFont *)fontWithName:(NSString *)fontName size:(CGFloat)fontSize;
+ (UIFont*) fontWithName___java_lang_String_double:(NSString*) fontName :(double) fontSize 
{
    UIFont* re$ult = [UIFont fontWithName:(fontName == JAVA_NULL ? nil : fontName) size:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIFont *)italicSystemFontOfSize:(CGFloat)fontSize;
+ (UIFont*) italicSystemFontOfSize___double:(double) fontSize 
{
    UIFont* re$ult = [UIFont italicSystemFontOfSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (CGFloat)labelFontSize;
+ (double) labelFontSize__
{
    return [UIFont labelFontSize];
}

// direct binding of: + (CGFloat)smallSystemFontSize;
+ (double) smallSystemFontSize__
{
    return [UIFont smallSystemFontSize];
}

// direct binding of: + (UIFont *)systemFontOfSize:(CGFloat)fontSize;
+ (UIFont*) systemFontOfSize___double:(double) fontSize 
{
    UIFont* re$ult = [UIFont systemFontOfSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (CGFloat)systemFontSize;
+ (double) systemFontSize__
{
    return [UIFont systemFontSize];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *familyName;
- (NSString*) familyName__
{
    NSString* re$ult = [self familyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *fontName;
- (NSString*) fontName__
{
    NSString* re$ult = [self fontName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) CGFloat pointSize;
- (double) pointSize__
{
    return [self pointSize];
}

// direct binding of: - (UIFont *)fontWithSize:(CGFloat)fontSize;
- (UIFont*) fontWithSize___double:(double) fontSize 
{
    UIFont* re$ult = [self fontWithSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
