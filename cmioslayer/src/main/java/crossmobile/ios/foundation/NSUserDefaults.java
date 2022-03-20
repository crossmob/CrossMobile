/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.io.FileBridgeConstants;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.bridge.system.JsonHelper;
import org.robovm.objc.block.Block0;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * NSUserDefaults class defines an object that provides support related to user
 * default preferences storing.
 */
@CMClass
public class NSUserDefaults extends NSObject {

    private static final File DEST_PATH = new File(
            Native.file().getHomeLocation() + File.separator
                    + FileBridgeConstants.DEFAULTPATHS[NSSearchPathDirectory.Library] + File.separator
                    + "Preferences");

    private static NSUserDefaults standard;

    private final String suitename;
    private final HashMap<String, Object> user = new HashMap<>();
    private HashMap<String, Object> bundle;
    private HashMap<String, Block0<Object>> virtual;

    private final Runnable synchronizeLater = () -> new Thread(this::synchronize).start();

    /**
     * Returns the shared NSUserDefaults object.
     *
     * @return The shared NSUserDefaults object.
     */
    @CMSelector("+ (NSUserDefaults *)standardUserDefaults;")
    public static NSUserDefaults standardUserDefaults() {
        if (standard == null)
            standard = new NSUserDefaults("." + Native.system().bundleID() + "_properties").addBundleSettings();
        return standard;
    }

    @SuppressWarnings("unchecked")
    @CMConstructor("- (instancetype)initWithSuiteName:(NSString *)suitename;")
    public NSUserDefaults(String suitename) {
        this.suitename = suitename;

        File sourceFile = new File(DEST_PATH, suitename);
        if (!sourceFile.exists()) return;

        String data = BaseUtils.readFile(sourceFile);
        if (data == null) return;

        Object jsonRaw = JsonHelper.decode(data);
        if (jsonRaw == null) return;

        Map<?, Object> json = (Map<?, Object>) jsonRaw;
        for (Object key : json.keySet())
            if (key instanceof String)
                user.put((String) key, json.get(key));
    }

    @SuppressWarnings("unchecked")
    private NSUserDefaults addBundleSettings() {
        Map<String, Object> dict = NSDictionary.dictionaryWithContentsOfFile(Native.file().getApplicationPrefix() + File.separator + "Settings.bundle" + File.separator + "Root.plist");
        if (dict != null) {
            bundle = new HashMap<>();
            List<Object> prefsList = (List<Object>) dict.get("PreferenceSpecifiers");
            if (prefsList != null)
                for (Object prefObj : prefsList) {
                    Map<String, Object> prefMap = (Map<String, Object>) prefObj;
                    String key = (String) prefMap.get("Key");
                    if (key != null) {
                        Object value = prefMap.get("DefaultValue");
                        bundle.put(key, value == null ? "" : value.toString());
                    }
                }
        }
        return this;
    }

    void addVirtualValue(String key, Block0<Object> supplier) {
        if (key == null || supplier == null)
            return;
        if (virtual == null)
            virtual = new HashMap<>();
        virtual.put(key, supplier);
    }

    /**
     * Stores any changes to the disk and updates functionality of the
     * application according to the stored values.
     *
     * @return TRUE if disk updating was successful.
     */
    @CMSelector("- (BOOL)synchronize;")
    public boolean synchronize() {
        try {
            return BaseUtils.writeFile(new File(DEST_PATH, suitename), JsonHelper.encode(user, false));
        } catch (Exception e) {
            Native.system().error("Unable to encode User Defaults", e);
            return false;
        }
    }

    /**
     * Sets the specified object for the specified key.
     *
     * @param value The object of the specified key.
     * @param key   The key for which the object is set.
     */
    @CMSelector("- (void)setObject:(id)value \n"
            + "           forKey:(NSString *)defaultName;")
    public void setObject(Object value, String key) {
        if (value instanceof NSMutableData)
            user.put(key, new NSData(((NSMutableData) value).bytes()));
        else if (value instanceof List)
            user.put(key, Collections.unmodifiableList((List<?>) value));
        else if (value instanceof Set)
            user.put(key, Collections.unmodifiableSet((Set<?>) value));
        else if (value instanceof Collection)
            user.put(key, Collections.unmodifiableCollection((Collection<?>) value));
        else if (value instanceof Map)
            user.put(key, Collections.unmodifiableMap((Map<?, ?>) value));
        else
            user.put(key, value);
        // We need to call it like this, thus saving will be performed only once at the end of the cycle
        Native.lifecycle().runLaterOnceOnEventThread(synchronizeLater);
    }

