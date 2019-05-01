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
package org.crossmobile.build.xcode;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;

import java.util.Collection;

import static org.crossmobile.build.utils.PlistUtils.arrayToCollection;
import static org.crossmobile.build.utils.PlistUtils.getPath;

public class PBXBuildPhase extends PBXAny {

    private Collection<String> files;

    public PBXBuildPhase(String id, NSDictionary data) {
        super(id, data);
        files = arrayToCollection((NSArray) getPath(data, "files"));
    }

    @Override
    public String toString() {
        return id + " PBXBuildPhase{"
                + getData()
                + ", files=" + files
                + '}';
    }

    public void setFiles(Collection<String> files) {
        this.files = files;
    }

    @Override
    public NSDictionary getData() {
        data.put("files", NSObject.wrap(files.toArray()));
        return data;
    }
}
