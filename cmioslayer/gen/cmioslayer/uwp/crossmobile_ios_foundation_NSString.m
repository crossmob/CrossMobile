// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSString implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSLocale.h"
#import "crossmobile_ios_foundation_NSRange.h"
#import "crossmobile_ios_foundation_NSString.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_NSString$Ext

@end

@implementation NSString (cm_crossmobile_ios_foundation_NSString)

// - (BOOL)canBeConvertedToEncoding:(NSStringEncoding)encoding;
+ (BOOL) canBeConvertedToEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    return [(this == JAVA_NULL ? nil : this) canBeConvertedToEncoding:encoding];
}

// - (NSComparisonResult)compare:(NSString *)aString options:(NSStringCompareOptions)mask;
+ (int) compare___java_lang_String_java_lang_String_int:(NSString*) this :(NSString*) aString :(int) mask 
{
    return [(this == JAVA_NULL ? nil : this) compare:(aString == JAVA_NULL ? nil : aString) options:mask];
}

// - (NSArray<NSString *> *)componentsSeparatedByString:(NSString *)separator;
+ (NSArray*) componentsSeparatedByString___java_lang_String_java_lang_String:(NSString*) this :(NSString*) separator 
{
    NSArray* re$ult = [(this == JAVA_NULL ? nil : this) componentsSeparatedByString:(separator == JAVA_NULL ? nil : separator)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSData *)dataUsingEncoding:(NSStringEncoding)encoding;
+ (NSData*) dataUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    NSData* re$ult = [(this == JAVA_NULL ? nil : this) dataUsingEncoding:encoding];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGSize)drawAtPoint:(CGPoint)point withFont:(UIFont *)font;
+ (crossmobile_ios_coregraphics_CGSize*) drawAtPoint___java_lang_String_crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIFont:(NSString*) this :(crossmobile_ios_coregraphics_CGPoint*) point :(UIFont*) font 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[(this == JAVA_NULL ? nil : this) drawAtPoint:[point getCGPoint] withFont:(font == JAVA_NULL ? nil : font)]];
}

// - (instancetype)initWithData:(NSData *)data encoding:(NSStringEncoding)encoding;
+ (instancetype) initWithData___crossmobile_ios_foundation_NSData_int:(NSData*) data :(int) encoding 
{
    return [[NSString alloc] initWithData:(data == JAVA_NULL ? nil : data) encoding:encoding];
}

// - (instancetype)initWithFormat:(NSString *)format locale:(id)locale, ...;
+ (instancetype) initWithFormat___java_lang_String_crossmobile_ios_foundation_NSLocale_java_lang_Object_ARRAYTYPE:(NSString*) format :(NSLocale*) locale :(XMLVMArray*) va_array 
{
    vartype* var_p_item;
    double* var_d_item;
    gather_va_args(va_array, &var_p_item, &var_d_item, 20);
    id re$ult = [[NSString alloc] initWithFormat:(format == JAVA_NULL ? nil : format) locale:(locale == JAVA_NULL ? nil : locale) ,
        #ifdef VARARG_SIM_64
            var_p_item[0], var_d_item[0], var_p_item[1], var_d_item[1], var_p_item[2], var_d_item[2], var_p_item[3], var_d_item[3], var_p_item[4], var_d_item[4], var_p_item[5], var_d_item[5], var_p_item[6], var_d_item[6], var_p_item[7], var_d_item[7], var_p_item[8], var_d_item[8], var_p_item[9], var_d_item[9], var_p_item[10], var_d_item[10], var_p_item[11], var_d_item[11], var_p_item[12], var_d_item[12], var_p_item[13], var_d_item[13], var_p_item[14], var_d_item[14], var_p_item[15], var_d_item[15], var_p_item[16], var_d_item[16], var_p_item[17], var_d_item[17], var_p_item[18], var_d_item[18], var_p_item[19], var_d_item[19]
        #endif
        #ifdef VARARG_PHONE_64
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19]
        #endif
        #ifdef VARARG_32
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19], var_p_item[20], var_p_item[21], var_p_item[22], var_p_item[23], var_p_item[24], var_p_item[25], var_p_item[26], var_p_item[27], var_p_item[28], var_p_item[29], var_p_item[30], var_p_item[31], var_p_item[32], var_p_item[33], var_p_item[34], var_p_item[35], var_p_item[36], var_p_item[37], var_p_item[38], var_p_item[39]
        #endif
    ];
    free(var_p_item);
    free(var_d_item);
    return re$ult;
}

