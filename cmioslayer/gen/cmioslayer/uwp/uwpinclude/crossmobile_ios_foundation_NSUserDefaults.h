// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSUserDefaults definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSUserDefaults$Ext : NSUserDefaults
@end

#define crossmobile_ios_foundation_NSUserDefaults NSUserDefaults
@interface NSUserDefaults (cm_crossmobile_ios_foundation_NSUserDefaults)
+ (NSUserDefaults*) standardUserDefaults__;
- (instancetype) __init_crossmobile_ios_foundation_NSUserDefaults___java_lang_String:(NSString*) suitename ;
- (BOOL) boolForKey___java_lang_String:(NSString*) defaultName ;
- (NSData*) dataForKey___java_lang_String:(NSString*) defaultName ;
- (double) doubleForKey___java_lang_String:(NSString*) defaultName ;
- (float) floatForKey___java_lang_String:(NSString*) defaultName ;
- (int) integerForKey___java_lang_String:(NSString*) defaultName ;
- (id) objectForKey___java_lang_String:(NSString*) defaultName ;
- (void) removeObjectForKey___java_lang_String:(NSString*) defaultName ;
- (void) setBool___boolean_java_lang_String:(BOOL) value :(NSString*) defaultName ;
- (void) setDouble___double_java_lang_String:(double) value :(NSString*) defaultName ;
- (void) setFloat___float_java_lang_String:(float) value :(NSString*) defaultName ;
- (void) setInteger___int_java_lang_String:(int) value :(NSString*) defaultName ;
- (void) setObject___java_lang_Object_java_lang_String:(id) value :(NSString*) defaultName ;
- (NSString*) stringForKey___java_lang_String:(NSString*) defaultName ;
- (BOOL) synchronize__;
@end
