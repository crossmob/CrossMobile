/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_File.h"
#import "java_lang_StringBuffer.h"
#import "java_lang_IllegalArgumentException.h"

// java.io.File
//----------------------------------------------------------------------------
@implementation java_io_File

+ (java_lang_String*) _GET_separator
{
	return [_separator retain];
}

+ (XMLVMArray*) listRoots__
{
	java_io_File* f = [[java_io_File alloc] init];
	[f __init_java_io_File___java_lang_String: @"/"];
	XMLVMArray* arr = [XMLVMArray createSingleDimensionWithType: 0 andSize: 1];
	[arr retain];
	arr->array.o[0] = f;
	return arr;
}

+ (java_io_File*) createTempFile___java_lang_String_java_lang_String:(java_lang_String*)prefix :(java_lang_String*)suffix
{
	if (suffix==JAVA_NULL)
		suffix = @".tmp";
	if (prefix==JAVA_NULL || [prefix length]<3) {
		java_lang_IllegalArgumentException* ex = [[[java_lang_IllegalArgumentException alloc] init] autorelease];
		[ex __init_java_lang_IllegalArgumentException__];
		@throw ex;
	}
	
	// Create file template
	NSString * nsformat = [[NSString alloc] initWithFormat:@"%@%@XXXXXXXX%@", NSTemporaryDirectory(), prefix, suffix];
	const char * format = [nsformat UTF8String];
	[nsformat release];
	
	// Create temporary file name
	int size = strlen(format);
	char * template = malloc(size);
	strncpy(template, format, size+1);
#if defined(_WIN32) || defined(WIN32)
	_mktemp_s(template, [suffix length]);
#else
	mkstemps(template, [suffix length]);
#endif
	// Create actual temporary file
	NSString * nsresult = [[NSString alloc] initWithUTF8String:template];
	free(template);
	java_io_File * result = [[java_io_File alloc] init];
	[result __init_java_io_File___java_lang_String:(java_lang_String*)nsresult];
	[nsresult release];
	
	return result;
}

- (instancetype) __init_java_io_File___java_net_URI: (java_net_URI*) uri
{
	path = [uri getPath__];
    return self;
}

- (instancetype) __init_java_io_File___java_lang_String: (java_lang_String*) pathname
{
	if (pathname==JAVA_NULL || [pathname length] == 0 || [pathname characterAtIndex:0] != '/') {
		// For relative paths, prepend the base directory of <App>/Documents/
		// http://developer.apple.com/iphone/library/documentation/iPhone/Conceptual/iPhoneOSProgrammingGuide/FilesandNetworking/FilesandNetworking.html
		NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
		path = [[NSMutableString alloc] init];
		[path setString:[paths objectAtIndex:0]];
		[path appendFormat:@"/%@", pathname];
	} else {
		path = [[pathname copyWithZone: NULL] retain];
	}
    return self;
}

- (instancetype) __init_java_io_File___java_io_File_java_lang_String: (java_io_File*) dir: (java_lang_String*) name
{
	path = [[NSMutableString alloc] init];
	[(NSMutableString*)path appendString: [dir getPath__]];
	[(NSMutableString*)path appendString: _separator];
	[(NSMutableString*)path appendString: name];
    return self;
}

- (void) dealloc
{
	[path release];
	[super dealloc];
}

- (bool) canRead__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man isReadableFileAtPath: path];
}

- (bool) canWrite__ 
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man isWritableFileAtPath: path];	
}

- (bool) createNewFile__
{
	NSFileManager *man = [NSFileManager defaultManager];
	const char d[0];
	NSData *data = [NSData dataWithBytes: d length: 0];
	bool b = [man createFileAtPath: path contents: data attributes: nil];
	return b;
}

- (bool) delete__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man removeItemAtPath: path error: NULL];
}

- (bool) exists__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man fileExistsAtPath: path];
}

- (JAVA_LONG) length__
{
	NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
	NSFileManager *man = [NSFileManager defaultManager];
	NSDictionary *attrs = [man attributesOfItemAtPath: path error: NULL];
	JAVA_LONG size = attrs == nil ? -1 : [attrs fileSize];
	[pool release];
	return size;
}

- (java_lang_String*) getName__
{
	return [[path lastPathComponent] retain];
}

- (java_lang_String*) getPath__
{
	return [path retain];
}

- (java_net_URI*) toURI__
{
	java_lang_StringBuffer* s = [[java_lang_StringBuffer alloc] init];
	[s append___java_lang_String: @"file://"];
	java_lang_String* s2 = [self getAbsolutePath__];
	[s append___java_lang_String: s2];
	[s2 release];
	java_net_URI* u = [[java_net_URI alloc] initWithString: s];
	[s release];
	return u;
}

- (bool) isDirectory__
{	
	BOOL isDir = true;
	if ([[NSFileManager defaultManager] fileExistsAtPath: path isDirectory: &isDir])
        return isDir;
    return false;
}