// - (instancetype)initWithFormat:(NSString *)format, ...;
+ (instancetype) initWithFormat___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    vartype* var_p_item;
    double* var_d_item;
    gather_va_args(va_array, &var_p_item, &var_d_item, 20);
    id re$ult = [[NSString alloc] initWithFormat:(format == JAVA_NULL ? nil : format) ,
        #ifdef VARARG_SIM_64
            var_p_item[0], var_d_item[0], var_p_item[1], var_d_item[1], var_p_item[2], var_d_item[2], var_p_item[3], var_d_item[3], var_p_item[4], var_d_item[4], var_p_item[5], var_d_item[5], var_p_item[6], var_d_item[6], var_p_item[7], var_d_item[7], var_p_item[8], var_d_item[8], var_p_item[9], var_d_item[9], var_p_item[10], var_d_item[10], var_p_item[11], var_d_item[11], var_p_item[12], var_d_item[12], var_p_item[13], var_d_item[13], var_p_item[14], var_d_item[14], var_p_item[15], var_d_item[15], var_p_item[16], var_d_item[16], var_p_item[17], var_d_item[17], var_p_item[18], var_d_item[18], var_p_item[19], var_d_item[19]
        #endif
        #ifdef VARARG_PHONE_64
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19]
        #endif
        #ifdef VARARG_32
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19], var_p_item[20], var_p_item[21], var_p_item[22], var_p_item[23], var_p_item[24], var_p_item[25], var_p_item[26], var_p_item[27], var_p_item[28], var_p_item[29], var_p_item[30], var_p_item[31], var_p_item[32], var_p_item[33], var_p_item[34], var_p_item[35], var_p_item[36], var_p_item[37], var_p_item[38], var_p_item[39]
        #endif
    ];
    free(var_p_item);
    free(var_d_item);
    return re$ult;
}

// + (instancetype)localizedStringWithFormat:(NSString *)format, ...;
+ (instancetype) localizedStringWithFormat___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    vartype* var_p_item;
    double* var_d_item;
    gather_va_args(va_array, &var_p_item, &var_d_item, 20);
    id re$ult = [NSString localizedStringWithFormat:(format == JAVA_NULL ? nil : format) ,
        #ifdef VARARG_SIM_64
            var_p_item[0], var_d_item[0], var_p_item[1], var_d_item[1], var_p_item[2], var_d_item[2], var_p_item[3], var_d_item[3], var_p_item[4], var_d_item[4], var_p_item[5], var_d_item[5], var_p_item[6], var_d_item[6], var_p_item[7], var_d_item[7], var_p_item[8], var_d_item[8], var_p_item[9], var_d_item[9], var_p_item[10], var_d_item[10], var_p_item[11], var_d_item[11], var_p_item[12], var_d_item[12], var_p_item[13], var_d_item[13], var_p_item[14], var_d_item[14], var_p_item[15], var_d_item[15], var_p_item[16], var_d_item[16], var_p_item[17], var_d_item[17], var_p_item[18], var_d_item[18], var_p_item[19], var_d_item[19]
        #endif
        #ifdef VARARG_PHONE_64
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19]
        #endif
        #ifdef VARARG_32
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19], var_p_item[20], var_p_item[21], var_p_item[22], var_p_item[23], var_p_item[24], var_p_item[25], var_p_item[26], var_p_item[27], var_p_item[28], var_p_item[29], var_p_item[30], var_p_item[31], var_p_item[32], var_p_item[33], var_p_item[34], var_p_item[35], var_p_item[36], var_p_item[37], var_p_item[38], var_p_item[39]
        #endif
    ];
    free(var_p_item);
    free(var_d_item);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGSize)sizeWithFont:(UIFont *)font;
