// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_CFType definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"

@interface crossmobile_ios_foundation_CFType : java_lang_Object {
@public void* $reference;
}

- (instancetype) initWithCFType:(CFTypeRef) reference;
@end
