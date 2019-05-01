/*
 * ExtPath.java
 *
 * Created on June 18, 2007, 4:30 PM
 *
 * This file is part of Jubler.
 *
 * Jubler is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 *
 * Jubler is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jubler; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
package org.crossmobile.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static org.crossmobile.utils.FileUtils.getAbsFile;

public class MaterialsUtils {

    private MaterialsUtils() {
    }

    public static List<File> getMaterials(File basedir, String item) {
        List<File> result = new ArrayList<>();
        if (item != null) {
            File abs = getAbsFile(basedir, item);
            if (abs.isDirectory() && item.endsWith("/")) // should be fixed to this character
                result.addAll(Arrays.asList(abs.listFiles()));
            else if (abs.exists())
                result.add(abs);
        }
        return result;
    }

    public static void copyFiles(Collection<File> materials, File outputDir, Predicate<FileMaterial> shouldCopy) {
        copyFilesImpl(materials, outputDir, shouldCopy, "");
    }

    private static void copyFilesImpl(Collection<File> materials, File outputDir, Predicate<FileMaterial> shouldCopy, String pathUpToNow) {
        for (File material : materials) {
            String newPath = (pathUpToNow.isEmpty() ? "" : pathUpToNow + "/") + material.getName();
            File dest = new File(outputDir, material.getName());
            if (material.isDirectory()) {
                File[] files = material.listFiles();
                if (files != null && files.length > 0)
                    copyFilesImpl(Arrays.asList(files), dest, shouldCopy, newPath);
            } else if (shouldCopy == null || shouldCopy.test(new FileMaterial(material, dest, newPath)))
                FileUtils.copy(material, dest);
        }
    }

    public static class FileMaterial {
        public final File input;
        public final File output;
        public final String path;

        public FileMaterial(File input, File output, String relativePath) {
            this.input = input;
            this.output = output;
            this.path = relativePath;
        }
    }

}
