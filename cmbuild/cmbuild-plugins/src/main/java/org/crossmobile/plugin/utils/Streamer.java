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
package org.crossmobile.plugin.utils;

import java.io.File;
import java.io.IOException;

public interface Streamer {

    Streamer append(CharSequence text) throws IOException;

    default Streamer append(char c) throws IOException {
        return append(Character.toString(c));
    }

    Streamer tab();

    Streamer untab();

    static Streamer asHeader(File root, String name) {
        return new FileStreamer(new File(root, name + ".h"));
    }

    static Streamer asBody(File root, String name) {
        return new FileStreamer(new File(root, name + ".m"));
    }

    static Streamer asString() {
        return new StringStreamer(new StringBuilder());
    }

}
