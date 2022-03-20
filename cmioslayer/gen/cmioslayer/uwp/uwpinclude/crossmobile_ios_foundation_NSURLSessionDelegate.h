// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURLSession;

CM_EXPORT_CLASS
@protocol crossmobile_ios_foundation_NSURLSessionDelegate
- (void) didBecomeInvalidWithError___crossmobile_ios_foundation_NSURLSession_crossmobile_ios_foundation_NSError:(NSURLSession*) session :(NSError*) error ;
- (void) didFinishEventsForBackgroundURLSession___crossmobile_ios_foundation_NSURLSession:(NSURLSession*) session ;
@end
