/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.bind.system.i18n;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;
import crossmobile.ios.foundation.NSBundle;
import crossmobile.ios.foundation.NSString;
import crossmobile.ios.foundation.NSStringEncoding;
import org.crossmobile.bind.system.i18n.I18NSelf.NumberTest;
import org.crossmobile.bridge.ann.CMLib;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.crossmobile.bind.system.SystemUtilities.findLocalizedPath;
import static org.crossmobile.bridge.ann.CMLibTarget.JAVA;
import static org.crossmobile.bridge.system.I18Nparser.*;

@SuppressWarnings("Java8MapApi")
@CMLib(name = "cmi18n", target = JAVA, displayName = "I18N support for Java", description = "CrossMobile© iOS compatible i18n support")
public class I18N {

    private static final Map<String, Collection<StringsDict>> dictBook = new HashMap<>();   // Index of StringsDict based on NSLocalizedString (with equality)
    private static final Pattern PARAMETER = Pattern.compile("%([0-9]+\\$)?#@(.+?)@");
    private static final Object[] EMPTY = new Object[]{};


    private static Map<String, Map<String, Map<String, StringsDict>>> allData = new HashMap<>();  // bundle/table/key/value

    static String localizedString(NSBundle bundle, String key, String table) {
        Map<String, Map<String, StringsDict>> bundleMap = allData.get(bundle.bundlePath());
        if (bundleMap == null)
            allData.put(bundle.bundlePath(), bundleMap = new HashMap<>());
        Map<String, StringsDict> tableMap = bundleMap.get(table);
        // Load map in memory if not existed
        if (tableMap == null) {
            String path = findLocalizedPath(bundle, table, "stringsdict", null);
            if (path == null)
                path = findLocalizedPath(bundle, table, "strings", null);
            bundleMap.put(table, tableMap = populateFromJson(path));
        }
        StringsDict found = tableMap.get(key);
        return found == null ? null : found.format;  // use absolute equality to check for key, thus returning actual format
    }

    /**
     * Load a JSON-ised strings(dict) file
     *
     * @param path the location of the JSON file
     * @return the result StringsDict map, never null
     */
    public static Map<String, StringsDict> populateFromJson(String path) {
        Map<String, StringsDict> dictMap = new HashMap<>();

        if (path == null)
            return dictMap;
        String data = NSString.stringWithContentsOfFile(path, NSStringEncoding.UTF8, null);
        if (data == null)
            return dictMap;
        JsonValue root = Json.parse(data);
        if (!root.isObject())
            return dictMap;

        for (String translationKey : root.asObject().names()) {
            JsonValue translation = root.asObject().get(translationKey);
            if (translation.isString()) {
                // from plain strings file
                String format = translation.asString();
                StringsDict sd = StringsDict.generateInDictBook(format, false);
                dictMap.put(translationKey, sd);
            } else if (translation.isObject()) {
                // from stringsdict file
                String format = translation.asObject().getString(FORMAT, null);
                if (format == null)
                    continue;
                StringsDict sd = StringsDict.generateInDictBook(format, true);
                dictMap.put(translationKey, sd);
                for (String field : translation.asObject().names()) {
                    if (field.equals(FORMAT))
                        continue;
                    JsonValue forms = translation.asObject().get(field);
                    if (!forms.isObject())
                        continue;
                    Map<String, String> entry = sd.createEntry(field);
                    for (String form : forms.asObject().names()) {
                        JsonValue val = forms.asObject().get(form);
                        if (val.isString())
                            entry.put(form, val.asString());
                    }
                }
            }
        }
        return dictMap;
    }

    static void ping() {
    }

    /**
     * The data structure of the StringsDict entry
     */
    public static class StringsDict {
        public final String format;
        private Map<String, Map<String, String>> entries;

        /**
         * Generate a StringsDict and reverse-store it in dictBook, to be able to perform exact String
         * matches, not based on equals() method
         *
         * @param format the format of this StringsDict entry
         * @return the StringsDict entry
         */
        private static StringsDict generateInDictBook(String format, boolean requiresExactString) {
            StringsDict dict = new StringsDict(format);
            if (requiresExactString) {
                Collection<StringsDict> inRepo = dictBook.get(format);
                if (inRepo == null)
                    dictBook.put(format, inRepo = new ArrayList<>());
                inRepo.add(dict);
            }
            return dict;
        }

        /**
         * Retrieve a StringsDict entry, by format. This is based on equlity of the reference String,
         * not on equals() method, to be en-par with the iOS implementation.
         *
         * @param format the format of the StringsDict entry we search for
         * @return The corresponding StringsDict entry
         */
        @SuppressWarnings("StringEquality") // that's what it does
        public static StringsDict retrieve(String format) {
            Collection<StringsDict> inRepo = dictBook.get(format);
            if (inRepo != null)
                for (StringsDict sd : inRepo)
                    if (sd.format == format)
                        return sd;
            return null;
        }

        private StringsDict(String format) {
            this.format = format;
        }

        Map<String, String> createEntry(String field) {
            if (entries == null)
                entries = new HashMap<>();
            Map<String, String> entry = new HashMap<>();
            entries.put(field, entry);
            return entry;
        }

        /**
         * Format this StringsDict entry, based on the provided arguments
         *
         * @param args the list of arguments
         * @return the formatted String
         */
        public String getFormat(NumberTest few, NumberTest many, Object... args) {
            return entries == null ? format : getFormat(format, few, many, args == null ? EMPTY : args);
        }

