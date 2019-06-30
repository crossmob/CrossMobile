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
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.parameters.MultiCheckboxParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.CM_KEYBOARD_SUPPORT;

public class KeyboardSupportParameter extends MultiCheckboxParameter {

    private static final char SEPERATOR = ':';

    public KeyboardSupportParameter(ParamList list) {
        super(list, CM_KEYBOARD_SUPPORT.tag(),
                new String[]{"quit", "pause", "back", "menu", "home", "rotate", "multitouch"},
                new String[]{"Quit emulator", "Pause emulator", "Back button", "Menu button", "Home button", "Rotate", "Multitouch"},
                getValue(list.get(CM_KEYBOARD_SUPPORT.tag())), 4, SEPERATOR);
    }

    @Override
    public String getVisualTag() {
        return "Keyboard support:";
    }

    private static String getValue(String value) {
        if (value == null)
            return "";
        else if (value.equals("all"))
            return "quit:pause:back:menu:home:rotate:multitouch";
        return value;
    }
}
