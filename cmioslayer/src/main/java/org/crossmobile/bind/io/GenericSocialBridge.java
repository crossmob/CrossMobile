/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.io;

import org.crossmobile.bridge.SocialBridge;

import java.util.HashMap;
import java.util.Map;

public class GenericSocialBridge implements SocialBridge {

    private final Map<String, Handler> handlers = new HashMap<>();

    @Override
    public void registerSocial(String handler, Handler socialHandler) {
        handlers.put(handler, socialHandler);
    }

    @Override
    public Handler getHandler(String handler) {
        return handlers.get(handler);
    }

}
