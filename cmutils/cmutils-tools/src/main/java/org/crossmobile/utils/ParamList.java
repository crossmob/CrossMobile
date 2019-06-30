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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.crossmobile.gui.parameters.impl.GroupIdParameter;

public class ParamList {

    private static final Pattern VARIABLES = Pattern.compile("\\$\\{(.+?)\\}");
    private static final Pattern PROJECT = Pattern.compile("@\\[(.+?)\\]@");

    private final ParamSet paramset = new ParamSet();
    private final Properties props = paramset.getDefaults();

    public boolean updateFromProperties(File file) throws ProjectException {
        if (file.isFile())
            try {
                props.load(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                return true;
            } catch (IOException ex) {
            }
        return false;
    }

    public boolean updateFromPom(File pom) throws ProjectException {
        if (pom.exists())
            return new Pom(pom).updatePropertiesFromPom(props);
        return true;
    }

    public String get(Param tag) {
        return get(tag, false);
    }

    public String get(Param tag, boolean escaped) {
        return get(tag.name, escaped);
    }

    private String get(String tagkey, boolean escaped) {
        if (escaped)
            return StringEscapeUtilsTrimmed.escapeJava(props.getProperty(tagkey));
        else
            return props.getProperty(tagkey);
    }

    public final void put(Param key, String value) {
        props.put(key.name, value);
    }

    public void remove(Param key) {
        props.remove(key.name);
    }

    public void putIfMissing(Param key, String value) {
        if (key == null)
            return;
        if (get(key) == null)
            put(key, value);
    }

    public String dereferenceProperty(Param key) {
        return dereferenceProperty(key, false);
    }

    public String dereferenceProperty(Param key, boolean useSystemProps) {
        if (key == null)
            return null;
        return dereferenceProperty(key.name, useSystemProps);
    }

    public String dereferenceProperty(String key) {
        return dereferenceProperty(key, false);
    }

    public String dereferenceProperty(String key, boolean useSystemProps) {
        String val;
        if (key == null || (val = get(key, false)) == null)
            return null;
        return dereferenceValue(val, useSystemProps);
    }

    public String dereferenceValue(String val, boolean useSystemProps) {
        if (val == null)
            return null;

        // Dereference properties
        Matcher m = VARIABLES.matcher(val);
        while (m.find()) {
            String to = props.getProperty(m.group(1));
            if (to == null) {
                if (useSystemProps)
                    to = System.getProperty(m.group(1));
                if (to == null)
                    to = "@[" + m.group(1) + "]@";  // Protect this match
            }
            val = val.substring(0, m.start()) + to + val.substring(m.end());
            m.reset(val);
        }

        // Dereference protected properties
        m = PROJECT.matcher(val);
        while (m.find()) {
            val = val.substring(0, m.start()) + "${" + m.group(1) + "}" + val.substring(m.end());
            m.reset(val);
        }
        return val;
    }

    public Properties getProperties() {
        return props;
    }

    public ParamSet getParamset() {
        return paramset;
    }

}
