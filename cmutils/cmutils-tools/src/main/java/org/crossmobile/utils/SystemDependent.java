/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.prefs.Config;
import org.crossmobile.utils.func.Opt;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.*;
import java.util.function.Function;

import static java.io.File.pathSeparator;
import static java.io.File.separator;
import static org.crossmobile.utils.SystemDependent.Execs.*;

public class SystemDependent {

    private final static boolean IS_LINUX;
    private final static boolean IS_WINDOWS;
    private final static boolean IS_MACOSX;
    private final static String HOME;
    private final static String PLUGINS;

    private static final String APP_HOME;

    static {
        String OS = System.getProperty("os.name").toLowerCase();
        IS_LINUX = OS.contains("linux");
        IS_WINDOWS = OS.contains("windows");
        IS_MACOSX = OS.contains("mac");
        HOME = IS_WINDOWS ? System.getProperty("user.home").replace('\\', '/') : System.getProperty("user.home");
        PLUGINS = HOME + separator + ".local" + separator + "share" + separator + "crossmobile";
        if (IS_MACOSX)
            APP_HOME = HOME + "/Library/Application Support/CrossMobile/";
        else if (IS_WINDOWS)
            APP_HOME = System.getenv("APPDATA") + "\\CrossMobile\\";
        else
            APP_HOME = HOME + "/.local/share/crossmobile/";
    }

    public static int getBundleOrFileID() {
        if (IS_MACOSX)
            return ExtPath.BUNDLE_ONLY;
        return ExtPath.FILE_ONLY;
    }

