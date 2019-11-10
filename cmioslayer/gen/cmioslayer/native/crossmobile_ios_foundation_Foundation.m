// (c) 2019 under LGPL by CrossMobile plugin tools

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
    NSLog_cmva((format == JAVA_NULL ? nil : format), (va_array == JAVA_NULL ? nil : va_array));
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
