// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSFileHandle implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSFileHandle.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_NSFileHandle$Ext

@end

@implementation NSFileHandle (cm_crossmobile_ios_foundation_NSFileHandle)

// + (instancetype)fileHandleForReadingAtPath:(NSString *)path;
+ (instancetype) fileHandleForReadingAtPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSFileHandle fileHandleForReadingAtPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)fileHandleForReadingFromURL:(NSURL *)url error:(NSError * _Nullable *)error;
+ (instancetype) fileHandleForReadingFromURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSFileHandle fileHandleForReadingFromURL:(url == JAVA_NULL ? nil : url) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)fileHandleForUpdatingAtPath:(NSString *)path;
+ (instancetype) fileHandleForUpdatingAtPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSFileHandle fileHandleForUpdatingAtPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)fileHandleForUpdatingURL:(NSURL *)url error:(NSError * _Nullable *)error;
+ (instancetype) fileHandleForUpdatingURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSFileHandle fileHandleForUpdatingURL:(url == JAVA_NULL ? nil : url) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)fileHandleForWritingAtPath:(NSString *)path;
+ (instancetype) fileHandleForWritingAtPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSFileHandle fileHandleForWritingAtPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)fileHandleForWritingToURL:(NSURL *)url error:(NSError * _Nullable *)error;
+ (instancetype) fileHandleForWritingToURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSFileHandle fileHandleForWritingToURL:(url == JAVA_NULL ? nil : url) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSFileHandle *)fileHandleWithNullDevice;
+ (NSFileHandle*) fileHandleWithNullDevice__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithNullDevice];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSFileHandle *)fileHandleWithStandardError;
+ (NSFileHandle*) fileHandleWithStandardError__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithStandardError];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSFileHandle *)fileHandleWithStandardInput;
+ (NSFileHandle*) fileHandleWithStandardInput__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithStandardInput];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSFileHandle *)fileHandleWithStandardOutput;
+ (NSFileHandle*) fileHandleWithStandardOutput__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithStandardOutput];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithFileDescriptor:(int)fd;
- (instancetype) __init_crossmobile_ios_foundation_NSFileHandle___int:(int) fd 
{
    return [self initWithFileDescriptor:fd];
}

// - (instancetype)initWithFileDescriptor:(int)fd closeOnDealloc:(BOOL)closeopt;
- (instancetype) __init_crossmobile_ios_foundation_NSFileHandle___int_boolean:(int) fd :(BOOL) closeopt 
{
    return [self initWithFileDescriptor:fd closeOnDealloc:closeopt];
}

// @property(readonly, copy) NSData *availableData;
- (NSData*) availableData__
{
    NSData* re$ult = [self availableData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) int fileDescriptor;
- (int) fileDescriptor__
{
    return [self fileDescriptor];
}

// @property(readonly) unsigned long long offsetInFile;
- (JAVA_LONG) offsetInFile__
{
    return [self offsetInFile];
}

// - (void)acceptConnectionInBackgroundAndNotify;
- (void) acceptConnectionInBackgroundAndNotify__
{
    [self acceptConnectionInBackgroundAndNotify];
}

// - (void)acceptConnectionInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) acceptConnectionInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self acceptConnectionInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// - (void)closeFile;
- (void) closeFile__
{
    [self closeFile];
}

// - (NSData *)readDataOfLength:(NSUInteger)length;
- (NSData*) readDataOfLength___int:(int) length 
{
    NSData* re$ult = [self readDataOfLength:length];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSData *)readDataToEndOfFile;
- (NSData*) readDataToEndOfFile__
{
    NSData* re$ult = [self readDataToEndOfFile];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)readInBackgroundAndNotify;
- (void) readInBackgroundAndNotify__
{
    [self readInBackgroundAndNotify];
}

// - (void)readInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) readInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self readInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// - (void)readToEndOfFileInBackgroundAndNotify;
- (void) readToEndOfFileInBackgroundAndNotify__
{
    [self readToEndOfFileInBackgroundAndNotify];
}

// - (void)readToEndOfFileInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) readToEndOfFileInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self readToEndOfFileInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// - (unsigned long long)seekToEndOfFile;
- (JAVA_LONG) seekToEndOfFile__
{
    return [self seekToEndOfFile];
}

// - (void)seekToFileOffset:(unsigned long long)offset;
- (void) seekToFileOffset___long:(JAVA_LONG) offset 
{
    [self seekToFileOffset:offset];
}

// - (void)synchronizeFile;
- (void) synchronizeFile__
{
    [self synchronizeFile];
}

// - (void)truncateFileAtOffset:(unsigned long long)offset;
- (void) truncateFileAtOffset___long:(JAVA_LONG) offset 
{
    [self truncateFileAtOffset:offset];
}

// - (void)waitForDataInBackgroundAndNotify;
- (void) waitForDataInBackgroundAndNotify__
{
    [self waitForDataInBackgroundAndNotify];
}

// - (void)waitForDataInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) waitForDataInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self waitForDataInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// - (void)writeData:(NSData *)data;
- (void) writeData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    [self writeData:(data == JAVA_NULL ? nil : data)];
}

@end
