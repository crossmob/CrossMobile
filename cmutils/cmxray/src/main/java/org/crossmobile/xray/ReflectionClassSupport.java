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
package org.crossmobile.xray;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

import static java.awt.font.TextAttribute.*;

class ReflectionClassSupport {

    private final ClassLoader cl;
    Class<?> uiapplication;
    Class<?> uiview;
    Class<?> uicontrol;
    Class<?> uibutton;
    Class<?> uislider;
    Class<?> uilabel;
    Class<?> uiscrollview;
    Class<?> uitableview;
    Class<?> cgrect;
    Class<?> cgsize;
    Class<?> cgpoint;
    Class<?> cgcolor;
    Class<?> uicolor;
    Class<?> uifont;
    Class<?> uiedgeinsets;
    Class<?> nsselector;
    Class<?> nsnotification;
    Class<?> nsnotificationcenter;

    Class<? extends Annotation> getterAnn;
    Class<? extends Annotation> setterAnn;

    private Constructor<?> cgrect_c;
    private Constructor<?> cgsize_c;
    private Constructor<?> cgpoint_c;
    private Constructor<?> uiedgeinsets_c;

    private Method origin_cgrect;
    private Method size_cgrect;
    private Method x_cgpoint;
    private Method y_cgpoint;
    private Method width_cgsize;
    private Method height_cgsize;
    private Method top_insets;
    private Method left_insets;
    private Method bottom_insets;
    private Method right_insets;

    private Method color_c;
    private Method cgcolor_uicolor;
    private Method getcomponents_cgcolor;
    Method object_nsnotification;

    private Method font_sys_c;
    private Method font_sys_bold_c;
    private Method font_sys_italic_c;
    private Method font_named_c;
    private Method font_family_name;
    private Method font_name;
    private Method font_size;
    String system_font_name2;


