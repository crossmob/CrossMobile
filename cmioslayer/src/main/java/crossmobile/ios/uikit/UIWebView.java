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
package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.foundation.NSURLRequest;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.coregraphics.$coregraphics.context;

/**
 * UIWebView class defines an object that is attached to a window in order to
 * insert web content in an application.
 */
@CMClass
public class UIWebView extends UIView {

    private UIWebViewDelegate delegate = null;
    private long dataDetectorTypes = UIDataDetectorTypes.All;
    private boolean scalesPageToFit = false;

    /**
     * Constructs a default UIWebView object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UIWebView() {
        this(new CGRect(0, 0, 0, 0));
    }

    /**
     * Constructs a UIWebView object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect The frame rectangle for the view
     */
    @SuppressWarnings({"LeakingThisInConstructor", "OverridableMethodCallInConstructor"})
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIWebView(CGRect rect) {
        super(rect);
        setBackgroundColor(UIColor.whiteColor);
        setClipsToBounds(true);
        setMultipleTouchEnabled(true);
        registerWidget(Native.widget().webView(this));
    }

    private WebWrapper widget() {
        return (WebWrapper) getWidget();
    }

    /**
     * Loads the URL parameter asynchronously.
     *
     * @param request The URL of the content to be loaded.
     */
    @CMSelector("- (void)loadRequest:(NSURLRequest *)request;")
    public void loadRequest(final NSURLRequest request) {
        if (request != null && request.URL() != null && request.URL().absoluteString() != null)
            Native.system().postOnEventThread(() -> {
                if (delegate == null || delegate.shouldStartLoadWithRequest(UIWebView.this, request, UIWebViewNavigationType.LinkClicked))
                    widget().loadRequest(request);
            });
    }

    /**
     * Sets the content of the main page as defined by the parameter data and
     * the base URL for the content.
     *
     * @param data    The content of the main page.
     * @param baseURL The base URL of the content.
     */
    @CMSelector("- (void)loadHTMLString:(NSString *)string \n"
            + "               baseURL:(NSURL *)baseURL;")
    public void loadHTMLString(String data, NSURL baseURL) {
        widget().loadHTMLString(data, baseURL == null ? null : baseURL.absoluteString());
    }

    /**
     * Loads the content of the main page as defined by the parameters.
     *
     * @param data         The content of the main page.
     * @param mimetype     The MIME type of the content.
     * @param encodingName The encoding type.
     * @param baseURL      The base URL of the content.
     */
    @CMSelector("- (void)loadData:(NSData *)data \n"
            + "        MIMEType:(NSString *)MIMEType \n"
            + "textEncodingName:(NSString *)textEncodingName \n"
            + "         baseURL:(NSURL *)baseURL;")
    public void loadData(NSData data, String mimetype, String encodingName, NSURL baseURL) {
        Native.lifecycle().notImplemented();
    }

    /**
     * Returns the result of running a script.
     *
     * @param script The script to run.
     * @return The result of running script or null if it fails.
     */
    @CMSelector("- (NSString *)stringByEvaluatingJavaScriptFromString:(NSString *)script;")
    public String stringByEvaluatingJavaScriptFromString(String script) {
        return widget().stringByEvaluatingJavaScriptFromString(script);
    }

    /**
     * Returns the delegate.
     *
     * @return The receiver's delegate.
     */
    @CMGetter("@property(nonatomic, assign) id<UIWebViewDelegate> delegate;\n"
            + "")
    public UIWebViewDelegate delegate() {
        return delegate;
    }

    /**
     * Sets as delegate the one defined as parameter.
     *
     * @param delegate The receiver's delegate.
     */
    @CMSetter("@property(nonatomic, assign) id<UIWebViewDelegate> delegate;\n"
            + "")
    public void setDelegate(UIWebViewDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Reloads the page.
     */
    @CMSelector("- (void)reload;")
    public void reload() {
        widget().reload();
    }

    /**
     * Informs if this Web View could go back in history
     *
     * @return true if it could go back in history
     */
    @CMGetter("@property(nonatomic, readonly, getter=canGoBack) BOOL canGoBack;")
    public boolean canGoBack() {
        return widget().canGoBack();
    }

    /**
     * Takes the previous location of the back-forward list and loads it to the
     * widget.
     */
    @CMSelector("- (void)goBack;")
    public void goBack() {
        widget().goBack();
    }

    /**
     * Informs if this Web View could go forward in history
     *
     * @return true if it could go forward in history
     */
    @CMGetter("@property(nonatomic, readonly, getter=canGoForward) BOOL canGoForward;")
    public boolean canGoForward() {
        return widget().canGoForward();
    }

    /**
     * Takes the next location of the back-forward list and loads it to the
     * widget.
     */
    @CMSelector("- (void)goForward;")
    public void goForward() {
        widget().goForward();
    }

    /**
     * Returns the types of data that are viewed as clickable URLs in the web
     * view content.
     *
     * @return The types of data that will be viewed as clickable URLs. content.
     */
    @CMGetter("@property(nonatomic) UIDataDetectorTypes dataDetectorTypes;")
    public long dataDetectorTypes() {
        return dataDetectorTypes;
    }

    /**
     * Sets the types of data that will be viewed as clickable URLs in the web
     * view content.
     *
     * @param dataDetectorTypes The types of data that will be viewed as
     *                          clickable URLs.
     */
    @CMSetter("@property(nonatomic) UIDataDetectorTypes dataDetectorTypes;")
    public void setDataDetectorTypes(long dataDetectorTypes) {
        this.dataDetectorTypes = dataDetectorTypes;
    }

    /**
     * Returns a Boolean value that defines whether the webpage adapts
     * proportionally in order to fit the view. The use of the application is
     * able to change the scale.
     *
     * @return A Boolean value that defines whether the webpage adapts
     * proportionally in order to fit the view.
     */
    @CMGetter("@property(nonatomic) BOOL scalesPageToFit;")
    public boolean scalesPageToFit() {
        return scalesPageToFit;
    }

    /**
     * Sets a Boolean value that defines whether the webpage adapts
     * proportionally in order to fit the view. The use of the application is
     * able to change the scale.
     *
     * @param scalesPageToFit Sets a Boolean value that defines whether the
     *                        webpage adapts proportionally to the view.
     */
    @CMSetter("@property(nonatomic) BOOL scalesPageToFit;")
    public void setScalesPageToFit(boolean scalesPageToFit) {
        this.scalesPageToFit = scalesPageToFit;
    }

    @CMGetter("@property(nonatomic, readonly, getter=isLoading) BOOL loading;")
    public boolean isLoading() {
        return widget().isLoading();
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public final void drawRect(CGRect rect) {
        if (getWidget() != null)
            getWidget().draw(context(UIGraphics.getCurrentContext()));
    }

    @CMSetter("@property(nonatomic) BOOL mediaPlaybackRequiresUserAction;")
    public void setMediaPlaybackRequiresUserAction(boolean ua) {

    }

    @CMGetter("@property(nonatomic) BOOL mediaPlaybackRequiresUserAction;")
    public boolean mediaPlaybackRequiresUserAction() {
        return true;
    }

    /**
     * Returns the scroll view of the web view.
     *
     * @return Scroll view of the web view.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIScrollView *scrollView;")
    public UIScrollView scrollView() {
        Native.lifecycle().notImplemented();
        return new UIScrollView();
    }
}