+ (crossmobile_ios_coregraphics_CGSize*) sizeWithFont___java_lang_String_crossmobile_ios_uikit_UIFont:(NSString*) this :(UIFont*) font 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[(this == JAVA_NULL ? nil : this) sizeWithFont:(font == JAVA_NULL ? nil : font)]];
}

// - (CGSize)sizeWithFont:(UIFont *)font constrainedToSize:(CGSize)size lineBreakMode:(NSLineBreakMode)lineBreakMode ;
+ (crossmobile_ios_coregraphics_CGSize*) sizeWithFont___java_lang_String_crossmobile_ios_uikit_UIFont_crossmobile_ios_coregraphics_CGSize_int:(NSString*) this :(UIFont*) font :(crossmobile_ios_coregraphics_CGSize*) size :(int) lineBreakMode 
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[(this == JAVA_NULL ? nil : this) sizeWithFont:(font == JAVA_NULL ? nil : font) constrainedToSize:[size getCGSize] lineBreakMode:lineBreakMode]];
}

// - (NSString *)stringByAddingPercentEscapesUsingEncoding:(NSStringEncoding)encoding;
+ (NSString*) stringByAddingPercentEscapesUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    NSString* re$ult = [(this == JAVA_NULL ? nil : this) stringByAddingPercentEscapesUsingEncoding:encoding];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)stringByReplacingCharactersInRange:(NSRange)range withString:(NSString *)replacement;
+ (NSString*) stringByReplacingCharactersInRange___java_lang_String_crossmobile_ios_foundation_NSRange_java_lang_String:(NSString*) this :(crossmobile_ios_foundation_NSRange*) range :(NSString*) replacement 
{
    NSString* re$ult = [(this == JAVA_NULL ? nil : this) stringByReplacingCharactersInRange:[range getNSRange] withString:(replacement == JAVA_NULL ? nil : replacement)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)stringByReplacingPercentEscapesUsingEncoding:(NSStringEncoding)encoding;
+ (NSString*) stringByReplacingPercentEscapesUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding 
{
    NSString* re$ult = [(this == JAVA_NULL ? nil : this) stringByReplacingPercentEscapesUsingEncoding:encoding];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (id)stringWithContentsOfFile:(NSString *)path;
+ (id) stringWithContentsOfFile___java_lang_String:(NSString*) path 
{
    id re$ult = [NSString stringWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)stringWithContentsOfFile:(NSString *)path encoding:(NSStringEncoding)enc error:(NSError * _Nullable *)error;
+ (instancetype) stringWithContentsOfFile___java_lang_String_int_crossmobile_rt_StrongReference:(NSString*) path :(int) enc :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSString stringWithContentsOfFile:(path == JAVA_NULL ? nil : path) encoding:enc error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (id)stringWithContentsOfURL:(NSURL *)url;
+ (id) stringWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    id re$ult = [NSString stringWithContentsOfURL:(url == JAVA_NULL ? nil : url)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)stringWithContentsOfURL:(NSURL *)url encoding:(NSStringEncoding)enc error:(NSError * _Nullable *)error;
+ (instancetype) stringWithContentsOfURL___crossmobile_ios_foundation_NSURL_int_crossmobile_rt_StrongReference:(NSURL*) url :(int) enc :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSString stringWithContentsOfURL:(url == JAVA_NULL ? nil : url) encoding:enc error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)writeToFile:(NSString *)path atomically:(BOOL)useAuxiliaryFile encoding:(NSStringEncoding)enc error:(NSError * _Nullable *)error;
+ (BOOL) writeToFile___java_lang_String_java_lang_String_boolean_int_crossmobile_rt_StrongReference:(NSString*) this :(NSString*) path :(BOOL) useAuxiliaryFile :(int) enc :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [(this == JAVA_NULL ? nil : this) writeToFile:(path == JAVA_NULL ? nil : path) atomically:useAuxiliaryFile encoding:enc error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

@end
