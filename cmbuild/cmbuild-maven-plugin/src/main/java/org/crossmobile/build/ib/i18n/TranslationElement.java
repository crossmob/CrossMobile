/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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

