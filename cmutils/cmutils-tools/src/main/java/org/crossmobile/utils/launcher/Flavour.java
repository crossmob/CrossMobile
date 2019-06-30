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
package org.crossmobile.utils.launcher;

import java.util.List;
import java.util.function.Consumer;

import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.TextUtils.iteratorToString;

public enum Flavour {
    DESKTOP("Swing"),
    IOS("IOS"),
    ANDROID("Android"),
    UWP("UWP");

    private static final String packg_pre = "org.crossmobile.backend.";
    private static final String packg_mid = ".Native";
    public final String launcher;

    Flavour(String name) {
        this.launcher = packg_pre + name.toLowerCase() + packg_mid + name;
    }

    public String getProfileName() {
        return name().toLowerCase();
    }

    public static Flavour getFlavour(List<String> profiles) {
        Flavour flavour = null;
        for (String prof : profiles)
            try {
                if (prof.equals(prof.toLowerCase())) {
                    Flavour next = Flavour.valueOf(prof.toUpperCase());
                    if (next != null)
                        if (flavour == null)
                            flavour = next;
                        else
                            throw new RuntimeException("Only one profile should be specified");
                }
            } catch (IllegalArgumentException e) {
            }
        if (flavour == null)
            throw new RuntimeException(
                    "\nOne of the following profiles should be selected: " + iteratorToString(asList(Flavour.values()).iterator(), " ", f -> f.name().toLowerCase())
                            + "\nFor example, if build is performed from command line, this could be done with the "
                            + iteratorToString(asList(Flavour.values()).iterator(), " or ", f -> "-P" + f.name().toLowerCase()) + " option.\n"
                            + "If an IDE has been used, then the correct profile should be selected.\n"
                            + "For more info, please refer to https://crossmobile.tech/run/\n");
        return flavour;
    }
}