    /**
     * Returns the object of the specified key.
     *
     * @param key The key for which the object is requested.
     * @return The object of the specified key or NULL if the key was not found.
     */
    @CMSelector("- (id)objectForKey:(NSString *)defaultName;")
    public Object objectForKey(String key) {
        Object result = user.get(key);
        if (result == null && bundle != null)
            result = bundle.get(key);
        if (result == null && virtual != null) {
            Block0<Object> supplier = virtual.get(key);
            if (supplier != null)
                result = supplier.invoke();
        }
        return result;
    }

    /**
     * Removes the specified key from the dictionary.
     *
     * @param key The key that is removed.
     */
    @CMSelector("- (void)removeObjectForKey:(NSString *)defaultName")
    public void removeObjectForKey(String key) {
        user.remove(key);
    }

    private Number numberForKey(String key) {
        try {
            Object v = objectForKey(key);
            if (v == null)
                return 0;
            if (v instanceof Boolean)
                return (Boolean) v ? 1 : 0;
            if (v instanceof Number)
                return (Number) v;
            return new BigDecimal(v.toString());
        } catch (Exception ignored) {
        }
        return 0;
    }

    /**
     * Sets the specified integer number for the specified key.
     *
     * @param value The integer number of the specified key.
     * @param key   The key for which the value is set.
     */
    @CMSelector("- (void)setInteger:(NSInteger)value \n"
            + "            forKey:(NSString *)defaultName;")
    public void setInteger(int value, String key) {
        setObject(value, key);
    }

    /**
     * Returns the integer of the specified key.
     *
     * @param key The key for which the integer is returned.
     * @return The integer number of the specified key.
     */
    @CMSelector("- (NSInteger)integerForKey:(NSString *)defaultName;")
    public int integerForKey(String key) {
        return numberForKey(key).intValue();
    }

    /**
     * Sets the specified float number for the specified key.
     *
     * @param value The float number of the specified key.
     * @param key   The key for which the value is set.
     */
    @CMSelector("- (void)setFloat:(float)value \n"
            + "          forKey:(NSString *)defaultName;")
    public void setFloat(float value, String key) {
        setObject(value, key);
    }

    /**
     * Returns the float number of the specified key.
     *
     * @param key The key for which float number is requested.
     * @return The float number of the specified key.
     */
    @CMSelector("- (float)floatForKey:(NSString *)defaultName;")
    public float floatForKey(String key) {
        return numberForKey(key).floatValue();
    }

    /**
     * Sets the specified double number for the specified key.
     *
     * @param value The double number of the specified key.
     * @param key   The key for which the value is set.
     */
    @CMSelector("- (void)setDouble:(double)value \n" +
            "           forKey:(NSString *)defaultName;\n")
    public void setDouble(double value, String key) {
        setObject(value, key);
    }

    /**
     * Returns the double number of the specified key.
     *
     * @param key The key for which double number is requested.
     * @return The double number of the specified key.
     */
    @CMSelector("- (double)doubleForKey:(NSString *)defaultName;")
    public double doubleForKey(String key) {
        return numberForKey(key).doubleValue();
    }

    /**
     * Returns the string of the specified key.
     *
     * @param key The key for which the string is requested.
     * @return The string of the specified key.
     */
    @CMSelector("- (NSString *)stringForKey:(NSString *)defaultName;")
    public String stringForKey(String key) {
        Object v = objectForKey(key);
        if (v == null)
            return null;
        if (v instanceof String)
            return (String) v;
        else
            return v.toString();
    }

    /**
     * Set the specified Boolean for the specified key.
     *
     * @param value The Boolean for the specified key.
     * @param key   The key for which the Boolean value is set.
     */
    @CMSelector("- (void)setBool:(BOOL)value \n"
            + "         forKey:(NSString *)defaultName;")
    public void setBool(boolean value, String key) {
        setObject(value, key);
    }

    /**
     * Returns a Boolean of the specified key either the default or false.
     *
     * @param key The key for which the Boolean is returned.
     * @return FALSE if there is no default value.
     */
    @CMSelector("- (BOOL)boolForKey:(NSString *)defaultName;\n"
            + "")
    public boolean boolForKey(String key) {
        return BaseUtils.objectToBoolean(objectForKey(key));
    }

    /**
     * Returns the data object of the specified key.
     *
     * @param key The key whose data object is requested.
     * @return The data object of the specified key.
     */
    @CMSelector("- (NSData *)dataForKey:(NSString *)defaultName;")
    public NSData dataForKey(String key) {
        Object v = objectForKey(key);
        return v instanceof NSData ? (NSData) v : null;
    }
}
