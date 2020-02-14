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

import com.google.common.collect.ArrayListMultimap;
import org.crossmobile.bridge.ann.CMLibParam;
import org.crossmobile.build.ib.AnnotationHelpers;
import org.crossmobile.build.ng.CMBuildEnvironment;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.XcodeTarget;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

import static org.crossmobile.build.ib.AnnotationHelpers.getAnnotations;
import static org.crossmobile.utils.ReflectionUtils.getTopLevelClass;

public class XcodeTargetRegistry {
    private static Map<String, Collection<XcodeTarget>> targetsOfClass = new HashMap<>();
    private static Map<XcodeTarget, Collection<Pattern>> targetsOfMaterials = new LinkedHashMap<>();
    private static Map<String, XcodeTarget> targets = new HashMap<>();

    static {
        addTarget(XcodeTarget.Main);
    }

    public static void register(String file, boolean alsoInMain, boolean principalClass, String[] targets) {
        Collection<XcodeTarget> destTargets = new HashSet<>();
        List<String> targetList = new ArrayList<>(Arrays.asList(targets));
        if (alsoInMain)
            targetList.add("");
        for (String target : targetList) {
            XcodeTarget xcodeTarget = XcodeTargetRegistry.targets.get(target);
            if (xcodeTarget == null)
                Log.error("Destination target " + target + " could not be found. Please declare it first in the appropriate plugin.");
            else {
                destTargets.add(xcodeTarget);
                if (principalClass && !xcodeTarget.isMain())
                    if (!xcodeTarget.setPrincipalClass(file))
                        Log.error("Principal class of target " + target + " already set, older value `" + xcodeTarget.getPrincipalClass() + "`, dropped value `" + file + "`");
            }
        }
        targetsOfClass.put(file, destTargets);
    }

    public static boolean classBelongsToTarget(String className, XcodeTarget target) {
        if (className.equals("Dummy"))  // dummy Xcode file is present in all targets
            return true;
        Collection<XcodeTarget> foundFile = targetsOfClass.get(className);
        if (foundFile == null || foundFile.isEmpty())
            return target == XcodeTarget.Main;
        return foundFile.contains(target);
    }

    public static boolean materialBelongsToTarget(String materialName, XcodeTarget target) {
        Collection<Pattern> foundPattern = targetsOfMaterials.get(target);
        if (foundPattern == null)
            return target == XcodeTarget.Main;
        for (Pattern pattern : foundPattern)
            if (pattern.matcher(materialName).matches())
                return true;
        return false;
    }

    public static boolean hasExtraTargets() {
        return targets.size() > 1;
    }

    public static Iterable<XcodeTarget> getAllTargets() {
        return targets.values();
    }

    public static Iterable<XcodeTarget> getExtraTargets() {
        Collection<XcodeTarget> values = new ArrayList<>(targets.values());
        values.remove(XcodeTarget.Main);
        return values;
    }

    public static XcodeTarget getTarget(String name) {
        return targets.get(name);
    }

    public static boolean hasTarget(String name) {
        return targets.containsKey(name);
    }

    public static Map<String, AnnotationHelpers.CodeAnnotations> gatherTargets(CMBuildEnvironment env, File annotationsDir) {
        for (Param p : env.getParamset().runtime())
            if (p.context == CMLibParam.ParamContext.XcodeTarget) {
                String target = env.getProperties().getProperty(p.name);
                if (target != null && !target.trim().isEmpty()) {
                    if (target.toLowerCase().equals(env.getArtifactId().toLowerCase()))
                        throw new RuntimeException("Target module " + target + " can't have the same name as the application " + env.getArtifactId());
                    XcodeTarget newTarget = new XcodeTarget(target.trim());
                    newTarget.setMeta(p.meta);
                    if (addTarget(newTarget))
                        Log.error("Duplicate definition of target " + target);
                }
            }
        return getAnnotations(annotationsDir);
    }

    private static boolean addTarget(XcodeTarget target) {
        return targets.put(target.name, target) != null;
    }
}
