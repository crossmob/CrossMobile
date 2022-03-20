/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMPure;
import org.crossmobile.bridge.system.BaseUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

@CMPure(full = false)
public class SystemUtilities {
    private static final Pattern ESC_N = Pattern.compile("\\\\n");
    private static final Pattern ESC_R = Pattern.compile("\\\\r");
    private static final Pattern ESC_T = Pattern.compile("\\\\t");

    public static boolean propertyToBoolean(String key, boolean default_value) {
        return BaseUtils.objectToBoolean(System.getProperty(key, Boolean.toString(default_value)));
    }

    public static double propertyToDouble(String key, double default_value) {
        return stringToDouble(System.getProperty(key), default_value);
    }

    public static CGSize propertyToCGSize(String key, CGSize othersize) {
        String value = System.getProperty(key);
        if (value != null && !value.trim().toLowerCase().equals("@invalid")) {
            String[] parts = value.split(",");
            if (parts.length >= 2)
                try {
                    return new CGSize(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()));
                } catch (NumberFormatException ex) {
                    try {
                        //noinspection CharsetObjectCanBeUsed
                        ex.printStackTrace(new PrintWriter(new OutputStreamWriter(System.err, "UTF-8")));
                    } catch (UnsupportedEncodingException ignored) {
                    }
                }
        }
        return othersize;
    }

    public static double stringToDouble(String value, double default_value) {
        if (value == null || value.trim().toLowerCase().equals("@invalid"))
            return default_value;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return default_value;
        }
    }

    public static int stringToInt(String value, int default_value) {
        if (value == null || value.trim().toLowerCase().equals("@invalid"))
            return default_value;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return default_value;
        }
    }

    public static String bytesToString(byte[] bytes) {
        try {
            if (bytes != null)
                //noinspection CharsetObjectCanBeUsed
                return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder out = new StringBuilder();
        byte c;
        int l, h;
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < bytes.length; i++) {
            c = bytes[i];
            h = (c & 240) >>> 4;
            l = c & 15;
            out.append((char) (h < 10 ? h + '0' : h + 'a' - 10)).append((char) (l < 10 ? l + '0' : l + 'a' - 10));
        }
        return out.toString();
    }

    public static byte[] hexToBytes(String hex) {
        if (hex.length() % 2 == 1)
            hex = "0" + hex;
        byte[] result = new byte[hex.length() / 2];
        char h, l;
        for (int i = 0; i < 16; i++) {
            h = hex.charAt(i * 2);
            l = hex.charAt(i * 2 + 1);
            result[i] = (byte) (((h >= 'a' ? h - 'a' + 10 : h - '0') << 4) + (l >= 'a' ? l - 'a' + 10 : l - '0'));
        }
        return result;
    }

    public static String unescape(String input) {
        input = ESC_N.matcher(input).replaceAll("\n");
        input = ESC_R.matcher(input).replaceAll("\r");
        input = ESC_T.matcher(input).replaceAll("\t");
        return input;
    }

    /*
     * Find & call application Main
     */
    @SuppressWarnings("UseSpecificCatch")
    public static void launchClass(String classname, String[] args) {
        if (classname == null) {
            Native.lifecycle().quit("Not a valid CrossMobile application, missing main class definition", null);
            return;
        }
        // Initialize main class through reflection
        Method main;
        try {
            Class<?> clazz = SystemUtilities.class.getClassLoader().loadClass(classname);
            main = clazz.getMethod("main", args.getClass());
        } catch (Exception ex) {
            Native.lifecycle().quit("Unable to find CrossMobile application " + classname, ex);
            return;
        }
        // Execute main class
        try {
            main.invoke(null, new Object[]{args});
        } catch (Exception ex) {
            ex.printStackTrace(new PrintStream(System.err));
            Native.lifecycle().quit("Unable to initialize CrossMobile application " + classname, ex);
        }
    }

    @CMPure
    public static String getClassName(Class<?> cls) {
        String className = cls.getName();
        int point = className.lastIndexOf('.');
        if (point >= 0)
            className = className.substring(point + 1);
        return className;
    }

    public static <T> T construct(Class<T> typeClass) {
        try {
            Constructor<T> constructor = typeClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
        }
        try {
            return typeClass.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
        }
        return null;
    }

    public static String stackToString() {
        StringBuilder out = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        out.append("At ").append(stackTrace[3]).append("\n");
        boolean cut = false;
        for (int i = 4; i < stackTrace.length; i++) {
            String value = stackTrace[i].toString();
            if (value.startsWith("android.") || value.startsWith("com.android") || value.startsWith("java.") || value.startsWith("javax.") || value.startsWith("dalvik."))
                cut = true;
            else {
                out.append(cut ? "... " : "    ").append(value).append("\n");
                cut = false;
            }
        }
        if (cut)
            out.deleteCharAt(out.length() - 1).append(" ...\n");
        return out.toString();
    }

    public static boolean writeToFile(String path, byte[] data) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(data);
            return true;
        } catch (IOException ex) {
            return false;
        } finally {
            closeR(out);
        }
    }

    public static String writeToRandomFile(byte[] data) {
        String out = Native.file().getRandomLocation();
        return writeToFile(out, data)
                ? out
                : null;
    }

    public static boolean closeR(Reader reader) {
        if (reader != null)
            try {
                reader.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        else
            return false;
    }

    public static boolean closeR(InputStream stream) {
        if (stream != null)
            try {
                stream.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        else
            return false;
    }

    public static boolean closeR(Writer writer) {
        if (writer != null) {
            try {
                writer.flush();
            } catch (IOException ignore) {
                return false;
            }
            try {
                writer.close();
            } catch (IOException ignore) {
                return false;
            }
            return true;
        } else
            return false;
    }

    public static boolean closeR(OutputStream stream) {
        if (stream != null) {
            try {
                stream.flush();
            } catch (IOException ignore) {
                return false;
            }
            try {
                stream.close();
            } catch (IOException ignore) {
                return false;
            }
            return true;
        } else
            return false;
    }

    public static <T> T safeInstantiation(Class<? extends T> classType, Class<T> defaultClassType) {
        if (classType == null)
            classType = defaultClassType;
        try {
            return classType.newInstance();
        } catch (Exception ex) {
            Native.lifecycle().quit("Unable to initialize " + getClassName(classType), ex);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T safeInstantiation(String className) {
        try {
            return (T) Class.forName(className).getConstructor().newInstance();
        } catch (Exception ignored) {
            return null;
        }
    }

    @SuppressWarnings("EqualsReplaceableByObjectsCall")
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public static String fixURI(String url) {
        String MATRIX = "0123456789ABCDEF";
        StringBuilder uri = new StringBuilder();
        for (char c : url.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
                    || c == '+' || c == '.' || c == '-'
                    || c == ':'
                    || c == '_' || c == '~' || c == '/' || c == '?' || c == '#' || c == '['
                    || c == ']' || c == '@' || c == '!' || c == '$' || c == '&' || c == '\''
                    || c == '(' || c == ')' || c == '*' || c == ',' || c == ';' || c == '='
                    || c == '%')
                uri.append(c);
            else {
                try {
                    //noinspection CharsetObjectCanBeUsed
                    for (byte b : String.valueOf(c).getBytes("UTF-8")) {
                        int u = b & 0xFF;   // convert to unsigned
                        uri.append('%');
                        uri.append(MATRIX.charAt((u >>> 4) % 16));
                        uri.append(MATRIX.charAt(u % 16));
                    }
                } catch (UnsupportedEncodingException ignored) {
                }
            }
        }
        return uri.toString();
    }

    public static String URIEncode(String path) {
        StringBuilder uri = new StringBuilder();
        char c;
        for (int i = 0; i < path.length(); i++)
            switch (c = path.charAt(i)) {
                case ' ':
                    uri.append("%20");
                    break;
                case '"':
                    uri.append("%22");
                    break;
                case '%':
                    uri.append("%25");
                    break;
                case '-':
                    uri.append("%2D");
                    break;
                case '.':
                    uri.append("%2E");
                    break;
                case '<':
                    uri.append("%3C");
                    break;
                case '>':
                    uri.append("%3E");
                    break;
                case '\\':
                    uri.append("%5C");
                    break;
                case '^':
                    uri.append("%5E");
                    break;
                case '_':
                    uri.append("%5F");
                    break;
                case '`':
                    uri.append("%60");
                    break;
                case '{':
                    uri.append("%7B");
                    break;
                case '|':
                    uri.append("%7C");
                    break;
                case '}':
                    uri.append("%7D");
                    break;
                case '~':
                    uri.append("%7E");
                    break;
//                case '!':
//                    uri.append("%21");
//                    break;
//                case '#':
//                    uri.append("%23");
//                    break;
//                case '$':
//                    uri.append("%24");
//                    break;
//                case '&':
//                    uri.append("%26");
//                    break;
//                case '\'':
//                    uri.append("%27");
//                    break;
//                case '(':
//                    uri.append("%28");
//                    break;
//                case ')':
//                    uri.append("%29");
//                    break;
//                case '*':
//                    uri.append("%2A");
//                    break;
//                case '+':
//                    uri.append("%2B");
//                    break;
//                case ',':
//                    uri.append("%2C");
//                    break;
//                case ':':
//                    uri.append("%3A");
//                    break;
//                case ';':
//                    uri.append("%3B");
//                    break;
//                case '=':
//                    uri.append("%3D");
//                    break;
//                case '?':
//                    uri.append("%3F");
//                    break;
//                case '@':
//                    uri.append("%40");
//                    break;
//                case '[':
//                    uri.append("%5B");
//                    break;
//                case ']':
//                    uri.append("%5D");
//                    break;
                case '\n':
                    uri.append("%0A");
                    break;
                case '\r':
                    uri.append("0D");
                    break;
                case '\t':
                    uri.append("%09");
                    break;
                case '\f':
                    uri.append("%0C");
                    break;
                default:
                    uri.append(c);
            }
        return uri.toString();
    }

    @SuppressWarnings("CharsetObjectCanBeUsed")
    public static String toString(byte[] bytes, String encodingName, String defaultValue) {
        if (bytes == null)
            return defaultValue;
        try {
            return new String(bytes, encodingName);
        } catch (UnsupportedEncodingException ignored) {
        }
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {
        }
        return defaultValue;
    }
}
