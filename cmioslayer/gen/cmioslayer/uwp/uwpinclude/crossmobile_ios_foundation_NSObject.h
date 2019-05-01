// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSObject definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSObject$Ext : NSObject
@end

#define crossmobile_ios_foundation_NSObject NSObject
@interface NSObject (cm_crossmobile_ios_foundation_NSObject)
- (instancetype) __init_crossmobile_ios_foundation_NSObject__;
- (void) performSelector___crossmobile_ios_foundation_NSSelector_java_lang_Object_double:(id<crossmobile_ios_foundation_NSSelector>) aSelector :(id) anArgument :(double) delay ;
- (void) performSelectorOnMainThread___crossmobile_ios_foundation_NSSelector_java_lang_Object_boolean:(id<crossmobile_ios_foundation_NSSelector>) aSelector :(id) arg :(BOOL) wait ;
- (void) release__;
- (instancetype) retain__;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key ;
- (id) valueForKey___java_lang_String:(NSString*) key ;
@end
