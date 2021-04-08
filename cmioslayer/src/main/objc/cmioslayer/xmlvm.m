/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_Boolean.h"
#import "java_lang_Character.h"
#import "java_lang_Byte.h"
#import "java_lang_Short.h"
#import "java_lang_Integer.h"
#import "java_lang_Float.h"
#import "java_lang_Double.h"
#import "java_lang_Long.h"
#import "java_lang_Class.h"
#import "java_util_List.h"
#import <objc/message.h>
#import <UIKit/UIDevice.h>

id JAVA_NULL;

void xmlvm_init()
{
      JAVA_NULL = [NSNull null];
}

int isObjectInstanceOf(id obj, char* className)
{
    if (obj==JAVA_NULL)
        return FALSE;
    if (strncmp("crossmobile_ios_", className, 16)==0) {
        className+=16;
        char* underscore = strchr(className, '_');
        if (underscore!=NULL)
            className = underscore+1;
    }
    if ([obj isKindOfClass:objc_getClass(className)] || [obj conformsToProtocol:objc_getProtocol(className)])
        return TRUE;
    return FALSE;
}

void xmlvm_error(NSString* msg)
{
    NSLog(@"%@", msg);
    @throw [NSException exceptionWithName: @"XMLVM missing byte code instruction" reason:msg userInfo: nil];
}

NSString* jclass_to_string(java_lang_Class* classname)
{
    if (classname==JAVA_NULL||classname==nil)
        return nil;
    NSString* name = [classname getName__];
    NSString* objcname = [name stringByReplacingOccurrencesOfString:@"." withString:@"_"];
    [name release];
    return objcname;
}

Class jclass_to_class(java_lang_Class* classname)
{
    if (classname==JAVA_NULL||classname==nil)
        return nil;
    return classname->clazz;
}

NSArray<Class>* jclass_to_class_list(java_util_List* list){
    if (list==JAVA_NULL||list==nil)
        return nil;

    int size = [list size__];
    NSMutableArray* result = [[[NSMutableArray alloc] initWithCapacity:[list size__]] autorelease];
    for(int i = 0 ; i <size ; i++)
        [result addObject:((java_lang_Class*)[list get___int:i])->clazz];
    return result;
}

@implementation XMLVMArray

/* This private method creates a shallow copy of this array */
XMLVMElemPtr copyData(int type, int length, XMLVMElemPtr olddata)
{
    int sizeOfBaseType = [XMLVMArray sizeOfBaseTypeInBytes:type];
    int sizeOfArrayInBytes = sizeOfBaseType * length;
    XMLVMElemPtr array;
    array.data = malloc(sizeOfArrayInBytes);
    if (type == 0) {
        for (int i = 0; i < length; i++) {
            array.o[i] = [olddata.o[i] retain];
        }
    }
    else {
        memcpy(array.data, olddata.data, sizeOfArrayInBytes);
    }
    return array;
}

+ (XMLVMArray*) createSingleDimensionWithType:(int) type andSize:(int) size
{
    XMLVMArray *retval = [[XMLVMArray alloc] init];
    retval->type = type;
    retval->length = size;

    int sizeOfBaseType = [XMLVMArray sizeOfBaseTypeInBytes:type];
    retval->array.data = malloc(sizeOfBaseType * size);
    bzero(retval->array.data, sizeOfBaseType * size);

    if (type == 0) {
        for (int i = 0; i < size; i++) {
            retval->array.o[i] = JAVA_NULL;
        }
    }
    
    return retval;
}

+ (XMLVMArray*) createSingleDimensionWithType:(int) type size:(int) size andData:(void*) data
{
    XMLVMArray *retval = [[XMLVMArray alloc] init];
    retval->type = type;
    retval->length = size;
    retval->array = copyData(type, size, (XMLVMElemPtr)data);
    return retval;
}

+ (XMLVMArray*) createMultiDimensionsWithType:(int) type dimensions:(XMLVMElem*) dim count:(int)count
{
    int dimensions = dim->i;
    dim++;
    count--;
    if (count == 0) {
        return [XMLVMArray createSingleDimensionWithType:type andSize:dimensions];
    }
    XMLVMArray* slice = [XMLVMArray createSingleDimensionWithType:0 andSize:dimensions];
    for (int i = 0; i < dimensions; i++) {
        id o = [XMLVMArray createMultiDimensionsWithType:type dimensions:dim count:count];
        [slice replaceObjectAtIndex:i withObject:o];
        [o release];
    }
    return slice;
}

+ (void) fillArray:(XMLVMArray*) array withData:(void*) data
{
    int sizeOfBaseType = [XMLVMArray sizeOfBaseTypeInBytes:array->type];
    int n = sizeOfBaseType * array->length;
    memcpy(array->array.data, data, n);
}