    @SuppressWarnings("unchecked")
    ReflectionClassSupport(ClassLoader cl) {
        this.cl = cl;
        try {
            getterAnn = (Class<? extends Annotation>) cl.loadClass("org.crossmobile.bridge.ann.CMGetter");
            setterAnn = (Class<? extends Annotation>) cl.loadClass("org.crossmobile.bridge.ann.CMSetter");
            uiapplication = cl.loadClass("crossmobile.ios.uikit.UIApplication");
            uiview = cl.loadClass("crossmobile.ios.uikit.UIView");
            uicontrol = cl.loadClass("crossmobile.ios.uikit.UIControl");
            uibutton = cl.loadClass("crossmobile.ios.uikit.UIButton");
            uislider = cl.loadClass("crossmobile.ios.uikit.UISlider");
            uiscrollview = cl.loadClass("crossmobile.ios.uikit.UIScrollView");
            uitableview = cl.loadClass("crossmobile.ios.uikit.UITableView");
            uilabel = cl.loadClass("crossmobile.ios.uikit.UILabel");
            uicolor = cl.loadClass("crossmobile.ios.uikit.UIColor");
            uifont = cl.loadClass("crossmobile.ios.uikit.UIFont");
            cgcolor = cl.loadClass("crossmobile.ios.coregraphics.CGColor");

            cgrect = cl.loadClass("crossmobile.ios.coregraphics.CGRect");
            cgsize = cl.loadClass("crossmobile.ios.coregraphics.CGSize");
            cgpoint = cl.loadClass("crossmobile.ios.coregraphics.CGPoint");
            uiedgeinsets = cl.loadClass("crossmobile.ios.uikit.UIEdgeInsets");
            nsselector = cl.loadClass("crossmobile.ios.foundation.NSSelector");
            nsnotification = cl.loadClass("crossmobile.ios.foundation.NSNotification");
            nsnotificationcenter = cl.loadClass("crossmobile.ios.foundation.NSNotificationCenter");

            origin_cgrect = cgrect.getMethod("getOrigin");
            size_cgrect = cgrect.getMethod("getSize");
            x_cgpoint = cgpoint.getMethod("getX");
            y_cgpoint = cgpoint.getMethod("getY");
            width_cgsize = cgsize.getMethod("getWidth");
            height_cgsize = cgsize.getMethod("getHeight");
            top_insets = uiedgeinsets.getMethod("getTop");
            left_insets = uiedgeinsets.getMethod("getLeft");
            bottom_insets = uiedgeinsets.getMethod("getBottom");
            right_insets = uiedgeinsets.getMethod("getRight");

            cgrect_c = cgrect.getConstructor(double.class, double.class, double.class, double.class);
            cgsize_c = cgsize.getConstructor(double.class, double.class);
            cgpoint_c = cgpoint.getConstructor(double.class, double.class);
            uiedgeinsets_c = uiedgeinsets.getConstructor(double.class, double.class, double.class, double.class);

            color_c = uicolor.getMethod("colorWithRedGreenBlueAlpha", double.class, double.class, double.class, double.class);
            cgcolor_uicolor = uicolor.getMethod("CGColor");
            getcomponents_cgcolor = cgcolor.getMethod("getComponents");
            object_nsnotification = nsnotification.getMethod("object");

            font_sys_c = uifont.getMethod("systemFontOfSize", double.class);
            font_sys_bold_c = uifont.getMethod("boldSystemFontOfSize", double.class);
            font_sys_italic_c = uifont.getMethod("italicSystemFontOfSize", double.class);
            font_named_c = uifont.getMethod("fontWithName", String.class, double.class);
            font_family_name = uifont.getMethod("familyName");
            font_name = uifont.getMethod("fontName");
            font_size = uifont.getMethod("pointSize");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    ClassLoader getClassLoader() {
        return cl;
    }

    Object constructCGRect(double x, double y, double width, double height) {
        try {
            return cgrect_c.newInstance(x, y, width, height);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Double invokeDouble(Method method, Object origin) throws InvocationTargetException, IllegalAccessException {
        return (Double) method.invoke(origin);
    }

    Double[] deconstructCGRect(Object rect) {
        try {
            Object origin = origin_cgrect.invoke(rect);
            Object size = size_cgrect.invoke(rect);
            return new Double[]{invokeDouble(x_cgpoint, origin), invokeDouble(y_cgpoint, origin), invokeDouble(width_cgsize, size), invokeDouble(height_cgsize, size)};
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }


    Object constructCGSize(double width, double height) {
        try {
            return cgsize_c.newInstance(width, height);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Double[] deconstructCGSize(Object size) {
        try {
            return new Double[]{invokeDouble(width_cgsize, size), invokeDouble(height_cgsize, size)};
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Object constructCGPoint(double x, double y) {
        try {
            return cgpoint_c.newInstance(x, y);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Double[] deconstructCGPoint(Object point) {
        try {
            return new Double[]{invokeDouble(x_cgpoint, point), invokeDouble(x_cgpoint, point)};
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Object constructInsets(double top, double left, double bottom, double right) {
        try {
            return uiedgeinsets_c.newInstance(top, left, bottom, right);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Double[] deconstructInsets(Object insets) {
        try {
            return new Double[]{invokeDouble(top_insets, insets), invokeDouble(left_insets, insets), invokeDouble(bottom_insets, insets), invokeDouble(right_insets, insets)};
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Object constructColor(Color color) {
        try {
            return color_c.invoke(null, color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Color deconstructColor(Object col) {
        try {
            Object cgcolor = col == null ? null : cgcolor_uicolor.invoke(col);
            if (cgcolor == null) cgcolor = cgcolor_uicolor.invoke(color_c.invoke(null, 0d, 0d, 0d, 0d));
            double[] c = (double[]) getcomponents_cgcolor.invoke(cgcolor);
            return new Color((float)c[0], (float)c[1], (float)c[2], (float)c[3]);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    Object constructFont(Font font) {
        try {
            if (font.getFamily().equals(systemFontName())) {
                if (font.isBold() && font.isItalic()) {
                } else if (font.isBold()) {
                    return font_sys_bold_c.invoke(null, font.getSize());
                } else if (font.isItalic()) {
                    return font_sys_italic_c.invoke(null, font.getSize());
                } else {
                    return font_sys_c.invoke(null, font.getSize());
                }
            }
            return font_named_c.invoke(null, font.getFamily() + (font.isBold() ? " Bold" : "") + (font.isItalic() ? " Italic" : ""), font.getSize());
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    String systemFontName() {
        if (system_font_name2 == null) {
            try {
                system_font_name2 = (String) font_family_name.invoke(font_sys_c.invoke(null, 12f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return system_font_name2;
    }

    Font deconstructFont(Object ofont) {
        try {
            String name = (String) font_name.invoke(ofont);
            boolean bold = false;
            boolean italic = false;
            StringBuilder familyName = new StringBuilder();
            for (String part : name.split(" ")) {
                String lower = part.toLowerCase();
                if (lower.equals("bolditalic") || lower.equals("italicbold")) {
                    bold = true;
                    italic = true;
                    continue;
                }
                if (!bold & lower.equals("bold")) {
                    bold = true;
                    continue;
                }
                if (!italic && lower.equals("italic")) {
                    italic = true;
                    continue;
                }
                if (!part.isEmpty())
                    familyName.append(' ').append(part);
            }
            Map<AttributedCharacterIterator.Attribute, Object> attributes = new HashMap<>();
            attributes.put(FAMILY, familyName.toString().trim());
            attributes.put(WEIGHT, bold ? WEIGHT_BOLD : WEIGHT_REGULAR);
            attributes.put(POSTURE, italic ? POSTURE_OBLIQUE : POSTURE_REGULAR);
            attributes.put(SIZE, font_size.invoke(ofont));
            return new Font(attributes);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
