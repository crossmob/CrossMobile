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
package org.crossmobile.bind.system;

import crossmobile.ios.foundation.NSIndexPath;
import crossmobile.ios.uikit.UIPickerView;
import crossmobile.ios.uikit.UITableView;
import crossmobile.rt.UnimplementedOptionalException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Optionals {

    public static final int UITable_titleForHeaderInSection = 0;
    public static final int UITable_titleForFooterInSection = 1;
    public static final int UITable_viewForHeaderInSection = 2;
    public static final int UITable_viewForFooterInSection = 3;
    public static final int UITable_heightForHeaderInSection = 4;
    public static final int UITable_heightForFooterInSection = 5;
    public static final int UITable_heightForRowAtIndexPath = 6;
    public static final int UIPicker_useDelegateForWidth = 7;

    private static final String[] interface_name = {
            "titleForHeaderInSection",
            "titleForFooterInSection",
            "viewForHeaderInSection",
            "viewForFooterInSection",
            "heightForHeaderInSection",
            "heightForFooterInSection",
            "heightForRowAtIndexPath",
            "widthForComponent"
    };
    private static final Class[][] interface_definitions = {
            {UITableView.class, int.class},
            {UITableView.class, int.class},
            {UITableView.class, int.class},
            {UITableView.class, int.class},
            {UITableView.class, int.class},
            {UITableView.class, int.class},
            {UITableView.class, NSIndexPath.class},
            {UIPickerView.class, int.class}
    };
    private static final Object[][] interface_parameters = {
            {null, 0},
            {null, 0},
            {null, 0},
            {null, 0},
            {null, 0},
            {null, 0},
            {null, NSIndexPath.indexPathForRow(0, 0)},
            {null, 0}
    };

    private static final int COUNT;
    private static final boolean supportsOptional = Double.parseDouble(System.getProperty("java.class.version", "0")) > 51.5; // 52.0 is the first version that supports optional methods, thus check just below 52.0 and just above 51.0
    private static final Map<Class, boolean[]> optionals = new HashMap<Class, boolean[]>();

    static {
        COUNT = interface_name.length;
        if (interface_name.length != interface_definitions.length)
            throw new ArrayIndexOutOfBoundsException("Definitions (" + interface_definitions.length + ") do not match names (" + interface_name.length + ")");
        if (interface_name.length != interface_parameters.length)
            throw new ArrayIndexOutOfBoundsException("Parameters (" + interface_parameters.length + ") do not match names (" + interface_name.length + ")");
    }

    public static boolean supports(Object target, int optional) {
        if (target == null || optional < 0 || optional >= COUNT)
            return false;
        Class pclass = target.getClass();
        boolean[] values = optionals.get(pclass);
        if (values == null) {
            values = new boolean[COUNT];
            for (int idx = 0; idx < COUNT; idx++)
                if (supportsOptional) {
                    Class c = pclass;
                    while (c != null)
                        try {
                            c.getDeclaredMethod(interface_name[idx], interface_definitions[idx]);
                            values[idx] = true;     // The concrete method exists - it's not a default method
                            break;
                        } catch (Exception ex) {
                            c = c.getSuperclass();
                        }
                } else
                    try {
                        Method method = pclass.getMethod(interface_name[idx], interface_definitions[idx]);
                        try {
                            method.invoke(target, interface_parameters[idx]);
                            values[idx] = true;     // The method exists
                        } catch (IllegalAccessException ex) {
                        } catch (IllegalArgumentException ex) {
                        } // Here is the interesting part: if UnimplementedOptionalException is thrown, then the method is not implemented 
                        catch (InvocationTargetException ex) {
                            if (ex.getCause() == null || !(ex.getCause() instanceof UnimplementedOptionalException))
                                values[idx] = true;
                        } catch (UnimplementedOptionalException ex) {
                        } catch (Throwable th) {    // We don't care for other internal exceptions - the method exists
                            values[idx] = true;
                        }
                    } catch (NoSuchMethodException ex) {
                    } catch (SecurityException ex) {
                    }
            optionals.put(pclass, values);
        }
        return values[optional];
    }
}
