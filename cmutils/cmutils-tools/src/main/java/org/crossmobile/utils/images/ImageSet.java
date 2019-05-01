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
package org.crossmobile.utils.images;

import org.crossmobile.bridge.system.ExceptionUtils;
import org.crossmobile.utils.CollectionUtils;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ImageSet {

    private final Map<Integer, MetaImage> images = new HashMap<>();

    public ImageSet(String defaultIconResource, File... roots) {
        for (File root : CollectionUtils.asList(roots))
            for (File child : FileUtils.list(root))
                try {
                    MetaImage old = child.isFile() ? addImage(new MetaImage(child)) : null;
                    if (old != null)
                        Log.error("Ignoring image " + child.getAbsolutePath() + " with size " + old.size + "; already found at " + old.file.getAbsolutePath());
                } catch (IOException e) {
                    Log.error("Unable to load image " + child.getAbsolutePath());
                }
        if (images.isEmpty()) {
            try {
                addImage(new MetaImage(ImageSet.class.getResourceAsStream(defaultIconResource)));
            } catch (IOException e) {
                ExceptionUtils.throwException(new IOException("Unable to load default image at resource location " + defaultIconResource));
            }
        }
    }

    public List<File> getImageFiles() {
        List<File> files = new ArrayList<>();
        for (MetaImage img : images.values())
            if (img.file != null)
                files.add(img.file);
        return files;
    }

    public MetaImage find(int size, boolean required) {
        MetaImage found = findOptimumImage(size, required ? null : i -> i.size >= size);
        if (found.size == size)
            return found;
        found = found.resize(size);
        addImage(found);
        return found;
    }

    private MetaImage addImage(MetaImage img) {
        if (img.isInvalid())
            return null;
        MetaImage old = images.get(img.size);
        if (old != null)
            return old;
        images.put(img.size, img);
        return null;
    }

    private MetaImage findOptimumImage(int size, Predicate<MetaImage> predicate) {
        MetaImage found = images.get(size);
        if (found != null)
            return found;
        Double lastScore = null;
        for (MetaImage current : images.values()) {
            if (current.resizable && (predicate == null || predicate.test(current))) {
                double score = (double) current.size / size;
                if (score > 2) {
                    // For much bigger images, select the one which is closer to the required size
                    score = 1.8 + 1 / (score * 2.5);   // starts at 2, tends to 1.8
                }
                if (lastScore == null || score < lastScore) {
                    lastScore = score;
                    found = current;
                }
            }
        }
        return found == null ? new MetaImage(size) : found;
    }
}
