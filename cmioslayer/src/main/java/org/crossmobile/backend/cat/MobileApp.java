/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.cat;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSJSONSerialization;
import org.crossmobile.backend.desktop.OperatingSystem;
import org.crossmobile.bridge.Native;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import static org.crossmobile.bridge.system.BaseUtils.throwExceptionAndReturn;
import static org.crossmobile.bridge.system.RuntimeCommons.MATERIALS_TAG;

public class MobileApp implements Comparable<MobileApp> {

    private final static RescaleOp highlight = new RescaleOp(new float[]{1.2f, 1.2f, 1.2f, 1f}, new float[]{30, 30, 30, 0}, null);
    private static final String ICONPATH = "org" + File.separator + "crossmobile" + File.separator + MATERIALS_TAG + File.separator + "sys" + File.separator + "appicon.png";
    private static final String DEFAULTICONPATH = "/" + MobileApp.class.getPackage().getName().replace('.', '/') + "/default.png";

    private final String name;
    private final String identifier;
    private final String path;
    private final String mainclass;
    private final String classpath;
    private BufferedImage icon;
    private BufferedImage selectedicon;


    public static void goToHome() {
        Native.lifecycle().quit(null, null);
        try {
            String[] args = new String[]{
                    OperatingSystem.getJavaExec(),
                    "-cp",
                    System.getProperty("java.class.path"),
                    "org.crossmobile.backend.desktop.cat.ApplicationPresentation"
            };
            Runtime.getRuntime().exec(args);
        } catch (IOException ignored) {
        } finally {
            System.exit(0);
        }
    }

    public static MobileApp current() {
        try {
            return new MobileApp(System.getProperty("cm.display.name"),
                    Native.system().bundleID(),
                    new File(System.getProperty("user.dir")).getAbsolutePath(),
                    System.getProperty("java.class.path"),
                    System.getProperty("cm.main.class"));
        } catch (IOException ex) {
        }
        return null;
    }

    @SuppressWarnings("UseSpecificCatch")
    public static MobileApp fromJSON(String json) {
        try {
            if (json == null)
                return null;
            Object root = NSJSONSerialization.JSONObjectWithData(NSData.dataWithBytes(json.getBytes()), 0, null);
            if (root != null && root instanceof Map) {
                Map map = (Map) root;
                Object name = map.get("name");
                Object identifier = map.get("identifier");
                Object path = map.get("path");
                Object classpath = map.get("classpath");
                Object mainclass = map.get("mainclass");
                if (name != null && identifier != null && path != null && classpath != null && mainclass != null)
                    return new MobileApp(name.toString(), identifier.toString(), path.toString(), classpath.toString(), mainclass.toString());
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public String toJSON() {
        Map<String, Object> root = new HashMap<>();
        root.put("name", name);
        root.put("identifier", identifier);
        root.put("path", path);
        root.put("classpath", classpath);
        root.put("mainclass", mainclass);
        NSData res = NSJSONSerialization.dataWithJSONObject(root, 0, null);
        return res == null ? null : res.toString();
    }

    private MobileApp(String name, String identifier, String path, String classpath, String mainclass) throws IOException {
        this.name = name;
        this.identifier = identifier;
        this.path = path;
        this.mainclass = mainclass;
        this.classpath = classpath;
        checkConsistency();
    }

    public void open() {
        try {
            ProcessBuilder pb = new ProcessBuilder(OperatingSystem.getJavaExec(),
                    "-cp",
                    classpath,
                    mainclass);
            pb.directory(new File(path));
            pb.start();
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Unable to start application " + name + "\n\n" + ex.toString(), "Launch error for " + name, JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    public String info() {
        return path;
    }

    public String name() {
        return name;
    }

    public String id() {
        return identifier;
    }

    public Image icon(boolean selected) {
        if (icon == null) {
            // First try to load read icon
            StringTokenizer tok = new StringTokenizer(classpath, File.pathSeparator);
            while (tok.hasMoreTokens()) {
                File file = new File(tok.nextToken());
                if (!file.isAbsolute())
                    file = new File(path, file.getPath()).getAbsoluteFile();
                try {
                    InputStream stream = file.isDirectory()
                            ? new FileInputStream(new File(file, ICONPATH))
                            : new JarFile(file).getInputStream(new ZipEntry(ICONPATH));
                    icon = ImageIO.read(stream);
                    if (icon != null)
                        break;
                } catch (Exception ex) {
                }
            }

            // Then try to go to failsafe icon
            if (icon == null)
                try {
                    icon = ImageIO.read(getClass().getResource(DEFAULTICONPATH));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Unable to load icon", "CrossMobile", JOptionPane.ERROR_MESSAGE);
                    return throwExceptionAndReturn(ex);
                }
            selectedicon = highlight.filter(this.icon, null);
        }
        return selected ? selectedicon : icon;
    }

    private void checkConsistency() throws IOException {
    }

    @Override
    public int compareTo(MobileApp o) {
        return o == null ? 1 : identifier.compareTo(o.identifier);
    }

    @Override
    public String toString() {
        return "MobileApp{" + "name=" + name + ", identifier=" + identifier + ", path=" + path + '}';
    }
}
