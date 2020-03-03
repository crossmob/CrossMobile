/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Class.h"
#import "java_lang_reflect_Constructor.h"


// java.lang.reflect.Constructor
//----------------------------------------------------------------------------
@implementation java_lang_reflect_Constructor;

- (id) initWithClass: (java_lang_Class*) c andSignature: (XMLVMArray*) s andMangledConstructorName: (NSMutableString*) n
{
	self = [super init];
	self->clazz = [c retain];
	self->signature = [s retain];
	self->mangledConstructorName = [n retain];
	return self;
}

- (void) dealloc
{
	[self->clazz release];
	[self->signature release];
	[self->mangledConstructorName release];
	[super dealloc];
}

- (java_lang_Object*) newInstance___java_lang_Object_ARRAYTYPE: (XMLVMArray*) params
{
	int i;
	
	NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
	NSObject* obj = (NSObject*) class_createInstance(clazz->clazz, class_getInstanceSize(clazz->clazz));
	[obj init];
    [obj preInitJava];
	// Call constructor
	SEL sel = NSSelectorFromString(mangledConstructorName);
	NSMethodSignature * sig = [clazz->clazz instanceMethodSignatureForSelector:sel];
	NSInvocation* inv = [NSInvocation invocationWithMethodSignature: sig];
	[inv setTarget: obj];
	[inv setSelector: sel];
	
	for (i = 0; i < [params count]; i++) {
		java_lang_Object* obj = params->array.o[i];
		// The +2 is to offset self and _cmd
		[inv setArgument:&obj atIndex:i + 2];
	}
	
	[inv invoke];
	[pool release];
	return obj;
}

@end
