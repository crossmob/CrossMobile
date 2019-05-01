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

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * UITabBarItem class defines an object that represents an item of a tab bar.
 */
@CMClass
public class UITabBarItem extends UIBarItem {

    private String badgeValue;

    UITabBarItem() {
        this(null, null, 0);
    }

    /**
     * Constructs and returns a new UITabBarItem with the specified properties.
     *
     * @param title The title of UITabBarItem.
     * @param image The image of UITabBarItem.
     * @param tag   The tag of UITabBarItem
     */
    @CMConstructor("- (instancetype)initWithTitle:(NSString *)title\n"
            + "                        image:(UIImage *)image\n"
            + "                          tag:(NSInteger)tag")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UITabBarItem(String title, UIImage image, int tag) {
        super(false, null);
        setTitle(title);
        setImage(image);
        setTag(tag);
    }

    /**
     * Returns the text that is displayed in the top-right position of an item
     * encircled by an red oval border.
     *
     * @return The text that is displayed in the top-right position of an item
     * encircled by an red oval border.
     */
    @CMGetter("@property(nonatomic, copy) NSString *badgeValue;")

    public String badgeValue() {
        return badgeValue;
    }

    /**
     * Sets the text displayed in the top-right position of an item encircled by
     * an red oval border.
     *
     * @param badgeValue The text displayed in the top-right position of an item
     *                   encircled by an red oval border.
     */
    @CMSetter("@property(nonatomic, copy) NSString *badgeValue;")
    public void setBadgeValue(String badgeValue) {
        this.badgeValue = badgeValue;
    }

}
