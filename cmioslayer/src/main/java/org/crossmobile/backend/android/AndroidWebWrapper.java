/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.*;
import android.widget.Toast;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSMutableURLRequest;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.uikit.UIWebViewNavigationType;
import org.crossmobile.backend.android.AndroidNativeDispatcher.AndroidNativeWidget;
import org.crossmobile.backend.android.web.VideoEnabledWebChromeClient;
import org.crossmobile.backend.android.web.VideoEnabledWebView;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bridge.Native;

import java.io.File;
import java.util.Iterator;

import static android.content.Context.DOWNLOAD_SERVICE;

public class AndroidWebWrapper extends WebWrapper<AndroidWebWrapper.NativeW, AndroidGraphicsContext> {

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            WebView.enableSlowWholeDocumentDraw();
    }

    private static final String JSTAG = "javascript:";

    private boolean isLoading = false;

    public AndroidWebWrapper(UIWebView parent) {
        super(parent);
    }

    @Override
    public NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public void loadRequest(NSURLRequest req) {
        NSMutableURLRequest mreq = (NSMutableURLRequest) ((req instanceof NSMutableURLRequest) ? req : null);
        if (mreq != null)
            getNativeWidget().postUrl(mreq.URL().absoluteString(), mreq.HTTPBody() == null ? null : mreq.HTTPBody().bytes());
        else
            getNativeWidget().loadUrl(req.URL().absoluteString());
    }

    @Override
    public void loadHTMLString(String data, String baseURL) {
        if (baseURL != null)
            getNativeWidget().loadDataWithBaseURL(baseURL, data, "text/html", "utf-8", null);
        else
            getNativeWidget().loadData(data, "text/html", "utf-8");
    }

    @Override
    public boolean canGoBack() {
        return getHistoryList().canGoBack();
    }

    @Override
    public void goBack() {
        HistorySanitizer history = getHistoryList();
        if (history.canGoBack() && acceptsURL(history.previousURL(), UIWebViewNavigationType.BackForward))
            getNativeWidget().goBack();
    }

    @Override
    public boolean canGoForward() {
        return getHistoryList().canGoForth();
    }

    @Override
    public void goForward() {
        HistorySanitizer history = getHistoryList();
        if (history.canGoForth() && acceptsURL(history.nextURL(), UIWebViewNavigationType.BackForward))
            getNativeWidget().goForward();
    }

    @Override
    public String stringByEvaluatingJavaScriptFromString(String script) {
        if (!script.startsWith(JSTAG))
            script = JSTAG + script;
        getNativeWidget().loadUrl(script);
        //    System.err.println("Call back string not implemented yet with Android backend. Probably a addJavascriptInterface should be activated.");
        return null;
    }

    @Override
    public void reload() {
        getNativeWidget().reload();
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    public class NativeW extends VideoEnabledWebView implements AndroidNativeWidget {

        public NativeW() {
            super(MainActivity.current);
            updateSettings(getSettings());
            setWebChromeClient(new VideoEnabledWebChromeClient(MainView.current, MainView.current, null, this));
            setDownloadListener((String url, String userAgent, String contentDisposition, String mimetype, long contentLength) -> {
                downloadFile(url, mimetype);
            });
            setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    isLoading = true;
                    UIWebView source = getIOSWidget();
                    if (source != null && source.delegate() != null && (url == null || !url.startsWith(JSTAG)))
                        source.delegate().didStartLoad(source);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    isLoading = false;
                    UIWebView source = getIOSWidget();
                    if (source != null && source.delegate() != null && (url == null || !url.startsWith(JSTAG))) {
                        source.delegate().didFinishLoad(source);
                        zoomOut();
                    }
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    isLoading = false;
                    UIWebView source = getIOSWidget();
                    if (source != null)
                        if (source.delegate() != null)
                            source.delegate().didFailLoadWithError(source, new NSError("NSURLErrorDomain", errorCode, null));
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return shouldOverrideUrlLoading(request.getUrl().toString());
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return shouldOverrideUrlLoading(url);
                }

                private boolean shouldOverrideUrlLoading(String url) {
                    return !acceptsURL(url, UIWebViewNavigationType.LinkClicked);
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

                MainActivity.current.registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        if (!DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction()))
                            return;
                        MainActivity.current.unregisterReceiver(this);
                        Bundle extras = intent.getExtras();
                        long downloadId = extras.getLong(DownloadManager.EXTRA_DOWNLOAD_ID);
                        Cursor c = dm.query(new DownloadManager.Query().setFilterById(downloadId));
                        if (!c.moveToFirst())
                            return;
                        int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                        if (status == DownloadManager.STATUS_SUCCESSFUL) {
                            try {
                                Uri uri = AndroidFileBridge.getExternalUri(Uri.parse(c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))));
                                MainActivity.current.startActivity(new Intent().setAction(android.content.Intent.ACTION_VIEW)
                                        .setDataAndType(uri, mime).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION));
                            } catch (Exception ex) {
                                Toast.makeText(MainActivity.current, "Unable to display external file. It can still be found as Downloaded content", 2).show();
                            }
                        } else if (status == DownloadManager.STATUS_FAILED) {
                            for (File f : new File(MainActivity.current.getCacheDir().getAbsolutePath()).listFiles())
                                if (f.getName().contains(String.valueOf(downloadId))) {
                                    //noinspection ResultOfMethodCallIgnored
                                    f.delete();
                                    break;
                                }
                            Toast.makeText(MainActivity.current, "Unable to download external file", 2).show();
                        } else
                            Toast.makeText(MainActivity.current, "Unable to download external file (status " + status + ")", 2).show();
                    }
                }, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                dm.enqueue(request);
            }, AndroidPermission.WRITE_EXTERNAL_STORAGE);
        }

        @Override
        public void invalidate() {
            NativeW.super.invalidate();
            Native.graphics().refreshDisplay();
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
    }

    private void updateSettings(WebSettings settings) {
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            settings.setDisplayZoomControls(false);
    }

    private HistorySanitizer getHistoryList() {
        WebView widget = getNativeWidget();
        WebBackForwardList urls = widget.copyBackForwardList();
        return new HistorySanitizer(urls.getCurrentIndex(), new Iterator<String>() {
            int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < urls.getSize();
            }

            @Override
            public String next() {
                return urls.getItemAtIndex(idx++).getUrl();
            }
        });
    }
}
