/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Object.h"
#import "java_lang_Class.h"
#import "java_lang_String.h"
#include <pthread.h>
#import <objc/runtime.h> // For associative references
#import "java_lang_IllegalArgumentException.h"
#import "java_lang_IllegalMonitorStateException.h"
#import "java_lang_InterruptedException.h"
#import "java_lang_Thread.h"

// java.lang.Object
//----------------------------------------------------------------------------
@implementation NSObject (cat_java_lang_Object)

static char memberKey; // key for associative reference for member variables

- (java_lang_Object_members*)members {
	java_lang_Object_members *members = nil;
	@synchronized(self) {
		members = (java_lang_Object_members *)objc_getAssociatedObject(self, &memberKey);
		if (members == nil) {
			members = [[java_lang_Object_members alloc] init];
			objc_setAssociatedObject(self, &memberKey, members, OBJC_ASSOCIATION_RETAIN);
			[members release];
		}
	}
	return members;
}

- (instancetype) __init_java_lang_Object__
{
    return [self init];
}

- (id) preInitJava
{
    return self;
}

- (java_lang_Class*) getClass__
{
    return [[java_lang_Class alloc] initWithClass:[self class]];
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
	return self == o;
}

- (int) hashCode__
{
	return [self hash];
}

- (java_lang_String*) toString__
{
	return_XMLVM(description)
}

/*****************************************
 * synchronized implementation
 ****************************************/

- (void) syncLock
{
	java_lang_Object_members* members = [self members];

	[[members syncLock] lock];
	@synchronized (self) {
		[members setOwningThread:(NSInteger)pthread_self()];
	}
}

- (void) syncUnlock
{
	java_lang_Object_members* members = [self members];

	@synchronized (self) {
		[members setOwningThread:(NSInteger)-1];
	}
	[[members syncLock] unlock];
}

/**
 * @return true if the lock was acquired or false if the thread already had the lock
 */
- (BOOL) acquireLockRecursive
{
	java_lang_Object_members* members = [self members];

	BOOL acquireLock = FALSE;
	@synchronized (self) {
		acquireLock = ((NSInteger)pthread_self()) != [members owningThread];
	}

	if (acquireLock) {
		[self syncLock];
	}
	// This would be better implemented with an increment method
	[members setRecursiveLocks:[members recursiveLocks] + 1];
	//NSLog(@"---    Locked level %i, Hash (mostly unique): %i", [members recursiveLocks], [[members syncLock] hash]);

	return acquireLock;
}

- (void) releaseLockRecursive
{
	java_lang_Object_members* members = [self members];

	//NSLog(@"--- Unlocking level %i, Hash (mostly unique): %i", [members recursiveLocks], [[members syncLock] hash]);
	// This would be better implemented with an increment method, but use -1
	[members setRecursiveLocks:[members recursiveLocks] - 1];
	//if (acquireLock) {
	if ([members recursiveLocks] == 0) {
		[self syncUnlock];
	}
}

/*****************************************
 * wait / notify implementation
 ****************************************/

/**
 * Add the thread id to the "wait" list & return it
 */
- (NSInteger) enqueueThreadId
{
	NSInteger threadId = (NSInteger)pthread_self();
	NSNumber* threadIdNumber = [[NSNumber alloc] initWithInteger:threadId];
	[[[self members] threads] addObject:threadIdNumber];
	[threadIdNumber release];
	return threadId;
}

/**
 * Verify that a synchronized lock is obtained. If it is not, throw an exception.
 */
- (void) checkSynchronized
{
	java_lang_Object_members* members = [self members];

	BOOL ownsObjectMonitor = FALSE;
	@synchronized (self) {
		ownsObjectMonitor = ((NSInteger)pthread_self()) == [members owningThread];
	}
	if (!ownsObjectMonitor) {
		java_lang_IllegalMonitorStateException* ex = [[java_lang_IllegalMonitorStateException alloc] init];
		[ex __init_java_lang_IllegalMonitorStateException___java_lang_String:[NSMutableString stringWithString:@"the current thread is not the owner of the object's monitor"]];
		@throw ex;
	}
}

