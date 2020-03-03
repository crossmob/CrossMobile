/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "javax_xml_xpath_XPathExpressionException.h"

// javax.xml.xpath.XPathExpressionException
//----------------------------------------------------------------------------
@implementation javax_xml_xpath_XPathExpressionException

- (id) init
{
    return [self initWithName: @"javax_xml_xpath_XPathExpressionException" reason: nil userInfo: nil];
}

- (instancetype) __init_javax_xml_xpath_XPathExpressionException__
{
    return [self init];
}

- (instancetype) __init_javax_xml_xpath_XPathExpressionException___java_lang_String: (java_lang_String*) msg
{
    return [self init];
}

- (instancetype) __init_javax_xml_xpath_XPathExpressionException___java_lang_String_java_lang_Throwable: (java_lang_String*) msg: (java_lang_Throwable*) cause
{
    return [self init];
}

- (javax_xml_xpath_XPathExpressionException *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause
{
	[self retain];
	return self;
}

- (void) printStackTrace__
{
}

@end
