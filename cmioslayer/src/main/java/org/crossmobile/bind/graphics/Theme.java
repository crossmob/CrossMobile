/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIColor;
import org.crossmobile.bind.graphics.theme.ThemeManager;
import org.crossmobile.bind.graphics.theme.ThemeUtilities;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.uicolor;
import static java.lang.Integer.getInteger;
import static java.lang.Long.getLong;
import static org.crossmobile.bind.system.SystemUtilities.*;

public class Theme {

    public final static class Images {

        public final static String DELETE_PRESSED = "delete_pressed";
        public final static String DELETE_RELEASED = "delete_released";
        public final static String INSERT_PRESSED = "insert_pressed";
        public final static String INSERT_RELEASED = "insert_released";
        public final static String THUMB_OVER = "thumb_over";
        public final static String ROUNDRECT_PRESSED = "roundrect_pressed";
        public final static String ROUNDRECT_RELEASED = "roundrect_released";
        public final static String SEARCH = "search";
        public final static String[] REC_BRIGHT = {"crossmobile_recm_bright", "crossmobile_rec0_bright", "crossmobile_rec1_bright", "crossmobile_rec2_bright", "crossmobile_rec3_bright", "crossmobile_rec4_bright", "crossmobile_rec5_bright"};
        public final static String[] REC_DARK = {"crossmobile_recm_dark", "crossmobile_rec0_dark", "crossmobile_rec1_dark", "crossmobile_rec2_dark", "crossmobile_rec3_dark", "crossmobile_rec4_dark", "crossmobile_rec5_dark"};
        public final static String[] WIFI1_BRIGHT = {"crossmobile_wifi1_bright", "crossmobile_wifi2_bright", "crossmobile_wifi3_bright"};
        public final static String[] WIFI1_DARK = {"crossmobile_wifi1_dark", "crossmobile_wifi2_dark", "crossmobile_wifi3_dark"};

        private Images() {
        }
    }

    public final static class Font {

        public static final String BACKCHAR = System.getProperty("cm.theme.font.backchar", "\u276E");

        private Font() {
        }
    }

    public final static class Color {

        public final static UIColor TINT = uicolor((int) ((long) getLong("cm.theme.color.tint", 0xFF2676D6)));
        public final static UIColor FORE = uicolor((int) ((long) getLong("cm.theme.color.fore", 0xFF000000)));
        public final static UIColor SHADOW = uicolor((int) ((long) getLong("cm.theme.color.shadow", 0xFFA0A0A0)));
        public final static UIColor TOOLBACK = uicolor((int) ((long) getLong("cm.theme.color.toolback", 0xFFB7B7B7)));
        public final static UIColor BARBACK = uicolor((int) ((long) getLong("cm.theme.color.barback", ThemeUtilities.getDuller(color(Theme.Color.TINT.CGColor())))));
        public final static UIColor SEPARATOR = uicolor((int) ((long) getLong("cm.theme.color.separator", 0xFFAAAAAA)));

        public final static double[] BARGRADIENTSTOPS = new double[]{0.0, 0.3, 1.0};

        public static int[] getBarGradientColors(UIColor baseColor) {
            if (Bar.FLAT)
                return null;
            ThemeManager themeManager = Native.graphics().themeManager();
            int base = color(baseColor.CGColor());
            int[] result = new int[3];
            result[0] = ThemeUtilities.getBrighter(base);
            result[1] = base;
            result[2] = ThemeUtilities.getDuller(base);
            return result;
        }

        private Color() {
        }
    }

    public final static class Bar {

        private Bar() {
        }

        private final static boolean FLAT = propertyToBoolean("cm.theme.bar.flat", false);

        public final static UIColor FORE = uicolor((int) ((long) getLong("cm.theme.bar.fore", 0xFFFFFFFF)));
        public final static UIColor SHADOW = uicolor((int) ((long) getLong("cm.theme.bar.shadow", 0xFF808080)));
        public static final int FONTSIZE = getInteger("cm.theme.bar.fontsize", 17);
        public static final boolean ISTRANSLUCENT = propertyToDouble("cm.theme.bar.translucency", -1) >= 0;
        public static final double TRANSLUCENCY = propertyToDouble("cm.theme.bar.translucency", 0.88);

        public final static class Tool {

