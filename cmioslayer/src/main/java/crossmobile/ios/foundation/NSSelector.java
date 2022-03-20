/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
