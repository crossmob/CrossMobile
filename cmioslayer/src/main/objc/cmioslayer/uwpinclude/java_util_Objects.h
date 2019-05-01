//
//  java_util_Objects.h
//  cmjavalib
//
//

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Comparator.h"

CM_EXPORT_CLASS
@interface java_util_Objects : java_lang_Object

+ (int) equals___java_lang_Object_java_lang_Object :(java_lang_Object*)n1 :(java_lang_Object*)n2;
+ (int) deepEquals___java_lang_Object_java_lang_Object :(java_lang_Object*)n1 :(java_lang_Object*)n2;
+ (int) hashCode___java_lang_Object :(java_lang_Object*)n1;
+ (int) hash___java_lang_Object_ARRAYTYPE :(XMLVMArray*)n1;
+ (java_lang_String*) toString___java_lang_Object :(java_lang_Object*)n1;
+ (java_lang_String*) toString___java_lang_Object_java_lang_String :(java_lang_Object*)n1 :(java_lang_String*)n2;
+ (int) compare___java_lang_Object_java_lang_Object_java_util_Comparator :(java_lang_Object*)n1 :(java_lang_Object*)n2 :(java_util_Comparator*)n3;
+ (java_lang_Object*) requireNonNull___java_lang_Object :(java_lang_Object*)n1;
+ (java_lang_Object*) requireNonNull___java_lang_Object_java_lang_String :(java_lang_Object*)n1 :(java_lang_String*)n2;
+ (int) isNull___java_lang_Object :(java_lang_Object*)n1;
+ (int) nonNull___java_lang_Object :(java_lang_Object*)n1;

@end
