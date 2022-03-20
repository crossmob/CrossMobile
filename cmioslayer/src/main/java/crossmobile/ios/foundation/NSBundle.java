/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.i18n.I18NBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

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
        this.path = path.length() > 1 && path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
    }

    /**
     * Returns the bundle that corresponds to the specified path.
     *
     * @param fullPath The path for which the bundle is requested.
     * @return The bundle that corresponds to the specified path or null if the path is invalid
     */
    @CMSelector("+ (instancetype)bundleWithPath:(NSString *)path;")
    public static NSBundle bundleWithPath(String fullPath) {
        return NSFileManager.defaultManager().fileExistsAtPath(fullPath) ? new NSBundle(fullPath) : null;
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
        if (resource == null || resource.isEmpty())
            return null;
        resource = type == null ? resource : resource + "." + type;
        resource = directory == null ? resource : directory + "/" + resource;

        String resourcePath = path + "/" + resource;
        if (NSFileManager.defaultManager().fileExistsAtPath(resourcePath))
            return resourcePath;
        resourcePath = path + "/" + NSLocale.currentLocale().languageCode() + ".lproj/" + resource;
        if (NSFileManager.defaultManager().fileExistsAtPath(resourcePath))
            return resourcePath;
        resourcePath = path + "/Base.lproj/" + resource;
        if (NSFileManager.defaultManager().fileExistsAtPath(resourcePath))
            return resourcePath;
        return null;
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
     * Return a NSURL given a resource name and extension, under specific subdirectory
     *
     * @param name    the name of the resource
     * @param ext     the extension of the resource
     * @param subpath the subdirectory where this resource exists
     * @return the NSURL of this resource
     */
    @CMSelector("- (NSURL *)URLForResource:(NSString *)name \n" +
            "            withExtension:(NSString *)ext \n" +
            "             subdirectory:(NSString *)subpath;\n")
    public NSURL URLForResource(String name, String ext, String subpath) {
        return NSURL.fileURLWithPath(pathForResource(name, ext, subpath));
    }

    /**
     * Return a NSURL given a resource name and extension
     *
     * @param name the name of the resource
     * @param ext  the extension of the resource
     * @return the NSURL of this resource
     */
    @CMSelector("- (NSURL *)URLForResource:(NSString *)name \n" +
            "            withExtension:(NSString *)ext;\n")
    public NSURL URLForResource(String name, String ext) {
        return URLForResource(name, ext, null);
    }

    /**
     * The full path of this bundle.
     *
     * @return the full path of this bundle.
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
