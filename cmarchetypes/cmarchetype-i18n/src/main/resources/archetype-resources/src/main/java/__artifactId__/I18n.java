/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.foundation.NSBundle;
import crossmobile.ios.foundation.NSString;

@SuppressWarnings("WeakerAccess")
public class I18n {
    public static String _l(String text, Object... params) {
        return NSString.localizedStringWithFormat(NSBundle.mainBundle().localizedStringForKey(text, null, null), params);
    }
}
