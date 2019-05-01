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
package org.crossmobile.plugin.model;

import static org.crossmobile.utils.TextUtils.capitalize;

public class NProperty extends NParsable {

    private NType type;
    private String name;
    private boolean weak = false;
    private boolean readonly;
    private boolean copy;
    private boolean objcBased;
    private String getter;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public NType getType() {
        return type;
    }

    public void setType(NType type) {
        this.type = type;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public String getGetter() {
        return getter != null ? getter :
                objcBased ? name : "get" + capitalize(name);
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    public boolean isWeak() {
        return weak;
    }

    public boolean isCopy() {
        return copy;
    }

    public void setCopy(boolean copy) {
        this.copy = copy;
    }

    public void setObjcBased(boolean objcBased) {
        this.objcBased = objcBased;
    }
}