+ (int) sizeOfBaseTypeInBytes:(int) type
{
    int sizeOfBaseType;
    
    // 'type' values are defined by vm:sizeOf in xmlvm2objc.xsl
    switch (type) {
    case 1: // boolean
    case 3: // byte
       sizeOfBaseType = sizeof(char);
       break;
    case 2: // char
       sizeOfBaseType = sizeof(unichar);
       break;
    case 4: // short
       sizeOfBaseType = sizeof(short);
       break;
    case 5: // int
       sizeOfBaseType = sizeof(int);
       break;
    case 6: // float
       sizeOfBaseType = sizeof(float);
       break;
    case 7: // double
       sizeOfBaseType = sizeof(double);
       break;
    case 8: // long
       sizeOfBaseType = sizeof(JAVA_LONG);
       break;
    case 100: // XMLVMElem
        sizeOfBaseType = sizeof(XMLVMElem);
        break;
    default: // object reference
       sizeOfBaseType = sizeof(id);
       break;
    }
    
    return sizeOfBaseType;
}

// call by reference for type found
- (int) sizeOfBoxedTypeInBytes:(int) index typeFound:(int *) type asMaxSize:(BOOL) maxsize
{
    if (self->type!=0)    // It is not an object, return the actual size
        return [XMLVMArray sizeOfBaseTypeInBytes:type];
    const char* className = class_getName([self->array.o[index] class]);
    int maxSize = sizeof(JAVA_LONG);
    if (strcmp(className, "java_lang_Boolean")==0) {
        if (type!=NULL)
            *type = 1;
        return maxsize?sizeof(id):sizeof(char);
    }
    else if (strcmp(className, "java_lang_Character")==0) {
        if (type!=NULL)
            *type = 2;
        return maxsize?sizeof(int):sizeof(unichar);
    }
    else if (strcmp(className, "java_lang_Byte")==0) {
        if (type!=NULL)
            *type = 3;
        return maxsize?maxSize:sizeof(char);
    }
    else if (strcmp(className, "java_lang_Short")==0) {
        if (type!=NULL)
            *type = 4;
        return maxsize?maxSize:sizeof(short);
    }
    else if (strcmp(className, "java_lang_Integer")==0) {
        if (type!=NULL)
            *type = 5;
        return maxsize?maxSize:sizeof(int);
    }
    else if (strcmp(className, "java_lang_Long")==0) {
        if (type!=NULL)
            *type = 6;
        return maxSize;
    }
    else if (strcmp(className, "java_lang_Float")==0) {
        if (type!=NULL)
            *type = 7;
        return maxsize?maxSize:sizeof(float);
    }
    else if (strcmp(className, "java_lang_Double")==0) {
        if (type!=NULL)
            *type = 8;
        return sizeof(double);
    }
    else {
        return sizeof(id);
    }
}

- (void) replaceObjectAtIndex:(int) idx withObject:(id) obj
{
    [self->array.o[idx] release];
    self->array.o[idx] = [obj retain];
}

- (int) count
{
    return length;
}

- (void) dealloc
{
    if (self->type == 0) {
        for (int i = 0; i < length; i++) {
            [self->array.o[i] release];
        }
    }
    free(self->array.data);
    [super dealloc];
}


- (XMLVMArray*) clone__
{
    XMLVMArray *retval = [[XMLVMArray alloc] init];
    retval->type = self->type;
    retval->length = self->length;
    retval->array = copyData(self->type, self->length, self->array);
    return retval;
}

- (void*) toMallocedVarArg
{
    int totalsize = 0;
    int offset[self->length];
    int type[self->length];
    for (int i = 0 ; i < self->length ; i++) {
        offset[i] = totalsize;
        totalsize += [self sizeOfBoxedTypeInBytes:i typeFound:(type+i) asMaxSize:YES];
    }
    void * vararg = malloc(totalsize);
    for (int i = 0 ; i < self->length ; i++) {
        int ctype = type[i];
        if (ctype==1) {
            *(NSString **)(vararg + offset[i]) = [self->array.o[i] booleanValue__] ? @"true" : @"false";
        } else if (ctype==2) {
            *(unichar*)(vararg + offset[i]) = (JAVA_LONG)[self->array.o[i] charValue__];
        } else if (ctype==3) {
            *(JAVA_LONG*)(vararg + offset[i]) = (JAVA_LONG)[self->array.o[i] byteValue__];
        } else if (ctype==4) {
            *(JAVA_LONG*)(vararg + offset[i]) = (JAVA_LONG)[self->array.o[i] shortValue__];
        } else if (ctype==5) {
            *(JAVA_LONG*)(vararg + offset[i]) = (JAVA_LONG)[self->array.o[i] intValue__];
        } else if (ctype==6) {
            *(JAVA_LONG*)(vararg + offset[i]) = (JAVA_LONG)[self->array.o[i] longValue__];
        } else if (ctype==7) {
            *(double*)(vararg + offset[i]) = (double)[self->array.o[i] floatValue__];
        } else if (ctype==8) {
            *(double*)(vararg + offset[i]) = [self->array.o[i] doubleValue__];
        } else {
            *(NSString **)(vararg + offset[i]) = [self->array.o[i] toString__];
        }
    }
    return vararg;
}

