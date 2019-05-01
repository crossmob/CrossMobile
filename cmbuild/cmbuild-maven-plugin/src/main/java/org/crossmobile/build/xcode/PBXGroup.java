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

import static org.crossmobile.build.utils.PlistUtils.*;

public class PBXGroup extends PBXObject {

    private final Collection<String> children;
    private final String name;
    private final String sourceTree;

    public PBXGroup(String id, NSDictionary data) {
        super(id, data);
        this.name = getStringMaybe(getPath(data, "name"));
        this.sourceTree = getPath(data, "sourceTree").toString();
        children = arrayToCollection((NSArray) getPath(data, "children"));
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void addChild(String child) {
        children.add(child);
    }

    @Override
    public NSDictionary getData() {
        NSDictionary data = new NSDictionary();
        data.put("isa", isa);
        data.put("children", NSObject.wrap(children.toArray()));
        data.put("name", name);
        data.put("sourceTree", sourceTree);
        return data;
    }
}
