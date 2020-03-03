/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Observer.h"


// java.util.Observable
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_Observable : java_lang_Object {
	int changed;
	NSMutableArray* obs;
}

- (instancetype) __init_java_util_Observable__;

//Protected methods
- (void) setChanged__; //synchronized
- (void) clearChanged__; //synchronized

//Public methods
- (void) addObserver___java_util_Observer: (java_util_Observer*) o; //synchronized
- (void) deleteObserver___java_util_Observer: (java_util_Observer*) o; //synchronized
- (void) notifyObservers__;
- (void) notifyObservers___java_lang_Object: (java_lang_Object*) arg;
- (void) deleteObservers__; //synchronized
- (int) hasChanged__; //synchronized
- (int) countObservers__; //synchronized

@end