/**
 * Remove a thread from the list of threads to be notified. This is only required for wait(long) when a timeout occurs or a thread is interrupted.
 * Since the index does not remain consistent, we must find the thread by id.
 */
- (BOOL) removeThreadNotification:(NSInteger) threadId
{
	java_lang_Object_members* members = [self members];

	int i = 0;
	BOOL found = false;
	while (!found && i < [[members threads] count]) {
		if ([[[members threads] objectAtIndex:i] integerValue] == threadId) {
			found = true;

			[[members threads] removeObjectAtIndex:i];
			if (i <= [members notifyAllMaxIndex]) {
				[members incrementNotifyAllMaxIndex:-1];
			}
		} else {
			i++;
		}
	}
	return found;
}

+ (int) fetchRand:(int) min:(int) max
{
	return (arc4random() % (max - min + 1)) + min;
}

/**
 * Release the current thread's lock and notify the next thread, if any.
 */
- (void) unlockAndNotifyNext
{
	java_lang_Object_members* members = [self members];

	if ([members notifyAllMaxIndex] >= 0) {

		// This can be any random value from 0 to notifyAllMaxIndex inclusive
		int indexToUnlock = [java_lang_Object fetchRand: 0 : [members notifyAllMaxIndex]];

		// Find the next thread to unlock
		NSInteger nextThreadToUnlock = [[[members threads] objectAtIndex:indexToUnlock] integerValue];

		// Remove the thread from the list of threads to be notified
		[[members threads] removeObjectAtIndex:indexToUnlock];
		[members incrementNotifyAllMaxIndex:-1];

		//NSLog(@"(ALL) Unlocking %i", nextThreadToUnlock);
		[[members notifyLock] unlockWithCondition:nextThreadToUnlock];
	} else {
		[[members notifyLock] unlockWithCondition:-1];
	}
}

- (void) unlockAndNotifySingle
{
	java_lang_Object_members* members = [self members];

	// If called after a notifyAll(), but before all have been notified, notify() should only
	// notify a thread that would not otherwise be notified by the previous notifyAll().
	if ([[members threads] count] > [members notifyAllMaxIndex] + 1) {
		// This can be any random value from notifyAllMaxIndex + 1 to threads.size() exclusive
		int indexToUnlock = [java_lang_Object fetchRand: [members notifyAllMaxIndex] + 1: [[members threads] count] - 1];

		// Find the next thread to unlock
		NSInteger nextThreadToUnlock = [[[members threads] objectAtIndex:indexToUnlock] integerValue];

		// Remove the thread from the list of threads to be notified
		[[members threads] removeObjectAtIndex:indexToUnlock];

		// There is no need to decrement notifyAllMaxIndex since the notified index is greater than the max for notifyAll

		//NSLog(@"(ONE) Unlocking %i", nextThreadToUnlock);
		[[members notifyLock] unlockWithCondition:nextThreadToUnlock];
	} else {
		[[members notifyLock] unlockWithCondition:-1];
	}
}

/**
 * @return the number of recursive synchronized locks on this object when
 *         wait() or wait(long) was called. If the thread was already
 *         interrupted, this value will be negated.
 */
- (int) releaseLockBeforeWait
{
	java_lang_Object_members* members = [self members];

	[[java_lang_Thread currentThread__] setWaitingObject: self];

	int numLocks = [members recursiveLocks];
	[members setRecursiveLocks:0];

	// Clear the interrupted status and determine if the interrupted status was set to TRUE before being cleared
	BOOL alreadyInterrupted = [java_lang_Thread interrupted__];

	// If the thread was interrupted entirely before a "wait" was called
	if (alreadyInterrupted) {
		//NSLog(@"Thread was already interrupted before the \"wait\" process began [possibly after \"wait\" was called].");

		// Forego the "wait". An InterruptedException will then be thrown immediately in acquireLockAfterWait
		[[members notifyLock] lockWhenCondition:-1];

		NSInteger threadId = (NSInteger)pthread_self();
		[[members notifyLock] unlockWithCondition:threadId];

		numLocks = -numLocks;
	}

	[self syncUnlock];

	return numLocks;
}

