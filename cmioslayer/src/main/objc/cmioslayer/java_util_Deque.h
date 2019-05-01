#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Queue.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@protocol java_util_Deque <java_util_Queue>
- (void) addFirst___java_lang_Object :(java_lang_Object*)n1;
- (void) addLast___java_lang_Object :(java_lang_Object*)n1;
- (int) offerFirst___java_lang_Object :(java_lang_Object*)n1;
- (int) offerLast___java_lang_Object :(java_lang_Object*)n1;
- (java_lang_Object*) removeFirst__;
- (java_lang_Object*) removeLast__;
- (java_lang_Object*) pollFirst__;
- (java_lang_Object*) pollLast__;
- (java_lang_Object*) getFirst__;
- (java_lang_Object*) getLast__;
- (java_lang_Object*) peekFirst__;
- (java_lang_Object*) peekLast__;
- (int) removeFirstOccurrence___java_lang_Object :(java_lang_Object*)n1;
- (int) removeLastOccurrence___java_lang_Object :(java_lang_Object*)n1;
- (int) add___java_lang_Object :(java_lang_Object*)n1;
- (int) offer___java_lang_Object :(java_lang_Object*)n1;
- (java_lang_Object*) remove__;
- (java_lang_Object*) poll__;
- (java_lang_Object*) element__;
- (java_lang_Object*) peek__;
- (void) push___java_lang_Object :(java_lang_Object*)n1;
- (java_lang_Object*) pop__;
- (int) remove___java_lang_Object :(java_lang_Object*)n1;
- (int) contains___java_lang_Object :(java_lang_Object*)n1;
- (int) size__;
- (java_util_Iterator*) iterator__;
- (java_util_Iterator*) descendingIterator__;

@end

@interface java_util_Deque : java_lang_Object <java_util_Deque>
@end
