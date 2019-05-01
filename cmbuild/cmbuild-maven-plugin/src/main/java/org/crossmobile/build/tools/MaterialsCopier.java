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
package org.crossmobile.build.tools;

import org.crossmobile.build.ib.i18n.IBParserMeta;
import org.crossmobile.build.ib.i18n.LocalizedType;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.JarUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.MaterialsUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.jar.JarFile;

import static org.crossmobile.bridge.system.MaterialsCommon.MATERIALS_TAG;
import static org.crossmobile.build.tools.StringsToPropertiesConverter.parseStrings;
import static org.crossmobile.build.tools.StringsToPropertiesConverter.parseStringsDict;

public class MaterialsCopier {

    //   private static final BufferedImage shape = ImageUtils.getImage("/buildres/layers/shape.png");

    private static final Collection<String> BLACKLIST = new HashSet<>(Collections.singletonList(".DS_Store"));

    public static void updateTranslationsOnly(Collection<File> materials, File baseDir, IBParserMeta meta) {
        for (File file : materials)
            if (file.isDirectory())
                updateTranslationsOnly(FileUtils.list(file), baseDir, meta);
            else if (file.getName().endsWith(".strings")) {
                LocalizedType localized = LocalizedType.getLocalized(file, baseDir);
                if (localized != null && !localized.isBase)
                    parseStrings(file, localized, meta.get(localized.tableName));
            }
    }

    public static void copyMaterials(Collection<File> materials, File baseDir, File otherFiles, IBParserMeta meta) {
        MaterialsUtils.copyFiles(materials, otherFiles, file -> {
            String name = file.input.getName();
            if (BLACKLIST.contains(name))
                return false;
            if (name.startsWith("."))
                Log.warning("Hidden file found: " + file.path);
            if (name.endsWith(".strings")) {
                LocalizedType localized = LocalizedType.getLocalized(file.input, baseDir);
                FileUtils.write(file.output, parseStrings(file.input, localized, meta.get(localized == null || localized.isBase ? null : localized.tableName)));
                return false;
            } else if (name.endsWith(".stringsdict")) {
                FileUtils.write(file.output, parseStringsDict(file.input));
                return false;
            } else
                return true;
        });
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void copyAndroidSys(Collection<File> plugins, File andrAsset, File andrRes) {
        String path = MaterialsCopier.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath;
        try {
            decodedPath = URLDecoder.decode(path, "UTF-8");
            Log.info("jar path : " + decodedPath);
        } catch (UnsupportedEncodingException ex) {
        }
        try {
            JarUtils.copyJarResources(new JarFile(path), "res", andrRes);
        } catch (IOException ex) {
        }

        for (File plugin : plugins) {
            try {
                JarUtils.copyJarResources(new JarFile(plugin), "org/crossmobile/" + MATERIALS_TAG + "/sys", new File(andrRes, "drawable"));
            } catch (Exception ex) {
            }
            try {
                JarUtils.copyJarResources(new JarFile(plugin), "org/crossmobile/" + MATERIALS_TAG + "/app", andrAsset);
            } catch (Exception ex) {
            }
        }
    }

}
