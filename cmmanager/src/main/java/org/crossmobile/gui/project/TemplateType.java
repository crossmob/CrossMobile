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
package org.crossmobile.gui.project;

import org.crossmobile.gui.actives.ActiveIcon;

import javax.swing.*;

public enum TemplateType {
    BUTTON_PROJECT,
    NAVIGATION_PROJECT,
    TABLE_PROJECT,
    STORYBOARD_PROJECT,
    I18N_PROJECT,
    CAMERA_PROJECT,
    MAP_PROJECT,
    SINGLE_PROJECT,
    EMPTY_PROJECT;

    public final String actual;

    TemplateType() {
        String name = name();
        actual = name.substring(0, name.indexOf('_')).toLowerCase();
    }

    public Icon icon() {
        return new ActiveIcon("images/" + actual + "_project");
    }
}
