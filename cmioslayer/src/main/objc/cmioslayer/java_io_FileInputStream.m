/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_FileInputStream.h"
#import "java_io_FileNotFoundException.h"


@implementation java_io_FileInputStream

- (instancetype) __init_java_io_FileInputStream___java_lang_String :(java_lang_String*) path
{
	java_io_File *fi = [[java_io_File alloc] init];
	[fi __init_java_io_File___java_lang_String: path];
	[self __init_java_io_FileInputStream___java_io_File: fi];
	[fi release];
    return self;
}

- (instancetype) __init_java_io_FileInputStream___java_io_FileDescriptor :(java_io_FileDescriptor*) fdpar
{
	self->fd = [fdpar retain];
    return self;
}

- (instancetype) __init_java_io_FileInputStream___java_io_File: (java_io_File*) f 
{
	NSFileHandle *fdImpl;
	java_lang_String* path = [f getCanonicalPath__];
	NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
	fdImpl = [NSFileHandle fileHandleForReadingAtPath: path];
	[path release];
	if (fdImpl == nil) {
		[pool release];
		java_io_FileNotFoundException* ex = [[java_io_FileNotFoundException alloc] init];
		@throw ex;
	}
	self->fd = [[java_io_FileDescriptor alloc] init];
	[fd __init_java_io_FileDescriptor___NSFileHandle: fdImpl];
	[pool release];
    return self;
}

- (void) dealloc
{
	[self->fd release];
	[super dealloc];
}

- (int) available__
{
    NSFileHandle* fh = [self->fd fileHandle];
    unsigned long long offset = [fh offsetInFile];
    NSData* data = [fh availableData];
    [fh seekToFileOffset:offset];
    return [data length];
}

- (int) read__
{
	NSFileHandle* fh = [self->fd fileHandle];
	NSData *data = [fh readDataOfLength: 1];
	if (data == nil) {
		return -1;
	}
	char * ptr = (char *) [data bytes];
	if (ptr == NULL) {
		return -1;
	}	
	int i = ptr[0];
	return i;
}

- (JAVA_LONG) skip___long: (JAVA_LONG) n
{
	NSFileHandle* fh = [self->fd fileHandle];
	long initialPos = [fh offsetInFile];
	long newPos = n+initialPos;
	[fh seekToFileOffset: newPos];
	return [fh offsetInFile] - initialPos;
}


- (void) close__
{
	if (self->fd == JAVA_NULL) {
		return;
	}
	
	NSFileHandle* fh = [self->fd fileHandle];
	[fh closeFile];
}

- (java_io_FileDescriptor*) getFD__
{
	return [self->fd retain];
}

- (bool) markSupported__
{
	return true;
}

- (void) mark___int: (int) max
{
	NSFileHandle* fh = [self->fd fileHandle];
	marked = [fh offsetInFile];
}

- (void) mark___long: (JAVA_LONG) max
{
	NSFileHandle* fh = [self->fd fileHandle];
	marked = [fh offsetInFile];
}

- (void) reset__
{
	NSFileHandle* fh = [self->fd fileHandle];
	[fh seekToFileOffset: marked];
}

- (int) read___byte_ARRAYTYPE :(XMLVMArray*)buf
{
	NSFileHandle* fh = [self->fd fileHandle];
	int len = [buf count];
	NSData *data = [fh readDataOfLength: len];
	if (data == nil) {
		return -1;
	}
	char * ptr = (char *) [data bytes];
	if (ptr == NULL) {
		return -1;
	} else {
		for (int i = 0; i < [data length]; i++) {
			buf->array.b[i] = ptr[i];
		}
		return [data length];
	}
}	

- (int) read___byte_ARRAYTYPE_int_int :(XMLVMArray*)buf :(int)offs :(int)len
{
	NSFileHandle* fh = [self->fd fileHandle];
	NSData *data = [fh readDataOfLength: len];
	if (data == nil) {
		return -1;
	}
	char * ptr = (char *) [data bytes];
	if (ptr == NULL) {
		return -1;
	}	else {
		for (int i = 0; i < [data length]; i++) {
			buf->array.b[offs+i] = ptr[i];
		}
		return [data length];
	}
}	

@end
