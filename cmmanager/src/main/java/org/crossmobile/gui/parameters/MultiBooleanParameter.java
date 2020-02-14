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
package org.crossmobile.gui.parameters;

import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract class MultiBooleanParameter extends ProjectParameter {

    private final String[] parameter;
    private final char separator;
    protected final String[] display;
    protected final String[] tooltips;
    protected boolean[] value;

    public MultiBooleanParameter(ParamList plist, Param key, String[] parameter, String[] display, String textValue, char separator) {
        this(plist, key, parameter, display, null, textValue, separator);
    }

    public MultiBooleanParameter(ParamList plist, Param key, String[] parameter, String[] display, String[] tooltips, String textValue, char separator) {
        super(plist, key);
        if (display == null)
            display = parameter;
        if (parameter.length != display.length)
            throw new ArrayIndexOutOfBoundsException("Size of parameters is " + parameter.length + ", while size of display values is " + display.length);

        this.separator = separator;
        this.value = new boolean[parameter.length];
        this.parameter = parameter;
        this.display = display;
        this.tooltips = tooltips;

        if (textValue == null)
            textValue = plist.get(key);
        if (textValue != null) {
            textValue = textValue.trim();
            if (!textValue.isEmpty()) {
                Set<String> given = new HashSet<>(Arrays.asList(textValue.split(String.valueOf(separator))));
                for (int i = 0; i < parameter.length; i++)
                    value[i] = given.contains(parameter[i]);
            }
        }
    }

    @Override
    public String getValue() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < parameter.length; i++)
            if (value[i])
                b.append(separator).append(parameter[i]);
        String r = b.toString();
        return r.length() > 0 ? r.substring(1) : "";
    }

    protected final void activateValue(String key) {
        for (int i = 0; i < parameter.length; i++)
            if (parameter[i].equals(key)) {
                value[i] = true;
                activateIndex(i);
            }
    }

    protected abstract void activateIndex(int idx);
}
