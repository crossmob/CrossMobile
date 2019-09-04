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
package org.crossmobile.utils;

import java.io.File;
import java.util.function.Consumer;

public class LocationRequest {

    private final LocationTarget target;
    private final String currentLocation;
    private final Consumer<File> foundFile;

    LocationRequest(LocationTarget target, String currentLocation, Consumer<File> foundFile) {
        this.target = target;
        this.currentLocation = currentLocation;
        this.foundFile = foundFile;
    }

    String getCurrentLocation() {
        return currentLocation;
    }

    String getApplicationName() {
        return target.getApplicationName();
    }

    void checkFile(File file) {
        target.checkFile(file, foundFile);
    }
}
