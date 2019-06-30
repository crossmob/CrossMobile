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
