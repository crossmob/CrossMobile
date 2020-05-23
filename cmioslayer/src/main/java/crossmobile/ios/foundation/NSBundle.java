/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.i18n.I18NBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.net.URI;
import java.net.URISyntaxException;

import static org.crossmobile.bind.system.i18n.I18NTest.I18N_SUPPORT;

/**
 * NSBundle class defines an object that represents the code and the resources
 * of the application.
 */
@CMClass
public class NSBundle extends NSObject {
    private static NSBundle mainBundle;
    private final String path;

    private NSBundle(String path) {
        this.path = path;
    }

    /**
     * Returns the bundle that corresponds to the specified path.
     *
     * @param fullpath The path for which the bundle is requested.
     * @return The bundle that corresponds to the specified path.
     */
    @CMSelector("+ (instancetype)bundleWithPath:(NSString *)path;")
    public static NSBundle bundleWithPath(String fullpath) {
        return new NSBundle(fullpath);
    }

    /**
     * Returns the bundle that corresponds to the current executable.
     *
     * @return The bundle of the current executable.
     */
    @CMSelector("+ (NSBundle *)mainBundle;")
    public static NSBundle mainBundle() {
        if (mainBundle == null)
            mainBundle = bundleWithPath(Native.file().getApplicationPrefix());
        return mainBundle;
    }

    /**
     * Returns the full path of the file specified by its subpath and name.
     *
     * @param resource  The resource file.
     * @param type      The type of the file.
     * @param directory The subpath of the file.
     * @return The full path of the specified resource file.
     */
    @CMSelector("- (NSString *)pathForResource:(NSString *)name \n"
            + "                       ofType:(NSString *)ext \n"
            + "                  inDirectory:(NSString *)subpath;")
    public String pathForResource(String resource, String type, String directory) {
        if (directory == null || directory.length() == 0)
            directory = "";
        else if (!directory.endsWith("/"))
            directory += "/";
        if (type != null)
            resource += "." + type;
        String currentpath = directory.startsWith("/")
                ? directory + resource
                : Native.file().getApplicationPrefix() + "/" + directory + resource;
        if (currentpath.startsWith("file:///android_asset")) {
        } else if (currentpath.startsWith("file:/"))
            try {
                currentpath = new URI(currentpath).getPath();
            } catch (URISyntaxException ex) {
                currentpath = currentpath.substring(6);
            }
        else if (currentpath.startsWith("file:"))
            currentpath = currentpath.substring(5);
        return NSFileManager.defaultManager().fileExistsAtPath(currentpath) ? currentpath : null;
    }

    /**
     * Returns the full path of the specified file.
     *
     * @param resource The resource file.
     * @param type     The type of the file.
     * @return The full path of the specified file.
     */
    @CMSelector("- (NSString *)pathForResource:(NSString *)name \n"
            + "                       ofType:(NSString *)ext;")
    public String pathForResource(String resource, String type) {
        return pathForResource(resource, type, null);
    }

    /**
     * The full path of this bundle.
     *
     * @return he full path of this bundle.
     */
    @CMGetter("@property(readonly, copy) NSString *bundlePath;")
    public String bundlePath() {
        return path;
    }

    /**
     * Returns the localized version of the specified String associated with the
     * specified key of the given table.
     *
     * @param key   The key of the String.
     * @param value The initial String.
     * @param table The table of the initial String.
     * @return The localized version of the specified String.
     */
    @CMSelector("- (NSString *)localizedStringForKey:(NSString *)key \n"
            + "                              value:(NSString *)value \n"
            + "                              table:(NSString *)tableName;")
    public String localizedStringForKey(String key, String value, String table) {
        if (table == null || table.isEmpty())
            table = "Localizable";
        String result = I18N_SUPPORT && key != null ? I18NBridge.localizedString(this, key, table) : null;
        if (result != null)   // found
            return result;
        // Not found
        if (key == null)
            return value == null ? "" : value;
        return value == null ? key : value;
    }
}
