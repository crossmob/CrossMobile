// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLSessionUploadTask implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_foundation_NSURLResponse.h"
#import "crossmobile_ios_foundation_NSURLSessionUploadTask.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSURLSessionUploadTask$Ext

// (NSURLSessionTask) @property(readonly) int64_t countOfBytesExpectedToReceive;
- (JAVA_LONG) countOfBytesExpectedToReceive__
{
    return [super countOfBytesExpectedToReceive];
}

// (NSURLSessionTask) @property(readonly) int64_t countOfBytesExpectedToSend;
- (JAVA_LONG) countOfBytesExpectedToSend__
{
    return [super countOfBytesExpectedToSend];
}

// (NSURLSessionTask) @property(readonly) int64_t countOfBytesReceived;
- (JAVA_LONG) countOfBytesReceived__
{
    return [super countOfBytesReceived];
}

// (NSURLSessionTask) @property(readonly) int64_t countOfBytesSent;
- (JAVA_LONG) countOfBytesSent__
{
    return [super countOfBytesSent];
}

// (NSURLSessionTask) @property(readonly, copy) NSURLRequest *currentRequest;
- (NSURLRequest*) currentRequest__
{
    NSURLRequest* re$ult = [super currentRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLSessionTask) @property(readonly, copy) NSError *error;
- (NSError*) error__
{
    NSError* re$ult = [super error];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLSessionTask) @property(readonly, copy) NSURLRequest *originalRequest;
- (NSURLRequest*) originalRequest__
{
    NSURLRequest* re$ult = [super originalRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLSessionTask) @property float priority;
- (void) setPriority___float:(float) priority 
{
    [super setPriority:priority];
}

// (NSURLSessionTask) @property float priority;
- (float) priority__
{
    return [super priority];
}

// (NSURLSessionTask) @property(readonly, copy) NSURLResponse *response;
- (NSURLResponse*) response__
{
    NSURLResponse* re$ult = [super response];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLSessionTask) @property(readonly) NSURLSessionTaskState state;
- (int) state__
{
    return [super state];
}

// (NSURLSessionTask) @property(copy) NSString *taskDescription;
- (void) setTaskDescription___java_lang_String:(NSString*) taskDescription 
{
    [super setTaskDescription:(taskDescription == JAVA_NULL ? nil : taskDescription)];
}

// (NSURLSessionTask) @property(copy) NSString *taskDescription;
- (NSString*) taskDescription__
{
    NSString* re$ult = [super taskDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLSessionTask) @property(readonly) NSUInteger taskIdentifier;
- (int) taskIdentifier__
{
    return [super taskIdentifier];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSURLSessionTask) - (void)cancel;
- (void) cancel__
{
    [super cancel];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSURLSessionTask) - (void)resume;
- (void) resume__
{
    [super resume];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSURLSessionTask) - (void)suspend;
- (void) suspend__
{
    [super suspend];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation NSURLSessionUploadTask (cm_crossmobile_ios_foundation_NSURLSessionUploadTask)

@end
