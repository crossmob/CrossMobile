// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_social_SLRequestHandler definition

#import "xmlvm.h"
#import <Social/Social.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSHTTPURLResponse;

@protocol crossmobile_ios_social_SLRequestHandler
- (void) invoke___crossmobile_ios_foundation_NSData_crossmobile_ios_foundation_NSHTTPURLResponse_crossmobile_ios_foundation_NSError:(NSData*) responseData :(NSHTTPURLResponse*) urlResponse :(NSError*) error ;
@end
