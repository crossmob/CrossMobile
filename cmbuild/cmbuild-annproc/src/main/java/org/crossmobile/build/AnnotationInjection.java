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
package org.crossmobile.build;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

import static org.crossmobile.build.AnnotationConfig.*;

public final class AnnotationInjection {

    static final String METHOD = "method";
    static final String CODE = "code";

    public final Collection<String> actions = new ArrayList<>();
    public final Map<String, String> outlets = new HashMap<>();
    public final static Map<String, Collection<String>> generatedOutlets = new HashMap<>();
    public final Map<String, Map<String, String>> nativemethods = new HashMap<>();
    public boolean inMainTarget;
    public boolean principalClass;
    public String otherTargets;

    public AnnotationInjection(boolean dummy) { // really?????? - why should be like this?
    }

    // Why this? Because it seems that library calls are not very friendly with compile-time code (i.e. no JSON could be used)
    public final void serializeForXcode(Writer out) throws IOException {
        for (String action : actions)
            out.append(ACTION).append(SEP).append(esc(action)).append(END);
        for (String outletKey : outlets.keySet()) {
            String convType = outlets.get(outletKey).replace('.', '_');
            out.append(OUTLET).append(SEP).append(esc(outletKey + "_" + convType)).append(SEP).append(esc(convType)).append(END);
        }
        for (String nativeMethodKey : nativemethods.keySet()) {
            Map<String, String> nativeMethod = nativemethods.get(nativeMethodKey);
            out.append(NATIVE).append(SEP).append(esc(nativeMethodKey)).append(SEP).append(esc(nativeMethod.get(METHOD))).append(SEP).append(esc(nativeMethod.get(CODE))).append(END);
        }
        if (otherTargets != null)
            out.append(TARGET).append(SEP).
                    append(inMainTarget ? "true" : "false").append(SEP).
                    append(principalClass ? "true" : "false").append(SEP).
                    append(otherTargets).append(END);
        out.flush();
        out.close();
    }

    public final void serializeAsSource(String parentClassName, String parentFlatname, Writer out) throws IOException {
        out.append("package org.crossmobile.sys;\n\nimport crossmobile.ios.uikit.*;\n\npublic class " + parentFlatname + "__ {\n");
        for (String outletKey : outlets.keySet()) {
            String outletType = outlets.get(outletKey);
            if (generatedOutlets.containsKey(parentFlatname))
                generatedOutlets.get(parentFlatname).remove(outletKey + "_field");
            out.append("\n    public static void ").append(outletKey + "_field").append("(").
                    append(parentClassName).append(' ').append("parent, ").append(outletType).append(" outlet){\n").
                    append("        parent.").append(outletKey).append(" = outlet;\n").
                    append("    }\n");
        }
        out.append("}\n");
        out.flush();
        out.close();
    }

    private String capitalizeFirst(String str) {
        return str.toUpperCase().charAt(0) + str.substring(1);
    }


    public static final String esc(String input) {
        return input.
                replaceAll("\\\\", "\\\\\\\\").
                replaceAll("\n", "\\\\n").
                replaceAll("\t", "\\\\t");
    }

    public boolean hasOutlets() {
        return !outlets.isEmpty();
    }
}
