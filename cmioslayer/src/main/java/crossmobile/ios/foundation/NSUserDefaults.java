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

import org.crossmobile.bind.io.FileBridgeConstants;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.support.MiGBase64;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * NSUserDefaults class defines an object that provides support related to user
 * default preferences storing.
 */
@CMClass
public class NSUserDefaults extends NSObject {

    private static final File userPath = new File(
            Native.file().getHomeLocation() + File.separator
                    + FileBridgeConstants.DEFAULTPATHS[NSSearchPathDirectory.Library] + File.separator
                    + "Preferences" + File.separator
                    + Native.system().bundleID() + ".properties");
    private static final String NSDATA_PREFIX = "[NSData]";
    private static NSUserDefaults standard;
    //
    private final Properties values = new Properties();

    /**
     * Returns the shared NSUserDefaults object.
     *
     * @return The shared NSUserDefaults object.
     */
    @CMSelector("+ (NSUserDefaults *)standardUserDefaults;")
    public static NSUserDefaults standardUserDefaults() {
        if (standard == null) {
            standard = new NSUserDefaults();
            standard.parseSettings();
            standard.parseUser();
        }
        return standard;
    }

    @CMConstructor("- (instancetype)initWithSuiteName:(NSString *)suitename;")
    public NSUserDefaults(String suitename) {

    }

    NSUserDefaults() {
    }

    private void parseSettings() {
        Map<String, Object> dict = NSDictionary.dictionaryWithContentsOfFile(Native.file().getApplicationPrefix() + File.separator + "Settings.bundle" + File.separator + "Root.plist");
        if (dict == null)
            return;
        List<Object> prefsList = (List<Object>) dict.get("PreferenceSpecifiers");
        if (prefsList != null)
            for (Object prefObj : prefsList) {
                Map<String, Object> prefMap = (Map<String, Object>) prefObj;
                String key = (String) prefMap.get("Key");
                if (key != null) {
                    Object value = prefMap.get("DefaultValue");
                    if (value == null)
                        value = "";
                    values.setProperty(key, value.toString());
                }
            }
    }

    private void parseUser() {
        try {
            values.load(new InputStreamReader(new FileInputStream(userPath), "UTF-8"));
        } catch (IOException ex) {
        }
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
            values.store(new OutputStreamWriter(new FileOutputStream(userPath), "UTF-8"), "CrossMobile user defaults");
            return true;
        } catch (IOException ex) {
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
        if (value instanceof NSData)
            values.setProperty(key, NSDATA_PREFIX + MiGBase64.encodeToString(((NSData) value).data, false));
        else
            values.setProperty(key, value.toString());
        synchronize();
    }

    /**
     * Returns the object of the specified key.
     *
     * @param key The key for which the object is requested.
     * @return The object of the specified key or NULL if the key was not found.
     */
    @CMSelector("- (id)objectForKey:(NSString *)defaultName;")
    public Object objectForKey(String key) {
        String val = values.getProperty(key);
        if (val == null)
            return null;
        if (val.startsWith(NSDATA_PREFIX))
            return dataForKey(key);
        {
            String valLC = val.toLowerCase();
            if (valLC.equals("true") || valLC.equals("yes"))
                return Boolean.TRUE;
            if (valLC.equals("false") || valLC.equals("no"))
                return Boolean.FALSE;
        }
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException ex) {
        }
        try {
            return Double.parseDouble(val);
        } catch (NumberFormatException ex) {
        }
        return val;
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
        values.setProperty(key, Integer.toString(value));
        synchronize();
    }

    /**
     * Returns the integer of the specified key.
     *
     * @param key The key for which the integer is returned.
     * @return The integer number of the specified key.
     */
    @CMSelector("- (NSInteger)integerForKey:(NSString *)defaultName;")
    public int integerForKey(String key) {
        try {
            return Integer.parseInt(values.getProperty(key));
        } catch (NumberFormatException ex) {
        }
        return 0;
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
        values.setProperty(key, Boolean.toString(value));
        synchronize();
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
        String val = values.getProperty(key);
        if (val == null)
            return false;
        val = val.toLowerCase();
        return val.equals("true") || val.equals("yes");
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
        values.setProperty(key, Float.toString(value));
        synchronize();
    }

    /**
     * Returns the float number of the specified key.
     *
     * @param key The key for which float number is requested.
     * @return The float number of the specified key.
     */
    @CMSelector("- (float)floatForKey:(NSString *)defaultName;")
    public float floatForKey(String key) {
        try {
            return Float.parseFloat(values.getProperty(key));
        } catch (NumberFormatException ex) {
        }
        return 0;
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
        values.setProperty(key, Double.toString(value));
        synchronize();
    }

    /**
     * Returns the double number of the specified key.
     *
     * @param key The key for which double number is requested.
     * @return The double number of the specified key.
     */
    @CMSelector("- (double)doubleForKey:(NSString *)defaultName;")
    public double doubleForKey(String key) {
        try {
            return Double.parseDouble(values.getProperty(key));
        } catch (NumberFormatException ex) {
        }
        return 0;
    }

    /**
     * Returns the string of the specified key.
     *
     * @param key The key for which the string is requested.
     * @return The string of the specified key.
     */
    @CMSelector("- (NSString *)stringForKey:(NSString *)defaultName;")
    public String stringForKey(String key) {
        return values.getProperty(key);
    }

    /**
     * Returns the data object of the specified key.
     *
     * @param key The key whose data object is requested.
     * @return The data object of the specified key.
     */
    @CMSelector("- (NSData *)dataForKey:(NSString *)defaultName;")
    public NSData dataForKey(String key) {
        String val = values.getProperty(key);
        if (val == null || !val.startsWith(NSDATA_PREFIX))
            return null;
        return new NSData(MiGBase64.decode(val.substring(NSDATA_PREFIX.length())));
    }

    /**
     * Removes the specified key from the dictionary.
     *
     * @param key The key that is removed.
     */
    @CMSelector("- (void)removeObjectForKey:(NSString *)defaultName")
    public void removeObjectForKey(String key) {
        values.remove(key);
    }
}
