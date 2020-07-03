/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UIFont;
import org.crossmobile.bridge.Native;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UserInterfaceDrill.uicolor;
import static java.lang.Integer.getInteger;
import static java.lang.Long.getLong;
import static org.crossmobile.bind.system.SystemUtilities.*;

public class Theme {

    private static int getDuller(int base) {
        double[] hsv = Native.graphics().colorRGBAtoHSVA(base);
        hsv[1] *= 0.6;
        hsv[2] *= 0.8;
        return Native.graphics().colorHSBAtoRGBA(hsv[0], hsv[1], hsv[2], hsv[3]);
    }

    private static int getBrighter(int base) {
        double[] hsv = Native.graphics().colorRGBAtoHSVA(base);
        hsv[1] *= 0.6;
        hsv[2] *= 2;
        return Native.graphics().colorHSBAtoRGBA(hsv[0], hsv[1], hsv[2], hsv[3]);
    }

    public static boolean isDark(int base) {
        double red = ((base >> 16) & 0xff) / 255.0;
        double green = ((base >> 8) & 0xff) / 255.0;
        double blue = (base & 0xff) / 255.0;
        return Math.sqrt(red * red * 0.299 + green * green * 0.587 + blue * blue * 0.114) < 0.5;
    }

    public final static class Images {

        public final static String ACTIVITY_BLACK = "activity";
        public final static String ACTIVITY_WHITE = "activityw";
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

        public static final int BUTTONSIZE = getInteger("cm.theme.font.button.size", 18);
        public static final int SYSTEMBUTTONSIZE = getInteger("cm.theme.font.systembutton.size", 15);
        public static final int LABELSIZE = getInteger("cm.theme.font.label.size", 17);
        public static final int SYSTEMSIZE = getInteger("cm.theme.font.system.size", 14);
        public static final int SMALLSYSTEMSIZE = getInteger("cm.theme.font.smallsystem.size", 12);
        public static final String FONTNAME = System.getProperty("cm.theme.font.name", "Arial");
        public static final String BACKCHAR = System.getProperty("cm.theme.font.backchar", "\u276E");

        private Font() {
        }
    }

    public final static class Color {

        public final static UIColor TINT = uicolor((int) ((long) getLong("cm.theme.color.tint", 0xFF2676D6)));
        public final static UIColor FORE = uicolor((int) ((long) getLong("cm.theme.color.fore", 0xFF000000)));
        public final static UIColor SHADOW = uicolor((int) ((long) getLong("cm.theme.color.shadow", 0xFFA0A0A0)));
        public final static UIColor TOOLBACK = uicolor((int) ((long) getLong("cm.theme.color.toolback", 0xFFB7B7B7)));
        public final static UIColor BARBACK = uicolor((int) ((long) getLong("cm.theme.color.barback", getDuller(color(Theme.Color.TINT.CGColor())))));
        public final static UIColor THUMB = uicolor((int) ((long) getLong("cm.theme.color.thumb", 0xFFF0F0F0)));
        public final static UIColor SEPARATOR = uicolor((int) ((long) getLong("cm.theme.color.separator", 0xFFAAAAAA)));

        public final static double[] BARGRADIENTSTOPS = new double[]{0.0, 0.3, 1.0};

        public static int[] getBarGradientColors(UIColor baseColor) {
            if (Bar.FLAT)
                return null;
            int base = color(baseColor.CGColor());
            int[] result = new int[3];
            result[0] = getBrighter(base);
            result[1] = base;
            result[2] = getDuller(base);
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
        public static final int FONTSMALLSIZE = getInteger("cm.theme.bar.fontsmallsize", 13);
        public static final boolean ISTINTED = propertyToBoolean("cm.theme.bar.tinted", true);
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

    public final static class Label {

        public final static UIFont FONT = UIFont.systemFontOfSize(Font.LABELSIZE);

        private Label() {
        }
    }

    public final static class TextField {

        public final static UIFont FONT = UIFont.systemFontOfSize(Font.LABELSIZE);

        private TextField() {
        }
    }

    public final static class TextView {

        public final static UIFont FONT = UIFont.systemFontOfSize(Font.SMALLSYSTEMSIZE);

        private TextView() {
        }
    }

    public final static class Button {

        public final static UIFont SYSTEMTFONT = UIFont.systemFontOfSize(Font.SYSTEMBUTTONSIZE);
        public final static UIFont FONT = UIFont.systemFontOfSize(Font.BUTTONSIZE);
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

    public final static class ActivityIndicator {

        public final static int SLICES = getInteger("cm.theme.activityindicator.slices", 9);
        public final static int ALPHA_SAFE = getInteger("cm.theme.activityindicator.alpha.safe", 4);
        public final static double ANGLE = propertyToDouble("cm.theme.activityindicator.angle", 0.1);
        public final static double THICK = propertyToDouble("cm.theme.activityindicator.thick", 5);
        public final static double THIN = propertyToDouble("cm.theme.activityindicator.thin", 2);

        private ActivityIndicator() {
        }
    }

    public final static class Progress {

        public final static boolean ISSQUARED = propertyToBoolean("cm.theme.progress.squared", false);
        public final static int BAR_HEIGHT = getInteger("cm.theme.progress.bar.height", 10);
        public final static int DEFAULT_HEIGHT = getInteger("cm.theme.progress.height.default", 10);
        public final static boolean ISINVERSE = propertyToBoolean("cm.theme.progress.inverse", true);
        public final static boolean IS_BACK_DISABLED = propertyToBoolean("cm.theme.progress.back.disabled", false);

        private Progress() {
        }
    }

    public final static class Switch {

        public final static int WIDTH = getInteger("cm.theme.switch.width", 78);
        public final static int HEIGHT = getInteger("cm.theme.switch.height", 28);
        public final static int INSET = getInteger("cm.theme.switch.inset", 3);
        public final static boolean ISBORDERED = propertyToBoolean("cm.theme.switch.bordered", true);
        public final static boolean USE_THUMB_IMAGE = propertyToBoolean("cm.theme.switch.thumb", true);
        public final static int TRACK_WIDTH = WIDTH - INSET - INSET;
        public final static int THUMB_SIZE = HEIGHT - INSET - INSET;
        public final static int TRACK_MOVING_AREA = TRACK_WIDTH - THUMB_SIZE;

        private Switch() {
        }
    }

    public final static class Slider {

        public final static boolean ISSQUARED = propertyToBoolean("cm.theme.slider.squared", false);
        public final static boolean ISBORDERED = propertyToBoolean("cm.theme.slider.bordered", true);
        public final static int HEIGHT = getInteger("cm.theme.slider.height", 10);
        public final static int THUMB_SIZE = Switch.THUMB_SIZE;

        private Slider() {
        }
    }

    public final static class Scroll {

        public final static int INDICATOR_THICKNESS = getInteger("cm.theme.scroll.indicator.thickness", 8);
        public final static int INDICATOR_INSET = getInteger("cm.theme.scroll.indicator.inset", 2);
        public final static double SPRING_FACTOR = propertyToDouble("cm.theme.scroll.spring.factor", 0.5);

        private Scroll() {
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
