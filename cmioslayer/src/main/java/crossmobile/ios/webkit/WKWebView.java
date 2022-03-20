/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.uikit.*;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.robovm.objc.block.VoidBlock2;

import java.util.Set;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;

/**
 * Present HTML and Web content inside the application
 */
@CMClass
public class WKWebView extends UIView {
    private final WKWebViewConfiguration configuration;
    private WKNavigationDelegate navigationDelegate;

    public WKWebView() {
        this(CGRect.zero());
    }

    public WKWebView(CGRect frame) {
        this(frame, new WKWebViewConfiguration());
    }

    private WebWrapper widget() {
        return (WebWrapper) getWidget();
    }

    @SuppressWarnings("unchecked")
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame \n" +
            "                configuration:(WKWebViewConfiguration *)configuration;\n")
    public WKWebView(CGRect frame, WKWebViewConfiguration configuration) {
        super(frame);
        this.configuration = new WKWebViewConfiguration(configuration);
        setBackgroundColor(UIColor.whiteColor());
        setClipsToBounds(true);
        setMultipleTouchEnabled(true);
        registerWidget(Native.webview().webView(this));
    }

    @CMGetter("@property(nonatomic, readonly, copy) WKWebViewConfiguration *configuration;")
    public WKWebViewConfiguration configuration() {
        return new WKWebViewConfiguration(configuration);
    }


    @CMGetter("@property(nullable, nonatomic, weak) id<WKNavigationDelegate> navigationDelegate;")
    public WKNavigationDelegate navigationDelegate() {
        return navigationDelegate;
    }

    @CMSetter("@property(nullable, nonatomic, weak) id<WKNavigationDelegate> navigationDelegate;")
    public void setNavigationDelegate(WKNavigationDelegate navigationDelegate) {
        this.navigationDelegate = navigationDelegate;
    }

    @CMGetter("@property(nullable, nonatomic, copy) NSString *customUserAgent;")
    public String customUserAgent() {
        return configuration.applicationNameForUserAgent();
    }

    @CMGetter("@property(nullable, nonatomic, readonly, copy) NSURL *URL;")
    public NSURL URL() {
        String url = widget().getUrl();
        return url == null ? null : NSURL.URLWithString(url);
    }

    @CMGetter("@property(nullable, nonatomic, readonly, copy) NSString *title;")
    public String title() {
        return widget().getTitle();
    }

    @CMGetter("@property(nonatomic, readonly) double estimatedProgress;")
    public double estimatedProgress() {
        return widget().getProgress();
    }

    @CMGetter("@property(nonatomic, readonly) BOOL hasOnlySecureContent;")
    public boolean hasOnlySecureContent() {
        Native.system().notImplemented();
        return false;
    }

    @CMGetter("@property(nonatomic, readonly, getter=isLoading) BOOL loading;")
    public boolean isLoading() {
        return widget().isLoading();
    }

