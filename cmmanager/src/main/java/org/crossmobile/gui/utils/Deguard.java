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
package org.crossmobile.gui.utils;

import org.crossmobile.Version;
import org.crossmobile.gui.ProjectFrame;
import org.crossmobile.gui.actives.ActiveButton;
import org.crossmobile.gui.elements.DebugInfo;
import org.crossmobile.utils.Log;
import proguard.retrace.ReTrace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deguard {
    private static final boolean supported;
    private static List<File> mapfiles = new ArrayList<>();

    static {
        File home = new File(System.getProperty("user.home"));
        File cmioslayer;
        if ((cmioslayer = new File(home, "crossmobile/resources/installers/mapping/cmioslayer-" + Version.VERSION + ".map")).exists()) {
            mapfiles.add(cmioslayer);
        } else if ((cmioslayer = new File(home, ".cm/resources/installers/mapping/cmioslayer-" + Version.VERSION + ".map")).exists()) {
            mapfiles.add(cmioslayer);
        } else if ((cmioslayer = new File(home, "Desktop/Projects/crossmobile/resources/installers/mapping/cmioslayer-" + Version.VERSION + ".map")).exists()) {
            mapfiles.add(cmioslayer);
        } else
            cmioslayer = null;

        supported = cmioslayer != null;
        if (supported) {
            File base = cmioslayer.getParentFile();
//            mapfiles.add(new File(base, "cmmanager-" + Version.VERSION + ".map"));
            mapfiles.add(new File(base, "cmbuild-maven-plugin-" + Version.VERSION + ".map"));
        }

    }

    public static ActiveButton getWandButton(ProjectFrame frame) {
        if (!supported)
            return null;
        ActiveButton res = new ActiveButton();
        res.setIcon("images/magicwand");
        res.addActionListener(l -> {
            DebugInfo debugInfo = frame.getDebugInfo();
            frame.updateTo(deGuardString(debugInfo.output), deGuardString(debugInfo.error));
        });
        return res;
    }

    private static String deGuardString(String input) {
        for (File map : mapfiles) {
            ReTrace retrace = new ReTrace(ReTrace.STACK_TRACE_EXPRESSION, false, map);
            StringWriter out = new StringWriter(input.length());
            try (LineNumberReader lnr = new LineNumberReader(new StringReader(input)); PrintWriter pw = new PrintWriter(out)) {
                retrace.retrace(lnr, pw);
            } catch (IOException e) {
                Log.error("Unable to retrace using map " + map.getName());
                continue;
            }
            input = out.toString().replaceAll("\r\n", "\n");
        }
        return input;
    }
}
