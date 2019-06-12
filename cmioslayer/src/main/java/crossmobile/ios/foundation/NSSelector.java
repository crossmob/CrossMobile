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

import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMTarget;

/**
 * A Java mapping of the Objective-C Selector construct
 *
 * @param <G> The argument type of this selector
 */
@CMTarget
public interface NSSelector<G> {

    /**
     * Execute this selector
     *
     * @param arg the argument of the selector
     */
    @CMSelector(("-(void) exec:(id) argument;"))
    void exec(G arg);
}
