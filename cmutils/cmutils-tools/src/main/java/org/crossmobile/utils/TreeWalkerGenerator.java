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

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

public class TreeWalkerGenerator {

    final Collection<String> application;
    final Collection<String> otherfiles;
    final int foldersToGoUp;

    public TreeWalkerGenerator(Collection<String> application, Collection<String> otherfiles, int foldersToGoUp) {
        this.application = application == null ? Collections.EMPTY_LIST : application;
        this.otherfiles = otherfiles == null ? Collections.EMPTY_LIST : otherfiles;
        this.foldersToGoUp = foldersToGoUp;
    }

    public TreeWalkerEntry getEntry(Consumer<File> foundFile, String... origLocations) {
        return new TreeWalkerEntry(this, foundFile, origLocations == null || origLocations.length == 0 ? null : Arrays.asList(origLocations));
    }

}
