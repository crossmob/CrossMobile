// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSLog implementation

#import "crossmobile_ios_foundation_NSLog.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSLog

// direct binding of: void NSLog(NSString *format, ...);
+ (void) log___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array 
{
    xmlvm_formatWith(FFI_FN(NSLog), NO, 1, va_array, (format == JAVA_NULL ? nil : format));
}

@end
