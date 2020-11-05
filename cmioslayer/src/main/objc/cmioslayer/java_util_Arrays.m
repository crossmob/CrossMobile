/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Arrays.h"
#import "java_lang_Comparable.h"
#import "java_lang_System.h"
#import "java_util_ArrayList.h"
#import "java_lang_NullPointerException.h"

static void swap(int *x,int *y)
{
   int temp;
   temp = *x;
   *x = *y;
   *y = temp;
}

static void swapObjects(XMLVMArray *x, int a, int b)
{
	java_lang_Object* t = x->array.o[a];
	x->array.o[a] = x->array.o[b];
	x->array.o[b] = t;
}

static int choose_pivot(int i, int j)
{
   return (i + j) / 2;
}

static void quicksort(int list[], int m, int n)
{
   int key, i, j, k;
   
   if (m < n) {
      k = choose_pivot(m, n);
      swap(&list[m], &list[k]);
      key = list[m];
      i = m+1;
      j = n;
      while (i <= j) {
         while ((i <= n) && (list[i] <= key))
                i++;
         while ((j >= m) && (list[j] > key))
                j--;
         if (i < j)
                swap(&list[i],&list[j]);
      }
      swap(&list[m], &list[j]);
      quicksort(list, m, j-1);
      quicksort(list, j+1, n);
   }
}

@implementation java_util_Arrays

+ (void) mergeSortWithComparator:(XMLVMArray*) src: (XMLVMArray*) dest: (int) low: (int) high: (int) off: (java_util_Comparator*)c {
	int INSERTIONSORT_THRESHOLD = 7;
	
	int length = high - low;
	
	// Insertion sort on smallest arrays
	if (length < INSERTIONSORT_THRESHOLD) {
		for (int i = low; i < high; i++) {
			int j = i;
			BOOL done = FALSE;
			while (j > low && !done) {
				int compareVal = 0;
				java_lang_Object* c1 = dest->array.o[j-1];
				java_lang_Object* c2 = dest->array.o[j];
				if (c == JAVA_NULL) {
					compareVal = [(java_lang_Comparable*)c1 compareTo___java_lang_Object:c2];
				} else {
					compareVal = [c compare___java_lang_Object_java_lang_Object:c1:c2];
				}
				if (compareVal > 0) {
					swapObjects(dest, j, j - 1);
					j--;
				} else {
					done = TRUE;
				}
			}
		}
		return;
	}
	
	// Recursively sort halves of dest into src
	int destLow  = low;
	int destHigh = high;
	low  += off;
	high += off;
	
	//TODO test that this equals "int mid = (low + high) >>> 1;"
	unsigned int mid = low + high;
	mid /= 2;
	
	[java_util_Arrays mergeSortWithComparator:dest:src:low:mid:-off:c];
	[java_util_Arrays mergeSortWithComparator:dest:src:mid:high:-off:c];
	
	// If list is already sorted, just copy from src to dest.  This is an
	// optimization that results in faster sorts for nearly ordered lists.
	int compareVal = 0;
	java_lang_Object* c1 = src->array.o[mid-1];
	java_lang_Object* c2 = src->array.o[mid];
	if (c == JAVA_NULL) {
		compareVal = [(java_lang_Comparable*)c1 compareTo___java_lang_Object:c2];
	} else {
		compareVal = [c compare___java_lang_Object_java_lang_Object:c1:c2];
	}
	if (compareVal <= 0) {
		[java_lang_System arraycopy___java_lang_Object_int_java_lang_Object_int_int:src:low:dest:destLow:length];
		return;
	}
	
	// Merge sorted halves (now in src) into dest
	for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
		int compareVal2 = 0;
		java_lang_Object* c3 = src->array.o[p];
		java_lang_Object* c4 = src->array.o[q];
		if (c == JAVA_NULL) {
			compareVal2 = [(java_lang_Comparable*)c3 compareTo___java_lang_Object:c4];
		} else {
			compareVal2 = [c compare___java_lang_Object_java_lang_Object:c3:c4];
		}
		if (q >= high || p < mid && compareVal2 <= 0) {
			dest->array.o[i] = src->array.o[p++];
		} else {
			dest->array.o[i] = src->array.o[q++];
		}
	}
}

+ (void) sort___int_ARRAYTYPE: (XMLVMArray*) a
{
	quicksort(a->array.i, 0, a->length - 1);
}

+ (void) sort___java_lang_Object_ARRAYTYPE: (XMLVMArray*) a {
	[java_util_Arrays sort___java_lang_Object_ARRAYTYPE_int_int_java_util_Comparator:a :0 :[a count] :JAVA_NULL];
}

