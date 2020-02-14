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
package org.crossmobile.build.utils;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import org.crossmobile.utils.Log;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.crossmobile.utils.CollectionUtils.*;
import static org.crossmobile.utils.FileUtils.getExtension;

public class PlistUtils {

    public static final NSObject getPath(NSObject data, String... path) {
        return getPath(data, Arrays.asList(path));
    }

    public static final NSObject getPath(NSObject data, Collection<String> path) {
        if (data instanceof NSDictionary && path != null && !path.isEmpty()) {
            NSObject value = ((NSDictionary) data).get(head(path));
            Collection<String> tail = tail(path);
            return (tail.isEmpty() ? value : getPath(value, tail));
        }
        return null;
    }

    public static final String getStringMaybe(NSObject object) {
        return object == null ? null : object.toString();
    }

    public static final boolean containsElement(NSArray data, String value) {
        if (data == null || value == null)
            return false;
        value = value.toLowerCase();
        for (NSObject o : data.getArray())
            if (o.toString().toLowerCase().equals(value))
                return true;
        return false;
    }

    public static <T> Collection<T> filterObjects(NSDictionary data, String isa, BiFunction<String, NSDictionary, T> constructor) {
        isa = isa.toLowerCase();
        Collection<T> files = new ArrayList<>();
        NSDictionary objects = (NSDictionary) getPath(data, "objects");
        for (String id : objects.keySet()) {
            NSDictionary dic = (NSDictionary) objects.get(id);
            if (getStringMaybe(getPath(dic, "isa")).toLowerCase().equals(isa))
                files.add(constructor.apply(id, dic));
        }
        return files;
    }

    public static final Collection<String> arrayToCollection(NSArray array) {
        List<String> list = new ArrayList<>();
        for (NSObject item : array.getArray())
            list.add(item.toString());
        return list;
    }

    public static String getFileType(String filename) {
        switch (getExtension(filename).toLowerCase()) {
            case "c":
                return "sourcecode.c.c";
            case "cpp":
                return "sourcecode.cpp.cpp";
            case "m":
                return "sourcecode.c.objc";
            case "mm":
                return "sourcecode.cpp.objcpp";
            case "h":
                return "sourcecode.c.h";
            case "swift":
                return "sourcecode.swift";
            default:
                Log.warning("Unknown file type: " + filename);
                return null;
        }
    }

    public static boolean isCompilable(String filename) {
        switch (getExtension(filename).toLowerCase()) {
            case "c":
            case "cpp":
            case "m":
            case "mm":
            case "swift":
                return true;
            default:
                return false;
        }
    }

    public static boolean isInclude(String filename) {
        return getExtension(filename).toLowerCase().equals("h");
    }

    public static NSDictionary findEntryWithChild(NSDictionary dic, String childkey, String childvalue) {
        Iterator<NSDictionary> found = findEntriesWithChild(dic, childkey, childvalue).iterator();
        return found.hasNext() ? found.next() : null;
    }

    public static Iterable<NSDictionary> findEntriesWithChild(NSDictionary dic, String childkey, String childvalue) {
        Collection<NSDictionary> found = new ArrayList<>();
        for (String key : dic.keySet()) {
            NSObject child = dic.get(key);
            if (child instanceof NSDictionary) {
                NSObject result = ((NSDictionary) child).get(childkey);
                if (result != null && result.toString().equals(childvalue))
                    found.add((NSDictionary) child);
            }
        }
        return found;
    }

    public static <T> NSArray toArray(Collection<T> collection, Function<T, ? extends NSObject> conv) {
        return new NSArray(asList(collection, conv).toArray(new NSObject[collection.size()]));
    }

    public static class SafeRef {

        private final NSDictionary dic;
        int idx = 1;

        public SafeRef(NSDictionary dic) {
            this.dic = dic;
        }

        public String put(Object value) {
            String key;
            while (dic.containsKey(key = String.valueOf(idx)))
                idx++;
            dic.put(key, value);
            return key;
        }
    }
}
