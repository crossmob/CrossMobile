//
//  java_lang_Number.h
//  cmioslayer
//
//

#import "xmlvm.h"
#import "java_lang_String.h"

CM_EXPORT_CLASS
@interface java_lang_Number : NSNumber
@property (strong) NSNumber *cmnumber;
- (instancetype) initWithNumber:(NSNumber*) number;
@end

@interface NSNumber (cm_number)
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
