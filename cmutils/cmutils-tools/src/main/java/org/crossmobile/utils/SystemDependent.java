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

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;

import static org.crossmobile.utils.SystemDependent.Execs.JAVA;

public class SystemDependent {

    private final static boolean IS_LINUX;
    private final static boolean IS_WINDOWS;
    private final static boolean IS_MACOSX;
    private final static String HOME;

    private static final String APP_HOME;

    static {
        String OS = System.getProperty("os.name").toLowerCase();
        IS_LINUX = OS.contains("linux");
        IS_WINDOWS = OS.contains("windows");
        IS_MACOSX = OS.contains("mac");
        HOME = IS_WINDOWS ? System.getProperty("user.home").replace('\\', '/') : System.getProperty("user.home");
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
        } catch (Exception ex) {
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
        res.add(new ExtPath(HOME + "/Library", 4));
        res.add(new ExtPath(HOME + "/Downloads", 3));
        res.add(new ExtPath(HOME + "/Desktop", 3));
        res.add(new ExtPath(HOME + "/Android", 3));
        res.add(new ExtPath(HOME + "/.local/share/JetBrains/Toolbox/apps", 3));

        res.add(new ExtPath("/usr/local/Cellar", 3));
        //linux default paths
        res.add(new ExtPath("/usr/bin", 1));
        res.add(new ExtPath("/usr/local", 3));
        res.add(new ExtPath("/usr/share", 4));
        res.add(new ExtPath("/opt", 3));
        res.add(new ExtPath("/Library/Java/JavaVirtualMachines", 4));
        res.add(new ExtPath("/System/Library/Java/JavaVirtualMachines", 4));
        res.add(new ExtPath("/usr/lib/jvm", 3));
        res.add(new ExtPath("/usr/lib64/jvm", 3));
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

    public static String getHome() {
        return HOME;
    }

    public static String getAppHome() {
        return APP_HOME;
    }

    public static String getPluginsDir() {
        return HOME + "/.local/share/crossmobile/plugins";
    }

    public static String getJavaExec() {
        String JAVAHOME = System.getProperty("java.home");
        String EXEC = JAVA.filename();
        String file = JAVAHOME + File.separator + "bin" + File.separator + EXEC;
        if (new File(file).isFile())
            return file;
        file = JAVAHOME + File.separator + "jre" + File.separator + "bin" + File.separator + EXEC;
        if (new File(file).isFile())
            return file;
        return null;
    }

    public static boolean isJavaOld(String version) {
        List<Integer> numbs = TextUtils.listOfInts(version);
        if (numbs.isEmpty())
            return true;
        if (numbs.get(0) > 8)
            return false;
        if (numbs.size() < 2)
            return true;
        if (numbs.get(1) < 8)
            return true;
        if (numbs.get(1) > 8)
            return false;
        if (numbs.size() < 3)
            return true;
        if (numbs.get(2) > 0)
            return false;
        if (numbs.size() < 4)
            return true;
        return numbs.get(3) < 111;
    }

    public static String getAppliationRoot(File mainclasspath) {
        if (mainclasspath.getName().toLowerCase().endsWith("jar"))
            return IS_MACOSX // one path more, since the JAR is already a file
                    ? mainclasspath.getParentFile().getParentFile().getParent()
                    : mainclasspath.getParentFile().getParent();
        return IS_MACOSX
                ? new File(mainclasspath.getParent(), "crossmobile/app/CrossMobile.app").getAbsolutePath()
                : new File(mainclasspath.getParent(), "crossmobile").getAbsolutePath();
    }

    public static boolean canMakeIos() {
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

    public enum Execs {

        JAVA("exe"),
        JAVAC("exe"),
        ANDROID("bat"),
        SDKMANAGER("bat"),
        ADB("exe"),
        NETBEANS("exe"),
        IDEA("exe", "sh"),
        STUDIO("exe", "sh"),
        STUDIO64("exe", "sh"),
        MVN("cmd");

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
