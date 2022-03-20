/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromInfo;
import static org.crossmobile.bind.system.SystemUtilities.closeR;

/**
 * NSURLConnection class defines an object that is responsible to perform the
 * loading of a URL request.
 */
@CMClass
public class NSURLConnection extends NSObject {

    private static final int BUFFER_SIZE = 1 << 16; // 64k
    //
    private final NSURLRequest request;
    private final NSURLRequest currentRequest;
    private final NSURLConnectionDelegate delegate;
    private boolean hasStarted = false;
    private boolean hasAborted = false;

    /**
     * Request for synchronous data loading for the specified URL.
     *
     * @param <T>      NSURLResponse type
     * @param request  The URL of the data load request.
     * @param response The URL of the response.
     * @param error    The error returned in case of failure, NULL in case of
     *                 success.
     * @return The data of the synchronous loading request.
     */
    @Deprecated
    @CMSelector("+ (NSData *)sendSynchronousRequest:(NSURLRequest *)request \n"
            + "                 returningResponse:(NSURLResponse * _Nullable *)response \n"
            + "                             error:(NSError * _Nullable *)error;")
    public static <T extends NSURLResponse> NSData sendSynchronousRequest(NSURLRequest request, final StrongReference<T> response, final StrongReference<NSError> error) {
        if (error != null)
            error.set(null);
        final NSMutableData data = new NSMutableData(0);
        final StrongReference<Boolean> isOk = new StrongReference<>(Boolean.TRUE);
        NSURLConnection connection = new NSURLConnection(request, new NSURLConnectionDataDelegate() {
            @Override
            public void didFailWithError(NSURLConnection p1, NSError p2) {
                if (error != null)
                    error.set(p2);
                isOk.set(Boolean.FALSE);
            }

            @SuppressWarnings("unchecked")
            @Override
            public void didReceiveResponse(NSURLConnection connection, NSURLResponse resp) {
                if (response != null)
                    response.set((T) resp);
            }

            @Override
            public void didReceiveData(NSURLConnection connection, NSData newdata) {
                data.appendData(newdata);
            }
        });
        Thread thread = connection.startInNewThread();
        try {
            thread.join();
        } catch (InterruptedException ignored) {
        }
        return isOk.get() ? data : null;
    }

    /**
     * Creates and returns a connection object for the specified URL and begins
     * data loading.
     *
     * @param NSURLRequest            The URL of the connection.
     * @param NSURLConnectionDelegate The corresponding delegate for this
     *                                connection.
     * @return The new NSURLConnection object.
     */
    @Deprecated
    @CMSelector("+ (NSURLConnection *)connectionWithRequest:(NSURLRequest *)request delegate:(id)delegate;")
    public static NSURLConnection connectionWithRequest(NSURLRequest NSURLRequest, NSURLConnectionDelegate NSURLConnectionDelegate) {
        return new NSURLConnection(NSURLRequest, NSURLConnectionDelegate, true);
    }

    /**
     * Constructs a new connection object for the specified URL and begins data
     * loading.
     *
     * @param request  The URL of the connection.
     * @param delegate The corresponding delegate for this connection.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithRequest:(NSURLRequest *)request \n"
            + "                       delegate:(id)delegate;")
    public NSURLConnection(NSURLRequest request, NSURLConnectionDelegate delegate) {
        this.request = request == null ? null : request.copy();
        this.currentRequest = request;
        this.delegate = delegate;
    }

    /**
     * Constructs a new NSURLConnection object and with the option to start
     * loading data from the specified URL.
     *
     * @param request          The URL to load.
     * @param delegate         The delegate object of the connection
     * @param startImmediately TRUE then loading data starts immediately.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @Deprecated
    @CMConstructor("- (instancetype)initWithRequest:(NSURLRequest *)request \n"
            + "                       delegate:(id)delegate \n"
            + "               startImmediately:(BOOL)startImmediately;")
    public NSURLConnection(NSURLRequest request, NSURLConnectionDelegate delegate, boolean startImmediately) {
        this(request, delegate);
        if (startImmediately)
            start();
    }

    /**
     * Returns a copy of this connection request.
     *
     * @return A copy of this connection request.
     */
    @CMGetter("@property(readonly, copy) NSURLRequest *originalRequest;")
    public NSURLRequest originalRequest() {
        return request;
    }

