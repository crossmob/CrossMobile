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

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.HashMap;
import java.util.Map;

/**
 * NSObject class is the base class of all objects.
 */
@CMClass
public class NSObject {

    private Map<String, Object> keyvalues;

    /**
     * The default constructor of the NSObject.
     */
    @CMConstructor("-(instancetype) init;")
    public NSObject() {
    }

    /**
     * Applies the specified method to this object using delay.
     *
     * @param <A>      argument type
     * @param selector Defines which method to apply.
     * @param arg      The argument of the method that is applied. NULL if the method
     *                 has no arguments.
     * @param delay    The minimum time before which the message is sent.
     */
    @CMSelector(value = "- (void)performSelector:(SEL)aSelector withObject:(id)anArgument afterDelay:(NSTimeInterval)delay;")
    public final <A> void performSelector(NSSelector<A> selector, A arg, double delay) {
        NSTimer.scheduledTimerWithTimeInterval((float) delay, timer -> selector.exec((A) timer.userInfo()), arg, false);
    }

    /**
     * Applies the specified method to this object with the option of suspending
     * the thread.
     *
     * @param selector      Defines which method to apply.
     * @param arg           The argument of the method that is applied. NULL if the method
     *                      has no arguments.
     * @param waitUntilDone TRUE then the current thread waits until the method
     *                      is applied.
     */
    @CMSelector(value = "- (void)performSelectorOnMainThread:(SEL)aSelector \n"
            + "                         withObject:(id)arg \n"
            + "                      waitUntilDone:(BOOL)wait;")
    public final <A> void performSelectorOnMainThread(NSSelector<A> selector, final A arg, boolean waitUntilDone) {
        if (selector != null)
            if (waitUntilDone)
                Native.system().runAndWaitOnEventThread(() -> selector.exec(arg));
            else
                Native.system().postOnEventThread(() -> selector.exec(arg));
    }

    /**
     * Sends the retain message to this object.(Objective-C's feature)
     *
     * @return Returns this object after sending to it the retain message.
     */
    @CMSelector("- (instancetype)retain;")
    public final NSObject retain() {
        return this;
    }

    /**
     * Applies the low level method on this object.
     */
    @CMSelector("- (oneway void)release")
    public final void release() {
    }

    /**
     * Sets the value of the property specified by the key to the specified value.
     *
     * @param value The value to set on the property.
     * @param key   The name of the property whose value you want to retrieve.
     */
    @CMSelector("- (void)setValue:(id)value forKey:(NSString *)key;")
    public void setValue(Object value, String key) {
        if (keyvalues == null)
            keyvalues = new HashMap<>();
        keyvalues.put(key, value);
    }

    /**
     * Returns the id value of the specified key.
     *
     * @param key The key name of the value to be retrieved.
     * @return The id value of the specified key.
     */
    @CMSelector("- (id)valueForKey:(NSString *)key;")
    public Object valueForKey(String key) {
        return keyvalues == null ? null : keyvalues.get(key);
    }

}
