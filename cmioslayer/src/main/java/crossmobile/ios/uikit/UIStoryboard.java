/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSBundle;
import crossmobile.ios.foundation.NSLocale;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.system.init.PluginsLauncherList;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import static org.crossmobile.bind.system.SystemUtilities.safeInstantiation;


@CMClass
public class UIStoryboard extends NSObject {
    private static final String IBObjectPackage = PluginsLauncherList.class.getPackage().getName();

    @CMSelector("+ (UIStoryboard *)storyboardWithName:(NSString *)name \n" +
            "                              bundle:(NSBundle *)storyboardBundleOrNil;")
    public static UIStoryboard storyboardWithName(String name, NSBundle storyboardBundleOrNil) {
        String canonicalName = (name + ".storyboard")
                .replace("\\", "_")
                .replace("/", "_")
                .replace(".", "_")
                .replace(" ", "_");
        String lang = NSLocale.currentLocale().languageCode();
        UIStoryboard storyBoard = safeInstantiation(IBObjectPackage + ".IBObjects$" + lang + "_lproj_" + canonicalName);
        if (storyBoard == null)
            storyBoard = safeInstantiation(IBObjectPackage + ".IBObjects$Base_lproj_" + canonicalName);
        if (storyBoard == null)
            storyBoard = safeInstantiation(IBObjectPackage + ".IBObjects$" + canonicalName);

        if (storyBoard == null) {
            String bundleName = storyboardBundleOrNil == null ? "main bundle" : "bundle at " + storyboardBundleOrNil.bundlePath();
            Native.system().error("Could not find a storyboard named '" + name + "' in " + bundleName, null);
        }
        return storyBoard;
    }

    @CMSelector("- (__kindof UIViewController *)instantiateViewControllerWithIdentifier:(NSString *)identifier;")
    public UIViewController instantiateViewControllerWithIdentifier(String identifier) {
        return null;
    }

    @CMSelector("- (__kindof UIViewController *)instantiateInitialViewController;")
    public UIViewController instantiateInitialViewController() {
        return null;
    }

}
