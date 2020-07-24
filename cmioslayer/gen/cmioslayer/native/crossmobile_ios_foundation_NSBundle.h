// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_NSBundle definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;

@interface crossmobile_ios_foundation_NSBundle$Ext : NSBundle
@end

#define crossmobile_ios_foundation_NSBundle NSBundle
@interface NSBundle (cm_crossmobile_ios_foundation_NSBundle)
+ (instancetype) bundleWithPath___java_lang_String:(NSString*) path ;
+ (NSBundle*) mainBundle__;
- (NSString*) bundlePath__;
- (NSURL*) URLForResource___java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext ;
- (NSURL*) URLForResource___java_lang_String_java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext :(NSString*) subpath ;
- (NSString*) localizedStringForKey___java_lang_String_java_lang_String_java_lang_String:(NSString*) key :(NSString*) value :(NSString*) tableName ;
- (NSString*) pathForResource___java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext ;
- (NSString*) pathForResource___java_lang_String_java_lang_String_java_lang_String:(NSString*) name :(NSString*) ext :(NSString*) subpath ;
@end