+ (void) sort___java_lang_Object_ARRAYTYPE_java_util_Comparator: (XMLVMArray*) a: (java_util_Comparator*) c
{
	[java_util_Arrays sort___java_lang_Object_ARRAYTYPE_int_int_java_util_Comparator:a :0 :[a count] :c];
}

+ (void) sort___java_lang_Object_ARRAYTYPE_int_int_java_util_Comparator:(XMLVMArray*) a :(int) fromIndex :(int) toIndex :(java_util_Comparator*) c;
{
	XMLVMArray* aux = [a clone__];
	[java_util_Arrays mergeSortWithComparator:aux:a:fromIndex:toIndex:0:c];
	[aux release];
}

+ (java_util_List*) asList___java_lang_Object_ARRAYTYPE:(XMLVMArray*) a {
	java_util_ArrayList* result = [[java_util_ArrayList alloc]__init_java_util_ArrayList___int:[a count]];
	for (int i = 0; i < [a count]; i++) {
		[result add___java_lang_Object:a->array.o[i]];
	}
	return (java_util_List*)result;
}

+ (XMLVMArray*) copyOf___int_ARRAYTYPE_int:(XMLVMArray*) original :(int) newLength
{
    return [java_util_Arrays copyOfRange___int_ARRAYTYPE_int_int:original :0 :newLength];
}

+ (XMLVMArray*) copyOfRange___int_ARRAYTYPE_int_int:(XMLVMArray*) original :(int) from :(int) to
{
    int newLength = to - from;
	XMLVMArray* newArray = [XMLVMArray createSingleDimensionWithType:5 /*INT*/ andSize:newLength];
	[java_lang_System arraycopy___java_lang_Object_int_java_lang_Object_int_int:original :from :newArray :0 :newLength];
	return newArray;
}

+ (void) fill___boolean_ARRAYTYPE_boolean:(XMLVMArray*) a :(BOOL) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    char charV = v;
    char* array = a->array.b;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = charV;
    }
}

+ (void) fill___byte_ARRAYTYPE_byte:(XMLVMArray*) a :(char) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    char* array = a->array.b;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___short_ARRAYTYPE_short:(XMLVMArray*) a :(short) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    short* array = a->array.s;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___int_ARRAYTYPE_int:(XMLVMArray*) a :(int) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    int* array = a->array.i;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___long_ARRAYTYPE_long:(XMLVMArray*) a :(JAVA_LONG) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    JAVA_LONG* array = a->array.l;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___float_ARRAYTYPE_float:(XMLVMArray*) a :(float) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    float* array = a->array.f;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___double_ARRAYTYPE_double:(XMLVMArray*) a :(double) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    double* array = a->array.d;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___char_ARRAYTYPE_char:(XMLVMArray*) a :(unichar) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    unichar* array = a->array.c;
    int length = a->length;
    for (int i = 0; i < length; i++) {
        array[i] = v;
    }
}

+ (void) fill___java_lang_Object_ARRAYTYPE_java_lang_Object:(XMLVMArray*) a :(java_lang_Object*) v
{
    if (a==JAVA_NULL||a==nil) @throw [[java_lang_NullPointerException alloc] init];
    for (int i = 0; i < a->length; i++) {
        [a replaceObjectAtIndex:i withObject:v];
    }
}

+ (java_lang_String*) toString___boolean_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:a->array.b[i] ? @"true" : @"false"];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___byte_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[[NSNumber numberWithChar:a->array.b[i]] stringValue]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___short_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[[NSNumber numberWithShort:a->array.s[i]] stringValue]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___int_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[[NSNumber numberWithInt:a->array.i[i]] stringValue]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___long_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[[NSNumber numberWithLongLong:a->array.l[i]] stringValue]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___float_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[[NSNumber numberWithFloat:a->array.f[i]] stringValue]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___double_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[[NSNumber numberWithDouble:a->array.d[i]] stringValue]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___char_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:[NSString stringWithCharacters:&(a->array.c[i]) length:1]];
        }
        [result appendString:@"]"];
    }
    return result;
}

+ (java_lang_String*) toString___java_lang_Object_ARRAYTYPE:(XMLVMArray*) a
{
    NSMutableString *result = [[NSMutableString alloc] init];
    if (a==JAVA_NULL||a==nil) {
        [result appendString:@"null"];
    } else {
        [result appendString:@"["];
        for (int i = 0 ; i < a->length; i++) {
            if (i!=0) [result appendString:@", "];
            [result appendString:(NSString*)[a->array.o[i] toString__]];
        }
        [result appendString:@"]"];
    }
    return result;
}

@end
