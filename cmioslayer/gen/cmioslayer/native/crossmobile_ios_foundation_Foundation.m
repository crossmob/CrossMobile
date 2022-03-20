// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_Foundation implementation

#import "crossmobile_ios_foundation_Foundation.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_Foundation

// NSString * NSHomeDirectory ( void );
+ (NSString*) NSHomeDirectory__
{
    NSString* re$ult = NSHomeDirectory();
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// void NSLog(NSString *format, ...);
+ (void) NSLog___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    vartype* var_p_item;
    double* var_d_item;
    gather_va_args(va_array, &var_p_item, &var_d_item, 20);
    NSLog((format == JAVA_NULL ? nil : format), 
        #ifdef VARARG_SIM_64
            var_p_item[0], var_d_item[0], var_p_item[1], var_d_item[1], var_p_item[2], var_d_item[2], var_p_item[3], var_d_item[3], var_p_item[4], var_d_item[4], var_p_item[5], var_d_item[5], var_p_item[6], var_d_item[6], var_p_item[7], var_d_item[7], var_p_item[8], var_d_item[8], var_p_item[9], var_d_item[9], var_p_item[10], var_d_item[10], var_p_item[11], var_d_item[11], var_p_item[12], var_d_item[12], var_p_item[13], var_d_item[13], var_p_item[14], var_d_item[14], var_p_item[15], var_d_item[15], var_p_item[16], var_d_item[16], var_p_item[17], var_d_item[17], var_p_item[18], var_d_item[18], var_p_item[19], var_d_item[19]
        #endif
        #ifdef VARARG_PHONE_64
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19]
        #endif
        #ifdef VARARG_32
            var_p_item[0], var_p_item[1], var_p_item[2], var_p_item[3], var_p_item[4], var_p_item[5], var_p_item[6], var_p_item[7], var_p_item[8], var_p_item[9], var_p_item[10], var_p_item[11], var_p_item[12], var_p_item[13], var_p_item[14], var_p_item[15], var_p_item[16], var_p_item[17], var_p_item[18], var_p_item[19], var_p_item[20], var_p_item[21], var_p_item[22], var_p_item[23], var_p_item[24], var_p_item[25], var_p_item[26], var_p_item[27], var_p_item[28], var_p_item[29], var_p_item[30], var_p_item[31], var_p_item[32], var_p_item[33], var_p_item[34], var_p_item[35], var_p_item[36], var_p_item[37], var_p_item[38], var_p_item[39]
        #endif
    );
    free(var_p_item);
    free(var_d_item);
}

// NSArray<NSString *> * NSSearchPathForDirectoriesInDomains ( NSSearchPathDirectory directory, NSSearchPathDomainMask domainMask, BOOL expandTilde );
+ (NSArray*) NSSearchPathForDirectoriesInDomains___int_int_boolean:(int) directory :(int) domainMask :(BOOL) expandTilde 
{
    NSArray* re$ult = NSSearchPathForDirectoriesInDomains(directory, domainMask, expandTilde);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// NSString * NSTemporaryDirectory ( void );
+ (NSString*) NSTemporaryDirectory__
{
    NSString* re$ult = NSTemporaryDirectory();
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
