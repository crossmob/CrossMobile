// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLConnectionDataDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURLConnection;
@class crossmobile_ios_foundation_NSURLResponse;

@protocol crossmobile_ios_foundation_NSURLConnectionDataDelegate
- (void) didFailWithError___crossmobile_ios_foundation_NSURLConnection_crossmobile_ios_foundation_NSError:(NSURLConnection*) connection :(NSError*) error ;
- (void) didFinishLoading___crossmobile_ios_foundation_NSURLConnection:(NSURLConnection*) connection ;
- (void) didReceiveData___crossmobile_ios_foundation_NSURLConnection_crossmobile_ios_foundation_NSData:(NSURLConnection*) connection :(NSData*) data ;
- (void) didReceiveResponse___crossmobile_ios_foundation_NSURLConnection_crossmobile_ios_foundation_NSURLResponse:(NSURLConnection*) connection :(NSURLResponse*) response ;
@end
