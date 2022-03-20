// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSFileHandle definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_rt_StrongReference;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_foundation_NSFileHandle$Ext : NSFileHandle
@end

#define crossmobile_ios_foundation_NSFileHandle NSFileHandle
@interface NSFileHandle (cm_crossmobile_ios_foundation_NSFileHandle)
+ (instancetype) fileHandleForReadingAtPath___java_lang_String:(NSString*) path ;
+ (instancetype) fileHandleForReadingFromURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error ;
+ (instancetype) fileHandleForUpdatingAtPath___java_lang_String:(NSString*) path ;
+ (instancetype) fileHandleForUpdatingURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error ;
+ (instancetype) fileHandleForWritingAtPath___java_lang_String:(NSString*) path ;
+ (instancetype) fileHandleForWritingToURL___crossmobile_ios_foundation_NSURL_crossmobile_rt_StrongReference:(NSURL*) url :(crossmobile_rt_StrongReference*) error ;
+ (NSFileHandle*) fileHandleWithNullDevice__;
+ (NSFileHandle*) fileHandleWithStandardError__;
+ (NSFileHandle*) fileHandleWithStandardInput__;
+ (NSFileHandle*) fileHandleWithStandardOutput__;
- (instancetype) __init_crossmobile_ios_foundation_NSFileHandle___int:(int) fd ;
- (instancetype) __init_crossmobile_ios_foundation_NSFileHandle___int_boolean:(int) fd :(BOOL) closeopt ;
- (NSData*) availableData__;
- (int) fileDescriptor__;
- (JAVA_LONG) offsetInFile__;
- (void) acceptConnectionInBackgroundAndNotify__;
- (void) acceptConnectionInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes ;
- (void) closeFile__;
- (NSData*) readDataOfLength___int:(int) length ;
- (NSData*) readDataToEndOfFile__;
- (void) readInBackgroundAndNotify__;
- (void) readInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes ;
- (void) readToEndOfFileInBackgroundAndNotify__;
- (void) readToEndOfFileInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes ;
- (JAVA_LONG) seekToEndOfFile__;
- (void) seekToFileOffset___long:(JAVA_LONG) offset ;
- (void) synchronizeFile__;
- (void) truncateFileAtOffset___long:(JAVA_LONG) offset ;
- (void) waitForDataInBackgroundAndNotify__;
- (void) waitForDataInBackgroundAndNotifyForModes___java_util_List:(NSArray*) modes ;
- (void) writeData___crossmobile_ios_foundation_NSData:(NSData*) data ;
@end
