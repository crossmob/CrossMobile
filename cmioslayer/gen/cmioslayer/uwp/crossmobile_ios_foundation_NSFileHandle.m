// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSFileHandle implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSFileHandle.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_NSFileHandle$Ext

// (NSFileHandle) @property(readonly, copy) NSData *availableData;
- (NSData*) availableData__
{
    NSData* re$ult = [super availableData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSFileHandle) @property(readonly) int fileDescriptor;
- (int) fileDescriptor__
{
    return [super fileDescriptor];
}

// (NSFileHandle) @property(readonly) unsigned long long offsetInFile;
- (JAVA_LONG) offsetInFile__
{
    return [super offsetInFile];
}

// (NSFileHandle) - (void)acceptConnectionInBackgroundAndNotify;
- (void) acceptConnectionInBackgroundAndNotify__
{
    [super acceptConnectionInBackgroundAndNotify];
}

// (NSFileHandle) - (void)acceptConnectionInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) acceptConnectionInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [super acceptConnectionInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// (NSFileHandle) - (void)closeFile;
- (void) closeFile__
{
    [super closeFile];
}

// (NSFileHandle) - (NSData *)readDataOfLength:(NSUInteger)length;
- (NSData*) readDataOfLength___int:(int) length 
{
    NSData* re$ult = [super readDataOfLength:length];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSFileHandle) - (NSData *)readDataToEndOfFile;
- (NSData*) readDataToEndOfFile__
{
    NSData* re$ult = [super readDataToEndOfFile];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSFileHandle) - (void)readInBackgroundAndNotify;
- (void) readInBackgroundAndNotify__
{
    [super readInBackgroundAndNotify];
}

// (NSFileHandle) - (void)readInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) readInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [super readInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// (NSFileHandle) - (void)readToEndOfFileInBackgroundAndNotify;
- (void) readToEndOfFileInBackgroundAndNotify__
{
    [super readToEndOfFileInBackgroundAndNotify];
}

// (NSFileHandle) - (void)readToEndOfFileInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) readToEndOfFileInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [super readToEndOfFileInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// (NSFileHandle) - (unsigned long long)seekToEndOfFile;
- (JAVA_LONG) seekToEndOfFile__
{
    return [super seekToEndOfFile];
}

// (NSFileHandle) - (void)seekToFileOffset:(unsigned long long)offset;
- (void) seekToFileOffset___long:(JAVA_LONG) offset 
{
    [super seekToFileOffset:offset];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSFileHandle) - (void)synchronizeFile;
- (void) synchronizeFile__
{
    [super synchronizeFile];
}

// (NSFileHandle) - (void)truncateFileAtOffset:(unsigned long long)offset;
- (void) truncateFileAtOffset___long:(JAVA_LONG) offset 
{
    [super truncateFileAtOffset:offset];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSFileHandle) - (void)waitForDataInBackgroundAndNotify;
- (void) waitForDataInBackgroundAndNotify__
{
    [super waitForDataInBackgroundAndNotify];
}

// (NSFileHandle) - (void)waitForDataInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) waitForDataInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [super waitForDataInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// (NSFileHandle) - (void)writeData:(NSData *)data;
- (void) writeData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    [super writeData:(data == JAVA_NULL ? nil : data)];
}

@end

@implementation NSFileHandle (cm_crossmobile_ios_foundation_NSFileHandle)

