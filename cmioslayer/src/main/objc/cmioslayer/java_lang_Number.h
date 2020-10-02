//
//  java_lang_Number.h
//  cmioslayer
//
//

#import "xmlvm.h"
#import "java_lang_String.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Number : NSNumber
@property (strong) NSNumber *cmnumber;
- (instancetype) initWithNumber:(NSNumber*) number;
@end

@interface NSNumber (cm_number)
- (instancetype) __init_java_lang_Number__;
- (char) byteValue__;
- (short) shortValue__;
- (int) intValue__;
- (JAVA_LONG) longValue__;
- (float) floatValue__;
- (double) doubleValue__;
- (int) booleanValue__;
- (unichar) charValue__;
- (java_lang_String*) toString__;
@end
