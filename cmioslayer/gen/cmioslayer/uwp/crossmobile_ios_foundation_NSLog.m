// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSLog implementation

#import "crossmobile_ios_foundation_NSLog.h"
#import "java_lang_String.h"
#import "java_util_Arrays.h"
#import "cmioslayer-Swift.h"

@implementation crossmobile_ios_foundation_NSLog

// direct binding of: void NSLog(NSString *format, ...);
+ (void) log___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    [cmioslayer_va NSLog_NSLog:(format == JAVA_NULL ? nil : format) :[java_util_Arrays asList___java_lang_Object_ARRAYTYPE:va_array]];
}

@end
