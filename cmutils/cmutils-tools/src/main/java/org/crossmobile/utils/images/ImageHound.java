/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.images;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.Log;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.crossmobile.bridge.system.BaseUtils.listFiles;

public class ImageHound {
    private final Map<Integer, MetaImage> foreImages = new HashMap<>();
    private final Map<Integer, MetaImage> backImages = new HashMap<>();

    private final static double BACK_SIZE_MULTIPLIER = 1.5;

    public ImageHound addForegroundImages(MetaImage defaultImage, File... srcDirs) {
        gatherImages(true, null, defaultImage == null ? null : defaultImage.image, srcDirs);
        return this;
    }

    public ImageHound addForegroundImages(String defaultResource, File... srcDirs) {
        gatherImages(true, defaultResource, null, srcDirs);
        return this;
    }

    public ImageHound addBackgroundImages(String defaultResource, File... srcDirs) {
        gatherImages(false, defaultResource, null, srcDirs);
        return this;
    }

    private void gatherImages(boolean asFore, String defaultResource, BufferedImage defaultImage, File... srcDirs) {
        if (!container(asFore).isEmpty())
            throw new IllegalArgumentException("Images already set for " + (asFore ? "fore" : "back") + "ground set");
        for (File srcDir : srcDirs)
            for (File child : listFiles(srcDir))
                try {
                    MetaImage old = child.isFile() ? addImage(new MetaImage(child), asFore) : null;
                    if (old != null)
                        Log.error("Ignoring image " + child.getAbsolutePath() + " with size " + old.size + "; already found at " + old.file.getAbsolutePath());
                } catch (IOException e) {
                    Log.error("Unable to load image " + child.getAbsolutePath());
                }
        if (container(asFore).isEmpty()) {
            try {
                MetaImage meta = defaultImage == null
                        ? new MetaImage(ImageHound.class.getResourceAsStream(defaultResource))
                        : new MetaImage(defaultImage);
                addImage(meta, asFore);
            } catch (IOException e) {
                BaseUtils.throwException(new IOException("Unable to load default image at resource location " + defaultResource));
            }
        }
    }

    private Map<Integer, MetaImage> container(boolean asFore) {
        return asFore ? foreImages : backImages;
    }

    public List<Image> getDeclaredImages() {
        List<Image> files = new ArrayList<>();
        for (MetaImage foreImage : container(true).values())
            if (foreImage.isValid()) {
                MetaImage backImage = findBack(foreImage.size, true);
                files.add(foreImage.withBackground(backImage).withCanvas(foreImage.size).image);
            }
        return files;
    }

    public MetaImage findFore(int size, boolean required) {
        return find(size, true, required);
    }

    public MetaImage findBack(int size, boolean required) {
        return find((int) Math.round(size * BACK_SIZE_MULTIPLIER), false, required);
    }

    private MetaImage find(int size, boolean asFore, boolean required) {
        MetaImage found = findOptimumImage(size, asFore, required ? null : i -> i.size >= size);
        if (found.size == size) // invalid images already have correct size
            return found;
        found = found.resize(size);
        addImage(found, asFore);
        return found;
    }

    private MetaImage addImage(MetaImage img, boolean asFore) {
        if (!img.isValid())
            return null;
        MetaImage old = container(asFore).get(img.size);
        if (old != null)
            return old;
        container(asFore).put(img.size, img);
        return null;
    }

    private MetaImage findOptimumImage(int size, boolean asFore, Predicate<MetaImage> predicate) {
        MetaImage found = container(asFore).get(size);
        if (found != null)
            return found;
        Double lastScore = null;
        for (MetaImage current : container(asFore).values()) {
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
