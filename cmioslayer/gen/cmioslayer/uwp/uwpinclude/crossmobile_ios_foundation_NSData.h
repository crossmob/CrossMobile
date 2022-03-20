// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSData definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSData$Ext : NSData
@end

#define crossmobile_ios_foundation_NSData NSData
@interface NSData (cm_crossmobile_ios_foundation_NSData)
+ (instancetype) dataWithBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes ;
+ (instancetype) dataWithBytesNoCopy___byte_ARRAYTYPE:(XMLVMArray*) bytes ;
+ (instancetype) dataWithContentsOfFile___java_lang_String:(NSString*) path ;
+ (instancetype) dataWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (instancetype) __init_crossmobile_ios_foundation_NSData___java_lang_String_int:(NSString*) base64String :(int) options ;
- (void*) bytes__;
- (int) length__;
- (NSString*) base64EncodedStringWithOptions___int:(int) options ;
- (BOOL) writeToFile___java_lang_String_boolean:(NSString*) path :(BOOL) useAuxiliaryFile ;
@end
