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

import crossmobile.ios.coregraphics.CGColor;
import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGFont;
import crossmobile.ios.coregraphics.CGPoint;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.coregraphics.$coregraphics.convertBaseContextToCGContext;

public class $uikit {

    public static CGFont cgfont(UIFont f) {
        return f.cgfont;
    }

    public static CGColor cgcolor(UIColor c) {
        return c.cgcolor;
    }

    public static UIColor uicolor(int color) {
        return new UIColor(color);
    }

    public static void drawWindow(GraphicsContext cxt) {
        UIGraphics.pushContext(convertBaseContextToCGContext(cxt));
        UIWindow window = UIApplication.splashWindow;
        if (window == null)
            window = UIApplication.sharedApplication() == null ? null : UIApplication.sharedApplication().keyWindow();
        if (window != null)
            window.drawWindow();
        UIGraphics.popContext();
    }

    public static UIWindow splashWindow() {
        return UIApplication.splashWindow;
    }

    public static UITouch newUITouch(double hardwareX, double hardwareY, int pointerID, UIWindow window, int phase) {
        return new UITouch(Native.graphics().metrics().getHardwareToVirtual(hardwareX, hardwareY), pointerID, window, phase);
    }

    public static UIEvent newUIEvent(UITouch[] active, Object originalEvent, int phase) {
        return new UIEvent(active, originalEvent, phase);
    }

    public static UIViewController getViewControllerFromView(UIView view) {
        return view.controller;
    }

    public static void mouseDidScroll(float hardwareX, float hardwareY, int scrollAmount) {
        UIView topView = UIApplication.sharedApplication() == null ? null : UIApplication.sharedApplication().keyWindow();
        if (topView == null)
            return;
        UIView hitTest = topView.hitTest(Native.graphics().metrics().getHardwareToVirtual(hardwareX, hardwareY), new cmPrivateEvent() {
            @Override
            public boolean isHitAllowed(UIView targetView) {
                return targetView instanceof UIScrollView;
            }
        });
        if (hitTest != null && (hitTest instanceof UIScrollView)) {
            UIScrollView scrollView = (UIScrollView) hitTest;
            CGPoint offset = scrollView.contentOffset();
            offset.setY(offset.getY() + scrollAmount * 10);
            if (offset.getY() < 0)
                offset.setY(0);
            if (offset.getY() > (scrollView.contentSize.getHeight() + scrollView.contentInset.getTop() + scrollView.contentInset.getBottom()) - scrollView.getHeight())
                offset.setY((scrollView.contentSize.getHeight() + scrollView.contentInset.getTop() + scrollView.contentInset.getBottom()) - scrollView.getHeight());
            scrollView.setContentOffset(offset, false);
            scrollView.flashScrollIndicators();
        }
    }

    public static TextWrapper getTextFieldWrapper(UITextField tf) {
        return (TextWrapper) tf.getWidget();
    }

    public static void drawSelf(UIView view, CGContext cx) {
        view.drawingSelf(cx);
    }

    public static void setStoryboard(UIViewController controller, UIStoryboard storyboard) {
        controller.setStoryboard(storyboard);
    }

    public static void addSegue(UIViewController controller, String id, UIStoryboardSegue segue) {
        controller.addSegue(id, segue);
    }

    public static void addSegue(UITableViewCell cell, String trigger, UIStoryboardSegue segue) {
        cell.addSegue(trigger, segue);
    }

    public static void addSection(UITableViewController tableViewController, String headerTitle, String footerTitle, UITableViewCell[] cells) {
        tableViewController.addSection(headerTitle, footerTitle, cells);
    }

    public static void setCellRowHeight(UITableViewCell cell, float rowHeight) {
        cell.setRowHeight(rowHeight);
    }
}