        /**
         * One level format this StringsDict entry, based on the provided arguments and the format-up-to-now.
         * This is a recursive method, through getFormatParam method.
         *
         * @param current the up-to-now formatted String.
         * @param args    the list of arguments
         * @return the partially formatted String
         */
        private String getFormat(String current, NumberTest few, NumberTest many, Object... args) {
            Matcher match = PARAMETER.matcher(current);
            MatchGroup found = null;
            while (match.find()) {
                if (found == null)
                    found = new MatchGroup();
                found.add(getIndex(match.group(1)), match.group(2), match.start(), match.end());
            }
            if (found != null) {
                found.fixIndices(args.length);
                for (MatchFinder part : found.groups()) {
                    current = current.substring(0, part.start) +
                            getFormatParam(part.param, part.index, few, many, args) +
                            current.substring(part.end);
                }
            }
            return current;
        }

        /**
         * Retrieve a parameter value and replace it with it's corespondent value. This method recurses
         * with the getFormat, when a proper format was found.
         *
         * @param param The name of the parameter
         * @param index it's index on args
         * @param args  the list of arguments
         * @return the formatted version of this parameter
         */
        private String getFormatParam(String param, int index, NumberTest few, NumberTest many, Object... args) {
            Map<String, String> entry = entries.get(param);
            if (entry != null && args.length != 0) {
                // Normalize index
                index--;    // index is 1-based, while args is 0-based
                if (index < 0)
                    index = 0;
                int numeric = getNumberFromObject(args[index]);
                if (numeric >= 0) {
                    String newFormat = entry.get(getTagFromNumber(numeric, few, many));
                    if (newFormat != null)
                        return getFormat(newFormat, few, many, args);
                    newFormat = entry.get(OTHER);
                    if (newFormat != null)
                        return getFormat(newFormat, few, many, args);
                    newFormat = entry.get(String.valueOf(numeric));
                    if (newFormat != null)
                        return getFormat(newFormat, few, many, args);
                }
            }
            return "%" + (index + 1) + "$#@" + param + "@";
        }

        /**
         * Convert an unknown argument to number
         *
         * @param arg the argument, could be any kind of object
         * @return the converted integer
         */
        private int getNumberFromObject(Object arg) {
            int num = -1;
            if (arg instanceof Double || arg instanceof Float) {
                double dnum = (arg instanceof Double) ? (Double) arg : ((Float) arg).doubleValue();
                if (dnum < 0)
                    num = -1;
                else if (dnum >= Integer.MAX_VALUE)
                    num = Integer.MAX_VALUE;
                else if (Math.abs(dnum - (int) dnum) < 0.00001)
                    num = (int) dnum;
                else
                    num = -1;
            } else if (arg instanceof Number)
                num = ((Number) arg).intValue();
            return num;
        }

        /**
         * Convert a number to a numeric tag
         *
         * @param num the number
         * @return the tag to used in order to retrieve the localized value
         */
        private String getTagFromNumber(int num, NumberTest few, NumberTest many) {
            if (num == 0)
                return ZERO;
            else if (num == 1)
                return ONE;
            else if (num == 2)
                return TWO;
            else if (few != null && few.accept(num))
                return FEW;
            else if (many != null && many.accept(num))
                return MANY;
            else
                return OTHER;
        }

        /**
         * Convert a textual representation of number to an integer, or -1 if null
         *
         * @param textual the textual representation of the number
         * @return the integer value of the number
         */
        private static int getIndex(String textual) {
            if (textual == null)
                return -1;
            return Integer.parseInt(textual.substring(0, textual.length() - 1));
        }
    }

    /**
     * A struct to temporary store the locations of the found parameters
     */
    private static class MatchFinder {
        private final int start;
        private final int end;
        private int index;
        private final String param;

        private MatchFinder(int index, String param, int start, int end) {
            this.index = index;
            this.param = param;
            this.start = start;
            this.end = end;
        }
    }

    /**
     * The location of all found parameters in the format
     */
    private static class MatchGroup {
        private List<MatchFinder> finders = new ArrayList<>();

        /**
         * Add a new parameter
         *
         * @param index the index of the parameter in the args variable
         * @param value the name of the parameter
         * @param start the start location in the format String
         * @param end   the end location in the format String
         */
        private void add(int index, String value, int start, int end) {
            finders.add(new MatchFinder(index, value, start, end));
        }

        /**
         * Replace invalid or unknown indices with valid ones
         *
         * @param maxIndex the maximum number of index, 1-based
         */
        private void fixIndices(int maxIndex) {
            //noinspection StatementWithEmptyBody
            if (finders.size() <= 0) {
            } else if (finders.size() == 1) {
                MatchFinder item = finders.get(0);
                if (item.index <= 0)
                    item.index = 1;
                else if (item.index > maxIndex)
                    item.index = maxIndex;
            } else {
                List<Integer> order = new ArrayList<>();
                for (int i = finders.size(); i > 0; i--)
                    order.add(i);
                for (MatchFinder f : finders)
                    if (f.index < 0)
                        f.index = order.remove(order.size() - 1);
                    else if (f.index > maxIndex)
                        f.index = maxIndex;
                    else
                        order.remove((Integer) f.index);
            }
        }

        /**
         * Create an iterator of the parameters. It is in inverse order, thus it is possible to
         * iterate on the format and properly replace the parameters.
         *
         * @return the inverse iterator
         */
        private Iterable<MatchFinder> groups() {
            return () -> new Iterator<MatchFinder>() {
                int idx = finders.size();

                @Override
                public boolean hasNext() {
                    return idx > 0;
                }

                @Override
                public MatchFinder next() {
                    idx--;
                    return finders.get(idx);
                }
            };
        }
    }
}
