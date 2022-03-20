/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import org.crossmobile.backend.desktop.cgeo.Chassis;
import org.crossmobile.bind.system.Debug;

import java.io.PrintStream;

public class DesktopArguments {

    private static final String UNKNOWN_NAME = "Unknown";
    public static final String USER_ARG_SCALE = "user.arg.scale";
    public static final String USER_ARG_SKIN = "user.arg.skin";

    private static final String emphOn;
    private static final String emphOff;

    static {
        if (System.console() == null || System.getenv("TERM") == null)
            emphOn = emphOff = "";
        else {
            emphOn = "\033[0m\033[4m";
            emphOff = "\033[0m";
        }
    }

    public void parse(String[] args) {
        if (args == null || args.length == 0)
            return;
        String descr = System.getProperty("cm.description", "");
        if (descr.trim().isEmpty())
            descr = "A CrossMobile Application";
        String header = emphOff + emphOn + System.getProperty("cm.display.name", UNKNOWN_NAME) + emphOff + " : " + descr + "\n";
        for (String s : args) {
            s = s.toLowerCase().trim();
            if (s.startsWith("--scale="))
                try {
                    s = s.substring("--scale=".length());
                    double scale = Double.parseDouble(s);
                    if (scale < 0.01) {
                        scale = 0.01;
                        System.err.println("Set to minimum supported scale: " + scale);
                    } else if (scale > 100) {
                        scale = 100;
                        System.err.println("Set to maximum supported scale: " + scale);
                    }
                    System.getProperties().put(USER_ARG_SCALE, String.valueOf(scale));
                } catch (Exception ex) {
                    System.err.println("Unable to parse scaling factor '" + s + "'");
                    ex.printStackTrace(new PrintStream(System.err));
                    System.exit(1);
                }
            else if (s.startsWith("--skin=")) {
                String skin = s.substring("--skin=".length()).trim();
                if (skin.equals("help") || skin.equals("?")) {
                    System.out.print(""
                            + header
                            + "\n"
                            + "List of supported skins.\n"
                            + "These skins can be activated with the --skin=NAME command.\n");
                    for (Chassis ch : Chassis.getSkins()) {
                        System.out.println("  " + ch.getName() + ": " + ch.getInfo());
                        System.out.println("      " + ch.getDescr());
                    }
                    System.exit(0);
                } else if (!skin.trim().isEmpty())
                    System.getProperties().put(USER_ARG_SKIN, skin);
            } else if (s.equals("--debug")) {
                Debug.Full_Debug = true;
            } else if (s.equals("--help")) {
                System.out.println(""
                        + header
                        + "\n"
                        + "Usage:\n"
                        + "  Skins and themes:\n"
                        + "  --skin=NAME     : The name of the skin to use.\n"
                        + "  --skin=[help|?] : Use this switch to see a list of supported skins\n"
                        + "\n"
                        + "  Scaling factor:\n"
                        + "  --scale=? : Interface scaling, a floating point number\n"
                        + "              Values should be between 0.5 and 2 (Retina)\n"
                        + "\n"
                        + "  Other options:\n"
                        + "  --debug : Full debug information\n"
                        + "  --help : This message\n");
                System.exit(0);
            } else {
                System.err.println("Unknown parameter: " + args[0]);
                System.exit(-1);
            }
        }
    }
}
