/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Environment;
import android.webkit.*;
import android.widget.Toast;
import crossmobile.ios.foundation.*;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIWebViewNavigationType;
import crossmobile.ios.webkit.WKBackForwardList;
import crossmobile.ios.webkit.WKBackForwardListItem;
import crossmobile.ios.webkit.WKNavigation;
import crossmobile.ios.webkit.WebKitDrill;
import org.crossmobile.backend.android.AndroidNativeDispatcher.AndroidNativeWidget;
import org.crossmobile.backend.android.web.VideoEnabledWebChromeClient;
import org.crossmobile.backend.android.web.VideoEnabledWebView;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bind.wrapper.HistoryItem;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.robovm.objc.block.VoidBlock2;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

import static android.content.Context.DOWNLOAD_SERVICE;

@CMLib(name = "cmwebkit")
@SuppressWarnings("deprecation")
public class AndroidWebWrapper extends WebWrapper<AndroidWebWrapper.NativeW, AndroidGraphicsContext> {

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            WebView.enableSlowWholeDocumentDraw();
    }

    private static final String JSTAG = "javascript:";

    private boolean isLoading = false;
    private double scale = 1d;
    private double progress;

    public AndroidWebWrapper(UIView parent) {
        super(parent);
    }

    @Override
    public NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public WKNavigation loadRequest(NSURLRequest req) {
        NSMutableURLRequest mreq = (NSMutableURLRequest) ((req instanceof NSMutableURLRequest) ? req : null);
        if (mreq != null)
            getNativeWidget().postUrl(mreq.URL().absoluteString(), mreq.HTTPBody() == null ? null : mreq.HTTPBody().bytes());
        else if (req != null)
            getNativeWidget().loadUrl(req.URL().absoluteString());
        else
            return null;
        isLoading = true;
        return getNavigation(req.URL().absoluteString());
    }

    @Override
    public WKNavigation loadData(String data, String MIMEType, String baseURL) {
        getNativeWidget().loadDataWithBaseURL(baseURL, data, MIMEType, null, null);
        return getNavigation(baseURL);
    }

    @Override
    public WKNavigation goBack() {
        getNativeWidget().goBack();
        WKBackForwardListItem item = getBackForwardList().backItem();
        return item == null ? null : getNavigation(item.URL().absoluteString());
    }

    @Override
    public WKNavigation goForward() {
        getNativeWidget().goForward();
        WKBackForwardListItem item = getBackForwardList().forwardItem();
        return item == null ? null : getNavigation(item.URL().absoluteString());
    }

    @Override
    public void evaluateJavaScript(String script, VoidBlock2<Object, NSError> callback) {
        getNativeWidget().evaluateJavascript(script, v -> {
            if (callback != null)
                callback.invoke(v, null);
        });
    }

    @Override
    public WKNavigation reload() {
        getNativeWidget().reload();
        return getNavigation(getUrl());
    }

    @Override
    public void stopLoading() {
        getNativeWidget().stopLoading();
    }

    @Override
    public double getMagnification() {
        return scale;
    }

    @Override
    public double getProgress() {
        return progress;
    }

    @Override
    public String getTitle() {
        return getNativeWidget().getTitle();
    }

    @Override
    public String getUrl() {
        return getNativeWidget().getUrl();
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    @Override
    public WKBackForwardList getBackForwardList() {
        WebBackForwardList list = getNativeWidget().copyBackForwardList();
        return WebKitDrill.backForwardList(() -> new Iterator<HistoryItem>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return list.getSize() > current;
            }

            @Override
            public HistoryItem next() {
                WebHistoryItem item = list.getItemAtIndex(current);
                current++;
                return new HistoryItem(item.getUrl(), item.getOriginalUrl(), item.getTitle());
            }
        }, list.getCurrentIndex());
    }

    public class NativeW extends VideoEnabledWebView implements AndroidNativeWidget {

        public NativeW() {
            super(MainActivity.current);
            updateSettings(getSettings());
            setWebChromeClient(new VideoEnabledWebChromeClient(MainView.current, this));
            setDownloadListener((String url, String userAgent, String contentDisposition, String mimetype, long contentLength) -> downloadFile(url, mimetype));
            setWebViewClient(new WebViewClient() {

                @Override
                public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && request.isForMainFrame()
                            ? shouldInterceptRequest(request.getUrl().toString())
                            : super.shouldInterceptRequest(view, request);
                }

                @Override
                public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                    return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
                            ? shouldInterceptRequest(url)
                            : super.shouldInterceptRequest(view, url);
                }

                private WebResourceResponse shouldInterceptRequest(String url) {
                    isLoading = true;
                    if (getDelegate() != null)
                        getDelegate().didStartProvisionalNavigation(getWebView(), getNavigation(url));
                    return null;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    if (isLoading) {
                        if (url == null || !url.startsWith(JSTAG)) {
                            if (getDelegate() != null)
                                getDelegate().didCommitNavigation(getWebView(), getNavigation(url));
                        }
                    }
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    if (isLoading && (url == null || !url.startsWith(JSTAG))) {
                        if (getDelegate() != null)
                            getDelegate().didFinishNavigation(getWebView(), getNavigation(url));
                        zoomOut();
                    }
                    isLoading = false;
                }

                @Override
                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    if (request.isForMainFrame() && isLoading) {
                        NSHTTPURLResponse response = new NSHTTPURLResponse(NSURL.URLWithString(request.getUrl().toString()), errorResponse.getStatusCode(), "", errorResponse.getResponseHeaders());
                        if (!acceptsResponse(response)) {
                            Native.lifecycle().postOnEventThread(() -> getNativeWidget().stopLoading());
                            onReceivedError(errorResponse.getStatusCode(), request.getUrl().toString());
                        }
                    }
                }

                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    onReceivedError(error.getPrimaryError(), error.getUrl());
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
                        onReceivedError(errorCode, failingUrl);
                }

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && request.isForMainFrame())
                        onReceivedError(error.getErrorCode(), request.getUrl().toString());
                }

                private void onReceivedError(int errorCode, String failingUrl) {
                    NSError error = new NSError("NSURLErrorDomain", errorCode, null);
                    if (getDelegate() != null)
                        getDelegate().didFailProvisionalNavigation(getWebView(), getNavigation(failingUrl), error);
                    isLoading = false;
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    isLoading = true;
                    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && request.isForMainFrame()
                            ? shouldOverrideUrlLoading(request.getUrl().toString())
                            : super.shouldOverrideUrlLoading(view, request);
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return Build.VERSION.SDK_INT < Build.VERSION_CODES.N
                            ? shouldOverrideUrlLoading(url)
                            : super.shouldOverrideUrlLoading(view, url);
                }

                private boolean shouldOverrideUrlLoading(String url) {
                    boolean accepted = acceptsRequest(NSURLRequest.requestWithURL(NSURL.URLWithString(SystemUtilities.fixURI(url))), UIWebViewNavigationType.LinkClicked);
                    if (accepted && getDelegate() != null && isLoading)
                        getDelegate().didReceiveServerRedirectForProvisionalNavigation(getWebView(), getNavigation(url));
                    return !accepted;
                }

                @Override
                public void onScaleChanged(WebView view, float oldScale, float newScale) {
                    AndroidWebWrapper.this.scale = newScale;
                }

                @Override
                public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                    if (getDelegate() != null)
                        getDelegate().webContentProcessDidTerminate(getWebView());
                    return super.onRenderProcessGone(view, detail);
                }
            });
        }

        private void downloadFile(String url, String mime) {
            AndroidPermissions.current().requestPermissions(notGranted -> {
                if (!notGranted.isEmpty()) {
                    Toast.makeText(MainActivity.current, "No permission given to write to external storage", 2).show();
                    return;
                }

                Toast.makeText(MainActivity.current, "Background download started for external file", 2).show();
                String filename = AbstractFileBridge.getFileFromURL(url);

                DownloadManager dm = (DownloadManager) MainActivity.current.getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(url));
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
                request.setTitle(filename);
                final AtomicLong downloadId = new AtomicLong(0);

                MainActivity.current.registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        if (!DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction()))
                            return;
                        MainActivity.current.unregisterReceiver(this);
                        Cursor c = dm.query(new DownloadManager.Query().setFilterById(downloadId.get()));
                        if (!c.moveToFirst())
                            return;
                        int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                        if (status == DownloadManager.STATUS_SUCCESSFUL) {
                            try {
                                Uri uri = dm.getUriForDownloadedFile(downloadId.get());
                                MainActivity.current.getStateListener().launch(null, new Intent().setAction(android.content.Intent.ACTION_VIEW)
                                        .setDataAndType(uri, mime)
                                        .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION));
                            } catch (Exception ex) {
                                Toast.makeText(MainActivity.current, "Unable to display external file. It can still be found as Downloaded content", 2).show();
                            }
                        } else if (status == DownloadManager.STATUS_FAILED) {
                            dm.remove(downloadId.get());
                            Toast.makeText(MainActivity.current, "Unable to download external file", 2).show();
                        } else
                            Toast.makeText(MainActivity.current, "Unable to download external file (status " + status + ")", 2).show();
                    }
                }, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                downloadId.set(dm.enqueue(request));
            }, AndroidPermission.WRITE_EXTERNAL_STORAGE);
        }

        @Override
        public void invalidate() {
            NativeW.super.invalidate();
            getIOSWidget().setNeedsDisplay();
        }

        @Override
        public void invalidate(Rect dirty) {
            super.invalidate(dirty);
            Native.graphics().refreshDisplay();
        }

        @Override
        public void invalidate(final int l, final int t, final int r, final int b) {
            super.invalidate(l, t, r, b);
            Native.graphics().refreshDisplay();
        }

        @Override
        public void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
            Native.graphics().refreshDisplay();
        }

        @Override
        public void draw(Canvas canvas) {
            if (useNativeDrawPipeline)
                try {
                    super.draw(canvas);
                } catch (Throwable th) {
                    Native.system().error("Unable to paint WebView component", th);
                }
        }

        @Override
        public void superDraw(AndroidGraphicsContext cxt) {
            if (!useNativeDrawPipeline)
                try {
                    super.draw(cxt.cv);
                } catch (Throwable th) {
                    Native.system().error("Unable to paint native component", th);
                }
        }

        @Override
        public void setUserInteraction(final boolean status) {
            setEnabled(status);
        }

        @Override
        public void setProgress(int progressPercentage) {
            AndroidWebWrapper.this.progress = progress / 100d;
        }
    }

    private void updateSettings(WebSettings settings) {
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            settings.setDisplayZoomControls(false);
    }
}
