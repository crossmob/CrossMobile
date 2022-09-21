/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.prefs.Prefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamList {

    private static final Pattern VARIABLES = Pattern.compile("\\$\\{(.+?)\\}");
    private static final Pattern PROJECT = Pattern.compile("@\\[(.+?)\\]@");

    private final ParamSet paramset = new ParamSet();
    private final Properties props = paramset.getDefaults();

    public void updateFromProperties(File file) {
        if (file.isFile())
            try {
                props.load(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                String sdkDir = Prefs.getAndroidSDKLocation();
                String givenSdkDir = props.getProperty("sdk.dir", "");
                if (!sdkDir.trim().isEmpty() && new File(sdkDir).isDirectory() && (givenSdkDir.trim().isEmpty() || !new File(givenSdkDir).isDirectory()))
                    props.put("sdk.dir", Prefs.getAndroidSDKLocation());
            } catch (IOException ignored) {
            }
    }

    public void updateFromPom(Pom pomFile) throws ProjectException {
        pomFile.updatePropertiesFromPom(props);
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

    public final ParamList put(Param key, String value) {
        props.put(key.name, value);
        return this;
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