/**
 * @param locked true if notifyLock was locked, else false (such as during a wait(long) timeout)
 * @param numLocks the number of recursive synchronized lock to reacquire after a wait() or wait(long) has awakened
 * @param numLocks
 *            the number of recursive synchronized locks to reacquire after a
 *            wait() or wait(long) has awakened. If this value is negative,
 *            use the absolute value and throw an InterruptedException.
 * @return true if the thread was interrupted and needs to throw an interrupted exception, else false
 */
- (BOOL) acquireLockAfterWait:(BOOL)locked:(int)numLocks
{
	BOOL wasInterrupted = FALSE;

	java_lang_Object_members* members = [self members];

	// If it gained the lock, release the lock before synchronization to
	// avoid a possible deadlock where this thread has the notifyLock
	// and wants synchronization, but a notify thread has vice versa.
	// It will be regained below.
	if (locked) {
		[[members notifyLock] unlockWithCondition:-1];
	}

	[self syncLock];

	[[java_lang_Thread currentThread__] setWaitingObject: NULL];

	// If the thread has been interrupted, clear the interrupted status & throw an exception
	if ([java_lang_Thread interrupted__]) {
		wasInterrupted = TRUE;
	}

	if (numLocks < 0) {
		numLocks = -numLocks;
		wasInterrupted = TRUE;
	}

	[members setRecursiveLocks:numLocks];

	if (locked) {
		[[members notifyLock] lockWhenCondition:-1];
	}

	return wasInterrupted;
}

/**
 * Once everything is unlocked and remaining notifications have been handled,
 * this may be called to throw an InterruptedException.
 */
- (void) throwInterruptedException {
	java_lang_InterruptedException* ex = [[java_lang_InterruptedException alloc] init];
	[ex __init_java_lang_InterruptedException__];
	@throw ex;
}

- (void) wait__
{
	[self checkSynchronized];

	java_lang_Object_members* members = [self members];

	NSInteger threadId = [self enqueueThreadId];

	int numLocks = [self releaseLockBeforeWait];
	[[members notifyLock] lockWhenCondition:threadId];
	BOOL wasInterrupted = [self acquireLockAfterWait:TRUE:numLocks];

	[self unlockAndNotifyNext];

	if (wasInterrupted) {
		[self throwInterruptedException];
	}
}

