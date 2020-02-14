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
