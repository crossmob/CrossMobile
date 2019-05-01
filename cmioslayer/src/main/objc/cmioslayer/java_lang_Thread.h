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
#import "java_lang_Runnable.h"
#import "java_lang_String.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Thread : java_lang_Object<java_lang_Runnable> {

id<java_lang_Runnable> runnable;
NSThread*              thread;
pthread_t              m_pthread_t; // Used solely to get the thread id
BOOL interrupted;
java_lang_Object* waitingObj; // the object the thread is synchronized & waiting on (this is used to interrupt a wait)
BOOL alive;

}

+ (void) initialize;
- (id) init;
- (void) dealloc;
- (instancetype) __init_java_lang_Thread__;
- (instancetype) __init_java_lang_Thread___java_lang_Runnable: (id<java_lang_Runnable>) r;
- (void) threadCallback: (id) arg;
- (void) run__;
- (void) start__;
- (BOOL) isAlive__;
- (void) join__;
- (void) join___long:(JAVA_LONG)millis;
+ (void) sleep___long: (JAVA_LONG) millis;
+ (java_lang_Thread*) currentThread__;
- (void) setWaitingObject: (java_lang_Object*) obj;
- (void) interrupt__;
+ (BOOL) interrupted__;
- (BOOL) isInterrupted__;
- (java_lang_String*) getName__;
- (void) setName___java_lang_String:(java_lang_String*)name;

@end
