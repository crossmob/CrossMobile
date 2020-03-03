/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_ref_WeakReference.h"

@implementation WeakReferenceCallBack

- (id)initWithWeakReference:(java_lang_ref_WeakReference*) wr 
{
    self = [super init];
    if (self) {
        weakref = wr;
    }
    return self;
}

- (void)dealloc
{
    if (weakref != nil) {
        [weakref clear__];
        weakref = nil;
    }
    [super dealloc];
}

- (java_lang_ref_WeakReference *) get_weakref
{
    return self->weakref;
}

- (void) set_weakref:(java_lang_ref_WeakReference *) weakref
{
    self->weakref = weakref;
}

@end


@implementation java_lang_ref_WeakReference 

- (instancetype) __init_java_lang_ref_WeakReference___java_lang_Object:(java_lang_Object*) ref
{
    callback = nil;
    referent = nil;
    
    if (ref!=JAVA_NULL) {
        referent = ref;
        callback = [[WeakReferenceCallBack alloc] initWithWeakReference:self];
        objc_setAssociatedObject(referent, callback, callback, OBJC_ASSOCIATION_RETAIN);
        [callback release];
    }
    return self;
}

- (void)dealloc
{
    [self clear__];
    [super dealloc];
}
- (java_lang_Object *) get_referent
{
    return self->referent;
}

- (void) set_referent:(java_lang_Object *) referent
{
    self->referent = referent;
}

- (WeakReferenceCallBack *) get_callback
{
    return self->callback;
}

- (void) set_callback:(WeakReferenceCallBack *) callback
{
    self->callback = callback;
}

- (java_lang_Object*) get__ {
    return referent==nil ? JAVA_NULL : [referent retain];
}

- (void) clear__
{
    if (callback!=nil) {
        callback->weakref = nil;
        callback = nil;
    }
    referent = nil;
}

- (int) enqueue__
{
	return NO;
}

- (int) isEnqueued__
{
	return NO;
}

@end
