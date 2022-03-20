/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.List;

public class ProgressFinder {

    private final String[] progressTxt;
    private int index = -1;

    public ProgressFinder(List<String> progress) {
        this(progress == null ? null : progress.toArray(new String[progress.size()]));
    }

    public ProgressFinder(String... progress) {
        this.progressTxt = progress != null && progress.length < 1 ? null : progress;
    }

    public float nextEntry(CharSequence input) {
        if (progressTxt == null || (index + 1) >= progressTxt.length)
            return 1;
        String line = input.toString();
        for (int i = index + 1; i < progressTxt.length; i++)
            if (line.contains(progressTxt[i])) {
                index = i;
                break;
            }
        return (float) (index < 0 ? 0 : index) / progressTxt.length;
    }

}
