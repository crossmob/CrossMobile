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

import com.panayotis.hrgui.HiResComponent;
import com.panayotis.hrgui.HiResEmptyBorder;
import com.panayotis.hrgui.HiResPanel;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public abstract class ProjectParameter {

    private static final HiResComponent NOT_INITIALIZED = () -> null;

    protected final ParamList properties;
    private Set<ParameterListener> listeners;
    private final Param key;
    private HiResComponent comp = NOT_INITIALIZED;
    private ActiveLabel identedParam = null;

    ProjectParameter(ParamList prop, Param key) {
        this.key = key;
        this.properties = prop;
    }

    public abstract String getValue();

    protected abstract String getVisualTag();

    protected boolean isSingleLineVisual() {
        return false;
    }

    public boolean shouldTrackChanges() {
        return true;
    }

    public final HiResComponent getIndentedComponent() {
        return identedParam;
    }

    public HiResComponent getVisuals() {
        if (comp == NOT_INITIALIZED) {
            HiResComponent base = initVisuals();
            if (base == null)
                comp = null;
            else {
                String tag = getVisualTag();
                if (tag == null)
                    tag = "";
                tag = tag.trim();
                if (tag.isEmpty())
                    comp = base;
                else {
                    HiResPanel panel = new HiResPanel(new BorderLayout());
                    panel.setOpaque(false);
                    ActiveLabel label = new ActiveLabel(getVisualTag());
                    label.setBorder(new HiResEmptyBorder(0, 0, 0, 8));
                    label.setOpaque(false);
                    panel.add(label, isSingleLineVisual() ? BorderLayout.WEST : BorderLayout.NORTH);
                    identedParam = isSingleLineVisual() ? label : null;
                    panel.add(initVisuals().comp(), BorderLayout.CENTER);
                    comp = panel;
                }
            }
        }
        if (comp == NOT_INITIALIZED)
            throw new RuntimeException("Component not initialized");
        return comp;
    }

    protected abstract HiResComponent initVisuals();

    public void updatePropertyList() {
        if (properties != null && key != null) {
            String value = getValue();
            if (value == null)
                properties.remove(key);
            else
                properties.put(key, value);
        }
    }

    public final ProjectParameter addParameterListener(ParameterListener<?> listener) {
        if (listener != null) {
            if (listeners == null)
                listeners = new HashSet<>();
            listeners.add(listener);
        }
        return this;
    }

    public final void removeParameterListener(ParameterListener listener) {
        if (listener != null && listeners != null)
            listeners.remove(listener);
    }

    public final void fireValueUpdated() {
        String value = getValue();
        if (key != null)
            if (value == null || value.isEmpty())
                properties.remove(key);
            else
                properties.put(key, value);
        if (listeners != null)
            for (ParameterListener listener : listeners)
                listener.updateParameter(this);
    }
}
