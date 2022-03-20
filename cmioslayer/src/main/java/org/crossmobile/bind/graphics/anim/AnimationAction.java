/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.anim;

public interface AnimationAction {

    void start();

    void apply(double progress);

    void end();
}
