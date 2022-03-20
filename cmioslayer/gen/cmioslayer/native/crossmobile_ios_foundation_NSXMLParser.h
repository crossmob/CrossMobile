// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSXMLParser definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@protocol crossmobile_ios_foundation_NSXMLParserDelegate;

@interface crossmobile_ios_foundation_NSXMLParser$Ext : NSXMLParser
@end

#define crossmobile_ios_foundation_NSXMLParser NSXMLParser
@interface NSXMLParser (cm_crossmobile_ios_foundation_NSXMLParser)
- (instancetype) __init_crossmobile_ios_foundation_NSXMLParser___crossmobile_ios_foundation_NSData:(NSData*) data ;
- (void) setDelegate___crossmobile_ios_foundation_NSXMLParserDelegate:(id<NSXMLParserDelegate>) delegate ;
- (NSError*) parserError__;
- (void) setShouldProcessNamespaces___boolean:(BOOL) shouldProcessNamespaces ;
- (BOOL) shouldProcessNamespaces__;
- (void) setShouldReportNamespacePrefixes___boolean:(BOOL) shouldReportNamespacePrefixes ;
- (BOOL) shouldReportNamespacePrefixes__;
- (BOOL) parse__;
@end
