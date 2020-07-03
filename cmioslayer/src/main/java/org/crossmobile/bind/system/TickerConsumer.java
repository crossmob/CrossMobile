/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

public interface TickerConsumer {

    void start();

    void apply(double progress);

    void end();
}
