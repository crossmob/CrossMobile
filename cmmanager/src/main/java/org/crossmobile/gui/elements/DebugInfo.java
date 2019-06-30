/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.gui.elements;

public class DebugInfo {
    public final String output;
    public final String error;
    public final String appId;

    public DebugInfo(String output, String error, String appId) {
        this.output = output;
        this.error = error;
        this.appId = appId;
    }

    public static boolean streamsHaveTraces(String... texts) {
        for (String text : texts)
            for (String line : text.split("[\n|\r]"))
                if (line.trim().startsWith("at crossmobile.ios."))
                    return true;
        return false;
    }

    public interface Provider {
        DebugInfo getDebugInfo();
    }

    public interface Consumer {
        void updateTo(String outStream, String errorStream);
    }
}