- (bool) isFile__
{
    BOOL isDir = true;
    if ([[NSFileManager defaultManager] fileExistsAtPath: path isDirectory: &isDir])
        return !isDir;
    return false;
}

- (bool) isHidden__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSDictionary *attrs = [man attributesOfItemAtPath: path error: NULL];
	if (attrs == nil) {
		return -1;
	}
	return [[attrs objectForKey: NSFileExtensionHidden] boolValue];
}

- (JAVA_LONG) lastModified__
{
/*	NSFileManager *man = [NSFileManager defaultManager];
	NSDictionary *attrs = [man attributesOfItemAtPath: path error: NULL];
	NSDate *n = [attrs fileModificationDate];*/
	NSDate *n = [NSDate date];//TODO real
	return (JAVA_LONG) ([n timeIntervalSince1970] * 1000);
}

- (XMLVMArray*) list__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return JAVA_NULL;
	}
	int count = [files count];
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 0 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [files objectAtIndex: i];
		[s retain];
		f->array.o[i] = s;
	}
	return f;
}

- (XMLVMArray*) list___java_io_FilenameFilter: (java_io_FilenameFilter*) filter
{
	NSFileManager *man = [NSFileManager defaultManager];
	
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return JAVA_NULL;
	}
	
	NSMutableArray *arr = [NSMutableArray arrayWithCapacity: [files count]];
	for (java_lang_String *s in files) {
		if ([filter accept___java_io_File_java_lang_String: self : s]) {
			[arr addObject: s];
		}
	}
	
	int count = [arr count];
	
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 0 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [arr objectAtIndex: i];
		[s retain];
		f->array.o[i] = s;
	}
	
	return f;	
}

- (XMLVMArray*) listFiles__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return JAVA_NULL;
	}
	int count = [files count];
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 0 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [files objectAtIndex: i];
		java_io_File* fi = [[java_io_File alloc] init];
		[fi __init_java_io_File___java_io_File_java_lang_String: self : s];
		f->array.o[i] = [fi retain];
	}
	return f;
}

- (XMLVMArray*) listFiles___java_io_FilenameFilter: (java_io_FilenameFilter*) filter
{
	NSFileManager *man = [NSFileManager defaultManager];
	
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return nil;
	}
	
	NSMutableArray *arr = [NSMutableArray arrayWithCapacity: [files count]];
	for (java_lang_String *s in files) {
		if ([filter accept___java_io_File_java_lang_String: self : s]) {
			[arr addObject: s];
		}
	}
	
	int count = [arr count];
	
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 0 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [arr objectAtIndex: i];
		java_io_File* fi = [[java_io_File alloc] init];
		[fi __init_java_io_File___java_io_File_java_lang_String: self : s];
		f->array.o[i] = [fi retain];
	}
	
	return f;		
}

- (bool) mkdir__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man createDirectoryAtPath: path withIntermediateDirectories: false attributes: nil error: NULL];
}

- (bool) mkdirs__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man createDirectoryAtPath: path withIntermediateDirectories: true attributes: nil error: NULL];
}

- (java_lang_String*) getAbsolutePath__
{
	if ([path startsWith___java_lang_String: _separator]) {
		return [path retain];
	}
	NSFileManager *man = [NSFileManager defaultManager];
	NSString *currentDir = [man currentDirectoryPath];
	if (currentDir == nil) {
		return [path retain];
	}
	NSMutableString* s = [NSMutableString stringWithString: currentDir];
	if (! [s endsWith___java_lang_String:_separator]) {
		[s appendString: _separator];
	}
	[s appendString: path];	
	NSString *s2 = [s stringByStandardizingPath];
	return [s2 retain];
	
}

- (java_lang_String*) getCanonicalPath__
{
	return [self getAbsolutePath__];
}


- (JAVA_LONG) getUsableSpace__
{
	int64_t totalSpace = 0;  
    NSError *error = nil;  
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);  
    NSDictionary *dictionary = [[NSFileManager defaultManager] attributesOfFileSystemForPath:[paths lastObject] error: &error];  
    if (dictionary) {  
        NSNumber *fileSystemSizeInBytes = [dictionary objectForKey: NSFileSystemFreeSize];  
        totalSpace = [fileSystemSizeInBytes longLongValue];  
    }
    return totalSpace / 1024;  //TODO real, it's KByte.
}

- (bool) renameTo___java_io_File: (java_io_File*) f
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man moveItemAtPath: path toPath: [f getCanonicalPath__] error: NULL];
}

- (java_io_File*) getParentFile__
{
	java_io_File * result = [[java_io_File alloc] init];
	[result __init_java_io_File___java_lang_String:(java_lang_String*)[path stringByDeletingLastPathComponent]];
	return result;
}

@end

