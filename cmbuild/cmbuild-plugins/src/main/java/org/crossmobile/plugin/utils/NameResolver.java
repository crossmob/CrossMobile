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
package org.crossmobile.plugin.utils;

import org.crossmobile.plugin.model.MethodType;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.utils.Log;

import java.util.*;

import static org.crossmobile.plugin.utils.Collectors.findMostPopularNames;
import static org.crossmobile.plugin.utils.Texters.*;
import static org.crossmobile.utils.CollectionUtils.tail;
import static org.crossmobile.utils.NamingUtils.*;
import static org.crossmobile.utils.ReflectionUtils.isReservedWord;
import static org.crossmobile.utils.TextUtils.*;

public class NameResolver {

    private static final int MINIMUM_STRING_COMMON_SIZE = 3;

    private final Map<String, Set<NameEntry>> groupedSelectors = new HashMap<>();
    private final NObject nobj;

    public static boolean resolve(NObject nobj) {
        return new NameResolver(nobj).parse();
    }

    private NameResolver(NObject nobj) {
        this.nobj = nobj;
    }

    private boolean parse() {
        if (!searchForDuplicateNativeCode(nobj))
            return false;

        String typeName = guessTypeName(nobj);
        for (NSelector selector : nobj.getSelectors()) {
            if (selector.isConstructor() || selector.isGetter() || selector.isSetter() || selector.isInherited())
                continue;
            List<String> nameParts = getNameParts(selector);
            if (nameParts.get(0).startsWith(typeName))
                // in Delegates, the first argument is usually the name of the source object - remove this name if possible
                if (nameParts.get(0).length() == typeName.length())
                    if (selector.getMethodType() == MethodType.SELECTOR)
                        add(new NameEntry(nameParts.get(1), tail(nameParts), selector));
                    else {
                        String javaName = selector.getJavaExecutable().getName();
                        String possibleName = commonPartialText(nameParts.get(0), javaName, false);
                        if (possibleName.equals(javaName))
                            add(new NameEntry(javaName, nameParts, selector));
                        else
                            add(new NameEntry("", nameParts, selector));    // Will break later on
                    }
                else
                    add(new NameEntry(nameParts.get(0).substring(typeName.length()), nameParts, selector));
            else
                add(new NameEntry(nameParts.get(0), nameParts, selector));
        }

        // group selectors by base name
        boolean dirty = true;
        Set<NameEntry> toRemove = new HashSet<>();
        Set<NameEntry> toAdd = new HashSet<>();
        while (dirty) {
            dirty = false;
            for (String hash : groupedSelectors.keySet()) {
                Set<NameEntry> group = groupedSelectors.get(hash);
                if (group.size() > 1) {
                    dirty = true;
                    for (NameEntry namer : group) {
                        NameEntry deeper = namer.deeper();
                        if (deeper != null) {
                            toRemove.add(namer);
                            toAdd.add(deeper);
                        }
                    }
                }
            }
            if (dirty == true && toAdd.isEmpty()) {
                // No changes
                Log.error("Naming loop detected when trying to guess naming scheme for class " + getClassNameFull(nobj.getType()) + " .");
                break;
            }
            for (NameEntry entry : toRemove)
                remove(entry);
            for (NameEntry entry : toAdd)
                add(entry);
            toRemove.clear();
            toAdd.clear();
        }

        // Check names
        boolean correct = true;
        for (String hash : groupedSelectors.keySet()) {
            NameEntry entry = groupedSelectors.get(hash).iterator().next();
            String existingName = entry.origin.getJavaExecutable().getName();
            String calculatedName = isReservedWord(entry.methodName) ? capitalize(entry.methodName) : entry.methodName;
            if (calculatedName.isEmpty()) {
                Log.error("Unable to match name of method " + execSignature(entry.origin.getJavaExecutable()) + " with native code `" + entry.origin.getOriginalCode() + "` ; another method name should be provided");
                correct = false;
            } else if (!existingName.equals(calculatedName) && !isMethodInherited(entry.origin)) {
                // Check mathing name of other selectors
                if (existingName.toLowerCase().equals(calculatedName.toLowerCase()))
                    Log.error("Name of method `" + execSignature(entry.origin.getJavaExecutable()) + "` has wrong casing, expected `" + calculatedName + "`, compared to native code `" + entry.origin.getOriginalCode() + "`");
                else
                    Log.error("Μethod `" + execSignature(entry.origin.getJavaExecutable()) + "` should be named " + calculatedName + " ; native code provided: " + entry.origin.getOriginalCode());
                correct = false;
            }
        }
        return correct;
    }

