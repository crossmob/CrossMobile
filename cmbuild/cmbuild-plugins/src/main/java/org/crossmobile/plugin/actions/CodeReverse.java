/*
 * (c) 2019 by Panayotis Katsaloulis
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
import org.crossmobile.plugin.objc.ReverseBlockRegistry;
import org.crossmobile.plugin.objc.SelectorEmitterReverse;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.utils.Streamer;
import org.crossmobile.utils.NativeCodeCollection;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.crossmobile.plugin.reg.PluginRegistry.getPlugin;
import static org.crossmobile.utils.NamingUtils.execSignature;

public final class CodeReverse {

    private final Map<String, ReverseCodeEntries> entries = new HashMap<>();
    private final ReverseBlockRegistry handleRegistry = new ReverseBlockRegistry();
    private final ClassPool cp;

    public CodeReverse(ClassPool cp) {
        this.cp = cp;
        for (NObject obj : ObjectRegistry.retrieveAll())
            if (obj.needsOverrideBindings()) {
                String plugin = getPlugin(obj.getType().getName());
                entries.computeIfAbsent(plugin, p -> new ReverseCodeEntries()).addObject(obj);
            }
    }

    public String toString(String plugin) {
        ReverseCodeEntries reverse = entries.get(plugin);
        return reverse == null ? "{}" : reverse.toString();
    }

    Iterable<String> getClasses(String plugin) {
        ReverseCodeEntries reverse = entries.get(plugin);
        return reverse == null ? Collections.emptyList() : reverse.map.getClassMethodCode().keySet();
    }

    private class ReverseCodeEntries {

        private final NativeCodeCollection map = new NativeCodeCollection(cp);

        private void addObject(NObject obj) {
            for (NSelector sel : obj.getSelectors())
                if (sel.needsOverrideBindings()) {
                    Streamer out = Streamer.asString();
                    try {
                        String signature = getSelectorSignature(sel);
                        new SelectorEmitterReverse(sel, handleRegistry).emitImplementation(out);
                        map.add(signature, obj.getType(), out.toString(), handleRegistry.getIncludesFrom(obj.getType(), signature));
                    } catch (IOException ignored) {
                    }
                }
        }

        @Override
        public String toString() {
            try {
                return JsonHelper.encode(map.getClassMethodCode(), true);
            } catch (Exception ex) {
                BaseUtils.throwException(ex);
                return "";
            }
        }
    }

    public ReverseBlockRegistry getHandleRegistry() {
        return handleRegistry;
    }

    public static String getSelectorSignature(NSelector selector) {
        return execSignature(selector.getJavaExecutable(), false);
    }
}
