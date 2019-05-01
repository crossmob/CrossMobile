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

import com.panayotis.hrgui.HiResComboBox;
import com.panayotis.hrgui.HiResComponent;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

import static org.crossmobile.utils.FileUtils.removeExtension;

public abstract class FilteredFileParameter extends ProjectParameter {

    private final File basedir;
    private final Predicate<String> filter;
    private String file;

    public FilteredFileParameter(ParamList prop, Param key, File basedir, Predicate<String> namefilter) {
        super(prop, key);
        this.file = prop.get(key);
        this.basedir = basedir;
        this.filter = namefilter;
    }

    @Override
    public String getValue() {
        return file;
    }

    @Override
    protected boolean isSingleLineVisual() {
        return true;
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResComboBox<String> selection = new HiResComboBox<>();
        selection.addActionListener(event -> {
            Object selected = selection.getSelectedItem();
            if (selected != null && !selected.equals(file)) {
                file = selected.toString();
                fireValueUpdated();
            }
        });
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        selection.setModel(model);
        model.setSelectedItem(file);
        selection.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                model.removeAllElements();
                model.addElement("");
                AtomicReference<String> foundNoCase = new AtomicReference<>();
                AtomicBoolean found = new AtomicBoolean(false);
                String fileLC = file.toLowerCase();
                FileUtils.forAll(basedir, f -> filter.test(f.getName()), (s, f) -> {
                    String element = removeExtension(s + (s.isEmpty() ? "" : "/") + f.getName());
                    model.addElement(element);
                    if (element.equals(file)) {
                        model.setSelectedItem(element);
                        found.set(true);
                    } else if (element.toLowerCase().equals(fileLC))
                        foundNoCase.set(element);
                });
                if (!found.get())
                    if (foundNoCase.get() != null)
                        model.setSelectedItem(foundNoCase.get());
                    else
                        model.setSelectedItem("");
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        return selection;
    }
}
