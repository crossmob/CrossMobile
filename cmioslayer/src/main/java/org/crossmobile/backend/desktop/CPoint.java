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
package org.crossmobile.backend.desktop;

import org.xml.sax.Attributes;

import java.util.concurrent.atomic.AtomicReference;

public class CPoint {

    private final Number X, Y;
    private final AtomicReference<Anchor> anchorX = new AtomicReference<>();
    private final AtomicReference<Anchor> anchorY = new AtomicReference<>();
    private int cx = 0, cy = 0;

    public CPoint(Attributes attributes) throws CPointException {
        X = Anchor.seek(attributes, "x", anchorX);
        Y = Anchor.seek(attributes, "y", anchorY);
    }

    int x() {
        return cx;
    }

    int y() {
        return cy;
    }

    void updateWidth(int widgetWidth, int widgetHeight, int screenWidth, int screenHeight) {
        cx = anchorX.get().get(X, widgetWidth, screenWidth);
        cy = anchorY.get().get(Y, widgetHeight, screenHeight);
    }

    public static final class CPointException extends Exception {

        public final String tag;
        public final String reason;

        public CPointException(String tag, String reason) {
            super();
            this.tag = tag;
            this.reason = reason;
        }
    }

    private static enum Anchor {
        START {
            @Override
            int get(Number n, int widget, int screen) {
                return n.intValue();
            }

            @Override
            Number convert(String n, String axis) throws CPointException {
                try {
                    return Integer.parseInt(n);
                } catch (NumberFormatException ex) {
                    throw new CPointException(axis, "Value '" + n + "' is not a number");
                }
            }

        }, END {
            @Override
            int get(Number n, int widget, int screen) {
                return screen + n.intValue();
            }

            @Override
            Number convert(String n, String axis) throws CPointException {
                try {
                    return Integer.parseInt(n);
                } catch (NumberFormatException ex) {
                    throw new CPointException(axis, "Value '" + n + "' is not a number");
                }
            }

        }, PERCENT {
            @Override
            int get(Number n, int widget, int screen) {
                return (int) (n.doubleValue() * screen - widget / 2d);
            }

            @Override
            Number convert(String n, String axis) throws CPointException {
                Number num;
                try {
                    num = Double.parseDouble(n.substring(0, n.length() - 1)) / 100d;
                } catch (NumberFormatException ex) {
                    throw new CPointException(axis, "Value '" + n + "' is not a number");
                }
                if (num.doubleValue() < 0)
                    throw new CPointException(axis, "Relative location should be bigger or equal to 0%, was " + n);
                if (num.doubleValue() > 1)
                    throw new CPointException(axis, "Relative location should be less or equal to 100%, was " + n);
                return num;
            }
        };

        private static Number seek(Attributes attributes, String axis, AtomicReference<Anchor> anchor) throws CPointException {
            String val = attributes.getValue(axis);
            if (val == null)
                throw new CPointException(axis, "Unable to find attribute");
            val = val.trim();
            if (val.endsWith("%"))
                anchor.set(PERCENT);
            else if (Integer.parseInt(val) >= 0)
                anchor.set(START);
            else
                anchor.set(END);
            return anchor.get().convert(val, axis);
        }

        abstract int get(Number n, int widget, int screen);

        abstract Number convert(String num, String axis) throws CPointException;
    }
}
