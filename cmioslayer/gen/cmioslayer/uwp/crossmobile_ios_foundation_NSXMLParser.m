// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSXMLParser implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSXMLParser.h"
#import "crossmobile_ios_foundation_NSXMLParserDelegate.h"

@implementation crossmobile_ios_foundation_NSXMLParser$Ext

@end

@implementation NSXMLParser (cm_crossmobile_ios_foundation_NSXMLParser)

// - (instancetype)initWithData:(NSData *)data;
- (instancetype) __init_crossmobile_ios_foundation_NSXMLParser___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    return [self initWithData:(data == JAVA_NULL ? nil : data)];
}

// @property(assign) id<NSXMLParserDelegate> delegate;
- (void) setDelegate___crossmobile_ios_foundation_NSXMLParserDelegate:(id<NSXMLParserDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(readonly, copy) NSError *parserError;
- (NSError*) parserError__
{
    NSError* re$ult = [self parserError];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property BOOL shouldProcessNamespaces;
- (void) setShouldProcessNamespaces___boolean:(BOOL) shouldProcessNamespaces 
{
    [self setShouldProcessNamespaces:shouldProcessNamespaces];
}

// @property BOOL shouldProcessNamespaces;
- (BOOL) shouldProcessNamespaces__
{
    return [self shouldProcessNamespaces];
}

// @property BOOL shouldReportNamespacePrefixes;
- (void) setShouldReportNamespacePrefixes___boolean:(BOOL) shouldReportNamespacePrefixes 
{
    [self setShouldReportNamespacePrefixes:shouldReportNamespacePrefixes];
}

// @property BOOL shouldReportNamespacePrefixes;
- (BOOL) shouldReportNamespacePrefixes__
{
    return [self shouldReportNamespacePrefixes];
}

// - (BOOL)parse;
- (BOOL) parse__
{
    return [self parse];
}

@end
