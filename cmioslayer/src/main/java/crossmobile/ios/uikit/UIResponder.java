/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * UIResponder class defines provides all the essential methods for responding
 * and handling events.
 */
@CMClass
public class UIResponder extends NSObject {

    private static final Map<Class<?>, boolean[]> responderMap = new HashMap<>();
    private static final Class<?>[] UR_PARAM = new Class[]{Set.class, UIEvent.class};
    private static UIResponder currentResponder = null;

    static UIResponder requestResponderBeforeInit;

    final boolean[] usesTouches = supports(getClass());

    private static boolean[] supports(Class<?> cls) {
        boolean[] values = responderMap.get(cls);
        if (values == null) {
            values = new boolean[]{
                    overridesMethod(cls, "touchesBegan"),
                    overridesMethod(cls, "touchesMoved"),
                    false,
                    overridesMethod(cls, "touchesEnded"),
                    overridesMethod(cls, "touchesCancelled")
            };
            responderMap.put(cls, values);
        }
        return values;
    }

    private static boolean overridesMethod(Class<?> pclass, String methodName) {
        try {
            return !UIResponder.class.equals(pclass.getMethod(methodName, UR_PARAM).getDeclaringClass());
        } catch (Throwable ex) {
            return false;
        }
    }

    /**
     * Sent to this responder when one or more fingers touched the screen.
     *
     * @param touches The set touches to which the touch or touches belongs.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesBegan:(NSSet<UITouch *> *)touches \n"
            + "           withEvent:(UIEvent *)event;")
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
    }

    /**
     * Sent to this responder when one or more fingers move on the screen.
     *
     * @param touches The set touches to which the touch or touches belongs.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesMoved:(NSSet<UITouch *> *)touches \n"
            + "           withEvent:(UIEvent *)event;")
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
    }

    /**
     * Sent to this responder when one or more fingers were lifted from the
     * screen.
     *
     * @param touches The set touches to which the touch or touches belongs.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesEnded:(NSSet<UITouch *> *)touches \n"
            + "           withEvent:(UIEvent *)event;")
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
    }

    /**
     * Sent to this responder when touch event has been canceled.
     *
     * @param touches The set touches to which the touch belongs.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesCancelled:(NSSet<UITouch *> *)touches \n"
            + "               withEvent:(UIEvent *)event;")
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
    }

    /**
     * Returns the next responder of the response chain.
     *
     * @return The next responder of the response chain. NULL if has none.
     */
    @CMSelector("- (UIResponder *)nextResponder;")
    public UIResponder nextResponder() {
        return null;
    }

    /**
     * Returns a Boolean that shows whether this UIResponder accepts to resign
     * its status as first responder.
     *
     * @return TRUE if this UIResponder accepts to resigns its status as first
     * responder.
     */
    @CMSelector("- (BOOL)resignFirstResponder;")
    public boolean resignFirstResponder() {
        if (currentResponder != this)
            return false;
        currentResponder = null;
        requestResponderBeforeInit = null;
        return true;
    }

    /**
     * Returns a Boolean that shows whether this UIResponder accepts to change
     * its status to first responder.
     *
     * @return TRUE if this UIResponder accepts first responder status.
     */
    @CMSelector("- (BOOL)becomeFirstResponder;")
    public boolean becomeFirstResponder() {
        if (UIApplication.splashWindow != null) {
            requestResponderBeforeInit = this;
            return false;
        }
        if (currentResponder == this)
            return false;
        if (currentResponder != null)
            currentResponder.resignFirstResponder();
        currentResponder = this;
        return true;
    }

    /**
     * Returns a Boolean that shows whether this responder is the first
     * responder.
     *
     * @return A Boolean that shows whether this responder is the first
     * responder.
     */
    @CMSelector("- (BOOL)isFirstResponder;")
    public boolean isFirstResponder() {
        return currentResponder == this;
    }

    String getResponderInfo() {
        if (this instanceof UIView)
            return ((UIView) this).selfAndParentList();
        else
            return SystemUtilities.getClassName(getClass());
    }
}
