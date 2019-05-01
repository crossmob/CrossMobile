/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock3;

import java.util.List;

@CMClass
public class NSURLSession extends NSObject {

    public final static String DownloadTaskResumeData = "NSURLSessionDownloadTaskResumeData";
    public final static String NSURLErrorBackgroundTaskCancelledReasonKey = "NSURLErrorBackgroundTaskCancelledReasonKey";
    public final static long NSURLSessionTransferSizeUnknown = -1;


    private NSURLSessionConfiguration configuration;
    private NSURLSessionDelegate delegate;
    private String sessionDescription;
    private NSURLSession sharedSession;
    private NSOperationQueue delegateQueue;

    NSURLSession() {
    }

    @CMSelector("+ (NSURLSession *)sessionWithConfiguration:(NSURLSessionConfiguration *)configuration;")
    public static NSURLSession sessionWithConfiguration(NSURLSessionConfiguration configuration) {
        return new NSURLSession();
    }

    @CMSelector("+ (NSURLSession *)sessionWithConfiguration:(NSURLSessionConfiguration *)configuration\n" +
            "    delegate:(id<NSURLSessionDelegate>)delegate\n" +
            "    delegateQueue:(NSOperationQueue *)queue;")
    public static NSURLSession sessionWithConfiguration(NSURLSessionConfiguration configuration, NSURLSessionDelegate delegate, NSOperationQueue queue) {
        return new NSURLSession();
    }

    @CMGetter(" @property(readonly, copy) NSURLSessionConfiguration *configuration;")
    public NSURLSessionConfiguration configuration() {
        return configuration;
    }

    @CMGetter("@property(readonly, retain) id<NSURLSessionDelegate> delegate;")
    public NSURLSessionDelegate delegate() {
        return delegate;
    }

    @CMGetter("@property(readonly, retain) NSOperationQueue *delegateQueue;")
    public NSOperationQueue delegateQueue() {
        return delegateQueue;
    }

    @CMGetter("@property(copy) NSString *sessionDescription;")
    public String sessionDescription() {
        return sessionDescription;
    }

    @CMSetter("@property(copy) NSString *sessionDescription;")
    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    @CMSelector("- (NSURLSessionDataTask *)dataTaskWithURL:(NSURL *)url;")
    public NSURLSessionDataTask dataTaskWithURL(NSURL url) {
        return null;
    }

    @CMSelector("- (NSURLSessionDataTask *)dataTaskWithURL:(NSURL *)url\n" +
            "    completionHandler:(void (^)(NSData *data, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionDataTask dataTaskWithURL(NSURL url, VoidBlock3<NSData, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionDataTask *)dataTaskWithRequest:(NSURLRequest *)request;")
    public NSURLSessionDataTask dataTaskWithRequest(NSURLRequest request) {
        return null;
    }

    @CMSelector("- (NSURLSessionDataTask *)dataTaskWithRequest:(NSURLRequest *)request\n" +
            "    completionHandler:(void (^)(NSData *data, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionDataTask dataTaskWithRequest(NSURLRequest request, VoidBlock3<NSData, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionDownloadTask *)downloadTaskWithURL:(NSURL *)url;")
    public NSURLSessionDownloadTask downloadTaskWithURL(NSURL url) {
        return null;
    }

    @CMSelector("- (NSURLSessionDownloadTask *)downloadTaskWithURL:(NSURL *)url\n" +
            "    completionHandler:(void (^)(NSURL *location, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionDownloadTask downloadTaskWithURL(NSURL url, VoidBlock3<NSURL, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionDownloadTask *)downloadTaskWithRequest:(NSURLRequest *)request;")
    public NSURLSessionDownloadTask downloadTaskWithRequest(NSURLRequest request) {
        return null;
    }


    @CMSelector("- (NSURLSessionDownloadTask *)downloadTaskWithRequest:(NSURLRequest *)request\n" +
            "    completionHandler:(void (^)(NSURL *location, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionDownloadTask downloadTaskWithRequest(NSURLRequest request, VoidBlock3<NSURL, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionDownloadTask *)downloadTaskWithResumeData:(NSData *)resumeData;")
    public NSURLSessionDownloadTask downloadTaskWithResumeData(NSData resumeData) {
        return null;
    }

