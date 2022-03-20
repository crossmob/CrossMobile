/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.io.File;

public class ProjectException extends Exception {

    private final File projectLocation;

    public ProjectException() {
        this(null, null, null);
    }

    public ProjectException(String message) {
        this(message, null, null);
    }

    public ProjectException(String message, File projectLocation) {
        this(message, projectLocation, null);
    }

    public ProjectException(Throwable cause) {
        this(null, null, cause);
    }

    public ProjectException(String message, Throwable cause) {
        this(message, null, cause);
    }

    public ProjectException(String message, File projectLocation, Throwable cause) {
        super(message, cause);
        this.projectLocation = projectLocation;
    }

    public File getProjectLocation() {
        return projectLocation;
    }

    @Override
    public String getMessage() {
        return projectLocation == null
                ? super.getMessage()
                : super.getMessage() + "\n'" + projectLocation.getAbsolutePath() + "'";
    }

}
