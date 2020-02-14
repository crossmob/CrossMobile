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
package org.crossmobile.plugin.actions;

import javassist.ClassPool;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.bridge.system.JsonHelper;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.objc.ReverseImportRegistry;
import org.crossmobile.plugin.objc.SelectorEmitter;
import org.crossmobile.plugin.objc.SelectorEmitterReverse;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.utils.Streamer;
import org.crossmobile.plugin.utils.Texters;
import org.crossmobile.utils.CustomTypeClasses;
import org.crossmobile.utils.ReverseCodeCollection;

import java.io.IOException;
import java.util.*;

import static org.crossmobile.plugin.reg.PluginRegistry.getPlugin;
import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.utils.ReflectionUtils.getBareClass;

public final class ReverseCode {

    private final Map<String, Factory> entries = new TreeMap<>();
    private final ReverseImportRegistry handleRegistry = new ReverseImportRegistry();
    private final ClassPool cp;

    public ReverseCode(ClassPool cp) {
        this.cp = cp;
        for (NObject obj : ObjectRegistry.retrieveAll())
            if (obj.needsOverrideBindings()) {
                String plugin = getPlugin(obj.getType().getName());
                entries.computeIfAbsent(plugin, p -> new Factory()).attachObject(obj);
            }
    }

    public String toString(String plugin) {
        Factory reverse = entries.get(plugin);
        return reverse == null ? "{}" : reverse.toString();
    }

    Iterable<String> getListOfClasses(String plugin) {
        Factory reverse = entries.get(plugin);
        return reverse == null ? Collections.emptyList() : reverse.codeCollection.getClassMethodCode().keySet();
    }

    private class Factory {

        private final ReverseCodeCollection codeCollection = new ReverseCodeCollection(cp);

        private void attachObject(final NObject obj) {
            NObject current = obj;
            Collection<NSelector> selectors = new TreeSet<>();
            while (current != null) {
                current.getSelectors().stream().filter(NSelector::needsOverrideBindings).forEach(selectors::add);
                current = ObjectRegistry.retrieve(current.getType().getSuperclass());
            }
            for (Class<?> inter : obj.getType().getInterfaces()) {
                NObject interClass = ObjectRegistry.retrieve(inter);
                if (interClass != null)
                    selectors.addAll(interClass.getSelectors());
            }

            for (NSelector sel : selectors)
                attachSelector(sel, obj, sel.getContainer().isProtocol() || sel.getContainer() == obj);
        }

        private void attachSelector(NSelector sel, NObject obj, boolean shouldEmitMethods) {
            try {
                String signature = Texters.getSelectorSignature(sel);
                Streamer reverseCode = Streamer.asString();
                Streamer superCode = Streamer.asString();
                Collection<String> reverseImports = Collections.emptyList();
                Collection<String> superImports = Collections.emptyList();
                if (shouldEmitMethods) {
                    new SelectorEmitterReverse(sel, handleRegistry).emitImplementation(reverseCode);
                    reverseImports = handleRegistry.getReverseImports(obj.getType(), signature);
                    new SelectorEmitter(sel, "super").emitImplementation(superCode);
                    superImports = getSuperImports(sel);
                }
                codeCollection.addFromSource(signature, obj.getType()
                        , reverseCode.toString(), superCode.toString()
                        , reverseImports, superImports);
            } catch (IOException ignored) {
            }
        }

        private Collection<String> getSuperImports(NSelector sel) {
            Collection<String> imports = new TreeSet<>();
            sel.getParams().stream().map(p -> getIncludeName(p.getNType())).filter(Objects::nonNull).forEach(imports::add);
            String returnName = getIncludeName(sel.getReturnType());
            if (returnName != null)
                imports.add(returnName);
            return imports;
        }

        private String getIncludeName(NType type) {
            Class<?> cls = getBareClass(type.getType());
            if (cls.isPrimitive() || CustomTypeClasses.VoidRef.class == cls)
                return null;
            return toObjC(cls);
        }

        @Override
        public String toString() {
            try {
                return JsonHelper.encode(codeCollection.getClassMethodCode(), true);
            } catch (Exception ex) {
                BaseUtils.throwException(ex);
                return "";
            }
        }
    }

    ReverseImportRegistry getHandleRegistry() {
        return handleRegistry;
    }

}
