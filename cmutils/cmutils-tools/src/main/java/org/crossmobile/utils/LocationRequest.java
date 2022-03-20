/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
