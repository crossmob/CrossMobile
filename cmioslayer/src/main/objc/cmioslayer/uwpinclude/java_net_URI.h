/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

/**
 * 
 *
 */

#import "java_lang_Object.h"
#import "java_lang_String.h"

CM_EXPORT_CLASS
@interface NSURLRef : NSObject {

@private NSURL *url;
	
}
- (id) init;

- (instancetype) __init_java_net_URI___java_lang_String: (java_lang_String*) url;

- (id) copyWithZone: (NSZone *) zone;

- (void) dealloc;

- (void) setRef: (NSURL *) url;

- (NSMethodSignature *) methodSignatureForSelector:(SEL)aSelector;
- (void) forwardInvocation:(NSInvocation *)anInvocation;

@end

#define java_net_URI NSURL

@interface NSURL (cat_java_net_URI)

- (id) init;

+ (java_net_URI*) create___java_lang_String: (java_lang_String*) str;

- (java_lang_String*) getRawPath__;
- (java_lang_String*) getPath__;

@end