    private boolean searchForDuplicateNativeCode(NObject nobj) {
        Map<String, NSelector> allSignatures = new HashMap<>();
        boolean correct = true;
        for (NSelector sel : nobj.getSelectors()) {
            String sig = selectorSignature(sel);
            if (allSignatures.containsKey(sig)) {
                Log.error("Unable to parse class " + getClassNameFull(nobj.getType()) + " for consistent Java naming: native Selector `" + sel.getOriginalCode() + "` at method " + execSignature(sel.getJavaExecutable()) + " has been already defined at method " + execSignature(allSignatures.get(sig).getJavaExecutable()));
                correct = false;
            } else
                allSignatures.put(sig, sel);
        }
        return correct;
    }

    private final class NameEntry {

        private final NSelector origin;
        private final String methodName;
        private final List<String> rest;

        private NameEntry(String methodName, List<String> fullList, NSelector origin) {
            this.origin = origin;
            String basename = (methodName.length() > 1 && methodName.substring(0, 2).toUpperCase().equals(methodName.substring(0, 2)))
                    ? methodName
                    : decapitalize(methodName);
            this.methodName = basename;
            this.rest = fullList.subList(1, fullList.size());
        }

        private NameEntry deeper() {
            return rest.isEmpty() ? null : new NameEntry(methodName + capitalize(rest.get(0)), rest, origin);
        }

        private String hash() {
            return nobj.isProtocol() ? methodName : methodName + paramHash(origin);
        }
    }

    private void remove(NameEntry entry) {
        String hash = entry.hash();
        Set<NameEntry> set = groupedSelectors.get(hash);
        set.remove(entry);
        if (set.isEmpty())
            groupedSelectors.remove(hash);
    }

    private void add(NameEntry sel) {
        String hash = sel.hash();
        Set<NameEntry> selectors = groupedSelectors.get(hash);
        if (selectors == null) {
            selectors = new HashSet<>();
            groupedSelectors.put(hash, selectors);
        }
        selectors.add(sel);
    }

    private static String guessTypeName(NObject nobj) {
        if (!nobj.getType().isInterface() && !nobj.isCBased())
            return getClassNameSimple(nobj.getType());
        Map<String, Integer> names = new HashMap<>();
        for (NSelector sel : nobj.getSelectors())
            if (!isMethodInherited(sel) && !sel.getParams().isEmpty()) {
                String classname = getClassNameSimple(sel.getParams().get(0).getNType().getType());
                String prefix = commonPartialText(classname, sel.getName(), true);
                if (!prefix.isEmpty()) {
                    Integer count = names.get(prefix);
                    count = count == null ? 1 : count++;
                    names.put(prefix, count);
                }
            }
        if (names.isEmpty())
            return getClassNameSimple(nobj.getType());
        if (names.size() == 1)
            return names.keySet().iterator().next();

        List<String> popular = findMostPopularNames(names);
        if (popular.size() == 1)
            return popular.iterator().next();

        Collections.sort(popular);
        Collections.reverse(popular);
        return findMaxInSize(popular);
    }

    private static boolean isMethodInherited(NSelector selector) {
        NObject nobj = selector.getContainer();
        return nobj.getType().isInterface() && !selector.getJavaExecutable().getDeclaringClass().equals(nobj.getType());
    }

    private static String commonPartialText(String base, String search, boolean trimNamespace) {
        String[] baseV = camelCaseSplit(base, trimNamespace);
        String[] baseL = lowerCase(baseV);
        String[] searchV = camelCaseSplit(search);
        String[] searchL = lowerCase(searchV);
        StringBuilder result = new StringBuilder();
        int baseIdx = 0, searchIdx = 0;
        while (baseIdx < baseL.length && searchIdx < searchL.length)
            if (!baseL[baseIdx].equals(searchL[searchIdx]))
                baseIdx++;
            else {
                result.append(searchV[searchIdx]);
                baseIdx++;
                searchIdx++;
            }
        return result.length() >= MINIMUM_STRING_COMMON_SIZE ? result.toString() : "";
    }
}