    /**
     * Returns the current value of the request for this connection.
     *
     * @return The current value of the request for this connection
     */
    @CMGetter("@property(readonly, copy) NSURLRequest *currentRequest;")
    public NSURLRequest currentRequest() {
        return currentRequest;
    }

    /**
     * Starts loading data for this connection.
     */
    @CMSelector("- (void)start;")
    public void start() {
        startInNewThread();
    }

    /**
     * Cancels the asynchronous load of a request.
     */
    @CMSelector("- (void)cancel;")
    public void cancel() {
        hasAborted = true;
    }

    private Thread startInNewThread() {
        Thread proc = new Thread(() -> {
            if (hasStarted)
                return;
            hasStarted = true;
            if (request == null || request.URL() == null || request.URL().absoluteString().isEmpty()) {
                if (delegate != null)
                    delegate.didFailWithError(NSURLConnection.this, error(-1, "Empty URL"));
                return;
            }

            HttpURLConnection connection = null;
            InputStream in = null;
            OutputStream out = null;
            NSURLConnectionDataDelegate ccdelegate = (delegate != null && (delegate instanceof NSURLConnectionDataDelegate)) ? (NSURLConnectionDataDelegate) delegate : null;
            try {
                // Create connection
                connection = (HttpURLConnection) new URL(request.URL().absoluteString()).openConnection();
                int timeout = (int) (request.timeoutInterval() * 1000);
                connection.setReadTimeout(timeout);
                connection.setConnectTimeout(timeout);

                if (request instanceof NSMutableURLRequest) {
                    NSMutableURLRequest req_m = ((NSMutableURLRequest) request);
                    if (req_m.httpMethod != null)
                        connection.setRequestMethod(req_m.httpMethod);

                    // Set request properties
                    if (req_m.header != null)
                        for (String key : req_m.header.keySet())
                            connection.setRequestProperty(key, req_m.header.get(key));

                    //Set Post, if available
                    if (req_m.body != null && req_m.body.data.length > 0) {
                        connection.setDoOutput(true);
                        out = new BufferedOutputStream(connection.getOutputStream());
                        if (req_m.HTTPBody() != null && req_m.HTTPBody().length() > 0)
                            out.write(req_m.HTTPBody().data);
                        closeR(out);
                        out = null;
                    }
                }

                // Send headers to delegate
                if (ccdelegate != null)
                    ccdelegate.didReceiveResponse(NSURLConnection.this, new NSHTTPURLResponse(request.URL(), connection.getContentType(), connection.getContentLength(), connection.getResponseCode(), connection.getHeaderFields()));

                // Start downloading data
                in = connection.getInputStream();
                byte[] buffer = new byte[BUFFER_SIZE];
                int gotsize;
                while ((gotsize = readDataChunk(in, buffer)) > 0) {
                    if (ccdelegate != null)
                        ccdelegate.didReceiveData(NSURLConnection.this, NSData.dataWithBytes(buffer, gotsize));
                    if (hasAborted)
                        break;
                }

                //Finish download
                if (ccdelegate != null)
                    ccdelegate.didFinishLoading(NSURLConnection.this);
            } catch (Exception e) {
                if (delegate != null) {
                    int result = -1;
                    if (connection != null)
                        try {
                            result = connection.getResponseCode();
                        } catch (Exception ignored) {
                        }
                    delegate.didFailWithError(NSURLConnection.this, error(result, e.toString()));
                }
            } finally {
                closeR(in);
                closeR(out);
                if (connection != null)
                    connection.disconnect();
            }
        });
        proc.start();
        return proc;
    }

    private int readDataChunk(InputStream in, byte[] buffer) throws IOException {
        int gotBytes;
        int location = 0;
        int fullGauge = buffer.length * 9 / 10;
        while (location < fullGauge && (gotBytes = in.read(buffer, location, buffer.length - location)) >= 0)
            location += gotBytes;
        return location == 0 ? -1 : location;
    }

    private static NSError error(int errorCode, String description) {
        return NSError.errorWithDomain(NSError.Domain.NSURL, errorCode < 0 ? NSError.ErrorCode.BadURL : NSError.ErrorCode.BadServerResponse, errorFromInfo(description + " (" + errorCode + ")"));
    }
}
