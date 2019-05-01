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
package org.crossmobile.gui.parameters;

import org.crossmobile.gui.parameters.MultiEntryParameter.SingleEntry;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleMultiEntryParameter extends MultiEntryParameter<SingleEntry> {

    private final List<SingleEntry> list;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public SimpleMultiEntryParameter(ParamList params, Param key, String entries, char separator) {
        super(params, key, separator);
        list = new ArrayList<>();
        if (entries != null) {
            entries = entries.trim();
            if (!entries.isEmpty())
                for (String part : entries.split(String.valueOf(separator)))
                    list.add(newSingleEntry(part));
        }
    }

    @Override
    protected List<SingleEntry> getEntries() {
        return list;
    }

    @Override
    protected void removeEntry(SingleEntry entry) {
        list.remove(entry);
    }

    protected void addEntry(SingleEntry entry) {
        if (!list.contains(entry)) {
            list.add(entry);
            addVisualEntry(entry);
        }
    }

    protected SingleEntry newSingleEntry(String value) {
        return new SingleEntry(value);
    }
}
