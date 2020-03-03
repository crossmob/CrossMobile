/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_Exception.h"
#import "java_lang_String.h"


// org.xml.sax.SAXException
//----------------------------------------------------------------------------
// For some reason, compiling for the device doesn't like to define this
// class as a category.
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface org_xml_sax_SAXException : java_lang_Exception

- (id) init;
- (instancetype) __init_org_xml_sax_SAXException__;
- (instancetype) __init_org_xml_sax_SAXException___java_lang_String: (java_lang_String*) msg;
- (instancetype) __init_org_xml_sax_SAXException___java_lang_String_java_lang_Throwable: (java_lang_String*) msg: (java_lang_Throwable*) cause;
- (org_xml_sax_SAXException *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause;
- (void) printStackTrace__;

@end
