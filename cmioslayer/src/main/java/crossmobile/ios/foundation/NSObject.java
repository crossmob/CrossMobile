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
import org.crossmobile.bridge.ann.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * NSObject class is the base class of all objects.
 */
@CMClass
public class NSObject {

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
    public void setValueForKey(Object value, String key) {
        if (key == null || key.isEmpty())
            return;
        String uKey = key.substring(0, 1).toUpperCase() + (key.length() > 1 ? key.substring(1) : "");
        String[] methodNames = {"set" + uKey, "_setKey" + uKey};
        for (Method method : getClass().getMethods())
            if (method.getParameterCount() == 1 && method.getParameters()[0].getClass().isInstance(value))
                for (String methodName : methodNames)
                    if (methodName.equals(method.getName())) {
                        try {
                            method.invoke(this, value);
                        } catch (IllegalAccessException | InvocationTargetException ignored) {
                        }
                        return;
                    }
        setValueForUndefinedKey(value, key);
    }

    @CMSelector("- (void)setValue:(id)value \n" +
            " forUndefinedKey:(NSString *)key;")
    public void setValueForUndefinedKey(Object value, String key) {
        throwUndefinedKeyException(key);
    }

    /**
     * Returns the id value of the specified key.
     *
     * @param key The key name of the value to be retrieved.
     * @return The id value of the specified key.
     */
    @CMSelector("- (id)valueForKey:(NSString *)key;")
    public Object valueForKey(String key) {
        if (key == null || key.isEmpty())
            return null;
        String uKey = key.substring(0, 1).toUpperCase() + (key.length() > 1 ? key.substring(1) : "");
        Class<? extends NSObject> cls = getClass();
        Method method = getSafeMethod(cls, "get" + uKey);
        if (method == null)
            method = getSafeMethod(cls, key);
        if (method == null)
            method = getSafeMethod(cls, "is" + uKey);
        if (method == null)
            method = getSafeMethod(cls, "_" + key);
        if (method == null)
            return valueForUndefinedKey(key);
        try {
            return method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException ignored) {
            return null;
        }
    }

    @CMSelector("- (id)valueForUndefinedKey:(NSString *)key;")
    public Object valueForUndefinedKey(String key) {
        throwUndefinedKeyException(key);
        return null;
    }

    private Method getSafeMethod(Class<? extends NSObject> cls, String methodName) {
        try {
            return cls.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    @CMSelector("- (void)addObserver:(NSObject *)observer \n" +
            "         forKeyPath:(NSString *)keyPath \n" +
            "            options:(NSKeyValueObservingOptions)options \n" +
            "            context:(void *)context;\n")
    public void addObserver(NSObject observer, String keyPath, int NSKeyValueObservingOptions, Object context) {
        Native.lifecycle().notImplemented();
    }

    @CMSelector("- (void)removeObserver:(NSObject *)observer \n" +
            "            forKeyPath:(NSString *)keyPath;")
    public void removeObserver(NSObject observer, String keyPath) {
        Native.lifecycle().notImplemented();
    }

    @CMSelector("- (void)removeObserver:(NSObject *)observer \n" +
            "            forKeyPath:(NSString *)keyPath \n" +
            "               context:(void *)context;")
    public void removeObserver(NSObject observer, String keyPath, Object context) {
        Native.lifecycle().notImplemented();
    }

    @CMSelector("- (void)observeValueForKeyPath:(NSString *)keyPath \n" +
            "                      ofObject:(id)object \n" +
            "                        change:(NSDictionary<NSKeyValueChangeKey, id> *)change \n" +
            "                       context:(void *)context;\n")
    public void observeValueForKeyPath(String keyPath, Object object, Map<String, Object> change, Object context) {
    }

    private void throwUndefinedKeyException(String key) {
        throw new RuntimeException("Undefined key " + key + " in object " + getClass().getName());
    }
}
