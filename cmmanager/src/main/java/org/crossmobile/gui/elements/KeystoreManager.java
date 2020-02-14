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
package org.crossmobile.gui.elements;

import com.panayotis.appenh.AFileChooser;
import com.panayotis.appenh.Enhancer;
import org.crossmobile.prefs.Prefs;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static com.panayotis.appenh.AFileChooser.FileSelectionMode.FilesOnly;

public class KeystoreManager {
    private static final AFileChooser afc = new AFileChooser().setMode(FilesOnly).setRememberSelection(true);

    public static String browseKeystore() {
        File keystore = afc.setDirectory(new File(Prefs.getAndroidKeyLocation())).openSingle();
        return keystore != null && keystore.exists() && isKeystoreFile(keystore)
                ? keystore.getAbsolutePath()
                : null;
    }

    public static boolean isKeystoreFile(File file) {
        if (getKeystore(file) == null) {
            JOptionPane.showMessageDialog(null, "File " + file.getAbsolutePath() + " is not a valid Java Keystore", "Error while parsing keystore file", JOptionPane.ERROR_MESSAGE);
            return false;
        } else
            return true;
    }

    public static List<String> getKeystoreAliases(File file) {
        List<String> list = new ArrayList<>();
        KeyStore ks = getKeystore(file);
        if (ks != null) {
            Enumeration<String> aliases;
            try {
                aliases = ks.aliases();
                while (aliases.hasMoreElements())
                    list.add(aliases.nextElement());
            } catch (KeyStoreException ex) {
            }
        }
        return list;
    }

    @SuppressWarnings("UseSpecificCatch")
    private static KeyStore getKeystore(File file) {
        java.io.FileInputStream fis = null;
        try {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            fis = new java.io.FileInputStream(file);
            ks.load(fis, null); // no password
            return ks;
        } catch (Exception ex) {
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException ex) {
                }
        }
        return null;
    }
}
