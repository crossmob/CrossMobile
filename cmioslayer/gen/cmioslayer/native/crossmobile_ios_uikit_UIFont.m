// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIFont implementation

#import "crossmobile_ios_uikit_UIFont.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIFont$Ext

@end

@implementation UIFont (cm_crossmobile_ios_uikit_UIFont)

// + (UIFont *)boldSystemFontOfSize:(CGFloat)fontSize;
+ (UIFont*) boldSystemFontOfSize___double:(double) fontSize 
{
    UIFont* re$ult = [UIFont boldSystemFontOfSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (CGFloat)buttonFontSize;
+ (double) buttonFontSize__
{
    return [UIFont buttonFontSize];
}

// + (NSArray<NSString *>*) familyNames;
+ (NSArray*) familyNames__
{
    NSArray* re$ult = [UIFont familyNames];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSArray<NSString *> *)fontNamesForFamilyName:(NSString *)familyName;
+ (NSArray*) fontNamesForFamilyName___java_lang_String:(NSString*) familyName 
{
    NSArray* re$ult = [UIFont fontNamesForFamilyName:(familyName == JAVA_NULL ? nil : familyName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIFont *)fontWithName:(NSString *)fontName size:(CGFloat)fontSize;
+ (UIFont*) fontWithName___java_lang_String_double:(NSString*) fontName :(double) fontSize 
{
    UIFont* re$ult = [UIFont fontWithName:(fontName == JAVA_NULL ? nil : fontName) size:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIFont *)italicSystemFontOfSize:(CGFloat)fontSize;
+ (UIFont*) italicSystemFontOfSize___double:(double) fontSize 
{
    UIFont* re$ult = [UIFont italicSystemFontOfSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (CGFloat)labelFontSize;
+ (double) labelFontSize__
{
    return [UIFont labelFontSize];
}

// + (CGFloat)smallSystemFontSize;
+ (double) smallSystemFontSize__
{
    return [UIFont smallSystemFontSize];
}

// + (UIFont *)systemFontOfSize:(CGFloat)fontSize;
+ (UIFont*) systemFontOfSize___double:(double) fontSize 
{
    UIFont* re$ult = [UIFont systemFontOfSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (CGFloat)systemFontSize;
+ (double) systemFontSize__
{
    return [UIFont systemFontSize];
}

// @property(nonatomic, readonly) CGFloat ascender;
- (double) ascender__
{
    return [self ascender];
}

// @property(nonatomic, readonly) CGFloat capHeight;
- (double) capHeight__
{
    return [self capHeight];
}

// @property(nonatomic, readonly) CGFloat descender;
- (double) descender__
{
    return [self descender];
}

// @property(nonatomic, readonly, strong) NSString *familyName;
- (NSString*) familyName__
{
    NSString* re$ult = [self familyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) NSString *fontName;
- (NSString*) fontName__
{
    NSString* re$ult = [self fontName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) CGFloat leading;
- (double) leading__
{
    return [self leading];
}

// @property(nonatomic, readonly) CGFloat lineHeight;
- (double) lineHeight__
{
    return [self lineHeight];
}

// @property(nonatomic, readonly) CGFloat pointSize;
- (double) pointSize__
{
    return [self pointSize];
}

// @property(nonatomic, readonly) CGFloat xHeight;
- (double) xHeight__
{
    return [self xHeight];
}

// - (UIFont *)fontWithSize:(CGFloat)fontSize;
- (UIFont*) fontWithSize___double:(double) fontSize 
{
    UIFont* re$ult = [self fontWithSize:fontSize];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
