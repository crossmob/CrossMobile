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
