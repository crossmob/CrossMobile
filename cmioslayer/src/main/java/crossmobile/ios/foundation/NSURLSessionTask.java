/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

@CMClass
public class NSURLSessionTask extends NSObject {

    private int state;
    private float priority;
    private long countOfBytesExpectedToReceive;
    private long countOfBytesReceived;
    private long countOfBytesExpectedToSend;
    private long countOfBytesSent;
    private NSURLRequest currentRequest;
    private NSURLRequest originalRequest;
    private NSURLResponse response;
    private String taskDescription;
    private int taskIdentifier;
    private NSError error;

    @CMSelector("- (void)cancel;")
    public void cancel() {

    }

    @CMSelector("- (void)resume;")
    public void resume() {

    }

    @CMSelector("- (void)suspend;")
    public void suspend() {

    }

    @CMGetter("@property(readonly) NSURLSessionTaskState state;")
    public int state() {
        return state;
    }

    @CMGetter("@property float priority;")
    public float priority() {
        return priority;
    }

    @CMSetter("@property float priority;")
    public void setPriority(float priority) {
        this.priority = priority;
    }

    @CMGetter("@property(readonly) int64_t countOfBytesExpectedToReceive;")
    public long countOfBytesExpectedToReceive() {
        return countOfBytesExpectedToReceive;
    }

    @CMGetter("@property(readonly) int64_t countOfBytesReceived;")
    public long countOfBytesReceived() {
        return countOfBytesReceived;
    }

    @CMGetter("@property(readonly) int64_t countOfBytesExpectedToSend;")
    public long countOfBytesExpectedToSend() {
        return countOfBytesExpectedToSend;
    }

    @CMGetter("@property(readonly) int64_t countOfBytesSent;")
    public long countOfBytesSent() {
        return countOfBytesSent;
    }

    @CMGetter("@property(readonly, copy) NSURLRequest *currentRequest;")
    public NSURLRequest currentRequest() {
        return currentRequest;
    }

    @CMGetter("@property(readonly, copy) NSURLRequest *originalRequest;")
    public NSURLRequest originalRequest() {
        return originalRequest;
    }

    @CMGetter("@property(readonly, copy) NSURLResponse *response;")
    public NSURLResponse response() {
        return response;
    }

    @CMGetter("@property(copy) NSString *taskDescription;")
    public String taskDescription() {
        return taskDescription;
    }

    @CMSetter("@property(copy) NSString *taskDescription;")
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @CMGetter("@property(readonly) NSUInteger taskIdentifier;")
    public int taskIdentifier() {
        return taskIdentifier;
    }

    @CMGetter("@property(readonly, copy) NSError *error;")
    public NSError error() {
        return error;
    }
}
