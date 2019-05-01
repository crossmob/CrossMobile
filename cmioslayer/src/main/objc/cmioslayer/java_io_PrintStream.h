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

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_io_OutputStream.h"
#import "java_io_File.h"
#import "java_lang_String.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_PrintStream : java_lang_Object {
@private java_io_OutputStream* os;
@private int autoFlush;
}

- (instancetype) __init_java_io_PrintStream___java_io_OutputStream: (java_io_OutputStream*) s;
- (instancetype) __init_java_io_PrintStream___java_io_File:(java_io_File*) file;
- (instancetype) __init_java_io_PrintStream___java_lang_String:(java_lang_String*) filename;
- (instancetype) __init_java_io_PrintStream___java_io_OutputStream_boolean:(java_io_OutputStream*) s :(int)autoflush;
- (void) dealloc;
- (void) writeString: (NSString*) str;

- (void) write___int:(int) i;
- (void) println___boolean: (int) i;
- (void) println___int: (int) i;
- (void) println___float: (float) f;
- (void) println___double: (double) d;
- (void) println___java_lang_String: (NSString*) s;
- (void) println___java_lang_Object: (java_lang_Object*) o;
- (void) println___byte: (char) b;
- (void) println___short: (short) s;
- (void) println___long: (JAVA_LONG) l;
- (void) println___char: (unichar) c;
- (void) println__;
- (void) print___boolean: (int) i;
- (void) print___int: (int) i;
- (void) print___float: (float) f;
- (void) print___double: (double) d;
- (void) print___java_lang_String: (NSString*) s;
- (void) print___java_lang_Object: (java_lang_Object*) o;
- (void) print___byte: (char) b;
- (void) print___short: (short) s;
- (void) print___long: (JAVA_LONG) i;
- (void) print___char: (unichar) c;
- (void) flush__;
@end
