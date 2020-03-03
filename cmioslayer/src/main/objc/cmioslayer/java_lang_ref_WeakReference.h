/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

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