- (void) wait___long_int: (JAVA_LONG)timeout :(int) nanos
{
	//NSLog(@"Waiting %i", timeout);
	if (timeout < 0L) {
		java_lang_IllegalArgumentException* ex = [[java_lang_IllegalArgumentException alloc] init];
		[ex __init_java_lang_IllegalArgumentException___java_lang_String:[NSMutableString stringWithString:@"the value of timeout is negative"]];
		@throw ex;
	} else if (timeout == 0L) {
		[self wait__];
	} else {

		[self checkSynchronized];

		java_lang_Object_members* members = [self members];

		NSDate* date = [NSDate dateWithTimeIntervalSinceNow:(timeout / 1000.0 + nanos / 1000000000.0)];

		NSInteger threadId = [self enqueueThreadId];

		//NSLog(@"Locking before date on condition %i", threadId);

		int numLocks = [self releaseLockBeforeWait];
		BOOL locked = [[members notifyLock] lockWhenCondition:threadId beforeDate:date];
		BOOL wasInterrupted = [self acquireLockAfterWait:locked:numLocks];
/*
		if (locked) {
			NSLog(@"Timed out? false");
		} else {
			NSLog(@"Timed out? true");
		}
*/
		// If it timed out
		if (!locked) {
			// Remove the thread from the list of threads to be notified
			[self removeThreadNotification:threadId];

			// There is a chance that another thread tried to notify this one
			// after it timed out and before "acquireLockAfterWait" acquired
			// the lock. The following will check if that occurred so that
			// notify doesn't break. I.e. the NSConditionLock has a condition
			// for this thread, so NO other thread would be notified going forward
			// if this wasn't handled.

			NSDate* smallTimeout = [NSDate dateWithTimeIntervalSinceNow:0.0];
			locked = [[members notifyLock] lockWhenCondition:threadId beforeDate:smallTimeout];
			if (locked) {
				// Another thread did try to notify this thread
				// after this thread already timed out
				//NSLog(@"Tardy notification handled on thread %i", threadId);
			} else {
				// Lock without a condition
				[[members notifyLock] lockWhenCondition:-1];
			}
		}

		[self unlockAndNotifyNext];

		if (wasInterrupted) {
			[self throwInterruptedException];
		}
	}
}

- (void) wait___long: (JAVA_LONG)timeout
{
    [self wait___long_int:timeout :0];
}


- (void) notify__
{
	[self checkSynchronized];

	java_lang_Object_members* members = [self members];

	[[members notifyLock] lockWhenCondition:-1];
	[self unlockAndNotifySingle];
}

- (void) notifyAll__
{
	[self checkSynchronized];

	java_lang_Object_members* members = [self members];

	[[members notifyLock] lockWhenCondition:-1];
	// Any thread waiting to be notified can now be notified, but NOT any threads that are waiting after this notification, even if before the notifications complete.
	[members setNotifyAllMaxIndex:[[members threads] count] - 1];
	[self unlockAndNotifyNext];
}

/**
 * Notify a specific waiting thread immediately after marking the thread as interrupted.
 * This is called from java_lang_Thread to interrupt a thread that is definitely waiting on this object.
 * This is only called while synchronized on the java_lang_Thread.
 */
- (void) interruptWait: (NSInteger)threadId {
	// It is safe to synchronize on the waiting object since if the thread is waiting, it released the object's monitor.
	// OR if another thread is sleeping while synchronized on the object, the waiting thread will have to wait for its interruption until the sleep to finishes anyways.
	[self acquireLockRecursive]; // start synchronized block

	// Remove the thread from the list of threads to be notified since it will be interrupted
	BOOL found = [self removeThreadNotification:threadId];
	if (found) {
		java_lang_Object_members* members = [self members];

		[[members notifyLock] lockWhenCondition:-1];
		//NSLog(@"Interrupting thread %i", threadId);
		[[members notifyLock] unlockWithCondition:threadId];
	} else {
		//NSLog(@"Thread is not currently in the waiting list.");
	}

	[self releaseLockRecursive]; // finish synchronized block
}

/****************************************/

@end

@implementation java_lang_Object_members

@synthesize recursiveLocks;
@synthesize owningThread;
@synthesize syncLock;
@synthesize threads;
@synthesize notifyLock;
@synthesize notifyAllMaxIndex;

- (id) init
{
	self = [super init];
	recursiveLocks = 0;
	owningThread = -1;
	syncLock = [[NSLock alloc] init];

	threads = [[NSMutableArray alloc] initWithCapacity:0]; // It is initialized with an initialCapacity of 0 since most Objects won't use wait/notify
	notifyLock = [[NSConditionLock alloc] initWithCondition:-1];
	notifyAllMaxIndex = -1;
	return self;
}

- (void) incrementNotifyAllMaxIndex: (int) increment
{
	notifyAllMaxIndex += increment;
}

- (void) dealloc
{
	[syncLock release];
	[notifyLock release];
	[threads release];
	[super dealloc];
}

@end
