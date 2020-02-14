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
package org.crossmobile.build.ib;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.ib.helper.RealElement;
import org.crossmobile.build.ib.i18n.IBParserMeta;
import org.crossmobile.utils.Log;

import java.util.*;

import static org.crossmobile.build.ib.Elements.*;
import static org.crossmobile.build.ib.i18n.TranslationElement.toKey;

public abstract class Element {

    protected static final String I1 = "  ";
    protected static final String I2 = "    ";
    protected static final String I3 = "      ";
    protected static final String I4 = "        ";
    protected static final String I5 = "          ";
    protected static final String I6 = "            ";
    protected static final String I7 = "              ";
    protected static final String NEWLINE = "\n";

    private final Map<String, Value> supportedAttributes = new HashMap<>();
    private final Map<String, Element> supportedNamed = new HashMap<>();
    private final List<Element> supportedUnnamed = new ArrayList<>();

    private final Map<String, Value> attributes = new HashMap<>();
    private final Map<String, Value.LocalizedString> localizedAttributes = new HashMap<>();
    private final Map<String, Element> named = new HashMap<>();
    private final List<Element> unnamed = new ArrayList<>();

    private IBParserMeta meta;

    public Element() {
    }

    public Element(IBParserMeta meta) {
        this.meta = meta;
    }

    public IBParserMeta getMeta() {
        return meta;
    }

    protected void addSupportedAttribute(String name, Value attribute) {
        supportedAttributes.put(name, attribute);
    }

    protected void addSupportedChild(Element element) {
        addSupportedChild(null, element);
    }

    protected void addSupportedChild(String key, Element element) {
        if (key == null)
            supportedUnnamed.add(element);
        else
            supportedNamed.put(key, element);
    }

    protected abstract void addSupported();

    public abstract String toCode();

    protected String capitalize(String item) {
        return item == null ? null : (item.length() > 0 ? item.substring(0, 1).toUpperCase() + item.substring(1) : "");
    }

    @SuppressWarnings({"UseSpecificCatch"})
    private Element model() {
        return getModel(null, getName(this));
    }

    public void setAttribute(String attributeName, String attributeValue) {
        Value modelValue = model().supportedAttributes.get(attributeName);
        if (modelValue == null)
            Log.warning(getName(this) + ": unknown attribute " + attributeName);
        else {
            Value value = modelValue.newInstance(attributeValue);
            attributes.put(attributeName, value);
            if (value instanceof Value.LocalizedString)
                localizedAttributes.put(attributeName, (Value.LocalizedString) value);
        }
    }

    public Element addChild(String childName, String childKey, IBParserMeta meta) {
        String name = getName(this);
        Element model_parent = model();
        Element model_child = Elements.getModel(name, childName);

        if (model_child == null || model_child == Nil)
            return null;
        if (childKey == null || childKey.trim().isEmpty()) {
            if (!model_parent.supportedUnnamed.contains(model_child)) {
                Log.warning(name + ": unsupported item " + childName);
                return null;
            }
        } else if (!model_parent.supportedNamed.containsKey(childKey)) {
            Log.warning(name + ": unsupported key " + childKey + " of type " + childName);
            return null;
        } else if (!model_parent.supportedNamed.get(childKey).equals(model_child)) {
            Log.warning(name + ": key " + childKey + " of type " + childName + " not compatible with " + model().supportedNamed.get(childKey));
            return null;
        }
        try {
            Element child = model_child.getClass().newInstance();
            if (childKey == null || childKey.trim().isEmpty())
                unnamed.add(child);
            else
                named.put(childKey, child);
            child.meta = meta;
            return child;
        } catch (InstantiationException | IllegalAccessException ex) {
            return BaseUtils.throwException(ex);
        }
    }

    protected String attr(String name) {
        return attr(name, null, false);
    }

    protected String attr(String name, String deflt) {
        return attr(name, deflt, false);
    }

    protected String attrName(String name) {
        return attr(name, null, true);
    }

    private String attr(String name, String deflt, boolean plain) {
        Value v = attributes.get(name);
        if (v != null)
            return plain ? v.getPlainValue() : v.getValue();
        if (deflt == null)
            return null;
        v = model().supportedAttributes.get(name).newInstance(deflt);
        return plain ? v.getPlainValue() : v.getValue();
    }

    public <T extends Element> Collection<T> parts(T filter) {
        Collection<T> result = new ArrayList<>();
        Class filterClass = filter == null ? null : filter.getClass();
        for (Element el : unnamed)
            if (filterClass == null || filterClass.isAssignableFrom(el.getClass()))
                result.add((T) el);
        return result;
    }

    public <T extends Element> Collection<T> namedParts(T filter) {
        Collection<T> result = new ArrayList<>();
        Class filterClass = filter == null ? null : filter.getClass();
        for (Element el : named.values())
            if (filterClass == null || filterClass.isAssignableFrom(el.getClass()))
                result.add((T) el);
        return result;
    }

    protected Element item(String key) {
        return named.get(key);
    }

    protected String value(String key) {
        Element c = item(key);
        return c == null ? null : c.toCode();
    }

    public void performChecks() {
    }

    public void applyLocalizations(Element parent) {
        if (!meta.currentFileIsLocalizable())
            return;
        for (String attributeName : localizedAttributes.keySet()) {
            String className;
            Value.LocalizedString value = localizedAttributes.get(attributeName);
            String id = attrName("id");
            if (id == null) {   // The localizations meta data are found in the parent object, and are multiplexed with current state
                id = parent.attrName("id");
                attributeName = attrName("key") + capitalize(attributeName);
                className = ((RealElement) parent).getClassName();
            } else
                className = ((RealElement) this).getClassName();

            if (id == null) {
                Log.error("Unable to locate id of localized item " + attributeName);
                continue;
            }
            if (className == null) {
                Log.error("Unable to locate type of localized item " + attributeName);
                continue;
            }
            value.updateLocalized(toKey(id, attributeName), meta.current().table);
            meta.addLocalization(className, id, attributeName, value.getPlainValue());
        }
    }
}

