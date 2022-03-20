// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSMutableData definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSMutableData$Ext : NSMutableData
@end

#define crossmobile_ios_foundation_NSMutableData NSMutableData
@interface NSMutableData (cm_crossmobile_ios_foundation_NSMutableData)
+ (instancetype) dataWithBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes ;
+ (instancetype) dataWithBytesNoCopy___byte_ARRAYTYPE:(XMLVMArray*) bytes ;
+ (instancetype) dataWithContentsOfFile___java_lang_String:(NSString*) path ;
+ (instancetype) dataWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) aURL ;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableData___int:(int) length ;
- (void) appendBytes___byte_ARRAYTYPE:(XMLVMArray*) bytes ;
- (void) appendData___crossmobile_ios_foundation_NSData:(NSData*) other ;
- (void) setData___crossmobile_ios_foundation_NSData:(NSData*) data ;
@end
