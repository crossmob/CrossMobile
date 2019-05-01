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
package crossmobile.ios.quartzcore;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * CATransition class defines transition animations for layers.
 */
@CMClass
public abstract class CATransition extends CAAnimation {

    /**
     * The layer's content is fading out.
     */
    public static final String Fade = "fade";

    /**
     * The layer's content is sliding in.
     */
    public static final String MoveIn = "moveIn";

    /**
     * The layer's content pushes any existing content and slides in.
     */
    public static final String Push = "push";

    /**
     * The layer content is gradually revealing.
     */
    public static final String Reveal = "reveal";

    /**
     * The transition from right.
     */
    public static final String FromRight = "fromRight";

    /**
     * The transition from left.
     */
    public static final String FromLeft = "fromLeft";

    /**
     * The transition from top.
     */
    public static final String FromTop = "fromTop";

    /**
     * The transition from bottom.
     */
    public static final String FromBottom = "fromBottom";

    //
    private float startProgress = 0;
    private float endProgress = 1;
    private String type = Fade;
    private String subtype = null;

    /**
     * Returns a number that represents the starting point of this CATransition.
     *
     * @return The starting point of this CATransition.
     */
    @CMGetter("@property float startProgress;")
    public float startProgress() {
        return startProgress;
    }

    /**
     * Sets a number that represents the starting point of this CATransition.
     *
     * @param startProgress The starting point of this CATransition.
     */
    @CMSetter("@property float startProgress;")
    public void setStartProgress(float startProgress) {
        if (startProgress < 0)
            startProgress = 0;
        if (startProgress > 1)
            startProgress = 1;
        this.startProgress = startProgress;
    }

    /**
     * Returns a number that represents the ending point of this CATransition.
     *
     * @return The ending point of this CATransition.
     */
    @CMGetter("@property float endProgress;")
    public float endProgress() {
        return endProgress;
    }

    /**
     * Sets a number that represents the ending point of this CATransition.
     *
     * @param endProgress The ending point of this CATransition.
     */
    @CMSetter("@property float endProgress;")
    public void setEndProgress(float endProgress) {
        if (endProgress < 0)
            endProgress = 0;
        if (endProgress > 1)
            endProgress = 1;
        this.endProgress = endProgress;
    }

    /**
     * Returns the default transition type.
     *
     * @return The default transition type.
     */
    @CMGetter("@property(copy) NSString *type;")
    public String type() {
        return type;
    }

    /**
     * Sets the default transition type.
     *
     * @param type The default transition type.
     */
    @CMSetter("@property(copy) NSString *type;")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the optional subtype of the direction for the predefined
     * transition.
     *
     * @return The optional subtype of the direction for the predefined
     * transition.
     */
    @CMGetter("@property(copy) NSString *subtype;")
    public String subtype() {
        return subtype;
    }

    /**
     * Sets the optional subtype of the direction for the predefined transition.
     *
     * @param subtype The optional subtype of the direction for the predefined
     *                transition.
     */
    @CMSetter("@property(copy) NSString *subtype;")
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
