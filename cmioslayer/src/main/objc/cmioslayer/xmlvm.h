/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */


#import <objc/runtime.h>
#import <math.h>
#import <Foundation/Foundation.h>
#import "ffi.h"
@class java_lang_Class;
@class java_util_List;

#define CGBitmapContextRef CGContextRef

#if defined(_WIN32)
typedef NSString *UIActivityType;
#define uuid_t XMLVMArray*
#endif

#define MEMBER_GET(OBJ,TYPE,CLASS,SELECTOR)     ((TYPE (*)(id, SEL))[[CLASS class] instanceMethodForSelector: @selector(SELECTOR)])(OBJ, @selector(SELECTOR))
#define MEMBER_SET(OBJ,TYPE,CLASS,SELECTOR,VALUE)     ((void(*)(id, SEL, TYPE))[[CLASS class] instanceMethodForSelector: @selector(SELECTOR)])(OBJ, @selector(SELECTOR), (VALUE))

void xmlvm_init();

void xmlvm_error(NSString* msg);
int isObjectInstanceOf(id * obj, char* className);
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
- (id) objectAtIndex:(int) idx;
- (void) replaceObjectAtIndex:(int) idx withObject:(id) obj;
- (int) count;
- (XMLVMArray*) clone__;
- (int) sizeOfBoxedTypeInBytes:(int) index typeFound:(int *) type asMaxSize:(BOOL) maxsize;  // call by reference for type found
- (void*) toMallocedVarArg;

@end

NSString* xmlvm_formatWith( void (*func)(void), BOOL returns, int extraParamSize, XMLVMArray* varargs, ...);

#define Infinity 0x7f800000
#define NaN 0x7fc00000

// Use this macro to safely set an obj-c value, in case Java has given a null pointer
#define XMLVM_NULL2NIL(VALUE) (((id)(VALUE)==JAVA_NULL)?nil:VALUE)
#define XMLVM_NIL2NULL(VALUE) (VALUE==nil?JAVA_NULL:VALUE)

// Return the value of an obj-c property. This value is retained.  If the value is nil, null is returned to java
#define return_XMLVM(PROPNAME) return_XMLVM_SELECTOR(self PROPNAME)
// Same as return_XMLVM_SELECTOR, but also define the actual selector
#define return_XMLVM_SELECTOR(SELECTOR) id __xmlvm_item = [SELECTOR]; return [XMLVM_NIL2NULL(__xmlvm_item) retain] ;

// Set a property and retain it. Usually this is called when a delegate is given as a parameter. This object will automatically be released when this object will be released
#define XMLVM_PROPERTY(PROPERTY,VALUE) XMLVM_PROPERTY_WITHCOMMAND(PROPERTY,VALUE,self.PROPERTY = __retainable)
// Like XMLVM_PROPERTY but specify the exact command to execute to set this property (if any) 
#define XMLVM_PROPERTY_WITHCOMMAND(PROPERTY,VALUE,COMMAND) id __retainable=(VALUE==JAVA_NULL)?nil:VALUE; COMMAND; static char PROPERTY_key; objc_setAssociatedObject(self, &PROPERTY_key, __retainable, OBJC_ASSOCIATION_RETAIN_NONATOMIC);

// Under old iPhone simulator there is a bug, in which associations are not supported. This is a workaround, which actually leaves a memory leak, but it doesn't harm (much).
#if __IPHONE_OS_VERSION_MAX_ALLOWED < 40000
#if TARGET_IPHONE_SIMULATOR
#define objc_setAssociatedObject(A,B,ITEM,D) [ITEM retain];
#define OBJC_ASSOCIATION_RETAIN_NONATOMIC 1
#endif
#endif

// This is used to support optional protocol implementation in Java. Declare that an ObjC selector exists ONLY if the JAVA selector exists. CHECK is the current selector being asked.
#define XMLVM_REROUTE(CHECK,OBJC,JAVA) if (sel_isEqual(CHECK, @selector(OBJC))) return [super respondsToSelector:@selector(JAVA)];