@end

// Support selectors based on version
int isIosAtLeast(int req_major, int req_minor) {
    static int dev_major = -1;
    static int dev_minor = -1;
    if (dev_major < 0) {
        NSArray<NSString*>* components = [[[UIDevice currentDevice] systemVersion] componentsSeparatedByString:@"."];
        dev_major = [[components firstObject] intValue];
        dev_minor = [[components objectAtIndex:1] intValue];
    }
    return dev_major > req_major || (dev_major == req_major && dev_minor >= req_minor);
}


// Vararg versions
void gather_va_args(XMLVMArray* va_array, vartype**params, double** doubles, int va_maxsize) {
    int maxvar_size = va_maxsize * MAXVAR_SIZE_MULTIPLIER;
    vartype* p = malloc(maxvar_size*sizeof(vartype));
    memset(p, 0, maxvar_size*sizeof(vartype));
    *params = p;
    
    double* d = malloc(maxvar_size*sizeof(double));
    memset(d, 0, maxvar_size*sizeof(double));
    *doubles = d;
    if (!va_array || va_array == JAVA_NULL)
        return;

#ifdef VARARG_SIM_64
    int di = 0;
#endif
#ifdef VARARG_32
    uint32_t buffer[2];
#endif
    
    int pi = 0;
    for(int i = 0 ; i < va_array->length && i < va_maxsize ; i++) {
        id item = va_array->array.o[i];
        const char* className = class_getName([item class]);        // Change param according to it's actual type
        if (strcmp(className, "java_lang_Boolean")==0) {
            p[pi++] = [item boolValue];
        } else if (strcmp(className, "java_lang_Byte")==0 || strcmp(className, "java_lang_Short")==0 || strcmp(className, "java_lang_Integer")==0 || strcmp(className, "java_lang_Character")==0) {
            p[pi++] = [item intValue];
        } else if (strcmp(className, "java_lang_Long")==0) {
#ifdef VARARG_32
            *(long long *)(buffer) = [item longLongValue];
            p[pi++] = buffer[0];
            p[pi++] = buffer[1];
#else
            p[pi++] = [item longLongValue];
#endif
        } else if (strcmp(className, "java_lang_Float")==0 || strcmp(className, "java_lang_Double")==0) {
#ifdef VARARG_32
            *(double*)(buffer) = [item doubleValue];
            p[pi++] = buffer[0];
            p[pi++] = buffer[1];
#endif
#ifdef VARARG_PHONE_64
            *(double*)(p+pi) = [item doubleValue];
            pi++;
#endif
#ifdef VARARG_SIM_64
            *(double*)(d+di) = [item doubleValue];
            di++;
#endif
        } else {
            p[pi++] = (vartype)item;
        }
    }
}

@implementation NSNull (cat_crossmobile_null)

-(void) throwNullPointerException {
    @throw [[NSException alloc] initWithName:@"Null pointer exception" reason:@"Null pointer" userInfo:nil];
}

- (void)doesNotRecognizeSelector:(SEL)aSelector {
    [self throwNullPointerException];
}

- (java_lang_Class*) getClass__ {
    [self throwNullPointerException];
    return JAVA_NULL;
}

- (int) equals___java_lang_Object: (java_lang_Object*) o {
    [self throwNullPointerException];
    return NO;
}

- (int) hashCode__ {
    [self throwNullPointerException];
    return 0;
}

- (java_lang_String*) toString__ {
    [self throwNullPointerException];
    return JAVA_NULL;
}

- (void) wait__ {
    [self throwNullPointerException];
}

- (void) wait___long: (JAVA_LONG)timeout {
    [self throwNullPointerException];
}

- (void) wait___long_int: (JAVA_LONG)timeout :(int) nanos {
    [self throwNullPointerException];
}

- (void) notify__ {
    [self throwNullPointerException];
}

- (void) notifyAll__  {
    [self throwNullPointerException];
}

@end
