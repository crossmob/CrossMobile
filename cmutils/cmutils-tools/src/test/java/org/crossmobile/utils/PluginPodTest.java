/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
