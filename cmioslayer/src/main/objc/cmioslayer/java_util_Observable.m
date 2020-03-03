/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Observable.h"
#import "java_lang_NullPointerException.h"

// java.util.Observable
//----------------------------------------------------------------------------
@implementation java_util_Observable

- (instancetype) __init_java_util_Observable__ {
	[super __init_java_lang_Object__];

	// Using an NSMutableArray for two reasons:
	// 1) Vector is not yet implemented.
	// 2) To easily make use of native Objects
	//This is not trouble since the only main difference is synchronization,
	//and any time it is referenced is already synchronized on the containing object.
	obs = [[NSMutableArray alloc] init];
    return self;
}

- (void) setChanged__ {
	@synchronized(self) {
		changed = 1; //true
	}
}

- (void) clearChanged__ {
	@synchronized(self) {
		changed = 0; //false
	}
}

- (void) addObserver___java_util_Observer: (java_util_Observer*) o {
	@synchronized(self) {
		if (o == JAVA_NULL) {
			java_lang_NullPointerException* ex = [[java_lang_NullPointerException alloc] init];
			[ex __init_java_lang_NullPointerException__];
			@throw ex;
		}
		if (![obs containsObject: o]) {
			[obs addObject:o];
		}
	}
}

- (void) deleteObserver___java_util_Observer: (java_util_Observer*) o {
	@synchronized(self) {
		NSUInteger i = [obs indexOfObject: o];
		if (i != NSNotFound) {
			[obs removeObjectAtIndex: i];
		}
	}
}

- (void) notifyObservers__ {
	[self notifyObservers___java_lang_Object:JAVA_NULL];
}

- (void) notifyObservers___java_lang_Object: (java_lang_Object*) arg {
	NSMutableArray* arrLocal = [[NSMutableArray alloc] init];
	@synchronized(self) {
		if (changed != 1) {
			return;
		}
		//Copy to a new array so that we don't have to be synchronized while notifying Observers
		for (int i = 0; i < [obs count]; i++) {
			[arrLocal addObject:[obs objectAtIndex:i]];
		}
		[self clearChanged__];
	}

	for (int i = [arrLocal count] - 1; i >= 0; i--) {
		java_util_Observer* observer = (java_util_Observer*)[arrLocal objectAtIndex:i];
		[observer update___java_util_Observable_java_lang_Object:self:arg];
	}

	[arrLocal release];
}

- (void) deleteObservers__ {
	@synchronized(self) {
		[obs removeAllObjects];
	}
}

- (int) hasChanged__ {
	int changedBoolean = 0;
	@synchronized(self) {
		changedBoolean = changed;
	}
	return changedBoolean;
}

- (int) countObservers__ {
	int size = -1;
	@synchronized(self) {
		size = [obs count];
	}
	return size;
}

- (void)dealloc {
	[obs release];
	[super dealloc];
}

@end