    /* This method is valid only under Mac OSX.
     * It uses Spotlight to find a desired application.
     * Under other platforms does not do anything
     */
    @SuppressWarnings("UseSpecificCatch")
    public static void appendSpotlightApplication(String name, List<ExtPath> res) {
        if (!IS_MACOSX)
            return;
        if (name == null)
            return;
        Process proc;
        String[] cmd = new String[2];
        cmd[0] = "mdfind";
//        cmd[1] = "kind:application " + name;
        cmd[1] = "kMDItemKind == 'Application' && kMDItemDisplayName == '*" + name + "*'c";
        try {
            String line;
            proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = in.readLine()) != null)
                if (line.endsWith(".app"))
                    res.add(new ExtPath(line, ExtPath.BUNDLE_ONLY));
        } catch (Exception ignored) {
        }
    }

    public static void appendPathApplication(List<ExtPath> res) {
//        StringTokenizer st = new StringTokenizer(System.getenv("PATH"), File.pathSeparator);
//        while (st.hasMoreTokens())
//            res.add(new ExtPath(st.nextToken(), 1));

        // Add some system dependent paths
        res.add(new ExtPath("C:/Program Files", 4));
        res.add(new ExtPath("C:/Program Files (x86)", 4));
        // Might no need to add /Application because under OSX we can use spotlight instead
        res.add(new ExtPath(HOME + "/Applications", 4));
        res.add(new ExtPath(HOME + "/AppData", 5));
        res.add(new ExtPath(HOME + "/Library/Android", 3));
        res.add(new ExtPath(HOME + "/Downloads", 3));
        res.add(new ExtPath(HOME + "/Desktop", 3));
        res.add(new ExtPath(HOME + "/Android", 3));
        res.add(new ExtPath(HOME + "/.sdk", 3));
        res.add(new ExtPath(HOME + "/.local/share/JetBrains/Toolbox/apps", 4));
        res.add(new ExtPath(HOME + "/.sdkman/candidates/java", 2));

        res.add(new ExtPath("/usr/local/Cellar", 3));
        //linux default paths
        res.add(new ExtPath("/usr/bin", 1));
        res.add(new ExtPath("/usr/local", 3));
        res.add(new ExtPath("/opt", 3));
        res.add(new ExtPath("/Library/Java/JavaVirtualMachines", 4));
        res.add(new ExtPath("/System/Library/Java/JavaVirtualMachines", 4));
        res.add(new ExtPath("/usr/lib/jvm", 3));
        res.add(new ExtPath("/usr/lib64/jvm", 3));
        res.add(new ExtPath("/snap/bin", 1, false));
        String javaHome = System.getenv("JAVA_HOME");
        if (javaHome != null)
            res.add(new ExtPath(javaHome, 3));
    }

    public static Charset getEncoding() {
        if (IS_WINDOWS)
            return Charset.forName("x-UTF-16LE-BOM");
        else
            return StandardCharsets.UTF_8;
    }

    public static String getDefaultTheme() {
        return IS_WINDOWS ? "light" : "auto";
    }

    public static String getHome() {
        return HOME;
    }

    public static String getAppHome() {
        return APP_HOME;
    }

    public static String getManagerPluginsDir() {
        return PLUGINS + separator + "manager-plugins";
    }

    public static String getMetaPluginsDir() {
        return PLUGINS + separator + "plugins";
    }

    private static String getJavaRelatedExec(String javaHome, Execs exec) {
        String EXEC = exec.filename();
        String file = javaHome + separator + "bin" + separator + EXEC;
        if (new File(file).isFile())
            return file;
        file = javaHome + separator + "jre" + separator + "bin" + separator + EXEC;
        if (new File(file).isFile())
            return file;
        return null;
    }

    public static String getJavaExec() {
        return getJavaRelatedExec(System.getProperty("java.home"), JAVA);
    }

    public static String getJavahExec(File given) {
        Function<String, String> r = s -> {
            Log.info("Found javah under " + s);
            return s;
        };
        if (given != null && given.isFile())
            return r.apply(given.getAbsolutePath());
        String javah = getJavaRelatedExec(System.getProperty("java.home"), JAVAH);
        if (javah != null)
            return r.apply(javah);

        File sdkman = new File(System.getProperty("user.home"), ".sdkman" + separator + "candidates" + separator + "java/");
        if (sdkman.isDirectory()) {
            for (File home : sdkman.listFiles()) {
                javah = getJavaRelatedExec(home.getAbsolutePath(), JAVAH);
                if (javah != null)
                    return r.apply(javah);
            }
        }

        File macosjava = new File("/Library/Java/JavaVirtualMachines/");
        if (macosjava.isDirectory()) {
            for (File root : macosjava.listFiles()) {
                File home = new File(root, "Contents/Home");
                if (home.isDirectory()) {
                    javah = getJavaRelatedExec(home.getAbsolutePath(), JAVAH);
                    if (javah != null)
                        return r.apply(javah);
                }
            }
        }

        throw new RuntimeException("Unable to locate javah");
    }

    public static String safeArg(String arg) {
        return IS_WINDOWS ? (arg.isEmpty() ? " " : arg) : arg;
    }

    public static boolean isJavaValid(String version) {
        List<Integer> given = TextUtils.listOfInts(version.trim());
        List<Integer> req = TextUtils.listOfInts(Config.MIN_JAVA_VERSION_FULL);
        if (req.get(0) == 1)    // for versions 1.7 1.8 etc. Go directly to 7.X 8.X etc.
            req.remove(0);

        if (given.isEmpty())
            return false;
        if (given.get(0) > req.get(0) && given.get(0) <= Integer.parseInt(Config.MAX_JAVA_VERSION))
            return true;
        if (given.size() < 2)
            return false;
        if (given.get(1) < 8)
            return false;
        if (given.get(1) > 8)
            return true;
        if (given.size() < 3)
            return false;
        if (given.get(2) > 0)
            return true;
        if (given.size() < 4)
            return false;
        return given.get(3) >= req.get(2);  // we have already removed the first 1. part
    }

    public static boolean hasXcode() {
        return IS_MACOSX;
    }

    public static boolean canMakeUwp() {
        return IS_WINDOWS;
    }

    /* A dirty dirty dirty trick to be able to find the actual canWrite attribute under Windows */
    public static boolean canWrite(File f) {
        if (f == null)
            return false;
        if (!IS_WINDOWS)
            return f.canWrite();
        /* Do this horrible trick to make sure that a file is REALLY writable... */
        boolean ret = false;
        if (f.isFile())
            if (f.exists()) {
                File newfile = new File(f.getPath() + ".canWrite");
                boolean renameTo = f.renameTo(newfile);
                if (renameTo) {
                    newfile.renameTo(f);
                    ret = true;
                }
            } else
                ret = newfile_canwrite(f);
        else if (f.isDirectory())
            ret = newfile_canwrite(new File(f, "canWrite"));
        return ret;
    }

    private static boolean newfile_canwrite(File f) {
        Writer qw = null;
        boolean ret = false;
        try {
            qw = new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8);
            qw.write(" ");
            ret = true;
        } catch (IOException ex) {
        } finally {
            try {
                if (qw != null)
                    qw.close();
            } catch (IOException ex) {
            } finally {
                if (f.exists())
                    f.delete();
            }
        }
        return ret;
    }

    public static boolean makeExecutable(File file) {
        try {
            if (!IS_WINDOWS)
                Files.setPosixFilePermissions(file.toPath(), PosixFilePermissions.fromString("rwxr-xr-x"));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String getFileManagerName() {
        return IS_MACOSX ? "Finder" : IS_WINDOWS ? "Explorer" : "File Manager";
    }

    public static Collection<File> getBlacklistedLocations() {
        try {
            if (IS_MACOSX) {
                Collection<File> blacklist = new HashSet<>();
                blacklist.add(new File(HOME, "Library/Application Support/AddressBook").getCanonicalFile());
                blacklist.add(new File(HOME, "Library/Calendars").getCanonicalFile());
                blacklist.add(new File(HOME, "Library/Reminders").getCanonicalFile());
                blacklist.add(new File(HOME, "Pictures/Photos.photoslibrary").getCanonicalFile());
                return blacklist;
            }
        } catch (IOException ignored) {
        }
        return null;
    }

    public static String canAccessPath(String appName, String location) {
        try {
            if (IS_MACOSX && new File(location).getAbsoluteFile().getCanonicalPath().startsWith(HOME + separator + "Desktop"))
                return "Location of " + appName + " seems to be under user's Desktop.\nThis is not recommended under Apple's file policy.\nNote you might experience hangs when accessing it.\n\nPlease consider installing it to a different location.";
        } catch (Exception ignored) {
        }
        return null;
    }

    public static boolean is64Bit() {
        for (String prop : new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"})
            if (System.getProperty(prop, "").contains("64"))
                return true;
        return false;
    }

    public static String getOSBinName() {
        return IS_WINDOWS ? "windows" : IS_LINUX ? "linux64" : "macos";
    }

    public static String getBashExec() {
        for (String part : Opt.of(System.getenv("PATH")).getOrElse("").split(pathSeparator)) {
            File path = new File(part, BASH.filename());
            if (path.isFile())
                return path.getAbsolutePath();
        }
        return null;
    }

    public static String getFullName() {
        if (IS_MACOSX) {
            StringBuilder out = new StringBuilder();
            Commander c = new Commander("id", "-F");
            c.setOutListener(out::append);
            c.exec();
            c.waitFor();
            String name = out.toString();
            if (c.exitValue() == 0 && !name.trim().isEmpty())
                return name.trim();
        }
        String username = System.getProperty("user.name", "").trim();
        if (!username.isEmpty()) {
            String passwd = FileUtils.read(new File("/etc/passwd"));
            String check = username + ":";
            if (passwd != null)
                for (String line : passwd.split("\\r?\\n"))
                    if (line.startsWith(check)) {
                        String[] parts = line.split(":");
                        if (parts.length >= 5) {
                            String[] name = parts[4].split(",");
                            if (name.length > 0 && name[0].trim().length() > 0)
                                return name[0];
                        }
                    }
            return username.substring(0, 1).toUpperCase() + (username.length() > 1 ? username.substring(1) : "");
        }
        return "Company";
    }

    public static Map<String, String> getEnvWithFixedPaths() {
        String key = IS_WINDOWS ? "Path" : "PATH";
        String path = System.getenv(key) + pathSeparator + "/usr/local/bin" + pathSeparator + "/usr/local/sbin";
        return Collections.singletonMap(key, path);
    }

    public static String getDeploymentTarget() {
        if (IS_MACOSX) {
            String[] parts = System.getProperty("os.version", "1.0").split("\\.");
            try {
                if (parts.length >= 2 && parts[0].equals("10") && Integer.parseInt(parts[1]) <= 13)
                    return "10.0";
            } catch (NumberFormatException ignored) {
            }
        }
        return "13.0";
    }

    public static void setUiFont(String resource) {
        try {
            Font droidFont = Font.createFont(Font.TRUETYPE_FONT, SystemDependent.class.getResourceAsStream(resource)).deriveFont(12f);
            if (IS_LINUX) {
                // Force AA under Linux
                // Java 9+ API
                UIManager.getLookAndFeelDefaults().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                try {
                    // Java 8 API
                    Object key = SystemDependent.class.getClassLoader().loadClass("sun.swing.SwingUtilities2").getField("AA_TEXT_PROPERTY_KEY").get(null);
                    Object value = SystemDependent.class.getClassLoader().loadClass("sun.swing.SwingUtilities2$AATextInfo").getConstructor(Object.class, Integer.class).newInstance(RenderingHints.VALUE_TEXT_ANTIALIAS_ON, 200);
                    UIManager.getLookAndFeelDefaults().put(key, value);
                } catch (Exception ignored2) {
                }
            }
            UIManager.getLookAndFeelDefaults().put("defaultFont", droidFont);
        } catch (Exception ignored) {
        }
    }

    public enum Execs {

        JAVA("exe"),
        JAVAC("exe"),
        JAVAH("exe"),
        ANDROID("bat"),
        SDKMANAGER("bat"),
        ADB("exe"),
        EMULATOR("exe"),
        NETBEANS("exe"),
        IDEA("exe", "sh"),
        CODE("exe"),
        CODIUM("exe"),
        STUDIO("exe", "sh"),
        STUDIO64("exe", "sh"),
        BASH("exe"),
        MVN("cmd"),
        MAKEAPP("exe");

        private final String ext;
        private final String lext;

        Execs(String ext) {
            this.ext = ext;
            this.lext = null;
        }

        Execs(String ext, String lext) {
            this.ext = ext;
            this.lext = lext;
        }

        public String filename() {
            return IS_WINDOWS ? name().toLowerCase() + "." + ext : (IS_LINUX && lext != null) ? name().toLowerCase() + "." + lext : name().toLowerCase();
        }
    }

}
