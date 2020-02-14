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
package org.crossmobile.plugin;

import java.io.File;

public class Repository {

    String id = "userplugins";
    String name = "User Plugins";
    String url;
    File file;
    boolean cleanEntries = false;

    public String getId() {
        return id;
    }

    public File getFile() {
        return file;
    }

    public boolean isCleanEntries() {
        return cleanEntries;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
