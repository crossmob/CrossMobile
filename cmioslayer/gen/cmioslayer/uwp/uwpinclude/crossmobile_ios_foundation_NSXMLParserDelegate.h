// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSXMLParserDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSXMLParser;
@class java_lang_String;
@protocol java_util_Map;

CM_EXPORT_CLASS
@protocol crossmobile_ios_foundation_NSXMLParserDelegate
- (void) didEndElement___crossmobile_ios_foundation_NSXMLParser_java_lang_String_java_lang_String_java_lang_String:(NSXMLParser*) parser :(NSString*) elementName :(NSString*) namespaceURI :(NSString*) qName ;
- (void) didEndMappingPrefix___crossmobile_ios_foundation_NSXMLParser_java_lang_String:(NSXMLParser*) parser :(NSString*) prefix ;
- (void) didStartElement___crossmobile_ios_foundation_NSXMLParser_java_lang_String_java_lang_String_java_lang_String_java_util_Map:(NSXMLParser*) parser :(NSString*) elementName :(NSString*) namespaceURI :(NSString*) qName :(NSDictionary*) attributeDict ;
- (void) didStartMappingPrefix___crossmobile_ios_foundation_NSXMLParser_java_lang_String_java_lang_String:(NSXMLParser*) parser :(NSString*) prefix :(NSString*) namespaceURI ;
- (void) foundCDATA___crossmobile_ios_foundation_NSXMLParser_crossmobile_ios_foundation_NSData:(NSXMLParser*) parser :(NSData*) CDATABlock ;
- (void) foundCharacters___crossmobile_ios_foundation_NSXMLParser_java_lang_String:(NSXMLParser*) parser :(NSString*) string ;
@end
