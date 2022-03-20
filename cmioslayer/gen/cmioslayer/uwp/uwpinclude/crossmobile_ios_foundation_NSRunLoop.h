// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSRunLoop definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSTimer;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSRunLoop$Ext : NSRunLoop
@end

#define crossmobile_ios_foundation_NSRunLoop NSRunLoop
@interface NSRunLoop (cm_crossmobile_ios_foundation_NSRunLoop)
+ (NSRunLoop*) mainRunLoop__;
- (void) addTimer___crossmobile_ios_foundation_NSTimer_java_lang_String:(NSTimer*) timer :(NSString*) mode ;
@end
