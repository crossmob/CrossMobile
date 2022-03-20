/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.bridge.system.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.crossmobile.utils.func.ScopeUtils.with;

public class TextUtils {

    public static final String TAB = "    ";
    public final static String NL = "\n";
    private static final String CAPITALIZE_MATCHER = "(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])";
    private static final Pattern SPACE_TRIMMER = Pattern.compile(" \n\t\r\f");

    public static <T> String iteratorToString(Iterator<T> iterator, String delimeter, Function<T, String> converter) {
        StringBuilder out = new StringBuilder();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next != null) {
                String value = converter == null ? next.toString() : converter.apply(next);
                if (value != null)
                    out.append(delimeter).append(value);
            }
        }
        return out.length() < delimeter.length() ? "" : out.substring(delimeter.length());
    }

    public static String iteratorToString(Iterator<String> iterator, String delimeter) {
        return iteratorToString(iterator, delimeter, null);
    }

    public static <T> String iterableToString(Iterable<T> iterable, String delimeter, Function<T, String> converter) {
        return iteratorToString(iterable.iterator(), delimeter, converter);
    }

    public static String iterableToString(Iterable<String> iterable, String delimeter) {
        return iteratorToString(iterable.iterator(), delimeter, null);
    }

    public static List<String> listFromString(String entries, String delimeter) {
        List<String> result = new ArrayList<>();
        if (entries != null) {
            StringTokenizer tk = new StringTokenizer(entries, delimeter);
            while (tk.hasMoreElements()) {
                String value = tk.nextToken().trim();
                if (!value.isEmpty())
                    result.add(value);
            }
        }
        return result;
    }

    public static String plural(int howmany) {
        return plural(howmany, null);
    }

    public static String plural(int howmany, String ext) {
        return howmany == 1 ? "" : ext == null ? "s" : ext;
    }

    public static String capitalize(String input) {
        if (input == null || input.isEmpty())
            return input;
        else if (input.length() == 1)
            return input.toUpperCase();
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String decapitalize(String input) {
        if (input == null || input.isEmpty())
            return input;
        else if (input.length() == 1)
            return input.toLowerCase();
        return input.substring(0, 1).toLowerCase() + input.substring(1);
    }

    public static String repeatString(String what, int howmany) {
        char[] pattern = what.toCharArray();
        char[] res = new char[howmany * pattern.length];
        int length = pattern.length;
        for (int i = 0; i < howmany; i++)
            System.arraycopy(pattern, 0, res, i * length, length);
        return new String(res);
    }

    public static String commonText(String current, String other) {
        if (current == null || other == null)
            return null;
        int max = Math.min(current.length(), other.length());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < max; i++)
            if (current.charAt(i) == other.charAt(i))
                out.append(current.charAt(i));
            else
                break;
        return out.toString();
    }

    public static String[] lowerCase(String[] texts) {
        if (texts == null)
            return null;
        String[] result = new String[texts.length];
        for (int i = 0; i < texts.length; i++)
            if (texts[i] != null)
                result[i] = texts[i].toLowerCase();
        return result;
    }

    public static String[] camelCaseSplit(String text) {
        return camelCaseSplit(text, false);
    }

    public static String[] camelCaseSplit(String text, boolean removeNamespace) {
        String[] split = text.split(CAPITALIZE_MATCHER);
        if (removeNamespace && split.length > 1 && split[0].length() > 3) {
            String[] temp = new String[split.length + 1];
            temp[0] = split[0].substring(0, 2);
            temp[1] = split[0].substring(2);
            System.arraycopy(split, 1, temp, 2, split.length - 1);
            split = temp;
        }
        return split;
    }

    public static int countUpperCase(String data) {
        if (data == null)
            return 0;
        int count = 0;
        for (int i = 0; i < data.length(); i++)
            if (Character.isUpperCase(data.charAt(i)))
                count++;
        return count;
    }

    public static int countLowerCase(String data) {
        if (data == null)
            return 0;
        int count = 0;
        for (int i = 0; i < data.length(); i++)
            if (Character.isLowerCase(data.charAt(i)))
                count++;
        return count;
    }

    public static boolean startsWith(CharSequence base, Collection<? extends CharSequence> prefix) {
        for (CharSequence seq : prefix)
            if (startsWith(base, seq))
                return true;
        return false;
    }

    public static boolean startsWith(CharSequence base, CharSequence prefix, int offset) {
        int prefixPointer = 0;
        int prefixLength = prefix.length();
        if ((offset < 0) || (offset > base.length() - prefixLength))
            return false;
        while (--prefixLength >= 0)
            if (base.charAt(offset++) != prefix.charAt(prefixPointer++))
                return false;
        return true;
    }

    public static boolean startsWith(CharSequence base, CharSequence prefix) {
        return startsWith(base, prefix, 0);
    }

    public static boolean endsWith(CharSequence base, CharSequence suffix) {
        return startsWith(base, suffix, base.length() - suffix.length());
    }

    public static CharSequence trim(CharSequence input) {
        int len = input.length();
        int st = 0;
        char c;
        while ((st < len) && ((c = input.charAt(st)) == ' ' || c == '\t'))
            st++;
        while ((st < len) && ((c = input.charAt(len - 1)) == ' ' || c == '\t'))
            len--;
        return ((st > 0) || (len < input.length())) ? input.subSequence(st, len) : input;
    }

    public static String trimAll(CharSequence input) {
        return SPACE_TRIMMER.matcher(input).replaceAll("");
    }

    public static String safeXML(String text) {
        return text.
                replaceAll("&", "&amp;").
                replaceAll("\"", "&quot;").
                replaceAll("'", "&apos;").
                replaceAll("<", "&lt;").
                replaceAll(">", "&gt;");
    }

    public static int countCharacter(String location, char ch) {
        if (location == null)
            return 0;
        int howmany = 0;
        for (int i = 0; i < location.length(); i++)
            if (location.charAt(i) == ch)
                howmany++;
        return howmany;
    }

    public static String[] split(String input, int size) {
        if (size < 0 || input == null)
            return null;
        String[] chunks = new String[(input.length() + size - 1) / size];
        int loc = 0;
        for (int i = 0; i < chunks.length; i++, loc += size)
            chunks[i] = input.substring(loc, Math.min(input.length(), (i + 1) * size));
        return chunks;
    }

    public static void replaceMultiple(StringBuilder base, String from, String to) {
        int toSize = from.length();
        int found;
        while ((found = base.indexOf(from)) >= 0)
            base.replace(found, found + toSize, to);
    }

    public static String replaceMultiple(CharSequence base, String from, String to) {
        return with(new StringBuilder(base), s -> replaceMultiple(s, from, to)).toString();
    }

    public static String replaceOldString(String oldVar, String newVar, String description) {
        String result = replaceOld(oldVar != null && oldVar.trim().isEmpty() ? null : oldVar, newVar != null && newVar.trim().isEmpty() ? null : newVar, description);
        return result == null ? oldVar : result;
    }

    public static <T> T replaceOld(T oldVar, T newVar, String description) {
        if (newVar != null) {
            if (oldVar != null && !newVar.equals(oldVar))
                Log.error("Duplicate definition of " + description + ", keeping old value " + oldVar + ", instead of " + newVar);
            else
                return newVar;
        }
        return oldVar;
    }

    public static String getPairedParams(String combiner, String separator, Pair<?, ?>... values) {
        StringBuilder out = new StringBuilder();
        if (values != null && values.length > 0)
            for (Pair<?, ?> pair : values)
                if (pair.a != null && pair.b != null) {
                    String a = pair.a.toString();
                    String b = pair.b.toString();
                    if (!a.isEmpty() && !b.isEmpty())
                        out.append(separator).append(pair.a).append(combiner).append(pair.b);
                }
        return out.length() > 0 ? out.substring(separator.length()) : "";
    }

    public static String findMaxInSize(Collection<String> items) {
        String result = "";
        for (String item : items)
            if (result.length() < item.length())
                result = item;
        return result.isEmpty() ? null : result;
    }

    public static List<Integer> listOfInts(String source) {
        StringBuilder next = new StringBuilder();
        List<Integer> out = new ArrayList<>();
        for (char c : source.toCharArray())
            if (c < '0' || c > '9') {
                if (next.length() > 0) {
                    out.add(Integer.parseInt(next.toString()));
                    next.delete(0, next.length());
                }
            } else
                next.append(c);
        if (next.length() > 0)
            out.add(Integer.parseInt(next.toString()));
        return out;
    }

    public static String bytesToHex(byte[] array) {
        if (array == null)
            return null;
        StringBuilder out = new StringBuilder();
        for (byte b : array)
            out.append(numToChar((b & 0xF0) >>> 4)).append(numToChar(b & 0xF));
        return out.toString();
    }

    private static char numToChar(int i) {
        return (char) (i < 10 ? ('0' + i) : ('A' - 10 + i));
    }

    public static Range maxCommon(String base, String key, int minimum_size) {
        if (base == null || key == null)
            return null;
        char[] b = base.toCharArray();
        char[] k = key.toCharArray();
        if (b.length < minimum_size || k.length < minimum_size)
            return null;
        int max = Math.min(b.length, k.length);

        int found, starts, kstart, bstart, size;
        int max_found = 0;
        int max_starts = 0;
        for (int i = minimum_size - k.length; i <= b.length - minimum_size; i++) {    // this is the main looper
            kstart = i < 0 ? -i : 0;    // where k will start searching
            bstart = i < 0 ? 0 : i;     // where b will start searching
            size = Math.min(i < 0 ? k.length - kstart : b.length - bstart, max);    // how many letters to search for

            starts = Integer.MIN_VALUE;
            found = 0;
            for (int j = 0; j < size; j++)
                if (b[bstart + j] == k[kstart + j]) {
                    found++;
                    if (starts == Integer.MIN_VALUE)
                        starts = bstart + j;
                } else {
                    if (found >= minimum_size && found > max_found) {
                        max_found = found;
                        max_starts = starts;
                    }
                    starts = Integer.MIN_VALUE;
                    found = 0;
                }
            if (found >= minimum_size && found > max_found) {
                max_found = found;
                max_starts = starts;
            }
        }
        return max_found > 0 ? new Range(max_starts, max_starts + max_found) : null;
    }

    public static String escape(String input, char escape, Pair<Character, Character>... toBeEscaped) {
        return escape(input, escape, false, toBeEscaped);
    }

    public static String escape(String input, char escape, boolean usuals, Pair<Character, Character>... toBeEscaped) {
        StringBuilder out = new StringBuilder();
        Map<Character, Character> escaped = getEscapedSet(escape, toBeEscaped);
        if (usuals) {
            escaped.put('\n', 'n');
            escaped.put('\r', 'r');
            escaped.put('\t', 't');
            escaped.put('\f', 'f');
        }
        for (char current : input.toCharArray()) {
            Character found = escaped.get(current);
            if (found == null)
                out.append(current);
            else
                out.append(escape).append(found);
        }
        return out.toString();
    }

    public static String unescape(String input, char escape, Pair<Character, Character>... inverseEscaped) {
        return unescape(input, escape, false, inverseEscaped);
    }

    public static String unescape(String input, char escape, boolean usuals, Pair<Character, Character>... inverseEscaped) {
        StringBuilder out = new StringBuilder();
        Map<Character, Character> escaped = getEscapedSet(escape, inverseEscaped);
        if (usuals) {
            escaped.put('n', '\n');
            escaped.put('r', '\r');
            escaped.put('t', '\t');
            escaped.put('f', '\f');
        }
        boolean escapedContext = false;
        for (char current : input.toCharArray())
            if (escapedContext) {
                Character found = escaped.get(current);
                if (found == null)
                    out.append(escape).append(current);
                else
                    out.append(found);
                escapedContext = false;
            } else {
                if (current == escape)
                    escapedContext = true;
                else
                    out.append(current);
            }
        return out.toString();
    }

    private static Map<Character, Character> getEscapedSet(char escape, Pair<Character, Character>... toBeEscaped) {
        Map<Character, Character> escaped = new HashMap<>();
        escaped.put(escape, escape);
        if (toBeEscaped != null && toBeEscaped.length > 0)
            for (Pair<Character, Character> e : toBeEscaped)
                escaped.put(e.a, e.b);
        return escaped;
    }

    public static String trim(String base, String prefix) {
        return base.startsWith(prefix) ? base.substring(prefix.length()) : base;
    }

    public static boolean nullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static void requireValue(String input) {
        requireValue(input, null);
    }

    public static void requireValue(String input, String reason) {
        if (nullOrEmpty(input))
            throw new NullPointerException(reason == null ? "Item should not be null or empty" : reason);
    }

    public static String snakeToCamel(String snakeCase) {
        if (snakeCase.indexOf('_') < 0)
            return snakeCase;
        return decapitalize(Arrays.stream(snakeCase.split("_"))
                .filter(t -> !t.isEmpty())
                .map(TextUtils::capitalize)
                .collect(Collectors.joining()));
    }
}
