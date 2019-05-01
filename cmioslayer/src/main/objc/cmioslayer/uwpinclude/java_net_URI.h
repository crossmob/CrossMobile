/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

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
