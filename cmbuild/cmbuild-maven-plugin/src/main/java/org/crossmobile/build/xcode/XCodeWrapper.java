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
package org.crossmobile.build.xcode;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.Log;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.*;
import java.util.function.BiFunction;

import static org.crossmobile.build.utils.PlistUtils.filterObjects;
import static org.crossmobile.build.utils.PlistUtils.getPath;

public class XCodeWrapper {

    private static final Map<String, BiFunction<String, NSDictionary, PBXObject>> objectMapper;
    private static final BiFunction<String, NSDictionary, PBXObject> defaultObjectMapper;

    private final NSDictionary base;
    private final Map<String, Collection<PBXObject>> objects;
    private BigInteger currentId;

    static {
        objectMapper = new HashMap<>();
        objectMapper.put("PBXBuildFile", PBXBuildFile::new);
        objectMapper.put("PBXFileReference", PBXFileReference::new);
        objectMapper.put("PBXSourcesBuildPhase", PBXBuildPhase::new);
        objectMapper.put("PBXFrameworksBuildPhase", PBXBuildPhase::new);
        objectMapper.put("PBXResourcesBuildPhase", PBXBuildPhase::new);
        objectMapper.put("XCConfigurationList", XCConfigurationList::new);
        objectMapper.put("XCBuildConfiguration", XCBuildConfiguration::new);
        objectMapper.put("PBXProject", PBXProject::new);
        objectMapper.put("PBXNativeTarget", PBXNativeTarget::new);
        objectMapper.put("PBXGroup", PBXGroup::new);
        objectMapper.put("PBXVariantGroup", PBXGroup::new);

        defaultObjectMapper = PBXAny::new;
    }

    public static XCodeWrapper load(String xcodeproj) {
        try {
            NSObject obj = PropertyListParser.parse(new File(xcodeproj));
            Log.debug(obj == null ? null : obj.toString());
            if (obj instanceof NSDictionary)
                return new XCodeWrapper((NSDictionary) obj);
        } catch (IOException | PropertyListFormatException | ParseException | ParserConfigurationException | SAXException ex) {
            return BaseUtils.throwException(ex);
        }
        return null;
    }

    private XCodeWrapper(NSDictionary data) {
        this.base = data;
        Collection<String> objectTypes = new ArrayList<>();
        NSDictionary obj = (NSDictionary) getPath(data, "objects");
        for (String id : obj.keySet())
            objectTypes.add(getPath((NSDictionary) obj.get(id), "isa").toString());

        objects = new HashMap<>();
        for (String type : objectTypes) {
            BiFunction<String, NSDictionary, PBXObject> constr = objectMapper.get(type);
            if (constr == null)
                constr = defaultObjectMapper;
            objects.put(type, filterObjects(data, type, constr));
        }
    }

    public boolean save(File out) {
        try {
            Map<String, Object> obj = new HashMap<>();
            for (Collection<PBXObject> collection : objects.values())
                for (PBXObject object : collection)
                    obj.put(object.id, object.getData());
            base.put("objects", NSObject.wrap(obj));
            PropertyListParser.saveAsASCII(base, out);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public Collection<PBXObject> removeType(String type) {
        return objects.remove(type);
    }

    public void addType(String type, Collection<PBXObject> collection) {
        objects.put(type, collection);
    }

    public Collection<PBXObject> getType(String type) {
        return objects.get(type);
    }

    public PBXObject getObjectWithID(String id) {
        PBXObject object = null;
        for (String type : objects.keySet())
            if ((object = getObjectWithID(id, type)) != null)
                break;
        return object;

    }

    public PBXObject getObjectWithID(String id, String type) {
        Collection<PBXObject> list = objects.get(type);
        if (list != null)
            for (PBXObject object : list)
                if (object.id.equals(id))
                    return object;
        return null;
    }

    public PBXObject getObjectWithCondition(String type, PBXObjectCondition condition) {
        Collection<PBXObject> list = objects.get(type);
        if (list != null)
            for (PBXObject object : list)
                if (condition.check(object))
                    return object;
        return null;
    }

    public <T extends PBXObject> Collection<T> getObjectsWithCondition(Class T, PBXObjectCondition condition) {
        List<T> out = new ArrayList<>();
        Collection<T> list = (Collection<T>) objects.get(T.getSimpleName());
        if (list != null)
            for (T object : list)
                if (condition.check(object))
                    out.add(object);
        return out;
    }

    public void removeObjectWithCondition(String type, PBXObjectCondition condition) {
        Collection<PBXObject> list = objects.get(type);
        if (list == null)
            return;
        list.removeIf(condition::check);
    }

    public void removeObject(String type, PBXObject object) {
        Collection<PBXObject> list = objects.get(type);
        if (list == null)
            return;
        list.remove(object);
    }

    public void addObject(PBXObject object) {
        Collection<PBXObject> list = objects.get(object.isa);
        if (list == null)
            objects.put(object.isa, list = new ArrayList<>());
        list.add(object);
    }

    private BigInteger lastUsedID() {
        BigInteger id = BigInteger.ZERO;
        BigInteger temp;
        for (Collection<PBXObject> collection : objects.values())
            for (PBXObject object : collection)
                if ((temp = new BigInteger(object.id, 16)).compareTo(id) > 0)
                    id = temp;
        return id;
    }

    public String getNextID() {
        if (currentId == null)
            currentId = lastUsedID();
        currentId = currentId.add(BigInteger.ONE);
        return currentId.toString(16).toUpperCase();
    }

}
