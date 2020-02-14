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
package org.crossmobile.gui.parameters;

import com.panayotis.hrgui.*;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.elements.Theme;
import org.crossmobile.gui.parameters.MultiEntryParameter.SingleEntry;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public abstract class MultiEntryParameter<S extends SingleEntry> extends ProjectParameter {

    protected final char separator;
    private HiResPanel itemRows;

    public MultiEntryParameter(ParamList prop, Param key, char separator) {
        super(prop, key);
        this.separator = separator;
    }

    @Override
    public String getValue() {
        StringBuilder out = new StringBuilder();
        for (SingleEntry entry : getEntries())
            out.append(entry.getValue()).append(separator);
        if (out.length() > 0)
            out.deleteCharAt(out.length() - 1);
        return out.toString();
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResPanel up = new HiResPanel(new BorderLayout());
        HiResButton add = new HiResButton("Add");
        add.setOpaque(false);
        add.addActionListener((ActionEvent e) -> {
            if (addItemEvent())
                fireValueUpdated();
        });
        up.setOpaque(false);
        up.add(add, BorderLayout.EAST);
        up.add(new ActiveLabel(getVisualTag()), BorderLayout.WEST);

        itemRows = new HiResPanel(new GridLayout(0, 1)) {
            @Override
            public void revalidate() {
                Component[] complist = getComponents();
                for (int i = 0; i < complist.length; i++) {
                    JComponent current = (JComponent) complist[i];
                    if (i < (complist.length - 1))
                        current.setBorder(new HiResMatteBorder(0, 0, 1, 0, Theme.current().shortLine));
                    else
                        current.setBorder(null);
                }
                super.revalidate();
            }
        };
        itemRows.setOpaque(false);
        itemRows.setBorder(new HiResEmptyBorder(0, 12, 0, 0));
        List<S> items = getEntries();
        for (int i = 0; i < items.size(); i++)
            addVisualEntry(items.get(i));

        HiResPanel comp = new HiResPanel(new BorderLayout());
        comp.setOpaque(false);
        comp.add(itemRows, BorderLayout.CENTER);
        comp.add(up, BorderLayout.NORTH);
        return comp;
    }

    protected void addVisualEntry(final S entry) {
        if (entry == null)
            return;

        final HiResPanel row = new HiResPanel(new BorderLayout());
        row.setOpaque(false);
        row.setName(null);
        row.add(entry.getVisual().comp(), BorderLayout.CENTER);

        final HiResButton button = new HiResButton("Remove");
        button.setOpaque(false);
        button.addActionListener((ActionEvent e) -> {
            itemRows.remove(row);
            itemRows.revalidate();
            removeEntry(entry);
            fireValueUpdated();
        });

        row.add(button, BorderLayout.EAST);
        itemRows.add(row);
        itemRows.revalidate();
    }

    protected abstract List<S> getEntries();

    protected abstract boolean addItemEvent();

    protected abstract void removeEntry(S entry);

    public static class SingleEntry {

        private HiResComponent comp;
        private String value;

        public SingleEntry() {
        }

        public SingleEntry(String value) {
            this.value = value;
        }

        public HiResComponent getVisual() {
            if (comp == null)
                comp = new ActiveLabel(getVisualTag());
            return comp;
        }

        public String getVisualTag() {
            return value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof SingleEntry))
                return false;
            final SingleEntry other = (SingleEntry) obj;
            return !((this.value == null) ? (other.value != null) : !this.value.equals(other.value));
        }

        @Override
        public int hashCode() {
            return 133 + (this.value != null ? this.value.hashCode() : 0);
        }
    }
}
