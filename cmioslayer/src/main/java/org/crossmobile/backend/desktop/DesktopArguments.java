/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.backend.desktop;

import java.io.PrintStream;

import static org.crossmobile.bridge.LifecycleBridge.UNKNOWN_NAME;

public class DesktopArguments {

    private static final String emphOn;
    private static final String emphOff;
    //
    private double scale = 1;
    private String skin = null;

    static {
        if (OperatingSystem.current == OperatingSystem.Windows)
            emphOn = emphOff = "";
        else {
            emphOn = "\033[0m\033[4m";
            emphOff = "\033[0m";
        }
    }

    public void parse(String[] args) {
        skin = Chassis.Default.getName();
        if (args == null || args.length == 0)
            return;
        for (String s : args) {
            s = s.toLowerCase().trim();
            if (s.startsWith("--scale="))
                try {
                    s = s.substring("--scale=".length());
                    scale = Double.parseDouble(s);
                    if (scale < 0.5) {
                        scale = 0.5;
                        System.out.println("Set to minimum supported scale: 0.5");
                    } else if (scale > 2) {
                        scale = 2;
                        System.out.println("Set to maximum supported scale: 2");
                    }
                } catch (Exception ex) {
                    System.err.println("Unable to parse scaling factor '" + s + "'");
                    ex.printStackTrace(new PrintStream(System.err));
                    System.exit(1);
                }
            else if (s.startsWith("--skin=")) {
                skin = s.substring("--skin=".length()).trim();
                if (skin.equals("help") || skin.equals("?")) {
                    System.out.print(""
                            + emphOff + emphOn + System.getProperty("cm.display.name", UNKNOWN_NAME) + emphOff + " : a CrossMobile application\n"
                            + "\n"
                            + "List of supported skins.\n"
                            + "These skins can be activated with the --skin=NAME command.\n"
                            + "\n");
                    for (Chassis ch : Chassis.getSkins(null)) {
                        System.out.println("  " + ch.getName() + ": " + ch.getInfo());
                        System.out.println("      " + ch.getDescr());
                    }
                    System.exit(0);
                }
            } else if (s.equals("--help")) {
                System.out.println(""
                        + emphOff + emphOn + System.getProperty("cm.display.name", UNKNOWN_NAME) + emphOff + " : a CrossMobile application\n"
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
                        + "  --help : This message\n");
                System.exit(0);
            } else {
                System.err.println("Unknown parameter: " + args[0]);
                System.exit(-1);
            }
        }
    }

    public double getScale(int idiom) {
        return scale;
    }

    public String getSkin() {
        return skin == null || skin.equals("") ? Chassis.Default.getName() : skin;
    }
}
