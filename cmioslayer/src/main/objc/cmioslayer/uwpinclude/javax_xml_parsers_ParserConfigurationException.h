/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_Exception.h"
#import "java_lang_String.h"


// javax.xml.parsers.ParserConfigurationException
//----------------------------------------------------------------------------
// For some reason, compiling for the device doesn't like to define this
// class as a category.
CM_EXPORT_CLASS
@interface javax_xml_parsers_ParserConfigurationException : java_lang_Exception

- (id) init;
- (instancetype) __init_javax_xml_parsers_ParserConfigurationException__;
- (instancetype) __init_javax_xml_parsers_ParserConfigurationException___java_lang_String: (java_lang_String*) msg;
- (instancetype) __init_javax_xml_parsers_ParserConfigurationException___java_lang_String_java_lang_Throwable: (java_lang_String*) msg: (java_lang_Throwable*) cause;
- (javax_xml_parsers_ParserConfigurationException *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause;
- (void) printStackTrace__;

@end