    @CMSelector("- (NSURLSessionDownloadTask *)downloadTaskWithResumeData:(NSData *)resumeData\n" +
            "    completionHandler:(void (^)(NSURL *location, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionDownloadTask downloadTaskWithResumeData(NSData resumeData, VoidBlock3<NSURL, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionUploadTask *)uploadTaskWithRequest:(NSURLRequest *)request\n" +
            "    fromData:(NSData *)bodyData;")
    public NSURLSessionUploadTask uploadTaskWithRequest(NSURLRequest request, NSData bodyData) {
        return null;
    }

    @CMSelector("- (NSURLSessionUploadTask *)uploadTaskWithRequest:(NSURLRequest *)request\n" +
            "    fromData:(NSData *)bodyData\n" +
            "    completionHandler:(void (^)(NSData *data, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionUploadTask uploadTaskWithRequest(NSURLRequest request, NSData bodyData, VoidBlock3<NSData, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionUploadTask *)uploadTaskWithRequest:(NSURLRequest *)request\n" +
            "    fromFile:(NSURL *)fileURL;")
    public NSURLSessionUploadTask uploadTaskWithRequest(NSURLRequest request, NSURL fileURL) {
        return null;
    }

    @CMSelector("- (NSURLSessionUploadTask *)uploadTaskWithRequest:(NSURLRequest *)request\n" +
            "    fromFile:(NSURL *)fileURL\n" +
            "    completionHandler:(void (^)(NSData *data, NSURLResponse *response, NSError *error))completionHandler;")
    public NSURLSessionUploadTask uploadTaskWithRequest(NSURLRequest request, NSURL fileURL, VoidBlock3<NSData, NSURLResponse, NSError> completionHandler) {
        return null;
    }

    @CMSelector("- (NSURLSessionUploadTask *)uploadTaskWithStreamedRequest:(NSURLRequest *)request;")
    public NSURLSessionUploadTask uploadTaskWithStreamedRequest(NSURLRequest request) {
        return null;
    }

    @CMSelector("- (NSURLSessionStreamTask *)streamTaskWithHostName:(NSString *)hostname\n" +
            "    port:(NSInteger)port;")
    public NSURLSessionStreamTask streamTaskWithHostName(String hostname, int port) {
        return null;
    }

    //        - (NSURLSessionStreamTask *)streamTaskWithNetService:(NSNetService *)service;
    @CMSelector("- (void)finishTasksAndInvalidate;")
    public void finishTasksAndInvalidate() {

    }

    @CMSelector("- (void)flushWithCompletionHandler:(void (^)(void))completionHandler;")
    public void flushWithCompletionHandler(Runnable completionHandler) {

    }

    @CMSelector("- (void)getTasksWithCompletionHandler:(void (^)(NSArray<NSURLSessionDataTask *> *dataTasks, NSArray<NSURLSessionUploadTask *> *uploadTasks, NSArray<NSURLSessionDownloadTask *> *downloadTasks))completionHandler;")
    public void getTasksWithCompletionHandler(VoidBlock3<List<NSURLSessionDataTask>, List<NSURLSessionUploadTask>, List<NSURLSessionDownloadTask>> completionHandler) {

    }

    @CMSelector("- (void)invalidateAndCancel;")
    public void invalidateAndCancel() {

    }

    @CMSelector("- (void)resetWithCompletionHandler:(void (^)(void))completionHandler;")
    public void resetWithCompletionHandler(Runnable completionHandler) {

    }

    @CMGetter("@property(class, readonly, strong) NSURLSession *sharedSession;")
    public NSURLSession sharedSession() {
        return sharedSession;
    }

    @CMSelector("- (void)getAllTasksWithCompletionHandler:(void (^)(NSArray<__kindof NSURLSessionTask *> *tasks))completionHandler;")
    public void getAllTasksWithCompletionHandler(VoidBlock1<List<NSURLSessionTask>> completionHandler) {

    }
}
