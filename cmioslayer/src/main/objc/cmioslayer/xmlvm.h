/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import <objc/runtime.h>
#import <math.h>
#import <Foundation/Foundation.h>
@class java_lang_Class;
@class java_util_List;

#define CGBitmapContextRef CGContextRef
#define Dispatch NSObject

#if defined(_WIN32)
typedef NSString *UIActivityType;
#define uuid_t XMLVMArray*
#endif

#define MEMBER_GET(OBJ,TYPE,CLASS,SELECTOR)     ((TYPE (*)(id, SEL))[[CLASS class] instanceMethodForSelector: @selector(SELECTOR)])(OBJ, @selector(SELECTOR))
#define MEMBER_SET(OBJ,TYPE,CLASS,SELECTOR,VALUE)     ((void(*)(id, SEL, TYPE))[[CLASS class] instanceMethodForSelector: @selector(SELECTOR)])(OBJ, @selector(SELECTOR), (VALUE))

void xmlvm_init(void);

void xmlvm_error(NSString* msg);
int isObjectInstanceOf(id obj, char* className);
NSString* jclass_to_string(java_lang_Class* classname);
Class jclass_to_class(java_lang_Class* classname);
NSArray<Class>* jclass_to_class_list(java_util_List* list);

typedef long long JAVA_LONG;
typedef unsigned long long JAVA_ULONG;
#ifndef WINOBJC
typedef BOOL boolean;
#endif

typedef union {
    id        o;
    int       i;
    float     f;
    double    d;
    unichar   c;
    JAVA_LONG l;
} XMLVMElem;

typedef union {
    id*             o;
    char*           b;
    unsigned short* c;
    short*          s;
    int*            i;
    float*          f;
    double*         d;
    JAVA_LONG*      l;
    void*           data;
} XMLVMElemPtr;


extern id JAVA_NULL;


@interface XMLVMArray : NSObject // TODO should be java_lang_Object
{
    @public XMLVMElemPtr array;
    @public int          type;
    @public int          length;
}

+ (XMLVMArray*) createSingleDimensionWithType:(int) type andSize:(int) size;
+ (XMLVMArray*) createSingleDimensionWithType:(int) type size:(int) size andData:(void*) data;
+ (XMLVMArray*) createMultiDimensionsWithType:(int) type dimensions:(XMLVMElem*) dim count:(int)count;
+ (void) fillArray:(XMLVMArray*) array withData:(void*) data;
+ (int) sizeOfBaseTypeInBytes:(int) type;
- (void) replaceObjectAtIndex:(int) idx withObject:(id) obj;
- (int) count;
- (XMLVMArray*) clone__;
- (int) sizeOfBoxedTypeInBytes:(int) index typeFound:(int *) type asMaxSize:(BOOL) maxsize;  // call by reference for type found
- (void*) toMallocedVarArg;

@end

#define Infinity 0x7f800000
#define NaN 0x7fc00000

// Use this macro to safely set an obj-c value, in case Java has given a null pointer
#define XMLVM_NULL2NIL(VALUE) (((id)(VALUE)==JAVA_NULL)?nil:VALUE)
#define XMLVM_NIL2NULL(VALUE) (VALUE==nil?JAVA_NULL:VALUE)

// Return the value of an obj-c property. This value is retained.  If the value is nil, null is returned to java
#define return_XMLVM(PROPNAME) return_XMLVM_SELECTOR(self PROPNAME)
// Same as return_XMLVM_SELECTOR, but also define the actual selector
#define return_XMLVM_SELECTOR(SELECTOR) id __xmlvm_item = [SELECTOR]; return [XMLVM_NIL2NULL(__xmlvm_item) retain] ;

// Use this instead of @available since this is a light runtime check instead of compiletime check
int isIosAtLeast(int major, int minor);

// Varargs
#if __LP64__
    #define VARARG_64
    #define MAXVAR_SIZE_MULTIPLIER 1
    typedef long long vartype;
    #if TARGET_OS_SIMULATOR
        #define VARARG_SIM_64
    #else
        #define VARARG_PHONE_64
    #endif
#else
    #define VARARG_32
    #define MAXVAR_SIZE_MULTIPLIER 2
    typedef int vartype;
#endif
void gather_va_args(XMLVMArray* va_array, vartype**params, double** doubles, int va_maxsize);
