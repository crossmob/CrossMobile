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