//    @CMGetter("@property(nonatomic) CGFloat magnification;")
//    public double magnification() {
//        return widget().getMagnification();
//    }

    @CMGetter("@property(nonatomic) BOOL allowsBackForwardNavigationGestures;")
    public boolean allowsBackForwardNavigationGestures() {
        return false;
    }

    /**
     * Informs if this Web View could go back in history
     *
     * @return true if it could go back in history
     */
    @CMGetter("@property(nonatomic, readonly) BOOL canGoBack;")
    public boolean canGoBack() {
        return widget().getBackForwardList().backItem() != null;
    }

    /**
     * Informs if this Web View could go forward in history
     *
     * @return true if it could go forward in history
     */
    @CMGetter("@property(nonatomic, readonly) BOOL canGoForward;")
    public boolean canGoForward() {
        return widget().getBackForwardList().forwardItem() != null;
    }


    /**
     * Takes the previous location of the back-forward list and loads it to the
     * widget.
     */
    @CMSelector("- (WKNavigation *)goBack;")
    public WKNavigation goBack() {
        WKBackForwardListItem item = widget().getBackForwardList().backItem();
        return item != null && widget().acceptsRequest(NSURLRequest.requestWithURL(item.URL()), UIWebViewNavigationType.BackForward)
                ? widget().goBack()
                : null;
    }

    /**
     * Takes the next location of the back-forward list and loads it to the
     * widget.
     */
    @CMSelector("- (WKNavigation *)goForward;")
    public WKNavigation goForward() {
        WKBackForwardListItem item = widget().getBackForwardList().forwardItem();
        return item != null && widget().acceptsRequest(NSURLRequest.requestWithURL(item.URL()), UIWebViewNavigationType.BackForward)
                ? widget().goForward()
                : null;
    }

    /**
     * Sets the content of the main page as defined by the parameter data and
     * the base URL for the content.
     *
     * @param data    The content of the main page.
     * @param baseURL The base URL of the content.
     */
    @CMSelector("- (WKNavigation *)loadHTMLString:(NSString *)string \n" +
            "                         baseURL:(NSURL *)baseURL;")
    public WKNavigation loadHTMLString(String data, NSURL baseURL) {
        return widget().loadData(data, "text/html", baseURL == null ? null : baseURL.absoluteString());
    }

    /**
     * Loads the content of the main page as defined by the parameters.
     *
     * @param data         The content of the main page.
     * @param MIMEType     The MIME type of the content.
     * @param encodingName The encoding type.
     * @param baseURL      The base URL of the content.
     */
    @CMSelector("- (WKNavigation *)loadData:(NSData *)data \n" +
            "                  MIMEType:(NSString *)MIMEType \n" +
            "     characterEncodingName:(NSString *)characterEncodingName \n" +
            "                   baseURL:(NSURL *)baseURL;")
    public WKNavigation loadData(NSData data, String MIMEType, String encodingName, NSURL baseURL) {
        return widget().loadData(SystemUtilities.toString(data == null ? null : data.bytes(), encodingName, ""),
                MIMEType == null ? "text/html" : MIMEType,
                baseURL == null ? null : baseURL.absoluteString());
    }

    @CMSelector("- (WKNavigation *)loadFileURL:(NSURL *)URL \n" +
            "      allowingReadAccessToURL:(NSURL *)readAccessURL;\n")
    public WKNavigation loadFileURL(NSURL url, NSURL readAccessURL) {
        return loadRequest(NSURLRequest.requestWithURL(url));
    }

    /**
     * Loads the URL parameter asynchronously.
     *
     * @param request The URL of the content to be loaded.
     */
    @CMSelector("- (WKNavigation *)loadRequest:(NSURLRequest *)request;")
    public WKNavigation loadRequest(NSURLRequest request) {
        return widget().acceptsRequest(request, UIWebViewNavigationType.LinkClicked)
                ? widget().loadRequest(request)
                : null;
    }

    /**
     * Reloads the page.
     */
    @CMSelector("- (WKNavigation *)reload;")
    public WKNavigation reload() {
        return widget().reload();
    }

    @CMGetter("@property(nonatomic) BOOL allowsLinkPreview;")
    public boolean allowsLinkPreview() {
        return false;
    }

    /**
     * Returns the result of running a script.
     *
     * @param javaScriptString The script to run.
     */
    @CMSelector("- (void)evaluateJavaScript:(NSString *)javaScriptString \n" +
            "         completionHandler:(void (^)(id, NSError *error))completionHandler;\n")
    @SuppressWarnings("unchecked")
    public void evaluateJavaScript(String javaScriptString, VoidBlock2<Object, NSError> completionHandler) {
        widget().evaluateJavaScript(javaScriptString, completionHandler);
    }

    /**
     * Returns the scroll view of the web view.
     *
     * @return Scroll view of the web view.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIScrollView *scrollView;")
    public UIScrollView scrollView() {
        Native.system().notImplemented();
        return new UIScrollView();
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(UserInterfaceDrill.getOriginalEvent(event), UserInterfaceDrill.getTouches(event, this));
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(UserInterfaceDrill.getOriginalEvent(event), UserInterfaceDrill.getTouches(event, this));
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(UserInterfaceDrill.getOriginalEvent(event), UserInterfaceDrill.getTouches(event, this));
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(UserInterfaceDrill.getOriginalEvent(event), UserInterfaceDrill.getTouches(event, this));
    }

    @Override
    public final void drawRect(CGRect rect) {
        if (getWidget() != null)
            getWidget().draw(context(UIGraphics.getCurrentContext()));
    }

}
