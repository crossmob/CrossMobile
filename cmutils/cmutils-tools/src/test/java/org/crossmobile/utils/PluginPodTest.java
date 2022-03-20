/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PluginPodTest {
    @Test
    public void testFreezeUnfreeze() {
        testPod(new PluginPod(":m\n;ame|", "\tm;in", "|||m|ax"));
        testPod(new PluginPod("Aaa", "", ""));
        testPod(new PluginPod("", "Bbb", ""));
        testPod(new PluginPod("", "", "Ccc"));
        testPod(new PluginPod("Aaa", "", "Ccc"));
        testPod(new PluginPod("", "", ""));
    }

    private static void testPod(PluginPod pod) {
        String freezed = pod.freeze();
        PluginPod unfreezed = PluginPod.unfreeze(freezed);
        assertEquals(pod.getName(), unfreezed.getName());
        assertEquals(pod.getMinVersion(), unfreezed.getMinVersion());
        assertEquals(pod.getMaxVersion(), unfreezed.getMaxVersion());
    }
}
