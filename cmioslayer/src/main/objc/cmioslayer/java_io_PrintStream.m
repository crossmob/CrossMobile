/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_PrintStream.h"
#import "java_io_FileOutputStream.h"
#import "java_io_File.h"

// java.io.PrintStream
//----------------------------------------------------------------------------
@implementation java_io_PrintStream;

- (instancetype) __init_java_io_PrintStream___java_io_OutputStream: (java_io_OutputStream*) s
{
    return [self __init_java_io_PrintStream___java_io_OutputStream_boolean:s :FALSE];
}

- (instancetype) __init_java_io_PrintStream___java_io_File:(java_io_File*) file
{
    java_io_FileOutputStream * s = [[java_io_FileOutputStream alloc] init];
    [s __init_java_io_FileOutputStream___java_io_File:file];
    [self __init_java_io_PrintStream___java_io_OutputStream_boolean:s :FALSE];
    [s release];
    return self;
}

- (instancetype) __init_java_io_PrintStream___java_lang_String:(java_lang_String*) filename
{
    java_io_File * f = [[java_io_File alloc] init];
    [f __init_java_io_File___java_lang_String:filename];
    [self __init_java_io_PrintStream___java_io_File:f];
    [f release];
    return self;
}

- (instancetype) __init_java_io_PrintStream___java_io_OutputStream_boolean:(java_io_OutputStream*) s :(int)af
{
    self->os = [s retain];
    self->autoFlush = af;
    return self;
}

- (void) dealloc
{
	[self->os release];
	[super dealloc];
}

- (void) writeString: (NSString*) str
{
	if (str==JAVA_NULL) {
		str=@"null";
        return;
    }
    char * cstr = [str UTF8String];
    int pointer = 0;
    while (cstr[pointer]!=0) {
        [self-> os write___int:cstr[pointer]];
        pointer++;
    }
}

- (void) write___int:(int) i
{
    [self->os write___int:i];
}

- (void) println__
{
	[self->os write___int:'\n'];
    if (self->autoFlush) {
        [self flush__];
    }
}

- (void) println___boolean: (int) i
{
	[self writeString: (i == NO) ? @"false" : @"true"];
    [self println__];
}

- (void) println___int: (int) i
{
    [self writeString:[NSString stringWithFormat:@"%d", i]];
    [self println__];
}


- (void) println___float: (float) f
{
	[self writeString:[NSString stringWithFormat:@"%f", f]];
    [self println__];
}


- (void) println___double: (double) d
{
    [self writeString:[NSString stringWithFormat:@"%lf", d]];
    [self println__];
}


- (void) println___java_lang_String: (NSString*) s
{
	[self writeString:s];
    [self println__];
}

- (void) println___java_lang_Object: (java_lang_Object*) o
{
	[self print___java_lang_Object:o];
	[self println__];
}

- (void) println___byte: (char) b
{
	[self writeString:[NSString stringWithFormat:@"%d", b]];
    [self println__];
}

- (void) println___short: (short) s
{
	[self writeString:[NSString stringWithFormat:@"%hi", s]];
    [self println__];
}

- (void) println___long: (JAVA_LONG) l
{
	[self writeString:[NSString stringWithFormat:@"%qi", l]];
    [self println__];
}

- (void) println___char: (unichar) c
{
    [self writeString:[NSString stringWithFormat:@"%C", c]];
    [self println__];
}

- (void) print___boolean: (int) i
{
	[self writeString: ((i == NO) ? @"false" : @"true")];
}

- (void) print___int: (int) i
{
    [self writeString:[NSString stringWithFormat:@"%d", i]];
}


- (void) print___float: (float) f
{
	[self writeString:[NSString stringWithFormat:@"%f", f]];
}


- (void) print___double: (double) d
{
    [self writeString:[NSString stringWithFormat:@"%lf", d]];
}


- (void) print___java_lang_String: (NSString*) s
{
	[self writeString:s];
}

- (void) print___java_lang_Object: (java_lang_Object*) o
{
	if (o==JAVA_NULL)
		[self writeString:@"null"];
	else {
		NSString* s= [o toString__];
		[self writeString:s];
		[s release];
	}
}

- (void) print___byte: (char) b
{
	[self writeString:[NSString stringWithFormat:@"%d", b]];
}

- (void) print___short: (short) s
{
	[self writeString:[NSString stringWithFormat:@"%hi", s]];
}

- (void) print___long: (JAVA_LONG) l
{
	[self writeString:[NSString stringWithFormat:@"%qi", l]];
}

- (void) print___char: (unichar) c
{
    [self writeString:[NSString stringWithFormat:@"%C", c]];
}

- (void) flush__
{
    [self-> os flush__];
}

@end
