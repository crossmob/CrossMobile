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
package org.crossmobile.xray;

import com.panayotis.xray.prop.PropertyVisuals;
import com.panayotis.xray.prop.visuals.PropertyTreeDecorator;
import com.panayotis.xray.prop.visuals.PropertyTreeModel;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.panayotis.ce.CEventCommons.CHANGE_DEBUG_GRAPHICS;
import static com.panayotis.ce.CEventManager.fireEvent;
import static com.panayotis.xray.utils.ReflectionUtils.getHierarchy;
import static com.panayotis.xray.utils.TextUtils.getNameFromClass;
import static com.panayotis.xray.utils.TextUtils.removePackageName;

class UIKitVisuals extends PropertyVisuals<Object> {

    UIKitVisuals(ReflectionClassSupport refl) {
        super(new UIKitModel(refl));
        setResolver(new UIKitResolver(refl));
        setHarvester(new AnnotatedPropertyHarvester(refl));
        setSorter(new UIKitSorter(refl));
        update();

        ToggleButton editmode = new ToggleButton("/icons/editmode.png");
//        addToolbarButton(editmode);
        editmode.addActionListener(e -> UIKitXRayPlugin.editMode = editmode.isSelected());

        ToggleButton graphics = new ToggleButton("/icons/paint.png");
        addToolbarButton(graphics);
        graphics.addActionListener(e -> fireEvent(CHANGE_DEBUG_GRAPHICS, graphics.isSelected()));
    }
}

class UIKitModel implements PropertyTreeModel<Object> {

    private static final Object APPROOT = new Object();
    private static final HashMap<String, Icon> icons = new HashMap<>();
    private static final HashMap<String, Boolean> packed = new HashMap<>();
    private final ReflectionClassSupport rcs;


    static {
        icons.put("uiview", new ImageIcon(UIKitModel.class.getResource("/icons/view.png")));
        icons.put("uiwindow", new ImageIcon(UIKitModel.class.getResource("/icons/window.png")));
        icons.put("uibutton", new ImageIcon(UIKitModel.class.getResource("/icons/button.png")));
        icons.put("uiimageview", new ImageIcon(UIKitModel.class.getResource("/icons/image.png")));
        icons.put("uilabel", new ImageIcon(UIKitModel.class.getResource("/icons/label.png")));
        icons.put("uislider", new ImageIcon(UIKitModel.class.getResource("/icons/slider.png")));
        icons.put("uiswitch", new ImageIcon(UIKitModel.class.getResource("/icons/switch.png")));
        icons.put("uitextfield", new ImageIcon(UIKitModel.class.getResource("/icons/textfield.png")));
        icons.put("uitextview", new ImageIcon(UIKitModel.class.getResource("/icons/textview.png")));
        icons.put("uitableview", new ImageIcon(UIKitModel.class.getResource("/icons/table.png")));
        icons.put("uitableviewcell", new ImageIcon(UIKitModel.class.getResource("/icons/tablecell.png")));
        icons.put("uistackview", new ImageIcon(UIKitModel.class.getResource("/icons/stack.png")));
        icons.put("uinavigationbar", new ImageIcon(UIKitModel.class.getResource("/icons/navigation.png")));
        icons.put("uitoolbar", new ImageIcon(UIKitModel.class.getResource("/icons/toolbar.png")));
        icons.put("uitabbar", new ImageIcon(UIKitModel.class.getResource("/icons/tabbar.png")));
        icons.put("uinavigationcontroller$navigationview", new ImageIcon(UIKitModel.class.getResource("/icons/controllerview.png")));
        icons.put("uitabbarcontroller$uitabbar", new ImageIcon(UIKitModel.class.getResource("/icons/controllerview.png")));

        packed.put("uibutton", false);
        packed.put("uitoolbar", false);
        packed.put("uinavigationbar", false);
        packed.put("uitableviewcell", false);
    }

    UIKitModel(ReflectionClassSupport rcs) {
        this.rcs = rcs;
    }

    @Override
    public Object getRoot() {
        return APPROOT;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object> getChildren(Object item) {
        try {
            if (item == APPROOT) {
                Object appinstance = rcs.uiapplication.getMethod("sharedApplication").invoke(null);
                return (List<Object>) rcs.uiapplication.getMethod("windows").invoke(appinstance);
            } else {
                return (List<Object>) rcs.uiview.getMethod("subviews").invoke(item);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isOpenByDefault(Object item) {
        return findValue(item, packed, true);
    }

    @Override
    public PropertyTreeDecorator<Object> getTreeDecorator() {
        return new PropertyTreeDecorator<Object>() {
            @Override
            public String getName(Object item) {
                return getNameFromClass(item.getClass(), "(^UI|^CG)", true);
            }

            @Override
            public Icon getIcon(Object item) {
                return findValue(item, icons, null);
            }
        };
    }

    private static <T> T findValue(Object item, HashMap<String, T> dictionary, T deflt) {
        for (Class<?> c : getHierarchy(item.getClass())) {
            T value = dictionary.get(removePackageName(c.getName()).toLowerCase());
            if (value != null)
                return value;
        }
        return deflt;
    }
}
