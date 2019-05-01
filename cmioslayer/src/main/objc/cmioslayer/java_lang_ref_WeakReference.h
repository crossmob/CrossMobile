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

#import "xmlvm.h"
#import "java_lang_Object.h"

@class WeakReferenceCallBack;

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_ref_WeakReference : java_lang_Object {
@public
    java_lang_Object * referent;
	WeakReferenceCallBack * callback;
}

- (java_lang_Object *) get_referent;
- (void) set_referent:(java_lang_Object *) referent;
- (WeakReferenceCallBack *) get_callback;
- (void) set_callback:(WeakReferenceCallBack *) callback;
- (instancetype) __init_java_lang_ref_WeakReference___java_lang_Object:(java_lang_Object*) ref;
- (java_lang_Object*) get__;
- (void) clear__;
- (int) enqueue__;
- (int) isEnqueued__;

@end



@interface WeakReferenceCallBack : NSObject {
@public
    java_lang_ref_WeakReference * weakref;
}
- (java_lang_ref_WeakReference *) get_weakref;
- (void) set_weakref:(java_lang_ref_WeakReference *) weakref;
- (id)initWithWeakReference:(java_lang_ref_WeakReference*) wr;
@end
