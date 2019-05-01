//
//  java_util_Objects.m
//  cmjavalib
//
//

#import "java_util_Objects.h"
#import "java_lang_NullPointerException.h"

@implementation java_util_Objects

+ (int) equals___java_lang_Object_java_lang_Object :(java_lang_Object*)n1 :(java_lang_Object*)n2
{
    if (n1==n2)
        return true;
    return n1!=JAVA_NULL && [n1 equals___java_lang_Object:n2];
}

+ (int) deepEquals___java_lang_Object_java_lang_Object :(java_lang_Object*)n1 :(java_lang_Object*)n2
{
    return [java_util_Objects equals___java_lang_Object_java_lang_Object:n1 :n2];
}

+ (int) hashCode___java_lang_Object :(java_lang_Object*)n1
{
    return n1==JAVA_NULL?0:[n1 hashCode__];
}

+ (int) hash___java_lang_Object_ARRAYTYPE :(XMLVMArray*)n1
{
    return [java_util_Objects hashCode___java_lang_Object:n1];
}

/* Retain already performed */
+ (java_lang_String*) toString___java_lang_Object :(java_lang_Object*)n1
{
    /* Retain already performed */
    return [java_lang_String valueOf___java_lang_Object:n1];
}

+ (java_lang_String*) toString___java_lang_Object_java_lang_String :(java_lang_Object*)n1 :(java_lang_String*)n2
{
    /* Retain already performed */
    return n1 == JAVA_NULL ? n2 : [java_lang_String valueOf___java_lang_Object:n1];
}

+ (int) compare___java_lang_Object_java_lang_Object_java_util_Comparator :(java_lang_Object*)n1 :(java_lang_Object*)n2 :(java_util_Comparator*)n3
{
    if (n1==n2)
        return true;
    else
        return [n3 compare___java_lang_Object_java_lang_Object:n1 :n2];
}

+ (java_lang_Object*) requireNonNull___java_lang_Object :(java_lang_Object*)n1
{
    if (n1==JAVA_NULL)
        @throw [[java_lang_NullPointerException alloc] init];
    return [n1 retain];
}

+ (java_lang_Object*) requireNonNull___java_lang_Object_java_lang_String :(java_lang_Object*)n1 :(java_lang_String*)n2
{
    if (n1==JAVA_NULL)
        @throw [[java_lang_NullPointerException alloc] __init_java_lang_NullPointerException___java_lang_String:n2];
    return [n1 retain];
}

+ (int) isNull___java_lang_Object :(java_lang_Object*)n1
{
    return n1==JAVA_NULL;
}

+ (int) nonNull___java_lang_Object :(java_lang_Object*)n1
{
    return n1!=JAVA_NULL;
}

@end
