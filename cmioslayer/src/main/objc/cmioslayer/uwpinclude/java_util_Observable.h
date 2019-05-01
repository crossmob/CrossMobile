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
#import "java_util_Observer.h"


// java.util.Observable
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
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
