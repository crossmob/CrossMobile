/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_io_PrintStream.h"
#import "java_io_InputStream.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_System : java_lang_Object

+ (void) initialize;
+ (java_io_PrintStream*) _GET_out;
+ (java_io_PrintStream*) _GET_err;
+ (java_io_InputStream*) _GET_in;
+ (void) setOut___java_io_PrintStream: (java_io_PrintStream*) ps;
+ (void) setErr___java_io_PrintStream: (java_io_PrintStream*) ps;
+ (JAVA_LONG) currentTimeMillis__;
+ (JAVA_LONG) nanoTime__;
+ (java_lang_String *) setProperty___java_lang_String_java_lang_String: (java_lang_String *) s1: (java_lang_String *) s2;
+ (void) arraycopy___java_lang_Object_int_java_lang_Object_int_int
               :(java_lang_Object*) src
               :(int) srcPos
               :(java_lang_Object*) dest
               :(int) destPos
               :(int) length;
+ (void) gc__;
+ (int) identityHashCode___java_lang_Object: (java_lang_Object*) o;
+ (java_lang_String*) getProperty___java_lang_String_java_lang_String:(java_lang_String*)key :(java_lang_String*)defaultValue;
+ (java_lang_String*) getProperty___java_lang_String:(java_lang_String*)key;
+ (void) exit___int:(int)exitcode;

@end
