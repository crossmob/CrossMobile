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
 * You should have received attr copy of the GNU General Public License
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Values;
import org.crossmobile.utils.Log;

import java.io.*;

import static org.crossmobile.build.AnnotationConfig.*;

public class Outlet extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("property", Values.String);
        addSupportedAttribute("destination", Values.String);
    }

    @Override
    public String toCode() {
        return "";
    }

    @Override
    public void performChecks() {
        String property = attrName("property");
        if (property == null || property.isEmpty())
            return;
        if (!property.endsWith("_field") && !property.equals("delegate") && !property.equals("dataSource"))
            Log.error("IBOutlet named " + attr("property") + " with destination " + attr("destination") + " with id " + attr("id") + " does not follow the CrossMobile's naming convention.");
    }

    public String getOutlet(String variableName, String variableType) {
        String property = attrName("property");
        String destination = Objects.GETTER + variableFromID(attrName("destination")) + "()";
        if (property == null || property.isEmpty())
            return "";
        if (property.equals("delegate") || property.equals("dataSource"))
            return I4 + variableName + ".set" + capitalize(property) + "(" + destination + ");" + NEWLINE;
        variableType = variableType.replace('.', '_');
        writeOUT(variableType, property);
        return I4 + OUTLET_PGK + "." + variableType + "__." + property + "(" + variableName + ", " + destination + ");" + NEWLINE;
    }

    private void writeOUT(String variableType, String property) {
        try {
            Writer out = new OutputStreamWriter(new FileOutputStream(new File(getMeta().getAnnotationLocation(), variableType + GENERATED_EXT), true));
            out.append(OUTLET).append(SEP).append(property).append(END);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