// direct binding of: + (instancetype)fileHandleForReadingAtPath:(NSString *)path;
+ (instancetype) fileHandleForReadingAtPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSFileHandle fileHandleForReadingAtPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)fileHandleForReadingFromURL:(NSURL *)url error:(NSError * _Nullable *)error;
+ (instancetype) fileHandleForReadingFromURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSFileHandle fileHandleForReadingFromURL:(url == JAVA_NULL ? nil : url) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)fileHandleForUpdatingAtPath:(NSString *)path;
+ (instancetype) fileHandleForUpdatingAtPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSFileHandle fileHandleForUpdatingAtPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)fileHandleForUpdatingURL:(NSURL *)url error:(NSError * _Nullable *)error;
+ (instancetype) fileHandleForUpdatingURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSFileHandle fileHandleForUpdatingURL:(url == JAVA_NULL ? nil : url) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)fileHandleForWritingAtPath:(NSString *)path;
+ (instancetype) fileHandleForWritingAtPath___java_lang_String:(NSString*) path 
{
    id re$ult = [NSFileHandle fileHandleForWritingAtPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)fileHandleForWritingToURL:(NSURL *)url error:(NSError * _Nullable *)error;
+ (instancetype) fileHandleForWritingToURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSFileHandle fileHandleForWritingToURL:(url == JAVA_NULL ? nil : url) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSFileHandle *)fileHandleWithNullDevice;
+ (NSFileHandle*) fileHandleWithNullDevice__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithNullDevice];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSFileHandle *)fileHandleWithStandardError;
+ (NSFileHandle*) fileHandleWithStandardError__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithStandardError];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSFileHandle *)fileHandleWithStandardInput;
+ (NSFileHandle*) fileHandleWithStandardInput__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithStandardInput];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSFileHandle *)fileHandleWithStandardOutput;
+ (NSFileHandle*) fileHandleWithStandardOutput__
{
    NSFileHandle* re$ult = [NSFileHandle fileHandleWithStandardOutput];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithFileDescriptor:(int)fd;
- (instancetype) __init_crossmobile_ios_foundation_NSFileHandle___int:(int) fd 
{
    return [self initWithFileDescriptor:fd];
}

// direct binding of: - (instancetype)initWithFileDescriptor:(int)fd closeOnDealloc:(BOOL)closeopt;
- (instancetype) __init_crossmobile_ios_foundation_NSFileHandle___int_boolean:(int) fd :(BOOL) closeopt 
{
    return [self initWithFileDescriptor:fd closeOnDealloc:closeopt];
}

// direct binding of: @property(readonly, copy) NSData *availableData;
- (NSData*) availableData__
{
    NSData* re$ult = [self availableData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) int fileDescriptor;
- (int) fileDescriptor__
{
    return [self fileDescriptor];
}

// direct binding of: @property(readonly) unsigned long long offsetInFile;
- (JAVA_LONG) offsetInFile__
{
    return [self offsetInFile];
}

// direct binding of: - (void)acceptConnectionInBackgroundAndNotify;
- (void) acceptConnectionInBackgroundAndNotify__
{
    [self acceptConnectionInBackgroundAndNotify];
}

// direct binding of: - (void)acceptConnectionInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) acceptConnectionInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self acceptConnectionInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// direct binding of: - (void)closeFile;
- (void) closeFile__
{
    [self closeFile];
}

// direct binding of: - (NSData *)readDataOfLength:(NSUInteger)length;
- (NSData*) readDataOfLength___int:(int) length 
{
    NSData* re$ult = [self readDataOfLength:length];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSData *)readDataToEndOfFile;
- (NSData*) readDataToEndOfFile__
{
    NSData* re$ult = [self readDataToEndOfFile];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)readInBackgroundAndNotify;
- (void) readInBackgroundAndNotify__
{
    [self readInBackgroundAndNotify];
}

// direct binding of: - (void)readInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) readInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self readInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// direct binding of: - (void)readToEndOfFileInBackgroundAndNotify;
- (void) readToEndOfFileInBackgroundAndNotify__
{
    [self readToEndOfFileInBackgroundAndNotify];
}

// direct binding of: - (void)readToEndOfFileInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) readToEndOfFileInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self readToEndOfFileInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// direct binding of: - (unsigned long long)seekToEndOfFile;
- (JAVA_LONG) seekToEndOfFile__
{
    return [self seekToEndOfFile];
}

// direct binding of: - (void)seekToFileOffset:(unsigned long long)offset;
- (void) seekToFileOffset___long:(JAVA_LONG) offset 
{
    [self seekToFileOffset:offset];
}

// direct binding of: - (void)synchronizeFile;
- (void) synchronizeFile__
{
    [self synchronizeFile];
}

// direct binding of: - (void)truncateFileAtOffset:(unsigned long long)offset;
- (void) truncateFileAtOffset___long:(JAVA_LONG) offset 
{
    [self truncateFileAtOffset:offset];
}

// direct binding of: - (void)waitForDataInBackgroundAndNotify;
- (void) waitForDataInBackgroundAndNotify__
{
    [self waitForDataInBackgroundAndNotify];
}

// direct binding of: - (void)waitForDataInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;
- (void) waitForDataInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes 
{
    [self waitForDataInBackgroundAndNotifyForModes:(modes == JAVA_NULL ? nil : modes)];
}

// direct binding of: - (void)writeData:(NSData *)data;
- (void) writeData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    [self writeData:(data == JAVA_NULL ? nil : data)];
}

@end
