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
package org.crossmobile.build.ib.i18n;

public class TranslationElement implements Comparable<TranslationElement> {
    public final String classType;
    public final String key;
    public final String objectId;
    public final String property;
    public final String text;

    public static String toKey(String objectId, String property) {
        return objectId + "." + property;
    }

    public TranslationElement(String classType, String itemID, String property, String text) {
        this.classType = classType;
        this.objectId = itemID;
        this.property = property;
        this.text = text;
        this.key = toKey(objectId, property);
    }

    @Override
    public int compareTo(TranslationElement o) {
        int v = classType.compareTo(o.classType);
        if (v == 0) {
            v = objectId.compareTo(o.objectId);
            if (v == 0) {
                v = property.compareTo(o.property);
                if (v == 0)
                    v = 1;  // Shouldn't come here
            }
        }
        return v;
    }

    @Override
    public String toString() {
        return "TranslationElement{" +
                "classType='" + classType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", property='" + property + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

