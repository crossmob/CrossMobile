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

import org.crossmobile.gui.ProjectFrame;
import org.crossmobile.gui.actives.ActiveButton;
import org.crossmobile.gui.elements.DebugInfo;
import org.crossmobile.utils.Log;
import proguard.retrace.ReTrace;

import java.io.*;

public class Deguard {

    public static MagicWand getWandButton(ProjectFrame frame) {
        MagicWand res = new MagicWand();
        res.setText("Deobfuscate");
        res.setIcon("images/magicwand");
        res.addActionListener(l -> {
            DebugInfo debugInfo = frame.getDebugInfo();
            frame.updateTo(deGuardString(res.mapFile, debugInfo.output), deGuardString(res.mapFile, debugInfo.error));
        });
        return res;
    }

    private static String deGuardString(File map, String input) {
        if (!map.exists())
            return input;
        ReTrace retrace = new ReTrace(ReTrace.STACK_TRACE_EXPRESSION, false, map);
        StringWriter out = new StringWriter(input.length());
        try (LineNumberReader lnr = new LineNumberReader(new StringReader(input)); PrintWriter pw = new PrintWriter(out)) {
            retrace.retrace(lnr, pw);
        } catch (IOException e) {
            Log.error("Unable to retrace using map " + map.getName());
            return input;
        }
        input = out.toString().replaceAll("\r\n", "\n");
        return input;
    }

    public static class MagicWand extends ActiveButton {

        private File mapFile;

        public void setMapFile(File file) {
            mapFile = file;
        }
    }
}
