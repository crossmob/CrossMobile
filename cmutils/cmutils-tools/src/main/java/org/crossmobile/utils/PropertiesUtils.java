/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.Map;

import static org.crossmobile.utils.TextUtils.NL;

public class PropertiesUtils {

    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String mapToString(Map<String, String> map, String comment) {
        StringBuilder out = new StringBuilder();
        if (comment != null)
            out.append("# ").append(comment).append(NL);
        for (String key : map.keySet())
            out.append(safe(key, true)).append('=').append(safe(map.get(key), false)).append(NL);
        return out.toString();
    }

    private static String safe(String input, boolean key) {
        if (input.isEmpty())
            return "";
        StringBuilder out = new StringBuilder(input.length() * 2);
        if (!key && input.charAt(0) == ' ')
            out.append('\\');
        for (char c : input.toCharArray())
            switch (c) {
                case ' ':
                    if (key)
                        out.append('\\');
                    out.append(' ');
                    break;
                case '\\':
                    out.append('\\').append('\\');
                    break;
                case '\n':
                    out.append('\\').append('n');
                    break;
                case '\r':
                    out.append('\\').append('r');
                    break;
                case '\t':
                    out.append('\\').append('t');
                    break;
                case '\f':
                    out.append('\\').append('f');
                    break;
                case '!':
                case '#':
                case ':':
                case '=':
                    out.append('\\').append(c);
                    break;
                default:
                    if (c >= ' ' && c <= '~')
                        out.append(c);
                    else {
                        out.append('\\').append('u');
                        out.append(HEX[(c >>> 12) & 0xF]).append(HEX[(c >> 8) & 0xF]).append(HEX[(c >> 4) & 0xF]).append(HEX[c & 0xF]);
                    }
            }
        return out.toString();
    }

}