            public static final int EDGEOFFSET = getInteger("cm.theme.bar.tool.edge.offset", 4);
            public static final int BETWEENOFFSET = getInteger("cm.theme.bar.tool.distance", 4);
            public static final int HEIGHTOFFSET = getInteger("cm.theme.bar.tool.height.offset", 6);
            public static final int DEFAULTHEIGHT = getInteger("cm.theme.bar.tool.height.default", 44);

            private Tool() {
            }
        }

        public final static class Nav {

            public static final int EDGEOFFSET = getInteger("cm.theme.bar.nav.edge.offset", 8);
            public static final int HEIGHTOFFSET = getInteger("cm.theme.bar.nav.height.offset", 6);
            public static final int HEIGHTNORMAL = getInteger("cm.theme.bar.nav.height.normal", 44);
            public static final boolean ISSHADOWED = propertyToCGSize("cm.theme.bar.nav.shadow.offset", null) != null;
            public static final CGSize SHADOWOFFSET = ISSHADOWED ? propertyToCGSize("cm.theme.bar.nav.shadow.offset", null) : null;
            public static final int TITLEOFFSET = getInteger("cm.theme.bar.nav.title.offset", 4);

            private Nav() {
            }
        }

        public final static class Tab {

            public static final int DEFAULTHEIGHT = getInteger("cm.theme.bar.tab.height.default", 49);

            private Tab() {
            }
        }
    }


    public final static class Button {

        public final static boolean IS_BACKGROUND_ADJUSTED = propertyToBoolean("cm.theme.button.background.adjusted", true);
        public final static boolean IS_TINT_INHERITED = propertyToBoolean("cm.theme.button.tint.inherited", true);
        public final static boolean IS_SYSTEM = propertyToBoolean("cm.theme.button.system", true);
        public final static double HIGHLIGHT_TEXT_FADE = 0.3;

        private Button() {
        }
    }

    public final static class Cell {

        public final static UIColor SELECTED_BLUE = uicolor((int) ((long) getLong("cm.theme.cell.selected_blue", 0xFF3F7FE5)));
        public final static UIColor SELECTED_GRAY = uicolor((int) ((long) getLong("cm.theme.cell.selected_grey", 0xFFD0D0D0)));
        public final static UIColor HEADERBACK = uicolor((int) ((long) getLong("cm.theme.cell.headerback", 0xFFF5F5F5)));
        public final static UIColor HEADERTEXT = uicolor((int) ((long) getLong("cm.theme.cell.headertext", 0xFFEDEDE5)));
        public final static int EDIT_SIZE = getInteger("cm.theme.cell.edit.size", 25);
        public final static int ACCESSORY_SIZE = getInteger("cm.theme.cell.accessory.size", 22);
        public final static int IMAGE_SIZE = getInteger("cm.theme.cell.image.size", 30);
        public final static int INSET_LEFT = getInteger("cm.theme.cell.inset.left", 10);
        public final static int INSET_RIGHT_EDGE = getInteger("cm.theme.cell.inset.right", 14);
        public final static int INSET_RIGHT_ACCESSORY_ACCESSORY = getInteger("cm.theme.cell.inset.right", 4);
        public final static int INSET_CONTENT = getInteger("cm.theme.cell.inset.right", 10);

        private Cell() {
        }
    }

    public final static class Debug {

        public final static UIColor STRIKE_COLOR = uicolor((int) ((long) getLong("cm.theme.debug.strike_color", 0xFFFF0000)));
        public final static UIColor FILL_COLOR = uicolor((int) ((long) getLong("cm.theme.debug.fill_color", 0x11990000)));
        public final static UIColor WINDOW_STRIKE_COLOR = uicolor((int) ((long) getLong("cm.theme.debug.window_strike_color", 0xFF0000FF)));
        public final static UIColor WINDOW_FILL_COLOR = uicolor((int) ((long) getLong("cm.theme.debug.window_fill_color", 0)));

        private Debug() {
        }

        /**
         * use UIView.getLayer().getStyle() to set the CGColor of the debug
         */
        public final static class StyleTags {

            public final static String FILL_COLOR_TAG = "DebugBodyColor";
            public final static String STRIKE_COLOR_TAG = "DebugBorderColor";

            private StyleTags() {
            }
        }
    }
}
