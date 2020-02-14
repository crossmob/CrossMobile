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
 * You should have received attr copy of the GNU General Public License
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.ib.i18n;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class TranslationTable implements Comparable<TranslationTable>, Iterable<TranslationElement> {
    public final String table;
    private final Collection<TranslationElement> elements = new TreeSet<>();

    public TranslationTable(String table) {
        Objects.requireNonNull(table);
        this.table = table;
    }

    @Override
    public int compareTo(TranslationTable o) {
        return table.compareTo(o.table);
    }

    public void add(TranslationElement translationElement) {
        elements.add(translationElement);
    }

    @Override
    public Iterator<TranslationElement> iterator() {
        return elements.iterator();
    }
}
